package ru.blogspot.feomatr.lab.patterns.structural.composite;

public class Label implements Graphic {
    private String name;

    public Label(String name) {
        this.name = name;
    }

    public void paint() {
        // Отрисовать элемент
        System.out.println("Label " + name);
    }

    public void add(Graphic graphic) {
        throw new UnsupportedOperationException();
    }

    public void remove(Graphic graphic) {
        throw new UnsupportedOperationException();
    }

    public Graphic getChild(int index) {
        return null;
    }
}