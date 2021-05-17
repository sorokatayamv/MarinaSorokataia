package ru.training.at.hw4.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw4.testdata.TestData;

import java.util.ArrayList;
import java.util.List;

@Getter
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

    public void switchToIFrame() {
        webDriver.switchTo().frame(iFrame);
    }

    public void switchToHomePageFromiFrame() {
        webDriver.switchTo().defaultContent();
    }

    public void openSite() {
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    public String getBrowserTitle() {
        return webDriver.getTitle();
    }

    public List<WebElement> getImages() {
        List<WebElement> images = new ArrayList<>();
        images.add(imageFirstHomePage);
        images.add(imageSecondHomePage);
        images.add(imageThirdHomePage);
        images.add(imageFourthHomePage);
        return images;
    }

    public List<WebElement> getTextsUnderImages() {
        List<WebElement> textsUnderImages = new ArrayList<>();
        textsUnderImages.add(textFirstHomePage);
        textsUnderImages.add(textSecondHomePage);
        textsUnderImages.add(textThirdHomePage);
        textsUnderImages.add(textFourthHomePage);
        return textsUnderImages;
    }

    public List<String> getTextsUnderImagesExpected() {
        List<String> textsExpected = new ArrayList<>();
        textsExpected.add(TestData.textFirstHomePage);
        textsExpected.add(TestData.textSecondHomePage);
        textsExpected.add(TestData.textThirdHomePage);
        textsExpected.add(TestData.textFourthHomePage);
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
        leftMenuExpected.add(TestData.homeLeftMenu);
        leftMenuExpected.add(TestData.contactFormLeftMenu);
        leftMenuExpected.add(TestData.serviceLeftMenu);
        leftMenuExpected.add(TestData.metalAndColorsLeftMenu);
        leftMenuExpected.add(TestData.elementsPackLeftMenu);
        return leftMenuExpected;
    }

    public WebElement getLoginField() {
        return loginField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getEnterButton() {
        return enterButton;
    }

    public WebElement getiFrame() {
        return iFrame;
    }


}
