package ru.blogspot.feomatr.lab.words;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * TODO: comment
 *
 * @author iipolovinkin
 * @since 14.03.2016
 */
public class Utils {
	private static final Logger log = LoggerFactory.getLogger(Utils.class);

	public static String FILE_NAME = "src/main/resources/words/TheGreatLeveller";
	public static String EXT = ".txt";

	public static List<String> fileToList(String fileName) throws IOException {
//		 = ;
		File file = new File(fileName);
		System.out.println(file.getAbsolutePath());
		long length = file.length();
		System.out.println("length = " + length);
		List<String> strings = FileUtils.readLines(file);
		Set<String> words = new HashSet<>();
		Set some_list = new HashSet<>();
//		some_list.addAll(Arrays.asList("didn’t", "wasn’t", ""))

		for (String str : strings) {
			if (StringUtils.isEmpty(str)) {
				continue;
			}
			String[] split = str.split(" ");
			for (String s : split) {
				s = s.replace("\"", "");
				s = s.replace("“", "");
				s = s.replace("”", "");
				s = s.replace(".", "");
				s = s.replace(",", "");
				s = s.replace("?", "");
				s = s.replace("!", "");
				s = s.replace("'t", "");
				s = s.replace("'d", "");
				s = s.replace("'s", "");
				s = s.replace("'", "");
				s = s.replace("-", "");
				s = s.replace("n’t", "");

				if (s.contains("’")) {
					s = s.split("’")[0];
				}

				if (needSkip(s)) {
					continue;
				}

				words.add(s.toLowerCase());
			}
		}

		System.out.println("words.size() = " + words.size());
		return new ArrayList<>(words);

	}

	private static boolean needSkip(String s) {
//		some_list.contains(s);
//		dict.contains(s);
		return false;
	}

	public static void main(String[] args) throws IOException {

		List<String> words = fileToList(FILE_NAME + EXT);
		TreeSet<String> sortedWords = new TreeSet<>(words);
		File fileWords = new File(FILE_NAME + "Words" + EXT);
		System.out.println(fileWords.getAbsolutePath());
		FileUtils.writeLines(fileWords, sortedWords);
	}
}
