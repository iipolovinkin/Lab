package ru.blogspot.feomatr.lab.patterns.structural.decorator;

class SimpleWindow implements Window {
    public void draw() {
        // Draw window
    }

    public String getDescription() {
        return "simple window";
    }
}