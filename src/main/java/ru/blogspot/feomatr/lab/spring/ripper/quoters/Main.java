package ru.blogspot.feomatr.lab.spring.ripper.quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.lang.Thread.sleep;

/**
 * @author iipolovinkin
 * @since 05.10.2015
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringContainer/ripper/context.xml");
		while (true) {
			context.getBean(Quoter.class).sayQuote();
			sleep(1000);
		}
	}
}
