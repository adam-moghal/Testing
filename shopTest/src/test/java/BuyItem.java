import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuyItem {

    @FindBy (css = "#block_top_menu > ul > li:nth-child(1) > ul > li:nth-child(1) > ul > li:nth-child(2) > a")
    private WebElement blouse;



    public void selectBlouse(){

        blouse.click();
    }
}
