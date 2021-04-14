package ru.blogspot.feomatr.lab.patterns.abstractfactory.products.car;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Body;

public class CarBody implements Body {

    @Override
    public String toString() {
        return "This is Car Body!";
    }
}
