package tests.testNgTests.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.testNgTests.BaseClass;
import utils.BrowserUtilis;
import utils.Constants;

public class TestNGClasses extends BaseClass {


    @BeforeClass
    public void beforeAllTests() {
        System.out.println("BEFORE CLASS EXECTUION");
    }

    @Test

    public void Test01() {
        double a = 1.05;
        double b = 2.01;
        double sum = a + b;
        System.out.println("My very first testNG test");
        /**
         *  va da pass din cauza lui delta care e toleranta
         *  practic suma noastra trebuie sa fie in intervalul +- delta ->sum +- 0.1-> da true si test passed
         */

        Assert.assertEquals(sum, 3.01, 0.1, "Equals");
        Assert.fail("Putem noi sa dam fail la test cu aceasta comanda");
    }

    @Test
    public void Test02() {
        System.out.println("My second testNG test");
    }

    @Test
    public void Test03() {
        System.out.println("Test 03");
        //go to the specified URL
        driver.get(Constants.URL_BASED);

        //Thread.sleep is not recommended to be used in autoframework
        try {
            System.out.println("Starting to sleep");
            Thread.sleep(1000);
            System.out.println("Finished sleeping");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        //ALTERNATIVELY
        driver.navigate().to(Constants.URL_BASED);

        //click on the back button from the browser
        driver.navigate().back();
        // clock on the forward button from the browser
        driver.navigate().forward();
        //refresh clock
        driver.navigate().refresh();
    }


}

