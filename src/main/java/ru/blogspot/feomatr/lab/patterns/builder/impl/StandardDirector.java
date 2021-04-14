package ru.blogspot.feomatr.lab.patterns.builder.impl;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Vehicle;
import ru.blogspot.feomatr.lab.patterns.builder.VehicleBuilder;
import ru.blogspot.feomatr.lab.patterns.builder.VehicleDirector;

/**
 * Director.
 *
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class StandardDirector implements VehicleDirector {

    @Override
    public Vehicle build(VehicleBuilder builder) {

        builder.buildBody();
        builder.buildChassis();
        builder.buildPassengerArea();
        builder.buildWindows();

        return builder.getVehicle();
    }
}
