package tests.testNgTests.loginTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.testNgTests.BaseClass;
import tests.testNgTests.loginTests.pages.LoginPage;
import utils.Constants;
import utils.GeneralUtils;
import utils.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class UsernameTestsPageObjectMod  extends BaseClass {

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

    @Test
    public void basicAuthTest(){
        driver.get(Constants.URL_BASED2+ "/#/login");
        //Page factory line actually initializes all the web elements from the page
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.login("zebra", "zebrapassword");
    }

    @Test(dataProvider ="UsernameDataProvider")
    public void authUserLengthTest(String length, String userError, String charsetType){
        driver.get(Constants.URL_BASED2+ "/#/login");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

       // Assert.assertTrue(loginPage.checkCurrentPage());
        String generateUsername = GeneralUtils.getRandomStringByLength(Integer.parseInt(length), Integer.parseInt(charsetType));
        String generatePassword = GeneralUtils.getRandomStringByLength(8,5);
        loginPage.login(generateUsername,generatePassword);
        loginPage.validateUserError(userError);



    }
}
