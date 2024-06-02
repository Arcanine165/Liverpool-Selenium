package org.victor.perez.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/java/org/victor/perez/features/Register.feature","src/main/java/org/victor/perez/features/Login.feature","src/main/java/org/victor/perez/features/Login.feature","src/main/java/org/victor/perez/features/AddToCart.feature"},
        glue = {"org.victor.perez.stepdefinitions","org.victor.perez.utils"},
        monochrome = true,
        stepNotifications = true
)
public class Runner {

}
