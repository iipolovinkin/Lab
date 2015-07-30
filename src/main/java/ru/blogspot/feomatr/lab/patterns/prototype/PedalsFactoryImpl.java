package ru.blogspot.feomatr.lab.patterns.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Concrete factory.
 *
 * @author iipolovinkin
 * @since 31.07.2015
 */
public class PedalsFactoryImpl implements PedalsFactory {
    private static final Logger log = LoggerFactory.getLogger(PedalsFactoryImpl.class);

    private Clutch clutch;
    private Brake brake;
    private Accelerator accelerator;

    public PedalsFactoryImpl(Clutch clutch, Brake brake, Accelerator accelerator) {
        this.clutch = clutch;
        this.brake = brake;
        this.accelerator = accelerator;
    }

    @Override
    public Clutch createClutch() {
        try {
            return clutch.clone();
        } catch (CloneNotSupportedException ex) {
            log.error("create Clutch error", ex);
            return null;
        }
    }

    @Override
    public Brake createBrake() {
        try {
            return brake.clone();
        } catch (CloneNotSupportedException ex) {
            log.error("create Brake error", ex);
            return null;
        }
    }

    @Override
    public Accelerator createAccelerator() {
        try {
            return accelerator.clone();
        } catch (CloneNotSupportedException ex) {
            log.error("create Accelerator error", ex);
            return null;
        }
    }
}
