package ru.training.at.hw5.context;

import java.util.HashMap;
import java.util.Map;

public final class TestContext {

    public static final String WEB_DRIVER = "driver";

    private static TestContext instance;

    private TestContext() {

    }

    private Map<String, Object> context = new HashMap<>();

    public void setTestObject(String key, Object object) {
        context.put(key, object);
    }

    public <T> T getTestObject(String key) {
        return (T) context.get(key);
    }

    public void cleanContext() {
        context.clear();
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
}
