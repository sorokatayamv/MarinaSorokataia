package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseClass {

    public Calculator calculator = new Calculator();

    @BeforeMethod
    public void beforeMethod() {
        calculator = new Calculator();
    }

    @AfterMethod
    public void afterMethod() {
        calculator = null;
    }
}
