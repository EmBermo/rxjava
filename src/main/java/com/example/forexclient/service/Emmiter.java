package com.example.forexclient.service;

import com.example.forexclient.util.ClientPrice;
import com.example.forexclient.util.RandomForexLines;
import io.reactivex.rxjava3.subjects.PublishSubject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * Emitter that produces FX messages in CSV format
 */
public class Emmiter {
    private static Subscriber subscriber = new Subscriber();
    public static void getFXPricesEmitter(int generationLimit) {
        int l=100;
        PublishSubject<String> emitter = PublishSubject.create();
        emitter.timeout(10000, TimeUnit.MILLISECONDS);
        emitter.subscribe(subscriber);
        while (l<=generationLimit+100) {
            try {
                emitter.onNext(RandomForexLines.getLine(l++));
                sleep(100);
            } catch (Exception e) {
            }
        }
    }
    public static List<ClientPrice> getSubscriberResult(){
        return subscriber.getSubscriberResult();
    }
}
