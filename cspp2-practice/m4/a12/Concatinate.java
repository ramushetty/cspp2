import java.util.Scanner;
/**
 * { item_description }.
 */
public final class Concatinate {
    /**
     * Constructs the object.
     */
    private Concatinate() {
        //empty.
    }
    /**
     * { main }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        String con = "Hello";
        String conc = con.concat(" ").concat(str).concat("!");
        System.out.println(conc);
    }
}
