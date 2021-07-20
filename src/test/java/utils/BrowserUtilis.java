package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

import static utils.Constants.DRIVERS_PATH;

public class BrowserUtilis {

    //only for reference -> this is deprecated
//    public static Browsers getBrowsersOld(String browser){
//        switch (browser.toLowerCase()){
//            case"firefox":{
//                return Browsers.FIREFOX;
//            }
//            case"chrome":{
//                return Browsers.CHROME;
//            }
//            case "edge":{
//                return Browsers.EDGE;
//            }
//            default:{
//                throw new IllegalArgumentException("Browser not supported");
//            }
//        }
//    }

    public static WebDriver getDriver(String browser) {
        WebDriver driver = null;
        switch (browser.toLowerCase()) {
            case "chrome": {
                if (Constants.CURRENT_ENV.equals("local")) {
                    //TODO :continue environment selection at the automation env course!
                    WebDriverManager.chromedriver().setup();
                } else {
                    System.setProperty("webdriver.chrome.driver", DRIVERS_PATH + "chromedriver.exe");
                }
                driver = new ChromeDriver();
                break;
            }


            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            case "edge": {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            }
            default: {
                throw new IllegalArgumentException("The value provided for the browser type is illegal: " + browser);
            }
        }
        return driver;
    }
}
