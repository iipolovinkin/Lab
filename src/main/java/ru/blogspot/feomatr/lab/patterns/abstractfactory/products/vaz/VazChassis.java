package ru.blogspot.feomatr.lab.patterns.abstractfactory.products.vaz;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Chassis;

/**
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class VazChassis implements Chassis {

    @Override
    public String toString() {
        return "This is Vaz Chassis!";
    }
}
