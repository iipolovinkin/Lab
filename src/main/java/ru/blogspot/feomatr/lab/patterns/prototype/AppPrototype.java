package ru.blogspot.feomatr.lab.patterns.prototype;

import java.util.Arrays;

/**
 * Prototype. The excample create new instances by cloning objects.
 *
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class AppPrototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        PedalsFactory factory;
        Clutch clutch;
        Brake brake;
        Accelerator accelerator;

        factory = new PedalsFactoryImpl(
                new AsianClutch(), new AsianBrake(new String[]{"x1", "x5", "x10"}), new AsianAccelerator());

        clutch = factory.createClutch();
        brake = factory.createBrake();
        accelerator = factory.createAccelerator();

        System.out.println("clutch = " + clutch);
        System.out.println("brake = " + brake);
        System.out.println("accelerator = " + accelerator);


        factory = new PedalsFactoryImpl(
                new EuropeanClutch(), new EuropeanBrake(Arrays.asList(2, 8, 512)), new EuropeanAccelerator());

        clutch = factory.createClutch();
        brake = factory.createBrake();
        accelerator = factory.createAccelerator();

        System.out.println("clutch = " + clutch);
        System.out.println("brake = " + brake);
        System.out.println("accelerator = " + accelerator);


        factory = new PedalsFactoryImpl(
                new EuropeanClutch(), new EuropeanBrake(Arrays.asList(1, 2, 3)), new EuropeanAccelerator());

        clutch = factory.createClutch();
        brake = factory.createBrake();
        accelerator = factory.createAccelerator();

        System.out.println("clutch = " + clutch);
        System.out.println("brake = " + brake);
        System.out.println("accelerator = " + accelerator);
    }
}
