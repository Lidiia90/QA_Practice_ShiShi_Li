package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import static helpers.PropertiesReader.getProperty;
import static java.sql.DriverManager.getDriver;

public class HomePageRu extends BasePage{

    public HomePageRu(WebDriver driver){
        setDriver(driver);
        driver.get(getProperty("data.properties", "url_ru"));
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
    @FindBy(xpath = "//a[@class='small button']")
    WebElement btnLogin;

    public LoginPageRu navigateToLoginPage() {
        btnLogin.click();
        return new LoginPageRu(driver);
    }
}