package com.example.forexclient.service;

import com.example.forexclient.util.ClientPrice;
import com.example.forexclient.util.ClientPriceFromCSVString;
import io.reactivex.rxjava3.functions.Consumer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A subscriber to listen to the market prices. You can assume the feed is coming from a messaging system
 * where all you have to do is implement an interface.
 * Selected interface: io.reactivex.rxjava3.functions.Consumer.
 */
public class Subscriber implements Consumer<String> {
    private List<ClientPrice> result = new ArrayList<>();
    @Override
    public void accept(String s) throws Throwable {
        result.add(ClientPriceFromCSVString.getFromCSVString(s));
    }
    public List<ClientPrice> getSubscriberResult(){
        result.sort(Comparator.comparing(ClientPrice::getDate).reversed());
        return result;
    }
}
