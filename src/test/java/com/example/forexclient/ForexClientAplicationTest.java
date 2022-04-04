package com.example.forexclient;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import com.example.forexclient.client.WebClientPrice;
import com.example.forexclient.util.ClientPrice;
import org.junit.Test;

import java.util.List;

public class ForexClientAplicationTest {
    @Test
    public void shouldTransformCSVLinesIntoFXPrices() {
        WebClientPrice wcp = new WebClientPrice();
        List<ClientPrice> clientPrices = wcp.getPricesForClient(100);
        assertTrue(!clientPrices.isEmpty());
        ClientPrice result = clientPrices.get(clientPrices.size() - 1);
        System.out.println("Last result: "+clientPrices.get(0));
        assertNotNull(result);
    }
}
