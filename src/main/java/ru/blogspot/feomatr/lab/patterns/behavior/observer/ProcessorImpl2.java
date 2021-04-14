package ru.blogspot.feomatr.lab.patterns.behavior.observer;

import java.util.List;

public class ProcessorImpl2 implements Processor {
    private ProcessorImpl2 dataPainter;
    private ProcessorImpl2 dataSender;

    @Override
    public void process(List<Data> datas) {
        for (Data data : datas) {
            String result = doProcess(data);
            dataPainter.paint(result);
            dataSender.send(result);
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
