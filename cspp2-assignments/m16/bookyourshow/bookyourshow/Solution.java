import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class BookYourShow {
	ArrayList<Show> showlist;
	ArrayList<String> tickets;
	BookYourShow() {
		showlist = new ArrayList<>();
		tickets = new ArrayList<>();
	}
	void addAShow(final Show s) {
		showlist.add(s);
	}
	Show getAShow(final String moviename, final String stime) {
		for (Show show : showlist) {
			if (show.getmname().equals(moviename) && show.getdatetime().equals(stime)) {
				return show;
			}
		}
		return null;
	}
	void bookAShow(final String movie, final String dati, final Patron nm, final String[] seats) {
		Show show = getAShow(movie, dati);
		if (show == null) {
			System.out.println("No show");
			return;
		}
		boolean flag = false;
		String[] sseats = show.getseats();
		for (String seat : seats) {
			for (int i = 0; i < sseats.length; i++) {
				if (seats.equals(sseats[i])) {
					show.setseats(i);
					flag = true;
				}
			}
		}
		if (flag) {
			tickets.add(nm.getmobilenumber() + " " + movie + " " + dati);
		}
	}
	void printTicket(String movie, String showtime, String mobile) {
		String t = mobile + " " + movie + " " + showtime;
		if (tickets.contains(t)) {

			System.out.println(t);
		} else {
			System.out.println("Invalid");
		}

	}
	void showAll() {
		for (Show show : showlist) {
			System.out.println(show.toString() + "," + Arrays.toString(show.getseats()).replace(" ",""));
		}
	} 



}
class Show {
	private String mname;
	private String datetime;
	private String[] seats;
	Show(final String mname, final String datetime, final String[] seats) {
		this.mname = mname;
		this.datetime = datetime;
		this.seats = seats;
	}
	String getmname() {
		return mname;
	}
	String getdatetime() {
		return datetime;
	}
	String[] getseats() {
		return seats;
	}
	void setseats(int index) {
		seats[index] = "N/A";
	}
	public String toString() {
		return mname + "," + datetime;
	}

}
class Patron {
	String pname;
	String mobilenumber;
	Patron(String pname, String mobilenumber) {
		this.pname = pname;
		this.mobilenumber = mobilenumber;
	}
	String getpname() {
		return pname;
	}
	String getmobilenumber() {
		return mobilenumber;
	}
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
                // break;

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
