package org.victor.perez.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.victor.perez.base.BaseTest;
import org.victor.perez.utils.ImageIdExtractor;

import java.util.List;

public class CartPage extends BaseTest {
    @FindBy(xpath = "//figure[contains(@class,'m-imageProductMyBag')]/img")
    private List<WebElement> articles;
    private String productImageUrl;
    public CartPage(String productImageUrl){
        this.productImageUrl = productImageUrl;
        PageFactory.initElements(driver,this);
    }
    public Boolean validateIfProductIsOnCart(){
        for (WebElement article : articles) {
            String articleId = ImageIdExtractor.extractImageId(article.getAttribute("src"));

            if (articleId != null) {
                if (articleId.equalsIgnoreCase(productImageUrl)) {
                    return true;
                }
            }

        }
        return false;
    }
}
