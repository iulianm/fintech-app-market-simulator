package com.fintech.marketsimulator.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MarketPriceBuilder {

    private String stockName;
    private String stockSymbol;

    private double priceOpen;
    private double priceHigh;
    private double priceLow;
    private double priceClose;

    private double volume;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy'T'HH:mm", timezone="UTC")
    private Date timestamp;

    public MarketPrice build()
    {
        return new MarketPrice(stockName, stockSymbol, priceOpen, priceHigh, priceLow, priceClose, volume, timestamp);
    }

    public MarketPriceBuilder withStockName(String stockName){
        this.stockName = stockName;
        return  this;
    }

    public MarketPriceBuilder withStockSymbol(String stockSymbol){
            this.stockSymbol = stockSymbol;
            return  this;
        }

    public MarketPriceBuilder withPriceOpen(double priceOpen){
            this.priceOpen = priceOpen;
            return  this;
        }

    public MarketPriceBuilder withPriceHigh(double priceHigh){
            this.priceHigh = priceHigh;
            return  this;
        }

    public MarketPriceBuilder withPriceLow(double priceLow){
            this.priceLow = priceLow;
            return  this;
        }

    public MarketPriceBuilder withPriceClose(double priceClose){
            this.priceClose = priceClose;
            return  this;
        }

    public MarketPriceBuilder withVolume(double volume){
            this.volume = volume;
            return  this;
        }

    public MarketPriceBuilder withTimestamp(Date timestamp){
            this.timestamp = timestamp;
            return  this;
        }
}
