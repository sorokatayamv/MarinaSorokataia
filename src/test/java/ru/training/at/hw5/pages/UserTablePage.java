package ru.training.at.hw5.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserTablePage extends BaseClass {

    @FindBy(css = "tr>td:nth-child(1)")
    private List<WebElement> allNumbers;

    @FindBy(css = "table tr:nth-child(1)>td:nth-child(2) option")
    private List<WebElement> dropdownValues;

    @FindBy(css = "td>a")
    private List<WebElement> allUsers;

    @FindBy(css = "tr>td:nth-child(4)>div>span")
    private List<WebElement> allDescriptions;

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(id = "ivan")
    private WebElement checkboxSergeyIvan;

    @FindBy(css = ".logs>li")
    private List<WebElement> allLogRows;

    @FindBy(xpath = "//*[@id='mCSB_2_container']/section[1]/div[2]/div/ul/li")
    private WebElement logRow;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public String getUserPageUrl(){
        return  driver.getCurrentUrl();
    }

    public List<String> getAllNumbers(){
        return allNumbers.stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getAllUsers(){
        return allUsers.stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getAllDescription(){
        return  allDescriptions.stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void selectCheckboxSergeyIvan(){
        checkboxSergeyIvan.click();
    }

    public List<String> getAllLogRows(){
        return allLogRows.stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getDropdownValues(){
        return dropdownValues.stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }
}