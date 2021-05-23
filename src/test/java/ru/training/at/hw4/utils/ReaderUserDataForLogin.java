package ru.training.at.hw4.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReaderUserDataForLogin {

    private static Properties prop;
    private static String propPath = "src/test/resources/hw3properties/config.properties";

    static {
        prop = new Properties();
        File data = new File(propPath);

        try (InputStream inputStream = new FileInputStream(data)) {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getLoginData() {
        return prop;
    }
}

