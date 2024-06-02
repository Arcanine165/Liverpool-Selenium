package org.victor.perez.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.victor.perez.base.BaseTest;
import org.victor.perez.utils.ImageIdExtractor;

import java.awt.*;

public class ProductPage extends BaseTest {
    @FindBy(tagName = "h1")
    private WebElement productName;
    @FindBy(id = "opc_pdp_addCartButton")
    private WebElement btnAddToBag;

    @FindBy(xpath = "//div[contains(@class,' m-mdc__snackbarSurface mdc-snackbar__surface ')]/div[contains(text(),'Agregaste un producto a tu bolsa')]")
    private WebElement successAlert;
    @FindBy(xpath = "//div[contains(@class,' m-mdc__snackbarSurface mdc-snackbar__surface ')]/div[contains(text(),'Selecciona una talla')]")
    private WebElement errorAlert;
    @FindBy(id = "image-real")
    private WebElement productImage;
    @FindBy(xpath = "//button[contains(@class,'a-header__bag')]")
    private WebElement btnBag;

    public ProductPage(){
        PageFactory.initElements(driver,this);
    }

    public Boolean userIsInPDP(){
        return btnAddToBag.isDisplayed();
    }

    public void addProduct(){
        btnAddToBag.click();
        if (warrantyIsPresent()){
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i.icon-close.close")));
            closeButton.click();
        }

    }
    public boolean warrantyIsPresent(){
        try {
            driver.findElement(By.tagName("h6"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean successAlertVisible(){
        wait.until(ExpectedConditions.visibilityOf(successAlert));
        return successAlert.isDisplayed();
    }

    public CartPage goToCart(){
        btnBag.click();
        String imageUrl = ImageIdExtractor.extractImageId(productImage.getAttribute("src"));
        return new CartPage(imageUrl);
    }
    public  boolean errorAlertVisible(){
        wait.until(ExpectedConditions.visibilityOf(errorAlert));
        return errorAlert.isDisplayed();
    }

}
