package ru.blogspot.feomatr.lab.patterns.behavior.observer;

import java.util.List;

public class ProcessorImpl implements Processor {
    @Override
    public void process(List<Data> datas) {
        for (Data data : datas) {
            String result = doProcess(data);
            paint(result);
            send(result);
        }
    }

    private void send(String result) {
        System.out.println("send " + result);
    }

    private void paint(String result) {
        System.out.println("paint " + result);
    }

    private String doProcess(Data data) {
        return data + " processed";
    }
}
