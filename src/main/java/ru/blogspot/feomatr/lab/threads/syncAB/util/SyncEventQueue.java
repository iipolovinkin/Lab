package ru.blogspot.feomatr.lab.threads.syncAB.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.blogspot.feomatr.lab.threads.syncAB.events.Event;

import java.util.LinkedList;
import java.util.List;

/**
 * @author iipolovinkin
 * @since 14.01.2016
 */
public class SyncEventQueue implements EventQueue {
	private static final Logger log = LoggerFactory.getLogger(SyncEventQueue.class);
	private List<Event> list = new LinkedList<>();


	@Override
	public void push(Event event) {
		list.add(event);
	}

	@Override
	public Event pop(long duration) {
		if (!list.isEmpty()) {
			return list.remove(0);
		}
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			log.error("", e);
			return null;
		}
		if (!list.isEmpty()) {
			return list.remove(0);
		}
		return null;
	}

	public Event pop() {
		if (list.isEmpty()) {
			return null;
		}
		return list.remove(0);
	}
}
