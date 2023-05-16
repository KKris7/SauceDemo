package WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class WebDriverProvider {

    public static WebDriver getWebDriverInstance(String browserName) {

        WebDriver driver;

        if (browserName.contains("Chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        } else if (browserName.contains("Edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();

        }  else
            throw new RuntimeException("Browser Name is not Correct or Not Supported right now " + browserName);
        return driver;
    }

}
