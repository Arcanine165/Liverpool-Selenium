package org.victor.perez.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.TakesScreenshot;
import org.victor.perez.base.BaseTest;
import org.victor.perez.pages.HomePage;
import org.victor.perez.pages.LoginPage;
import org.victor.perez.utils.Screenshot;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LoginSteps {
    private HomePage home;
    private LoginPage login;

    @Given("User is in Liverpool HomePage")
    public void userIsInLiverpoolHomePage() {
        home = new HomePage();
        login = home.clickOnLogin();
    }
    @Given("User clicks on Iniciar sesión")
    public void user_clicks_on_login(){
        login = home.clickOnLogin();
    }


    @Given("User enters username as {string} and password as {string}")
    public void userEntersUsernameAsAndPasswordAs(String username, String password) {
        login.fillInputs(username,password);
    }

    @Then("user clicks on iniciar")
    public void userClicksOnIniciar() {
        login.clickOnLogin();
        Screenshot.setScrenshotToFolder(LoginSteps.class.getName());
    }


}
