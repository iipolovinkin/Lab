package ru.blogspot.feomatr.lab.patterns.abstractfactory.products.car;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Transmission;

public class CarTransmission implements Transmission {

    @Override
    public String toString() {
        return "This is Car Transmission!";
    }
}
