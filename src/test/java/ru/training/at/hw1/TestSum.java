package ru.training.at.hw1;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSum {
    @BeforeTest
    public void beforeTest(){
        Calculator calculator = new Calculator();
    }

    @Test
    public void testSumLong(){
        long actual = calculator.sum(5,2);
        long expected = 7;
        Assert.assertEquals(actual,expected);
    }
    @AfterMethod
    public void afterTest(){
        calculater = null;
    }
}

