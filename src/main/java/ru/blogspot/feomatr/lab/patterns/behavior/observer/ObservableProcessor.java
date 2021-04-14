package ru.blogspot.feomatr.lab.patterns.behavior.observer;

import java.util.List;

public class ObservableProcessor implements Processor {
    final DataListener listener;

    public ObservableProcessor(DataListener listener) {
        this.listener = listener;
    }

    @Override
    public void process(List<Data> datas) {
        for (Data data : datas) {
            ProcessedData result = doProcess(data);

            listener.onEvent(result);
        }
    }

    private ProcessedData doProcess(Data data) {
        System.out.println("process data = " + data.getData());
        return new ProcessedData(data, " processed");
    }
}
