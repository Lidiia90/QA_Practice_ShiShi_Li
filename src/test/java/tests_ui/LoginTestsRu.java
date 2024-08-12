package tests_ui;

import config.ApplicationManager;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePageRu;
import pages.LoginPageRu;

import static helpers.PropertiesReader.getProperty;

public class LoginTestsRu extends ApplicationManager {
    UserDTO user = UserDTO.builder()
            .email(getProperty("data.properties", "email"))
            .password(getProperty("data.properties", "password"))
            .build();
    @Test
    public void startPositiveTest(){
        HomePageRu homePageRu = new HomePageRu(getDriver());
        LoginPageRu loginPageRu = homePageRu.navigateToLoginPage();
        loginPageRu.fieldEmail(user.getEmail());
        loginPageRu.fieldPassword(user.getPassword());
        loginPageRu.clickButtonSubmit();
        Assert.assertTrue(loginPageRu.isLoginSuccessful(), "Login was not successful");
    }
    @Test
    public void LoginTestWrongEmail(){
        HomePageRu homePageRu = new HomePageRu(getDriver());
        LoginPageRu loginPageRu = homePageRu.navigateToLoginPage();

        String wrongEmail = getProperty("data.properties", "wrongEmail");
        String password = user.getPassword();

        loginPageRu.fieldEmail(wrongEmail);
        loginPageRu.fieldPassword(password);
        loginPageRu.clickButtonSubmit();

        Assert.assertEquals(loginPageRu.getErrorMessage(), "Логин/пароль не верен");
    }
    @Test
    public void LoginTestWrongPassword(){
        HomePageRu homePageRu = new HomePageRu(getDriver());
        LoginPageRu loginPageRu = homePageRu.navigateToLoginPage();

        String email = user.getPassword();
        String wrongPassword = getProperty("data.properties", "wrongPassword");

        loginPageRu.fieldEmail(email);
        loginPageRu.fieldPassword(wrongPassword);
        loginPageRu.clickButtonSubmit();

        Assert.assertEquals(loginPageRu.getErrorMessage(), "Логин/пароль не верен");
    }
}
