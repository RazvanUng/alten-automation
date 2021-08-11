package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static utils.Constants.CURRENT_ENV;
import static utils.Constants.DRIVERS_PATH;

public class BrowserUtilis {

    //only for reference -> this is deprecated
    public static Browsers getBrowsers(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox": {
                return Browsers.FIREFOX;
            }
            case "chrome": {
                return Browsers.CHROME;
            }
            case "edge": {
                return Browsers.EDGE;
            }
            default: {
                throw new IllegalArgumentException("Browser not supported");
            }
        }
    }

    private static boolean isWebDriverManagerRun() {
        if(ConfigReader.WEB_DRIVER_MANAGER){
            return true;
        }
        if (Constants.CURRENT_ENV.toLowerCase().equals("local")) {
            Log.debug("Running on environment" + CURRENT_ENV + " with WebDriverManager");
            return true;
        } else {
            Log.debug("Running on environment" + CURRENT_ENV + " with System propety of the browser");
            return false;
        }
    }

    public static WebDriver getDriver(String browser) {
        WebDriver driver = null;
        switch (browser.toLowerCase()) {
            case "chrome": {
                if (isWebDriverManagerRun()) {
                    WebDriverManager.chromedriver().setup();
                } else {
                    System.setProperty("webdriver.chrome.driver", DRIVERS_PATH + "chromedriver.exe");
                }
                ChromeOptions chromeOptions = new ChromeOptions();
                /*how to add an extension(careful on headless)*/
               // chromeOptions.addExtensions(new File(Constants.EXTENSIONS_PATH+"extension_9_8_3_0.crx"));
                /*start browser maximized*/
                chromeOptions.addArguments("--start-maximized");


                /*le ruleaza in background fara a mai deschide browserul*/
                chromeOptions.setHeadless(true);

                //chromeOptions.addArguments("--headeless");-> acelasi lucru


                /*change download default directory*/
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("downloa.default_directory", Constants.DOWNLOAD_PATH);
                chromeOptions.setExperimentalOption("prefs", prefs);

                //trebuie sa punem optiunile cand instantiem chromeDriverul
                //mereu instantierea driverului la final
                driver = new ChromeDriver(chromeOptions);
                break;
            }


            case "firefox": {
                if (isWebDriverManagerRun()) {
                    WebDriverManager.firefoxdriver().setup();
                } else {
                    System.setProperty("webdriver.firefox.driver", DRIVERS_PATH + "geckodriver.exe");
                }
                FirefoxProfile firefoxProfile = new FirefoxProfile();

                /* add extensions*/

                firefoxProfile.addExtension(new File(Constants.EXTENSIONS_PATH+"metamask-9.8.2-an+fx.xpi"));

                /*Deprecated*/
                //DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                //desiredCapabilities.setCapability(FirefoxDriver.PROFILE,firefoxProfile);

                FirefoxOptions firefoxOptions = new FirefoxOptions();

                /* start maximized*/
                firefoxOptions.addArguments(("--start-maximized"));


                /* change download default directory*/

                firefoxProfile.setPreference("browser.download.dir",Constants.DOWNLOAD_PATH);
                firefoxOptions.setProfile(firefoxProfile);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
            case "edge": {
                if (isWebDriverManagerRun()) {
                    WebDriverManager.edgedriver().setup();
                } else {
                    System.setProperty("webdriver.edge.driver", DRIVERS_PATH + "msedgedriver.exe");
                }

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability("args","['start-maximized']");

                driver = new EdgeDriver();
                break;
            }
            default: {
                Log.fatal("Illegal argument for browser "+browser );

                throw new IllegalArgumentException("The value provided for the browser type is illegal: " + browser);
            }
        }
        Log.info("The current browser running is " + browser);
        return driver;
    }
}
