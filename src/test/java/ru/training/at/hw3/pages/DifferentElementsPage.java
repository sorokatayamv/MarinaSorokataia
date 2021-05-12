package ru.training.at.hw3.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPage extends BaseClass {

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
    private WebElement panelLogWater;

    @FindBy(css = "div.info-panel-body.info-panel-body-log " +
            "> div > ul > li:nth-child(3)")
    private WebElement panelLogWind;

    @FindBy(css = "div.info-panel-body.info-panel-body-log " +
            "> div > ul > li:nth-child(2)")
    private WebElement panelLogSelen;

    @FindBy(css = "div.info-panel-body.info-panel-body-log " +
            "> div > ul > li:nth-child(1)")
    private WebElement panelLogYellow;

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

    public WebElement getPanelLogWater() {
        return panelLogWater;
    }

    public WebElement getPanelLogWind() {
        return panelLogWind;
    }

    public WebElement getPanelLogSelen() {
        return panelLogSelen;
    }

    public WebElement getPanelLogYellow() {
        return panelLogYellow;
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
}
