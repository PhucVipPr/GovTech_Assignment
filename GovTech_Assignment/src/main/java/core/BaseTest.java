package core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    private WebDriver driver;

    public static String reportPath;

    public static List<TestResult> testResultList;

    @BeforeSuite
    public void beforeSuite() throws IOException {
        testResultList = new ArrayList<>();
        reportPath = System.getProperty("user.dir")+"\\src\\main\\resources\\reports\\"+System.currentTimeMillis()+".xlsx";
        FileUtils.copyFile(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\TestResult.xlsx"),new File(reportPath));
    }

    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void afterSuite() throws IOException {
        ExcelUtils.updateTestResult(reportPath, testResultList);
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
