package ru.training.at.hw6.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import ru.training.at.hw6.testdata.MetalAndColorsData;

public class MetalAndColorsForm extends Form<MetalAndColorsData> {

    @FindBy(name = "custom_radio_odd")
    public RadioButtons radioButtonsOdds;

    @FindBy(name = "custom_radio_even")
    public RadioButtons radioButtonsEven;

    @FindBy(css = "section[id = elements-checklist] input[type = checkbox]")
    public Checklist elements;

    @JDropdown(root = "#colors",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown colors;

    @JDropdown(root = "div[ui=combobox]",
            value = "input",
            list = "li",
            expand = ".caret")
    public Dropdown metals;

    @JDropdown(root = "#vegetables",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown vegetables;

    @FindBy(id = "submit-button")
    public Button submit;


    public void selectElements(MetalAndColorsData data) {

        radioButtonsOdds.select(data.getSummary().get(0).toString());
        radioButtonsEven.select(data.getSummary().get(1).toString());

        for (String e : data.getElements()) {
            elements.select(e);
        }

        metals.select(data.getMetals());
        colors.select(data.getColor());

        vegetables.select(3);
        for (String v : data.getVegetables()) {
            vegetables.select(v);
        }
    }

    public void clickSubmit() {
        submit.click();
    }
}
