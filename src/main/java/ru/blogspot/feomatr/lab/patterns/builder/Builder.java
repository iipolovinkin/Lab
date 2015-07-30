package ru.blogspot.feomatr.lab.patterns.builder;

/**
 * @author iipolovinkin
 * @since 30.07.2015
 */
public interface Builder {

    void buildBody();

    void buildChassis();

    void buildEngine();

    void buildTransmission();

    Car getCar();
}
