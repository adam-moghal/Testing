import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

@FindBy(css = "#lst-ib")
private WebElement searchBar;
@FindBy(css = "#rso > div:nth-child(1) > div > div:nth-child(2) > div > div > h3 > a")
private WebElement siteLink;


public void setSearchBar(String search){

    searchBar.sendKeys(search);
}

public void websitelink(){

    siteLink.click();
}
}
