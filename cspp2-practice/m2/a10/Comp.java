/**
 * { class }.
 */
public final class Comp {
    /**
     * { varA }.
     */
    public static final int VARA = 10;
    /**
     * { varB }.
     */
    public static final int VARB = 20;
    /**
     * Constructs the object.
     */
    private Comp() {
    //empty.
    }
    /**
     * { main }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        if (VARA > VARB) {
            System.out.println("Bigger");
        } else if (VARA == VARB) {
            System.out.println("Equal");
        } else if (VARA < VARB) {
            System.out.println("Smaller");
        }
    }
}
