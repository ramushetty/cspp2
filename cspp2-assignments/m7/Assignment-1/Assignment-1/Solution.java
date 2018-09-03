import java.util.*;
class InputValidator
{
	String input;
	public InputValidator(String data) {
		input = data;
	}
	public boolean validateData() {
		int length = 6;
		return input.length() > length;
	}
}
public final class Solution
{
	public static void main(final String args[])
    {
    	Scanner s = new Scanner(System.in);
    	String input = s.next();
    	InputValidator i = new InputValidator(input);    	
    	System.out.println(i.validateData());

    }

}
