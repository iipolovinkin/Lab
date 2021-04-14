package ru.blogspot.feomatr.lab.patterns.behavior.observer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObservableProcessor processor = new ObservableProcessor(c-> System.out.println("listen c = " + c.result));

        List<Data> datas = new ArrayList<>();

        datas.add(new Data("hello"));
        datas.add(new Data("world"));

        processor.process(datas);
    }
}
