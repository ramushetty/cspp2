import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class for question.
 */
class Question {
  /**
   * { question text }.
   */
  private String questiontext;
  /**
   * { given choices }.
   */
  private  String choices;
  /**
   * { correct answer }.
   */
  private int correctAnswer;
  /**
   * { max marks allocated to question }.
   */
  private int maxMarks;
  /**
   * { minus marks for wrong answer }.
   */
  private int penalty;
  /**
   * { response }.
   */
  private String response;
  /**
   * Constructs the object.
   */
  Question() {

  }
  /**
   * Constructs the object.
   *
   * @param      question1       The question 1
   * @param      choices1        The choices 1
   * @param      correctAnswer1  The correct answer 1
   * @param      maxMarks1       The maximum marks 1
   * @param      penalty1        The penalty 1
   */
  Question(final String question1, final String choices1,
           final int correctAnswer1, final int maxMarks1, final int penalty1) {
    this.questiontext = question1;
    this.choices = choices1;
    this.correctAnswer = correctAnswer1;
    this.maxMarks = maxMarks1;
    this.penalty = penalty1;

  }
  /**
   * { checks for correct answer }.
   *
   * @param      choice  The choice
   *
   * @return     {returns true or false }
   */
  public boolean evaluateResponse(final String choice) {
    String[] ch = getChoice().split(",");
    return ch[correctAnswer - 1].equals(choice);
  }
  /**
   * Gets the correct answer.
   *
   * @return     The correct answer.
   */
  public String getCorrectAnswer() {

    return correctAnswer + "";
  }
  /**
   * Gets the question text.
   *
   * @return     The question text.
   */
  public String getquestiontext() {
    return questiontext;
  }
  /**
   * Gets the choice.
   *
   * @return     The choice.
   */
  public String getChoice() {
    return choices;
  }
  /**
   * Gets the maximum marks.
   *
   * @return     The maximum marks.
   */
  public int getMaxMarks() {
    return maxMarks;
  }
  /**
   * Gets the penalty.
   *
   * @return     The penalty.
   */
  public int getPenalty() {
    return penalty;
  }
  /**
   * Sets the response.
   *
   * @param      answer  The answer
   */
  public void setResponse(final String answer) {

  }
  /**
   * Gets the response.
   *
   * @return     The response.
   */
  public String getResponse() {
    return null;
  }
  /**
   * Returns a string representation of the object.
   *
   * @return     String representation of the object.
   */
  public String toString() {
    String s = "";
    return s;
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
    //Quiz q = new Quiz();
    ArrayList<Question> q = new ArrayList<>();
    // code to read the test cases input file
    Scanner s = new Scanner(System.in);
    // check if there is one more line to process
    while (s.hasNext()) {
      // read the line
      String line = s.nextLine();
      // split the line using space
      String[] tokens = line.split(" ");
      // based on the list operation invoke the corresponding method
      // System.out.println(tokens[0]);
      // System.out.println(tokw);
      switch (tokens[0]) {
      case "LOAD_QUESTIONS":
        System.out.println("|----------------|");
        System.out.println("| Load Questions |");
        System.out.println("|----------------|");
        loadQuestions(s, q, Integer.parseInt(tokens[1]));
        break;
      case "START_QUIZ":
        System.out.println("|------------|");
        System.out.println("| Start Quiz |");
        System.out.println("|------------|");
        startQuiz(s, q, Integer.parseInt(tokens[1]));
        break;
      case "SCORE_REPORT":
        System.out.println("|--------------|");
        System.out.println("| Score Report |");
        System.out.println("|--------------|");
        displayScore(q);
        break;
      default:
        break;
      }
    }
  }

  /**
   * { string array to store answers }.
   */
  private static String[] p = new String[2 + 2 + 2 + 2 + 2 + 2];

  /**
   * Loads questions.
   *
   * @param      scan       The scan
   * @param      q          The quiz
   * @param      z          The question count
   *
   */
  public static void loadQuestions(final Scanner scan,
                                   final ArrayList<Question> q, final int z) {
    // write your code here to read the questions from the console
    // tokenize the question line and create the question object
    // add the question objects to the quiz class
    int count = 0;
    if (z > 0) {
      for (int i = 0; i < z; i++) {
        String line = scan.nextLine();
        String[] tokens = line.split(":");

        if ((tokens.length == (2 + 2 + 1)) && !(tokens[0].equals(""))) {
          String[] choi = tokens[1].split(",");
          if (choi.length >= 2) {
            if (Integer.parseInt(tokens[2 + 1]) > 0) {
              // System.out.println(choi.length);
              if (Integer.parseInt(tokens[2]) <= choi.length) {
                if (Integer.parseInt(tokens[2 + 2]) <= 0) {
                  q.add(new Question(tokens[0], tokens[1],
  Integer.parseInt(tokens[2]), Integer.parseInt(
    tokens[2 + 1]), Integer.parseInt(tokens[2 + 2])));
                  count++;

                  if (count == z) {
                    System.out.println(z + " are added to the quiz");
                  }

                } else {
                  System.out.println("Invalid penalty for " + tokens[0]);
                }
              } else {
                System.out.println(
      "Error! Correct answer choice number is out of range for " + tokens[0]);
              }

            } else {
              System.out.println("Invalid max marks for " + tokens[0]);
            }


          } else {
            System.out.println(
              tokens[0] + " does not have enough answer choices");
          }
        } else {
          System.out.println("Error! Malformed question");
        }
      }
    } else {
      System.out.println("Quiz does not have questions");
    }
  }
  /**
   * Starts a quiz.
   *
   * @param      scan  The scan
   * @param      quiz  The quiz
   * @param      a     The answer count
   */
  public static void startQuiz(final Scanner scan,
                               final ArrayList<Question> quiz, final int a) {
    // write your code here to display the quiz questions on the console.
    // read the user responses from the console using scanner object.
    // store the user respone in the question object
    int countt = a;
    for (Question e : quiz) {
      System.out.println(e.getquestiontext() + "(" + (e.getMaxMarks()) + ")");
      String[] choi = e.getChoice().split(",");
      for (int j = 0; j < choi.length - 1; j++) {
        System.out.print(choi[j]  + "\t");
      }
      System.out.print(choi[choi.length - 1]);
      System.out.println("\n");

    }
    for (int i = 0; i < countt; i++) {
      String ss = scan.nextLine();
      p[i] = ss;
    }
  }
  /**
   * Displays the score report.
   *
   * @param      quiz     The quiz object
   */
  public static void displayScore(final ArrayList<Question> quiz) {
    // write your code here to display the score report using quiz object.
    int total = 0;
    int c = 0;
    int i = 0;

    for (Question e : quiz) {
      System.out.println(e.getquestiontext());
      if (i < p.length) {
        if (e.evaluateResponse(p[i])) {
          System.out.println(
            " Correct Answer! - Marks Awarded: " + e.getMaxMarks());
          total += e.getMaxMarks();
          i++;
          c++;
        } else {
          System.out.println(" Wrong Answer! - Penalty: " + e.getPenalty());
          total = total + e.getPenalty();
          i++;
          c++;
        }
      }
    }
    if (c  != 0) {
      System.out.println("Total Score: " + total);
    }
  }
}
