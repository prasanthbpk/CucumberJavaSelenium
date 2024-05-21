Feature: Login

  Scenario: Login with Valid Credentials
    Given User Launch Chrome Browser
    When User Opens Url as "https://admin-demo.nopcommerce.com/login"
    And User Enters Email as "admin@yourstore.com" and Password as "admin"
    And Click in Login
    Then Page Title Should be "Dashboard / nopCommerce administration"
    When User click on Logout Link
    Then Page Title Should be "Your store. Login"
    And Close Browser