package com.example.forexclient.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RandomForexLines {
    private static final Random random = new Random();
    private static List<String> currencies = new ArrayList<>();
    static {
        currencies.add("EUR");
        currencies.add("USD");
        currencies.add("JPY");
        currencies.add("GBP");
    }
    private static Map<String, Double> commonAprox = new HashMap<>();
    static {
        commonAprox.put("EUR/USD", 1.1653D);
        commonAprox.put("EUR/JPY", 128.27D);
        commonAprox.put("EUR/GBP", 0.8685D);
        commonAprox.put("USD/EUR", 0.8587D);
        commonAprox.put("USD/JPY", 110.18D);
        commonAprox.put("USD/GBP", 0.7458D);
        commonAprox.put("JPY/USD", 0.8394D);
        commonAprox.put("JPY/GBP", 0.00678D);
        commonAprox.put("GBP/EUR", 1.1515D);
        commonAprox.put("GBP/JPY", 147.86D);
        commonAprox.put("GBP/USD", 1.3419D);
    }
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-YYYY hh:mm:ss:SSS");
    private static String getBaseCurrency(){
        OptionalInt pos;
        do{
            pos = random.ints(0, currencies.size()).findFirst();
        }while(!pos.isPresent());
        return currencies.get(pos.getAsInt());
    }
    private static String getDestinationCurrency(int base){
        OptionalInt pos;
        do{
            pos = random.ints(0, currencies.size()).filter(i -> i != base).findFirst();
        }while(!pos.isPresent());
        return currencies.get(pos.getAsInt());
    }
    private static String getCommonAproxKey(){
        String base = getBaseCurrency();
        return base+"/"+getDestinationCurrency(currencies.indexOf(base));
    }
    private static Double getBidPrice(Double commonAprox){
        OptionalDouble bidPrice;
        do{
            bidPrice = random.doubles(commonAprox, commonAprox + 0.5D).findFirst();
        }while(!bidPrice.isPresent());
        return bidPrice.getAsDouble();
    }
    private static Double getAskPrice(Double bidPrice){
        OptionalDouble askPrice;
        do{
            askPrice = random.doubles(bidPrice+0.1D, bidPrice+0.5D).findFirst();
        }while(!askPrice.isPresent());
        return askPrice.getAsDouble();
    }
    public static String getLine(int l){
        String randomKey = getCommonAproxKey();
        Double bidPrice = getBidPrice(commonAprox.get(randomKey));
        String result = l + "," + randomKey + "," + bidPrice + "," + getAskPrice(bidPrice) + "," + dtf.format(LocalDateTime.now());
        System.out.println(result);
        return result;
    }
}
