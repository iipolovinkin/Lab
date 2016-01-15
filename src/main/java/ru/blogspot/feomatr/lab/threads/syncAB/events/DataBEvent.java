package ru.blogspot.feomatr.lab.threads.syncAB.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author iipolovinkin
 * @since 14.01.2016
 */
public class DataBEvent extends Event {
	private static final Logger log = LoggerFactory.getLogger(DataBEvent.class);

	public DataBEvent(List<Integer> list) {
		super(list);
	}

	public List<Integer> getData() {
		return (List<Integer>) super.getData();
	}
}
