/**
 * { item_description }.
 * author ramu
 * rollnumber 20186082
 * date 29/08/2018
 */
public final class Converttowhileloop {
    /**
     * { var num }.
     */
    public static final int NUM1 = 10;
    /**
     * Constructs the object.
     */
    private Converttowhileloop() {
        //empty.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        int i = 2;
        while (i <= NUM1) {
            System.out.println(i);
            i = i + 2;
        }
        System.out.println("GoodBye!");
    }
}
