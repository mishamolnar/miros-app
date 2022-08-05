package com.test.cards.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.test.cards.config.CardsConfigServer;
import com.test.cards.model.Card;
import com.test.cards.model.Customer;
import com.test.cards.model.Properties;
import com.test.cards.repository.CardRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CardController {

    private static final Logger logger = LoggerFactory.getLogger(CardController.class);
    private CardRepository cardRepository;
    private CardsConfigServer cardsConfig;

    public CardController(CardRepository cardRepository, CardsConfigServer cardsConfig) {
        this.cardRepository = cardRepository;
        this.cardsConfig = cardsConfig;
    }

    @GetMapping("/cards/{customerId}")
    public List<Card> getCardDetails(@RequestHeader("privatbank-correlation-id") String correlationId,
                                      @PathVariable Long customerId) {
        logger.info("getCardDetails method executing");
        return cardRepository.findByCustomerId(customerId);
    }


    @GetMapping("/cards/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(cardsConfig.getMsg(), cardsConfig.getBuildVersion(),
                cardsConfig.getMailDetails(), cardsConfig.getActiveBranches());
        return ow.writeValueAsString(properties);
    }
}
