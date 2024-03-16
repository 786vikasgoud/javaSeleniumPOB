package Pages;

import net.bytebuddy.implementation.bytecode.Throw;
import org.example.Exception.ElementNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SearchProduct_Page {
    WebDriver driver;

    public SearchProduct_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@id='twotabsearchtextbox']")
    WebElement searchbox;
    @FindBy(how = How.XPATH, using = "//input[@id='nav-search-submit-button']")
    WebElement searchbtn;
    @FindBy(how = How.XPATH, using = "//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[5]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h2[1]/a[1]")
    WebElement productLink;

    @FindBy(how = How.XPATH, using = "//li[@id='size_name_1']")
    WebElement gbSelect;

    @FindBy(how = How.XPATH, using = "//input[@id='buy-now-button']")
    WebElement addToCard;


    public void productSelect(String str) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        searchbox.sendKeys(str);
        searchbtn.click();
        productLink.click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        try {
            if (windowHandles.size() >= 2) {
                driver.switchTo().window(windowHandles.get(1));
                driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
                gbSelect.click();
                Thread.sleep(5000);
                addToCard.click();
                driver.close();
                driver.switchTo().window(windowHandles.get(0));
                System.out.println("product order sucessful");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

