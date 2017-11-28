import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LoginTestPOReports {

    private String url = "http://thedemosite.co.uk/addauser.php";
    private WebDriver webDriver;
    private AddUserPage addUser;
    private LoginPage login;
    private static ExtentReports report;
    private SpreadSheetReader sSReader;
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
        sSReader = new SpreadSheetReader((System.getProperty("user.dir")+ File.separatorChar +"IOValues.xlsx"));
        rowString = sSReader.readRow(0, "Sheet1");
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
    public void qaTest() {
        ExtentTest test = report.createTest("MyFirstTest");
        test.log(Status.INFO, "My First Test is Starting - Navigating to Webpage, creating a user, navigating to login page, logging in.");
        test.log(Status.DEBUG, "Nav to create user page, create a user with superUser as username and uberPass as password. Then nav to login page and log in.");
        webDriver.navigate().to(url);
        addUser = PageFactory.initElements(webDriver, AddUserPage.class);
        String userName = rowString.get(0);
        String passWord = rowString.get(1);
        String expectedResult = rowString.get(2);
        addUser.setUserAndPass(userName, passWord);
        addUser.clickLink();
        login = PageFactory.initElements(webDriver, LoginPage.class);
        login.loginUser(userName, passWord);
        String confirmation = login.getConfirmation();
        Assert.assertEquals(expectedResult, confirmation);
        try {
            test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "screenShot"), "Screenshot of end of test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
