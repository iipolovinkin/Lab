package ru.blogspot.feomatr.lab.patterns.structural.facadeSImple;

import ru.blogspot.feomatr.lab.patterns.structural.facadeSImple.abc.*;

public class FacadeImpl implements Facade {
    private final SubsystemA subsystemA = new SubsystemA();
    private final SubsystemB subsystemB = new SubsystemB();
    private final SubsystemC subsystemC = new SubsystemC();

    @Override
    public Operation1 operation1() {
        A1 a1 = subsystemA.operationA1();
        B1 b1 = subsystemB.operationB1();
        C1 c1 = subsystemC.operationC1();

        Operation1 operation1 = new Operation1();
        operation1.setA1(a1);
        operation1.setB1(b1);
        operation1.setC1(c1);

        System.out.println("operation1 = " + operation1);

        return operation1;
    }

    @Override
    public Operation2 operation2() {
        Operation2 operation2 = new Operation2();
        operation2.setA2(subsystemA.operationA2());
        operation2.setB2(subsystemB.operationB2());
        operation2.setC2(subsystemC.operationC2());

        System.out.println("operation2 = " + operation2);
        return operation2;
    }
}
