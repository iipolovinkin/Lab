package ru.blogspot.feomatr.lab.patterns.behavior.observer;

public class ProcessedData {
    String result;

    public ProcessedData(Data data, String s) {
        result = data.data + s;
    }
}
