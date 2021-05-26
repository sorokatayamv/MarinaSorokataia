package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import ru.training.at.hw6.forms.MetalAndColorsForm;
import ru.training.at.hw6.testdata.MetalAndColorsData;

import java.util.List;
import java.util.stream.Collectors;

@Url("/metals-colors.html")
@Title("Metal & Colors")
public class MetalAndColorsPage extends WebPage {

    MetalAndColorsForm metalAndColorsForm;

    public void selectElements(MetalAndColorsData data) {
        metalAndColorsForm.selectElements(data);
        metalAndColorsForm.clickSubmit();
    }

    @Css("div.info-panel-section ul.panel-body-list.results li")
    public WebList resultList;

    public List<String> getResultList() {
        return resultList.stream().map(UIElement::getText)
                .collect(Collectors.toList());
    }

}
