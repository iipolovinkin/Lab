package ru.blogspot.feomatr.lab.xstream;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.Arrays;

/**
* Created by iipolovinkin on 02.01.15.
*/
public class Employee implements Serializable{
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Employee employee = (Employee) o;

		return new EqualsBuilder()
				.append(age, employee.age)
				.append(firstName, employee.firstName)
				.append(secondName, employee.secondName)
				.append(nickNames, employee.nickNames)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(firstName)
				.append(secondName)
				.append(age)
				.append(nickNames)
				.toHashCode();
	}
}
