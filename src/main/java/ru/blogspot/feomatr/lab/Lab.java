package ru.blogspot.feomatr.lab;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;

/**
 * @author iipolovinkin
 *
 */
public class Lab {

	private static Logger logger = LoggerFactory.getLogger(Lab.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DateTime dt[] = { new DateTime(2014, 10, 2, 9, 20),
				new DateTime(2014, 10, 2, 9, 30),
				new DateTime(2014, 10, 2, 9, 40) };

		for (int i = 0; i < dt.length; ++i) {
			logger.info("dt[{}] = {}", i, dt[i]);
		}
		for (int i = 0; i < dt.length; ++i) {
			logger.info("dt[i].isAfter(dt[1]): {}", dt[i].isAfter(dt[1]));
		}
		for (int i = 0; i < dt.length; ++i) {
			logger.info("dt[i].isBefore(dt[1]): {}", dt[i].isBefore(dt[1]));
		}

		Period p = new Period(dt[0], dt[2]);
		Interval i = new Interval(dt[0], dt[2]);
		Duration d = new Duration(dt[0], dt[2]);

		logger.info("period: {}, interval: {}, duration: {}", new Object[] { p,
				i, d });
		for (int j = 0; j < dt.length; ++j) {
			logger.info("interval contains date:  \n{}\n{}\n{}", new Object[] {
					i, dt[j], i.contains(dt[j]) });
		}
		Timestamp timeStamp = new Timestamp(dt[0].getMillis());
		System.out.println("sql timestamp: " + timeStamp);

		DateTime t = new DateTime();

		DateTimeFormatterBuilder dtfb = new DateTimeFormatterBuilder();

	}
}
