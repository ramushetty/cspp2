/**
    *swaping.
    *author :ramu
    *roll nummber: 20186082
    *date : 29/08/2018
*/
public final class Swap {
    /**
        *INITIALLING VARIABLES.
    */
    public static final int NUM1 = 3;
    /**
        *initialling variable.
    */
    public static final int NUM2 = 10;
    /**
    *default constructor.
    */
    private Swap() {
    // empty
    }
    /**
            *initialling variables.
            @param args of type string[]
    */

    public static void main(final String[] args) {
        int a = NUM1;
        int b = NUM2;
        int temp;

        System.out.println("a:" + a);
        System.out.println("b:" + b);
        temp = a;
        a = b;
        b = temp;
        System.out.println("a:" + a);
        System.out.println("b:" + b);


    }
}
