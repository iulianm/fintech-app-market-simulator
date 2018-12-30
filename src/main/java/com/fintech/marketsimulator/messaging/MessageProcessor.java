package com.fintech.marketsimulator.messaging;

import com.fintech.marketsimulator.model.MarketPrice;
import com.fintech.marketsimulator.model.MarketPriceBuilder;
import com.fintech.marketsimulator.websocket.config.SchedulerConfig;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

@Component
public class MessageProcessor {

    @Autowired
    private SchedulerConfig schedulerConfig;

//    @Value("${fleetman.position.queue}")
//    private String queueName;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("stock-prices.queue");
    }

    @JmsListener(destination="stock-prices.queue")
    public void processPriceMessageFromQueue(Map<String, String> incomingMessage ) throws ParseException {

        System.out.println("Incoming message is ---> ");
        System.out.println(incomingMessage);

        MarketPrice newMarketPrice = new MarketPriceBuilder()
                                            .withStockName(incomingMessage.get("stockName"))
                                            .withStockSymbol(incomingMessage.get("stockSymbol"))
                                            .withPriceOpen(Double.parseDouble(incomingMessage.get("priceOpen")))
                                            .withPriceHigh(Double.parseDouble(incomingMessage.get("priceHigh")))
                                            .withPriceLow(Double.parseDouble(incomingMessage.get("priceLow")))
                                            .withPriceClose(Double.parseDouble(incomingMessage.get("priceClose")))
                                            .withVolume(Double.parseDouble(incomingMessage.get("volume")))
                                            .withTimestamp(new SimpleDateFormat("MM/dd/yyyy' 'HH:mm")
                                                    .parse(incomingMessage.get("timestamp")))
                                            .build();

        schedulerConfig.sendAdhocMessages(newMarketPrice);

    }
}
