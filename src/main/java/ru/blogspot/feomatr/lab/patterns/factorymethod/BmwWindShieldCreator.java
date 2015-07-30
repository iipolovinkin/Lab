package ru.blogspot.feomatr.lab.patterns.factorymethod;

/**
 * Concrete creator.
 *
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class BmwWindShieldCreator extends WindShieldCreator {
    /**
     * Create BmwWindShield
     *
     * @return
     */
    @Override
    public WindShield createWindShield() {
        return new BmwWindShield();
    }
}
