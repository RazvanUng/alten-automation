package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.BrowserUtilis;
import utils.Constants;

public class TestNGClasses {

    WebDriver driver;

    //echivalentul lui @Before din Junit
    @BeforeMethod
    public void beforeTests(){
        System.out.println("Before tests");
        driver = BrowserUtilis.getDriver(Constants.CURRENT_BROWSER);
        driver.get(Constants.URL_BASED);
    }

    @BeforeClass
    public void beforeAllTests(){
        System.out.println("BEFORE CLASS EXECTUION");
    }

    @Test

    public void Test01(){
        System.out.println("My very first testNG test");
    }

    @Test
    public void Test02(){
        System.out.println("My second testNG test");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Runs after tests");
        driver.close();
    }

    @AfterClass

    public void afterAllTests(){
        System.out.println("AFTER CLASS EXECUTION");
    }


}

