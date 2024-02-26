/*////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Program Name: InsertionSortKK.java                                                                               //
// Name: Keigo Katanaga                                                                                             //
// Date: 05/31/2021                                                                                                 //
//                                                                                                                  //
// Description: Sorts an unsorted file using insertion sort; the designated input file will be sorted and written   //
// into an output file. Sorting order can be changed to decreasing (descending = 1) or increasing (descending = 0). //
*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;

public class InsertionSortKK
{
    public static void main (String[] args)
    {
	String fileLocIn    = "C:\\Games\\unsorted.dat";                                                                        // fileLocationIn; the file to read from
	String fileLocOut   = "C:\\Games\\OUT.dat";                                                                             // fileLocationOut; the file to write on
	
	int descending      = 0;                                                                                                // 0 (no) for ascending, 1 (yes) for descending
	
	int maxArray        = 10000;                                                                                            // Specifies the maximum number of data containable in an array
	int[] unsortedArray = new int [maxArray];                                                                               // Array to contain the unsorted data
	int[] sortedArray   = new int [maxArray];                                                                               // Array to contain the sorted data
	
	String tempHold     = null;                                                                                             // Temporarily holds the integer of a line
	int indexCount      = -1;                                                                                               // Contains the number of elements contained in an array
	
	String tempString   = null;                                                                                             // Temporarily holds the string converted from the sorted integers
	
	try
	{
	    BufferedReader inData  = new BufferedReader (new FileReader (fileLocIn) );                                          // Opens the file containing an unsorted set
	    BufferedWriter outData = new BufferedWriter (new FileWriter (fileLocOut) );                                         // Designates the output to write the sorted set
	    
	    while ( (tempHold = inData.readLine()) != null)
	    {                                                                                                                   // Keeps reading the input until there are no more lines to read
		indexCount++;                                                                                                   // Adds 1 to start the counter at 0; keeps adding 1 before reaching null
		unsortedArray [indexCount] = Integer.parseInt (tempHold);                                                       // Converts the line read in fileLocIn to integer
	    }                                                                                                                   // *End while()
	    
	    if (indexCount == -1)
	    {                                                                                                                   // Activates when elementCount doesn't change; input is empty
		System.out.println ("No values found!");                                                                        // Prints out an error message specifying no data in the input
	    }                                                                                                                   // *End if()
	    
	    else
	    {                                                                                                                   // Activates when there are at least 1 values in the input
		sortedArray = insertionSort (unsortedArray, indexCount, descending);                                            // Sorts the unsorted array using bubble sort
	    }
	    
	    for (int i = 0; i <= indexCount; i++)
	    {                                                                                                                   // Activates for every element that contains a value other than 0
		tempString = String.valueOf (sortedArray[i]);                                                                   // Converts the sorted integers into string
		outData.write (tempString);                                                                                     // Writes the sorted string at position i
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
    // <!> Method Name: insertionSort()                                                                             <!>
    // <!> Input: int[] array (unsorted array), int maxPosn (maximum number of values in an array),                 <!>
    // <!> int orderTo (0 for ascending, 1 for descending)                                                          <!>
    // <!> Output: int[] (sorted array; increasing/decreasing order)                                                <!>
    // <!>                                                                                                          <!>
    // <!> Description: Receives an unsorted array and sorts it in ascending or descending order using insertion    <!>
    // <!> sort.                                                                                                    <!>
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>

    static int[] insertionSort (int[] array, int maxPosn, int orderTo)
    {
	boolean swapOccurs = false;                                                                                             // True when a swap must be done / has been done; false otherwise
	int tempSwap       = 0;                                                                                                 // Temporarily holds a value to be swapped
	
	for (int currPosn = 1; currPosn <= maxPosn; currPosn++)
	{                                                                                                                       // for loop that increments the base index to perform the "insertion" algorithm
	    for (int scanPosn = currPosn; scanPosn >= 1; scanPosn--)
	    {                                                                                                                   // Compares two values: left & right. This occurs all within the base index block
		swapOccurs = false;                                                                                             // Sets swapOccurs as false to reset the swap scan
		
		if (array[scanPosn - 1] > array[scanPosn] && orderTo == 0)
		{                                                                                                               // Activates for ascending order; only when the value before is greater than the value after
		    swapOccurs = true;                                                                                          // Designates that a swap must occur
		}                                                                                                               // *End if()
		else if (array[scanPosn - 1] < array[scanPosn] && orderTo == 1)
		{                                                                                                               // Activates for descending order; only when the value before is lesser than the value after
		    swapOccurs = true;                                                                                          // Designates that a swap must occur
		}                                                                                                               // *End else if()
		
		if (swapOccurs == true)
		{                                                                                                               // Activates when a swap must occur
		    tempSwap            = array[scanPosn - 1];                                                                  // Temporarily holds the left value
		    array[scanPosn - 1] = array[scanPosn];                                                                      // Replaces the left value with the right balue
		    array[scanPosn]     = tempSwap;                                                                             // Replaces the right value with the temporarily held left value
		}                                                                                                               // *End if()
		else
		{                                                                                                               // Activates when a swap doesn't need to occur
		    break;                                                                                                      // Breaks the scanning loop
		}                                                                                                               // *End else
	    
	    }                                                                                                                   // *End for(scanPosn)
	    
	}                                                                                                                       // *End for(currPosn)
	
	return array;                                                                                                           // Returns the sorted array
    
    }                                                                                                                           // *End insertionSort()
    
}                                                                                                                               // *End InsertionSortKK
