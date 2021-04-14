package ru.blogspot.feomatr.lab.patterns.abstractfactory.products.van;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Engine;

public class VanEngine implements Engine {

    @Override
    public String toString() {
        return "This is Van Engine!";
    }
}
