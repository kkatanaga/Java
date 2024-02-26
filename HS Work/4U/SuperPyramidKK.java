/*////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Program Name: SuperPyramidKK.java                                                                                    //
// Name: Keigo Katanaga                                                                                                 //
// Date: 06/14/2021                                                                                                     //
//                                                                                                                      //
// Description: Calculates the "apex" of a sequence much like a Pascal's Triangle; the apex value is the topmost value  //
// in the super pyramid. The super pyramid adds two pairs in a row to fill the sum onto the row above it and requires   //
// a base as an input to work. Input must be separated by line for the program to work properly.                        //
//                                                                                                                      //
// Example Input: 1                                                                                                     //
//                2                                                                                                     //
//                3                                                                                                     //
//                4                                                                                                     //
//                5                                                                                                     //
//                                                                                                                      //
// From the inputs above, the foundation/base will be made out of 5 elements; but because of the behavior of the super  //
// pyramid, the number of elements in the foundation will always be equal to the number of rows in the pyramid. Based   //
// on the example inputs, there are 5 rows in total that make up the pyramid. It will then proceed to add element pairs //
// that are next to each other; the sum of the pair will be placed in between and above the pair:                       //
//                                                                                                                      //
// 1 2 3 4 5 --> 3 5 7 9 -->  3 5 7 9                                                                                   //
//                           1 2 3 4 5                                                                                  //
//                                                                                                                      //
// This will be repeated until the apex is formed:                                                                      //
//         48          <- Apex Value                                                                                    //
//       20  28                                                                                                         //
//      8  12  16                                                                                                       //
//    3   5   7   9                                                                                                     //
//  1   2   3   4   5  <- Foundation                                                                                    //
*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;

public class SuperPyramidKK
{
    public static void main (String[] args) throws IOException
    {
	String fileLocIn   = "C:\\Games\\foundation.txt";                                                                       // fileLocationIn; the file to read the foundation elements from
	
	int maxArray       = 10000;                                                                                             // Specifies the maximum number of data containable in an array
	int[] seqArray     = new int [maxArray];                                                                                // Array to contain the foundation of the super pyramid
	
	String tempElement = null;                                                                                              // Temporarily contains an element
	int elementCount   = 0;                                                                                                 // Contains how many elements are in the base and how many rows the pyramid has
	
	int result         = 0;                                                                                                 // Contains the top most value; the apex value
	
	try
	{
	    BufferedReader inData  = new BufferedReader (new FileReader (fileLocIn) );                                          // Opens the file containing an unsorted set
	    
	    while ( (tempElement = inData.readLine()) != null) 
	    {                                                                                                                   // Keeps reading the input until there are no more lines to read
		seqArray [elementCount] = Integer.parseInt (tempElement);                                                       // Converts the line read in fileLocIn to integer
		elementCount++;                                                                                                 // Adds 1 to the number of elements in the base
	    }                                                                                                                   // *End while()
	    
	    result = pyramidUp (seqArray, elementCount - 1);                                                                    // Calls the pyramid method to solve for the apex
	    
	    inData.close();                                                                                                     // Closes the input file
	}                                                                                                                       // *End try
	
	catch (IOException e) 
	{                                                                                                                       // Catches the error
	    System.out.println ("Error found! Check your input!");                                                              // Prints out an error message
	    System.out.print   (e);                                                                                             // Prints out java's error message
	}                                                                                                                       // *End catch
	
    }                                                                                                                           // *End main()
    
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    // <!> Method Name: pyramidUp()                                                                                 <!>
    // <!> Input: int[] rowCurrent (base), int row (number of rows; initially the number of elements in a row)      <!>
    // <!> Output: int (apex value)                                                                                 <!>
    // <!>                                                                                                          <!>
    // <!> Description: Adds the rows in a pattern; for example, {1, 2, 3} are the inputs. 1 + 2 = 3, and 2 + 3 = 5 <!>
    // <!> so the row above {1, 2, 3} will be {3, 5}. This method is recursive.                                     <!>
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>

    public static int pyramidUp (int[] rowCurrent, int row)
    {
	int[] rowAbove = new int [row];                                                                                         // Contains the row above the input row
	int apex = 0;                                                                                                           // Contains the apex value
	
	if (row == 0) 
	{                                                                                                                       // Activates when the recursion hits row 0 (non-existent)
	    System.out.print   ("[");                                                                                           // Prints out the left bracket
	    System.out.print   (rowCurrent [0]);                                                                                // Prints out the apex value
	    System.out.println ("]");                                                                                           // Prints out the right bracket
	    return rowCurrent [0];                                                                                              // Returns the apex value
	}                                                                                                                       // *End if()
	else 
	{                                                                                                                       // Else adds the rows in a pattern (see description)
	    for (int index = 0; index < row; index++) 
	    {                                                                                                                   // For loop that adds two values next to each other then moves to the next pair until the end
		rowAbove [index] = rowCurrent [index] + rowCurrent [index + 1];                                                 // Adds two pairs together and saves the sum to the row above
	    }                                                                                                                   // *End for()
	    
	    apex = pyramidUp (rowAbove, row - 1);                                                                               // Calls for a recursion; the apex value is saved for later use (basically a buffer)
	}                                                                                                                       // *End else
	
	System.out.print ("[");                                                                                                 // Prints out the left bracket
	
	for (int element = 0; element <= row; element++) 
	{                                                                                                                       // Keeps looping until the whole row in the pyramid is printed
	    if (element == row) 
	    {                                                                                                                   // Activates when the method is printing the last element of the row
		System.out.println (rowCurrent [element] + "]");                                                                // Prints out the right bracket and moves the next print to the next line
	    }                                                                                                                   // *End if()
	    else 
	    {                                                                                                                   // Activates when the method isn't printing the last element of the row
		System.out.print   (rowCurrent [element] + ",");                                                                // Prints out an element in a row
	    }                                                                                                                   // *End else
	    
	}                                                                                                                       // *End for()
	
	return apex;                                                                                                            // Returns the apex value
    }                                                                                                                           // *End pyramidUp()
    
}                                                                                                                               // *End SuperPyramidKK class
