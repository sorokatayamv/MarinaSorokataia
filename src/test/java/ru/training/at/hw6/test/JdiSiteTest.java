package ru.training.at.hw6.test;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.training.at.hw6.JdiSite;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.testdata.DataProvider;
import ru.training.at.hw6.testdata.MetalAndColorsFormTestData;

import java.util.List;

import static ru.training.at.hw6.JdiSite.jdiHomePage;
import static ru.training.at.hw6.JdiSite.metalAndColorsPage;

public class JdiSiteTest extends BaseTest {

    @Test(dataProvider = "metalAndColors", dataProviderClass = DataProvider.class)
    public void selectDifferentElementsOnMetalAndColorsPage(MetalAndColorsFormTestData data) {
        JdiSite.open();
        jdiHomePage.login(User.ROMAN);
        jdiHomePage.openMetalAndColorsPage();
        metalAndColorsPage.selectElements(data);

        List<String> actualResultsInStrings = metalAndColorsPage.getResultList();
        List<String> expectedResultsInString = metalAndColorsPage
                .getExpectedResultInString(data);

        System.out.println(actualResultsInStrings + " " + expectedResultsInString);
        Assert.assertTrue(actualResultsInStrings.containsAll(expectedResultsInString));

    }

    @AfterMethod
    public void logout() {
        JdiSite.logoutUser();
    }
}

