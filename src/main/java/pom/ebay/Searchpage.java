package pom.ebay;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Searchpage {

    final Logger logger = Logger.getLogger(Searchpage.class);

    WebDriver webDriver;

    public Searchpage(WebDriver driver){this.webDriver = driver;}

    @FindBy(how = How.ID, using = "gh-ac")
    WebElement searchbox;

    @FindBy(how = How.ID, using = "gh-btn")
    WebElement searchbutton;

    @FindBy(how = How.XPATH,using="//ul[@id='ListViewInner']/li[1]/div/div/a")
    WebElement product;

    public void search_for_product(String searchterm){
        logger.info("Inside search_for_product() method...");
        searchbox.sendKeys(searchterm);
        searchbutton.click();
    }

    public void select_product_from_results(){
        product.click();
    }

}
