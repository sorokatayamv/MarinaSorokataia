package ru.training.at.hw4.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.steps.ActionStep;
import ru.training.at.hw4.steps.SoftAssertionStep;
import ru.training.at.hw4.testdata.TestData;

public class FailedTest extends TestBase {
    @Feature("Check home page main elements")
    @Story("Home page with login")
    @Test
    public void homePageTestWithSoftAsserts() {

        ActionStep actionStep = new ActionStep(webDriver);
        SoftAssertionStep assertionStep = new SoftAssertionStep(webDriver);

        //1.Open site
        actionStep.openHomePage();

        //2.Assert Browser title
        assertionStep.checkBrowserTitle(" ");

        //3.Perform login
        actionStep.login();

        //4.Assert Username is loggined
        assertionStep.checkIfUserLogged(TestData.userLoginName);

        //5.Assert that there are 4 items on the header
        //section are displayed and they have proper texts
        assertionStep.checkFourHeaderItems();

        //6.Assert that there are 4 images on the Index Page and they are displayed
        assertionStep.checkFourImagesAreDisplayed();

        //7.Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertionStep.checkFourTextUnderImages();

        //8.Assert that there is the iframe with “Frame Button” exist
        assertionStep.checkIFrameIsExist();

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        //and switch to original window back
        assertionStep.checkFrameButtonIsDisplayed();

        //10.Assert that there are 5 items in the Left Section
        // are displayed and they have proper text
        assertionStep.checkLeftMenuHasProperText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();
    }
}
