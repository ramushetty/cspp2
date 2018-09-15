import java.util.Scanner;
import java.util.ArrayList;
class Quiz {
	String questionn;
	String questionchoices;
	String correctanswer;
	int alloatedmarks;
	int minusmarks;
	Quiz(final String questionn1,
	     final String questionchoices1, final String correctanswer1,
	     final int alloatedmarks1, final int minusmarks1) {
		this.questionn = questionn1;
		this.questionchoices = questionchoices1;
		this.correctanswer = correctanswer1;
		this.alloatedmarks = alloatedmarks1;
		this.minusmarks = minusmarks1;


	}
	Quiz( ) {

	}
	String getquestionn() {
		return questionn;
	}
	String getquestionchoices() {
		return questionchoices;
	}
	String getcorrectanswer() {
		return "choice" + " " + correctanswer;
	}
	int getalloatedmarks() {
		return alloatedmarks;
	}
	int getminusmarks() {
		return minusmarks;
	}
	public void setgetcorrectanswer(String an) {
		this.correctanswer = an;
	}

}

/**
 * Solution class for code-eval.
 */
public final class Solution {
	/**
	* Constructs the object.
	*/
	private Solution() {
		// leave this blank
	}
	/**
	 * main function to execute test cases.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		// instantiate this Quiz
		Quiz quiz = new Quiz();
		// code to read the test cases input file
		Scanner s = new Scanner(System.in);
		// check if there is one more line to process
		while (s.hasNext()) {
			// read the line
			String line = s.nextLine();
			// split the line using space
			String[] tokens = line.split(" ");
			// based on the list operation invoke the corresponding method
			switch (tokens[0]) {
			case "LOAD_QUESTIONS":
				System.out.println("|----------------|");
				System.out.println("| Load Questions |");
				System.out.println("|----------------|");
				loadQuestions(s, quiz, Integer.parseInt(tokens[1]));
				break;
			case "START_QUIZ":
				System.out.println("|------------|");
				System.out.println("| Start Quiz |");
				System.out.println("|------------|");
				startQuiz(s, quiz, Integer.parseInt(tokens[1]));
				break;
			case "SCORE_REPORT":
				System.out.println("|--------------|");
				System.out.println("| Score Report |");
				System.out.println("|--------------|");
				displayScore(quiz);
				break;
			default:
				break;
			}
		}
	}
	private static ArrayList<Quiz> q = new ArrayList<>();
	private static String[] p = new String[10];
	/**
	 * Loads questions.
	 *
	 * @param      s              The scanner object for user input
	 * @param      quiz           The quiz object
	 * @param      questionCount  The question count
	 */
	public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
		// write your code here to read the questions from the console
		// tokenize the question line and create the question object
		// add the question objects to the quiz class

		int count = questionCount;
		if (count >= 1) {
			for (int i = 1; i <= questionCount; i++) {

				String all = s.nextLine();
				String[] tokens = all.split(":");
				if (tokens.length == 5) {
					String[] tchoice = tokens[1].split(",");
					if (tchoice.length >= 2) {
						Quiz obj = new Quiz(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
						q.add(obj);
					} else {
						System.out.println("<" + tokens[0] +">" + " does not have enough answer choices");
						break;
					}


				} else {
					System.out.println("Error! Malformed question");
					break;
				}
			}
			System.out.println(count + " are added to quiz");
		} else {
			System.out.println("Quiz does not have questions");
		}

	}

	/**
	 * Starts a quiz.
	 *
	 * @param      s            The scanner object for user input
	 * @param      quiz         The quiz object
	 * @param      answerCount  The answer count
	 */
	public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
		// write your code here to display the quiz questions
		// read the user responses from the console
		// store the user respones in the quiz object
		int countt = answerCount;
		for (Quiz e : q) {
			System.out.println(e.getquestionn());
			String[] choi = e.getquestionchoices().split(",");
			for (int j = 0; j < choi.length; j++) {
				System.out.print(choi[j] + "	");

			}
			System.out.println();

		}

		for (int i = 0; i <= countt; i++) {
			String ss = s.nextLine();
			p[i] = ss;
		}

	}

	/**
	 * Displays the score report
	 *
	 * @param      quiz     The quiz object
	 */
	public static void displayScore(final Quiz quiz) {
		// write your code here to display the score report
		int total = 0;
		for (int i = 0; i < p.length; i++) {
			for (Quiz e : q) {
				if (e.getcorrectanswer().equals(p[i])) {
					System.out.println("Correct Answer! - Marks Awarded: " + e.getalloatedmarks());
					total += e.getalloatedmarks();
				} else {
					System.out.println("Wrong Answer! - Penalty: " + e.getminusmarks());
					total -= e.getminusmarks();
				}
				}
		}
		// System.out.println(total);
	}
}
