package com.example.forexclient.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClientPriceFromCSVString {
    /**
     * Convert a CSV string to an ClientPrice object
     * @param csvString CSV string
     * @return ClientPrice object
     */
    public static ClientPrice getFromCSVString(String csvString){
        DateFormat format = new SimpleDateFormat("dd-MM-YYYY hh:mm:ss:SSS");
        String[] csv = csvString.split(",");
        ClientPrice clientPrice = new ClientPrice();
        clientPrice.setCurrencies(csv[1]);
        clientPrice.setBid(Double.valueOf(csv[2])-0.1D);
        clientPrice.setAsk(Double.valueOf(csv[3])+0.1D);
        try {
            clientPrice.setDate(format.parse(csv[4]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return clientPrice;
    }
}
