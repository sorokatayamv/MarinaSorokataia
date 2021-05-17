package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class SoftAssertionStep extends AbstractStep {

    public SoftAssertionStep(WebDriver webDriver) {
        super(webDriver);
    }

    SoftAssert softAssert = new SoftAssert();

    @Step("Assert Browser title")
    public void checkBrowserTitle(String browserTitleExpected) {
        String browserTitleActual = homePage.getBrowserTitle();
        softAssert.assertEquals(browserTitleActual,
                browserTitleExpected);
    }

    @Step("Assert Username is loggined")
    public void checkIfUserLogged(String userLoginNameExpected) {
        softAssert.assertEquals(homePage.getUserLoginName().getText(),
                userLoginNameExpected);
    }

    @Step("Assert that there are 4 items on the header are displayed")
    public void checkFourHeaderItems() {
        softAssert.assertEquals(header.getHeader(), header.getHeaderExpected());
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void checkFourImagesAreDisplayed() {
        for (WebElement e : homePage.getImages()) {
            softAssert.assertTrue(e.isDisplayed());
        }
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void checkFourTextUnderImages() {
        for (WebElement e : homePage.getTextsUnderImages()) {
            softAssert.assertTrue(e.isDisplayed());
        }
        for (int i = 0; i < homePage.getTextsUnderImages().size(); i++) {
            softAssert.assertEquals(homePage.getTextsUnderImages().get(i).getText(),
                    homePage.getTextsUnderImagesExpected().get(i));
        }
    }

    @Step("Assert that there is the iframe with “Frame Button” exist")
    public void checkIFrameIsExist() {
        softAssert.assertTrue(homePage.getiFrame().isDisplayed());
    }

    @Step("Switch to the iframe and check that there is “Frame Button”" +
            " in the iframe and switch to original window back")
    public void checkFrameButtonIsDisplayed() {
        homePage.switchToIFrame();
        softAssert.assertTrue(homePage.getIFrameButton().isDisplayed());
        homePage.switchToHomePageFromiFrame();
    }

    @Step("Assert that there are 5 items in the Left Section " +
            "are displayed and they have proper text")
    public void checkLeftMenuHasProperText() {
        for (WebElement e : homePage.getLeftMenu()) {
            softAssert.assertTrue(e.isDisplayed());
        }
        for (int i = 0; i < homePage.getLeftMenuExpected().size(); i++) {
            softAssert.assertEquals(homePage.getLeftMenu().get(i).getText(),
                    homePage.getLeftMenuExpected().get(i));
        }
    }

}
