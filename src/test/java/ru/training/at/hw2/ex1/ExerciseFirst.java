package ru.training.at.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.TestBaseClass;

public class ExerciseFirst extends TestBaseClass {

    SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    @Override
    public void beforeTest() {
        super.beforeTest();
    }

    @Test
    public void homePageTestWithSoftAsserts() {

        //1.Open site
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html ");

        //2.Assert Browser title
        (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.titleContains(webDriver.getTitle()));
        String actual = webDriver.getTitle();
        String expected = "Home Page";
        softAssert.assertEquals(actual, expected);

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
        softAssert.assertEquals(actualUserName, expectedUserName);

        //5.Assert that there are 4 items on the header
        //section are displayed and they have proper texts
        WebElement homeButton = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("a[href='index.html']"))));
        String actualNameHomeButton = homeButton.getText();
        String expectedNameHomeButton = "HOME";
        softAssert.assertEquals(actualNameHomeButton, expectedNameHomeButton);
        WebElement contactForm = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("a[href='contacts.html']"))));
        String actualContactForm = contactForm.getText();
        String expectedContactForm = "CONTACT FORM";
        softAssert.assertEquals(actualContactForm, expectedContactForm);
        WebElement service = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("a[class='dropdown-toggle']"))));
        String actualServiceName = service.getText();
        String expectedServiceName = "SERVICE";
        softAssert.assertEquals(actualServiceName, expectedServiceName);
        WebElement metalsAndColors = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//a[@href='metals-colors.html']"))));
        String actualMetalAndColors = metalsAndColors.getText();
        String expectedMetalAndColors = "METALS & COLORS";
        softAssert.assertEquals(actualMetalAndColors, expectedMetalAndColors);

        //6.Assert that there are 4 images on the Index Page and they are displayed
        WebElement imageFirst = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("span[class='icons-benefit icon-practise']"))));
        softAssert.assertTrue(imageFirst.isDisplayed());
        WebElement imageSecond = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("span[class='icons-benefit icon-custom']"))));
        softAssert.assertTrue(imageSecond.isDisplayed());
        WebElement imageThird = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("span[class='icons-benefit icon-multi']"))));
        softAssert.assertTrue(imageThird.isDisplayed());
        WebElement imageFourth = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("span[class='icons-benefit icon-base']"))));
        softAssert.assertTrue(imageFourth.isDisplayed());

        //7.Assert that there are 4 texts on the Index Page under icons and they have proper text
        WebElement textFirst = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//*[text()='To include good practices' and @class='benefit-txt']"))));
        softAssert.assertTrue(textFirst.isDisplayed());
        String actualTextFirst = textFirst.getText();
        String expectedTextFirst = "To include good practices and ideas from successful EPAM project";
        softAssert.assertEquals(actualTextFirst, expectedTextFirst);
        WebElement textSecond = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//*[text()='To be flexible and' and @class='benefit-txt']"))));
        softAssert.assertTrue(textSecond.isDisplayed());
        String actualTextSecond = textSecond.getText();
        String expectedTextSecond = "To be flexible and customizable";
        softAssert.assertEquals(actualTextSecond, expectedTextSecond);
        WebElement textThird = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .className("benefit-txt"))));
        softAssert.assertTrue(textThird.isDisplayed());
        String actualTextThird = textThird.getText();
        String expectedTextThird = "To be multiplatform";
        softAssert.assertEquals(actualTextThird, expectedTextThird);
        WebElement textFourth = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//*[text()='Already have good base' and @class='benefit-txt']"))));
        softAssert.assertTrue(textFourth.isDisplayed());
        String actualTextFourth = textFourth.getText();
        String expectedTextFourth =
                "Already have good base (about 20 internal and some external projects), wish to get more…";
        softAssert.assertEquals(actualTextFourth, expectedTextFourth);

        //8.Assert that there is the iframe with “Frame Button” exist
        WebElement iFrame = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("frame"))));
        softAssert.assertTrue(iFrame.isDisplayed());

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(iFrame);
        WebElement frameButton = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("input[id='frame-button']"))));
        softAssert.assertTrue(frameButton.isDisplayed());

        //10.Switch to original window back
        webDriver.switchTo().defaultContent();

        //11.Assert that there are 5 items in the Left Section
        // are displayed and they have proper text
        WebElement homeLeft = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("a[href='index.html']"))));
        softAssert.assertTrue(homeLeft.isDisplayed());
        WebElement contactFormLeft = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("a[href='contacts.html']"))));
        softAssert.assertTrue(contactFormLeft.isDisplayed());
        WebElement serviceLeft = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//li[position()=3]"))));
        softAssert.assertTrue(serviceLeft.isDisplayed());
        WebElement metalsAndColorsLeft = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("a[href='metals-colors.html']"))));
        softAssert.assertTrue(metalsAndColorsLeft.isDisplayed());
        WebElement elementsPackLeft = (new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//li[position()=5]"))));
        softAssert.assertTrue(elementsPackLeft.isDisplayed());
    }
    //12.Close Browser
    @AfterTest
    @Override
    public void afterTest() {
        super.afterTest();
    }
}