package tests.testNgTests.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.testNgTests.BaseClass;
import utils.ConfigReader;
import utils.GeneralUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class CookieTests extends BaseClass {

    @Test
    public void cookieTest01() {
        driver.get("https://www.emag.ro/");
        GeneralUtils.printCookies(driver);

        //addong a new cookie while on the side
        Cookie c = new Cookie("razvanCookie","1234");
        driver.manage().addCookie(c);



        //adding a cookie from the start (without being on any site)

        Cookie c2 = new Cookie("cookie1","value1","emag.ro","/",new Date());

        GeneralUtils.printCookies(driver);

        //delete cookie created
        driver.manage().deleteCookie(c);

        /*delete a cookie based on its name*/
        //driver.manage().deleteCookieNamed("razvanCookie");

        /*delete all cookies*/
       // driver.manage().deleteAllCookies();
        GeneralUtils.printCookies(driver);
    }

    @Test
    public void cookieTest02(){
        driver.get("https://www.emag.ro/");
        GeneralUtils.takeScreenshot(driver);
        Set<Cookie> cookies = driver.manage().getCookies();
        //nu merge ca ia tot cu valoare si expiry etc
        Cookie loginCookie = driver.manage().getCookieNamed("EMAGVISITOR");
        System.out.println(loginCookie);
        Assert.assertEquals(loginCookie.getName(),"EMAGVISITOR");

        Assert.assertTrue(GeneralUtils.checkCookieName(driver,"EMAGVISITOR"));
    }

    @Test
    public void cookieTest03(){

        driver.get("http://86.121.249.150:4999/#/cookie");

        //elements found by id
        WebElement setCookieButton = driver.findElement(By.id("set-cookie"));
        WebElement deleteCookieButton = driver.findElement(By.id("delete-cookie"));

        System.out.println("Tag name " +setCookieButton.getTagName());
        System.out.println("Text: "+setCookieButton.getText());
        System.out.println("Tag name " +deleteCookieButton.getTagName());
        System.out.println("Text: "+deleteCookieButton.getText());

        System.out.println();

        //elements found by css selector
        WebElement cssSetCookieButton = driver.findElement(By.cssSelector("#set-cookie"));
        WebElement cssDeleteCookieButton = driver.findElement(By.cssSelector("#delete-cookie"));

        System.out.println("Tag name " +cssSetCookieButton.getTagName());
        System.out.println("Text: "+cssSetCookieButton.getText());
        System.out.println("Tag name " +cssDeleteCookieButton.getTagName());
        System.out.println("Text: "+cssDeleteCookieButton.getText());
        System.out.println();


        //elements found by tag name -> not recommented cause there are multiple tags with the same name
        WebElement tagTextSetCookieButton = driver.findElement(By.tagName("button"));
        WebElement tagTextDeleteCookieButton = driver.findElement(By.tagName("button"));
        List<WebElement> buttons =  driver.findElements(By.tagName("button"));

        System.out.println("Tag name " +tagTextSetCookieButton.getTagName());
        System.out.println("Text: "+tagTextSetCookieButton.getText());
        System.out.println("Tag name " +tagTextDeleteCookieButton.getTagName());
        System.out.println("Text: "+tagTextDeleteCookieButton.getText());
        System.out.println();



        //elements found by link-text-> aceasta nu merge, deoarece cauta dupa text
//        WebElement linkTextSetCookieButton = driver.findElement(By.linkText("Set the cookie"));
//        WebElement linkTextDeleteCookieButton = driver.findElement(By.linkText("Remove the cookie"));
//
//        System.out.println("Tag name " +linkTextSetCookieButton.getTagName());
//        System.out.println("Text: "+linkTextSetCookieButton.getText());
//        System.out.println("Tag name " +linkTextDeleteCookieButton.getTagName());
//        System.out.println("Text: "+linkTextDeleteCookieButton.getText());
//        System.out.println();

     //elements found by class name

        WebElement classNameSetCookieButton = driver.findElement(By.className("btn-success"));
        WebElement classNameDeleteCookieButton = driver.findElement(By.className("btn-danger"));

        System.out.println("Tag name " +classNameSetCookieButton.getTagName());
       // System.out.println("Text: "+classNameSetCookieButton.getText());
        System.out.println("Tag name " +classNameDeleteCookieButton.getTagName());
       // System.out.println("Text: "+classNameDeleteCookieButton.getText());
        System.out.println();
        for(WebElement button:buttons){
            System.out.println(button.getText());
        }


        setCookieButton.click();
        deleteCookieButton.click();
        System.out.println("Number of buttons find "+buttons.size());
        buttons.get(0).click();
        buttons.get(1).click();



    }

    @Test
    public void cookieTest04(){
        driver.get("http://86.121.249.150:4999/#/cookie");
        WebElement addCookieButton = driver.findElement(By.id("set-cookie"));
        WebElement deleteCookieButton = driver.findElement(By.id("delete-cookie"));
        WebElement cookieText = driver.findElement(By.id("cookie-value"));

        //check that there are no cookies present in the browser
        Set<Cookie> cookies = driver.manage().getCookies();
        Assert.assertEquals(cookies.size(), 0);

        //click on add cookie button
        addCookieButton.click();

        //get the text from the cookie text
        String cookieTextVal = cookieText.getText();

        //get the list of the cookies from the browser and check that the cookie was created in browser
        cookies = driver.manage().getCookies();
        Assert.assertEquals(cookies.size(), 1);

        GeneralUtils.printCookies(driver);

        //check that from the value list we have the cookie we searched for
        List<String> cookiesValue = new ArrayList<>();
        for(Cookie c: cookies){
           cookiesValue.add(c.getValue());
            }
        Assert.assertTrue(cookiesValue.contains(cookieTextVal));

        //delete the existing cookie

        deleteCookieButton.click();
        //get the list of the cookies from the browser
        cookies = driver.manage().getCookies();

        //check if the cookie is correctly deleted
        Assert.assertEquals(cookies.size(), 0);

        }
    }
