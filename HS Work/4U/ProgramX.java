// The "ProgramX" class.
public class ProgramX
{

//-----------------------------------------------
    static void printTitle( )
    {
	System.out.println ("------------");
	System.out.println ("Report Title");
	System.out.println ("------------");
    }
//-----------------------------------------------


    static void printName(String name, int age)
    {
	System.out.println (name);
	System.out.println (age);
    
    }
    
    static double average(int grade1, int grade2, int grade3, int grade4)
    {
	return (grade1+grade2+grade3+grade4)/4.00;
    }
    
    public static void main (String[] args)
    {
	printTitle( );
	printName ("Keigo", 16);
	System.out.println (average(50,60,45,99));
    
    } // main method
} // ProgramX class
