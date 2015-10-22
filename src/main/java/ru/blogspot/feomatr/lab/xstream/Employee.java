package ru.blogspot.feomatr.lab.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Arrays;

/**
* Created by iipolovinkin on 02.01.15.
*/
public class Employee {
    private String firstName;
    private String secondName;
    private int age;
    private String[] nickNames;

    public Employee() {
        super();
    }

    public Employee(String firstName, String secondName, int age, String[] nickNames) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.nickNames = nickNames;
    }

    public Employee(Employee e){
        this.firstName = e.getFirstName();
        this.secondName = e.getSecondName();
        this.age = e.getAge();
        this.nickNames = Arrays.copyOf(e.getNickNames(), e.getNickNames().length);
    }
    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public String[] getNickNames() {
        return nickNames;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", nickNames=" + Arrays.toString(nickNames) +
                '}';
    }
}
