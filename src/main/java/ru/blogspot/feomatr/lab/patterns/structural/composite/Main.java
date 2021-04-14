package ru.blogspot.feomatr.lab.patterns.structural.composite;

public class Main {
    public static void main(String[] args) {
        Label label1 = new Label("label1");
        Label label2 = new Label("label2");
        Label label3 = new Label("label3");
        Label label4 = new Label("label4");

        Panel panel = new Panel("panel");

        Panel panel1 = new Panel("panel1");
        Panel panel2 = new Panel("panel2");

        //Composes the panels
        panel1.add(label1);
        panel1.add(label2);
        panel1.add(label3);
        panel2.add(label4);
        panel.add(panel1);
        panel.add(panel2);

        panel.paint();
    }
}
