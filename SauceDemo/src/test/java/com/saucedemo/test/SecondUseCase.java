package com.saucedemo.test;

import TestData.Credentials;
import SauceDemoPages.SauceLoginPage;
import org.testng.annotations.Test;

public class SecondUseCase extends BaseTest{

    //1.	Login on SauceDemo
    //2.	Verify Page after Login.
    //3.	Select the Product By Image.
    //4.	Click Logout and User should be Logged Out

    @Test(dataProvider = "TestDataUserAndProduct",dataProviderClass = Credentials.class)
    public void VerifyLogout_SauceDemoTest(String userName, String password, String productName) {

                new SauceLoginPage(driver)
                .goToSauceLoginPage()
                .loginUser(userName, password)
                .verifyInventoryPageIsOpen()
                .click_ProductImage(productName)
                .logOut()
                .verifyLoginPage();
    }
}
