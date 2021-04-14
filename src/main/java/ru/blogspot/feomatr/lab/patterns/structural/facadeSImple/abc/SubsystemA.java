package ru.blogspot.feomatr.lab.patterns.structural.facadeSImple.abc;

import ru.blogspot.feomatr.lab.patterns.structural.facadeSImple.abc.A1;
import ru.blogspot.feomatr.lab.patterns.structural.facadeSImple.abc.A2;

public class SubsystemA {
    public A1 operationA1() {
        return new A1();
    }

    public A2 operationA2() {
        return new A2();
    }
}
