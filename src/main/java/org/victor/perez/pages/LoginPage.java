package org.victor.perez.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.victor.perez.base.BaseTest;

public class LoginPage extends BaseTest {
    @FindBy(xpath = "//a[contains(text(),'Crear cuenta')]")
    private WebElement createAccountBtn;
    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[contains(text(),'Iniciar sesión')]")
    private WebElement btnLogin;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public RegisterPage clickOnCreateAccount(){
        createAccountBtn.click();
        return new RegisterPage();
    }

    public void fillInputs(String username, String password){
        this.usernameInput.sendKeys(username);
        this.passwordInput.sendKeys(password);


    }
    public void clickOnLogin(){
        btnLogin.click();
    }

}
