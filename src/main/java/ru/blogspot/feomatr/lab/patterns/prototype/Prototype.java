package ru.blogspot.feomatr.lab.patterns.prototype;

/**
 * Product
 *
 * @author iipolovinkin
 * @since 30.07.2015
 */
public abstract class Prototype implements Cloneable {
    @Override
    public abstract Object clone() throws CloneNotSupportedException;
}
