/**
    *quotient and remainder.
    *author : ramu
    *roll number : 20186082
    *date: 27/08/2018
*/
public final class QuotientRemainder {
    /**
        *initialling variables.
    */
    public static final int NUM1 = 20;
    /**
        *initialize variable 2.
    */
    public static final int NUM2 = 5;
    /**
        //empty.
    */
    private QuotientRemainder() {
    }
    /**
        *initialize variable.
        @param args of type string
    */
    public static void main(final String[] args) {
        int dividend = NUM1, divisor = NUM2;
        int rem = dividend / divisor;
        int quo = dividend % divisor;
        System.out.println("remainder: " + quo);
        System.out.println("quotient: " + rem);

    }
}
