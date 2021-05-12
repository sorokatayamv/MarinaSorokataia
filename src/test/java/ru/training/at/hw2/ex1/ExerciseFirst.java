package ru.training.at.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.TestBaseClass;

import java.util.ArrayList;
import java.util.List;

public class ExerciseFirst extends TestBaseClass {

    @Test
    public void homePageTestWithSoftAsserts() {
        SoftAssert softAssert = new SoftAssert();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);

        //1.Open site
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html ");

        //2.Assert Browser title
        webDriverWait.until(ExpectedConditions.titleContains(webDriver.getTitle()));
        String actual = webDriver.getTitle();
        String expected = "Home Page";
        softAssert.assertEquals(actual, expected);

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
        softAssert.assertEquals(actualUserName, expectedUserName);

        //5.Assert that there are 4 items on the header
        //section are displayed and they have proper texts
        WebElement homeButton = webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("a[href='index.html']")));
        String actualNameHomeButton = homeButton.getText();
        String expectedNameHomeButton = "HOME";
        softAssert.assertEquals(actualNameHomeButton, expectedNameHomeButton);
        WebElement contactForm = webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("a[href='contacts.html']")));
        String actualContactForm = contactForm.getText();
        String expectedContactForm = "CONTACT FORM";
        softAssert.assertEquals(actualContactForm, expectedContactForm);
        WebElement service = webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("a[class='dropdown-toggle']")));
        String actualServiceName = service.getText();
        String expectedServiceName = "SERVICE";
        softAssert.assertEquals(actualServiceName, expectedServiceName);
        WebElement metalsAndColors = webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//a[@href='metals-colors.html']")));
        String actualMetalAndColors = metalsAndColors.getText();
        String expectedMetalAndColors = "METALS & COLORS";
        softAssert.assertEquals(actualMetalAndColors, expectedMetalAndColors);

        //6.Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = new ArrayList<>();
        images.add(webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("span[class='icons-benefit icon-practise']"))));
        images.add(webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("span[class='icons-benefit icon-custom']"))));
        images.add(webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("span[class='icons-benefit icon-multi']"))));
        images.add(webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("span[class='icons-benefit icon-base']"))));
        for(WebElement e : images){
            e.isDisplayed();
        }

        //7.Assert that there are 4 texts on the Index Page under icons and they have proper text
        WebElement textFirst = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//*[text()='To include good practices' and @class='benefit-txt']")));
        softAssert.assertTrue(textFirst.isDisplayed());
        String actualTextFirst = textFirst.getText();
        String expectedTextFirst = "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project";
        softAssert.assertEquals(actualTextFirst, expectedTextFirst);
        WebElement textSecond = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//*[text()='To be flexible and' and @class='benefit-txt']")));
        softAssert.assertTrue(textSecond.isDisplayed());
        String actualTextSecond = textSecond.getText();
        String expectedTextSecond = "To be flexible and\n" +
                "customizable";
        softAssert.assertEquals(actualTextSecond, expectedTextSecond);
        WebElement textThird = webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("div:nth-child(3) > div > span")));
        softAssert.assertTrue(textThird.isDisplayed());
        String actualTextThird = textThird.getText();
        String expectedTextThird = "To be multiplatform";
        softAssert.assertEquals(actualTextThird, expectedTextThird);
        WebElement textFourth = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//*[text()='Already have good base' and @class='benefit-txt']")));
        softAssert.assertTrue(textFourth.isDisplayed());
        String actualTextFourth = textFourth.getText();
        String expectedTextFourth =
                "Already have good base\n" + "(about 20 internal and\n" +
                        "some external projects),\n" + "wish to get more…";
        softAssert.assertEquals(actualTextFourth, expectedTextFourth);

        //8.Assert that there is the iframe with “Frame Button” exist
        WebElement iFrame = webDriverWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("frame")));
        softAssert.assertTrue(iFrame.isDisplayed());

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(iFrame);
        WebElement frameButton = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By
                .cssSelector("input[id='frame-button']")));
        softAssert.assertTrue(frameButton.isDisplayed());

        //10.Switch to original window back
        webDriver.switchTo().defaultContent();

        //11.Assert that there are 5 items in the Left Section
        // are displayed and they have proper text
        List<WebElement> leftMenu = new ArrayList<>();
        leftMenu.add(webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("a[href='index.html']"))));
        leftMenu.add(webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("a[href='contacts.html']"))));
        leftMenu.add(webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//li[position()=3]"))));
        leftMenu.add(webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("a[href='metals-colors.html']"))));
        leftMenu.add(webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("li.menu-title:nth-child(5) > a"))));
        for (WebElement e : leftMenu) {
            softAssert.assertTrue(e.isDisplayed());
        }
        softAssert.assertAll();
    }
    //12.Close Browser
}