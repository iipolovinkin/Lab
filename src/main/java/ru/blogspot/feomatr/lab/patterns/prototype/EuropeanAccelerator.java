package ru.blogspot.feomatr.lab.patterns.prototype;

/**
 * @author iipolovinkin
 * @since 31.07.2015
 */
public class EuropeanAccelerator extends Accelerator {

    @Override
    public String toString() {
        return "EuropeanAccelerator{}";
    }

    @Override
    public Accelerator clone() throws CloneNotSupportedException {
        return new EuropeanAccelerator();
    }
}
