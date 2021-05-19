package ru.training.at.hw5.steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import ru.training.at.hw5.hooks.WebDriverHook;

@CucumberOptions(features = {"classpath:features"},
        glue = {"ru.training.at.hw5.hooks"})
public class RunAllCucumberTests extends AbstractTestNGCucumberTests {
}
