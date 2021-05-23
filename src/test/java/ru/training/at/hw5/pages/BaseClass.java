package ru.training.at.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClass {
    protected final WebDriver driver;
    protected static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    public BaseClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

}
