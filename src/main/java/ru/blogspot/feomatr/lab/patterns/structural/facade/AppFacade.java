package ru.blogspot.feomatr.lab.patterns.structural.facade;

/**
 * Facade.
 * <p>
 * <b>Definition</b>
 * Provide a unified interface to a set of interfaces in a subsystem.
 * Façade defines a higher-level interface that makes the subsystem easier to use.
 *
 * @author iipolovinkin
 * @since 04.08.2015
 */
public class AppFacade {
    public static void main(String[] args) throws CloneNotSupportedException {
        NewCar car = new NewCar();
        car.start();
        System.out.println();
        car.stop();
    }
}
