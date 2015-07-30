package ru.blogspot.feomatr.lab.patterns.prototype;

/**
 * @author iipolovinkin
 * @since 31.07.2015
 */
public class EuropeanClutch extends Clutch {

    @Override
    public String toString() {
        return "EuropeanClutch{}";
    }

    @Override
    public Clutch clone() throws CloneNotSupportedException {
        return new EuropeanClutch();
    }
}
