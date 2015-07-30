package ru.blogspot.feomatr.lab.patterns.prototype;

/**
 * @author iipolovinkin
 * @since 31.07.2015
 */
public class AsianClutch extends Clutch {

    @Override
    public String toString() {
        return "AsianClutch{}";
    }

    @Override
    public Clutch clone() throws CloneNotSupportedException {
        return new AsianClutch();
    }
}
