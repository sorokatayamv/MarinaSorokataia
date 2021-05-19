package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.training.at.hw4.testdata.TestData;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
    public void checkLogPanel() {
        List<String> expectedLogPanel = new ArrayList<>();
        expectedLogPanel.add(TestData.LOG_ROW_WATER);
        expectedLogPanel.add(TestData.LOG_ROW_WIND);
        expectedLogPanel.add(TestData.LOG_ROW_SELEN);
        expectedLogPanel.add(TestData.LOG_ROW_YELLOW);
        for (int i = 0; i < expectedLogPanel.size(); i++) {
            Assert.assertEquals(differentElementsPage
                            .getLogPanel().element().getText(),
                    expectedLogPanel.get(i));
            differentElementsPage.getLogPanel().remove();
            expectedLogPanel.remove(i);
        }

    }
}

