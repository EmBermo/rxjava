package com.example.forexclient;

import com.example.forexclient.client.WebClientPrice;
import com.example.forexclient.util.ClientPrice;

import java.util.List;

/**
 * Santander Corporate & Investment Banking (FX)
 * Java Developer 2021 - Market Price Handler Exercise
 * @author Emilio Bermo Vizccaya
 * @
 */
public class ForexClient {
    public static void main(String[] args){
        WebClientPrice wcp = new WebClientPrice();
        System.out.println("Test 1:");
        String test1 = "110, EUR/JPY, 119.61,119.91,01-06-2020 12:01:02:110";
        System.out.println("CSV: " + test1);
        ClientPrice clientPrice = wcp.putPricesFromEmiter(test1);
        System.out.println("Client Price: " + clientPrice);
        System.out.println("******End Test 1*****");
        System.out.println("Test 2:");
        List<ClientPrice> clientPriceList = wcp.getPricesForClient(5);
        clientPriceList.forEach(System.out::println);
        System.out.println("******End Test 2*****");
    }
}
