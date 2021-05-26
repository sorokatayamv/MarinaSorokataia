package ru.training.at.hw6.test;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.training.at.hw6.JdiSite;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.testdata.DataProvider;
import ru.training.at.hw6.testdata.MetalAndColorsData;

import java.util.ArrayList;
import java.util.List;

import static ru.training.at.hw6.JdiSite.metalAndColorsPage;

public class JdiSiteTest extends BaseTest {

    @Test(dataProvider = "metalAndColors", dataProviderClass = DataProvider.class)
    public void selectDifferentElementsOnMetalAndColorsPage(MetalAndColorsData data) {
        JdiSite.open();
        JdiSite.performLogin(User.ROMAN);
        JdiSite.openMetalAndColorPage();
        JdiSite.selectElementsOnMetalAndColorsPage(data);

        List<String> actualResultsInStrings = metalAndColorsPage.getResultList();
        List<String> expectedResultsInString = getExpectedResultInString(data);

        Assert.assertTrue(actualResultsInStrings.containsAll(expectedResultsInString));

    }

    private List<String> getExpectedResultInString(MetalAndColorsData data) {
        List<String> result = new ArrayList<>();
        int sum = data.getSummary().get(0) + data.getSummary().get(1);
        result.add("Summary: " + sum);
        String elementsString = "Elements: ";
        for (int i = 0; i < data.getElements().size(); i++) {
            elementsString = elementsString + data.getElements().get(i) + ", ";
        }
        result.add(elementsString.substring(0, elementsString.length() - 2));
        result.add("Color: " + data.getColor());
        result.add("Metal: " + data.getMetals());
        String vegetableString = "Vegetables: ";
        for (int i = 0; i < data.getVegetables().size(); i++) {
            vegetableString = vegetableString + data.getVegetables().get(i) + ", ";
        }
        result.add(vegetableString.substring(0, vegetableString.length() - 2));

        return result;
    }

    @AfterMethod
    public void logout() {
        JdiSite.logoutUser();
    }
}

