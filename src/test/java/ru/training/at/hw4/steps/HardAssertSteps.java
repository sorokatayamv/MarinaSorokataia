package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Deque;

public class HardAssertSteps extends AbstractStep {

    public HardAssertSteps(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Assert Browser title")
    public void checkBrowserTitle(String browserTitleExpected) {
        String browserTitleActual = homePage.getBrowserTitle();
        Assert.assertEquals(browserTitleActual,
                browserTitleExpected);
    }

    @Step("Assert Username is loggined")
    public void checkIfUserLogged(String userLoginNameExpected) {
        Assert.assertEquals(homePage.getUserLoginName().getText(),
                userLoginNameExpected);
    }

    @Step("Assert each checkbox, radio and color has an individual log row")
    public void checkLogPanel(Deque<String> expectedLogPanel) {
        for (WebElement e : differentElementsPage.getLogPanel()) {
            Assert.assertEquals(e.getText().substring(9),
                    expectedLogPanel.element());
            differentElementsPage.getLogPanel().remove();
            expectedLogPanel.remove();
        }
    }
}
