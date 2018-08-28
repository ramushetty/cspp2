import java.util.Scanner;
/**
 * { initialize class }.
 */
public final class Factorial {
    /**
     * Constructs the object.
     */
    private Factorial() {
        // empty.
    }
    /**
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        int num;
        Scanner s = new Scanner(System.in);
        num = s.nextInt();
        int out = rec(num);
        System.out.println(out);
    }
    /**
     *
     * @param      re    { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    static int rec(final int re) {
        if (re == 0) {
            return 1;
        } else if (re == 1) {
            return 1;
        } else {
            return (re * rec(re - 1));
        }
    }
}
