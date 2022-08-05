package com.test.accounts.controller;

import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.test.accounts.clients.CardsFeignClient;
import com.test.accounts.clients.LoansFeignClient;
import com.test.accounts.config.AccountsServiceConfig;
import com.test.accounts.model.*;
import com.test.accounts.repository.AccountRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountsController {

    private static final Logger logger = LoggerFactory.getLogger(AccountsController.class);
    private AccountRepository accountRepository;
    private AccountsServiceConfig accountsConfig;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    public AccountsController(AccountRepository accountRepository, AccountsServiceConfig accountsConfig, CardsFeignClient cardsFeignClient, LoansFeignClient loansFeignClient) {
        this.accountRepository = accountRepository;
        this.accountsConfig = accountsConfig;
        this.cardsFeignClient = cardsFeignClient;
        this.loansFeignClient = loansFeignClient;
    }

    @GetMapping("/account/{customerId}")
    @Timed(value = "getAccount.time", description = "Time taken to return account by id")
    public Account getAccount(@PathVariable("customerId") Long id) {
        return accountRepository.findAccountByCustomerId(id);
    }

    @GetMapping("/account/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(accountsConfig.getMsg(), accountsConfig.getBuildVersion(),
                accountsConfig.getMailDetails(), accountsConfig.getActiveBranches());
        return ow.writeValueAsString(properties);
    }

    @GetMapping("/accountDetails/{customerId}")
    @CircuitBreaker(name = "detailsForCustomerSupportApp", fallbackMethod = "customDetailsFallBack")
    public CustomerDetails myCustomerDetails(@RequestHeader("privatbank-correlation-id") String correlationId,
                                             @PathVariable Long customerId) {
        logger.info("myCustomerDetails() method started");
        Account account = accountRepository.findAccountByCustomerId(customerId);
        List<Loan> loans = loansFeignClient.getLoanDetails(correlationId, customerId);
        List<Card> cards = cardsFeignClient.getCardDetails(correlationId, customerId);

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setAccount(account);
        customerDetails.setLoans(loans);
        customerDetails.setCards(cards);

        logger.info("myCustomerDetails() method ended");
        return customerDetails;

    }

    private CustomerDetails customDetailsFallBack(String correlationId, Long customerId, Throwable t) {
        Account account = accountRepository.findAccountByCustomerId(customerId);
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setAccount(account);
        return customerDetails;
    }
}
