package ru.blogspot.feomatr.lab.patterns.structural.facadeSImple.abc;

import ru.blogspot.feomatr.lab.patterns.structural.facadeSImple.abc.B1;
import ru.blogspot.feomatr.lab.patterns.structural.facadeSImple.abc.B2;

public class SubsystemB {
    public B1 operationB1() {
        return new B1();
    }

    public B2 operationB2() {
        return new B2();
    }

}
