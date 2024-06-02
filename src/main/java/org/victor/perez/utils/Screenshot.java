package org.victor.perez.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.victor.perez.base.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Screenshot {
    public static void setScrenshotToFolder(String folderName){
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        try {
            Screenshot.takeScreenshot(BaseTest.driver,"src/main/java/org/victor/perez/screenshots/"+folderName+"/"+Hooks.getCurrentScenarioName()+"/"+ timeStamp +".png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void takeScreenshot(WebDriver driver, String path) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(path);
        FileUtils.copyFile(srcFile,destFile);
    }

}
