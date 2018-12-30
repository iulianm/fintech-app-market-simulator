package com.fintech.marketsimulator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
//import java.math.BigDecimal;
import java.util.Date;

public class MarketPrice {

    private String stockName;
    private String stockSymbol;

    private double priceOpen;
    private double priceHigh;
    private double priceLow;
    private double priceClose;

    private double volume;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy'T'HH:mm", timezone="UTC")
    private Date timestamp;

   public MarketPrice() {
    }

    public MarketPrice(String stockName, String stockSymbol, double priceOpen, double priceHigh, double priceLow, double priceClose, double volume, Date timestamp) {
        this.stockName = stockName;
        this.stockSymbol = stockSymbol;
        this.priceOpen = priceOpen;
        this.priceHigh = priceHigh;
        this.priceLow = priceLow;
        this.priceClose = priceClose;
        this.volume = volume;
        this.timestamp = timestamp;
    }

    public String getStockName() {
        return stockName;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public double getPriceOpen() {
        return priceOpen;
    }

    public double getPriceHigh() {
        return priceHigh;
    }

    public double getPriceLow() {
        return priceLow;
    }

    public double getPriceClose() {
        return priceClose;
    }

    public double getVolume() {
        return volume;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "MarketPrice{" +
                "stockName='" + stockName + '\'' +
                ", stockSymbol='" + stockSymbol + '\'' +
                ", priceOpen=" + priceOpen +
                ", priceHigh=" + priceHigh +
                ", priceLow=" + priceLow +
                ", priceClose=" + priceClose +
                ", volume=" + volume +
                ", timestamp=" + timestamp +
                '}';
    }
}
