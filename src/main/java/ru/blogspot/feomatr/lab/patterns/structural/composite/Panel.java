package ru.blogspot.feomatr.lab.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Panel implements Graphic {
    private final List<Graphic> childGraphics = new ArrayList<>();
    private final String name;

    public Panel(String name) {
        this.name = name;
    }

    public void paint() {
        for (Graphic graphic : childGraphics) {
            graphic.paint();
        }
        System.out.println("Panel name = " + name);
    }

    public void add(Graphic graphic) {
        childGraphics.add(graphic);
    }

    public void remove(Graphic graphic) {
        childGraphics.remove(graphic);
    }

    public Graphic getChild(int index) {
        return childGraphics.get(index);
    }
}