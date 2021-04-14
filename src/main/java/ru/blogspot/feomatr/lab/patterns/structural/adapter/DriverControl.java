package ru.blogspot.feomatr.lab.patterns.structural.adapter;

public interface DriverControl {
    void ignitionOn();

    void ignitionOff();

    void accelerate();

    void brake();
}
