package com.test.loans.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.test.loans.config.LoansConfigServer;
import com.test.loans.model.Customer;
import com.test.loans.model.Loan;
import com.test.loans.model.Properties;
import com.test.loans.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.List;

@RestController
public class LoanController {

    private static final Logger logger = LoggerFactory.getLogger(LoanController.class);
    private LoanRepository loanRepository;
    private LoansConfigServer loansConfig;

    public LoanController(LoanRepository loanRepository, LoansConfigServer loansConfig) {
        this.loanRepository = loanRepository;
        this.loansConfig = loansConfig;
    }

    @GetMapping("/loans/{customerId}")
    public List<Loan> getLoansDetails(@RequestHeader("privatbank-correlation-id") String correlationId,
                                      @PathVariable("customerId") Long customerId) {
        logger.info("getLoanDetails method executing");
        return loanRepository.findByCustomerIdOrderByStartDtDesc(customerId);
    }

    @GetMapping("/loans/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(loansConfig.getMsg(), loansConfig.getBuildVersion(),
                loansConfig.getMailDetails(), loansConfig.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }
}
