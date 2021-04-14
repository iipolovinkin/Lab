package ru.blogspot.feomatr.lab.patterns.builder.products;

import lombok.Setter;
import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.*;

/**
 * Product. Complex product, consists of few parts.
 *
 * @author iipolovinkin
 * @since 30.07.2015
 */
@Setter
public class Van implements Vehicle {
    private Engine engine;
    private Body body;
    private Transmission transmission;
    private Chassis chassis;
    private ClimateControlSystem climateControlSystem;
    private Sunroof sunroof;

    @Override
    public String toString() {
        return "Van{" +
                "engine=" + engine +
                ", body=" + body +
                ", transmission=" + transmission +
                ", chassis=" + chassis +
                ", climateControlSystem=" + climateControlSystem +
                ", sunroof=" + sunroof +
                '}';
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }


    public void setChassis(Chassis chassis) {
        this.chassis = chassis;
    }

    public void setSunroof(Sunroof sunroof) {
        this.sunroof = sunroof;
    }
}
