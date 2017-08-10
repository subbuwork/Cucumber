package pom.ebay;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Homepage {
    final Logger logger = Logger.getLogger(Homepage.class);

      WebDriver webDriver;

      public Homepage(WebDriver driver){
          this.webDriver = driver;
      }


      public void go_to_ebay_home_page(String url){
          logger.info("Inside go_to_ebay_home_page() method:::"+logger.getName());
          webDriver.get(url);
      }
}
