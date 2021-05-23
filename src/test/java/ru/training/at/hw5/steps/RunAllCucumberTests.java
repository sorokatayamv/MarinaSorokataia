package ru.training.at.hw5.steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"ru.training.at.hw5.hooks", "ru.training.at.hw5.steps"})
public class RunAllCucumberTests extends AbstractTestNGCucumberTests {
}
