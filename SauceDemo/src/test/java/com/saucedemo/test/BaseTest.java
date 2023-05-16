package com.saucedemo.test;


import WebDriver.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({ScrshotOnTestFailure.class})
public class BaseTest {
    static WebDriver staticDriver;
    WebDriver driver;

    @BeforeClass
    public void setUp()
    {
        driver = WebDriverProvider.getWebDriverInstance("Chrome");
        BaseTest.staticDriver = driver;
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
