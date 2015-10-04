package ru.blogspot.feomatr.lab.spring.ripper.quoters;

/**
 * @author iipolovinkin
 * @since 04.10.2015
 */
public class TerminatorQuoter implements Quoter {
	private String message;

	@Override
	public void sayQuote() {
		System.out.println("message = " + message);
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
