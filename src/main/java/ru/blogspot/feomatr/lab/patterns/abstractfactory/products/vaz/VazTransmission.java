package ru.blogspot.feomatr.lab.patterns.abstractfactory.products.vaz;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Transmission;

/**
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class VazTransmission implements Transmission {

    @Override
    public String toString() {
        return "This is Vaz Transmission!";
    }
}
