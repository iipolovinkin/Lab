package ru.blogspot.feomatr.lab.patterns.abstractfactory;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Body;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Chassis;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Engine;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Transmission;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.bmw.BmwBody;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.bmw.BmwChassis;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.bmw.BmwEngine;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.bmw.BmwTransmission;

/**
 * Concrete factory.
 *
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class BmwCarFactoryImpl implements CarFactory {

    @Override
    public Engine createEngine() {
        return new BmwEngine();
    }

    @Override
    public Chassis createChassis() {
        return new BmwChassis();
    }

    @Override
    public Body createBody() {
        return new BmwBody();
    }

    @Override
    public Transmission createTransmission() {
        return new BmwTransmission();
    }
}
