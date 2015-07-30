package ru.blogspot.feomatr.lab.patterns.prototype;

/**
 * @author iipolovinkin
 * @since 31.07.2015
 */
public abstract class Brake extends Prototype {
    @Override
    public abstract Brake clone() throws CloneNotSupportedException;
}
