package ru.blogspot.feomatr.lab.patterns.builder;

/**
 * The example uses concrete builders to create different cars. GoF.
 *
 * @author iipolovinkin
 * @since 30.07.2015
 */
public class AppBuilder {
    public static void main(String[] args) {
        AppBuilder appBuilder = new AppBuilder();
        appBuilder.buildBmwCar();
        appBuilder.buildVazCar();
        appBuilder.buildMegaVazCar();

        System.out.println("We can instantiate any builder: \n" + appBuilder.buildCar(new BmwBuilder()));

    }

    private void buildBmwCar() {
        Builder builder = new BmwBuilder();
        Director director = new Director(builder);
        director.construct();
        Car bmwCar = builder.getCar();
        System.out.println("bmwCar = " + bmwCar);
    }

    private void buildVazCar() {
        Builder builder = new VazBuilder();
        Director director = new Director(builder);
        director.construct();
        Car vazCar = builder.getCar();
        System.out.println("vazCar = " + vazCar);
    }

    private void buildMegaVazCar() {
        Builder builder = new MegaVazBuilder();
        Director director = new Director(builder);
        director.construct();
        Car megaVazCar = builder.getCar();
        System.out.println("megaVazCar = " + megaVazCar);
    }

    private Car buildCar(Builder builder) {
        Director director = new Director(builder);
        director.construct();
        return builder.getCar();
    }
}
