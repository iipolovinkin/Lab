package ru.blogspot.feomatr.lab.patterns.structural.decorator;

public class Main {
    public static void main(String[] args) {
        // Create a decorated Window with horizontal and vertical scrollbars
        Window decoratedWindow = new HorizontalScrollBarDecorator(
                new VerticalScrollBarDecorator(new SimpleWindow()));

        // Print the Window's description
        System.out.println(decoratedWindow.getDescription());
        System.out.println(new VerticalScrollBarDecorator(new SimpleWindow()).getDescription());
    }
}
