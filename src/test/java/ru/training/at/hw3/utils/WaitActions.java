package ru.training.at.hw3.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.training.at.hw3.tests.TestBase;

import java.util.function.Function;

public class WaitActions{
    private WebDriverWait webDriverWait;

    public WaitActions(WebDriver webDriver) {

        webDriverWait = new WebDriverWait(webDriver, 10);
    }

    public Boolean waitUntilCondition(Function<WebDriver, Boolean> p) {
        return webDriverWait.ignoring(NoSuchElementException.class).until(p);
    }
}
