/*////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Program Name: BubbleSortKK.java                                                                                  //
// Name: Keigo Katanaga                                                                                             //
// Date: 05/26/2021                                                                                                 //
//                                                                                                                  //
// Description: Sorts an unsorted file using bubble sort; the designated input file will be sorted and written into //
// an output file. Sorting order can be changed to decreasing (descending = 1) or increasing (descending = 0).      //
*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;

public class BubbleSortKK
{
    public static void main (String[] args)
    {
	String fileLocIn    = "C:\\Games\\unsorted.dat";                                                                        // fileLocationIn; the file to read from
	String fileLocOut   = "C:\\Games\\OUT.dat";                                                                             // fileLocationOut; the file to write on
	
	int descending      = 0;                                                                                                // 0 (no) for ascending, 1 (yes) for descending
	
	int maxArray        = 10000;                                                                                            // Specifies the maximum number of data containable in an array
	int[] unsortedArray = new int [maxArray];                                                                               // Array to contain the unsorted data
	int[] sortedArray   = new int [maxArray];                                                                               // Array to contain the sorted data
	
	String tempElement  = null;                                                                                             // Temporarily contains the integer of a line
	int elementCount    = -1;                                                                                               // Contains the number of elements contained in an array
	
	String tempHolder   = null;                                                                                             // Temporarily holds the string converted from the sorted integers
	
	try
	{
	    BufferedReader inData  = new BufferedReader (new FileReader (fileLocIn) );                                          // Opens the file containing an unsorted set
	    BufferedWriter outData = new BufferedWriter (new FileWriter (fileLocOut) );                                         // Designates the output to write the sorted set
	    
	    while ( (tempElement = inData.readLine()) != null)
	    {                                                                                                                   // Keeps reading the input until there are no more lines to read
		elementCount++;                                                                                                 // Adds 1 to start the counter at 0; keeps adding 1 before reaching null
		unsortedArray [elementCount] = Integer.parseInt (tempElement);                                                  // Converts the line read in fileLocIn to integer
	    }                                                                                                                   // *End while()
	    
	    if (elementCount == -1)
	    {                                                                                                                   // Activates when elementCount doesn't change; input is empty
		System.out.println ("No values found!");                                                                        // Prints out an error message specifying no data in the input
	    }                                                                                                                   // *End if()
	    
	    else
	    {                                                                                                                   // Activates when there are at least 1 values in the input
		sortedArray = bubbleSort (unsortedArray, elementCount, descending);                                             // Sorts the unsorted array using bubble sort
	    }
	    
	    for (int i = 0; i <= elementCount; i++)
	    {                                                                                                                   // Activates for every element that contains a value other than 0
		tempHolder = String.valueOf (sortedArray[i]);                                                                   // Converts the sorted integers into string
		outData.write (tempHolder);                                                                                     // Writes the sorted string at position i
		outData.newLine ();                                                                                             // Moves to the next line
	    }                                                                                                                   // *End for()
	    
	    inData.close();                                                                                                     // Closes the input file
	    outData.close();                                                                                                    // Closes the output file
	    
	}                                                                                                                       // *End try
	
	catch (IOException e) 
	{                                                                                                                       // Catches the error
	    System.out.println ("Error found! Check your input!" + e);                                                          // Prints out an error message + java's error message
	}                                                                                                                       // *End catch
	 
    }                                                                                                                           // *End main

    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    // <!> Method Name: bubbleSort()                                                                                <!>
    // <!> Input: int[] unsortedArray (unsorted array), int maxPosn (maximum positions allowed in an array),        <!>
    // <!> int orderTo (0 for ascending, 1 for descending)                                                          <!>
    // <!> Output: int[] (sorted array; increasing/decreasing order)                                                <!>
    // <!>                                                                                                          <!>
    // <!> Description: Receives an unsorted array and sorts it in ascending or descending order using bubble sort. <!>
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>

    static int[] bubbleSort (int[] array, int maxPosn, int orderTo)
    {
	boolean swapOccurs = true;                                                                                              // True when a swap must be done / has been done; false otherwise
	int tempSwap       = 0;                                                                                                 // Temporarily holds a value to be swapped
	
	while (swapOccurs == true)
	{                                                                                                                       // Loops until no swap has occured in a loop
	    swapOccurs = false;                                                                                                 // Changes swapOccurs to false; remains false when no swapping has occured

	    for (int p = 0; p < maxPosn; p++)
	    {                                                                                                                   // Loop for swapping depending on the designated inputs
		if (array[p] > array[p+1] && orderTo == 0)
		{                                                                                                               // Activates for ascending order; only when the value before is greater than the value after
		    swapOccurs = true;                                                                                          // Designates that a swap must occur
		}                                                                                                               // *End if()
		else if (array[p] < array[p+1] && orderTo == 1)
		{                                                                                                               // Activates for descending order; only when the value before is lesser than the value after
		    swapOccurs = true;                                                                                          // Designates that a swap must occur
		}                                                                                                               // *End else if()

		if (swapOccurs == true)
		{                                                                                                               // Activates when a swap must occur
		    tempSwap   = array[p];                                                                                      // Temporarily holds the value before
		    array[p]   = array[p+1];                                                                                    // Places the value after into the value before
		    array[p+1] = tempSwap;                                                                                      // Places the temporarily held value into the value after
		}                                                                                                               // *End if()
		
	    }                                                                                                                   // *End for(p)
	    
	}                                                                                                                       // *End while()
	
	return array;                                                                                                           // Returns the sorted array
    
    }                                                                                                                           // *End bubbleSort()
    
}                                                                                                                               // *End BubbleSortKK
