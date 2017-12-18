package se.ff.bsv;


import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;

import java.util.Map;

@RunWith(PactRunner.class) // Say JUnit to run tests with custom Runner
@Provider("BusService") // Set up name of tested provider
@PactFolder("../pacts") // Point where to find pacts (See also section Pacts source in documentation)

public class BusStopContractTest {


    @State("There is a bus with number 613 arriving to Hammersmith bus station") // Method will be run before testing interactions that require "with-data" state
    public void hammerSmith() {
        System.out.println("There is a bus with number 613 arriving to Hammersmith bus station" );
    }


    @TestTarget // Annotation denotes Target that will be used for tests
    public final Target target = new HttpTarget(8111); // Out-of-the-box implementation of Target (for more information take a look at Test Target section)

}
