package tests.testNgTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.BrowserUtilis;
import utils.Constants;

public class TestNGClasses extends BaseClass {



    @BeforeClass
    public void beforeAllTests(){
        System.out.println("BEFORE CLASS EXECTUION");
    }

    @Test

    public void Test01(){
        double a = 1.05;
        double b = 2.01;
        double sum = a+b;
        System.out.println("My very first testNG test");
        /**
         *  va da pass din cauza lui delta care e toleranta
         *  practic suma noastra trebuie sa fie in intervalul +- delta ->sum +- 0.1-> da true si test passed
         */

        Assert.assertEquals(sum,3.01,0.1,"Equals");
        Assert.fail("Putem noi sa dam fail la test cu aceasta comanda");
    }

    @Test
    public void Test02(){
        System.out.println("My second testNG test");
    }




}

