Feature: Scenarios to test sauceDemo page

  Scenario Outline: Verify logout after login with valid credentials

    Given User is on login page
    And User enters "<userName>", "<passWord>" and clicks on login button
    And User is redirected to Inventory Page
    When User selects "<productName>"
    And User click on logout
    Then User logs out and should be redirected to the login page

    Examples:
      | userName      | passWord     | productName |
      | standard_user | secret_sauce | Sauce Labs Backpack|


  Scenario Outline: Verify footer and social media icons

    Given User is on login page
    And User enters "<userName>", "<passWord>" and clicks on login button
    And User is redirected to Inventory Page
    When User verifies Twitter, Facebook, Linkedin and Privacy text are in Footer
    And User selects "<productName>"
    And User verifies Twitter, Facebook, Linkedin and Privacy text are in Footer
    Then User click on logout

    Examples:
      | userName      | passWord     | productName |
      | standard_user | secret_sauce | Sauce Labs Backpack|


