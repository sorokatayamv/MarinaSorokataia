package ru.training.at.hw3.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public WebElement getDifferentElementsFromServiceHeader() {
        return differentElementsFromServiceHeader;
    }
}

