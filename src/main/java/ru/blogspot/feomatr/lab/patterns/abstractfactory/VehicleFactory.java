package ru.blogspot.feomatr.lab.patterns.abstractfactory;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Body;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Chassis;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Engine;


public interface VehicleFactory {

    Body createBody();

    Chassis createChassis();

    Engine createEngine();

    //  Если добавить новый продукт и метод, по его созданию,
    //  то потребуется добавлять метод в реализации интерфейса
//    Transmission createTransmission();
}
