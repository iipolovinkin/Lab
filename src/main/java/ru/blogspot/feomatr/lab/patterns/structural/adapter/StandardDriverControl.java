package ru.blogspot.feomatr.lab.patterns.structural.adapter;

public class StandardDriverControl implements DriverControl {
    private final Engine engine = new StandardEngine();

    public void ignitionOn() {
        engine.start();
    }

    public void ignitionOff() {
        engine.stop();
    }

    public void accelerate() {
        engine.increasePower();
    }

    public void brake() {
        engine.decreasePower();
    }
}
