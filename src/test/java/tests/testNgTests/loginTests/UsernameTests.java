package tests.testNgTests.loginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.testNgTests.BaseClass;
import tests.testNgTests.loginTests.models.AccountModel;
import utils.Constants;
import utils.GeneralUtils;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class UsernameTests extends BaseClass {

    //page factoring design pattern -> find element before we use it

    String authTextSelector ="#root > div > div.content > div > div:nth-child(1) > div > div > h1 > small";
    String usernameLabelSelector ="#login-form > div:nth-child(1) > label";
    String passwordLabelSelector ="#login-form > div.form-group.row.row-cols-lg-true > label";
    String usernameInputSelector ="input-login-username";
    String passwordInputSelector ="input-login-password";
    String submitButtonSelector ="#login-form > div:nth-child(3) > div.text-left.col-lg > button";
    String userErrorSelector ="#login-form > div:nth-child(1) > div > div > div.text-left.invalid-feedback";
    String passErrorSelector ="#login-form > div.form-group.row.row-cols-lg-true > div > div > div.text-left.invalid-feedback";
    String generalErrorSelector ="#login-form > div:nth-child(3) > div:nth-child(1)";


    //Username with more than maximum length
//    @Test
//    public void usernameMoreMaxLength(){
//        // go to authentication page
//        driver.get(Constants.URL_BASED2+ "/#/login");
//        //verify that the login page is displayed
//        WebElement usernameLabel = driver.findElement(By.cssSelector("#login-form > div:nth-child(1) > label"));
//        WebElement passwordLabel = driver.findElement(By.cssSelector("#login-form > div.form-group.row.row-cols-lg-true > label"));
//        Assert.assertEquals(usernameLabel.getText(),"Username");
//        Assert.assertEquals(passwordLabel.getText(),"Password");
//
//        //assert that the "Authentication text is present on the text"
//        WebElement authBanner = driver.findElement(By.cssSelector("#root > div > div.content > div > div:nth-child(1) > div > div > h1 > small"));
//        Assert.assertEquals(authBanner.getText(), "Authentication");
//
//
//
//        //Insert into the username filed more than maximum number of characters allowed
//        //Identify the username field and input a random string with more than 8 characters
//        WebElement usernameInput = driver.findElement(By.id("input-login-username"));
//        WebElement passwordInput = driver.findElement(By.id("input-login-password"));
//
//        usernameInput.clear();
//        passwordInput.clear();
//
//        usernameInput.sendKeys(GeneralUtils.getRandomStringByLength(9));
//        passwordInput.sendKeys(GeneralUtils.getRandomStringByLength(9));
//
//        //verify that there is an error on the page related to the max length of the username exceeded
//        //Grab the error message from the page and assert that it is correct
//
//        WebElement usernameError = driver.findElement(By.cssSelector("#login-form > div:nth-child(1) > div > div > div.text-left.invalid-feedback"));
//        Assert.assertEquals(usernameError.getText(),"Username exceeded maximum length");
//    }
//    @Test
//    public void usernameExactMinLength() {
//        // go to authentication page
//        driver.get(Constants.URL_BASED2+ "/#/login");
//        //verify that the login page is displayed
//        WebElement usernameLabel = driver.findElement(By.cssSelector("#login-form > div:nth-child(1) > label"));
//        WebElement passwordLabel = driver.findElement(By.cssSelector("#login-form > div.form-group.row.row-cols-lg-true > label"));
//        Assert.assertEquals(usernameLabel.getText(),"Username");
//        Assert.assertEquals(passwordLabel.getText(),"Password");
//
//        //assert that the "Authentication text is present on the text"
//        WebElement authBanner = driver.findElement(By.cssSelector("#root > div > div.content > div > div:nth-child(1) > div > div > h1 > small"));
//        Assert.assertEquals(authBanner.getText(), "Authentication");
//
////Insert into the username filed more than maximum number of characters allowed
//        //Identify the username field and input a random string with more than 8 characters
//        WebElement usernameInput = driver.findElement(By.id("input-login-username"));
//        WebElement passwordInput = driver.findElement(By.id("input-login-password"));
//
//        usernameInput.clear();
//        passwordInput.clear();
//
//        usernameInput.sendKeys(GeneralUtils.getRandomStringByLength(3));
//        passwordInput.sendKeys(GeneralUtils.getRandomStringByLength(8));
//
//    //Verify that there are no errors related to the minimum length of the username
//     //Grab the error message from the username field if exists and check that is not the error message related with min length
//        WebElement usernameError = driver.findElement(By.cssSelector("#login-form > div:nth-child(1) > div > div > div.text-left.invalid-feedback"));
//        Assert.assertEquals(usernameError.getText(),"");
//}
//
//    @Test
//
//    public void usernameLessMinLength(){
//        // go to authentication page
//        driver.get(Constants.URL_BASED2+ "/#/login");
//        //verify that the login page is displayed
//        WebElement usernameLabel = driver.findElement(By.cssSelector("#login-form > div:nth-child(1) > label"));
//        WebElement passwordLabel = driver.findElement(By.cssSelector("#login-form > div.form-group.row.row-cols-lg-true > label"));
//        Assert.assertEquals(usernameLabel.getText(),"Username");
//        Assert.assertEquals(passwordLabel.getText(),"Password");
//
//        //assert that the "Authentication text is present on the text"
//        WebElement authBanner = driver.findElement(By.cssSelector("#root > div > div.content > div > div:nth-child(1) > div > div > h1 > small"));
//        Assert.assertEquals(authBanner.getText(), "Authentication");
//
////Insert into the username filed more than maximum number of characters allowed
//        //Identify the username field and input a random string with more than 8 characters
//        WebElement usernameInput = driver.findElement(By.id("input-login-username"));
//        WebElement passwordInput = driver.findElement(By.id("input-login-password"));
//
//        usernameInput.clear();
//        passwordInput.clear();
//
//        usernameInput.sendKeys(GeneralUtils.getRandomStringByLength(2));
//        passwordInput.sendKeys(GeneralUtils.getRandomStringByLength(8));
//
//        //Verify that there is an error related to the minimum characters allowed for minimum characters
//        //Grab the error message from the username field if exists and check that is not the error message related with min length
//        WebElement usernameError = driver.findElement(By.cssSelector("#login-form > div:nth-child(1) > div > div > div.text-left.invalid-feedback"));
//        Assert.assertEquals(usernameError.getText(),"Username below minimum characters");
//    }
//
//    @Test
//
//    public void usernameMaxLength(){
//        // go to authentication page
//        driver.get(Constants.URL_BASED2+ "/#/login");
//        //verify that the login page is displayed
//        WebElement usernameLabel = driver.findElement(By.cssSelector("#login-form > div:nth-child(1) > label"));
//        WebElement passwordLabel = driver.findElement(By.cssSelector("#login-form > div.form-group.row.row-cols-lg-true > label"));
//        Assert.assertEquals(usernameLabel.getText(),"Username");
//        Assert.assertEquals(passwordLabel.getText(),"Password");
//
//        //assert that the "Authentication text is present on the text"
//        WebElement authBanner = driver.findElement(By.cssSelector("#root > div > div.content > div > div:nth-child(1) > div > div > h1 > small"));
//        Assert.assertEquals(authBanner.getText(), "Authentication");
//
////Insert into the username filed maximum number of characters allowed
//        //Identify the username field and input a random string with more than 8 characters
//        WebElement usernameInput = driver.findElement(By.id("input-login-username"));
//        WebElement passwordInput = driver.findElement(By.id("input-login-password"));
//
//        usernameInput.clear();
//        passwordInput.clear();
//
//        usernameInput.sendKeys(GeneralUtils.getRandomStringByLength(8));
//        passwordInput.sendKeys(GeneralUtils.getRandomStringByLength(8));
//
//        //Verify that there are no errors related to the maximum length of the username
//        //Grab the error message from the username field if exists and check that is not the error message related with min length
//        WebElement usernameError = driver.findElement(By.cssSelector("#login-form > div:nth-child(1) > div > div > div.text-left.invalid-feedback"));
//        Assert.assertEquals(usernameError.getText(),"");
//    }

    //    @Test
//    public void usernameSpecialCharacters(){
//        // go to authentication page
//        driver.get(Constants.URL_BASED2+ "/#/login");
//
//        //verify that the login page is displayed
//        //assert that the "Authentication text is present on the text"
//
//        //In the username field insert a random string between 3 and 8 chars than contains special chars
//        //Identify the username field , generate a random string with special chars and input in the field
//
//        //There is an error related with the fact that spcial characters are not allowed
//        //Grab the error message from the username field and assert that the message is correct
//    }

//    @Test
//    public void usernameWithAlphaNumeric(){
//        // go to authentication page
//        driver.get(Constants.URL_BASED2+ "/#/login");
//
//        //verify that the login page is displayed
//        //assert that the "Authentication text is present on the text"
//
//        //In the username field insert a random string between 3-8 chars that contain both alphanumerical and numerical characters
//        //Identify the username field, generate a random string with numerical and alphanumerical characters
//
//        //There is an error related with the fact the numerical chars are not allowed
//        //Grab the error message from the username field and assert that the message is correct
//    }

//    @Test
//    public void usernameNull(){
//        // go to authentication page
//        driver.get(Constants.URL_BASED2+ "/#/login");
//
//        //verify that the login page is displayed
//        //assert that the "Authentication text is present on the text"
//
//        //In the username field do not insert any chars
//        //Identify the username field, clear if chars are present, assert that the length of the input is 0
//
//        //There is an error related with the fact that null input is not allowed
//        //Grab the error message for the username field and assert that ht message is correct
//
//    }

    @DataProvider(name ="UsernameDataProvider")
    public Iterator<Object[]> usernameData(){
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[]{"9","Username exceed maximum length","1"});
        dp.add(new String[]{"3","","1"});
        dp.add(new String[]{"2","Username below minimum number of characters","1"});
        dp.add(new String[]{"8","","1"});
        dp.add(new String[]{"8","Username does not allow special characters","4"});
        dp.add(new String[]{"8", "Username does not allow alphanumeric characters","6"});
        dp.add(new String[]{"0","Username is required!","1"});
        return dp.iterator();

    }

    //numele trebuie sa fie identic cu numele de sus sau care il asociaza
    //numarul de parametri de la data provideri sa fie identic cu nr parametrilor functiei din test

    /**
     *  TestMaxLength
     *  TestMinLength
     *   TestMoreThanMaxLength
     *   TestLessThanMinLength
     *   TestUsernameSpecialCharacters
     *   TestUsernameSpecialCharacters
     *   TestNullCharacters
     */

    @Test(dataProvider = "UsernameDataProvider")
    public void testUsernameLength(String lengthString, String errorMessage, String charsetType){
        System.out.println(lengthString+" "+errorMessage);

        // go to authentication page
        driver.get(Constants.URL_BASED2+ "/#/login");
        //verify that the login page is displayed
        WebElement usernameLabel = driver.findElement(By.cssSelector(usernameLabelSelector));
        WebElement passwordLabel = driver.findElement(By.cssSelector(passwordLabelSelector));
        Assert.assertEquals(usernameLabel.getText(),"Username");
        Assert.assertEquals(passwordLabel.getText(),"Password");

        //assert that the "Authentication text is present on the text"
        WebElement authBanner = driver.findElement(By.cssSelector(authTextSelector));
        Assert.assertEquals(authBanner.getText(), "Authentication");

//Insert into the username filed maximum number of characters allowed
        //Identify the username field and input a random string with number of characters from dataProvider
        WebElement usernameInput = driver.findElement(By.id(usernameInputSelector));
        WebElement passwordInput = driver.findElement(By.id(passwordInputSelector));

        usernameInput.clear();
        passwordInput.clear();

        usernameInput.sendKeys(GeneralUtils.getRandomStringByLength(Integer.parseInt(lengthString),Integer.parseInt(charsetType)));
      passwordInput.sendKeys(GeneralUtils.getRandomStringByLength(8,5));

       System.out.println(passwordInput.getText());

        //Verify that there are no errors related to the maximum length of the username
        //Grab the error message from the username field if exists and check the error message related to each test
        WebElement usernameError = driver.findElement(By.cssSelector(generalErrorSelector));
        Assert.assertEquals(usernameError.getText(),errorMessage);

    }
    /* sunt 8 teste pentru fiecare caz de autentificare*/
    @DataProvider(name ="authenticationDataProvider")
    public Iterator<Object[]> authDataProvider(){
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[]{"dinosaur", "dinosaurpassword","",""," "});
        dp.add(new String[]{"dingo", "dingopassword","",""," "});
        dp.add(new String[]{"camel", "camelpassword","",""," "});
        dp.add(new String[]{"zebra", "zebrapassword","",""," "});
        dp.add(new String[]{"8","8","","","Account does not exist"});
        dp.add(new String[]{"0","8","Username is required!",""," "});
        dp.add(new String[]{"8","0","","Password is required!"," "});
        dp.add(new String[]{"0","0","Username is required!","Password is required!"," "});



        return dp.iterator();
    }

    @Test(dataProvider = "authenticationDataProvider")
    public void authTests(String username, String password, String userError, String passwordError, String generalError){
        // go to authentication page
        driver.get(Constants.URL_BASED2+ "/#/login");
        //verify that the login page is displayed
        WebElement usernameLabel = driver.findElement(By.cssSelector(usernameLabelSelector));
        WebElement passwordLabel = driver.findElement(By.cssSelector(passwordLabelSelector));
        Assert.assertEquals(usernameLabel.getText(),"Username");
        Assert.assertEquals(passwordLabel.getText(),"Password");

        //assert that the "Authentication text is present on the text"
        WebElement authBanner = driver.findElement(By.cssSelector(authTextSelector));
        Assert.assertEquals(authBanner.getText(), "Authentication");

        //Identify the username and password fields and submit button
        WebElement usernameInput = driver.findElement(By.id(usernameInputSelector));
        WebElement passwordInput = driver.findElement(By.id(passwordInputSelector));
        WebElement submitButton = driver.findElement(By.cssSelector(submitButtonSelector));

        //clear the input and populate the data
        usernameInput.clear();
        usernameInput.sendKeys(GeneralUtils.determineInputData(username));
        passwordInput.clear();
        passwordInput.sendKeys(GeneralUtils.determineInputData(password));

        submitButton.submit();

        //verify the username and password errors
        WebElement usernameErrorText = driver.findElement(By.cssSelector(userErrorSelector));
        WebElement passwordErrorText = driver.findElement(By.cssSelector(passErrorSelector));

        Assert.assertEquals(usernameErrorText.getText(),userError);
        Assert.assertEquals(passwordErrorText.getText(),passwordError);



        //submit the data and verify general message
        WebElement generalErrorText = driver.findElement(By.cssSelector("#login-form > div:nth-child(3) > div:nth-child(1)"));
        Assert.assertEquals(generalErrorText.getText(), generalError);

//        AccountModel accountModel = new AccountModel("aaa","bbb");
//        accountModel.getUsername();



    }





    @Test
    public void usernameRegistered(){
        // go to authentication page
        driver.get(Constants.URL_BASED2+ "/#/login");

        //verify that the login page is displayed
        //assert that the "Authentication text is present on the text"

        //Input a registered username without any password
        //Identify the username and password fields and input in the username field a registered user
        //clear the password field and assert that the lenght is 0
        //Grab the error message from the username (if any) and assert that the message is correct
    }

    @Test
    public void usernameUnregistered(){
        // go to authentication page
        driver.get(Constants.URL_BASED2+ "/#/login");

        //verify that the login page is displayed
        //assert that the "Authentication text is present on the text"

        //Input an unregistred username without any password
        //Identify the username and password fields and input in the username field a unregistered user
        //clear the password field and assert that the lenght is 0
        //Grab the error message from the username (if any) and assert that the message is correct - user not exists
    }

}
