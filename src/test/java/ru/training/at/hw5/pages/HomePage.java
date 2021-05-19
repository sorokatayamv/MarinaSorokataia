package ru.training.at.hw5.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw4.utils.ReaderUserDataForLogin;

import java.util.Properties;

@Getter
public class HomePage extends BaseClass {

    @FindBy(id = "user-icon")
    private WebElement loginButton;

    @FindBy(id = "name")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='login-button']")
    private WebElement enterButton;

    @FindBy(id = "user-name")
    private WebElement userLoginName;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openSite() {
        driver.get(URL);
    }

    public void login(){
        loginButton.click();
        Properties prop = null;
        prop = ReaderUserDataForLogin.getLoginData();
        loginField.sendKeys(prop.getProperty("username"));
        passwordField.sendKeys(prop.getProperty("password"));
        enterButton.click();
    }
}
