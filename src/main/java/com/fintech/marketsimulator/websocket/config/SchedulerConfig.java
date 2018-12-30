package com.fintech.marketsimulator.websocket.config;

import com.fintech.marketsimulator.model.MarketPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

//import java.math.BigDecimal;
import java.util.Date;

@EnableScheduling
@Configuration
public class SchedulerConfig {

    @Autowired
    SimpMessagingTemplate template;

    //@Scheduled(fixedDelay = 1000)
    public void sendAdhocMessages() {
        System.out.println("SCHEDULER started");
        template.convertAndSend("/topic/market-price", new MarketPrice(
                "Scheduler Ltd",
                "UHU",
                88,
                85,
                82,
                87,
                3000,
                new Date(12-28-2018)));
    }

    public void sendAdhocMessages(MarketPrice marketPrice) {
        System.out.println("Market Price - Received");
        template.convertAndSend("/topic/market-price", marketPrice);
    }
}
