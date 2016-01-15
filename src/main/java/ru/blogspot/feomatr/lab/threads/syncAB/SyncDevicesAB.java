package ru.blogspot.feomatr.lab.threads.syncAB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.blogspot.feomatr.lab.threads.syncAB.devices.DeviceA;
import ru.blogspot.feomatr.lab.threads.syncAB.devices.DeviceB;
import ru.blogspot.feomatr.lab.threads.syncAB.events.Event;
import ru.blogspot.feomatr.lab.threads.syncAB.util.SyncEventQueue;

/**
 * Реализация первого задания <b>"Синхронизация"</b>.
 * <br>
 * <br>Подробное описание находится по ссылке:
 * <a href="https://code.google.com/p/hpcource/wiki/Radar_Tasks_2014#1._%D0%A1%D0%B8%D0%BD%D1%85%D1%80%D0%BE%D0%BD%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D1%8F">hpcource/wiki/Radar_Tasks_2014#1._Синхронизация</a>
 *
 * @author iipolovinkin
 * @since 14.01.2016
 */
public class SyncDevicesAB {
	private static final Logger log = LoggerFactory.getLogger(SyncDevicesAB.class);

	public static void main(String[] args) {
		SyncEventQueue shareQueue = new SyncEventQueue();
		DeviceA deviceA = new DeviceA(shareQueue, 25, 1000);
		DeviceB deviceB = new DeviceB(shareQueue, 5, 5000);
	}
}
