import java.util.Scanner;
/**
 * { new class }.
 * author: ramu
 * rollno 20186082
 * date 29/08/2018
 */
public final class Sumofnnumbers {
    /**
     * Constructs the object.
     */
    private Sumofnnumbers() {
        //empty.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        n = s.nextInt();
        int count = 0;
        for (int i = 0; i <= n; i++) {
            count = count + i;
        }
        System.out.println(count);
    }
}
