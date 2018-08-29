
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution 
{

    public static void main(String[] args)
    {

        Scanner s = new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int gcd = gcd(n1, n2);
        System.out.println(gcd);
    }
    /*
	Need to write the gcd function and print the output.
	*/
    public static int gcd(final int n1, final int n2)
    {
        int k =0;

        for (int i = 1; i<=n1; i++)
        {

            if ((n1%i==0) && (n2%i==0))
            {

                k = i;
            } 

        }
        return k;
    }
}     
        

