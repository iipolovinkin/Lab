package ru.blogspot.feomatr.lab.patterns.builder;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Vehicle;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.car.*;
import ru.blogspot.feomatr.lab.patterns.builder.impl.CarBuilder;
import ru.blogspot.feomatr.lab.patterns.builder.impl.LuxeDirector;
import ru.blogspot.feomatr.lab.patterns.builder.impl.StandardDirector;
import ru.blogspot.feomatr.lab.patterns.builder.impl.VanBuilder;
import ru.blogspot.feomatr.lab.patterns.builder.products.Car;


public class ClientBuilder {
    public static void main(String[] args) {
        ClientBuilder client = new ClientBuilder();

//        client.clientUseConstructor();


//        client.useSetters("simple");

//        client.useBuilder();

        client.useBuilderAndDecorator();

    }

    public void clientUseConstructor() {
        // используется создание сложного объекта, например, через конструктор
        Vehicle vehicle = new Car(new CarEngine(), new CarBody(), new CarTransmission(),
                new CarChassis(), new CarClimateControlSystem(), new CarSunroof());


        System.out.println("vehicle = " + vehicle);
    }

    public Car useSetters(String carType) {

        Car car = new Car();

        car.setBody(new CarBody());
        car.setChassis(new CarChassis());
        car.setTransmission(new CarTransmission());

        if ("luxe".equalsIgnoreCase(carType)) {
            car.setSunroof(new CarSunroof());
            car.setClimateControlSystem(new CarClimateControlSystem());
        }

        System.out.println("car = " + car);

        return car;
    }

    public void useBuilder() {

        Vehicle vehicle = VanBuilder.newBuilder()
                .buildBody()
                .buildSunroof()
                .getVehicle();

        Vehicle vehicle2 = VanBuilder.newBuilder()
                .buildBody()
                .buildSunroof()
                .buildSunroof()
                .getVehicle();

        System.out.println("vehicle = " + vehicle);
    }

    public void useBuilderAndDecorator() {
        VehicleBuilder carBuilder = new CarBuilder();
        VehicleBuilder vanBuilder = new VanBuilder();

        VehicleDirector standardDirector = new StandardDirector();

        Vehicle standardCar = standardDirector.build(carBuilder);
        Vehicle standardVan = standardDirector.build(vanBuilder);

        System.out.println("standardCar = " + standardCar);
        System.out.println("standardVan = " + standardVan);

        System.out.println();

        VehicleDirector luxeDirector = new LuxeDirector();

        Vehicle luxeCar = luxeDirector.build(carBuilder);
        Vehicle luxeVan = luxeDirector.build(vanBuilder);

        System.out.println("luxeCar = " + luxeCar);
        System.out.println("luxeVan = " + luxeVan);

    }
}
