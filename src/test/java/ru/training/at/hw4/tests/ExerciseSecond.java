package ru.training.at.hw4.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import ru.training.at.hw4.pages.DifferentElementsPage;
import ru.training.at.hw4.steps.ActionStep;
import ru.training.at.hw4.steps.HardAssertSteps;
import ru.training.at.hw4.testdata.TestData;
import ru.training.at.hw4.utils.ReaderUserDataForLogin;

import java.util.Properties;

public class ExerciseSecond extends TestBase {

    @Feature("Check different elements page elements")
    @Story("Select different elements")
    @Test
    public void differentElementsPageTest() {

        DifferentElementsPage differentElementsPage = PageFactory
                .initElements(webDriver, DifferentElementsPage.class);
        ActionStep actionStep = new ActionStep(webDriver);
        HardAssertSteps hardAssertSteps = new HardAssertSteps(webDriver);

        //1.Open test site by URL
        actionStep.openHomePage();

        //2.Assert Browser title
        hardAssertSteps.checkBrowserTitle(TestData.HOME_PAGE_TITLE);

        //3.Perform login
        Properties prop = null;
        prop = ReaderUserDataForLogin.getLoginData();
        actionStep.login(prop.getProperty("username")
                , prop.getProperty("password"));

        //4.Assert Username is loggined
        hardAssertSteps.checkIfUserLogged(TestData.USER_LOGIN_NAME);

        //5.Open through the header menu Service -> Different Elements Page
        actionStep.openDifferentElementsPage();

        //6.Select checkboxes
        actionStep.selectCheckboxes();

        //7.Select radio
        actionStep.selectRadios();

        //8.Select in dropdown
        actionStep.selectColorInDropdown(3);

        //9.Assert that
        // 1)for each checkbox there is an individual log
        // row and value is corresponded to the status of checkbox
        // 2)for radio button there is a log row and value
        // is corresponded to the status of radio button
        // 3)for dropdown there is a log row and value
        // is corresponded to the selected value
        hardAssertSteps.checkLogPanel();
    }
}
