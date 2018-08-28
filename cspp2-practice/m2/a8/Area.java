import java.util.Scanner;
/**
 * { class  }.
 * author : ramu
 * rollnumber 20186082
 * area of a circle
 */
public final class Area {

    /**
     * { var NUM1 }.
     */
    public static final double NUM1 = 3.14
    /**
     * Constructs the object.
     */
    private Area() {
        //empty.
    }
    /**
     * { main }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int r;
        double area;
        r = s.nextInt();
        area = NUM1 * r * r;
        System.out.println(area);
    }
}
