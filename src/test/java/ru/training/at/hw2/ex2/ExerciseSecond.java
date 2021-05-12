package ru.training.at.hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw2.TestBaseClass;

public class ExerciseSecond extends TestBaseClass {

    @Test
    public void homePageTest() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);

        //1.Open test site by URL
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html ");

        //2.Assert Browser title
        webDriverWait.until(ExpectedConditions.titleContains(webDriver.getTitle()));
        String actualTitle = webDriver.getTitle();
        String expectedTitle = "Home Page";
        Assert.assertEquals(actualTitle, expectedTitle);

        //3.Perform login
        WebElement loginButton = webDriverWait.until(ExpectedConditions
                .elementToBeClickable(webDriver.findElement(By.id("user-icon"))));
        loginButton.click();
        WebElement username = webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.id("name")));
        username.sendKeys("Roman");
        WebElement password = webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.id("password")));
        password.sendKeys("Jdi1234");
        WebElement enterButton = webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@id='login-button']")));
        enterButton.click();

        //4.Assert Username is loggined
        WebElement userLoginName = webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.id("user-name")));
        String actualUserName = userLoginName.getText();
        String expectedUserName = "ROMAN IOVLEV";
        Assert.assertEquals(actualUserName, expectedUserName);

        //5.Open through the header menu Service -> Different Elements Page
        WebElement serviceButtonHeader = webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//li[position()=3]")));
        serviceButtonHeader.click();
        WebElement differentElementsButton = webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("a[href='different-elements.html']")));
        differentElementsButton.click();

        //6.Select checkboxes
        WebElement waterCheckbox = webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("label.label-checkbox:nth-child(1)")));
        waterCheckbox.click();
        WebElement windCheckbox = webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("label.label-checkbox:nth-child(3)")));
        windCheckbox.click();

        //7.Select radio
        WebElement selenRadio = webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("label.label-radio:nth-child(4)")));
        selenRadio.click();

        //8.Select in dropdown
        WebElement dropdown = webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("select.uui-form-element")));
        Select dropdownMenu = new Select(dropdown);
        dropdownMenu.selectByIndex(3);

        //9.Assert that
        // 1)for each checkbox there is an individual log
        // row and value is corresponded to the status of checkbox
        // 2)for radio button there is a log row and value
        // is corresponded to the status of radio button
        // 3)for dropdown there is a log row and value
        // is corresponded to the selected value
        WebElement panelLogWaterCheckbox = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By
                .cssSelector("div.info-panel-body.info-panel-body-log > div > ul > li:nth-child(4)")));
        Assert.assertTrue(panelLogWaterCheckbox.getText()
                .contains("Water: condition changed to true"));
        WebElement panelLogWindCheckbox = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By
                .cssSelector("div.info-panel-body.info-panel-body-log " +
                        "> div > ul > li:nth-child(3)")));
        Assert.assertTrue(panelLogWindCheckbox.getText()
                .contains("Wind: condition changed to true"));
        WebElement panelLogSelenRadio = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By
                .cssSelector("div.info-panel-body.info-panel-body-log " +
                        "> div > ul > li:nth-child(2)")));
        Assert.assertTrue(panelLogSelenRadio.getText().contains("metal: value changed to Selen"));
        WebElement panelLogYellowDropdown = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By
                .cssSelector("div.info-panel-body.info-panel-body-log " +
                        "> div > ul > li:nth-child(1)")));
        Assert.assertTrue(panelLogYellowDropdown.getText().contains("Colors: value changed to Yellow"));
    }
    //10.Close Browser
}





