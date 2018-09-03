import java.util.*;
/**
 * Class for input validator.
 */
class InputValidator {
	String input;
	/**
	 * Constructs the object inputvalidator.
	 *
	 * @param      data  The data given input
	 */
	public InputValidator(String data) {
		input = data;
	}
	/**
	 * { checks the length of the given input string}.
	 *
	 * @return     { returns true or false }
	 */
	public boolean validateData() {
		final int length = 6;
		return input.length() >= length;
	}
}
/**
 * { main class solution }.
 */
public final class Solution {
	/**
	 * empty constructor.
	 */
	private Solution() {
		//empty.
	}
	/**
	 * { main function }.
	 */
	public static void main(final String args[]) {
    	Scanner s = new Scanner(System.in);
    	String input = s.next();
    	InputValidator i = new InputValidator(input);    	
    	System.out.println(i.validateData());

    }

}
