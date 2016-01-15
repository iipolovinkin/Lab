package ru.blogspot.feomatr.lab.threads.syncAB.devices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.blogspot.feomatr.lab.threads.syncAB.util.SyncEventQueue;
import ru.blogspot.feomatr.lab.threads.syncAB.events.DataBEvent;

import java.util.Arrays;
import java.util.List;

/**
 * @author iipolovinkin
 * @since 14.01.2016
 */
public class DeviceB {
	private static final Logger log = LoggerFactory.getLogger(DeviceB.class);
	private SyncEventQueue queue;
	private int portions;
	private long timeout = 5000;

	public DeviceB(SyncEventQueue queue, int i) {
		this.queue = queue;
		this.portions = i;
	}

	public DeviceB(SyncEventQueue queue, int i, long timeout) {
		this.queue = queue;
		this.portions = i;
		this.timeout = timeout;
	}

	public List<Integer> readData() throws InterruptedException {
		if (portions > 0) {
			Integer a = 100 + portions;
			Integer b = 200 + portions;
			Integer c = 300 + portions;
			List<Integer> result = Arrays.asList(a, b, c);
			--portions;
			Thread.sleep(timeout);
			return result;
		}
		return null;
	}

	private void start() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					List<Integer> list = null;
					try {
						list = readData();
					} catch (InterruptedException e) {
						// открыт вопрос обработки исключений
						log.error("", e);
						return;
					}
					queue.push(new DataBEvent(list));
				}
			}
		}).start();
	}

}
