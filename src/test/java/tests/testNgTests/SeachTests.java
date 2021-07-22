package tests.testNgTests;

import org.testng.annotations.Test;
import utils.BrowserUtilis;
import utils.Constants;

public class SeachTests extends BaseClass {

    @Test
    public void searchTests(){
        System.out.println("Here we do the search test");
        driver.get(Constants.URL_LOGIN_EMAG);
    }
}
