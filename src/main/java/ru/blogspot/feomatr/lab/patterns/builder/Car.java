package ru.blogspot.feomatr.lab.patterns.builder;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Body;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Chassis;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Engine;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Transmission;

/**
 * Product. Complex product, consists of few parts.
 *
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class Car {
    private Engine engine;
    private Body body;
    private Transmission transmission;
    private Chassis chassis;

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", body=" + body +
                ", transmission=" + transmission +
                ", chassis=" + chassis +
                '}';
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Chassis getChassis() {
        return chassis;
    }

    public void setChassis(Chassis chassis) {
        this.chassis = chassis;
    }
}
