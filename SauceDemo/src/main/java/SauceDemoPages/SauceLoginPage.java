package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceLoginPage {
    WebDriver driver;

    public SauceLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public SauceLoginPage goToSauceLoginPage() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    private SauceLoginPage enterUserName(String userName) {
        driver.findElement(By.id("user-name")).sendKeys(userName);
        return this;
    }

    private SauceLoginPage enterPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
        return this;
    }

    public void loginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    public InventoryPage loginUser(String userName, String password) {
        enterUserName(userName).enterPassword(password).loginButton();
        return new InventoryPage(driver);
    }

    public SauceLoginPage verifyLoginPage() {

        boolean isBotLogoPresent = driver.findElement(By.cssSelector(".bot_column")).isDisplayed();
        boolean isLoginLogoPresent = driver.findElement(By.cssSelector(".login_logo")).isDisplayed();

        if (!isLoginLogoPresent && isBotLogoPresent) {
            throw new RuntimeException("Not able to verify the Page" + driver.findElement(By.cssSelector("head > title")));
        }

        return this;
    }
}
