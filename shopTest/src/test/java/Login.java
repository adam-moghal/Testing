import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

    @FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
    private WebElement signInButton;



    public void signInButtonClicked(){

        signInButton.click();
    }
}
