package org.victor.perez.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.victor.perez.base.BaseTest;

import java.util.List;

public class RegisterPage extends BaseTest {
    @FindBy(xpath = "//li/span[contains(text(),'Al menos 8 caracteres de largo')]")
    private WebElement lengthCriteria;
    @FindBy(xpath = "//li/span[contains(text(),'Letras minúsculas (a-z)')]")
    private WebElement lowercaseCriteria;
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "error-element-email")
    private WebElement wrongEmail;

    private String greyCheck = "cef36f021";


    public RegisterPage(){
        PageFactory.initElements(driver,this);
    }

    public String getTitle() {
        return driver.getTitle();
    }
    public void enterEmail(String email){
        emailInput.sendKeys(email);
    }
    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }
    public Boolean passwordLenghtIsNotCorrect(){
        WebElement parentLiElement = getParentElement(lengthCriteria);
        String liClass = parentLiElement.getAttribute("class");

        return  liClass.contains(greyCheck);
    }

    public Boolean passwordWithoutLowecased(){
        WebElement parentElement = getParentElement(lowercaseCriteria);
        String liClass = parentElement.getAttribute("class");

        return  liClass.contains(greyCheck);
    }

    private WebElement getParentElement(WebElement element){
        return element.findElement(By.xpath("./.."));
    }

}
