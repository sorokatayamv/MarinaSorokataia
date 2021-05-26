package ru.training.at.hw6.testdata;

import lombok.Data;

import java.util.List;

@Data
public class MetalAndColorsData {

    private List<Integer> summary;

    private List<String> elements;

    private String color;

    private String metals;

    private List<String> vegetables;
}
