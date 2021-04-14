package ru.blogspot.feomatr.lab.patterns.abstractfactory.products.van;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Body;

public class VanBody implements Body {

    @Override
    public String toString() {
        return "This is Van Body!";
    }
}
