package ru.blogspot.feomatr.lab.patterns.builder;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.vaz.VazBody;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.vaz.VazChassis;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.vaz.VazEngine;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.vaz.VazTransmission;

/**
 * Concrete Builder. Builds car using VAZ parts.
 *
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class VazBuilder implements Builder {

    private Car car;

    public VazBuilder() {
        this.car = new Car();
    }

    @Override
    public void buildBody() {
        car.setBody(new VazBody());
    }

    @Override
    public void buildChassis() {
        car.setChassis(new VazChassis());
    }

    @Override
    public void buildEngine() {
        car.setEngine(new VazEngine());
    }

    @Override
    public void buildTransmission() {
        car.setTransmission(new VazTransmission());
    }

    @Override
    public Car getCar() {
        return car;
    }
}
