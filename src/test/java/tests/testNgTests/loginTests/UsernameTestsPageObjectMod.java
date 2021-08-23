package tests.testNgTests.loginTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.Result;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.testNgTests.BaseClass;
import tests.testNgTests.loginTests.models.AccountModel;
import tests.testNgTests.loginTests.models.LoginModel;
import tests.testNgTests.loginTests.pages.LoginPage;
import utils.Constants;
import utils.ExcelReader;
import utils.GeneralUtils;
import utils.Log;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;

public class UsernameTestsPageObjectMod extends BaseClass {

    @DataProvider(name = "UsernameDataProvider")
    public Iterator<Object[]> usernameData() {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[]{"9", "Username exceed maximum length", "1"});
        dp.add(new String[]{"3", "", "1"});
        dp.add(new String[]{"2", "Username below minimum number of characters", "1"});
        dp.add(new String[]{"8", "", "1"});
        dp.add(new String[]{"8", "Username does not allow special characters", "4"});
        dp.add(new String[]{"8", "Username does not allow alphanumeric characters", "6"});
        dp.add(new String[]{"0", "Username is required!", "1"});
        return dp.iterator();

    }


    @Test
    public void basicAuthTest() {
        driver.get(Constants.URL_BASED2 + "/#/login");
        //Page factory line actually initializes all the web elements from the page
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login("zebra", "zebrapassword");
    }

    @Test(dataProvider = "UsernameDataProvider")
    public void authUserLengthTest(String length, String userError, String charsetType) {
        driver.get(Constants.URL_BASED2 + "/#/login");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        // Assert.assertTrue(loginPage.checkCurrentPage());
        String generateUsername = GeneralUtils.getRandomStringByLength(Integer.parseInt(length), Integer.parseInt(charsetType));
        String generatePassword = GeneralUtils.getRandomStringByLength(8, 5);
        loginPage.login(generateUsername, generatePassword);
        loginPage.validateUserError(userError);


    }

    @DataProvider(name = "jsonDp")
    public Iterator<Object[]> jsonDp() {
        Collection<Object[]> dp = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        File f = new File("src\\test\\resources\\dataFiles\\testdata.json");
        try {
            LoginModel loginModel = mapper.readValue(f, LoginModel.class);
            //citeste din fisier un loginModel
            dp.add(new Object[]{loginModel});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dp.iterator();
    }

    @Test(dataProvider = "jsonDp")
    public void jsonTest(LoginModel loginModel) {
        //  System.out.println(loginModel.getAccount().getUsername());
        // System.out.println(loginModel.getAccount().getPassword());
        String username = loginModel.getAccount().getUsername();
        String password = loginModel.getAccount().getPassword();
        driver.get(Constants.URL_BASED2 + "#/login");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login(username, password);
        loginPage.validateErrors(loginModel.getUserError(), loginModel.getPasswordError(), loginModel.getGeneralError());

    }

    private LoginModel readModel(File f) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(LoginModel.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (LoginModel) unmarshaller.unmarshal(f);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /*xml*/
    @DataProvider(name = "xmlDataProvider")
    public Iterator<Object[]> xmlDp() {
        Collection<Object[]> dp = new ArrayList<>();
        File f = new File("src\\test\\resources\\dataFiles\\testdata.xml");
        LoginModel loginModel = readModel(f);
        dp.add(new Object[]{loginModel});
        return dp.iterator();
    }

    @Test(dataProvider = "xmlDataProvider")
    public void xmlTest(LoginModel loginModel) {
        String username = loginModel.getAccount().getUsername();
        String password = loginModel.getAccount().getPassword();
        //ne conectam la server
        driver.get(Constants.URL_BASED2 + "#/login");
        //ne logam
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        //folosim credentialele de username si password ptr login
        loginPage.login(username, password);
        //verificam mesajele de eroare cu functia de validateErros din LoginPage
        loginPage.validateErrors(loginModel.getUserError(), loginModel.getPasswordError(), loginModel.getGeneralError());
    }

    /*csv*/
    @DataProvider(name = "csvDataProvider")
    public Iterator<Object[]> csvDp() {
        Collection<Object[]> dp = new ArrayList<>();

        try {
            File f = new File("src\\test\\resources\\dataFiles\\testdata.csv");
            Reader reader = Files.newBufferedReader(Paths.get(f.getAbsolutePath()));
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> csvData = csvReader.readAll();
            //practiclina csv e un vector de stringuri
            dp.addAll(csvData);

        } catch (IOException | CsvException ioException) {
            ioException.printStackTrace();
        }

        return dp.iterator();
    }

    @Test(dataProvider = "csvDataProvider")
    public void csvTest(String username, String password, String userErr, String passErr, String generalErr) {
        driver.get(Constants.URL_BASED2 + "#/login");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login(username, password);
        loginPage.validateErrors(userErr, passErr, generalErr);
    }

    @DataProvider(name = "xlsxDataProvider")
    public Iterator<Object[]> xlsxDp() {
        Collection<Object[]> dp = new ArrayList<>();


        try {
            File f = new File("src\\test\\resources\\dataFiles\\testdata.xlsx");
            String[][] excelData = ExcelReader.readExcelFile(f, "Sheet1", true, true);
            //luam fiecare linie din excel si adaugam datele de pe fiecare linie intr-o lista
            Collections.addAll(dp, excelData);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dp.iterator();
    }

    @Test(dataProvider = "xlsxDataProvider")
    public void xlsxTest(String username, String password, String userError, String passwordError, String generalError) {
        driver.get(Constants.URL_BASED2 + "#/login");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login(username, password);
        loginPage.validateErrors(userError, passwordError, generalError);
    }

    /* Data provider with LoginModel for excel*/
    @DataProvider(name = "xlsxDataProvider2")
    public Iterator<Object[]> xlsxDp2() {
        Collection<Object[]> dp = new ArrayList<>();


        try {
            File f = new File("src\\test\\resources\\dataFiles\\testdata.xlsx");
            String[][] excelData = ExcelReader.readExcelFile(f, "Sheet1", true, true);
            //luam fiecare linie din excel si adaugam datele de pe fiecare linie intr-o lista
            for (int i = 0; i < excelData.length; i++) {
                String username = excelData[i][0];
                String password = excelData[i][1];
                String userError = excelData[i][2];
                String passwordError = excelData[i][3];
                String generalError = excelData[i][4];
                AccountModel accountModel = new AccountModel(username, password);
                LoginModel loginModel = new LoginModel(accountModel, userError, passwordError, generalError);
                dp.add(new Object[]{loginModel});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dp.iterator();
    }

    @Test(dataProvider = "xlsxDataProvider2")
    public void xlsxModelTest(LoginModel loginModel) {
        driver.get(Constants.URL_BASED2 + "#/login");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        String username = loginModel.getAccount().getUsername();
        String password = loginModel.getAccount().getUsername();
        loginPage.login(username, password);
        loginPage.validateErrors(loginModel.getUserError(), loginModel.getPasswordError(), loginModel.getGeneralError());
    }

    @DataProvider(name = "sqlDp")
    public Iterator<Object[]> sqlDp() {
        Collection<Object[]> dp = new ArrayList<>();
        String query = "SELECT * FROM altenautomation.login";

        try {
            Connection connection = DriverManager.getConnection(Constants.DB_JDBC, Constants.DB_USER, Constants.DB_PASSWORD);
            System.out.println(Constants.DB_JDBC);
            //creare de statement
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
               // int id = resultSet.getInt("id");
                String user = GeneralUtils.sanitizeNullString(resultSet.getString("username"));
                String password = GeneralUtils.sanitizeNullString(resultSet.getString("password"));
                String userError = GeneralUtils.sanitizeNullString(resultSet.getString("usernameError"));
                String passwordError = GeneralUtils.sanitizeNullString(resultSet.getString("passwordError"));
                String generalErr = GeneralUtils.sanitizeNullString(resultSet.getString("generalError"));
                AccountModel am = new AccountModel(user, password);
                LoginModel loginModel = new LoginModel(am, userError, passwordError, generalErr);
                dp.add(new Object[]{loginModel});
            }
            //close connection
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return dp.iterator();
    }
    @Test(dataProvider = "sqlDp")
    public void sqlDataTest(LoginModel loginModel){
        driver.get(Constants.URL_BASED2+"#/login");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        String username = loginModel.getAccount().getUsername();
        String password = loginModel.getAccount().getPassword();
        loginPage.login(username,password);
        loginPage.validateErrors(loginModel.getUserError(), loginModel.getPasswordError(), loginModel.getGeneralError());
    }

}
