package ru.blogspot.feomatr.lab.patterns.factorymethod;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Vehicle;
import ru.blogspot.feomatr.lab.patterns.builder.products.Car;
import ru.blogspot.feomatr.lab.patterns.builder.products.Van;

public class VehicleFactory {
    public Vehicle createVehicle(Category category) {
        if (Category.CAR == category) {
            return new Car();
        } else {
            return new Van();
        }
    }
}
