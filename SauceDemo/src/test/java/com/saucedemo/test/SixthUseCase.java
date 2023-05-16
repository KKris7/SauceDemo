package com.saucedemo.test;

import SauceDemoPages.SauceLoginPage;
import TestData.Credentials;
import org.testng.annotations.Test;

public class SixthUseCase extends BaseTest {

    //1. Login on SauceDemo
    //2. Verify the Products Page.
    //3. Any Product By Name and Price should be Present and Store the Price of Product.
    //4. Click and Select the Above Product By Name.
    //5. Verify product description page opened.
    //6. Verify The Price of the Product is same Like in Products List Page.
    //7. Add to Cart the Product.
    //8. Click Cart Icon.
    //9. Verify in the Cart Page the product Price is Still Same.
    //10. Logout User.

    @Test(dataProvider = "TestDataUserAndProduct", dataProviderClass = Credentials.class)
    public void VerifyTheProductPriceInAllPages_SauceDemoTest(String userName, String password, String productName) {

                new SauceLoginPage(driver)
                .goToSauceLoginPage()
                .loginUser(userName, password)
                .verifyInventoryPageIsOpen()
                .setAllProductsInListByNamesAndPrices()
                .click_ProductTitle(productName)
                .verifyItemDetailsPageIsOpen(productName)
                .verifyProductPriceOnDetailsPage()
                .click_addToCartButton()
                .click_CartButton()
                .verifyProductPriceOnCartPage()
                .logOut();
    }
}
