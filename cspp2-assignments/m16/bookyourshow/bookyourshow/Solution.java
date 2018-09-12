import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Class for book your show.
 */
class BookYourShow {
    /**
     * { var_description }.
     */
    private ArrayList<Show> showlist;
    /**
     * { var_description }.
     */
    private ArrayList<String> tickets;
    /**
     * Constructer for bookyourshow.
     */
    BookYourShow() {
        showlist = new ArrayList<>();
        tickets = new ArrayList<>();
    }
    /**
     * Adds a show.
     *
     * @param      s     { parameter_description }
     */
    void addAShow(final Show s) {
        showlist.add(s);
    }
    /**
     * Gets a show.
     *
     * @param      moviename  The moviename
     * @param      stime      The stime
     *
     * @return     A show.
     */
    Show getAShow(final String moviename, final String stime) {
        for (Show show : showlist) {
            if (show.getmname().equals(moviename) && show.getdatetime().equals(stime)) {
                return show;
            }
        }
        return null;
    }
    /**
     * { function_description }.
     *
     * @param      movie  The movie
     * @param      dati   The dati
     * @param      nm     { parameter_description }
     * @param      seats  The seats
     */
    void bookAShow(final String movie, final String dati, final Patron nm, final String[] seats) {
        Show show = getAShow(movie, dati);
        if (show == null) {
            System.out.println("No show");
            return;
        }
        // System.out.println(nm);
        boolean flag = false;
        String[] sseats = show.getseats();
        for (String seat : seats) {
            for (int i = 0; i < sseats.length; i++) {
                if (seat.equals(sseats[i])) {
                    show.setseats(i);
                    flag = true;
                }
            }
        }
        if (flag) {
            // System.out.println("uo: "+nm.getmobilenumber());
            tickets.add(nm.getmobilenumber() + " " + movie + " " + dati);
        }
    }
    /**
     * { function_description }.
     *
     * @param      movie     The movie
     * @param      showtime  The showtime
     * @param      mobile    The mobile
     */
    void printTicket(final String movie, final String showtime, final String mobile) {
        String t = mobile + " " + movie + " " + showtime;
        if (tickets.contains(t)) {

            System.out.println(t);
        } else {
            System.out.println("Invalid");
        }

    }
    /**
     * Shows all.
     */
    void showAll() {
        for (Show show : showlist) {
            System.out.println(show.toString() + "," + Arrays.toString(show.getseats()).replace(" ", ""));
        }
    }



}
/**
 * Class for show.
 */
class Show {
    /**
     * { var_description }.
     */
    private String mname;
    /**
     * { var_description }.
     */
    private String datetime;
    /**
     * { var_description }.
     */
    private String[] seats;
    /**
     * Constructs the object.
     *
     * @param      mname     The mname
     * @param      datetime  The datetime
     * @param      seats     The seats
     */
    Show(final String mname, final String datetime, final String[] seats) {
        this.mname = mname;
        this.datetime = datetime;
        this.seats = seats;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    String getmname() {
        return mname;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    String getdatetime() {
        return datetime;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    String[] getseats() {
        return seats;
    }
    /**
     * { function_description }.
     *
     * @param      index  The index
     */
    void setseats(final int index) {
        seats[index] = "N/A";
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return mname + "," + datetime;
    }

}
/**
 * Class for patron.
 */
class Patron {
    /**
     * { var_description }.
     */
    private String pname;
    /**
     * { var_description }.
     */
    private String mobilenumber;
    /**
     * Constructs the object.
     *
     * @param      pname1         The pname
     * @param      mobilenumber1  The mobilenumber
     */
    Patron(final String pname1, final String mobilenumber1) {
        this.pname = pname1;
        this.mobilenumber = mobilenumber1;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    String getpname() {
        return pname;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    String getmobilenumber() {
        return mobilenumber;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return pname + " " + mobilenumber;
    }

}

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
            case "add":
                int k = 2;
                String[] seats = new String[tokens.length - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

            case "book":
                k = 2 + 2;
                seats = new String[tokens.length - 2 - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.bookAShow(check[1], tokens[1],
                              new Patron(tokens[2], tokens[2 + 1]), seats);
                break;

            case "get":
                Show show = bys.getAShow(check[1], tokens[1]);
                if (show != null) {
                    System.out.println(show);
                } else {
                    System.out.println("No show");
                }
                break;

            case "print":
                bys.printTicket(check[1], tokens[1], tokens[2]);
                break;

            case "showAll":
                bys.showAll();
                break;

            default:
                break;
            }
        }
    }
}
