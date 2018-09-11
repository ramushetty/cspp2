import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;
/**
 * Exception for signaling set empty errors.
 */
class SetEmptyException extends Exception {
	/**
	 * Constructs the object.
	 *
	 * @param      msg   The message
	 */
	SetEmptyException(String msg) {
		super(msg);
	}
}
/**
 * Exception for signaling invalid subset selection errors.
 */
class InvalidSubsetSelectionException extends Exception {
	/**
	 * Constructs the object.
	 *
	 * @param      msg   The message
	 */
	InvalidSubsetSelectionException(String msg) {
		super(msg);
	}
}

/**
 * Class for sorted set adt.
 */
class SortedSetADT {
	/**
	 * { var_description }.
	 */
	private int[] set;
	/**
	 * { var_description }.
	 */
	private int size;
	/**
	 * { var_description }.
	 */
	private static final int NUM = 10;
	SortedSetADT() {
		set = new int[NUM];
		size = 0;
	}
	/**
	 * { function_description }.
	 *
	 * @param      item  The item
	 */
	public void add(final int item) {
		if (size == set.length) {
			resize();
		}
		set[size++] = item;
	}
	/**
	 * { function_description }.
	 */
	public void resize() {
		set = Arrays.copyOf(set, 2 * set.length);
	}
	/**
	 * Adds all.
	 *
	 * @param      arr   The arr
	 */
	public void addAll(final int[] arr) {
		if (size + arr.length > set .length) {
			resize();
		}
		for (int i = 0; i < arr.length; i++) {
			if (contains(arr[i]) == 0) {
				add(arr[i]);
			}
		}
		set = Arrays.copyOf(set, size);
		Arrays.sort(set);

	}
	/**
	 * { function_description }.
	 *
	 * @param      item  The item
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int contains(final int item) {
		for (int i = 0; i < size; i++) {
			if (item == set[i]) {
				return -1;
			}

		}
		return 0;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		if (size == 0) {
			return "{}";
		}
		int i = 0;
		String str = "{";
		for (i = 0; i < size - 1; i++) {
			str = str + set[i] + "," + " ";
		}
		str = str + set[i] + "}";
		return str;
	}
	/**
	 * { function_description }.
	 *
	 * @param      end                The end
	 *
	 * @return     { description_of_the_return_value }
	 *
	 * @throws     SetEmptyException  { exception_description }
	 */
	public SortedSetADT headSet(final int end) throws SetEmptyException {
		SortedSetADT sset = new SortedSetADT();
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (set[i] < end) {
				sset.add(set[i]);
				count++;
			}
		}
		if (count  != 0) {
			return sset;
		}
		throw new SetEmptyException("Set Empty Exception");

	}
	/**
	 * { function_description }.
	 *
	 * @return     { description_of_the_return_value }
	 *
	 * @throws     SetEmptyException  { exception_description }
	 */
	public int last() throws SetEmptyException {
		if (size == 0) {
			throw new SetEmptyException("Set Empty Exception");
		}
		return set[size - 1];
	}
	public SortedSetADT subSet(final int fromelement, int endelement) throws InvalidSubsetSelectionException {
		if (fromelement > endelement) {
			throw new InvalidSubsetSelectionException("Invalid Arguments to Subset Exception");
		}
		SortedSetADT nset = new SortedSetADT();
		for (int i = 0; i < size; i++) {
			if (set[i] >= fromelement && set[i] < endelement) {
				nset.add(set[i]);
			}
		}
		return nset;
	}

	/**
	   * { retains elements present in the set }.
	   *
	   * @param      arr   The arr
	   *
	   * @return     { returns set }
	   */
	public SortedSetADT retainAll(final int[] arr) {
		SortedSetADT rset = new SortedSetADT();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (set[i] == arr[j]) {
					rset.add(set[i]);
				}
			}
		}
		return rset;


	}

	/**
	   * { intesection() returns common elements}.
	   *
	   * @param      item  The item
	   *
	   * @return     { returns set }
	   */
	public SortedSetADT intersection(final SortedSetADT item) {
		SortedSetADT nset = new SortedSetADT();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < item.size; j++) {
				if (set[i] == item.set[j]) {
					nset.add(set[i]);
				}

			}
		}
		return nset;
	}



}


/**
 * { item_description }.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//empty.
	}

	/**
	   * helper function to convert string input to int array.
	   *
	   * @param      s     { string input from test case file }
	   *
	   * @return     { int array from the given string }
	   */
	public static int[] intArray(final String s) {
		String input = s;
		if (input.equals("[]")) {
			return new int[0];
		}
		if (s.contains("[")) {
			input = s.substring(1, s.length() - 1);
		}
		return Arrays.stream(input.split(","))
		       .mapToInt(Integer::parseInt)
		       .toArray();

	}
	/**
	 * { function_description }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		SortedSetADT s = new SortedSetADT();
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		while (stdin.hasNext()) {
			String line = stdin.nextLine();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
			case "add":
				if (tokens.length == 2) {
					s.add(Integer.parseInt(tokens[1]));
				}
				break;
			case "addAll":
				if (tokens.length == 2) {
					String[] t = tokens[1].split(",");
					int[] a = new int[t.length];
					for (int i = 0; i < a.length; i++) {
						a[i] = Integer.parseInt(t[i]);
					}
					s.addAll(a);
				}
				break;
			case "print":
				System.out.println(s);
				break;
			case "headSet":
				try {
					System.out.println(s.headSet(Integer.parseInt(tokens[1])));
				} catch (Exception ex) {
					System.out.println("Set Empty Exception");
				}
				break;
			case "last":
				try {
					System.out.println(s.last());
				} catch (Exception ex) {
					System.out.println("Set Empty Exception");
				}
				break;
			case "subSet":
				if (tokens.length == 2) {
					String[] t2 = tokens[1].split(",");
					try {

						s.subSet(Integer.parseInt(t2[0]), Integer.parseInt(t2[1]));
						System.out.println(s.subSet(
						                     Integer.parseInt(
						                       t2[0]), Integer.parseInt(t2[1])));

					} catch (Exception ex) {
						System.out.println("Invalid Arguments to Subset Exception");
					}
				}
				break;
			case "retainAll":
				s = new SortedSetADT();
				int[] intArray = intArray(tokens[1]);
				intArray = intArray(tokens[1]);
				s.addAll(intArray);
				intArray = intArray(tokens[2]);
				System.out.println(s.retainAll(intArray));
				break;
			case "intersection":
				s = new SortedSetADT();
				SortedSetADT t = new SortedSetADT();
				intArray = intArray(tokens[1]);
				s.addAll(intArray);
				intArray = intArray(tokens[2]);
				t.addAll(intArray);
				System.out.println(s.intersection(t));
				break;

			}
		}
	}
}