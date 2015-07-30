package ru.blogspot.feomatr.lab.patterns.abstractfactory;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Body;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Chassis;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Engine;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Transmission;

/**
 * Abstract Factory interface. Create auto parts: an engine, a chassis, a body and a transmission.
 *
 * @author iipolovinkin
 * @since 30.07.2015
 */
public interface CarFactory {

    Engine createEngine();

    Chassis createChassis();

    Body createBody();

    Transmission createTransmission();

}
