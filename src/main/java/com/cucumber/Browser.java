package com.cucumber;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser{
    final Logger logger = Logger.getLogger(Browser.class);
    public enum browsers{gc,ie,ff,edge}
    WebDriver driver;

    public WebDriver open(String browser_name) {
        logger.info("Inside getDriver() method::");
        if (browser_name.equalsIgnoreCase(browsers.gc.toString())){
            logger.debug("opening chrome browser:::");
            System.setProperty("webdriver.chrome.driver","E:\\Softwares\\Selenium\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browser_name.equalsIgnoreCase(browsers.ie.toString())){
            logger.debug("Opening IE browser....");
            System.setProperty("webdriver.ie.driver","E:\\Softwares\\Selenium\\drivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();

        }else if (browser_name.equalsIgnoreCase(browsers.ff.toString())){
            logger.debug("Opening Firefox browser");
            System.setProperty("webdriver.gecko.driver","E:\\Softwares\\Selenium\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if (browser_name.equalsIgnoreCase(browsers.edge.toString())){
            logger.debug("Opening edge browser....");
            System.setProperty("webdriver.edge.driver","E:\\Softwares\\Selenium\\drivers\\MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        }else{
            logger.error("Please enter browser name like gc,id,ff,edge and try again..");
        }

        driver.manage().window().maximize();
        return driver;
    }
}
