package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Set;

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
}