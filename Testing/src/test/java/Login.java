import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

    @FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
    private WebElement username;
    @FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
    private WebElement password;

    @FindBy(css = "body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b")
    private WebElement submitInputText;


    public void setUsername(String uName) {

        username.sendKeys(uName);

    }
    public void setPassword( String uPassword) {

        password.sendKeys(uPassword);

    }

    public String getConfirmation(){
        return submitInputText.getText();
    }
}
