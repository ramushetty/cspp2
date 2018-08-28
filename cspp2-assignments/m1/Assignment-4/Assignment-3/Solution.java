import java.util.Scanner;
/**
 * Class for solution.
 * author ramu
 * roll number 20186082
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //empty.
    }
    /**
     * { var_description }.
     */
    public static final double NUM1 = 32, NUM2 = 1.8;
    /**
     * { main }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        double degreesCelsius = scan.nextDouble();
        degreestofare(degreesCelsius);

    }

    /**
     * { called function}.
     *
     * @param      degree  The degree
     */
    public static void degreestofare(final double degree) {
        System.out.println(degree * NUM2 + NUM1);

    }
}
