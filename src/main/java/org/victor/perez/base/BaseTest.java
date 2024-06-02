package org.victor.perez.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public BaseTest(){

    }
    public static void initBrowser(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        if (driver == null){
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.get("https://www.liverpool.com.mx/tienda/home");
        }


    }
    public static void closeBrowser(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
