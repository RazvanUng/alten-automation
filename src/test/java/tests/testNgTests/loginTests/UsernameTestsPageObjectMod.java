package tests.testNgTests.loginTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.testNgTests.BaseClass;
import tests.testNgTests.loginTests.models.LoginModel;
import tests.testNgTests.loginTests.pages.LoginPage;
import utils.Constants;
import utils.GeneralUtils;
import utils.Log;

import java.io.File;
import java.io.IOException;
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
    @DataProvider(name = "jsonDp")
    public Iterator<Object[]> jsonDp(){
        Collection<Object[]>dp = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        File f = new File("src\\test\\resources\\dataFiles\\testdata.json");
        try {
            LoginModel loginModel = mapper.readValue(f,LoginModel.class);
            //citeste din fisier un loginModel
            dp.add(new Object[] {loginModel});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dp.iterator();
    }

    @Test(dataProvider = "jsonDp")
    public void jsonTest(LoginModel loginModel){
      //  System.out.println(loginModel.getAccount().getUsername());
       // System.out.println(loginModel.getAccount().getPassword());
        String username = loginModel.getAccount().getUsername();
        String password = loginModel.getAccount().getPassword();
        driver.get(Constants.URL_BASED2+"#/login");
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.login(username, password);
        loginPage.validateErrors(loginModel.getUserError(), loginModel.getPasswordError(), loginModel.getGeneralError());

    }
}
