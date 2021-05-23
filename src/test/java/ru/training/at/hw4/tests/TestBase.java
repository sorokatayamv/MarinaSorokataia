package ru.training.at.hw4.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    WebDriver webDriver;

    @BeforeClass
    public void beforeClass(ITestContext testContext) {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);

        testContext.setAttribute("webDriver", webDriver);
    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }
}
