import java.util.Scanner;
/**
 * class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */

    private Solution() {
        // empty.
    }
    /**
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /*
    Need to write the power function and print the output.
    */
    /**
     * { function_description }.
     *
     * @param      b     { base }
     * @param      e     { exponenet }
     *
     * @return     { the_return_value }
     */

    static long power(final long b, final int e) {
        if (e != 0) {
            return (b * power(b, e - 1));
        } else {
            return 1;
        }
    }
}
