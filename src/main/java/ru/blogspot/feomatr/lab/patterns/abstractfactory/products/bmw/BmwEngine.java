package ru.blogspot.feomatr.lab.patterns.abstractfactory.products.bmw;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Engine;

/**
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class BmwEngine implements Engine {

    @Override
    public String toString() {
        return "This is Bmw Engine!";
    }
}
