import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author :
 */
final class Solution {
    /**
     * { var_description }.
     */
    public static final int NUM1 = 100, NUM2 = 50;
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a,
        final int rows, final int columns) {


    // write ypur code here
        int[][] arr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (a[i][j] < NUM2) {
                    a[i][j] = 0;
                    arr[i][j] = a[i][j];
                //if (a[i][j] >= 50 && a[i][j] <= 100); {
                        //arr[i][j] = 100;
                  //  }

                } else {
                    if ((a[i][j] % NUM1) < NUM2) {

                        int div = (a[i][j] / NUM1) * NUM1;
                        arr[i][j] = div;

                    } else {

                        if ((a[i][j] % NUM1) >= NUM2) {

                            int rem = ((a[i][j] / NUM1) * NUM1) + NUM1;
                            arr[i][j] = rem;
                        }
                    }
                }
            }



        }
        return arr;
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
