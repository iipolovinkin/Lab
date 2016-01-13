package ru.blogspot.feomatr.lab.io;

import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author polovinkin.igor
 * @since 22.10.2015
 */
public class FileDemos {
	private static final Logger log = LoggerFactory.getLogger(FileDemos.class);

	public static void main(String[] args) throws IOException {



		testWildCardFilter(new String[]{"*test*.java~*~"});
		testWildCardFilter(new String[]{"*.xml"});
		testWildCardFilter(new String[]{"*.*"});

		//6035_9e3c01b3-5db9-4a57-a677-b223c83b5f3a_MSC_RegistryAccount.xml
		testWildCardFilter(new String[]{"*_MSC_RegistryAccount.xml"});

//		removeExtraLogs();
		testListFiles();
	}

	public static void removeExtraLogs() {
		int COUNT_OF_SAVED_DAYS = 10;
		String log_backups = "/media/polovinkin/sdb1/stands/sufd_stand/logs_backups";

		File[] files1 = new File(log_backups).listFiles();
		if (files1.length < COUNT_OF_SAVED_DAYS) {
			return;
		}

		Arrays.sort(files1);

		int indexBeforeCountDays = getIndexBeforeCountDays(files1, 10);
		if (indexBeforeCountDays < 0) {
			return;
		}

		for (int i = indexBeforeCountDays; i > -1; i--) {
			try {
				FileUtils.forceDelete(files1[i]);
			} catch (IOException e) {
				log.error("", e);
			}
		}


	}

	/**
	 * Возвращает index, такой, что элементы списка 0..index являются старее, чем Count различных дней.
	 * @param files
	 * @param Count
	 * @return
	 */
	private static int getIndexBeforeCountDays(@NotNull File[] files, int Count) {
		int daysCount = 1;
		String currentDay = getDay(files[files.length - 1].getName());
		System.out.println(daysCount + " currentDay = " + currentDay);

		for (int i = files.length - 2; i > 0; i--) {
			String name = files[i].getName();
			if (!isValid(name)) {
				continue;
			}

			if (!currentDay.equals(getDay(name))) {
				daysCount++;
				currentDay = getDay(name);
				System.out.println(daysCount + " currentDay = " + currentDay);
				if (daysCount > Count - 1) {
					return i - 1;
				}
			}
		}

		return -1;
	}

	private static boolean isValid(@NotNull String name) {
		return name.startsWith("logs_") && name.length() >= 13;
	}

	private static String getDay(String logName) {
		return logName.substring(5, 13);
	}

	public static void testListFiles() {
		String pathFolder = ".";
		Collection<File> files = FileUtils.listFiles(new File(pathFolder), null, false);
//		Collection<File> files2 = FileUtils.listFilesAndDirs(new File(pathFolder), FalseFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		System.out.println("Print files only: ");
		for (File file : files) {
			System.out.println("file = " + file.getName());
		}

		System.out.println("");
		System.out.println("Print files and directories: ");
		for (String s : new File(pathFolder).list()) {
			System.out.println(" = " + s);
		}

	}

	public static void testWildCardFilter(String[] masks) {
		System.out.println("start testWildCardFilter with masks = " + Arrays.toString(masks));
		File dir = new File(FileDemos.class.getResource("").getPath());
		FileFilter fileFilter = new WildcardFileFilter(masks, IOCase.SYSTEM);
		File[] files = dir.listFiles(fileFilter);
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
		}
	}

}
