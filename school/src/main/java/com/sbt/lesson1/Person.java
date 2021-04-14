package com.sbt.lesson1;

public final class Person {
    public static final String MALE = "male";
    public static final String FEMALE = "female";

    private String name;
    private int age;
    private String male;

//    public Person(String name, int age, String male) {
//        this.name = name;
//        this.age = age;
//        this.male = male;
//
//    }

    public double getRandomAge() {
        return Math.random() * 18;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
        this.name = "default name";
        this.age = 30;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        age += 10;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", male='" + male + '\'' +
                '}';
    }

    public static void print(){
        System.out.println("person");
    }
}
