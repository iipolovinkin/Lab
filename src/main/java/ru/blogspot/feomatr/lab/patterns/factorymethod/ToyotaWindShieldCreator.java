package ru.blogspot.feomatr.lab.patterns.factorymethod;

/**
 * Concrete creator.
 *
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class ToyotaWindShieldCreator extends WindShieldCreator {
    /**
     * Create ToyotaWindShield
     *
     * @return
     */
    @Override
    public WindShield createWindShield() {
        return new ToyotaWindShield();
    }
}
