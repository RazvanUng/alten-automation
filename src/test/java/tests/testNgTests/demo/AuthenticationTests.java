package tests.testNgTests.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tests.testNgTests.BaseClass;

public class AuthenticationTests  extends BaseClass {

    @Test
    public void authenticationTest01(){
        driver.get("http://86.121.249.150:4999/#/login");

        //going to the authentification page
        WebElement loginPage = driver.findElement(By.cssSelector("#root > div > div.sidebar > a:nth-child(2)"));
        loginPage.click();

        //identify elements by page
        WebElement username = driver.findElement(By.id("input-login-username"));
        WebElement password = driver.findElement(By.id("input-login-password"));
        WebElement submitButton = driver.findElement(By.cssSelector("#login-form > div:nth-child(3) > div.text-left.col-lg > button"));

        //introduce a valid username and password too see if it is working
        username.clear();
        username.sendKeys("dinosaur");
        password.clear();
        password.sendKeys("dinosaurpassword");

        //daca avem buton de tip submit in pagina atunci e bine sa punem .submit()
        submitButton.submit();
    }
}
