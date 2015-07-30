package ru.blogspot.feomatr.lab.patterns.abstractfactory.products.vaz;

import ru.blogspot.feomatr.lab.patterns.abstractfactory.products.Engine;

/**
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class VazEngine implements Engine {

    @Override
    public String toString() {
        return "This is Vaz Engine!";
    }
}
