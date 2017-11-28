import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class testClass {
   private JavascriptExecutor js;

private WebDriver webDriver;
    @BeforeClass
    public static void init() {


    }

    @Before
    public void setUp() {

        webDriver = new ChromeDriver();
        if(webDriver instanceof JavascriptExecutor){
            js = (JavascriptExecutor)webDriver;
        }
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @AfterClass
    public static void cleanUp() {


    }

    @Test
    public void test(){

        webDriver.manage().window().maximize();
        webDriver.navigate().to("http://thedemosite.co.uk");


    }
}
