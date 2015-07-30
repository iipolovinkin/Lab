package ru.blogspot.feomatr.lab.patterns.builder;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.bmw.BmwBody;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.bmw.BmwChassis;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.bmw.BmwEngine;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.bmw.BmwTransmission;

/**
 * Concrete Builder. Builds car using BMW parts.
 *
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class BmwBuilder implements Builder {
    private Car car;

    public BmwBuilder() {
        this.car = new Car();
    }

    @Override
    public void buildBody() {
        car.setBody(new BmwBody());
    }

    @Override
    public void buildChassis() {
        car.setChassis(new BmwChassis());
    }

    @Override
    public void buildEngine() {
        car.setEngine(new BmwEngine());
    }

    @Override
    public void buildTransmission() {
        car.setTransmission(new BmwTransmission());
    }

    @Override
    public Car getCar() {
        return car;
    }
}
