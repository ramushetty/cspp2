import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedInputStream;
/**
 * Class for sorted set adt.
 */
class SortedSetADT {
	/**
	 * { array set of integer type }.
	 */
	private int[] set;
	/**
	 * { size of integer type}.
	 */
	private int size;
	/**
	 * Constructs the object.
	 */
	SortedSetADT() {
		set = new int[20];
		size = 0;


	}

	/**
	 * { function_description }.
	 *
	 * @param      fromElement  The from element
	 * @param      toElement    To element
	 *
	 * @return     { description_of_the_return_value }
	 */
	public SortedSetADT subSet(final int fromElement, final int toElement) {
		SortedSetADT sset = new SortedSetADT();
		for (int i = index(fromElement); i < index(toElement); i++) {
			sset.add(set[i]);
		}
		return sset;
	}
	

	/**
	 * { returns elements up to toelements}.
	 *
	 * @param      toElement  To element
	 *
	 * @return     { returns an array }
	 */
	public SortedSetADT headSet(final int toElement) {
		SortedSetADT nset = new SortedSetADT();
		System.out.println(index(toElement));
		//int[] nset = new int[index(toElement)];
		for (int i = 0; i < index(toElement); i++) {
			nset.add(set[i]);
		}
		//System.out.println(nset.toString());
		return nset;
	}

	/**
	 * { function_description }.
	 *
	 * @param      item  The item
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int index(final int item) {
		for (int i = 0; i < size - 1; i++) {
			if (item == set[i]) {
				return i;
			} else {

				if (item > set[size - 1]) {
					return size - 1;
				}
			}
		}
		return 0;
	}

	/**
	 * { function_description }.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int last() {
		return set[size - 1];

	}

	/**
	 * Adds all.
	 *
	 * @param      array  The array
	 */
	public void addAll(final int[] array) {
		if (size + array.length > set.length) {
			resize();
		}
		for ( int i = 0; i < array.length; i++) {
			if (contains(array[i]) == 0) {
				add(array[i]);
			}
			
		}
		set = Arrays.copyOf(set, size);
		Arrays.sort(set);
	}

	/**
	 * { function_description }.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String toString() {
		if (size == 0) {
			return "{}";
		}
		int i = 0;
		String str = "{";
		for (i = 0; i < size - 1; i++) {
			str += set[i] + "," + " ";
		}
		str += set[i] + "}";
		return str;
	}

	/**
	 * { function_description }.
	 *
	 * @param      item  The item
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int contains(int item) {
		for (int i = 0; i < size; i++) {
			if (item == set[i]) {
				return -1;
			}
		}
		return 0;
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
		set = Arrays.copyOf(set, 2*set.length);
	}

}

/**
 * Class for solution.
 */
public class Solution {
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
		SortedSetADT s = new SortedSetADT();
		Scanner inp = new Scanner(new BufferedInputStream(System.in));
		while (inp.hasNext()) {
			String line = inp.nextLine();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
				case "subSet":
					if (tokens.length == 2) {
						String[] t = tokens[1].split(",");
						System.out.println(s.subSet(Integer.parseInt(t[0]), Integer.parseInt(t[1])));
					}
					break;

				case "headSet":
					System.out.println(s.headSet(Integer.parseInt(tokens[1])));
					

					break;
				case "last":
					System.out.println(s.last());
					break;
				case "addAll":
					if (tokens.length == 2) {
						String[] t = tokens[1].split(",");
						int[] temp = new int[t.length];
						for (int i = 0; i < temp.length; i++) {
							temp[i] = Integer.parseInt(t[i]);
						}
						s.addAll(temp);
					}
					break;
				case "print":
					System.out.println(s);
					break;

			}
		}

	}
}