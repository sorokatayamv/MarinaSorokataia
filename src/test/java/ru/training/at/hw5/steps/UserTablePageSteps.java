package ru.training.at.hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.pages.Header;
import ru.training.at.hw5.pages.UserTablePage;
import ru.training.at.hw5.testdata.TestData;

import java.util.ArrayList;
import java.util.List;

public class UserTablePageSteps {

    UserTablePage userTablePage = new UserTablePage(TestContext.getInstance()
            .getTestObject(TestContext.WEB_DRIVER));


    @When("'User Table' page should be opened")
    public void checkUserTableIsOpened(){
        String actualTitle = userTablePage.getUserPageTitle();
        Assert.assertTrue(actualTitle.contains(TestData.USER_PAGE_TITLE));
    }

    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkSixNumberTypeDropdowns(int count){
        Assert.assertEquals(userTablePage.getAllNumbers()
                .size(), count);
    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void checkSixUsernamesAreDisplayed(int count){
        Assert.assertEquals(userTablePage.getAllNumbers()
                .size(), count);
    }

    @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void checkSixDescriptionTextsAreDisplayed(int count){
        Assert.assertEquals(userTablePage.getAllDescription()
                .size(), count);
    }

    @And("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkSixCheckboxesAreDisplayed(int count){
        List<WebElement> checkboxesActual = userTablePage.getCheckboxes();
        for(WebElement e : checkboxesActual){
        Assert.assertTrue(e.isDisplayed());
        }
        Assert.assertEquals(checkboxesActual.size(), count);
    }

    @Then("User table should contain following values:")
    public void checkUsersOnUserTable(DataTable table){
        List<List<String>> values = table.asLists();
        List<String> numberColumn = userTablePage.getAllNumbers();
        List<String> userColumn = userTablePage.getAllUsers();
        List<String> descriptionColumn = userTablePage.getAllDescription();
        for(int i = 0; i < values.size(); i++){
            numberColumn.add(values.get(i).get(0));
            userColumn.add(values.get(i).get(1));
            descriptionColumn.add(values.get(i).get(2));
        }

        Assert.assertEquals(userTablePage
                .getAllNumbers(), numberColumn);
        Assert.assertEquals(userTablePage
                .getAllUsers(), userColumn);
        Assert.assertEquals(userTablePage
                .getAllDescription(), descriptionColumn);
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void checkDropdownValues(DataTable table){
        List<String> values = table.asList();
        values = new ArrayList<>(values.subList(1, values.size()));
        Assert.assertEquals(userTablePage.getDropdownValues().toString(), values);
    }

    @When("I select 'vip' checkbox for 'Sergey Ivan'")
    public void selectVipCheckboxForSergeyIvan(){
        userTablePage.selectCheckboxSergeyIvan();
    }

    @Then("1 log row has 'Vip: condition changed to true text in log section'")
    public void checkLogRow(int row){
        List<String> logRows = userTablePage.getAllLogRows();
        Assert.assertEquals(logRows.size(), row);
        Assert.assertTrue(logRows.get(0).contains(TestData.LOG_ROW_VIP));
    }



}
