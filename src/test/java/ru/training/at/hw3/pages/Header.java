package ru.training.at.hw3.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw3.testdata.TestData;

import java.util.ArrayList;
import java.util.List;

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


    public void openDifferentElementsPageFromServiceHeaderDropdown() {
        serviceHeader.click();
        differentElementsFromServiceHeader.click();
    }

    public WebElement getHomeHeader() {
        return homeHeader;
    }

    public WebElement getContactFormHeader() {
        return contactFormHeader;
    }

    public WebElement getMetalsAndColorsHeader() {
        return metalsAndColorsHeader;
    }

    public WebElement getServiceHeader() {
        return serviceHeader;
    }

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
        headerExpected.add(TestData.HOME_HEADER);
        headerExpected.add(TestData.CONTACT_FORM_HEADER);
        headerExpected.add(TestData.SERVICE_HEADER);
        headerExpected.add(TestData.METALS_AND_COLORS_HEADER);
        return headerExpected;
    }
    public WebElement getDifferentElementsFromServiceHeader() {
        return differentElementsFromServiceHeader;
    }
}

