package ru.blogspot.feomatr.lab.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import ru.blogspot.feomatr.lab.spring.buildings.Box;

/**
 * @author iipolovinkin@yandex.ru
 * @since 08.08.2016
 */
public class MyApplicationListener implements ApplicationListener {
	private static final Logger log = LoggerFactory.getLogger(MyApplicationListener.class);

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			ContextRefreshedEvent ev = (ContextRefreshedEvent) event;
			ApplicationContext source = (ApplicationContext) ev.getSource();
			String[] beanNamesForType = source.getBeanNamesForType(Box.class);
			log.debug("event = " + source);
			for (String s : beanNamesForType) {
				log.debug("beanNamesForType = " + s);
			}
		}

	}
}
