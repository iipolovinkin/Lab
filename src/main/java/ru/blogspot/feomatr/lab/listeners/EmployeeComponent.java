package ru.blogspot.feomatr.lab.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.blogspot.feomatr.lab.serialization.xstream.Employee;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author polovinkin.igor
 * @since 09.02.2016
 */
public class EmployeeComponent {
	private static final Logger log = LoggerFactory.getLogger(EmployeeComponent.class);
	private String mood = "Initial";

	/**
	 * Used to handle the listener list for property change events.
	 * @see #addPropertyChangeListener
	 * @see #removePropertyChangeListener
	 * @see #firePropertyChangeListener
	 */
	private PropertyChangeSupport support = null;
	private String state = "Alive";

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		if (support == null) {
			support = new PropertyChangeSupport(this);
		}
		support.addPropertyChangeListener(listener);
	}

	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		if (support == null) {
			support = new PropertyChangeSupport(this);
		}
		support.addPropertyChangeListener(propertyName, listener);
	}


	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		if (support != null) {
			support.removePropertyChangeListener(propertyName, listener);
		}
	}

	/**
	 * Removes a PropertyChangeListener from the listener list.
	 * This removes a PropertyChangeListener that was registered
	 * for all properties.
	 * @param listener The PropertyChangeListener to be removed
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		if (support != null) {
			support.removePropertyChangeListener(listener);
		}
	}

	public void setMood(String mood) {
		String oldMood = this.mood;
		this.mood = mood;
		support.firePropertyChange("mood", oldMood, mood);
	}

	public void setState(String state) {
		String oldState = this.state;
		this.state = state;
		support.firePropertyChange("state", oldState, state);
	}
}
