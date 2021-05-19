package ru.training.at.hw4.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw4.steps.ActionStep;
import ru.training.at.hw4.steps.HardAssertSteps;
import ru.training.at.hw4.testdata.TestData;

public class FailedTest extends TestBase {
    @Feature("Check home page main elements")
    @Story("Home page with login")
    @Test
    public void loginFailed() {

        ActionStep actionStep = new ActionStep(webDriver);
        HardAssertSteps assertionStep = new HardAssertSteps(webDriver);

        //1.Open site
        actionStep.openHomePage();

        //2.Assert Browser title
        assertionStep.checkBrowserTitle(TestData.HOME_PAGE_TITLE);

        //3.Perform login
        actionStep.login("User", "pass");

        //4.Assert Username is loggined
        assertionStep.checkIfUserLogged(TestData.USER_LOGIN_NAME);

    }
}
