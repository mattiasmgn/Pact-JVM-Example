package se.ff.bsc;


import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class WhenComesTheBusTest {
    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("BusService", "localhost", 8112, this);

    @Pact(consumer = "BusServiceClient")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");


        DslPart etaResults = new PactDslJsonBody()
                .stringType("station","Hammersmith")
                .stringType("nr","613")
                .integerType("eta",4)
                .asBody();

        return builder
                .given("There is a bus with number 613 arriving to Hammersmith bus station")
                .uponReceiving("A request for eta for bus number 613 to Hammersmith bus station")
                .path("/bus/Hammersmith/613")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(etaResults).toPact();

    }

    @Test
    @PactVerification()
    public void doTest() {
        System.setProperty("pact.rootDir","../pacts");  // Change output dir for generated pact-files
        Integer eta = new WhenComesTheBus(provider.getPort()).checkEta("Hammersmith", "613");
        System.out.println("According to test eta="+eta);
        assertTrue(eta >= 0);
    }

}

