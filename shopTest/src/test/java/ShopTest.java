import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.List;

public class ShopTest {

    private JavascriptExecutor js;
    private static ExtentReports report;
    private ExtentTest test;
    private SpreadSheetReader spreadSheetReader;
    private WebDriver webDriver;

    private List<String> rowString;


    @BeforeClass
    public static void init() {
        report = new ExtentReports();
        String fileName = "DraggableReport" + ".html";
        String filePath = System.getProperty("user.dir")
                + File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));

    }

    @Before
    public void setUp() {

        webDriver = new ChromeDriver();
        test = report.createTest("Draggable Test");
        test.log(Status.INFO, "Test is starting ");
        // spreadSheetReader = new SpreadSheetReader((System.getProperty("user.dir") + File.separatorChar + "properties.xlsx"));
        //rowString = spreadSheetReader.readRow(0, "Sheet1");
    }

    @After
    public void tearDown() {
        // webDriver.quit();
    }

    @AfterClass
    public static void cleanUp() {
        report.flush();
    }


    @Test
    public void loginTest(){


    }
//webdriver factory - change internet browser

}
