package ru.blogspot.feomatr.lab.threads.syncAB.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author iipolovinkin
 * @since 14.01.2016
 */
public class DataAEvent extends Event {
	private static final Logger log = LoggerFactory.getLogger(DataAEvent.class);

	public DataAEvent(String data) {
		super(data);
	}

	public String getData() {
		return (String) super.getData();
	}
}
