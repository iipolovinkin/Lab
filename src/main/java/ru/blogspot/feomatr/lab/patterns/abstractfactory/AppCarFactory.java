package ru.blogspot.feomatr.lab.patterns.abstractfactory;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Body;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Chassis;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Engine;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Transmission;

/**
 * The example uses both concrete implementations to create an engine, a chassis, a body and a transmission.
 *
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class AppCarFactory {
    public static void main(String[] args) {
        createCar(new VazCarFactoryImpl());
        System.out.println();
        createCar(new BmwCarFactoryImpl());
    }

    private static void createCar(CarFactory carFactory) {
        Body body = carFactory.createBody();
        Engine engine = carFactory.createEngine();
        Chassis chassis = carFactory.createChassis();
        Transmission transmission = carFactory.createTransmission();

        System.out.println("The car was created");

        System.out.println(body);
        System.out.println(engine);
        System.out.println(chassis);
        System.out.println(transmission);
    }

}
