package ru.blogspot.feomatr.lab.guava;


import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import ru.blogspot.feomatr.lab.xstream.Employee;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterators.filter;
import static com.google.common.collect.Lists.transform;


/**
 * Created by iipolovinkin on 19.02.15.
 */
public class DemoGuava {
    public static void main(String[] args) {
        List<Employee> e = Lists.newArrayList();
        e.add(new Employee("Jim", "Smith", 25, new String[]{"fatboy", "stranger", "eagle"}));
        e.add(new Employee("Jane", "Smith", 18, new String[]{"thingirl", "stranger", "crow"}));
        e.add(new Employee("Ivan", "Sidorov", 25, new String[]{"fatboy", "stranger", "Turkey"}));
        e.add(new Employee("Nikolay", "Sidorov", 65, new String[]{"thinboy", "stranger", "Woodpecker"}));
        e.add(new Employee("Dmitriy", "Trishechkin", 35, new String[]{"fatboy", "stranger", "Rawen"}));




        List<Employee> filtered = Lists.newArrayList(Collections2.filter(e, new Predicate<Employee>() {
            @Override
            public boolean apply(Employee input) {
                return input.getAge() > 25;
            }
        }));
        List<String> birds = Lists.transform(filtered, new Function<Employee, String>() {
            @Override
            public String apply(Employee input) {
                return input.getNickNames()[2];
            }
        });

//                transform(filter(e.iterator(), new Predicate<Employee>() {
//                            @Override
//                            public boolean apply(Employee input) {
//                                return input.getAge() > 25;
//                            }
//                        }),
//                        new Function<Employee, String>() {
//                            @Override
//                            public String apply(Employee input) {
//                                return input.getNickNames()[2];
//                            }
//                        });

        for (String bird : birds){
            System.out.println(bird);
        }


    }
}
