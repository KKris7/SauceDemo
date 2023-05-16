package com.saucedemo.test;

import TestData.Credentials;
import SauceDemoPages.SauceLoginPage;
import org.testng.annotations.Test;

public class FirstUseCase extends BaseTest {

    //1.	Login on SauceDemo
    //2.	Verify the Page after Login
    //3.	Select the Product By Name
    //4.	Verify the Description/Details page for the Product
    //5.	Click Add to Cart
    //6.	Verify the Value in Add to Cart
    //7.	Click Add to Cart Icon
    //8.	Verify CheckOut Page and Check if the same Item is there or not
    //9.	Click CHECKOUT button
    //10.	Enter Your Name, Last Name and Zip code.
    //11.	Click Continue Button
    //12.	Verify Checkout : Overview page and Check the Product Name again.
    //13.	Click Finish Button
    //14.	Verify the Order is placed Successfully.

    @Test(dataProvider = "TestDataUserAndProduct",dataProviderClass = Credentials.class)
    public void VerifyProductPurchase_SauceDemoTest(String userName, String password, String productName) {

                new SauceLoginPage(driver)
                .goToSauceLoginPage()
                .loginUser(userName,password)
                .verifyInventoryPageIsOpen()
                .click_ProductTitle(productName)
                .verifyItemDetailsPageIsOpen(productName)
                .click_addToCartButton()
                .verifyItemIsAddedInCart()
                .click_CartButton()
                .verifyItemNameOnCartPage(productName)
                .click_CheckoutButton()
                .confirmYourInformation("Steve","Curry","1234")
                .verifyCheckout(productName)
                .click_FinishButton()
                .verifyOrderIsPlacedSuccessfully();

    }
}
