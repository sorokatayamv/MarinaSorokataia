package ru.training.at.hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ExerciseSecond {

    WebDriver webDriver;

    @Test
    public void homePageTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        //1.Open test site by URL
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html ");

        //2.Assert Browser title
        (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.titleContains(webDriver.getTitle()));
        String actualTitle = webDriver.getTitle();
        String expectedTitle = "Home Page";
        Assert.assertEquals(actualTitle, expectedTitle);

        //3.Perform login
        WebElement loginButton = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("user-icon")))));
        loginButton.click();
        WebElement username = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("name"))));
        username.sendKeys("Roman");
        WebElement password = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("password"))));
        password.sendKeys("Jdi1234");
        WebElement enterButton = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='login-button']"))));
        enterButton.click();

        //4.Assert Username is loggined
        WebElement userLoginName = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name"))));
        String actualUserName = userLoginName.getText();
        String expectedUserName = "ROMAN IOVLEV";
        Assert.assertEquals(actualUserName, expectedUserName);

        //5.Open through the header menu Service -> Different Elements Page
        WebElement serviceButtonHeader = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//li[position()=3]"))));
        serviceButtonHeader.click();
        WebElement differentElementsButton = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("a[href='different-elements.html']"))));
        differentElementsButton.click();

        //6.Select checkboxes
        WebElement waterCheckbox = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("label.label-checkbox:nth-child(1)"))));
        waterCheckbox.click();
        WebElement windCheckbox = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                                .cssSelector("label.label-checkbox:nth-child(3)"))));
        windCheckbox.click();

        //7.Select radio
        WebElement selenRadio = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                                .cssSelector("label.label-radio:nth-child(4)"))));
        selenRadio.click();

        //8.Select in dropdown
        WebElement dropdown = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                                .cssSelector("select.uui-form-element"))));
        /*dropdown.click();*/
       /* WebElement yellowDropdown = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("select[@class='uui-form-element']/option[text()='Yellow']"))));
        yellowDropdown.click();*/
        Select dropdownMenu = new Select(dropdown);
        dropdownMenu.selectByIndex(3);

        //9.Assert that
        // 1)for each checkbox there is an individual log
        // row and value is corresponded to the status of checkbox
        // 2)for radio button there is a log row and value
        // is corresponded to the status of radio button
        // 3)for dropdown there is a log row and value
        // is corresponded to the selected value

        WebElement panelLogWaterCheckbox = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                                .xpath("li[text()='Water: condition changed to true']"))));
        Assert.assertTrue(panelLogWaterCheckbox.isDisplayed());




        //10.Close Browser

    }
}





