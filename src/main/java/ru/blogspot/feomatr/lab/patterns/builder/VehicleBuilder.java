package ru.blogspot.feomatr.lab.patterns.builder;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Vehicle;

public interface VehicleBuilder {
    VehicleBuilder buildBody();

    void buildChassis();

    void buildPassengerArea();

    void buildWindows();

    void buildClimateControlSystem();

    VehicleBuilder buildSunroof();

    Vehicle getVehicle();

}
