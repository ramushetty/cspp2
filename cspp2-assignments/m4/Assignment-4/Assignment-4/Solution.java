
// Given an String, Write a java method that returns the decimal value for
// the given
//binary string.


import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //empty.
    }
    /*
    Do not modify the main function
    */
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);

    }
    /**
     * { function_description }.
     *
     * @param      str   The string
     *
     * @return     { description_of_the_return_value }
     */
    static String reverseString(final String str) {
        //char[] arr = new char[str.length()];
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);

        }
        return rev;
    }
}
