import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class testClass {

    private JavascriptExecutor js;
    private static ExtentReports report;
    private ExtentTest test;
    private SpreadSheetReader spreadSheetReader;
    private List<String> rowString;

    private WebDriver webDriver;


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

    @Ignore
    public void testDraggable() {
        Integer initialXPos;
        Integer initialYPos;
        Draggable demoHome = PageFactory.initElements(webDriver, Draggable.class);

        webDriver.manage().window().maximize();
        webDriver.navigate().to("http://demoqa.com/draggable");
        test.log(Status.INFO, "Link clicked ");


        try {
            test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "screenShot Before Draggable"), "Screenshot before element moved");
        } catch (IOException e) {
            e.printStackTrace();
        }

        initialXPos = demoHome.getDraggableX();
        test.log(Status.DEBUG, "New X Pos: " + initialXPos.toString());
        initialYPos = demoHome.getDraggableY();
        test.log(Status.DEBUG, "New Y Pos: " + initialYPos.toString());

        Actions builder = new Actions(webDriver);

        //builder.dragAndDropBy(demoHome.draggable, 200, 50).build().perform();
        builder.moveToElement(demoHome.draggable).clickAndHold().moveByOffset(50, 50).release().perform();

        test.log(Status.DEBUG, "Element Dragged " + demoHome.draggable);
        test.log(Status.DEBUG, "New X Pos: " + demoHome.getDraggableX());
        test.log(Status.DEBUG, "New Y Pos: " + demoHome.getDraggableY());
        try {
            test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "screenShot After Draggable"), "Screenshot After element moved");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //assert initialXPos&&InitialYPos != draggable current XYPos
        Assert.assertTrue("Result not expected", demoHome.getDraggableX() != initialXPos);
    }

    @Ignore
    public void testContrain() {
        Draggable demoHome = PageFactory.initElements(webDriver, Draggable.class);


        webDriver.manage().window().maximize();
        webDriver.navigate().to("http://demoqa.com/draggable");
        demoHome.clickConstrainMovementLink();
        test.log(Status.INFO, "clcked on constrain movement link");

        try {
            test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "screenShot Before Constrain"), "Screenshot before elements moved");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Actions builder = new Actions(webDriver);
        //builder.dragAndDropBy(demoHome.draggable, 200, 50).build().perform();
        builder.moveToElement(demoHome.constrainedX).clickAndHold().moveByOffset(0, 100).release().perform();
        builder.moveToElement(demoHome.constrainedY).clickAndHold().moveByOffset(100, 0).release().perform();

        try {
            test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "screenShot After Constrain"), "Screenshot before elements moved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Ignore
    public void testDraggableSortable() {
        Draggable demoHome = PageFactory.initElements(webDriver, Draggable.class);

        webDriver.manage().window().maximize();
        webDriver.navigate().to("http://demoqa.com/draggable");
        demoHome.clickDraggableSortableLink();
        test.log(Status.INFO, "clcked on draggable sortable link");

//        try {
//            test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "screenShot Before draggableSortable"), "Screenshot before elements moved");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Actions builder = new Actions(webDriver);
        builder.moveToElement(demoHome.item2Draggable).clickAndHold().moveByOffset(0, 30).release().perform();
        //      builder.moveToElement(demoHome.item1Draggable).clickAndHold().moveByOffset(0, 70).release().perform();



    }

    @Test
    public void testSlider(){
        Draggable demoHome = PageFactory.initElements(webDriver, Draggable.class);

        webDriver.manage().window().maximize();
        webDriver.navigate().to("http://demoqa.com/slider" );
        Actions builder = new Actions(webDriver);

        builder.moveToElement(demoHome.slider).clickAndHold().moveByOffset(150, 0).release().perform();

    }
}
