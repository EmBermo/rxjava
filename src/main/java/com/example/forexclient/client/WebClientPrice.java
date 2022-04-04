package com.example.forexclient.client;

import com.example.forexclient.service.Emmiter;
import com.example.forexclient.service.Subscriber;
import com.example.forexclient.util.ClientPrice;
import lombok.extern.java.Log;

import java.util.List;

@Log
public class WebClientPrice {
    /**
     * Suitable place for the endpoint GET
     * @param count FX prices requested to emitter
     * @return Client Prices transformed by subscriber
     */
    public List<ClientPrice> getPricesForClient(int count) {
        Emmiter.getFXPricesEmitter(count);
        return Emmiter.getSubscriberResult();
    }
    /**
     * Suitable place for the endpoint PUT
     * @param message message with CSV prices for a currencies pair
     * @return Client Prices for a currencies pair transformed by subscriber
     */
    public ClientPrice putPricesFromEmiter(String message){
        Subscriber subscriber = new Subscriber();
        try {
            subscriber.accept(message);
        } catch (Throwable e) {
            log.warning(e.getMessage());
        }
        return subscriber.getSubscriberResult().get(0);
    }
}
