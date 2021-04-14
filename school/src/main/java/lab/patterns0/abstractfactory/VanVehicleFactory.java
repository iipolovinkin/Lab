package lab.patterns0.abstractfactory;

import lab.patterns0.abstractfactory.product.Body;
import lab.patterns0.abstractfactory.product.Chassis;
import lab.patterns0.abstractfactory.product.VehicleFactory;
import lab.patterns0.abstractfactory.product.Window;

public class VanVehicleFactory implements VehicleFactory {
    @Override
    public Body createBody() {
        return null;
    }

    @Override
    public Window createWindow() {
        return null;
    }

    @Override
    public Chassis createChassis() {
        return null;
    }
}
