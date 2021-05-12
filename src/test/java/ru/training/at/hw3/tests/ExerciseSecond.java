package ru.training.at.hw3.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.training.at.hw3.pages.DifferentElementsPage;
import ru.training.at.hw3.pages.Header;
import ru.training.at.hw3.pages.HomePage;
import ru.training.at.hw3.utils.WaitActions;

public class ExerciseSecond extends TestBase {

    @BeforeTest
    @Override
    public void beforeTest() {
        super.beforeTest();
    }

    @Test
    public void homePageTest() {
        HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
        WaitActions waitActions = new WaitActions(webDriver);

        //1.Open test site by URL
        homePage.openSite();

        //2.Assert Browser title
        Assert.assertEquals(homePage.getBrowserTitle(), "Home Page");

        //3.Perform login
        waitActions.waitUntilCondition(webDriver ->
                homePage.getLoginButton().isDisplayed());
        homePage.login();

        //4.Assert Username is loggined
        waitActions.waitUntilCondition(webDriver ->
                homePage.getUserLoginName().isDisplayed());
        Assert.assertEquals(homePage.getUserLoginName().getText(), "ROMAN IOVLEV");

        //5.Open through the header menu Service -> Different Elements Page
        Header header = PageFactory.initElements(webDriver, Header.class);
        waitActions.waitUntilCondition(webDriver1 ->
                header.getServiceHeader().isDisplayed());
        header.openDifferentElementsPageFromServiceHeaderDropdown();

        //6.Select checkboxes
        DifferentElementsPage difElPage = PageFactory.initElements(webDriver,
                DifferentElementsPage.class);
        waitActions.waitUntilCondition(webDriver1 ->
                difElPage.getWaterCheckbox().isDisplayed());
        waitActions.waitUntilCondition(webDriver1 ->
                difElPage.getWindCheckbox().isDisplayed());
        difElPage.selectWaterCheckbox();
        difElPage.selectWindCheckbox();

        //7.Select radio
        waitActions.waitUntilCondition(webDriver1 ->
                difElPage.getSelenRadio().isDisplayed());
        difElPage.selectSelenRadio();

        //8.Select in dropdown
        waitActions.waitUntilCondition(webDriver1 ->
                difElPage.getDropdownColor().isDisplayed());
        difElPage.selectYellowInDropdownColor();

        //9.Assert that
        // 1)for each checkbox there is an individual log
        // row and value is corresponded to the status of checkbox
        // 2)for radio button there is a log row and value
        // is corresponded to the status of radio button
        // 3)for dropdown there is a log row and value
        // is corresponded to the selected value
        waitActions.waitUntilCondition(webDriver1 ->
                difElPage.getPanelLogWater().isDisplayed());
        Assert.assertTrue(difElPage.getPanelLogWater()
                .getText().contains("Water: condition changed to true"));
        waitActions.waitUntilCondition(webDriver ->
                difElPage.getPanelLogWind().isDisplayed());
        Assert.assertTrue(difElPage.getPanelLogWind()
                .getText().contains("Wind: condition changed to true"));
        waitActions.waitUntilCondition(webDriver ->
                difElPage.getSelenRadio().isDisplayed());
        Assert.assertTrue(difElPage.getSelenRadio()
                .getText().contains("metal: value changed to Selen"));
        waitActions.waitUntilCondition(webDriver ->
                difElPage.getDropdownColor().isDisplayed());
        Assert.assertTrue(difElPage.getPanelLogYellow()
                .getText().contains("Colors: value changed to Yellow"));
    }

    @AfterTest
    @Override
    public void afterTest() {
        super.afterTest();
    }
}
