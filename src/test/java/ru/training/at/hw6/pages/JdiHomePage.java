package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.forms.LoginForm;
import ru.training.at.hw6.forms.MetalAndColorsForm;

@Url("/index.html")
@Title("Home page")
public class JdiHomePage extends WebPage {
    @FindBy(id = "user-icon")
    public Icon userIcon;

    @Css("ul.uui-navigation.nav.navbar-nav.m-l8")
    public Menu header;

    public LoginForm loginForm;

    public MetalAndColorsForm metalAndColorsForm;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public void openMetalAndColorsPage(){
        header.get("Metals & Colors").click();
    }
}
