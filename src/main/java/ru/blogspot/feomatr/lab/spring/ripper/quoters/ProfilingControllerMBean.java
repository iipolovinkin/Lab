package ru.blogspot.feomatr.lab.spring.ripper.quoters;

/**
 * interface for changing BeanProperty throughout JMX.
 * Connect to thread using JVisualVM and change MBean property.
 *
 * @author iipolovinkin
 * @since 05.10.2015
 */
public interface ProfilingControllerMBean {
	void setEnabled(boolean enabled);
}
