package ru.blogspot.feomatr.lab.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.blogspot.feomatr.lab.spring.buildings.Box;

/**
 * Created by feo on 03.03.15.
 */
public class SpringContainer {

    @Autowired
    private static SpringContainer sc;

    @Autowired
    Box black;
    @Autowired
    Box white;
    @Autowired
    Box red;

//    @Autowired
//    Box beanFromFactoryMethod;

    /**
     * @param args
     */
    public static void main(String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("SpringContainer/spring-context.xml");
        int beanDefinitionCount = context.getBeanDefinitionCount();
        System.out.println("beanDefinitionCount: " + beanDefinitionCount);

        SpringContainer sc = context.getBean(SpringContainer.class);



        System.out.println(sc);
        System.out.println(sc.black);
        System.out.println(sc.white);
        System.out.println(sc.red);

        Box beanFromFactoryMethod = context.getBean("beanFromFactoryMethod", Box.class);
        System.out.println(beanFromFactoryMethod);

        String stringFromBean = context.getBean("stringFromBean", String.class);
        System.out.println("stringFromBean = " + stringFromBean);


    }

    /**
     * @param black
     * @param white
     * @param red
     */
    public SpringContainer(Box black, Box white, Box red ) {
        this.black = black;
        this.white = white;
        this.red = red;
    }

    public static void setSpringContainer(SpringContainer springContainer){
        sc = springContainer;
    }

    public static Box newBox(String description, int square){
        return new Box(description, square);
    }
}
