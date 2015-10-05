package ru.blogspot.feomatr.lab.spring.ripper.quoters;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation which print time needed for exectution of methods of annotated class.
 *
 * @author iipolovinkin
 * @since 05.10.2015
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Profiling {
}
