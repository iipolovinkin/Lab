package ru.blogspot.feomatr.lab.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author polovinkin.igor
 * @since 08.02.2016
 */
public class DemoPropertyChangeListener {
	private static final Logger log = LoggerFactory.getLogger(DemoPropertyChangeListener.class);

	public static void main(String[] args) {
		EmployeeComponent employeeComponent = new EmployeeComponent();
		employeeComponent
				.addPropertyChangeListener(new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						System.out.println(String.format("GeneralListener. Property %s changed. OldValue: %s newValue: %s", evt.getPropertyName(), evt.getOldValue(), evt.getNewValue()));
					}
				});
		employeeComponent
				.addPropertyChangeListener("mood", new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						System.out.println(String.format("MoodListener. OldValue: %s newValue: %s", evt.getPropertyName(), evt.getOldValue(), evt.getNewValue()));
					}
				});
		employeeComponent.setMood("glad");
		employeeComponent.setState("working");

	}
}
