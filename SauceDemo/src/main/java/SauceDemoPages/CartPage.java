package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends CommonSections {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage verifyIsThereAnItemAddedOnCartPage() {

        if (!isCartPageDisplayed() && driver.findElements(By.cssSelector(".cart_item")).isEmpty()) {
            throw new RuntimeException("There is an Item");
        }
        return this;
    }

    public CartPage verifyCheckOutButtonDisabled() {
        if (driver.findElement(By.id("checkout")).isEnabled()) {
            Assert.fail("Test should fail here", new Throwable(new RuntimeException("Checkout button is enabled")));
        }
        return this;
    }

    private boolean isCartPageDisplayed() {

        boolean isTitleOnCartPagePresent = driver.findElement(By.cssSelector(".title")).isDisplayed();
        boolean isCheckOutButtonPresent = driver.findElement(By.cssSelector("#checkout")).isDisplayed();

        if (!isTitleOnCartPagePresent && isCheckOutButtonPresent) {
            throw new RuntimeException("Not able to verify the Cart Page is Displayed");
        }
        return isTitleOnCartPagePresent && isCheckOutButtonPresent;
    }

    public CartPage verifyItemNameOnCartPage(String productItem) {
        String itemText = driver.findElement(By.linkText(productItem)).getText();

        if (!itemText.equalsIgnoreCase(productItem) && isCartPageDisplayed()) {
            throw new RuntimeException("Not able to verify the Item on Cart Page");
        }

        return this;
    }

    public CheckOutPage click_CheckoutButton() {
        driver.findElement(By.cssSelector("#checkout")).click();
        return new CheckOutPage(driver);
    }

    @Override
    public CartPage verifyFooterElements() {
        super.verifyFooterElements();
        return this;
    }

    public CartPage verifyProductPriceOnCartPage() {

        String itemName = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
        String itemPrice = driver.findElement(By.cssSelector(".inventory_item_price")).getText();
        String itemNameAndPrice = itemName + ":" + itemPrice;
        boolean isVerified = false;

        for (int i = 0; i < namesAndPricesOfItems.size(); i++) {
            if (namesAndPricesOfItems.get(i).equals(itemNameAndPrice)) {
                isVerified = true;
                break;
            }

        }
        if (!isVerified) {
            throw new RuntimeException("Price verification on CartPage failed for product: " + itemName + ".\nExpected price:" + itemPrice);
        }
        return this;
    }
}
