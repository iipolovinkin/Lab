package ru.blogspot.feomatr.lab.patterns.structural.adapter;

public interface Engine {
    void start();

    void stop();

    void increasePower();

    void decreasePower();

    int getSize();

    boolean isTurbo();
}
