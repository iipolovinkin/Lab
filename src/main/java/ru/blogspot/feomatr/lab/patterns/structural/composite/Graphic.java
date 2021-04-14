package ru.blogspot.feomatr.lab.patterns.structural.composite;

public interface Graphic {
    /**
     * Отрисовать компонент
     */
    void paint();

    /**
     * Добавить компонент
     */
    void add(Graphic graphic);

    /**
     * Удалить компонент
     */
    void remove(Graphic graphic);

    /**
     * Получить компонент
     */
    Graphic getChild(int index);
}
