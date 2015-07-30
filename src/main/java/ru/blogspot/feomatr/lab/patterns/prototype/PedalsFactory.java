package ru.blogspot.feomatr.lab.patterns.prototype;

/**
 * Abstract Pedals Factory.
 *
 * @author iipolovinkin
 * @since 31.07.2015
 */
public interface PedalsFactory {

    Clutch createClutch();

    Brake createBrake();

    Accelerator createAccelerator();
}
