package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static helpers.PropertiesReader.getProperty;

public class HomePageEn extends BasePage{
    public HomePageEn(WebDriver driver){
        setDriver(driver);
        driver.get(getProperty("data.properties", "url_en"));
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
}