package tests.testNgTests.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.testNgTests.BaseClass;
import utils.GeneralUtils;

import javax.swing.*;

public class PcGarageTest extends BaseClass {

    @Test
    public void authenticationTest(){
        driver.get("https://www.pcgarage.ro/");
        WebElement myAccount = driver.findElement(By.cssSelector("#h_account_top > a"));
        System.out.println(myAccount.getText());
        Assert.assertEquals(myAccount.getText(),"Contul meu");
        GeneralUtils.genericSleep(4000);

        myAccount.click();
        GeneralUtils.genericSleep(4000);

        //am ajuns pe site-ul de autentificare dar nu putem continua din cauza captcha
        WebElement authenticationText = driver.findElement(By.cssSelector("#auth-login-wrapper > h1"));
        Assert.assertEquals(authenticationText.getText(),"Autentificare");
    }

    @Test
    public void hoveTest(){
        driver.get("https://www.pcgarage.ro/");
        WebElement componente = driver.findElement(By.cssSelector("#cat_3 > a"));
        //hover cu actions
        GeneralUtils.genericSleep(4000);
        Actions actions = new Actions(driver);
        actions.moveToElement(componente).build().perform();

        GeneralUtils.genericSleep(4000);

        WebElement placiVideo = driver.findElement(By.cssSelector("#subcats_3 > div.menu_row > div:nth-child(1) > a:nth-child(1)"));
        placiVideo.click();

        GeneralUtils.genericSleep(4000);

        WebElement placiVideoText = driver.findElement(By.cssSelector("#category_name > h1 > b"));
        System.out.println(placiVideoText.getText());
        Assert.assertEquals(placiVideoText.getText(),"Placi video");
    }
}
