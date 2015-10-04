package ru.blogspot.feomatr.lab.spring.ripper.quoters;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author iipolovinkin
 * @since 05.10.2015
 */
public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringContainer/ripper/context.xml");
		context.getBean(TerminatorQuoter.class).sayQuote();
	}
}
