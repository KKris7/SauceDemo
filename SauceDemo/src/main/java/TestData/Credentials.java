package TestData;

import org.testng.annotations.DataProvider;

public class Credentials {
    private final String userName = "standard_user";
    private final String password = "secret_sauce";
    private final String productName = "Sauce Labs Backpack";
    private final String lowToHigh = "Price (low to high)";
    private final String highToLow = "Price (high to low)";

    @DataProvider(name = "TestDataUser")
    public Object[][] getUser()
    {
        Object[][] data = {{userName, password}};
        return data;
    }

    @DataProvider(name = "TestDataUserAndProduct")
    public Object[][] getUserAndProduct()
    {
        Object[][] data = {{userName, password,productName}};
        return data;
    }

    @DataProvider(name = "TestDataUserAndFilter")
    public Object[][] getUserAndFilter()
    {
        Object[][] data = {{userName, password,lowToHigh,highToLow}};
        return data;
    }
}
