package ru.training.at.hw6;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.ui.html.elements.common.Button;
import ru.training.at.hw6.pages.MetalAndColorsPage;
import ru.training.at.hw6.pages.JdiHomePage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    public static JdiHomePage jdiHomePage;
    public static MetalAndColorsPage metalAndColorsPage;

    @FindBy(css = "li.dropdown.uui-profile-menu")
    public static UIElement loggedUser;

    @FindBy(css = ".logout")
    public static Button logoutButton;

    public static void open() {
        jdiHomePage.open();
    }

    public static void logoutUser() {
        loggedUser.click();
        logoutButton.click();
    }
}
