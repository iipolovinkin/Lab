package ru.blogspot.feomatr.lab.patterns.factorymethod;

/**
 * The example create windshields by concrete creators.
 *
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class AppFactoryMethod {
    public static void main(String[] args) {
        WindShield windShield1 = new BmwWindShieldCreator().createWindShield();
        System.out.println("windShield1 = " + windShield1);
        WindShield windShield2 = new VazWindShieldCreator().createWindShield();
        System.out.println("windShield2 = " + windShield2);
        WindShield windShield3 = new ToyotaWindShieldCreator().createWindShield();
        System.out.println("windShield3 = " + windShield3);
    }
}
