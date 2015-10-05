package ru.blogspot.feomatr.lab.spring.ripper.quoters;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation processed after all beans will be created
 * @see PostProxyInvokerContextListener
 * @author polovinkin.igor
 * @since 05.10.2015
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface PostProxy {
}
