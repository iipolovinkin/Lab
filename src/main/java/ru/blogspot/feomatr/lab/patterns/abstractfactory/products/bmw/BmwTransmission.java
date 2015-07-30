package ru.blogspot.feomatr.lab.patterns.abstractfactory.products.bmw;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Transmission;

/**
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class BmwTransmission implements Transmission {

    @Override
    public String toString() {
        return "This is Bmw Transmissio!";
    }
}
