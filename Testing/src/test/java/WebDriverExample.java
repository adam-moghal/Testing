import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import java.io.File;
import java.io.IOException;
import java.util.*;
public class WebDriverExample {

    private WebDriver webDriver;
    private static ExtentReports report;
    private ExtentTest test;
    private SpreadSheetReader spreadSheetReader;
    private List<String> rowString;

    @BeforeClass
    public static void init() {

        report = new ExtentReports();
        String fileName = "MyReport" + ".html";
        String filePath = System.getProperty("user.dir")
                + File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));
    }

    @Before
    public void setUp() {

        webDriver = new ChromeDriver();
        test = report.createTest("MyFirstTest");
        test.log(Status.INFO, "My First Test is Starting ");
        spreadSheetReader = new SpreadSheetReader((System.getProperty("user.dir")+ File.separatorChar +"properties.xlsx"));
        rowString = spreadSheetReader.readRow(0, "Sheet1");
    }

    @After
    public void tearDown() {
         webDriver.quit();
    }

    @AfterClass
    public static void cleanUp() {
        report.flush();
    }

    @Test
    public void goToWebsite() {

        webDriver.manage().window().maximize();
        webDriver.navigate().to("http://thedemosite.co.uk");

        HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
        Website theDemoSite = PageFactory.initElements(webDriver, Website.class);
        Login login = PageFactory.initElements(webDriver, Login.class);

        WebElement registerLink = webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)"));
        registerLink.click();

        String username = rowString.get(0);
        String password = rowString.get(1);
        String expectedResult = rowString.get(2);

        theDemoSite.setUsername(username);
        theDemoSite.setPassword(password);

        test.log(Status.DEBUG, "username: " + username);
        test.log(Status.DEBUG, "password: " + password);
        test.log(Status.INFO, "set the username to " + username + " and password to " + password);

        WebElement registerButtonLink = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
        registerButtonLink.click();
        test.log(Status.INFO, "Registered new user");

        WebElement loginLink = webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)"));
        loginLink.click();
        login.setUsername(username);
        login.setPassword(password);


        WebElement profileLink = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
        profileLink.click();
        test.log(Status.INFO, "Login successful");
        String confirmation = login.getConfirmation();

        Assert.assertEquals(expectedResult, confirmation);

        try {
            test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "screenShot"), "Screenshot of end of test");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
