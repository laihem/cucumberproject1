package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.fail;

public class EbayAdvancedSearch_Steps {
    WebDriver driver;
    public EbayAdvancedSearch_Steps(Common_Steps cs){
        this.driver = cs.getDriver();
    }
    @Given("I am Ebay Advanced Search Page")
    public void i_am_ebay_advanced_search_page() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/sch/ebayadvsearch");

    }
    @When("I click on Ebay Logo")
    public void i_click_on_ebay_logo() {
        driver.findElement(By.id("gh-logo")).click();
    }
    @Then("I am navigated to Ebay Home Page")
    public void i_am_navigated_to_ebay_home_page() {
        String expUrl = "https://www.ebay.com/";
        String actUrl = driver.getCurrentUrl();
        if(!expUrl.equals(actUrl)){
            fail("Does not navigate to expected page.");
        }
//        driver.quit();

    }

}
