package ru.blogspot.feomatr.lab.patterns.factorymethod;

/**
 * Concrete creator.
 *
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class VazWindShieldCreator extends WindShieldCreator {
    /**
     * Create VazWindShield
     *
     * @return
     */
    @Override
    public WindShield createWindShield() {
        return new VazWindShield();
    }
}
