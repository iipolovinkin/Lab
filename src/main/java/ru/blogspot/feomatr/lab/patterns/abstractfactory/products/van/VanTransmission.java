package ru.blogspot.feomatr.lab.patterns.abstractfactory.products.van;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Transmission;

public class VanTransmission implements Transmission {

    @Override
    public String toString() {
        return "This is Van Transmission!";
    }
}
