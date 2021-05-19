package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.testdata.TestData;

import java.util.ArrayList;
import java.util.List;

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
        List<String> textsUnderImagesExpected = new ArrayList<>();
        textsUnderImagesExpected.add(TestData.TEXT_FIRST_HOME_PAGE);
        textsUnderImagesExpected.add(TestData.TEXT_SECOND_HOME_PAGE);
        textsUnderImagesExpected.add(TestData.TEXT_THIRD_HOME_PAGE);
        textsUnderImagesExpected.add(TestData.TEXT_FOURTH_HOME_PAGE);

        for (int i = 0; i < homePage.getTextsUnderImages().size(); i++) {
            softAssert.assertEquals(homePage.getTextsUnderImages().get(i).getText(),
                    textsUnderImagesExpected.get(i));
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
        List<String> leftMenuExpected = new ArrayList<>();
        leftMenuExpected.add(TestData.HOME_LEFT_MENU);
        leftMenuExpected.add(TestData.CONTACT_FORM_LEFT_MENU);
        leftMenuExpected.add(TestData.SERVICE_LEFT_MENU);
        leftMenuExpected.add(TestData.METAL_AND_COLORS_LEFT_MENU);
        leftMenuExpected.add(TestData.ELEMENTS_PACK_LEFT_MENU);

        for (int i = 0; i < homePage.getLeftMenu().size(); i++) {
            softAssert.assertEquals(homePage.getLeftMenu().get(i).getText(),
                    leftMenuExpected.get(i));
        }
    }

}
