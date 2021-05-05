package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSum {

    private Calculator calculator = new Calculator();

    @BeforeMethod
    public void beforeMethod() {
        calculator = new Calculator();
    }

    @Test(groups = {"sumAndSub"},dataProvider = "dataProviderSum", dataProviderClass = DataProviderClass.class)
    public void testSumLong(long firstNum, long secondNum, long expected) {
        long actual = calculator.sum(firstNum, secondNum);
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"sumAndSub"},dataProvider = "dataProviderSumDouble", dataProviderClass = DataProviderClass.class)
    public void testSumDouble(double numFirst, double numSecond, double expected) {
        double actual = calculator.sum(numFirst, numSecond);
        Assert.assertEquals(actual, expected);
    }

    @AfterMethod
    public void afterMethod(){
        calculator = null;
    }
}

