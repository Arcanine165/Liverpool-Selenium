package org.victor.perez.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.victor.perez.base.BaseTest;

public class Hooks {
    private static String currentScenarioName;

    @Before
    public void beforeScenario(Scenario scenario) {
        // This code will run before each scenario
        BaseTest.initBrowser();
        String scenarioName = scenario.getName();
        setCurrentScenarioName(scenarioName);
    }
    @After
    public void closeBrowser(){
        BaseTest.closeBrowser();
    }

    public static String getCurrentScenarioName() {
        return currentScenarioName;
    }

    public static void setCurrentScenarioName(String name) {
        currentScenarioName = name;
    }
}
