package ru.blogspot.feomatr.lab.patterns.abstractfactory;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Body;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Chassis;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Engine;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Transmission;

/**
 * The example uses both concrete implementations to create an engine, a chassis, a body.
 *
 */
public class AppCarFactory {
    public static void main(String[] args) {
        AppCarFactory appCarFactory = new AppCarFactory();

        appCarFactory.createCar(new VanVehicleFactoryImpl());
        System.out.println();
        appCarFactory.createCar(new CarVehicleFactoryImpl());
    }

    private void createCar(VehicleFactory vehicleFactory) {
        Body body = vehicleFactory.createBody();
        Engine engine = vehicleFactory.createEngine();
        Chassis chassis = vehicleFactory.createChassis();

        System.out.println("The vehicle was created");

        System.out.print(body);
        System.out.print(engine);
        System.out.println(chassis);
    }

}
