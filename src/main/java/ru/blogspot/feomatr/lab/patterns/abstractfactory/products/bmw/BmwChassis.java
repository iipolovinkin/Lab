package ru.blogspot.feomatr.lab.patterns.abstractfactory.products.bmw;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Chassis;

/**
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class BmwChassis implements Chassis {

    @Override
    public String toString() {
        return "This is Bmw Chassis!";
    }
}
