package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.hw4.pages.DifferentElementsPage;
import ru.training.at.hw4.pages.Header;
import ru.training.at.hw4.pages.HomePage;

public abstract class  AbstractStep {

    HomePage homePage;
    Header header;
    DifferentElementsPage differentElementsPage;

     AbstractStep(WebDriver webDriver){
        homePage = PageFactory.initElements(webDriver, HomePage.class);
        header = PageFactory.initElements(webDriver, Header.class);
        differentElementsPage = PageFactory.initElements
                (webDriver, DifferentElementsPage.class);
    }

    @Step("Open site")
    public void openHomePage() {
        homePage.openSite();
    }
}
