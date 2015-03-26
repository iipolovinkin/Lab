package ru.blogspot.feomatr.lab.xstream;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Arrays;

/**
* Created by feo on 02.01.15.
*/
public class EmployeeOmitedAge extends  Employee{
    @XStreamOmitField
    private int age;

    public EmployeeOmitedAge() {
        super();
    }

}
