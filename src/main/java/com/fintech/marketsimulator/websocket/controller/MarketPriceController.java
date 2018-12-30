package com.fintech.marketsimulator.websocket.controller;

import com.fintech.marketsimulator.model.MarketPrice;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class MarketPriceController {

    @MessageMapping("/market") // uri to trigger the message
    @SendTo("/topic/market-price") // the mkt-price will be placed in the topic, in the broker
    public MarketPrice getMarketPrice(MarketPrice marketPriceMessage) {
        System.out.println("Call was made to the CONTROLLER MarketPrice");
        return new MarketPrice(
                "By Request Ltd",
                "AHA",
                28,
                35,
                22,
                27,
                3000,
                new Date(12-18-2018));
    }
}