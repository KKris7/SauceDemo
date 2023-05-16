package com.saucedemo.test;

import SauceDemoPages.InventoryPage;
import SauceDemoPages.ItemDetailsPage;
import SauceDemoPages.SauceLoginPage;
import WebDriver.WebDriverProvider;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class StepDef {

    WebDriver driver;
    InventoryPage invPage;
    ItemDetailsPage itemPage;
    SauceLoginPage loginPage;

    @io.cucumber.java.Before
    public void setUp(){
        driver = WebDriverProvider.getWebDriverInstance("Chrome");
    }

    @io.cucumber.java.After
    public void afterTests() {
        driver.quit();
    }

    @Given("User is on login page")
    public void userIsOnLoginPage(){
        loginPage = new SauceLoginPage(driver).goToSauceLoginPage();
    }

    @And("User enters {string}, {string} and clicks on login button")
    public void userEntersUsernamePasswordsAndLogin(String userName, String password){
        new SauceLoginPage(driver).loginUser(userName, password);
    }

    @And("User is redirected to Inventory Page")
    public void userIsOnInventoryPage(){
       invPage = new InventoryPage(driver).verifyInventoryPageIsOpen();
    }

    @When("User selects {string}")
    public void userSelectsProduct(String productName){
        itemPage = invPage.click_ProductTitle(productName);
        itemPage.verifyItemDetailsPageIsOpen(productName);
    }

    @When("User click on logout")
    public void userClicksOnLogout(){
        loginPage = itemPage.logOut();
    }

    @Then("User logs out and should be redirected to the login page")
    public void isOnLoginPage(){
        loginPage.verifyLoginPage();
    }

    @When("User verifies Twitter, Facebook, Linkedin and Privacy text are in Footer")
    public void userVerifiesTwitterFacebookLinkedinAndPrivacyTextAreInFooter(){
        new InventoryPage(driver).verifyFooterElements();
    }

}
