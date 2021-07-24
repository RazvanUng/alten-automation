package utils.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.testNgTests.BaseClass;



    public class TestListener extends BaseClass implements ITestListener{

        private static ExtentReports report = ExtendManager.createInstance();
        private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

        @Override
        public void onTestStart(ITestResult result) {
            System.out.println("Extend reports started");
            ExtentTest extentTest = report.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
            test.set(extentTest);
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            System.out.println(result.getMethod().getMethodName()+ "passed ");
            test.get().pass("Test passed");
        }

        @Override
        public void onTestFailure(ITestResult result) {
            System.out.println(result.getMethod().getMethodName()+ "failed ");
            test.get().fail(result.getThrowable());
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            System.out.println(result.getMethod().getMethodName()+ "skipped");
            test.get().fail(result.getThrowable());
        }


        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
            System.out.println("Test failed but with success percentage for "+result.getMethod().getMethodName());
        }

        @Override
        public void onTestFailedWithTimeout(ITestResult result) {
            System.out.println("Test failed with timeout for " + result.getMethod().getMethodName());
        }

        @Override
        public void onStart(ITestContext context) {
            System.out.println("Extend report started");
        }

        @Override
        public void onFinish(ITestContext context) {
            System.out.println("Extend report finished");
            report.flush();
        }
    }
