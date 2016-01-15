package ru.blogspot.feomatr.lab.threads.syncAB.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author iipolovinkin
 * @since 14.01.2016
 */
public class Event {
	private static final Logger log = LoggerFactory.getLogger(Event.class);
	private Object data;

	Event(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}
}
