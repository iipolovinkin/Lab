package ru.blogspot.feomatr.lab.serialization.xstream;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
* Created by iipolovinkin on 02.01.15.
*/
public class EmployeeOmitedAge extends  Employee{
    @XStreamOmitField
    private int age;

    public EmployeeOmitedAge() {
        super();
    }

}
