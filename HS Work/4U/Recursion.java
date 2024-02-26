// The "Recursion" class.
public class Recursion
{
    public static void main (String[] args)
    {
	System.out.println (fact (5));
    } // main method
    
    public static int fact (int x)
    {
	if (x == 1) {
	    return 1;
	}
	else
	{
	    return x * fact (x-1);
	}
    }
} // Recursion class
