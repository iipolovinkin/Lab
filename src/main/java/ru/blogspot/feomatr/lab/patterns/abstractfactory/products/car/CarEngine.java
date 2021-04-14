package ru.blogspot.feomatr.lab.patterns.abstractfactory.products.car;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Engine;

public class CarEngine implements Engine {

    @Override
    public String toString() {
        return "This is Car Engine!";
    }
}
