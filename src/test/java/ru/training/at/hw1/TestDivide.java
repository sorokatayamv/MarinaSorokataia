package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDiv {
    private Calculator calculator = new Calculator();

    @BeforeMethod
    public void beforeMethod(){
        calculator = new Calculator();
    }

    @Test(groups = {"multAndDiv"},dataProvider = "dataProviderDiv", dataProviderClass = DataProviderClass.class)
    public void testDivLong(long numFirst, long numSecond, long expected) {
        long actual = calculator.div(numFirst, numSecond);
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"multAndDiv"},dataProvider = "dataProviderDivDouble", dataProviderClass = DataProviderClass.class)
    public void testDivDouble(double numFirst, double numSecond, double expected) {
        double actual = calculator.div(numFirst, numSecond);
        Assert.assertEquals(actual, expected);
    }

    @AfterMethod
    public void afterMethod(){
        calculator = null;
    }
}
