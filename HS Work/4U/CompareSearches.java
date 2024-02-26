/*////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Program Name: CompareSearches.java                                                                                       //
// Name: Keigo Katanaga                                                                                                     //
// Date: 05/16/2021                                                                                                         //
//                                                                                                                          //
// Description: Compares the efficiency of Sequential Search and Binary Search methods; two files are required for the      //
// program to run. The following format must be followed in order for the program to work properly:                         //
//   1.) The file used for Binary Search MUST be sorted in increasing order.                                                //
//   2.) Only integers can be searched for by the two methods and no empty spaces before or after the integers.             //
//   3.) The variable int lookFor will tell the program what value to search for; ONLY this variable and the file locations //
//   fileLocSeq & fileLocBin can be changed.                                                                                //
//   4.) The index position of the value will be printed along with whatever designated value is being looked for; if the   //
//   value isn't located anywhere in the sets, the methods will return -1 and print the designated value as N/A.            //
//   5.) The number of integers fed into the program must be equal for sequential search and binary search.                 //
*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;
import java.lang.*;

public class CompareSearches
{
    public static void main (String[] args) throws IOException
    {
	int lookFor       = 9999;                                                                                               // The integer to look for in the files; change in order to find other values
	
	String fileLocSeq = "C:\\Games\\unsortedData3.dat";                                                                     // fileLocation (for) Sequential searching; unsorted numbers   (sequential set)
	String fileLocBin = "C:\\Games\\sorted.dat";                                                                            // fileLocation (for) Binary     searching; sorted numbers     (binary set)
	
	String seqText    = null;                                                                                               // Temporarily holds a line of text from the sequential set
	String binText    = null;                                                                                               // Temporarily holds a line of text from the binary set
	
	boolean overForty;                                                                                                      // True if the title is over forty characters, false if the title is less than forty characters long
	
	int arrayMax      = 5001;                                                                                               // Holds the maximum number of elements containable in an array
	int[] seqArray    = new int[arrayMax];                                                                                  // An array that holds the sequential set
	int[] binArray    = new int[arrayMax];                                                                                  // An array that holds the binary set
	
	int elementCount  = 0;                                                                                                  // Contains the total number of values scanned
	
	int seqIndexLoc   = 0;                                                                                                  // (sequenceIndexLocation); contains the index position of lookFor in the sequential set
	int binIndexLoc   = 0;                                                                                                  // (binaryIndexLocation)  ; contains the index position of lookFor in the binary set
	
	double startTime  = 0.0;                                                                                                // Contains the milliseconds of when a search begins
	double endTime    = 0.0;                                                                                                // Contains the milliseconds of when a search ends
	
	try
	{
	    BufferedReader seqData = new BufferedReader (new FileReader (fileLocSeq) );                                         // Opens the file containing the sequential set
	    BufferedReader binData = new BufferedReader (new FileReader (fileLocBin) );                                         // Opens the file containing the binary set
	    
	    while ( (seqText = seqData.readLine()) != null && (binText = binData.readLine()) != null )
	    {                                                                                                                   // Keeps reading both the sequential & binary set until either one of them runs out of data
		seqArray [elementCount] = Integer.parseInt (seqText);                                                           // Converts the line read in fileLocSeq to integer and saves it to seqArray[]
		binArray [elementCount] = Integer.parseInt (binText);                                                           // Converts the line read in fileLocBin to integer and saves it to seqArray[]
		elementCount++;                                                                                                 // Adds 1 to the counter; seqArray[] and binArray[] will ALWAYS have equal number of elements
	    }                                                                                                                   // *End while()
	    
				/////////////////////
				
	    //////////////////////Sequential Search//////////////////////
	    
				/////////////////////
	    
	    if ( (overForty = printReportTitle ("Sequential Search")) == true )
	    {                                                                                                                   // Prints the title for the sequential search
		System.out.println ("Title is too long!");                                                                      // Prints an error if the title exceeds 40 characters
	    }                                                                                                                   // *End if()
	    
	    startTime = System.currentTimeMillis();                                                                             // Looks at what time the sequential search starts at
	    System.out.println ("Found in index : " + ( seqIndexLoc = sequentialSearch (lookFor, seqArray, elementCount) ));    // Prints out the index position of the number we're looking for in the sequential set
	    endTime   = System.currentTimeMillis();                                                                             // Looks at what time the sequential search ends at
	    
	    if (seqIndexLoc == -1)
	    {                                                                                                                   // Activates when lookFor doesn't exist
		System.out.println ("Looking for    : N/A");                                                                    // Prints out N/A, indicating the number isn't found
	    }                                                                                                                   // *End if()
	    else
	    {                                                                                                                   // Activates when lookFor was found
		System.out.println ("Looking for    : " + seqArray[seqIndexLoc]);                                               // Prints out the number we're looking for
	    }                                                                                                                   // *End else
	    
	    System.out.println ("It took sequential search " + (endTime - startTime) + " ms to find our value.");               // Prints out how many milliseconds it took to complete sequential search
	    System.out.println ();                                                                                              // Prints out a space after the sequential search outputs
	    
	    seqData.close();                                                                                                    // Closes the file containing the sequential set
	    
				  /////////////////
				  
	    ////////////////////////Binary Search////////////////////////
	    
				  /////////////////
	    
	    if ( (overForty = printReportTitle ("Binary Search")) == true )
	    {                                                                                                                   // Prints the title for the binary search
		System.out.println ("Title is too long!");                                                                      // Prints an error if the title exceeds 40 characters
	    }                                                                                                                   // *End if()
	    
	    startTime = System.currentTimeMillis();                                                                             // Looks at what time the binary search starts at
	    System.out.println ("Found in index : " + (binIndexLoc = binarySearch (lookFor, binArray, elementCount ) ));        // Prints out the index position of the number we're looking for in the binary set
	    endTime   = System.currentTimeMillis();                                                                             // Looks at what time the binary search ends at
	    
	    if (binIndexLoc == -1)
	    {                                                                                                                   // Activates when lookFor wasn't found
		System.out.println ("Looking for    : N/A");                                                                    // Prints out N/A, indicating the number isn't found
	    }                                                                                                                   // *End if()
	    else
	    {                                                                                                                   // Activates when lookFor was found
		System.out.println ("Looking for    : " + binArray[binIndexLoc]);                                               // Prints out the number we're looking for
	    }                                                                                                                   // *End else
	    
	    System.out.println ("It took binary search " + (endTime - startTime) + " ms to find our value.");                   // Prints out how many milliseconds it took to complete binary search
	    System.out.println ();                                                                                              // Prints out a space after the binary search outputs
	    
	    binData.close();                                                                                                    // Closes the file containing the binary set
	}                                                                                                                       // *End try
	
	catch (IOException e)
	{
	    System.out.println ("Error found!");                                                                                // Prints out error message header
	    System.out.println (e);                                                                                             // Prints out the java error message
	}                                                                                                                       // *End catch()
	
    }                                                                                                                           // *End main()
    
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    // <!> Method Name: printReportTitle()                                                                          <!>
    // <!> Input: String (the specified report title)                                                               <!>
    // <!> Output: boolean                                                                                          <!>
    // <!>                                                                                                          <!>
    // <!> Description: Receives a report title string and centers it within 40 characters before printing. Returns <!>
    // <!> true if the input is more than 40; returns false if the input is less than 40.                           <!>
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>

    static boolean printReportTitle (String inputTitle)
    {
	int padding = 0;                                                                                                        // Contains how much the title needs to be spaced
																// Tries in case the input title has problems
	if (inputTitle.length() <= 40)
	{                                                                                                                       // If statement to limit title length to be less than or equal to 40 characters
	    padding = (40 - inputTitle.length() ) / 2;                                                                          // Calculates how much padding is required for proper alignment
	    
	    for (int x = 0; x < padding; x++) 
	    {                                                                                                                   // Keeps looping until there are enough spaces to center the alignment of the title
		inputTitle = " " + inputTitle;                                                                                  // Adds Y amount of spaces before inputTitle, where Y is determined by the previously calculated padding
	    }                                                                                                                   // *End for()
	    
	    System.out.println ("----------------------------------------");                                                    // Prints out 40 dashes for the top border
	    System.out.println (inputTitle);                                                                                    // Prints out the input received
	    System.out.println ("----------------------------------------");                                                    // Prints out 40 dashes for the bottom border

	    return false;                                                                                                       // Returns a boolean to signify overForty is false
	}                                                                                                                       // *End if()
	
	else 
	{                                                                                                                       // Else statement if title length exceeds 40 characters
	    return true;                                                                                                        // Returns a boolean to signify overForty is true
	}                                                                                                                       // *End else
	
    }                                                                                                                           // *End printReportTitle()
    
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    // <!> Method Name: sequentialSearch()                                                                          <!>
    // <!> Input: int seqSearchFor (the value we're looking for), int[] seqLookIn (the array we're looking into),   <!>
    // <!> int seqIndexTotal (the total number of indexes in the file)                                              <!>
    // <!> Output: int (index position of the value searched for)                                                   <!>
    // <!>                                                                                                          <!>
    // <!> Description: Looks for the specified information (currently an int) sequentially within an array. If the <!>
    // <!> information is found, this method returns the index location of the match; else returns -1.              <!>
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    
    public static int sequentialSearch (int seqSearchFor, int[] seqLookIn, int seqIndexTotal)
    {
	int atIndex = 0;                                                                                                        // Contains the current index position
	
	while (seqSearchFor != seqLookIn[atIndex] && atIndex < seqIndexTotal)
	{                                                                                                                       // Keeps looping until seqSearchFor is found in the array
	    atIndex++;                                                                                                          // Adds 1 to the index counter
	}                                                                                                                       // *End while()
	
	if (seqSearchFor != seqLookIn[atIndex])
	{                                                                                                                       // Activates when seqSearchFor isn't foundin the array
	    return atIndex = -1;                                                                                                // Returns -1, indicating failure
	}                                                                                                                       // *End if()
    
	return atIndex;                                                                                                         // Returns seqSearchFor's index position
    }                                                                                                                           // *End sequentialSearch()
    
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    // <!> Method Name: binarySearch()                                                                              <!>
    // <!> Input: int binSearchFor (the value we're looking for), int[] binLookIn (the array we're looking into),   <!>
    // <!> int binIndexTotal (the total number of indexes in the file)                                              <!>
    // <!> Output: int (index position of the value searched for)                                                   <!>
    // <!>                                                                                                          <!>
    // <!> Description: A method that uses binary search to look for a piece of information within a set; a binary  <!>
    // <!> search keeps cutting until the information needed is found. If the information is found, this method     <!>
    // <!> returns the index location of the match; else returns -1.                                                <!>
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    
    public static int binarySearch (int binSearchFor, int[] binLookIn, int binIndexTotal)
    {
	int lowHalf      = 0;                                                                                                   // Contains the lowest array index needed
	int midHalf      = 0;                                                                                                   // Contains the array index between lowHalf and higHalf (the index position of binSearchFor)
	int higHalf      = 0;                                                                                                   // Contains the highest array index needed
	
	int checkMatch   = 0;                                                                                                   // Contains the data in midHalf for determining whether it matches binSearchFor or not
	int loopCount    = 0;                                                                                                   // Contains how many loops have occured
	double loopLimit = 0;
	
	midHalf = binIndexTotal / 2;                                                                                            // Cuts the max index in half
	higHalf = binIndexTotal;                                                                                                // Adjusts the binary search to the highest contained number of data
	
	loopLimit = Math.log(binIndexTotal)/Math.log(2);                                                                        // Calculates the binary cut limit (log base 2 of N, where N is the total number of index)
	
	while (binSearchFor != ( checkMatch = binLookIn[midHalf] ) && loopCount < loopLimit)
	{                                                                                                                       // Keeps looping until binSearchFor is found in the array
	    if (checkMatch > binSearchFor)
	    {                                                                                                                   // Activates when binSearchFor's value is lower than what the binary search found
		higHalf = midHalf;                                                                                              // Lowers the upper limit of the search
	    }                                                                                                                   // *End if()
	    else if (checkMatch < binSearchFor)
	    {                                                                                                                   // Activates when binSearchFor's value is higher than what the binary search found
		lowHalf = midHalf;                                                                                              // Raises the lower limit of the search
	    }                                                                                                                   // *End else if()
	    
	    midHalf = ( (higHalf - lowHalf) / 2) + lowHalf ;                                                                    // Calculates how the binary search should be halved
	    loopCount++;                                                                                                        // Counts the number of loops that occured
	}                                                                                                                       // *End while()
	
	if (binSearchFor != binLookIn[midHalf])
	{                                                                                                                       // Activates when the value can't be found
	    return midHalf = -1;                                                                                                // Returns -1, indicating failure
	}                                                                                                                       // *End if()
	
	return midHalf;                                                                                                         // Returns binSearchFor's index position
    }                                                                                                                           // *End binarySearch()
    
}                                                                                                                               // *End CompareSearches class
