import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    String data;
    /**
     * Constructs the object inputvalidator.
     *
     * @param      data  The data given input
     */
    public InputValidator(final String data) {
        this.data = data;
    }
    /**
     * { checks the length of the given input string}.
     *
     * @return     { returns true or false }
     */
    public boolean validateData() {
        final int length = 6;
        return data.length() >= length;
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
