package com.saucedemo.test;

import TestData.Credentials;
import SauceDemoPages.SauceLoginPage;
import org.testng.annotations.Test;
public class ThirdUseCase extends BaseTest{

    //1. Login on SauceDemo
    //2. Verify the Products Page.
    //3. Select Price Filter -> Low to High
    //4. Verify the Products are now listed as Low to High Price products.
    //5. Select Price Filter -> High to Low.
    //6. Verify the Products are now listed as High to Low Price products on the page.
    //7. Click Logout.

    @Test(dataProvider = "TestDataUserAndFilter",dataProviderClass = Credentials.class)
    public void VerifyThePriceFilterOnProductsPage_SauceDemoTest(String userName, String password, String lowToHigh, String HighToLow) {

                new SauceLoginPage(driver)
                .goToSauceLoginPage()
                .loginUser(userName,password)
                .verifyInventoryPageIsOpen()
                .selectPriceFilter(lowToHigh)
                .verifyFilterIsApplied(lowToHigh)
                .selectPriceFilter(HighToLow)
                .verifyFilterIsApplied(HighToLow)
                .logOut();

    }
}
