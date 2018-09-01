import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author :
 */
public final class Solution {
    /**
     * { var_description }.
     */
    public static final int NUM1 = 3;
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     //* @param      n     n value -->
     */
    // static void oddComposites(final int n) {
    // write your code here
    // }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
    /**
     * { function_description }.
     *
     * @param      num   The number
     */
    static void oddComposites(final int num) {
        int count = 0;
        int a = 1;
        int c = 0;
        while (c < num) {
            count = 0;
            a++;
            for (int i = 1; i <= a; i++) {
                if (a % i == 0) {
                    count++;

                }
            } if (count >= NUM1) {

                if (a % 2 != 0) {
                    if (a <= num) {
                    System.out.println(a);
                    }
                }
                    c += 1;
            }

        }
    }
}


