package ru.training.at.hw3.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.pages.Header;
import ru.training.at.hw3.pages.HomePage;
import ru.training.at.hw3.testdata.TestData;
import ru.training.at.hw3.utils.WaitActions;

public class ExerciseFirst extends TestBase {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void homePageTestWithSoftAsserts() {

        HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
        WaitActions waitActions = new WaitActions(webDriver);

        //1.Open site
        homePage.openSite();

        //2.Assert Browser title
        softAssert.assertEquals(homePage.getBrowserTitle(),
                TestData.homePageTitle);

        //3.Perform login
        waitActions.waitUntilCondition(webDriver ->
                homePage.getLoginButton().isDisplayed());
        homePage.login();

        //4.Assert Username is loggined
        waitActions.waitUntilCondition(webDriver ->
                homePage.getUserLoginName().isDisplayed());
        softAssert.assertEquals(homePage.getUserLoginName().getText(),
                TestData.userLoginName);

        //5.Assert that there are 4 items on the header
        //section are displayed and they have proper texts
        Header header = PageFactory.initElements(webDriver, Header.class);
        softAssert.assertEquals(header.getHeader(), header.getHeaderExpected());


        //6.Assert that there are 4 images on the Index Page and they are displayed
        for (WebElement e : homePage.getImages()) {
            softAssert.assertTrue(e.isDisplayed());
        }

        //7.Assert that there are 4 texts on the Index Page under icons and they have proper text
        for (WebElement e : homePage.getTextsUnderImages()) {
            softAssert.assertTrue(e.isDisplayed());
        }
        for (int i = 0; i < homePage.getTextsUnderImages().size(); i++) {
            softAssert.assertEquals(homePage.getTextsUnderImages().get(i).getText(),
                    homePage.getTextsUnderImagesExpected().get(i));
        }

        //8.Assert that there is the iframe with “Frame Button” exist
        waitActions.waitUntilCondition(webDriver -> homePage.getIFrame().isDisplayed());
        softAssert.assertTrue(homePage.getIFrame().isDisplayed());

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        homePage.switchToIFrame();
        softAssert.assertTrue(homePage.getiFrameButton().isDisplayed());

        //10.Switch to original window back
        homePage.returnToHomePageFromIFrame();

        //11.Assert that there are 5 items in the Left Section
        // are displayed and they have proper text
        for (WebElement e : homePage.getLeftMenu()) {
            softAssert.assertTrue(e.isDisplayed());
        }
        for (int i = 0; i < homePage.getLeftMenuExpected().size(); i++) {
            softAssert.assertEquals(homePage.getLeftMenu().get(i).getText(),
                    homePage.getLeftMenuExpected().get(i));
        }
        softAssert.assertAll();
    }
}
