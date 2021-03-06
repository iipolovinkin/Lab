package ru.blogspot.feomatr.lab.serialization.xstream;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
* Created by iipolovinkin on 02.01.15.
*/
public class EmployeeWithAttributes extends  Employee{
    @XStreamAsAttribute
    private String firstName;
    @XStreamAsAttribute
    private String secondName;
    @XStreamAsAttribute
    private int age;
    private String[] nickNames;

    public EmployeeWithAttributes(Employee e0) {
        super(e0);
    }

//    public EmployeeWithAttributes(String firstName, String secondName, int age, String[] nickNames) {
//        super(firstName, secondName, age, nickNames);
//    }

}
