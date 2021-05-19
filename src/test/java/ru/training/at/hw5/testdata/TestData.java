package ru.training.at.hw5.testdata;

public final class TestData {

    public static String testData;
    private TestData(String testData){
        this.testData = testData;
    }
    public final static String LOG_ROW_WATER = "Water: condition changed to true";
    public final static String LOG_ROW_WIND = "Wind: condition changed to true";
    public final static String LOG_ROW_SELEN = "metal: value changed to Selen";
    public final static String LOG_ROW_YELLOW = "Colors: value changed to Yellow";
    public final static String LOG_ROW_VIP = "Vip: condition changed to true";
    public static final String USER_PAGE_TITLE = "User page";
}
