package ru.blogspot.feomatr.lab.threads.syncAB.devices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.blogspot.feomatr.lab.threads.syncAB.util.SyncEventQueue;
import ru.blogspot.feomatr.lab.threads.syncAB.events.DataAEvent;

/**
 * @author iipolovinkin
 * @since 14.01.2016
 */
public class DeviceA {
	private static final Logger log = LoggerFactory.getLogger(DeviceA.class);
	private SyncEventQueue queue;
	private int portions;
	private long timeout = 1000;

	public DeviceA(SyncEventQueue queue, int i) {
		this.queue = queue;
		this.portions = i;
	}

	public DeviceA(SyncEventQueue queue, int i, long timeout) {
		this.queue = queue;
		this.portions = i;
		this.timeout = timeout;
	}

	public String readData() throws InterruptedException {
		if (portions > 0) {
			String result = "DeviceA.Msg#" + portions;
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
					String string = null;
					try {
						string = readData();
					} catch (InterruptedException e) {
						// открыт вопрос обработки исключений
						log.error("", e);
						return;
					}
					queue.push(new DataAEvent(string));
				}
			}
		}).start();
	}

}
