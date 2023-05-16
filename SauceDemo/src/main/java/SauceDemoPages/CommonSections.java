package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CommonSections {
    WebDriver driver;
    int counter;
    static List<String> namesAndPricesOfItems;

    public CommonSections(WebDriver driver) {
        this.driver = driver;
    }

    public SauceLoginPage logOut() {

        driver.findElement(By.id("react-burger-menu-btn")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logout_sidebar_link"))).click();

        return new SauceLoginPage(driver);
    }

    public CartPage click_CartButton() {
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        return new CartPage(driver);
    }

    private void verifySocialMediaLinksAndIcons() {

        boolean twitter = driver.findElement(By.cssSelector("a[href='https://twitter.com/saucelabs']")).isDisplayed();
        boolean faceBook = driver.findElement(By.cssSelector("a[href='https://www.facebook.com/saucelabs']")).isDisplayed();
        boolean linkedIn = driver.findElement(By.cssSelector("a[href='https://www.linkedin.com/company/sauce-labs/']")).isDisplayed();

        if (!twitter && faceBook && linkedIn) {
            throw new RuntimeException("Links and icons aren't set correctly");
        }
    }

    private void verifyFooterText() {
        if (!driver.findElement(By.cssSelector(".footer_copy")).getText().contains("Privacy Policy"))
            throw new RuntimeException("Footer doesn't contain privacy policy.");
    }

    public CommonSections verifyFooterElements() {
        verifySocialMediaLinksAndIcons();
        verifyFooterText();
        return this;
    }
}
