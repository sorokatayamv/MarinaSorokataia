package ru.training.at.hw5.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Header extends BaseClass {

    public Header(WebDriver driver) {
        super(driver);
    }

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

    @FindBy(css = "a[href = 'user-table.html']")
    private WebElement userTable;

    public List<String> getHeader() {
        List<String> header = new ArrayList<>();
        header.add(homeHeader.getText());
        header.add(contactFormHeader.getText());
        header.add(serviceHeader.getText());
        header.add(metalsAndColorsHeader.getText());
        return header;
    }

    public WebElement getDifferentElementsFromServiceHeader() {
        return differentElementsFromServiceHeader;
    }

}


