package ru.training.at.hw5.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.pages.Header;
import ru.training.at.hw5.pages.HomePage;

public class CommonStep {

    @Given("I open JDI GitHub site")
    public void openJdiSiteHomePage() {
        new HomePage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).openSite();
    }

    @Given("I login as user Roman Iovlev")
    public void login() {
        new HomePage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).login();
    }

    @When("I click on {string} button in Header")
    public void openServiceDropdown(String category) {
        if(category.equals("Service")){
            new Header(TestContext.getInstance()
                    .getTestObject(TestContext.WEB_DRIVER))
                    .getServiceHeader().click();
        }
    }

    @When("I click on {string} button in Service dropdown")
    public void openServiceDropdownSubcategory(String subcategory) {
        if (subcategory.equals("User Table")) {
            new Header(TestContext.getInstance()
                    .getTestObject(TestContext.WEB_DRIVER))
                    .getUserTable().click();
        }
        if (subcategory.equals("Different Element page")) {
            new Header(TestContext.getInstance()
                    .getTestObject(TestContext.WEB_DRIVER))
                    .getDifferentElementsFromServiceHeader().click();
        }
    }
}
