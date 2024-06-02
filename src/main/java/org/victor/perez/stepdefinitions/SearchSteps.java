package org.victor.perez.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.AfterClass;
import org.junit.Assert;
import org.victor.perez.base.BaseTest;
import org.victor.perez.pages.CartPage;
import org.victor.perez.pages.HomePage;
import org.victor.perez.pages.ProductPage;
import org.victor.perez.pages.SearchPage;

public class SearchSteps {
    private HomePage home;
    private SearchPage search;
    private ProductPage productPage;
    private CartPage cartPage;

    @Given("User is in home")
    public void userIsInLiverpoolHomePage(){
        home = new HomePage();

    }

    @Given("User clicks on search bar")
    public void userClicksOnSearchBar() {
        home.clicksOnSearchBar();
    }

    @And("Types product as {string}")
    public void typesProductAsProduct(String product) {
        home.typesOnSearchBar(product);
    }


    @Then("User clicks enter")
    public void userClicksEnter() {
        search = home.clickEnter();
    }

    @Then("User selects the third item")
    public void userSelectsTheThirdItem() {
        Assert.assertTrue("No esta ahi",search.isSearchVisible());
        productPage = search.selectItem(2);

    }

    @Then("User is in ProductDetail page")
    public void userIsInProductDetailPage() {
        Assert.assertTrue(productPage.userIsInPDP());
    }

    @And("User adds the product to the cart")
    public void userAddsTheProductToTheCart() {
        productPage.addProduct();

    }

    @Then("User goes to the cart")
    public void userGoesToTheCart() {
        cartPage = productPage.goToCart();
    }

    @And("validate if its there")
    public void validateIfItsThere() {
        Assert.assertTrue(cartPage.validateIfProductIsOnCart());
    }

    @And("Alert of success appear")
    public void alertOfSuccessAppear() {
        Assert.assertTrue(productPage.successAlertVisible());
    }

    @Then("The page displays a landing page error")
    public void thePageDisplaysALandingPageError() {
        Assert.assertTrue(search.notFoundIsVisible());
    }

    @Then("Error appears if user doesn't select size")
    public void errorAppearsIfUserDoesnTSelectSize() {
        Assert.assertTrue(productPage.errorAlertVisible());
    }
}
