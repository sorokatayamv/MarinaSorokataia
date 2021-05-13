package ru.training.at.hw3.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.pages.Header;
import ru.training.at.hw3.pages.HomePage;
import ru.training.at.hw3.utils.WaitActions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ExerciseFirst extends TestBase {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void homePageTestWithSoftAsserts() {
        File data = new File("src/test/resources/hw3properties/" +
                "test.properties");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
        WaitActions waitActions = new WaitActions(webDriver);

        //1.Open site
        homePage.openSite();

        //2.Assert Browser title
        softAssert.assertEquals(homePage.getBrowserTitle(),
                prop.getProperty("homePageTitle"));

        //3.Perform login
        waitActions.waitUntilCondition(webDriver ->
                homePage.getLoginButton().isDisplayed());
        homePage.login();

        //4.Assert Username is loggined
        waitActions.waitUntilCondition(webDriver ->
                homePage.getUserLoginName().isDisplayed());
        softAssert.assertEquals(homePage.getUserLoginName().getText(),
                prop.getProperty("userLoginName"));

        //5.Assert that there are 4 items on the header
        //section are displayed and they have proper texts
        Header header = PageFactory.initElements(webDriver, Header.class);
        waitActions.waitUntilCondition(webDriver -> header.getHomeHeader().isDisplayed());
        softAssert.assertEquals(header.getHomeHeader().getText(),
                prop.getProperty("homeHeader"));
        waitActions.waitUntilCondition(webDriver -> header.getContactFormHeader().isDisplayed());
        softAssert.assertEquals(header.getContactFormHeader().getText(),
                prop.getProperty("contactFormHeader"));
        waitActions.waitUntilCondition(webDriver -> header.getServiceHeader().isDisplayed());
        softAssert.assertEquals(header.getServiceHeader().getText(),
                prop.getProperty("serviceHeader"));
        waitActions.waitUntilCondition(webDriver -> header.getMetalsAndColorsHeader().isDisplayed());
        softAssert.assertEquals(header.getMetalsAndColorsHeader().getText(),
                prop.getProperty("metalsAndColorsHeader"));

        //6.Assert that there are 4 images on the Index Page and they are displayed
        waitActions.waitUntilCondition(webDriver -> homePage.getImageFirstHomePage().isDisplayed());
        softAssert.assertTrue(homePage.getImageFirstHomePage().isDisplayed());
        waitActions.waitUntilCondition(webDriver -> homePage.getImageSecondHomePage().isDisplayed());
        softAssert.assertTrue(homePage.getImageSecondHomePage().isDisplayed());
        waitActions.waitUntilCondition(webDriver -> homePage.getImageThirdHomePage().isDisplayed());
        softAssert.assertTrue(homePage.getImageThirdHomePage().isDisplayed());
        waitActions.waitUntilCondition(webDriver -> homePage.getImageFourthHomePage().isDisplayed());
        softAssert.assertTrue(homePage.getImageFourthHomePage().isDisplayed());

        //7.Assert that there are 4 texts on the Index Page under icons and they have proper text
        waitActions.waitUntilCondition(webDriver -> homePage.getTextFirstHomePage().isDisplayed());
        softAssert.assertEquals(homePage.getTextFirstHomePage().getText(),
                prop.getProperty("textFirstHomePage"));
        waitActions.waitUntilCondition(webDriver -> homePage.getTextSecondHomePage().isDisplayed());
        softAssert.assertEquals(homePage.getTextSecondHomePage().getText(),
                prop.getProperty("textSecondHomePage"));
        waitActions.waitUntilCondition(webDriver -> homePage.getTextThirdHomePage().isDisplayed());
        softAssert.assertEquals(homePage.getTextThirdHomePage().getText(),
                prop.getProperty("textThirdHomePage"));
        waitActions.waitUntilCondition(webDriver -> homePage.getTextFourthHomePage().isDisplayed());
        softAssert.assertEquals(homePage.getTextFourthHomePage().getText(),
                prop.getProperty("textFourthHomePage"));

        //8.Assert that there is the iframe with “Frame Button” exist
        waitActions.waitUntilCondition(webDriver -> homePage.getIFrame().isDisplayed());
        softAssert.assertTrue(homePage.getIFrame().isDisplayed());

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        homePage.switchToIFrame();
        softAssert.assertTrue(homePage.getiFrameButton().isDisplayed());

        //10.Switch to original window back
        homePage.returnToHomePageFromIFrame();

        //11.Assert that there are 5 items in the Left Section
        // are displayed and they have proper text
        waitActions.waitUntilCondition(webDriver -> homePage.getHomeLeftMenu().isDisplayed());
        softAssert.assertEquals(homePage.getHomeLeftMenu().getText(),
                prop.getProperty("homeLeftMenu"));
        waitActions.waitUntilCondition(webDriver -> homePage.getContactFormLeftMenu().isDisplayed());
        softAssert.assertEquals(homePage.getContactFormLeftMenu().getText(),
                prop.getProperty("contactFormLeftMenu"));
        waitActions.waitUntilCondition(webDriver -> homePage.getServiceLeftMenu().isDisplayed());
        softAssert.assertEquals(homePage.getServiceLeftMenu().getText(),
                prop.getProperty("serviceLeftMenu"));
        waitActions.waitUntilCondition(webDriver -> homePage.getMetalAndColorsLeftMenu().isDisplayed());
        softAssert.assertEquals(homePage.getMetalAndColorsLeftMenu().getText(),
                prop.getProperty("metalAndColorsLeftMenu"));
        waitActions.waitUntilCondition(webDriver -> homePage.getElementsPackLeftMenu().isDisplayed());
        softAssert.assertEquals(homePage.getElementsPackLeftMenu().getText(),
                prop.getProperty("elementsPackLeftMenu"));
        softAssert.assertAll();
    }
}
