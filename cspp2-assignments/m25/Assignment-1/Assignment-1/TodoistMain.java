import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/**
  * write your code below this comment
  */
class Task {
	private String title;
	String assignedTo;
	int timeToComplete;
	boolean important;
	boolean urgent;
	String status;
	String yes = "y";
	String no = "n";
	Task() {

	}
	Task(String tit, String assign, int time, boolean imp, boolean urg, String stat) {
		this.title = tit;
		this.assignedTo = assign;
		this.timeToComplete = time;
		this.important = imp;
		this.urgent = urg;
		this.status = stat;
	}
	String gettitle() {
		return title;
	}
	String getassignedTo() {
		return assignedTo;
	}
	int gettimeToComplete() {
		return timeToComplete;
	}
	String getimportant() {
		if (important) {
			return "Important";
		}
		return "Not Important";
	}
	String geturgent() {
		if (urgent) {
			return "Urgent";
		}
		
		return "Not Urgent";
	}
	String getstatus() {
		return status;
	}
	public void tostring() {
		System.out.println(title + ", " + assignedTo + ", " + timeToComplete+ ", " + getimportant() + ", " + geturgent() + ", " + status);
	}
}
class Todoist {
	// Task t = new Task();
	Task[] tas;
	Todoist() {
		tas = new Task[10];
	}
	// public testAddTask(Task item) {

	// }
	// public void testTask(ArrayList<String> item) {
	// 	ArrayList<Task> t = new ArrayList<>();
	// 	t.add(item);


	// }
}
/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        ArrayList<Task> ta;
        Task fi = new Task();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                ta = new ArrayList<>();
                	String title = tokens[1];
			        String assignedTo = tokens[2];
			        int timeToComplete = Integer.parseInt(tokens[3]);
			        boolean important = tokens[4].equals("y");
			        boolean urgent = tokens[5].equals("y");
			        String status = tokens[6];
			        ta.add(new Task(title, assignedTo, timeToComplete, important, urgent, status));
			        ta.get(0).tostring();
                break;
                // case "add-task":
                //     testAddTask(todo, tokens);
                // break;
                // // case "print-todoist":
                // //     System.out.println(todo);
                // break;
                // case "get-next":
                //     System.out.println(todo.getNextTask(tokens[1]));
                // break;
                // case "get-next-n":
                //     int n = Integer.parseInt(tokens[2]);
                //     Task[] tasks = todo.getNextTask(tokens[1], n);
                //     System.out.println(Arrays.deepToString(tasks));
                // break;
                // case "total-time":
                //     System.out.println(todo.totalTime4Completion());
                // break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    // public static void testAddTask(final Todoist todo, final String[] tokens) {
    //     try {
    //         todo.addTask(createTask(tokens));
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //     }
    // }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
