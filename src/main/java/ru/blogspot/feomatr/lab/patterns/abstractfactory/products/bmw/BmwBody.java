package ru.blogspot.feomatr.lab.patterns.abstractfactory.products.bmw;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Body;

/**
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class BmwBody implements Body {

    @Override
    public String toString() {
        return "This is Bmw Body!";
    }
}
