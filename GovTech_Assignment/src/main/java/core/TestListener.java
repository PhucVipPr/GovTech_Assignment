package core;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public static ThreadLocal<TestResult> testResultLocal = new ThreadLocal<>();
    @Override
    public void onTestSuccess(ITestResult result) {
        testResultLocal.get().setResult("PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        testResultLocal.get().setResult("FAILED");
    }

    @Override
    public void onStart(ITestContext context) {
        TestResult testResult = new TestResult();
        String tcid = context.getName();

        testResult.setTCID(tcid);

        testResultLocal.set(testResult);
    }

    @Override
    public void onFinish(ITestContext context) {
        BaseTest.testResultList.add(testResultLocal.get());
    }
}
