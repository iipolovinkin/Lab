package ru.blogspot.feomatr.lab.patterns.prototype;

/**
 * @author iipolovinkin
 * @since 31.07.2015
 */
public abstract class Clutch extends Prototype {
    @Override
    public abstract Clutch clone() throws CloneNotSupportedException;
}
