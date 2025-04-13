package org.ecm.utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;

/**
 * Hooks : Class used to perform actions Before and After executing a feature file, contains setup and teardown methods
 *
 * @author Abhishek Arora
 */
public class Hooks {

    @Before
    public void setUp(){
        DriverManagerUtility.getInstance().getDriver();
    }

    @After
    public void teardown(){
        DriverManagerUtility.getInstance().closeDriver();
    }
}
