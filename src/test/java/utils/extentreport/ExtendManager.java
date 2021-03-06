package utils.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.Platform;

import java.io.File;
import java.sql.Timestamp;

public class ExtendManager {

    private static ExtentReports extentReports;
    private static Platform platform;
    private static Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    private static String reportFilename = "Test_Automation_Report_" +timestamp.getTime() +".html";
    private static String windowsPath = System.getProperty("user.dir") + " \\TestReport";
    private static String winReportFileLocation = windowsPath + "\\" + reportFilename;

    private static ExtentReports getInstance() {
        if (extentReports == null) {
            createInstance();
        }
        return extentReports;
    }

    public static ExtentReports createInstance() {
        String filename = getReportLocation();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filename);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().getChartVisibilityOnOpen();
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(filename);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(filename);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        return extentReports;
    }

    private static String getReportLocation() {
        String reportLocation = null;
        reportLocation = winReportFileLocation;
        createReportPath(windowsPath);
        System.out.println("Report location is " + windowsPath);
        return reportLocation;
    }

    private static void createReportPath(String windowsPath) {
        File dir = new File(windowsPath);
        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println("folder was created");
            } else {
                System.out.println("folder not created");
            }
        } else {
            System.out.println("The folder already exists");
        }

    }
}