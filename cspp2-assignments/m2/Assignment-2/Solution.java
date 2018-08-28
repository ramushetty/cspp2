import java.util.Scanner;

public final class Solution {
	private Solution() {
		// empty.
	}
	/**
	 * { main }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	/**
	 * { function calling }.
	 *
	 * @param      a
	 * @param      b
	 * @param      c
	 *
	 * @return     { return_value }
	 */
	public static void rootsOfQuadraticEquation(final int a, final int b, final int c) {
		double x1 = (-b + Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
		double x2 = (-b - Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
		System.out.println(x1);
		double root1 = (a * (x1 * x1)) + (b * x1) + c;
		double root2 = (a * (x2 * x2)) + (b * x2) + c;
		System.out.println(root1 + " " + root2);
	}
}
