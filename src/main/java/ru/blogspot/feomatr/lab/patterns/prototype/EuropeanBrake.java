package ru.blogspot.feomatr.lab.patterns.prototype;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author iipolovinkin
 * @since 31.07.2015
 */
public class EuropeanBrake extends Brake {
    private List<Integer> states = new ArrayList<>();

    public EuropeanBrake(List<Integer> states) {
        setStates(states);
    }

    @Override
    public String toString() {
        return "EuropeBrake{" +
                "states=" + states +
                '}';
    }

    @Override
    public Brake clone() throws CloneNotSupportedException {
        EuropeanBrake europeanBrake = new EuropeanBrake(states);
        return europeanBrake;
    }

    public void setStates(@NotNull List<Integer> states) {
        this.states.clear();
        this.states.addAll(states);
    }
}
