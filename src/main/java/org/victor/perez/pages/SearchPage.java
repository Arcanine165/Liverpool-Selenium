package org.victor.perez.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.victor.perez.base.BaseTest;

import java.util.List;

public class SearchPage extends BaseTest {
    @FindBy(xpath = "//ul[contains(@class,'m-product__listingPlp')]")
    private WebElement searchList;
    @FindBy(xpath = "//h5[contains(@class,'card-title a-card-description')]")
    private List<WebElement> desiredProducts;
    @FindBy(className = "o-content__noResultsNullSearch")
    private WebElement notFoundContainer;

    private String productName;

    public SearchPage(){
        PageFactory.initElements(driver,this);
    }
    public Boolean isSearchVisible(){
        return searchList.isDisplayed();
    }
    public ProductPage selectItem(int index){
        List<WebElement> items = searchList.findElements(By.tagName("li"));
        items.get(index).click();

        return new ProductPage();

    }

    public Boolean notFoundIsVisible(){
        return notFoundContainer.isDisplayed();
    }

}
