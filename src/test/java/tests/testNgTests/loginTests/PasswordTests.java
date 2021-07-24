package tests.testNgTests.loginTests;

import org.testng.annotations.Test;
import tests.testNgTests.BaseClass;
import utils.Constants;

public class PasswordTests extends BaseClass {

    /**
     * Verify that password is not allowed less the minimum length of 8 characaters
     */
    @Test
    public void passwordLessMin(){
        // go to authentication page
        driver.get(Constants.URL_BASED2+ "/#/login");
       //Assert that the "Authentication: text is present on the page
        //Identify the username field and input a valid user
        //Identify the password field insert a random password with 7 characters
        //Click on submit button
        //Assert that the error message received on the password field
        //


    }
    /**
     * Verifiy that password input is validated correctly with the minimum length of 8 characters
     *
     */
    @Test
    public void passwordMinLength(){
        // go to authentication page
        driver.get(Constants.URL_BASED2+ "/#/login");
        //Assert that the "Authentication: text is present on the page
        //Identify the username field and input a valid user
        //Identify the password field insert a random password with 8 characters
        //Click on submit button
        //Assert that the error message received on the password field is correct
    }
    /**
     * Verifiy that password input is validated correctly with the nax length of 20 chars
     *
     */
    @Test
    public void passwordMaxLength(){
        // go to authentication page
        driver.get(Constants.URL_BASED2+ "/#/login");
        //Assert that the "Authentication: text is present on the page
        //Identify the username field and input a valid user
        //Identify the password field insert a random password with 20 characters
        //Click on submit button
        //Assert that the error message received on the password field is correct
    }

    /**
     * Verify that password is validated correctly with more than 20 chars
     */

    @Test
    public void passwordMoreMax(){
        // go to authentication page
        driver.get(Constants.URL_BASED2+ "/#/login");
        //Assert that the "Authentication: text is present on the page
        //Identify the username field and input a valid user
        //Identify the password field insert a random password with 21 characters
        //Click on submit button
        //Assert that the error message received on the password field is correct - password exceeds maxLength
    }

    /*
    Verify that password allows special characters and alphanumeric
     */

    @Test
    public void passwordCharsetTest(){
        // go to authentication page
        driver.get(Constants.URL_BASED2+ "/#/login");
        //Assert that the "Authentication: text is present on the page
        //Identify the username field and input a valid user
        //Identify the password field insert a random password between 8-20 characters
        //Click on submit button
        //Assert that the error message is related only to the fact that the passwword invalid for the correspondant
    }

    /*
    Verify that the password does not allow null
     */

    @Test
    public void passwordNull(){
        // go to authentication page
        driver.get(Constants.URL_BASED2+ "/#/login");
        //Assert that the "Authentication: text is present on the page
        //Identify the username field and input a valid user
        //Identify the password field and clear the field
        //Assert that the length of the password is 0
        //Click on submit
        //Assert that there is an error message that is expected on the password field
    }
    /*
    Verify that the valid password / valid username combination
     */

    @Test
    public void passwordUsernameRegistered(){
        // go to authentication page
        driver.get(Constants.URL_BASED2+ "/#/login");
        //Assert that the "Authentication: text is present on the page
        //Identify the username field and input a valid user
        //Identify the password field and input a valid password
        //Click on the submit button
        //Assert that there are no errors in the page
        //Assert that the user is authenticated
    }




}
