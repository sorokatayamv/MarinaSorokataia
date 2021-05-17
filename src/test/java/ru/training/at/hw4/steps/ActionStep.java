package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.training.at.hw4.utils.ReaderUserDataForLogin;

import java.util.List;
import java.util.Properties;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Perform login")
    public void login() {
        homePage.getLoginButton().click();
        Properties prop = null;
        prop = ReaderUserDataForLogin.getLoginData();
        homePage.getLoginField().sendKeys(prop.getProperty("username"));
        homePage.getPasswordField().sendKeys(prop.getProperty("password"));
        homePage.getEnterButton().click();
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {
        header.getServiceHeader().click();
        header.getDifferentElementsFromServiceHeader().click();
    }

    @Step("Select checkboxes")
    public void selectCheckboxes(List<WebElement> checkBoxes) {
        for (WebElement e : checkBoxes) {
            e.click();
        }
    }

    @Step("Select radios")
    public void selectRadios(List<WebElement> radios) {
        for (WebElement e : radios) {
            e.click();
        }
    }

    @Step("Select in dropdown")
    public void selectColorInDropdown(int indexColor) {
        Select dropdownMenu = new Select(differentElementsPage.getDropdownColor());
        dropdownMenu.selectByIndex(indexColor);
    }
}
