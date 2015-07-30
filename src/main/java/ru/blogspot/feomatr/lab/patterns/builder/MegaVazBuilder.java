package ru.blogspot.feomatr.lab.patterns.builder;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.bmw.BmwChassis;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.bmw.BmwEngine;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.bmw.BmwTransmission;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.vaz.VazBody;

/**
 * Concrete Builder. Builds car using BMV parts with VAZ body.
 *
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class MegaVazBuilder implements Builder {

    private Car car;

    public MegaVazBuilder() {
        this.car = new Car();
    }

    @Override
    public void buildBody() {
        car.setBody(new VazBody());
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
