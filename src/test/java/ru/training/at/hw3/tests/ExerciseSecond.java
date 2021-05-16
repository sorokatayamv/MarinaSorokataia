package ru.training.at.hw3.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw3.pages.DifferentElementsPage;
import ru.training.at.hw3.pages.Header;
import ru.training.at.hw3.pages.HomePage;
import ru.training.at.hw3.testdata.TestData;
import ru.training.at.hw3.utils.WaitActions;

public class ExerciseSecond extends TestBase {

    @Test
    public void homePageTest() {

        HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
        WaitActions waitActions = new WaitActions(webDriver);

        //1.Open test site by URL
        homePage.openSite();

        //2.Assert Browser title
        Assert.assertEquals(homePage.getBrowserTitle(),
                TestData.homePageTitle);

        //3.Perform login
        waitActions.waitUntilCondition(webDriver ->
                homePage.getLoginButton().isDisplayed());
        homePage.login();

        //4.Assert Username is loggined
        waitActions.waitUntilCondition(webDriver ->
                homePage.getUserLoginName().isDisplayed());
        Assert.assertEquals(homePage.getUserLoginName().getText(),
                TestData.userLoginName);

        //5.Open through the header menu Service -> Different Elements Page
        Header header = PageFactory.initElements(webDriver, Header.class);
        waitActions.waitUntilCondition(webDriver1 ->
                header.getServiceHeader().isDisplayed());
        header.openDifferentElementsPageFromServiceHeaderDropdown();

        //6.Select checkboxes
        DifferentElementsPage difElPage = PageFactory.initElements(webDriver,
                DifferentElementsPage.class);
        for(WebElement e : difElPage.getCheckBoxes()){
            waitActions.waitUntilCondition(webDriver1 ->
                    e.isDisplayed());
            e.click();
        }

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
        for (int i = 0; i < difElPage.getLogPanel().size(); i++) {
            Assert.assertEquals(difElPage.getLogPanel().element()
                            .getText().substring(9),
                    difElPage.getLogPanelExpected().element());
            difElPage.getLogPanel().remove();
            difElPage.getLogPanelExpected().remove();
        }
    }
}
