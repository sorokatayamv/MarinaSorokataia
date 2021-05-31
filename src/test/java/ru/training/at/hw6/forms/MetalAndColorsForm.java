package ru.training.at.hw6.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import ru.training.at.hw6.testdata.MetalAndColorsFormTestData;

public class MetalAndColorsForm extends Form<MetalAndColorsFormTestData> {

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

    @FindBy(xpath = "//div[@id='salad-dropdown']//span")
    public Button vegetablesButton;

    @FindBy(id = "g7")
    public Checkbox vegetableCheckbox;

    @Override
    public void fill(MetalAndColorsFormTestData data) {

        radioButtonsOdds.select(data.getSummary().get(0).toString());
        radioButtonsEven.select(data.getSummary().get(1).toString());

        for (String e : data.getElements()) {
            elements.select(e);
        }

        metals.select(data.getMetals());
        colors.select(data.getColor());

        resetVegetablesCheckbox();
        for (String v : data.getVegetables()) {
            vegetables.select(v);
        }
    }

    public void resetVegetablesCheckbox() {
        vegetablesButton.click();
        vegetableCheckbox.click();
    }

    @Override
    public void submit() {
        submit.click();
    }
}
