package org.victor.perez.stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.victor.perez.base.BaseTest;
import org.victor.perez.pages.HomePage;
import org.victor.perez.pages.LoginPage;
import org.victor.perez.pages.RegisterPage;
import org.victor.perez.utils.Hooks;
import org.victor.perez.utils.Screenshot;

public class RegisterSteps {
    private HomePage home;
    private LoginPage login;
    private RegisterPage register;

    @Given("User is in Liverpool")
    public void userIsInLiverpool() {
        home = new HomePage();
        login = home.clickOnLogin();
    }

    @Given("user clicks on login")
    public void userClicksOnLogin() {
         login = home.clickOnLogin();
    }


    @And("user clicks on create account button")
    public void userClicksOnCreateAccountButton() {
        register = login.clickOnCreateAccount();
    }

    @Then("user is on register page")
    public void userIsOnRegisterPage() {
        Assert.assertEquals("Crear cuenta",register.getTitle());
        Screenshot.setScrenshotToFolder(RegisterSteps.class.toString());
    }


    @And("user enters email as {string}")
    public void userEntersEmail(String email) {
        register.enterEmail(email);
    }

    @And("user enters password as {string} without correct length")
    public void userEntersPasswordAsWithoutCorrectLength(String password) {
        register.enterPassword(password);
        Screenshot.setScrenshotToFolder(RegisterSteps.class + "/"+ Hooks.getCurrentScenarioName());
        Assert.assertTrue(register.passwordLenghtIsNotCorrect());
    }

    @And("user enters password as {string} without lowercased letters")
    public void userEntersPasswordAsWithoutLowercasedLetters(String password) {
        register.enterPassword(password);
        Screenshot.setScrenshotToFolder(RegisterSteps.class.toString());
        Assert.assertTrue(register.passwordLenghtIsNotCorrect());

    }
}
