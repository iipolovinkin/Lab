package ru.blogspot.feomatr.lab.patterns.structural.facadeSImple.abc;

import ru.blogspot.feomatr.lab.patterns.structural.facadeSImple.abc.C1;
import ru.blogspot.feomatr.lab.patterns.structural.facadeSImple.abc.C2;

public class SubsystemC {
    public C1 operationC1() {
        return new C1();
    }

    public C2 operationC2() {
        return new C2();
    }

}
