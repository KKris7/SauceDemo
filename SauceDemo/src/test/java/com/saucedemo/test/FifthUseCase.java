package com.saucedemo.test;

import TestData.Credentials;
import SauceDemoPages.SauceLoginPage;
import org.testng.annotations.Test;

public class FifthUseCase extends BaseTest {

    //1. Login on SauceDemo
    //2. Verify the Products Page.
    //3. Verify Twitter, Facebook and LinkedIn Icons are present in the Footer.
    //4. Verify the URL for all 3 Icons pointing to Correct Website.( No Need to click on the Icons Please.)
    //5. Verify in Footer 'Privacy Policy' Text is also Present.
    //6. Select Any Product By Name.
    //7. Verify product description page opened.
    //8. Verify Again the Twitter, Facebook and LinkedIn Icons are present in the Footer.
    //9. Logout the User.

    @Test(dataProvider = "TestDataUserAndProduct", dataProviderClass = Credentials.class)
    public void VerifyTheFooterHasAll3SocialMediaIcons_SauceDemoTest(String userName, String password, String productName) {

                new SauceLoginPage(driver)
                .goToSauceLoginPage()
                .loginUser(userName, password)
                .verifyInventoryPageIsOpen()
                .verifyFooterElements()
                .click_ProductTitle(productName)
                .verifyItemDetailsPageIsOpen(productName)
                .verifyFooterElements()
                .logOut();
    }
}
