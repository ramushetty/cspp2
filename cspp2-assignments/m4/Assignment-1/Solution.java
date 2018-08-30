
import java.util.Scanner;
/**
 * Class for solution.
 * author : ramu 
 * roll number : 20186082
 * date : 30/08/2018
 */
public final class Solution {/*
    Fill this main function to print maximum of given array
    */
    /**
     * { main }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int max = arr[0];
        for (int number : arr) {
            if (number > max) {
                max = number;
            }
        }
        System.out.println(max);

    }
}
