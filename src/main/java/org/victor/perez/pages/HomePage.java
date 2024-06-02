package org.victor.perez.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.victor.perez.base.BaseTest;

import javax.xml.xpath.XPath;

public class HomePage extends BaseTest {
    @FindBy(xpath = "//span[contains(text(),'Iniciar sesión')]")
    private WebElement loginButton;

    @FindBy(id = "mainSearchbar")
    private WebElement searchBar;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public Boolean loginButtonIsVisible(){
        return loginButton.isDisplayed();
    }

    public String getTitle() {
        return driver.getTitle();
    }
    public LoginPage clickOnLogin(){
        loginButton.click();
        return new LoginPage();
    }
    public void clicksOnSearchBar(){
        searchBar.click();
    }
    public void typesOnSearchBar(String product){
        searchBar.sendKeys(product);
    }
    public SearchPage clickEnter(){
        searchBar.sendKeys(Keys.ENTER);
        return new SearchPage();
    }


}
