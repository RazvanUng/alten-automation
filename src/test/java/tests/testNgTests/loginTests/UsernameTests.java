package tests.testNgTests.loginTests;

import org.testng.annotations.Test;
import tests.testNgTests.BaseClass;
import utils.Constants;

public class UsernameTests extends BaseClass {

    //Username with more than maximum length
    @Test
    public void usernameMoreMaxLength(){
        // go to authentication page
        driver.get(Constants.URL_BASED2+ "/#/login");
        //verify that the login page is displayed
        //assert that the "Authentication text is present on the text"

        //Insert into the username filed more than maximum number of characters allowed
        //Identify the username field and input a random string with more than 8 characters

        //verify that there is an error on the page related to the max length of the username exceeded
        //Grab the error message from the page and assert that it is correct
    }
    @Test
    public void usernameExactMinLength() {
    // go to authentication page
    driver.get(Constants.URL_BASED2+ "/#/login");

    //verify that the login page is displayed
    //assert that the "Authentication text is present on the text"

    //Insert into the username field is exact the min length (3 characters)
    //Identify the username field in the page and insert a random string with length 3

    //Verify that there are no errors related to the minimum length of the username
     //Grab the error message from the username field if exists and check that is not the error message related with min length
}

    @Test

    public void usernameLessMinLength(){
        // go to authentication page
        driver.get(Constants.URL_BASED2+ "/#/login");

        //verify that the login page is displayed
        //assert that the "Authentication text is present on the text"

        //Insert into the username field less than then number of minimum characters allowed
        //Identify the username field in the page and insert a random string with length 2

        //The application responds with an error that the number of characters are less than minimum
        //Grab the error message from the username field and verify that the message is correct
    }

    @Test

    public void usernameMaxLength(){
        // go to authentication page
        driver.get(Constants.URL_BASED2+ "/#/login");

        //verify that the login page is displayed
        //assert that the "Authentication text is present on the text"


        //Insert into the username filed the max number of character
        //Identify the username field in the pasge and insert a random string with length 8

        //If the username is invalid there is an error generated. No errors generated for username length
        //Grab the error message (if any) from the username field and assert that the message is not related with max length
    }
    @Test
    public void usernameMoreThanMaxLength(){
        // go to authentication page
        driver.get(Constants.URL_BASED2+ "/#/login");

        //verify that the login page is displayed
        //assert that the "Authentication text is present on the text"

        //Insert into the username field more than the  max number of character
        //Identify the username field in the pasge and insert a random string with more than 9 characters

        //Verify that there is an error on the page related to the max length of the username exceeded
        //Grab the error message from the page and assert that it is correct


    }

    @Test
    public void usernameSpecialCharacters(){
        // go to authentication page
        driver.get(Constants.URL_BASED2+ "/#/login");

        //verify that the login page is displayed
        //assert that the "Authentication text is present on the text"

        //In the username field insert a random string between 3 and 8 chars than contains special chars
        //Identify the username field , generate a random string with special chars and input in the field

        //There is an error related with the fact that spcial characters are not allowed
        //Grab the error message from the username field and assert that the message is correct
    }

    @Test
    public void usernameWithAlphaNumeric(){
        // go to authentication page
        driver.get(Constants.URL_BASED2+ "/#/login");

        //verify that the login page is displayed
        //assert that the "Authentication text is present on the text"

        //In the username field insert a random string between 3-8 chars that contain both alphanumerical and numerical characters
        //Identify the username field, generate a random string with numerical and alphanumerical characters

        //There is an error related with the fact the numerical chars are not allowed
        //Grab the error message from the username field and assert that the message is correct
    }

    @Test
    public void usernameNull(){
        // go to authentication page
        driver.get(Constants.URL_BASED2+ "/#/login");

        //verify that the login page is displayed
        //assert that the "Authentication text is present on the text"

        //In the username field do not insert any chars
        //Identify the username field, clear if chars are present, assert that the length of the input is 0

        //There is an error related with the fact that null input is not allowed
        //Grab the error message for the username field and assert that ht message is correct

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
