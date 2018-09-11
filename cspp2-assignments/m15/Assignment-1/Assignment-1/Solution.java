
import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedInputStream;
/**
 * Exception for signaling invalid position errors.
 */
class InvalidPositionException extends Exception {
  /**
   * inavlid position exception constructor.
   *
   * @param      msg   The message
   */
    InvalidPositionException(final String msg) {
    super(msg);
  }
}
/**
 * List of .
 */
class List {
  /**
   * { integer array list}.
   */
  private int[] list;
  /**
   * { size of array}.
   */
  private int size;
  /**
   * { initail size of array}.
   */
  private static final int NUM = 10;

  /**
   * list Constructor.
   */
  List() {
    list = new int[NUM];
    size = 0;
  }

  /**
   * { adds items to list }.
   *
   * @param      item  The item
   */
  public void add(final int item) {
    if (size == list.length) {
      resize();
    }
    list[size++] = item;
  }

  /**
   * Adds all.
   *
   * @param      item  The item
   */
  public void addAll(final int[] item) {
    if (size + item.length > list.length) {
      resize();
    }
    for (int i = 0; i < item.length; i++) {
      add(item[i]);
    }
  }

  /**
   * { doubles the size of array}.
   */
  public void resize() {
    list = Arrays.copyOf(list, 2 * list.length);
  }

  /**
   * { returns size}.
   *
   * @return     { retuns size of list }
   */
  public int size() {
    return size;
  }

  /**
   * Returns a string representation of the object.
   *
   * @return     String representation of the object.
   */
  public String toString() {
    if (size == 0) {
      return "[]";
    }
    int i = 0;
    String str = "[";
    for (i = 0; i < size - 1; i++) {
      str += list[i] + ",";
    }
    str += list[i] + "]";
    return str;
  }

  /**
   * Removes all.
   *
   * @param      newarray  The new array
   */
  public void removeAll(final int[] newarray) {
    for (int i = 0; i < newarray.length; i++) {
      for (int j = 0; j < list.length; j++) {
        if (newarray[i] == list[j]) {
          remove(j);
          j--;
        }
      }
    }
  }

  /**
   * { removes the number present at particular index }.
   *
   * @param      index  The index
   */
  public void remove(final int index) {
    // write the logic for remove here. Think about what to do to the size
    // variable.
    if (index < 0 || index > size - 1) {
      System.out.println("Invalid Position Exception");
    } else {

      for (int i = index; i <= size(); i++) {
        list[i] = list[i + 1];
      }
      size--;
    }


  }

  /**
   * { sublist }.
   *
   * @param      starting                   The starting
   * @param      ending                     The ending
   *
   * @return     { returns sublist }
   *
   * @throws     IndexOutOfBoundsException  { exception }
   */
  public List subList(final int starting, final int ending)
  throws IndexOutOfBoundsException {
    if (starting > size || ending > size) {
      throw new IndexOutOfBoundsException("Index Out of Bounds Exception");
    }
    if (starting < 0 || ending < 0) {
      throw new IndexOutOfBoundsException("Index Out of Bounds Exception");
    }
    if (starting == 0 && ending == 0) {
      throw new IndexOutOfBoundsException("Index Out of Bounds Exception");
    }
    List nlist = new List();
    for (int i = starting; i < ending; i++) {
      nlist.add(list[i]);
    }
    return nlist;
  }

  /**
   * { clears the list }.
   */
  public void clear() {
    size = 0;
  }

  /**
   * { checks for numbers in list }.
   *
   * @param      nlist  The list
   *
   * @return     { returns true or false }
   */
  public boolean equals(final List nlist) {
    return nlist.toString().equals(this.toString());
  }

  /**
   * Searches for the first match.
   *
   * @param      item  The item
   *
   * @return     { returns index number of item }
   */
  public int indexOf(final int item) {
    // Replace the code below
    for (int i = 0; i < size() - 1; i++) {
      if (list[i] == item) {
        return i;
      }
    }
    return -1;
  }

  /**
   * { checks number is present in list or not }.
   *
   * @param      item  The item
   *
   * @return     { retuns true or false}
   */
  public boolean contains(final int item) {
    // Replace the code below

    return indexOf(item) != -1;
  }
  /**
   * { returns number present at index in list }.
   *
   * @param      index  The index
   *
   * @return     { returns number or -1 if number not present in list }
   */
  public int get(final int index) {
    // Replace the code below to write the code for get
    if (index >= 0 && index < size) {
      return list[index];
    }
    return -1;
  }

  /**
   * { counts the number of duplicate elements in list}.
   *
   * @param      item  The item
   *
   * @return     { returns the number of counted element }
   */
  public int count(final int item) {
    int count = 0;
    for (int i = 0; i < size; i++) {
      if (item == list[i]) {
        count++;
      }
    }
    return count;
  }


}
/**
 * { public class solutioin}.
 */
public final class Solution {
  /**
   * empty Constructor.
   */
  private Solution() {
    //empty.
  }
  /**
   * { main function }.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    List s = new List();
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
          int[] arr = new int[t.length];
          for (int i = 0; i < t.length; i++) {
            arr[i] = Integer.parseInt(t[i]);
          }
          s.addAll(arr);
        }
        break;
      case "remove":
        try {
          s.remove(Integer.parseInt(tokens[1]));
        } catch (Exception ex) {
          System.out.println("Invalid Position Exception");
        }

        break;
      case "print":
        System.out.println(s);
        break;
      case "subList":
        String[] t1 = tokens[1].split(",");
        try {
          List object = s.subList(Integer.parseInt(
            t1[0]), Integer.parseInt(t1[1]));
          System.out.println(object);
        } catch (Exception ex) {
          System.out.println("Index Out of Bounds Exception");
        }

        break;
      case "removeAll":
        if (tokens.length == 2) {
          String[] t2 = tokens[1].split(",");
          int[] a = new int[t2.length];
          for (int i = 0; i < t2.length; i++) {
            a[i] = Integer.parseInt(t2[i]);
          }
          s.removeAll(a);
        }
        break;
      case "equals":
        if (tokens.length == 2) {
          String[] lt = tokens[1].split(",");
          List l2 = new List();
          for (int k = 0; k < lt.length; k++) {
            l2.add(Integer.parseInt(lt[k]));
          }
          System.out.println(s.equals(l2));
        }
        break;
      case "clear":

        s.clear();
        break;
      case "contains":
        if (tokens.length == 2) {
          System.out.println(s.contains(
                               Integer.parseInt(tokens[1])));
        }
        break;
      case "get":
        if (tokens.length == 2) {
          System.out.println(s.get(
                               Integer.parseInt(tokens[1])));
        }
        break;
      case "indexOf":
        if (tokens.length == 2) {
          System.out.println(s.indexOf(
                               Integer.parseInt(tokens[1])));
        }
        break;
      case "size":
        System.out.println(s.size());
        break;
      case "count":
        System.out.println(s.count(Integer.parseInt(tokens[1])));
        break;
      default:
        break;
      }
    }
  }
}
