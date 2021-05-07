package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestMultiply extends TestBaseClass{

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
    }

    @Test(groups = {"multAndDiv"},dataProvider = "dataProviderMult", dataProviderClass = DataProviderClass.class)
    public void testMultiplyLong(long numFirst, long numSecond, long expected) {
        long actual = calculator.mult(numFirst, numSecond);
        Assert.assertEquals(actual, expected);
    }

    @AfterMethod
    @Override
    public void afterMethod() {
        super.afterMethod();
    }
}
