package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestMult {
    private Calculator calculator = new Calculator();

    @Test(dataProvider = "dataProviderMult", dataProviderClass = DataProviderClass.class)
    public void testMultLong(long numFirst, long numSecond, long expected){
        long actual = calculator.mult(numFirst, numSecond);
        Assert.assertEquals(actual, expected);
    }
    @BeforeMethod
    public void setUp(){
        calculator = new Calculator();
    }
    @AfterMethod
    public void tearDown(){
        calculator = null;
    }
}
