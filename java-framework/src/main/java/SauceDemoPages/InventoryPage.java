package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends CommonSections {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public ItemDetailsPage click_ProductImage(String productItem) {
        driver.findElement(By.cssSelector("img[alt='" + productItem + "']")).click();
        return new ItemDetailsPage(driver);
    }

    public ItemDetailsPage click_ProductTitle(String productItem) {
        driver.findElement(By.linkText(productItem)).click();
        return new ItemDetailsPage(driver);
    }

    public InventoryPage verifyInventoryPageIsOpen() {
        String titleOnInventoryPage = driver.findElement(By.cssSelector(".title")).getText();
        if (!titleOnInventoryPage.equalsIgnoreCase("Products")) {
            throw new RuntimeException("Not able to verify the Page title: Products");
        }

        return this;
    }

    public InventoryPage selectPriceFilterHighToLow() {
        WebElement filterButton = driver.findElement(By.cssSelector(".product_sort_container"));
        filterButton.sendKeys("Price (high to low)");

        return this;
    }

    public InventoryPage selectPriceFilterLowToHigh() {
        WebElement filterButton = driver.findElement(By.cssSelector(".product_sort_container"));
        filterButton.sendKeys("Price (low to high)");

        return this;
    }

/*
    public InventoryPage clickAddToCardOnInventoryPage(String productItem) {
        String searchProduct = productItem.toLowerCase().replaceAll(" ", "-");
        driver.findElement(By.id("add-to-cart-" + searchProduct)).click();
        return this;
    }
*/
    public InventoryPage verifyItemsAreListedLowToHigh() {

        List<WebElement> inventoryItemsPrice = driver.findElements(By.cssSelector("div.inventory_item_price"));

        for (int i = 0; i < inventoryItemsPrice.size() - 1; i++) {

            double currentItemPrice = Double.parseDouble(inventoryItemsPrice.get(i).getText().replace("$", ""));
            double nextItemPrice = Double.parseDouble(inventoryItemsPrice.get(i + 1).getText().replace("$", ""));

            if (currentItemPrice > nextItemPrice) {
                throw new RuntimeException("Items are not sorted from Low to High Price");
            }
        }
        return this;
    }

    public InventoryPage verifyItemsAreListedHighToLow() {

        List<WebElement> inventoryItemsPrice = driver.findElements(By.cssSelector("div.inventory_item_price"));

        for (int i = 0; i < inventoryItemsPrice.size() - 1; i++) {

            double currentItemPrice = Double.parseDouble(inventoryItemsPrice.get(i).getText().replace("$", ""));
            double nextItemPrice = Double.parseDouble(inventoryItemsPrice.get(i + 1).getText().replace("$", ""));

            if (currentItemPrice < nextItemPrice) {
                throw new RuntimeException("Items are not sorted from Low to High Price");
            }
        }
        return this;
    }

    @Override
    public InventoryPage verifyFooterElements() {
        super.verifyFooterElements();
        return this;
    }

    public InventoryPage getAllItemsNamesAndPrice() {

        List<WebElement> itemsList = driver.findElements(By.cssSelector("div.inventory_item_description"));
        namesAndPricesOfItems = new ArrayList<>();

        for (int i = 0; i < itemsList.size(); i++) {

            String nameOfItem = itemsList.get(i).findElement(By.className("inventory_item_name")).getText();
            String priceOfItem = itemsList.get(i).findElement(By.className("inventory_item_price")).getText();

            String combineNameAndPrice = nameOfItem + ":" + priceOfItem;
            namesAndPricesOfItems.add(combineNameAndPrice);
        }
        return this;
    }
}
