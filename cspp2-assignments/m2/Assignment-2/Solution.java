import java.util.Scanner;
/**
 * { main }.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        // empty.
    }
    /**
     * { main }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsQuadraticEquation(a, b, c);
    }
    /**
     * { function calling }.
     *
     * @param      a {a}
     * @param      b {b}
     * @param      c {c}
     *
     * //@return     { return_value }
     */
    static void rootsQuadraticEquation(final int a, final int b, final int c) {
        double x1 = (-b + Math.sqrt((b * b) - ((2 * 2) * a * c))) / (2 * a);
        double x2 = (-b - Math.sqrt((b * b) - ((2 * 2) * a * c))) / (2 * a);
        //double root1 = (a * (x1 * x1)) + (b * x1) + c;
        //double root2 = (a * (x2 * x2)) + (b * x2) + c;
        System.out.println(x1 + " " + x2);
    }
}

