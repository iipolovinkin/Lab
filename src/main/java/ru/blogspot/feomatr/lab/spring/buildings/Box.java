package ru.blogspot.feomatr.lab.spring.buildings;

import lombok.ToString;

import java.util.List;

/**
 * Created by iipolovinkin on 03.03.15.
 */

public class Box {
    private String description;
    private int square;

    public Box() {
    }

    public Box(String description, int square) {
        this.description = description;
        this.square = square;
    }

    public Box(List b) {
        this.description = (String) b.get(0);
        this.square = Integer.valueOf((String) b.get(1));
    }

    @Override
    public String toString() {
        return "Box{" +
                "description='" + description + '\'' +
                ", square=" + square +
                '}';
    }

    void init(){
        System.out.println("init " + toString());
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
