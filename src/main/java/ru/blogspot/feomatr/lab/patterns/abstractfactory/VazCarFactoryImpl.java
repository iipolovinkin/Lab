package ru.blogspot.feomatr.lab.patterns.abstractfactory;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Body;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Chassis;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Engine;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Transmission;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.vaz.VazBody;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.vaz.VazChassis;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.vaz.VazEngine;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.vaz.VazTransmission;

/**
 * Concrete factory.
 *
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class VazCarFactoryImpl implements CarFactory {

    @Override
    public Engine createEngine() {
        return new VazEngine();
    }

    @Override
    public Chassis createChassis() {
        return new VazChassis();
    }

    @Override
    public Body createBody() {
        return new VazBody();
    }

    @Override
    public Transmission createTransmission() {
        return new VazTransmission();
    }
}
