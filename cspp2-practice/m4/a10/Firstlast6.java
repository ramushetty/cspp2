import java.util.Scanner;
/**
 * { class }.
 * author ramu
 * rollnumber 20186082
 * date 30/08/2018
 */
public final class Firstlast6 {
    /**
     * { class variable  }.
     */
    public static final int N = 6;
    /**
     * Constructs the object.
     */
    private Firstlast6() {
        //empty.
    }
    /**
     * { main }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter array size");
        int size = s.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
        if (arr[0] == N || arr[size - 1] == N) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
