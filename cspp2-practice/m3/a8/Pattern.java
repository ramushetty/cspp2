import java.util.Scanner;
/**
 * { class  }.
 * author ramu
 * rollno 20186082
 * date 29/08/2018
 */
public final class Pattern {
    /**
     * Constructs the object.
     */
    private Pattern() {
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
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}


