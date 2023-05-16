package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletedOrderPage extends CommonSections {
    public CompletedOrderPage(WebDriver driver) {
        super(driver);
    }

    public CompletedOrderPage verifyOrderIsPlacedSuccessfully() {
        boolean isThankYouDisplayed = driver.findElement(By.cssSelector(".complete-header")).isDisplayed();
        String titleOnCompletedOrderPage = driver.findElement(By.cssSelector(".title")).getText();

        if (!titleOnCompletedOrderPage.equalsIgnoreCase("Checkout: Complete!")
                && isThankYouDisplayed) {
            throw new RuntimeException("Not able to verify the Page title: Checkout: Complete!");
        }
        return this;
    }

    @Override
    public CompletedOrderPage verifyFooterElements() {
        super.verifyFooterElements();
        return this;
    }
}
