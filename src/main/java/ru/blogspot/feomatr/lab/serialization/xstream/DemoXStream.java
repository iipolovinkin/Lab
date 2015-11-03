package ru.blogspot.feomatr.lab.serialization.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by iipolovinkin on 04.01.15.
 */
public class DemoXStream {

    public static void main(String[] args) {
        String[] args_ = new String[]{"/tmp/employeedata.txt"};

        Employee e0 = new Employee("Jim", "Smith", 25, new String[]{"fatboy", "stranger", "eagle"});
        Employee e = new Employee();
        EmployeeOmitedAge e2 = new EmployeeOmitedAge();

        System.out.println("\nEmployee:");
        writeXStream(args_, e0);
        readXStream(args_, e);

        System.out.println("\nOmited Age:");
        writeXStream(args_, e0);
        readXStream(args_, e2);


        System.out.println("\nEmployee:");
        writeXStream(args_, e0, System.out);

        EmployeeWithAttributes ewa = new EmployeeWithAttributes(e0);
        System.out.println("\n\nEmployeeWithAttributes:");
        writeXStream(args_, ewa, System.out);

    }

    static void writeXStream(String[] args, Employee e) {
        writeXStream(args, e, null);
    }
    static void writeXStream(String[] args, Employee e, OutputStream os) {
        System.out.println("Write: " + e);

        XStream xs = new XStream();
        try {
            if (os == null) {
                FileOutputStream fs = new FileOutputStream(args[0]);
                xs.toXML(e, fs);
            } else {
                xs.toXML(e, os);
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

    }

    static void readXStream(String[] args, @NotNull Employee e) {
        XStream xs = new XStream(new DomDriver());
        try {
            FileInputStream fis = new FileInputStream(args[0]);
            xs.fromXML(fis, e);

//			return десериализованного объекта
            System.out.println("Read: " + e);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
