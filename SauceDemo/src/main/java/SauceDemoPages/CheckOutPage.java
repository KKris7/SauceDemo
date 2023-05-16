package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends CommonSections {

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    private CheckOutPage enterFirstName(String firstName) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        return this;
    }

    private CheckOutPage enterLastName(String lastName) {
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        return this;
    }

    private CheckOutPage enterPostCode(String postCode) {
        driver.findElement(By.id("postal-code")).sendKeys(postCode);
        return this;
    }

    public void continueButton() {
        driver.findElement(By.name("continue")).click();
    }

    public CheckOutOverviewPage confirmYourInformation(String firstName, String lastName, String postCode) {
        enterFirstName(firstName).enterLastName(lastName).enterPostCode(postCode).continueButton();
        return new CheckOutOverviewPage(driver);
    }

    @Override
    public CheckOutPage verifyFooterElements() {
        super.verifyFooterElements();
        return this;
    }
}
