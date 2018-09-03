import java.util.Scanner;
/**
 * Class for student.
 */
class Student {
    /**
     * { name = student name }.
     */
    private static String name;
    /**
     * { rollnumber = student roll number }.
     */
    private static int rollnumber;
    /**
     * { s1 = marks of subject1 }.
     */
    private static double s1;
    /**
     * { s2 = marks of subject2 }.
     */
    private static double s2;
    /**
     * { s3 = marks of subject3 }.
     */
    private static double s3;
    /**
     * Constructs the object.
     *
     * @param      fname        The filename student name
     * @param      frollnumber  The frollnumber student roll number
     * @param      m1           The m 1 marks of subject1
     * @param      m2           The m 2 marks of subject2
     * @param      m3           The m 3 marks of subject3
     */
    Student(final String fname, final int frollnumber, final double m1,
        final double m2, final double m3) {
        name = fname;
        rollnumber = frollnumber;
        s1 = m1;
        s2 = m2;
        s3 = m3;
    }
    /**
     * { gpa() used to calculate average of three subjects}.
     *
     * @return     { description_of_the_return_value }
     */
    static double gpa() {
        final int num1 = 3;
        float avg = (float) (s1 + s2 + s3) / num1;
        return avg;
    }
}

/**
 * { main class studentdetails }.
 */
public final class Studentdetails {
    /**
     * empty constructor.
     */
    private Studentdetails() {
        //empty.
    }
    /**
     * { main function  }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter student name");
        String sname = scan.nextLine();
        System.out.println("enter roll number");
        int srollnumber = scan.nextInt();
        System.out.println("enter marks in subjects");
        double sub1 = scan.nextDouble();
        double sub2 = scan.nextDouble();
        double sub3 = scan.nextDouble();
        Student std = new Student(sname, srollnumber, sub1, sub2, sub3);
        System.out.println("average : " + std.gpa());
    }
}
