package ru.blogspot.feomatr.lab.regexp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * https://ru.wikipedia.org/wiki/Регулярные_выражения
 * @author polovinkin.igor
 * @since 02.11.2015
 */
public class RegexpDemo {
	private static final Logger log = LoggerFactory.getLogger(RegexpDemo.class);


	public static void main(String[] args) {
//		testCount();
//		test3Points();
		testDate();

	}

	private static void test3Points() {
		Pattern pattern = Pattern.compile("\\.{3}.*"); //паттерн: должно быть три точки и потом неважно какие символы
		List<String> string = Arrays.asList(new String[]{".", "..", "...", ".....", "...asd"});
		for (String s : string) {
			System.out.println("s = " + s + " , matches: " + pattern.matcher(s).matches());
		}

	}

	private static void testDate() {
		Pattern pattern = Pattern.compile("\\d{4}\\.\\d{2}\\.\\d{2}.*"); //паттерн: YYYY.MM.DD*
		List<String> string = Arrays.asList(new String[]{"2015", "2015.10.", "2015.10.12.", "2015.11.03aslkdfhkjsbdfjbas", "...asd"});

		for (String s : string) {
			System.out.println("s = " + s + " , matches: " + pattern.matcher(s).matches());
		}
	}

	//		Представление 	Число повторений 	Пример 	Соответствие
	//		{n} 	Ровно n раз 	colou{3}r 	colouuur
	//		{m,n} 	От m до n включительно 	colou{2,4}r 	colouur, colouuur, colouuuur
	//		{m,} 	Не менее m 	colou{2,}r 	colouur, colouuur, colouuuur и т. д.
	//		{,n} 	Не более n 	colou{,3}r 	color, colour, colouur, colouuur
	public static void testCount() {
		String prefix = "prefix";
		Pattern pattern = Pattern.compile(prefix + "\\d{8,}"); //паттерн: должно быть не менее 8 цифр после слова prefix

		List<String> string = Arrays.asList(new String[]{"pref", prefix + "20151102", prefix + "201511021733", prefix + "1234", prefix + "12345", prefix + "1"});
		for (String s : string) {
			System.out.println("s = " + s + " , matches: " + pattern.matcher(s).matches());
		}
	}
}
