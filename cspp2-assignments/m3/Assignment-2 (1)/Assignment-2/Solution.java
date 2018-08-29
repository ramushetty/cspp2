
import java.util.Scanner;
/*
    Do not modify this main function.
    */
/**
 * Class for solution.
 * author ramu 
 * roll number 20186082
 * date 29/08/2018
 */
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        // empty.
    }
    /**
     * { var_description }.
     */
    public static final int NUM1 = 10;
    /**
     * { var_description }.
     */
    public static final int NUM2 = 7;
/* Fill the main function to print the number of 7's between 1 to n*/
/**
 * { function_description }.
 *
 * @param      args  The arguments
 */
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        for (int i = 1 ;i < n ;i++) {
            int j = i;
            while (j > 0) {
                int re = j % NUM1;
                if (re == NUM2) {
                    count = count + 1;
                }
                j = j / NUM1;
            }
        }

    System.out.println(count);
    }
}