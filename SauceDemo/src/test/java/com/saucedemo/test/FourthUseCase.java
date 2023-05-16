package com.saucedemo.test;

import TestData.Credentials;
import SauceDemoPages.SauceLoginPage;
import org.testng.annotations.Test;

public class FourthUseCase extends BaseTest{

    //1. Login on SauceDemo
    //2. Verify the Products Page.
    //3. Click cart Icon from Top Corner.
    //4. Verify Your Cart Page Displayed.
    //5. Verify there is no Product In the Cart.
    //6. Verify As No product In Cart the CHECKOUT button should be Disabled.(Test should Fail Here)
    //7. Logout user.

    @Test(dataProvider = "TestDataUser",dataProviderClass = Credentials.class)
    public void VerifyTheEmptyCartPageAndVerifyCHECKOUTButtonIsDisabled_SauceDemoTest(String userName, String password){

                new SauceLoginPage(driver)
                .goToSauceLoginPage()
                .loginUser(userName, password)
                .verifyInventoryPageIsOpen()
                .click_CartButton()
                .verifyIsThereAnItemAddedOnCartPage()
                .verifyCheckOutButtonDisabled()
                .logOut();
    }
}
