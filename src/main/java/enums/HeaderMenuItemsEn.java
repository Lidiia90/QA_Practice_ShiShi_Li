package enums;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public enum HeaderMenuItemsEn {
    ABOUT("//a[@title='About Us']"),
    ACTIVITIES("//ul[@class='vertical medium-horizontal menu align-right show-for-medium show-for-large']/li[2]/a[@title='Activities']");

    private final String locator;

    HeaderMenuItemsEn(String locator) {
        this.locator = locator;
    }
    public String getLocator(){
        return locator;
    }
}