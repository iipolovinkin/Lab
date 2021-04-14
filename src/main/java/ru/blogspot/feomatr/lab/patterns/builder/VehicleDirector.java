package ru.blogspot.feomatr.lab.patterns.builder;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Vehicle;

public interface VehicleDirector {
    Vehicle build(VehicleBuilder builder);
}
