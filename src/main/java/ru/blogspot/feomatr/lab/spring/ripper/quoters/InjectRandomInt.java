package ru.blogspot.feomatr.lab.spring.ripper.quoters;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author iipolovinkin
 * @since 05.10.2015
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {
	int min();

	int max();
}
