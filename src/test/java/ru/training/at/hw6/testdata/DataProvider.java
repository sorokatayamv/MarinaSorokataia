package ru.training.at.hw6.testdata;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataProvider {

    public static final String TEST_DATA_PATH =
            "src/test/resources/JDI_ex8_metalsColorsDataSet.json";

    private List<MetalAndColorsData> getData() {
        List<MetalAndColorsData> dataList = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(TEST_DATA_PATH)) {
            JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
            GsonBuilder builder = new GsonBuilder();
            Map<String, Object> map = builder.create().fromJson(reader, Object.class);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                MetalAndColorsData data = new Gson().fromJson(entry.getValue().toString(),
                        MetalAndColorsData.class);
                dataList.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    @org.testng.annotations.DataProvider(name = "metalAndColors")
    public Object[][] dataProvider() {
        List<MetalAndColorsData> dataList = getData();
        return dataList.stream()
                .map(data -> new MetalAndColorsData[]{data})
                .toArray(Object[][]::new);
    }
}


