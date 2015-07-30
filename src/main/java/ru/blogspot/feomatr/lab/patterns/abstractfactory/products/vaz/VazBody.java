package ru.blogspot.feomatr.lab.patterns.abstractfactory.products.vaz;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Body;

/**
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class VazBody implements Body {

    @Override
    public String toString() {
        return "This is Vaz Body!";
    }
}
