package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSub {
    private Calculator calculator = new Calculator();

    @Test(dataProvider = "dataProviderSub", dataProviderClass = DataProviderClass.class)
    public void testSubLong(long numFirst, long numSecond, long expected){
        long actual = calculator.sub(numFirst, numSecond);
        Assert.assertEquals(actual,expected);
    }

}
