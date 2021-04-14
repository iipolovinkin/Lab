package ru.blogspot.feomatr.lab.patterns.structural.adapter;

public class StandardEngine implements Engine {
    @Override
    public void start() {
        System.out.println("start");
    }

    @Override
    public void stop() {
        System.out.println("stop");
    }

    @Override
    public void increasePower() {
        System.out.println("increasePower");
    }

    @Override
    public void decreasePower() {
        System.out.println("decreasePower");
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isTurbo() {
        return false;
    }
}
