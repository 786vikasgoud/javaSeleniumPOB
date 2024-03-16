package TestClasses.Index;

import Pages.AddToCardPage;
import Pages.LoginPage;
import Pages.SearchProduct_Page;
import Pages.SignOutPage;
import org.example.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class test {
    ConfigReader configRead=new ConfigReader();
    WebDriver driver;

    @BeforeSuite
    public void testBefore(){

        System.setProperty("webdriver.chrome.driver","/home/vikas/IdeaProjects/selenium_EndToEnd_Testinng/src/main/resources/chromedriver");
        driver=new ChromeDriver();
        driver.get(configRead.webUrl());
        driver.manage().window().maximize();
    }
    @AfterSuite
    public void testAfter(){
        driver.quit();
    }

    @Test
    public void lanchLogin() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        SearchProduct_Page Search_product_page=new SearchProduct_Page(driver);
        SignOutPage sign_out_page=new SignOutPage(driver);
        AddToCardPage add_cart=new AddToCardPage(driver);

        boolean result=loginPage.setLoginIn(configRead.user(),configRead.password());
        assert result == true;
        if(result){
            System.out.println("successfully login");
        }
        else {
            System.out.println("not logined sucessfully");
        }
        Search_product_page.productSelect(configRead.productName());
        add_cart.add_to_cart();
        sign_out_page.setSign_Out();
    }

}
