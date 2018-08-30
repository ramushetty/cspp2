import java.util.*;
/**
 * Class for solution.
 * author ramu
 * rollno 20186082
 * date 30/08/2018
 */
public final class Solution {
	/* Fill the main function to print resultant of addition of matrices*/
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//empty.
	}
	/**
	 * { main }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
	Scanner s = new Scanner(System.in);
	int row = s.nextInt();
	int col	= s.nextInt();
	int[][] mat1 = new int[row][col];
	for (int i = 0; i<mat1.length; i++) {
		for (int j = 0; j<mat1.length; j++){
			mat1[i][j] = s.nextInt();
		}
	//System.out.println(Arrays.deepToString(mat1));
	}
	int row1 = s.nextInt();
	int col1 = s.nextInt();
	int[][] mat2 = new int[row1][col1];
	for (int i = 0; i<row1; i++) {
		for (int j = 0; j<col1; j++){
			mat2[i][j] = s.nextInt();
		}
	//System.out.println(Arrays.deepToString(mat2));
	}
	if ((row == row1) || (col == col1)) {
		int[][] add = new int[row][col];
		for (int i = 0; i<mat1.length; i++) {
			for (int j = 0; j<mat2.length; j++) {
				add[i][j] = mat1[i][j] + mat2[i][j];
			}
		}
		for(int i = 0; i < row1; i++) {
			for (int j = 0; j < col1 - 1; j++) {
				System.out.print(add[i][j] + " ");
			}
			System.out.println(add[i][col1-1]);
		}
	} else {
		System.out.println("not possible");
	}
	}
}