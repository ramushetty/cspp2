import java.util.Scanner;
/**
 * { class }.
 * author ramu
 * rollnumber 20186082
 * date 30/08/2018
 */
public final class Average {
    /**
     * Constructs the object.
     */
    private Average() {
        //empty.
    }
    /**
     * { main }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        //int s;
        Scanner s = new Scanner(System.in);
        System.out.println("enter array size");
        int size = s.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
        int sum = 0;
        for (int number : arr) {
            sum += number;
        }
        System.out.println("array sum is: " + sum);
        System.out.println("average of array is : " + sum / arr.length);
    }
}
