package ru.blogspot.feomatr.lab.patterns.abstractfactory.products;

public interface Vehicle {
    void setEngine(Engine engine);

    void setBody(Body body);

    void setTransmission(Transmission transmission);

    void setChassis(Chassis chassis);

    void setSunroof(Sunroof sunroof);

    void setClimateControlSystem(ClimateControlSystem climateControlSystem);
}
