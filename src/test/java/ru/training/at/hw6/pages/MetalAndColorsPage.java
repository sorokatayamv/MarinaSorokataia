package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import ru.training.at.hw6.forms.MetalAndColorsForm;
import ru.training.at.hw6.testdata.MetalAndColorsFormTestData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Url("/metals-colors.html")
@Title("Metal & Colors")
public class MetalAndColorsPage extends WebPage {

    MetalAndColorsForm metalAndColorsForm;

    public void selectElements(MetalAndColorsFormTestData data) {
        metalAndColorsForm.fill(data);
        metalAndColorsForm.submit();
    }

    @Css("div.info-panel-section ul.panel-body-list.results li")
    public WebList resultList;

    public List<String> getResultList() {
        return resultList.stream().map(UIElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getExpectedResultInString(MetalAndColorsFormTestData data) {
        List<String> result = new ArrayList<>();
        int sum = data.getSummary().get(0) + data.getSummary().get(1);
        result.add("Summary: " + sum);
        String elementsString = "Elements: ";
        for (int i = 0; i < data.getElements().size(); i++) {
            elementsString = elementsString + data.getElements().get(i) + ", ";
        }
        result.add(elementsString.substring(0, elementsString.length() - 2));
        result.add("Color: " + data.getColor());
        result.add("Metal: " + data.getMetals());
        String vegetableString = "Vegetables: ";
        for (int i = 0; i < data.getVegetables().size(); i++) {
            vegetableString = vegetableString + data.getVegetables().get(i) + ", ";
        }
        result.add(vegetableString.substring(0, vegetableString.length() - 2));

        return result;
    }

}
