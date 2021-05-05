package ru.training.at.hw1;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "dataProviderSum")
    public static Object[][] dataProviderMethodSum() {
        return new Object[][]{{5, 2, 7}, {8, 1, 9}};
    }

    @DataProvider(name = "dataProviderSumDouble")
    public static Object[][] dataProviderMethodSumDouble() {
        return new Object[][]{{0.1, 0.1, 0.2}, {10.25, 0.85, 11.1}};
    }

    @DataProvider(name = "dataProviderMult")
    public static Object[][] dataProviderMethodMult() {
        return new Object[][]{{2, 5, 10}, {1, 8, 8}};
    }

    @DataProvider(name = "dataProviderSub")
    public static Object[][] dataProvideMethodSub() {
        return new Object[][]{{8, 5, 3}, {10, 11, -1}};
    }

    @DataProvider(name = "dataProviderDiv")
    public static Object[][] dataProviderMethodDiv() {
        return new Object[][]{{10, 2, 5}, {30, 10, 3}};
    }

    @DataProvider(name = "dataProviderDivDouble")
    public static Object[][] dataProviderMethodDivDouble() {
        return new Object[][]{{0.51, 0.1, 5.1}, {1.25, 0.4, 3.125}};
    }
}
