import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExample {

    private String url = "http://www.google.co.uk";
    private WebDriver webDriver;


    @Before
    public void setUp() {

        webDriver = new ChromeDriver();
    }

    @After
    public void tearDown() {
           webDriver.quit();
    }

    @Test
    public void qaTest() {
        webDriver.manage().window().maximize();
        webDriver.navigate().to(url);
        WebElement searchBar = webDriver.findElement(By.cssSelector("#lst-ib"));
        searchBar.sendKeys("thedemosite \n" );
     // webDriver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div > div > h3 > a"));
        WebElement theDemoSiteLink = webDriver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div:nth-child(2) > div > div > h3 > a"));
        theDemoSiteLink.click();

        WebElement registerLink = webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)"));
        registerLink.click();

        WebElement username = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
        username.sendKeys("adammoghal");

        WebElement password = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
        password.sendKeys("manchester");

        WebElement registerButtonLink = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
        registerButtonLink.click();

        WebElement loginLink = webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)"));
        loginLink.click();

        WebElement usernameLogin = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
        usernameLogin.sendKeys("adammoghal");

        WebElement passwordLogin = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
        passwordLogin.sendKeys("manchester");

        WebElement profileLink = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
        profileLink.click();

        String currentURL = webDriver.getCurrentUrl();
        String expectedUrl = "http://thedemosite.co.uk/login.php";
        Assert.assertEquals(expectedUrl,currentURL);
    }
}
