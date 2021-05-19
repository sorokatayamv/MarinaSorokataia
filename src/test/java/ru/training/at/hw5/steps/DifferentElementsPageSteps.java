package ru.training.at.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.pages.DifferentElementsPage;
import ru.training.at.hw5.testdata.TestData;

import java.util.List;

public class DifferentElementsPageSteps {

    DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext
            .getInstance()
            .getTestObject(TestContext.WEB_DRIVER));

    @When("I select checkboxes Water and Wind")
    public void selectWaterAndWindCheckboxes() {
        for (WebElement e : differentElementsPage.getCheckboxes()) {
            e.click();
        }
    }

    @When("I select radio Selen")
    public void selectSelenRadio() {
        differentElementsPage.getSelenRadio().click();
    }

    @When("I select Yellow in dropdown")
    public void selectYellowInDropdown() {
        differentElementsPage.selectColorInDropdown();
    }

    @Then("I check if there are an individual log row and "
            + "value is corresponded to the status of Water checkbox")
    public void checkWaterLogRow() {
        List<String> logRowsExpected = TestContext.getInstance()
                .getTestObject(TestContext.LOG_ROWS);

        Assert.assertTrue(logRowsExpected.contains(TestData.LOG_ROW_WATER));
    }

    @Then("I check if there are an individual log row and "
            + "value is corresponded to the status of Wind checkbox")
    public void checkWindLogRow() {
        List<String> logRowsExpected = TestContext.getInstance()
                .getTestObject(TestContext.LOG_ROWS);

        Assert.assertTrue(logRowsExpected.contains(TestData.LOG_ROW_WIND));
    }

    @Then("I check if there are an individual log row "
            + "and value is corresponded to the status of Selen radio")
    public void checkSelenLogRow() {
        List<String> logRowsExpected = TestContext.getInstance()
                .getTestObject(TestContext.LOG_ROWS);

        Assert.assertTrue(logRowsExpected.contains(TestData.LOG_ROW_SELEN));
    }

    @Then("I check if there are an individual log row "
            + "and value is corresponded to the status of Yellow color")
    public void checkYellowLogRow(){
        List<String> logRowsExpected = TestContext.getInstance()
                .getTestObject(TestContext.LOG_ROWS);

        Assert.assertTrue(logRowsExpected.contains(TestData.LOG_ROW_YELLOW));
    }
}
