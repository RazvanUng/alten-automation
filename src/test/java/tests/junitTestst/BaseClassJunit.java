package tests.junitTestst;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import static utils.BrowserUtilis.getDriver;
import static utils.Constants.CURRENT_BROWSER;
import static utils.Constants.URL_BASED;

public class BaseClassJunit  {
    WebDriver driver;

    @BeforeClass
    //trebuie sa le facem statice ca ruleaza o singura data
    public static void beforeClass(){
        System.out.println("This runs just once before all tests in the same class");
    }



    @Before

    public void beforeTest() {
        System.out.println("This surely runs each time before any test!!");
        //  WebDriver driver = new ChromeDriver();
        driver = getDriver(CURRENT_BROWSER);
        driver.navigate().to(URL_BASED);
    }
    @After
    public void afterMethod() {
        System.out.println("This is the method to run after tests");
        if(driver!=null) {
            driver.close();
        }
    }

    @AfterClass
    //trebuie sa le facem statice ca ruleaza o singura data
    public static void afterClass(){
        System.out.println("This runs once after class");
    }

}
