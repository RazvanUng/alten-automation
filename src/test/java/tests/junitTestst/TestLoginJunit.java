package tests.junitTestst;

import org.junit.Test;
import utils.Constants;

public class TestLoginJunit extends BaseClassJunit{

    @Test
    public void loginSite(){
        System.out.println("Here we do the login");
        driver.navigate().to(Constants.URL_BASED+"/user/login");
    }
}
