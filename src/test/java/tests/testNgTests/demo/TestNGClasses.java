package tests.testNgTests.demo;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.testNgTests.BaseClass;
import utils.BrowserUtilis;
import utils.Constants;
import utils.GeneralUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class TestNGClasses extends BaseClass {

    public static String searchElement = "koala";


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

    @Test
    public void Test04() {
        driver.get("https://www.google.ro/");
        //de pus "sunt de acord cu politica de confidentialitate

        WebElement agreeItems = driver.findElement(By.cssSelector("#L2AGLb > div"));
        agreeItems.click();

        //WebElement searchBox = driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf.emcav > div.RNNXgb > div > div.a4bIc > input"));
        //WebElement searchBox2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        WebElement searchBox3 = driver.findElement(By.name("q"));

        //typed koala in SearchBox
        searchBox3.sendKeys(searchElement);
        searchBox3.sendKeys(Keys.ENTER);

        //cautare link koala
        //WebElement firstLink = driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div > div.yuRUbf > a"));

        /*vom cauta doar dupa clasa noastra pentru a putea schimba searchTextul*/
        WebElement firstLink = driver.findElement(By.cssSelector("div.yuRUbf > a"));
        List<WebElement> allLinks = driver.findElements(By.cssSelector("div.yuRUbf > a"));

        System.out.println("Links on the page " + allLinks.size());
        for (WebElement link : allLinks) {
            System.out.println(link.getText());
        }
        firstLink.click();

    }

    @Test
    public void Test05() {
        driver.get(Constants.URL_BASED2);
        //implicit wait- >Asteapta pentru orice element sa se incarce in pagina maxim 10 secunde
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement waitTab = driver.findElement(By.cssSelector("#root > div > div.sidebar > a:nth-child(7)"));
        waitTab.click();

        //am ajuns pe pagina de wait si am identificat butonul si click

        WebElement buttonAnswer = driver.findElement(By.id("answer-trigger"));
        buttonAnswer.click();

        WebDriverWait wait = new WebDriverWait(driver, 15);

        // wait After text matches a pattern

        GeneralUtils.waitUntilText(driver, By.cssSelector("div.text-center.the-answer.row > div"), 15, "42");


        //luam rezultatul textului dupa waiting

        //wait until element is present on the page

        WebElement textWait = GeneralUtils.waitForGenericElement(driver, By.cssSelector("div.text-center.the-answer.row > div"), 15);
        //   WebElement textWait = driver.findElement(By.cssSelector("#root > div > div.content > div > div:nth-child(2) > div.text-center.the-answer.row > div"));
        // textWait.getText();
        System.out.println(textWait.getText());
        System.out.println(textWait.getCssValue("color"));
    }

    //buttons test
    @Test
    public void Test06() {
        driver.get(Constants.URL_BASED2);

        WebElement alertLink = driver.findElement(By.cssSelector("#root > div > div.sidebar > a:nth-child(4)"));
        alertLink.click();

        //alert button

        WebElement alertButton = driver.findElement(By.id("alert-trigger"));
        alertButton.click();
        //trebuie sa scapam de alerta pentru teste

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertTrue(alert.getText().contains("alert"));

        //a dat click pe alerta
        alert.accept();

        //confirmation button
        WebElement confirmButton = driver.findElement(By.id("confirm-trigger"));
        confirmButton.click();

        Alert confirm = driver.switchTo().alert();
        System.out.println(confirm.getText());
        Assert.assertTrue(confirm.getText().contains("confirmation"));

        confirm.dismiss();

        //prompt trigger
        WebElement promptButton = driver.findElement(By.id("prompt-trigger"));
        promptButton.click();

        Alert prompt = driver.switchTo().alert();
        System.out.println(prompt.getText());
        Assert.assertTrue(prompt.getText().contains("prompt"));

        //ii trimite inputul promptului
        prompt.sendKeys("Razvan");
        prompt.accept();


    }

    //hover test
    @Test
    public void Test07() {
        driver.get(Constants.URL_BASED2);
        //pune un timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

        WebElement hoverLink = driver.findElement(By.cssSelector("#root > div > div.sidebar > a:nth-child(6)"));
        hoverLink.click();

        WebElement hoverButton = driver.findElement(By.cssSelector("#root > div > div.content > div > div.container-table.text-center.container > div > button"));
        // hoverButton.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).build().perform();

        WebElement itemMenu = driver.findElement(By.id("Bird"));
        itemMenu.click();

        //practic aici luam rezultatul textului afisat in pagina dupa apasarea pe Bird
        WebElement resultText = driver.findElement(By.id("result"));
        System.out.println(resultText.getText());
        Assert.assertEquals(resultText.getText(), "You last clicked the Bird");
    }

    //stale element

    @Test
    public void Test08() {
        driver.get(Constants.URL_BASED2);
        WebElement staleTab = driver.findElement(By.cssSelector("#root > div > div.sidebar > a:nth-child(11)"));
        staleTab.click();

        WebElement pageText = driver.findElement(By.cssSelector("#root > div > div.content > div > div.container > div > div > h1 > small"));
        Assert.assertEquals(pageText.getText(), "Stale element (work in progress)");

        WebElement staleButton = driver.findElement(By.id("stale-button"));
        for (int i = 0; i < 100; i++) {
            staleButton.click();
        }

        System.out.println(staleButton.getText());

    }

    //modal test

    @Test
    public void Test09() {
        driver.get(Constants.URL_BASED2);
        WebElement modaltab = driver.findElement(By.cssSelector("#root > div > div.sidebar > a:nth-child(13)"));
        modaltab.click();

        WebElement modalText = driver.findElement(By.cssSelector("#root > div > div.content > div > div:nth-child(1) > div > div > h1 > small"));
        Assert.assertEquals(modalText.getText(), "Modal");

        WebElement launchModalButton = driver.findElement(By.cssSelector("#root > div > div.content > div > div.container-table.text-center.container > button"));
        launchModalButton.click();

        //click pe butonul de close
        WebElement closeModal = driver.findElement(By.cssSelector("body > div.fade.modal.show > div > div > div.modal-footer > button"));
        // closeModal.click();
        closeModal.sendKeys(Keys.ESCAPE);

        //CU ACTIONS
//        WebElement modalTitle = driver.findElement(By.cssSelector("body > div.fade.modal.show > div > div > div.modal-header > div"));
//        Actions actions = new Actions(driver);
//        actions.click(modaltab).sendKeys(Keys.ESCAPE).build().perform();

        modaltab.click();
    }


}

