package ru.blogspot.feomatr.lab.commons;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Formatter;

/**
 * @author iipolovinkin
 * @since 25.04.2015
 */
public class StringDemo {
    private static final Logger log = LoggerFactory.getLogger(StringDemo.class);

    public static void main(String[] args) {
		googleStrings();
        useFormatter();
    }

    public static void useFormatter() {
        System.out.println("StringDemo.useFormatter, using Formatter");

//      documentation http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
        new Formatter();
        System.out.println(String.format("Duke's Birthday: %1$tm %1$te,%1$tY", Calendar.getInstance()));
        System.out.println(String.format("Duke's Birthday: %1$te %1$tm,%1$tY", Calendar.getInstance()));
//        %1 - первый аргумент; $t - формат время, d - days: 01..31
//        %2 - 2-й аргумент; $08d - d - целое, с 8 символами. если не хватает - добавляет лидирующие нули до 8.
        System.out.println(String.format("%1$td %2$08d", Calendar.getInstance(), 12345));
        System.out.println(String.format("%1$td%1$te", Calendar.getInstance()));
        //  форматиррование строки в 20 символов
        System.out.println(String.format("%20s   |   %20s", "11", "22"));
        if (true) {
            return;
        }
    }

    static void googleStrings(){
		String strX5 = Strings.repeat("str", 5);
		System.out.println("strX5 = " + strX5);
		System.out.println("Strings.emptyToNull(\"    \") = " + Strings.emptyToNull(""));
		System.out.println("Strings.nullToEmpty(null) = '" + Strings.nullToEmpty(null)+"'");;
		System.out.println("Strings.padStart(\"World\", 10, '#') = " + Strings.padStart("World", 10, '#'));;
		System.out.println("Strings.padEnd(\"World\", 10, '#') = " + Strings.padEnd("World", 10, '#'));;
	}
}
