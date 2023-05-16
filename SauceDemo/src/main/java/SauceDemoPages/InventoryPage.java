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

    public InventoryPage selectPriceFilter(String filter) {
        WebElement filterButton = driver.findElement(By.cssSelector(".product_sort_container"));
        filterButton.sendKeys(filter);
        return this;
    }

    public InventoryPage verifyFilterIsApplied(String filter) {

        List<WebElement> inventoryItemsPrice = driver.findElements(By.cssSelector("div.inventory_item_price"));

        if (filter.equals("Price (low to high)")) {
            for (int i = 0; i < inventoryItemsPrice.size() - 1; i++) {

                double currentItemPrice = Double.parseDouble(inventoryItemsPrice.get(i).getText().replace("$", ""));
                double nextItemPrice = Double.parseDouble(inventoryItemsPrice.get(i + 1).getText().replace("$", ""));

                if (currentItemPrice > nextItemPrice) {
                    throw new RuntimeException("Items are not sorted from Low to High Price");
                }

            }
        } else if (filter.equals("Price (high to low)")) {
            for (int i = 0; i < inventoryItemsPrice.size() - 1; i++) {

                double currentItemPrice = Double.parseDouble(inventoryItemsPrice.get(i).getText().replace("$", ""));
                double nextItemPrice = Double.parseDouble(inventoryItemsPrice.get(i + 1).getText().replace("$", ""));

                if (currentItemPrice < nextItemPrice) {
                    throw new RuntimeException("Items are not sorted from High to Low Price");
                }
            }
        } else {
            throw new RuntimeException("Please select another filter");
        }

        return this;
    }

    @Override
    public InventoryPage verifyFooterElements() {
        super.verifyFooterElements();
        return this;
    }

    public InventoryPage setAllProductsInListByNamesAndPrices() {

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
