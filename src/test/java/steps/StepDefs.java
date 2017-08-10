package steps;

import com.cucumber.Browser;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pom.ebay.Homepage;
import pom.ebay.Searchpage;

public class StepDefs {
    final Logger logger = Logger.getLogger(StepDefs.class);
    WebDriver driver;
    //Browser browser;

    @Before
    public void setup(){
        //browser = new Browser();
       driver = new Browser().open("ff");
    }

    @After
    public void teardown(){
        driver.quit();
    }
    @Given("^user on home page \"([^\"]*)\"$")
    public void user_on_home_page(String url) throws Throwable {
        logger.info("Inside user_on_home_page() method::");
        Homepage homepage = PageFactory.initElements(driver,Homepage.class);
        homepage.go_to_ebay_home_page(url);
        logger.info("Page Title:::"+driver.getTitle());
    }

    @When("^user enter search term \"([^\"]*)\"and click on search button$")
    public void user_enter_search_term_and_click_on_search_button(String searchterm) throws Throwable {
        logger.info("Inside user_enter_search_term_and_click_on_search_button() method::");
        Searchpage searchpage = PageFactory.initElements(driver,Searchpage.class);
        searchpage.search_for_product(searchterm);
        driver.getPageSource().contains(searchterm);
        //System.out.println("Search for iphone 6s plus");
    }

    @Then("^user should see search results$")
    public void user_should_see_search_results() throws Throwable {
        logger.info("Inside user_should_see_search_results()::");
        driver.getPageSource().contains("iphone 6s");
    }

    @And("user can select product from results")
    public void select_product_from_results(){
        logger.info("Inside select_product_from_results() method:::");
        Searchpage searchpage = PageFactory.initElements(driver,Searchpage.class);
        searchpage.select_product_from_results();
    }
}
