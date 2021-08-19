package tests.testNgTests.loginTests.pages;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage {

    @FindBy(how = How.CSS, using = "#root > div > div.content > div > div:nth-child(1) > div > div > h1 > small")
    private WebElement authTextSelector;

    @FindBy(how = How.CSS, using = "#login-form > div:nth-child(1) > label")
    private WebElement usernameLabel;

    @FindBy(how = How.CSS, using = "#login-form > div.form-group.row.row-cols-lg-true > label")
    private WebElement passwordLabel;

    @FindBy(how = How.ID, using = "input-login-username")
    private WebElement usernameInput;

    @FindBy(how = How.ID, using = "input-login-password")
    private WebElement passwordInput;

    @FindBy(how = How.CSS, using = "#login-form > div:nth-child(3) > div.text-left.col-lg > button")
    private WebElement submitButtonSelector;

    @FindBy(how = How.CSS, using = "#login-form > div:nth-child(1) > div > div > div.text-left.invalid-feedback")
    private WebElement userError;

    @FindBy(how = How.CSS, using = "#login-form > div.form-group.row.row-cols-lg-true > div > div > div.text-left.invalid-feedback")
    private WebElement passError;

    @FindBy(how = How.CSS, using = "#login-form > div:nth-child(3) > div:nth-child(1)")
    private WebElement generalError;


    public void login(String username, String password) {

        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        submitButtonSelector.submit();

    }

    public boolean checkCurrentPage(){
        boolean currentPageOK = true;
      if(!authTextSelector.getText().equals("Authentication")) {
          currentPageOK = false;
      }
      if(!usernameLabel.getText().equals("Username")){
          currentPageOK = false;
      }
      if(!passwordLabel.getText().equals("Password")){
          currentPageOK = false;
      }
      return currentPageOK;
    }

    public void validateUserError(String user){
        Assert.assertEquals(userError.getText(), user);
        System.out.println(userError.getText());
    }

    public void validateErrors(String userErr, String passErr, String genError){
        //parametri trebuie sa fie diferiti ca nume ca cei globali, altfel le suprascrie
       Assert.assertEquals(userError.getText(), userErr);
       Assert.assertEquals(passError.getText(), passErr);
       Assert.assertEquals(generalError.getText(), genError);
    }

}