package com.saucedemo.test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ScrshotOnTestFailure implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        try {
            TakesScreenshot screenshot = (TakesScreenshot) BaseTest.staticDriver;
            File file = screenshot.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(file, new File("src\\test\\screenshots\\" +
                    result.getInstanceName().replace("com.saucedemo.test", "_") + "\\" + System.currentTimeMillis() + ".png"));

        } catch (Exception e) {
            System.out.println("Couldn't take screenshot: " + e.getMessage());
        }
    }


}