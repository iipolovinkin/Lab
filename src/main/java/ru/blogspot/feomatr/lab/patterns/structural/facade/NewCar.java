package ru.blogspot.feomatr.lab.patterns.structural.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author iipolovinkin
 * @since 04.08.2015
 */
public class NewCar {
    private static final Logger log = LoggerFactory.getLogger(NewCar.class);
    private FEngine engine;
    private SparkLight sparkPlug;
    private BoardComputer boardComputer;

    public NewCar() {
        engine = new FEngine();
        sparkPlug = new SparkLight();
        boardComputer = new BoardComputer();
    }

    public void start() {
        System.out.println("starting car");
        boardComputer.changeMode(ComputerMode.START_MODE);
        sparkPlug.light();
        engine.start();
    }

    public void stop() {
        System.out.println("stopping car");
        engine.stop();
        boardComputer.changeMode(ComputerMode.STOP_MODE);
    }

    private class FEngine {
        public void start() {
            System.out.println("engine started");
        }

        public void stop() {
            System.out.println("engine stopped");
        }
    }

    private class SparkLight {
        public void light() {
            System.out.println("light It");
        }
    }

    private class BoardComputer {
        public void changeMode(ComputerMode mode) {
            System.out.println("computer change mode to " + mode);
        }
    }
}
