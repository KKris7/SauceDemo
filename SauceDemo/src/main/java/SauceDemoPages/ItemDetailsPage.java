package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemDetailsPage extends CommonSections {

    public ItemDetailsPage(WebDriver driver) {
        super(driver);
    }

    public ItemDetailsPage verifyItemDetailsPageIsOpen(String productItem) {
        String itemName = driver.findElement(By.cssSelector(".inventory_details_name.large_size")).getText();
        if (!itemName.equalsIgnoreCase(productItem))
            throw new RuntimeException("Not able to verify Item Details Page for Item with name: " + productItem);
        return this;
    }

    public ItemDetailsPage click_addToCartButton() {
        driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
        counter++;
        return this;
    }

    public ItemDetailsPage verifyItemIsAddedInCart() {
        String count = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();

        if (Integer.parseInt(count) != counter)
            throw new RuntimeException("Failed to verify Items in the Cart");
        return this;
    }

    @Override
    public ItemDetailsPage verifyFooterElements() {
        super.verifyFooterElements();
        return this;
    }

    public ItemDetailsPage verifyProductPriceOnDetailsPage(){

        String itemName = driver.findElement(By.cssSelector(".inventory_details_name.large_size")).getText();
        String itemPrice = driver.findElement(By.cssSelector(".inventory_details_price")).getText();
        String itemNameAndPrice = itemName + ":" + itemPrice;
        boolean isVerified = false;

        for (int i = 0; i < namesAndPricesOfItems.size(); i++) {
            if(namesAndPricesOfItems.get(i).equals(itemNameAndPrice)){
                isVerified = true;
                break;
            }
        }
        if (!isVerified) {
            throw new RuntimeException("Price verification on DetailsPage failed for product: " + itemName + ".\nExpected price:" + itemPrice);
        }
        return this;
    }
}
