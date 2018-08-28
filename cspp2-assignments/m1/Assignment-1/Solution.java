import java.util.Scanner;
/**
    *name and roll number reading input from console.
    *Name : Ramu
    *roll number 20186082
    *date : 27/08/2018
*/
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    // empty

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        String n;
        int r;
        Scanner name = new Scanner(System.in);
        n = name.nextLine();
        r = name.nextInt();
        System.out.println("Name :" + n + ' ' + "Roll Number :" + r);
    }
}
