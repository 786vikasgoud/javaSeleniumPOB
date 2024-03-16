package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddToCardPage {

    WebDriver driver;
    public AddToCardPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH,using = "//button[@id='a-autoid-4-announce']")WebElement addToCart;
    @FindBy(how = How.XPATH,using = "//a[@id='nav-cart']")WebElement cartMenu;
    @FindBy(how = How.XPATH,using = "//input[@name='proceedToRetailCheckout']")WebElement ProcedToPay;

    public void add_to_cart(){
        addToCart.click();
        cartMenu.click();
        ProcedToPay.click();
        System.out.println("Checked the addtoCard");
    }

}
