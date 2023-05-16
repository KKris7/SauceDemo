package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutOverviewPage extends CommonSections {

    public CheckOutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutOverviewPage verifyCheckout(String productItem) {
        String itemText = driver.findElement(By.linkText(productItem)).getText();
        String titleOnCheckOutOverviewPage = driver.findElement(By.cssSelector(".title")).getText();

        if (!itemText.equalsIgnoreCase(productItem) && !titleOnCheckOutOverviewPage.equalsIgnoreCase("Checkout: Overview")) {
            throw new RuntimeException("Not able to verify Checkout Overview Page for Item with name: " + productItem);
        }
        return this;
    }

    public CompletedOrderPage click_FinishButton() {
        driver.findElement(By.cssSelector("#finish")).click();
        return new CompletedOrderPage(driver);
    }

    @Override
    public CheckOutOverviewPage verifyFooterElements() {
        super.verifyFooterElements();
        return this;
    }
}
