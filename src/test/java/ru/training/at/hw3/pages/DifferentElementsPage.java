package ru.training.at.hw3.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.training.at.hw3.testdata.TestData;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DifferentElementsPage extends BaseClass {

    @FindBy(css = "input[type='checkbox'")
    List<WebElement> checkBoxes;

    @FindBy(css = "label.label-checkbox:nth-child(1)")
    private WebElement waterCheckbox;

    @FindBy(css = "label.label-checkbox:nth-child(3)")
    private WebElement windCheckbox;

    @FindBy(css = "label.label-radio:nth-child(4)")
    private WebElement selenRadio;

    @FindBy(css = "select.uui-form-element")
    private WebElement dropdownColor;

    @FindBy(css = "div.info-panel-body.info-panel-body-log " +
            "> div > ul > li:nth-child(4)")
    private WebElement logRowWater;

    @FindBy(css = "div.info-panel-body.info-panel-body-log " +
            "> div > ul > li:nth-child(3)")
    private WebElement logRowWind;

    @FindBy(css = "div.info-panel-body.info-panel-body-log " +
            "> div > ul > li:nth-child(2)")
    private WebElement logRowSelen;

    @FindBy(css = "div.info-panel-body.info-panel-body-log " +
            "> div > ul > li:nth-child(1)")
    private WebElement logRowYellow;

    public void selectWaterCheckbox() {
        waterCheckbox.click();
    }

    public void selectWindCheckbox() {
        windCheckbox.click();
    }

    public void selectSelenRadio() {
        selenRadio.click();
    }

    public void selectYellowInDropdownColor() {
        Select dropdownMenu = new Select(dropdownColor);
        dropdownMenu.selectByIndex(3);
    }

    public WebElement getLogRowWater() {
        return logRowWater;
    }

    public WebElement getLogRowWind() {
        return logRowWind;
    }

    public WebElement getLogRowSelen() {
        return logRowSelen;
    }

    public WebElement getLogRowYellow() {
        return logRowYellow;
    }

    public WebElement getWaterCheckbox() {
        return waterCheckbox;
    }

    public WebElement getWindCheckbox() {
        return windCheckbox;
    }

    public WebElement getSelenRadio() {
        return selenRadio;
    }

    public WebElement getDropdownColor() {
        return dropdownColor;
    }

    public Deque<WebElement> getLogPanel() {
        Deque<WebElement> logPanel = new ArrayDeque<>();
        logPanel.add(logRowWater);
        logPanel.add(logRowWind);
        logPanel.add(logRowSelen);
        logPanel.add(logRowYellow);
        return logPanel;
    }

    public Deque<String> getLogPanelExpected() {
        Deque<String> logPanelExpected = new ArrayDeque<>();
        logPanelExpected.add(TestData.LOG_ROW_WATER);
        logPanelExpected.add(TestData.LOG_ROW_WIND);
        logPanelExpected.add(TestData.LOG_ROW_SELEN);
        logPanelExpected.add(TestData.LOG_ROW_YELLOW);
        return logPanelExpected;
    }

    public List<WebElement> getCheckBoxes(){
        List<WebElement> checkBoxes = new ArrayList<>();
        checkBoxes.add(waterCheckbox);
        checkBoxes.add(windCheckbox);
        return checkBoxes;
    }
}
