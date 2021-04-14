package ru.blogspot.feomatr.lab.patterns.abstractfactory.products.car;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Chassis;

public class CarChassis implements Chassis {

    @Override
    public String toString() {
        return "This is Car Chassis!";
    }
}
