import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /**
     * { variable input of string type }.
     */
    private String input;
    /**
     * Constructs the object inputvalidator.
     *
     * @param      data  The data given input
     */
    InputValidator(final String data) {
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
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }

}
