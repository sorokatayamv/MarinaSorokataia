package ru.training.at.hw6.testdata;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MetalAndColorsFormTestData {

    private List<Integer> summary;

    private List<String> elements;

    private String color;

    private String metals;

    private List<String> vegetables;

    public static List<String> getExpectedResultInString(MetalAndColorsFormTestData data) {
        List<String> result = new ArrayList<>();
        int sum = data.getSummary().get(0) + data.getSummary().get(1);
        result.add("Summary: " + sum);
        String elementsString = "Elements: ";
        for (int i = 0; i < data.getElements().size(); i++) {
            elementsString = elementsString + data.getElements().get(i) + ", ";
        }
        result.add(elementsString.substring(0, elementsString.length() - 2));
        result.add("Color: " + data.getColor());
        result.add("Metal: " + data.getMetals());
        String vegetableString = "Vegetables: ";
        for (int i = 0; i < data.getVegetables().size(); i++) {
            vegetableString = vegetableString + data.getVegetables().get(i) + ", ";
        }
        result.add(vegetableString.substring(0, vegetableString.length() - 2));

        System.out.println("expected: " + result);
        return result;
    }
}
