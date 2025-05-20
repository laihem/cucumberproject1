package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.fail;

public class EbayHome_Steps {
    WebDriver driver;

    public  EbayHome_Steps(Common_Steps cs){
        this.driver = cs.getDriver();
    }

    @Given("I am on Ebay Home Page")
    public void i_am_on_ebay_home_page() {

/*       System.out.println("I am on Ebay Home Page");
        //driver = new ChromeDriver();
       //driver.manage().window().maximize(); */
        driver.get("https://www.ebay.com/");
    }

    @When("I click on Advanced link")
    public void i_click_on_advanced_link() {

        //System.out.println("I click on Advanced link");
        driver.findElement(By.linkText("Advanced")).click();
    }

    @Then("I navigate to Advanced Search page")
    public void i_navigate_to_advanced_search_page() {

        //System.out.println("I navigate to Advanced Search page");
        String expUrl = "https://www.ebay.com/sch/ebayadvsearch";
        String actUrl = driver.getCurrentUrl();
        if(!expUrl.equals(actUrl)){
            fail("Does not navigate to expected page.");
        }

    }

    @When("I serach for iPhone 11")
    public void i_serach_for_iphone11() {
       driver.findElement(By.id("gh-ac")).sendKeys("iphone 11");
        driver.findElement(By.id("gh-search-btn")).click();

    }
    @Then("I validate atleast 1000 search items present")
    public void i_validate_atleast_search_items_present() {
      String itemCount = driver.findElement(By.cssSelector("h1.srp-controls__count-heading span.BOLD:first-child")).getText().trim();
      String itemCount2 = itemCount.replace(",", "");
      int itemCountInt = Integer.parseInt(itemCount2);

      if(itemCountInt <= 1000){
          fail("Less than 1000 results shown");
      }
//        driver.quit();
    }
}
