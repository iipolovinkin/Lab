package ru.blogspot.feomatr.lab.patterns.abstractfactory;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Body;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Chassis;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Engine;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Transmission;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.car.CarBody;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.car.CarChassis;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.car.CarEngine;

public class CarVehicleFactoryImpl implements VehicleFactory {

    @Override
    public Engine createEngine() {
        return new CarEngine();
    }

    @Override
    public Chassis createChassis() {
        return new CarChassis();
    }

    @Override
    public Body createBody() {
        return new CarBody();
    }

}
