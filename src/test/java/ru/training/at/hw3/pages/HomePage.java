package ru.training.at.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw3.testdata.TestData;
import ru.training.at.hw3.utils.ReaderUserDataForLogin;

import java.util.ArrayList;
import java.util.List;
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

    @FindBy(css = "span.icons-benefit")
    List<WebElement> images;

    @FindBy(css = "span.benefit-txt")
    List <WebElement> texts;

    public List<WebElement> getTextsUnderImages(){
        return texts;
    }

    public List<WebElement> getImages() {
        return images;
    }

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
        Properties prop = null;
        prop = ReaderUserDataForLogin.getLoginData();
        loginField.sendKeys(prop.getProperty("username"));
        passwordField.sendKeys(prop.getProperty("password"));
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


   /* public List<WebElement> getTextsUnderImages(){
        List<WebElement> textsUnderImages = new ArrayList<>();
        textsUnderImages.add(textFirstHomePage);
        textsUnderImages.add(textSecondHomePage);
        textsUnderImages.add(textThirdHomePage);
        textsUnderImages.add(textFourthHomePage);
        return textsUnderImages;
    }*/

    public List<String> getTextsUnderImagesExpected(){
        List<String> textsExpected = new ArrayList<>();
        textsExpected.add(TestData.TEXT_FIRST_HOME_PAGE);
        textsExpected.add(TestData.TEXT_SECOND_HOME_PAGE);
        textsExpected.add(TestData.TEXT_THIRD_HOME_PAGE);
        textsExpected.add(TestData.TEXT_FOURTH_HOME_PAGE);
        return textsExpected;
    }

    public List<WebElement> getLeftMenu() {
        List<WebElement> leftMenu = new ArrayList<>();
        leftMenu.add(homeLeftMenu);
        leftMenu.add(contactFormLeftMenu);
        leftMenu.add(serviceLeftMenu);
        leftMenu.add(metalAndColorsLeftMenu);
        leftMenu.add(elementsPackLeftMenu);
        return leftMenu;
    }

    public List<String> getLeftMenuExpected() {
        List<String> leftMenuExpected = new ArrayList<>();
        leftMenuExpected.add(TestData.HOME_LEFT_MENU);
        leftMenuExpected.add(TestData.CONTACT_FORM_LEFT_MENU);
        leftMenuExpected.add(TestData.SERVICE_LEFT_MENU);
        leftMenuExpected.add(TestData.METAL_AND_COLORS_LEFT_MENU);
        leftMenuExpected.add(TestData.ELEMENTS_PACK_LEFT_MENU);
        return leftMenuExpected;
    }


}
