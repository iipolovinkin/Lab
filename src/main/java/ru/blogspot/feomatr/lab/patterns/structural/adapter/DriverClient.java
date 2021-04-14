package ru.blogspot.feomatr.lab.patterns.structural.adapter;

public class DriverClient {
    public static void main(String[] args) {
        DriverControl driverControl = new StandardDriverControl();
        driverControl.ignitionOn();
        driverControl.accelerate();
        driverControl.brake();
        driverControl.ignitionOff();
    }
}
