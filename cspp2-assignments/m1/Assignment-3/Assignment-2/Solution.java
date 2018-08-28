import java.util.Scanner;
/**
 * Class for solution.
*/

public final class Solution {
    /**
     * { function_description }.
     *
     *    { description_of_the_return_value }
     */
    private Solution() {
        //empty
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */

    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int base = scan.nextInt();
        int height = scan.nextInt();
        float s = areaoftriangle(base, height);
        System.out.println(s);
    }
    /*
    Need to fill the areaOfTriangle function and print the output.
    of fahrenheit.
    */
    /**
     * { function_description }.
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    static  float  areaoftriangle(final float a, final float b) {
        float n = (a * b) / 2;
        return n;
    }
}
