package ru.blogspot.feomatr.lab.patterns.structural.decorator;


public interface Window {
    /**
     * Отрисовать компонент
     */
    void draw();

    /**
     * Описание компонента
     */
    String getDescription();
}