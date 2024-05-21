package StepDefinitions;

import PageObjects.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_Steps {

    public WebDriver driver;
    public LoginPage lp;

    @Given("User Launch Chrome Browser")
    public void user_launch_chrome_browser() {
        driver = new ChromeDriver();
        lp= new LoginPage(driver);
//        driver.get("https://admin-demo.nopcommerce.com/login");
//        driver.manage().window().maximize();


    }
    @When("User Opens Url as {string}")
    public void user_opens_url_as(String url) {
        driver.get(url);
        driver.manage().window().maximize();

    }
   /*@When("User Opens Url as {string} ")
    public void user_opens_url(String url)
        {

    }
*/
    /*@When("User Opens Url")
    public void user_opens_url() {
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
    }*/

    @When("User Enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        lp.setUserName(email);
        lp.setPassword(password);
    }
    @When("Click in Login")
    public void click_in_login() {
        lp.clickLogin();
    }
   @Then("Page Title Should be {string}")
    public void page_title_should_be(String title) {
        if (driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            Assert.assertTrue(false);
        }
        else {
            System.out.println(driver.getTitle());
            Assert.assertEquals(title, driver.getTitle());
        }
    }
/*@Then("Page Title Should be {string}")
public void page_title_should_be(String title) throws InterruptedException {
    Thread.sleep(3000);
    System.out.println(driver.getTitle());
    Assert.assertEquals(title, driver.getTitle());
}*/

    @When("User click on Logout Link")
    public void user_click_on_logout_link() throws InterruptedException {
        lp.clickLogout();
        Thread.sleep(3000);
    }
    @And("Close Browser")
    public void close_browser() {
        driver.close();
    }

}
