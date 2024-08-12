package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageRu extends BasePage {
    public LoginPageRu(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@id='identity']")
    WebElement fieldEmail;
    @FindBy(xpath = "//input[@id='password']")
    WebElement fieldPassword;
    @FindBy(xpath = "//input[@name='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//span[contains(text(),'Мои текущие заказы')]")
    WebElement ordersTextLocator;
    @FindBy(xpath = "//p[contains(text(),'Логин/пароль не верен')]")
    WebElement errorMessage;

    public void fieldEmail(String username) {
        fieldEmail.sendKeys(username);
    }

    public void fieldPassword(String password) {
        fieldPassword.sendKeys(password);
    }

    public void clickButtonSubmit() {
        loginButton.click();
    }

    public boolean isLoginSuccessful() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(ordersTextLocator));
            return ordersTextLocator.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getErrorMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.getText();
        } catch (TimeoutException e) {
            return "Логин/пароль не верен";
        }
    }
}
