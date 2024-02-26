import java.io.*;

public class SuperPyramidKK
{
    public static void main (String[] args) throws IOException
    {
	String fileLocIn    = "C:\\Games\\sequence.txt";                                                                        // fileLocationIn; the file to read from
	
	int maxArray        = 10000;                                                                                            // Specifies the maximum number of data containable in an array
	int[] seqArray = new int [maxArray];                                                                               // Array to contain the unsorted data
	String tempElement = null;
	int result = 0;
	int elementCount = 0;
	
	try
	{
	    BufferedReader inData  = new BufferedReader (new FileReader (fileLocIn) );                                          // Opens the file containing an unsorted set
	    
	    while ( (tempElement = inData.readLine()) != null) {                                                                // Keeps reading the input until there are no more lines to read
		seqArray [elementCount] = Integer.parseInt (tempElement);                                                       // Converts the line read in fileLocIn to integer
		elementCount++;
	    }                                                                                                                   // *End while()
	    result = pyramid (seqArray, elementCount - 1);
	}
	
	catch (IOException e) 
	{                                                                                                                       // Catches the error
	    System.out.println ("Error found! Check your input!" + e);                                                          // Prints out an error message + java's error message
	}                                                                                                                       // *End catch
    }                                                                                                                           // *End main()
    
    
    public static int pyramid (int[] rowCurrent, int num)
    {
	int[] rowAbove = new int [num];                                                                                         // Contains the
	
	for (int element = 0; element <= num; element++)
	{
	    System.out.print (rowCurrent [element] + " ");
	}
	System.out.println ();
	
	if (num == 0) 
	{
	    return rowCurrent [0];
	} 
	else 
	{
	    for (int x = 0; x < (num); x++) {
		rowAbove [x] = rowCurrent [x] + rowCurrent [x + 1];
	    }
	    return pyramid (rowAbove, num - 1);
	}
	
    }
    
} // SuperPyramidKK class
