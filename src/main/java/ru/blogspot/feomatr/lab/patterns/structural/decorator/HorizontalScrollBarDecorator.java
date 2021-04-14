package ru.blogspot.feomatr.lab.patterns.structural.decorator;

public class HorizontalScrollBarDecorator implements Window {
    private final Window decoratedWindow;

    public HorizontalScrollBarDecorator(Window decoratedWindow) {
        this.decoratedWindow = decoratedWindow;
    }

    public void draw() {
        decoratedWindow.draw(); //Delegation
        drawhorizontalScrollBar();
    }

    private void drawhorizontalScrollBar() {
        // Draw the horizontal scrollbar
    }

    public String getDescription() {
        return decoratedWindow.getDescription() + ", including horizontal scrollbars";
    }
}