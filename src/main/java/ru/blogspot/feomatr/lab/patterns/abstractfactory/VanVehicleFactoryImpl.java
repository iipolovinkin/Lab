package ru.blogspot.feomatr.lab.patterns.abstractfactory;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Body;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Chassis;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Engine;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.van.VanBody;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.van.VanChassis;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.van.VanEngine;


public class VanVehicleFactoryImpl implements VehicleFactory {

    @Override
    public Engine createEngine() {
        return new VanEngine();
    }

    @Override
    public Chassis createChassis() {
        return new VanChassis();
    }

    @Override
    public Body createBody() {
        return new VanBody();
    }

}
