package com.test.accounts.clients;

import com.test.accounts.model.Customer;
import com.test.accounts.model.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("loans")
public interface LoansFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "loans/{customerId}", consumes = "application/json")
    List<Loan> getLoanDetails(@RequestHeader("privatbank-correlation-id") String correlationId,
                              @PathVariable("customerId") Long customerId);
}
