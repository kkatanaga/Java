public class Example_Methods
{
    public static void main (String[] args)
    {
	int valueA = 5;                                         // First example value
	int valueB = 4;                                         // Second example value
	int newValue = 0;                                       // Holds the resulting value
	
	newValue = methodName (valueA, valueB);                 // Calls for the method "methodName" and sends value
	
	System.out.println (newValue);                          // Prints out newValue which is 9
    } 
    
    public static int methodName (int exInputA, int exInputB)
    {
	return exInputA + exInputB;                             // Adds exInputA and exInputB; 5 + 4, and returns it
    }
}                                                               // *End class Example_Methods

