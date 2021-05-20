package ru.training.at.hw5.testdata;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestData {

    public final static String LOG_ROW_WATER = "Water: condition changed to true";
    public final static String LOG_ROW_WIND = "Wind: condition changed to true";
    public final static String LOG_ROW_SELEN = "metal: value changed to Selen";
    public final static String LOG_ROW_YELLOW = "Colors: value changed to Yellow";
    public final static String LOG_ROW_VIP = "Vip: condition changed to true";
    public static final String USER_PAGE_URL = "https://jdi-testing.github.io/jdi-light/user-table.html";
}
