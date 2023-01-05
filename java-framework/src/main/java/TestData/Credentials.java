package TestData;

import org.testng.annotations.DataProvider;

public class Credentials {
    private String userName = "standard_user";
    private String pwd = "secret_sauce";
    private String productName = "Sauce Labs Backpack";

    @DataProvider(name = "TestData")
    public Object[][] getData()
    {
        Object[][] data = {{userName,pwd,productName}};
        return data;
    }
}
