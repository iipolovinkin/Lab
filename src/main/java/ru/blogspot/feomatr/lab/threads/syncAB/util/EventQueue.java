package ru.blogspot.feomatr.lab.threads.syncAB.util;

import ru.blogspot.feomatr.lab.threads.syncAB.events.Event;

/**
 * @author iipolovinkin
 * @since 14.01.2016
 */
public interface EventQueue {

	/**
	 * Положить сообщение в очередь
	 */
	void push(Event event);

	/**
	 * Удалить сообщение из очереди и вернуть его
	 * По истечении duration, если очередь пуста, вернуть пустой указатель
	 */
	Event pop(long duration);
}
