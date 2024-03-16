package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using = "//a[@id='nav-link-accountList']")
    WebElement SignBtn;
    @FindBy(how = How.XPATH, using = "//input[@id='ap_email']")
    WebElement email;
    @FindBy(how = How.XPATH, using = "//input[@id='continue']")
    WebElement Continue;
    @FindBy(how = How.XPATH, using = "//input[@id='ap_password']")
    WebElement password_1;
    @FindBy(how = How.XPATH, using = "//input[@id='signInSubmit']")
    WebElement signIn;


    public boolean setLoginIn(String mail, String pass) {
        try {
            SignBtn.click();
            email.sendKeys(mail);
            Continue.click();
            password_1.sendKeys(pass);
            signIn.click();
            return true;
        } catch (Exception e) {
            return false;

        }
    }

}
