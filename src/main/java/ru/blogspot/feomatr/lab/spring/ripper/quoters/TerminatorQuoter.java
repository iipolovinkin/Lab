package ru.blogspot.feomatr.lab.spring.ripper.quoters;

/**
 * @author iipolovinkin
 * @since 04.10.2015
 */
public class TerminatorQuoter implements Quoter {
	@InjectRandomInt(min = 2, max = 7)
	private int repeat;
	private String message;

	@Override
	public void sayQuote() {
		for (int i = 0; i < repeat; i++) {
			System.out.println("message = " + message);
		}
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
