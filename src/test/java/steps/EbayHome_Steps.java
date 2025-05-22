package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

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

    @When("I search for {string}")
    public void i_serach_for_iphone11(String item) {
       driver.findElement(By.id("gh-ac")).sendKeys(item);
        driver.findElement(By.id("gh-search-btn")).click();

    }


    @When("I serach for {string} in {string} category")
    public void iSerachForSoapInBaByCategory(String str1, String str2) {
        driver.findElement(By.xpath("//*[@id='gh-ac']")).sendKeys(str1);
        driver.findElement(By.xpath("//select[@id='gh-cat']")).click();
        List<WebElement> cat =  driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
        for(WebElement el : cat){
            if(el.getText().trim().equals(str2)){
                el.click();
                break;
            }
        }
    }
    @Then("I validate at least {int} search items present")
    public void i_validate_atleast_search_items_present(int count) throws InterruptedException {
        Thread.sleep(3000);
//        //h1[contains(@class, 'srp-controls__count-heading')]
        String itemCount = driver.findElement(By.cssSelector("h1.srp-controls__count-heading span.BOLD:first-child")).getText().trim();
        String itemCount2 = itemCount.replace(",", "");
        int itemCountInt = Integer.parseInt(itemCount2);

        if(itemCountInt <= count){
            fail("Less than 1000 results shown");
        }
//        driver.quit();
    }

    @When("I click on {string}")
    public void i_click_on(String string) throws InterruptedException {
        driver.findElement(By.linkText(string)).click();
        Thread.sleep(3000);
    }

    @Then("I validate that page navigates to {string} and title contains {string}")
    public void i_validate_that_page_navigates_to_and_title_contains(String url, String title) {
        String actuTitle = driver.getTitle();
        String actUrl = driver.getCurrentUrl();

        if(!actUrl.equals(url)){
            fail("Page does not navigate to expected url: " + url);
        }

        if(actuTitle.equals((title))){
            fail("title mismatch!");
        }
        }


}
