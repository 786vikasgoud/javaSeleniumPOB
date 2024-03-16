package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignOutPage {

    WebDriver driver;
    public SignOutPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(how = How.XPATH,using = "//a[@id='nav-hamburger-menu']")
    WebElement dropdownMenu;
    @FindBy(how = How.LINK_TEXT ,using= "Sign Out")WebElement sign_Out;

    public void setSign_Out(){
        System.out.println("lougout");
        dropdownMenu.click();
        sign_Out.click();
    }

}
