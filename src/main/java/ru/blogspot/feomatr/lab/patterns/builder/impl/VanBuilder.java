package ru.blogspot.feomatr.lab.patterns.builder.impl;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Vehicle;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.van.VanBody;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.van.VanChassis;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.van.VanClimateControlSystem;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.van.VanSunroof;
import ru.blogspot.feomatr.lab.patterns.builder.VehicleBuilder;
import ru.blogspot.feomatr.lab.patterns.builder.products.Van;

public class VanBuilder implements VehicleBuilder {

    private Vehicle van = new Van();

    public VanBuilder() {
        this.van = new Van();
    }

    public static VehicleBuilder newBuilder() {
        return new VanBuilder();
    }

    @Override
    public VehicleBuilder buildBody() {
        van.setBody(new VanBody());
        return this;
    }

    @Override
    public void buildChassis() {
        van.setChassis(new VanChassis());
    }

    @Override
    public void buildPassengerArea() {
        //111
    }

    @Override
    public Vehicle getVehicle() {
        return van;
    }

    @Override
    public void buildClimateControlSystem() {
        van.setClimateControlSystem(new VanClimateControlSystem());
    }

    @Override
    public VehicleBuilder buildSunroof() {
        van.setSunroof(new VanSunroof());
        return this;
    }

    @Override
    public void buildWindows() {
    }
}
