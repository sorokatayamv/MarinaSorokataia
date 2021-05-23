package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Perform login")
    public void login(String username, String password){
        homePage.getLoginButton().click();
        homePage.getLoginField().sendKeys(username);
        homePage.getPasswordField().sendKeys(password);
        homePage.getEnterButton().click();
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {
        header.getServiceHeader().click();
        header.getDifferentElementsFromServiceHeader().click();
    }

    @Step("Select checkboxes")
    public void selectCheckboxes() {
        for (WebElement e : differentElementsPage.getCheckBoxes()) {
            e.click();
        }
    }

    @Step("Select radios")
    public void selectRadios() {
       differentElementsPage.getSelenRadio().click();
    }

    @Step("Select in dropdown")
    public void selectColorInDropdown(int indexColor) {
        Select dropdownMenu = new Select(differentElementsPage.getDropdownColor());
        dropdownMenu.selectByIndex(indexColor);
    }
}
