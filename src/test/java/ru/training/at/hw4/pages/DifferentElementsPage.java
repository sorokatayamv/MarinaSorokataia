package ru.training.at.hw4.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw4.testdata.TestData;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

@Getter
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

    public Deque<WebElement> getLogPanel() {
        Deque<WebElement> logPanel = new ArrayDeque<>();
        logPanel.add(logRowWater);
        logPanel.add(logRowWind);
        logPanel.add(logRowSelen);
        logPanel.add(logRowYellow);
        return logPanel;
    }

    public List<WebElement> getCheckBoxes() {
        List<WebElement> checkBoxes = new ArrayList<>();
        checkBoxes.add(waterCheckbox);
        checkBoxes.add(windCheckbox);
        return checkBoxes;
    }

}
