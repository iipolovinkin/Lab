package ru.blogspot.feomatr.lab.spring.ripper.quoters;

/**
 * @author iipolovinkin
 * @since 05.10.2015
 */
public class ProfilingController implements ProfilingControllerMBean {
	private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
