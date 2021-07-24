package tests.testNgTests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.Log;

import static utils.BrowserUtilis.getDriver;
import static utils.Constants.CURRENT_BROWSER;
import static utils.Constants.URL_BASED;

public class BaseClass {
   public WebDriver driver;

    @BeforeClass
    public void beforeAllTests(){
        Log.info("Running before tests");
       // ConfigReader.readConfigFile();
    }



    @BeforeMethod

    public void beforeTest() {
        System.out.println("This surely runs each time before any test!!");
        //  WebDriver driver = new ChromeDriver();
        driver = getDriver(CURRENT_BROWSER);
       // driver.navigate().to(URL_BASED);
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("Runs after tests");
        if (driver != null) {
            driver.close();
        }
    }

    @AfterClass

    public void afterAllTests(){
        Log.info("AFTER CLASS EXECUTION");
    }
}
