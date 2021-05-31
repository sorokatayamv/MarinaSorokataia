package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import ru.training.at.hw6.forms.MetalAndColorsForm;
import ru.training.at.hw6.testdata.MetalAndColorsFormTestData;

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
        List<String> result = resultList.stream().map(UIElement::getText)
                .collect(Collectors.toList());
        System.out.println("actual: " + result);
        return result;
    }
}
