package ru.blogspot.feomatr.lab.patterns.abstractfactory.products.van;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Chassis;

public class VanChassis implements Chassis {

    @Override
    public String toString() {
        return "This is Van Chassis!";
    }
}
