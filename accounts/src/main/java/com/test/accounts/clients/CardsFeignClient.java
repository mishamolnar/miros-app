package com.test.accounts.clients;

import com.test.accounts.model.Card;
import com.test.accounts.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("cards")
public interface CardsFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "cards/{customerId}", consumes = "application/json")
    List<Card> getCardDetails(@RequestHeader("privatbank-correlation-id") String correlationId,
                              @PathVariable("customerId") Long customerId);
}
