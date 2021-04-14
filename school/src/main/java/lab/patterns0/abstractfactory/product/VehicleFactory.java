package lab.patterns0.abstractfactory.product;

public interface VehicleFactory {

    Body createBody();

    Window createWindow();

    Chassis createChassis();
}
