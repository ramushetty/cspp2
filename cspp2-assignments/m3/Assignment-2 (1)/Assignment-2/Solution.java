
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
/**
 * Class for solution.
 * author ramu 
 * roll number 20186082
 * date 29/08/2018
 */
public class Solution
{
/* Fill the main function to print the number of 7's between 1 to n*/
/**
 * { function_description }.
 *
 * @param      args  The arguments
 */
    public static void main(String[] args)
    {

        Scanner s = new Scanner(System.in);      
        int n = s.nextInt();
        int count = 0;
        for (int i =1 ; i < n ; i++) {
        	int j = i;
        	while (j > 0) {
        		int re = j % 10;
        		if (re == 7) {
        			count = count + 1;
        		}
        		j = j / 10;
        	}
        }

    System.out.println(count);
    }
}