package ru.blogspot.feomatr.lab.patterns.builder.impl;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Vehicle;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.car.*;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.van.VanBody;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.van.VanClimateControlSystem;
import ru.blogspot.feomatr.lab.patterns.builder.products.Car;
import ru.blogspot.feomatr.lab.patterns.builder.VehicleBuilder;

/**
 * Concrete Builder. Builds car using BMW parts.
 *
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class CarBuilder implements VehicleBuilder {
    private final Vehicle car = new Car();

    public static VehicleBuilder newBuilder() {
        return new CarBuilder();
    }


    @Override
    public VehicleBuilder buildBody() {
        car.setBody(new VanBody());
        return this;
    }

    @Override
    public void buildChassis() {
        car.setChassis(new CarChassis());
    }

    @Override
    public void buildPassengerArea() {

    }

    @Override
    public Vehicle getVehicle() {
        return car;
    }

    @Override
    public void buildClimateControlSystem() {
        car.setClimateControlSystem(new VanClimateControlSystem());
    }

    @Override
    public VehicleBuilder buildSunroof() {
        car.setSunroof(new CarSunroof());
        return this;
    }

    @Override
    public void buildWindows() {

    }
}
