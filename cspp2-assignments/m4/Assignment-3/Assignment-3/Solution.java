
// Given an String, Write a java method that returns the decimal
// value for th
 // given binary string.


import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution { /*
    Do not modify this main function.
    */
    /**
     * Constructs the object.
     */
    private Solution() {
        //empty.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int res = binaryToDecimal(s);
            System.out.println(res);
        }
    }
    /**
     * { function_description }.
     *
     * @param      str   The string
     *
     * @return     { description_of_the_return_value }
     */
    static int binaryToDecimal(final String str) {
        String bi = str;
        int k = 0;
        int binary = 0;
        for (int i = bi.length() - 1; i >= 0; i--) {
            if (bi.charAt(i) == '1') {
                binary += Math.pow(2, k);

            }
            k++;
        }
    return binary;
    }

}
