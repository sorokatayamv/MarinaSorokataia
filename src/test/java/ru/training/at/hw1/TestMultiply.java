package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestMult {
    private Calculator calculator = new Calculator();

    @BeforeMethod
    public void beforeMethod(){
        calculator = new Calculator();
    }

    @Test(groups = {"multAndDiv"},dataProvider = "dataProviderMult", dataProviderClass = DataProviderClass.class)
    public void testMultLong(long numFirst, long numSecond, long expected) {
        long actual = calculator.mult(numFirst, numSecond);
        Assert.assertEquals(actual, expected);
    }

    @AfterMethod
    public void afterMethod(){
        calculator = null;
    }
}
