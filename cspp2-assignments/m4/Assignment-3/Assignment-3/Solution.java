
// Given an String, Write a java method that returns the decimal value for the given binary string.


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
		// for (i = 0;i<bi.length()-1;i++) {

		// }
		int i = Integer.parseInt(bi, 2);
	return i;
	}

}
