package pages;

import helpers.enums.HeaderMenuItemsEn;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    @FindBy(xpath = "//i[@class='fa fa-facebook']/..")
    WebElement btnFacebookHeader;
    @FindBy(xpath = "//a[@title='About Us']")
    WebElement btnAboutHeader;
    @FindBy(xpath = "//a[@title='Activities']")
    WebElement btnActivitiesHeader;

    public static <T extends BasePage> T clickButtonsOnHeaderEn(HeaderMenuItemsEn headerMenuItemsEn) {
        try {
            WebElement elementHeaderMenuItem = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(headerMenuItemsEn.getLocator())));
            elementHeaderMenuItem.click();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        switch (headerMenuItemsEn) {
            case ACTIVITIES:
                return (T) new EventsPageEn(driver);
            case ABOUT:
                return (T) new AboutPageEn(driver);
            default:
                throw new IllegalArgumentException("invalid parametr headerMenuItemsEn");
        }
    }


}