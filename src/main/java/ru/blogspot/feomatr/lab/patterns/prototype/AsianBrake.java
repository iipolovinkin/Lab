package ru.blogspot.feomatr.lab.patterns.prototype;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * @author iipolovinkin
 * @since 31.07.2015
 */
public class AsianBrake extends Brake {
    private String[] states = {};

    public AsianBrake(String[] states) {
        setStates(states);
    }

    @Override
    public String toString() {
        return "AsianBrake{" +
                "states=" + Arrays.toString(states) +
                '}';
    }

    @Override
    public Brake clone() throws CloneNotSupportedException {
        AsianBrake asianBrake = new AsianBrake(states);
        return asianBrake;
    }

    public void setStates(String[] states) {
        this.states = Arrays.copyOf(states, states.length);
    }
}
