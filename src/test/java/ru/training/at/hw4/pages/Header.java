package ru.training.at.hw4.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw4.testdata.TestData;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Header extends BaseClass {

    @FindBy(css = "a[href='index.html']")
    private WebElement homeHeader;

    @FindBy(css = "a[href='contacts.html']")
    private WebElement contactFormHeader;

    @FindBy(xpath = "//li[position()=3]")
    private WebElement serviceHeader;

    @FindBy(xpath = "//a[@href='metals-colors.html']")
    private WebElement metalsAndColorsHeader;

    @FindBy(css = "a[href='different-elements.html']")
    private WebElement differentElementsFromServiceHeader;

    public List<String> getHeader(){
        List<String> header = new ArrayList<>();
        header.add(homeHeader.getText());
        header.add(contactFormHeader.getText());
        header.add(serviceHeader.getText());
        header.add(metalsAndColorsHeader.getText());
        return header;
    }

    public List<String> getHeaderExpected(){
        List<String> headerExpected = new ArrayList<>();
        headerExpected.add(TestData.homeHeader);
        headerExpected.add(TestData.contactFormHeader);
        headerExpected.add(TestData.serviceHeader);
        headerExpected.add(TestData.metalsAndColorsHeader);
        return headerExpected;
    }
    public WebElement getDifferentElementsFromServiceHeader() {
        return differentElementsFromServiceHeader;
    }
}

