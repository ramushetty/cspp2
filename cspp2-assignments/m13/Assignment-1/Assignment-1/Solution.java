import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : 
 */
class Set {
    //your code goes here...
    //Good luck :-)
    private int[] set;
    private int size;
    public Set() {
    	set = new int[10];
    	size = 0;
    }
    public int size() {
    	return size;
    }
    public boolean contains(final int item) {
    	return indexof(item) != -1;
    }
    public int indexof(final int item) {
    	for (int i = 0; i< size(); i++) {
    		if (item == set[i]) {
    			return i;
    		}
    	}
    	return -1;
    }
    public String toString() {
    	if (size == 0) {
    		return "{}";
    	}
    	String str;
    	str = "{";
    	int i = 0;
    	for (i = 0; i < size() - 1; i++) {
    		str += set[i] + "," + " ";
    	}
    	str += set[i] + "}";
    	return str;
    }
    public void add(final int item) {
    	if (size == set.length) {
    		resize();
    	}
    		set[size++] = item;
    }
    public void add(final int[] items) {
    	if (items.length + size > set.length) {
    		resize();
    	}

    	for (int i = 0; i < items.length; i++) {
    		if (indexof(items[i]) == -1) {
    			add(items[i]);
    		}

    		
    	}
    }
     public Set retainAll(final int[] arr) {
    	Set rset = new Set();
    	for (int i = 0; i < size; i++) {
    		for (int j = 0; j < arr.length; j++) {
    			if (set[i] == arr[j]) {
    				rset.add(set[i]);
    			}
    		}
    	}
    	return rset;
 
    	
    }
    public Set intersection(Set item) {
    	Set nset = new Set();
    	for (int i = 0; i < size; i++) {
    		for (int j = 0; j < item.size(); j++ ) {
    			if (set[i] == item.set[j]) {
    				nset.add(set[i]);
    			}
    			
    		}
    	}
    	return nset;
    }
    public int get(final int index) {
    	return set[index];
    }
    public int[][] cartesianProduct(Set arr) {
    	int[][] narr = new int[size * arr.size()][2];
    	System.out.println(arr.toString());
    	System.out.println(toString());
    	for (int i = 0; i < size(); i++) {
    		for (int j = 0; j < narr.length-1; j++) {
    			narr[1][0] = set[i];
    			narr[0][1] = arr.get(j);
    		}
    	}
    	return narr; 
    }
    public void remove(int index) {
    	if (index >= size || index < 0) {
    		System.out.println("iob");
    	} else {
    		for (int i = index; i < size() -1; i++) {
    			set[i] = set[i + 1];
    		}
    		size--;
    	}
    }
    public void resize() {
    	set = Arrays.copyOf(set, 2*set.length);
    }



}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

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
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                default:
                break;
            }
        }
    }
}
