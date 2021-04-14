package ru.blogspot.feomatr.lab.patterns.structural.decorator;

public class VerticalScrollBarDecorator implements Window {
    private final Window decoratedWindow;

    public VerticalScrollBarDecorator(Window decoratedWindow) {
        this.decoratedWindow = decoratedWindow;
    }

    public void draw() {
        decoratedWindow.draw(); //Delegation
        drawVerticalScrollBar();
    }

    private void drawVerticalScrollBar() {
        // Draw the vertical scrollbar
    }

    public String getDescription() {
        return decoratedWindow.getDescription() + ", including vertical scrollbars";
    }
}