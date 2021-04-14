package ru.blogspot.feomatr.lab.patterns.abstractfactory.products.van;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.ClimateControlSystem;

public class VanClimateControlSystem implements ClimateControlSystem {
    @Override
    public String toString() {
        return "This is Van ClimateControlSystem!";
    }
}
