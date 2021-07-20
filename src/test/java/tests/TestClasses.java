package tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Browsers;

import static utils.BrowserUtilis.getDriver;
import static utils.Constants.CURRENT_BROWSER;
import static utils.Constants.URL_BASED;

public class TestClasses {

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

    @Test
    public void Test01() {
        System.out.println("This is my very first test");


    }

 //   @Test
//    public void Test02() {
//        System.out.println("Firefox driver");
//        WebDriver driver = getDriver("firefox");
//        driver.navigate().to(URL_BASED);
//        driver.close();
//    }
//
//    @Test
//    public void Test03() {
//        System.out.println("Edge driver");
//        WebDriver driver = getDriver("edge");
//        driver.navigate().to(URL_BASED);
//        driver.close();
//    }

    @Test
    public void Test02(){
        System.out.println("The second test");

        //IDENTIFY TO SEACH BUTTON PLACE A STRING AND HIT RUN
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
