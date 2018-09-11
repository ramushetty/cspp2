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
		for (int i = 0; i < set[end]; i++) {
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
		if(size == 0) {
			throw new SetEmptyException("Set Empty Exception");
		}
		return set[size - 1];
	}
	public SortedSetADT subSet(final int fromelement, int endelement) throws InvalidSubsetSelectionException {
		System.out.println(fromelement +","+ endelement);
		if (fromelement > endelement) {
			throw new InvalidSubsetSelectionException("Invalid Arguments to Subset Exception");
		}
		System.out.println("heyy");
		SortedSetADT nset = new SortedSetADT();
		for (int i = fromelement; i < endelement; i++) {
			if (set[i] >= fromelement && set[i] < endelement) {
				nset.add(set[i]);
			}
		}
		System.out.println(nset);
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
					} catch(Exception ex) {
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
							System.out.println("Invalid Arguments to subset Exception");
						}
					}
					break;

			}
		}
	}
}