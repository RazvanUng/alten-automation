package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Set;
import java.util.regex.Pattern;

public class GeneralUtils {

    public static String stackTraceConvert(Object[] obj) {
        StringBuilder output = new StringBuilder();
        for (Object o : obj) {
            output.append(o.toString());
            output.append("\n");
        }
        return output.toString();
    }

    public static void printCookies(WebDriver driver) {
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie c : cookies) {
            System.out.println("Cookie name:" + c.getName());
            System.out.println("---Cookie value " + c.getValue());
            System.out.println("--->Domain " + c.getDomain());
            System.out.println("--->Expires " + c.getExpiry());
            System.out.println();

        }
        System.out.println("Number of cookies " + cookies.size());
    }

    //method for searching if a cookie with specific name is specific in a browser
    public static boolean checkCookieName(WebDriver driver, String cookieName) {
        Set<Cookie> cookies = driver.manage().getCookies();
        boolean found = false;
        for (Cookie c : cookies) {
            if (c.getName().toLowerCase().equals(cookieName.toLowerCase())) {
                found = true;
            }
        }
        return found;
    }

    //taking a screenshot

    public static void takeScreenshot(WebDriver driver) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //  File screenshotFile = new File(Constants.SCREENSHOT_PATH + "screenshot_"+timestamp.getTime()+ ".png");
        //identic cu codul de mai sus
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.SCREENSHOT_PATH);
        sb.append("screenshot_");
        sb.append(timestamp.getTime());
        sb.append(".png");
        File screenshotFile = new File(sb.toString());
        File capturedFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(capturedFile, screenshotFile);

        } catch (IOException ex) {
            System.out.println("Screenshot cannot be saved on the disk");
        }
    }

    public static void genericSleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Generic wait function
    public static WebElement waitForGenericElement(WebDriver driver, By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //Generic wait until specific text appear on the site

    public static boolean waitUntilText(WebDriver driver, By by, int timeout, String pattern) {
        Pattern r2 = Pattern.compile("42", 0);
        WebDriverWait wait = new WebDriverWait(driver, timeout);


        // wait After text matches a pattern
        return wait.until
                (ExpectedConditions.textMatches(by, r2));
    }

    public static String getRandomStringByLength(int length, int charsetType) {
        StringBuilder stringBuilder = new StringBuilder();
        String charsetLowerCase = "abcdefghijklmnoprstuvwxyz";
        String charsetUpperCase = charsetLowerCase.toUpperCase();
        String charsetNumbers = "0123456789";
        String charsetSpecialCharacters = "!@#$%()-+_";

        for (int i = 0; i < length; i++) {
            char randomChar = charsetLowerCase.charAt((int) (Math.random() * (charsetLowerCase.length() - 1)));
            stringBuilder.append(randomChar);
        }

        // intre 5 ->10 : 5+ Math.random() *5
        //intre x->y : x+ Math.random() * (y-x)
        String defaultCharcase = charsetLowerCase;
        switch (charsetType) {
            case 1: {
                defaultCharcase = charsetLowerCase;
                break;
            }
            //uppercase
            case 2: {
                defaultCharcase = charsetUpperCase;
                break;
            }
            //numbers
            case 3: {
                defaultCharcase = charsetNumbers;
                break;
            }
            //specialChars
            case 4: {
                defaultCharcase = charsetSpecialCharacters;
                break;
            }
            //all cases
            case 5: {
                defaultCharcase = charsetLowerCase + charsetUpperCase + charsetNumbers + charsetSpecialCharacters;
                break;
            }
            case 6: {
                defaultCharcase = charsetLowerCase + charsetNumbers;
                break;
            }
            default:
                System.out.println("Only 5 options allowed");
        }


        return stringBuilder.toString();

    }

    public static String determineInputData(String username) {
        String user = "";
        String pass = "";

        try {
            int usernameLength = Integer.parseInt(username);
            user = getRandomStringByLength(usernameLength, 1);
        } catch (NumberFormatException exception) {
            user = username;
        }
        return user;
    }

    public static String sanitizeNullString (String dbString){
        if(dbString ==null){
            return "";
        }
        return dbString;
    }
}