package tests.junitTestst;

import org.junit.*;

public class TestClasses  extends BaseClassJunit{




    @Test(expected = IllegalArgumentException.class)
    public void Test01() {
        System.out.println("This is my very first test");
        String s ="Alex";
        Assert.assertEquals(s, "Alex");
        int a = 20; int b = 30;
        Assert.assertEquals("Comparing the sum",50,a+b);
        Assert.assertNotNull("Exista obiectul nostru?", s);
        doSomething();



    }

    private void doSomething() throws IllegalArgumentException{
        throw new IllegalArgumentException("Illegal");
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
