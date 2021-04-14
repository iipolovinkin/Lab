package com.sbt.lesson1;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoClass implements Client, Serializable {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();

        System.out.println(Client.ВОЗРАСТ_СОВЕРШЕННОЛЕТИЯ_В_РФ);

        person1.setMale(Person.MALE);
        person1.setName("Ivan");
        int x = 123;
        System.out.println("x = " + x);


        changePerson(person1);
//
//        System.out.println(person1);
//
//        System.out.println("x = " + x);

        Person.print();


//        person2.setMale(Person.FEMALE);
//        System.out.println(person2);
    }


    private static void changeLong(List<Integer> list) {
        list.forEach(System.out::println);
    }

    private static void changePerson(Person person1) {
        person1.setName("newName");
    }

    private static void changePerson(String name) {
        System.out.println("name = " + name);
    }

    public static void test() {
        List<String> list = new ArrayList<>();


        list.add("s1");
        list.add("s2");
        list.add("s3");
        list.add("s4");
        list.add("s5");
        list.add("hello");
        int[][] a = new int[10][2];

//        System.out.println("list = " + list);
        list.forEach(a1 -> System.out.println("a1 = " + a1));
        for (int[] e : a) {
            System.out.print("e = " + Arrays.toString(e) + ", ");
        }
    }

    static void someMethod() {
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException();
    }
}
