import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register {

    @FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
    private WebElement signInButton;

    @FindBy(css = "#submitAccount")
    private WebElement registerButton;

    @FindBy(css = "#email_create")
    private WebElement setEmail;

    @FindBy(css = "#passwd")
    private WebElement setPassword;

    @FindBy(css = "#SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(css = "#id_gender1")
    private WebElement genderRadioButton;

    @FindBy(css = "#customer_firstname")
    private WebElement setName;

    @FindBy(css = "#customer_lastname")
    private WebElement lastName;

    @FindBy(css = "#address1")
    private WebElement setAddress;

    @FindBy(css = "#city")
    private WebElement setCity;

    @FindBy(css = "#postcode")
    private WebElement setPostcode;

    @FindBy(css = "#phone_mobile")
    private WebElement setphonenumber;



    public void signInButtonClicked(){

        signInButton.click();
    }
    public void registerButtonClicked(){

        registerButton.click();
    }

    public void setEmail(String emaill){

        setEmail.sendKeys(emaill);
    }

    public void setPassword(String password){

        setPassword.sendKeys(password);
    }
    public void createAccountButtonClicked(){

        createAccountButton.click();
    }

    public void genderRadioButtonClicked(){

        genderRadioButton.click();
    }

    public void setName(String name){

        setName.sendKeys(name);
    }

    public void setLastName(String lName){


        lastName.sendKeys(lName);
    }

    public void setAddress(String address){

        setAddress.sendKeys(address);

    }

    public void setCity(String city){

        setCity.sendKeys(city);

    }
    public void setPostcode(String postcode){

        setPostcode.sendKeys(postcode);

    }
    public void setPhoneNumber(String phoneNumber){

        setphonenumber.sendKeys(phoneNumber);

    }
}
