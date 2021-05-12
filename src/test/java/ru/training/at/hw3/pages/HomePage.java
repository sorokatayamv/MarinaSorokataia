package ru.training.at.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HomePage extends BaseClass {

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(id = "user-icon")
    private WebElement loginButton;

    @FindBy(id = "name")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='login-button']")
    private WebElement enterButton;

    @FindBy(css = "span[class='icons-benefit icon-practise']")
    private WebElement imageFirstHomePage;

    @FindBy(css = "span[class='icons-benefit icon-custom']")
    private WebElement imageSecondHomePage;

    @FindBy(css = "span[class='icons-benefit icon-multi']")
    private WebElement imageThirdHomePage;

    @FindBy(css = "span[class='icons-benefit icon-base']")
    private WebElement imageFourthHomePage;

    @FindBy(xpath = "//*[text()='To include good practices' and @class='benefit-txt']")
    private WebElement textFirstHomePage;

    @FindBy(xpath = "//*[text()='To be flexible and' and @class='benefit-txt']")
    private WebElement textSecondHomePage;

    @FindBy(css = "div:nth-child(3) > div > span")
    private WebElement textThirdHomePage;

    @FindBy(xpath = "//*[text()='Already have good base' and @class='benefit-txt']")
    private WebElement textFourthHomePage;

    @FindBy(id = "frame")
    private WebElement iFrame;

    @FindBy(css = "input[id='frame-button']")
    private WebElement iFrameButton;

    @FindBy(css = "li.active > a")
    private WebElement homeLeftMenu;

    @FindBy(xpath = "//*[@id='mCSB_1_container']/ul/li[2]/a")
    private WebElement contactFormLeftMenu;

    @FindBy(xpath = "//*[@id='mCSB_1_container']/ul/li[3]/a")
    private WebElement serviceLeftMenu;

    @FindBy(xpath = "//*[@id='mCSB_1_container']/ul/li[4]/a")
    private WebElement metalAndColorsLeftMenu;

    @FindBy(css = "li.menu-title:nth-child(5) > a")
    private WebElement elementsPackLeftMenu;

    @FindBy(id = "user-name")
    private WebElement userLoginName;

    public void login() {
        loginButton.click();
        FileInputStream inputStream;
        Properties properties = new Properties();
        try {
            inputStream = new FileInputStream("src/test/resources/hw3properties/" +
                    "config.properties");
            properties.load(inputStream);
            loginField.sendKeys(properties.getProperty("username"));
            passwordField.sendKeys(properties.getProperty("password"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        enterButton.click();
    }

    public void switchToIFrame() {
        webDriver.switchTo().frame(iFrame);
    }

    public void returnToHomePageFromIFrame() {
        webDriver.switchTo().defaultContent();
    }

    public void openSite() {
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    public String getBrowserTitle() {
        return webDriver.getTitle();
    }

    public WebElement getUserLoginName() {
        return userLoginName;
    }

    public WebElement getImageFirstHomePage() {
        return imageFirstHomePage;
    }

    public WebElement getImageSecondHomePage() {
        return imageSecondHomePage;
    }

    public WebElement getImageThirdHomePage() {
        return imageThirdHomePage;
    }

    public WebElement getImageFourthHomePage() {
        return imageFourthHomePage;
    }

    public WebElement getTextFirstHomePage() {
        return textFirstHomePage;
    }

    public WebElement getTextSecondHomePage() {
        return textSecondHomePage;
    }

    public WebElement getTextThirdHomePage() {
        return textThirdHomePage;
    }

    public WebElement getTextFourthHomePage() {
        return textFourthHomePage;
    }

    public WebElement getHomeLeftMenu() {
        return homeLeftMenu;
    }

    public WebElement getContactFormLeftMenu() {
        return contactFormLeftMenu;
    }

    public WebElement getServiceLeftMenu() {
        return serviceLeftMenu;
    }

    public WebElement getMetalAndColorsLeftMenu() {
        return metalAndColorsLeftMenu;
    }

    public WebElement getElementsPackLeftMenu() {
        return elementsPackLeftMenu;
    }

    public WebElement getIFrame() {
        return iFrame;
    }

    public WebElement getiFrameButton() {
        return iFrameButton;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }
}
