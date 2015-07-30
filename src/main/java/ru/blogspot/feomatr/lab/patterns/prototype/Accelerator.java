package ru.blogspot.feomatr.lab.patterns.prototype;

/**
 * @author iipolovinkin
 * @since 31.07.2015
 */
public abstract class Accelerator extends Prototype {
    @Override
    public abstract Accelerator clone() throws CloneNotSupportedException;
}
