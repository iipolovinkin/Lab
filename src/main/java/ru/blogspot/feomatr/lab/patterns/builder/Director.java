package ru.blogspot.feomatr.lab.patterns.builder;

/**
 * Director.
 *
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    void construct() {
        builder.buildBody();
        builder.buildChassis();
        builder.buildEngine();
        builder.buildTransmission();
    }
}
