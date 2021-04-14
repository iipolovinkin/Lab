package lab.patterns0.abstractfactory;

//import lab.patterns.abstractfactory.product.*;
import lab.patterns0.abstractfactory.product.Body;
import lab.patterns0.abstractfactory.product.Chassis;
import lab.patterns0.abstractfactory.product.VehicleFactory;
import lab.patterns0.abstractfactory.product.Window;

public class Client3 {

    public static void main(String[] args) {

        carSelector("car");

    }

    public static void carSelector(String carType) {

        Client3 client3 = new Client3();

        VehicleFactory factory;
        if ("car".equalsIgnoreCase(carType)) {
            factory = new CarVehicleFactory();
        } else if ("van".equalsIgnoreCase(carType)) {
            factory = new VanVehicleFactory();
        } else {
            throw new IllegalArgumentException("");
        }

        client3.workWithVehicle(factory);

    }

    private void workWithVehicle(VehicleFactory vehicleFactory) {
        Body body = vehicleFactory.createBody();
        Chassis chassis = vehicleFactory.createChassis();
        Window window = vehicleFactory.createWindow();
        System.out.println("body = " + body.getBodyParts());
    }
}
