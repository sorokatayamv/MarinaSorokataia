package ru.training.at.hw5.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.training.at.hw4.testdata.TestData;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class DifferentElementsPage extends BaseClass {


    @FindBy(css = "input[type='checkbox'")
    List<WebElement> checkboxes;

    @FindBy(css = "label.label-checkbox:nth-child(1)")
    private WebElement waterCheckbox;

    @FindBy(css = "label.label-checkbox:nth-child(3)")
    private WebElement windCheckbox;

    @FindBy(css = "label.label-radio:nth-child(4)")
    private WebElement selenRadio;

    @FindBy(css = "select.uui-form-element")
    private WebElement dropdownColor;

    @FindBy(css = ".logs>li")
    private List<WebElement> allLogRows;

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

    public DifferentElementsPage(WebDriver driver){
        super(driver);
    }

    public List<String> getAllLogRows(){
        return allLogRows.stream().map(webElement -> webElement.getText())
                .collect(Collectors.toList());
    }

    public Deque<WebElement> getLogPanel() {
        Deque<WebElement> logPanel = new ArrayDeque<>();
        logPanel.add(logRowWater);
        logPanel.add(logRowWind);
        logPanel.add(logRowSelen);
        logPanel.add(logRowYellow);
        return logPanel;
    }

    public List<WebElement> getCheckboxes() {
        List<WebElement> checkBoxes = new ArrayList<>();
        checkBoxes.add(waterCheckbox);
        checkBoxes.add(windCheckbox);
        return checkBoxes;
    }

    public List<WebElement> getRadios() {
        List<WebElement> radios = new ArrayList<>();
        radios.add(selenRadio);
        return radios;
    }

    public void selectColorInDropdown() {
        Select dropdownMenu = new Select(dropdownColor);
        dropdownMenu.selectByValue("Yellow");
    }

}
