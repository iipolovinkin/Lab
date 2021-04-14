package ru.blogspot.feomatr.lab.patterns.structural.facadeSImple;

public class MainFacade {
    public static void main(String[] args) {
        Facade facadeImpl = new FacadeImpl();

        facadeImpl.operation1();
        facadeImpl.operation2();
    }
}
