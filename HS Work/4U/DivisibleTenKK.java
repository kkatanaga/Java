/*////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Program Name: DivisibleTenKK.java                                                                                    //
// Name: Keigo Katanaga                                                                                                 //
// Date: 06/08/2021                                                                                                     //
//                                                                                                                      //
// Description: Calculates the number of turns an input X requires such that X becomes divisible by 10; this process    //
// is done by multiplying X by 2, and the number of times X is multiplied by 2 defines the number of turns. If the      //
// number of turns is certain, then the program prints out the number of turns; else it will print out -1. The first    //
// input must be an integer that specifies how many lines after itself will the program manipulate.                     //
//                                                                                                                      //
// Example Input:                                                                                                       //
// 4        - Program will deal with 4 lines after itself                                                               //
// 10       - By default, divisible by 10; 0 turns                                                                      //
// 20       - By default, divisible by 10; 0 turns                                                                      //
// 25       - Indivisible; multiply by 2 ONCE to get 50- divisible by 10; 1 turn                                        //
// 6        - Indivisible; can never be divisible by 10 even after multiple turns; -1 turns                             //
// 18       - 5th line, therefore not accounted for; indivisible anyways even after multiple turns                      //
*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;

public class DivisibleTenKK
{
    public static void main (String[] args) throws IOException
    {
	String fileLocIn = "C:\\Games\\indata.txt";                                                                             // fileLocationIn; the file to read from
	
	boolean underForty;                                                                                                     // Boolean for whether the report title is under 35 characters (true) or not (false)
	
	int loopCount    = 0;                                                                                                   // Contains the number of loops to be done (first integer input from the file)
	int lineNum      = 1;                                                                                                   // Contains what line/value is being worked on (excluding the first line)
	
	int number       = 0;                                                                                                   // Contains the value to be made divisible by 10; our value X
	
	int turnCount    = -1;                                                                                                  // Contains the number of turns used; starts at -1 to deignate the value as impossible to manipulate
	
	try
	{
	    BufferedReader inData  = new BufferedReader (new FileReader (fileLocIn) );                                          // Opens the file containing an unsorted set
	    
	    underForty = printReportTitle ("LAB TEST #2");                                                                      // Prints out the title "LAB TEST #2"
	    loopCount = Integer.parseInt (inData.readLine());                                                                   // Inputs the first line, the number of loops, into loopCount
	    
	    while ( lineNum <= loopCount && ( number = Integer.parseInt (inData.readLine()) ) != 0 )
	    {                                                                                                                   // Loops until the number of lines reaches the number of loops or the data is empty
		while (number % 5 == 0)
		{                                                                                                               // Loops while X is divisible by 5 until X is divisible by 10
		    turnCount++;                                                                                                // Adds 1 to the turn count
		    
		    if (number % 10 == 0)
		    {                                                                                                           // Activates when X becomes divisible by 10
			break;                                                                                                  // Breaks out of the while loop
		    }                                                                                                           // *End if()
		    
		    number = number * 2;                                                                                        // Multiplies X by 2
		}                                                                                                               // *End while()
		
		System.out.println (turnCount);                                                                                 // Prints out the number of turns used for X
		turnCount = -1;                                                                                                 // Resets the turn counter
		lineNum++;                                                                                                      // Specifies the movement to the next line
	    }                                                                                                                   // *End for()
	    
	    inData.close();                                                                                                     // Closes the input file
	    
	}                                                                                                                       // *End try
	
	catch (IOException e)
	{                                                                                                                       // Catches the error to avoid ugly messages
	    System.out.println ("Error Found!");                                                                                // Prints out "Error Found!"
	    System.out.println (e);                                                                                             // Prints out the error message
	}                                                                                                                       // *End catch
	
    }                                                                                                                           // *End main

    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    // <!> Method Name: printReportTitle()                                                                          <!>
    // <!> Input: String (the specified report title)                                                               <!>
    // <!> Output: boolean                                                                                          <!>
    // <!>                                                                                                          <!>
    // <!> Description: Receives a report title string and centers it within 35 characters before printing. Returns <!>
    // <!> true if the input is more than 35; returns false if the input is less than 35.                           <!>
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>

    static boolean printReportTitle (String inputTitle)
    {
	int padding = 0;                                                                                                        // Contains how much the title needs to be spaced
																// Tries in case the input title has problems
	if (inputTitle.length() <= 35)
	{                                                                                                                       // If statement to limit title length to be less than or equal to 40 characters
	    padding = (35 - inputTitle.length() ) / 2;                                                                          // Calculates how much padding is required for proper alignment
	    
	    for (int x = 0; x < padding; x++) 
	    {                                                                                                                   // Keeps looping until there are enough spaces to center the alignment of the title
		inputTitle = " " + inputTitle;                                                                                  // Adds Y amount of spaces before inputTitle, where Y is determined by the previously calculated padding
	    }                                                                                                                   // *End for()
	    
	    System.out.println ("-----------------------------------");                                                         // Prints out 35 dashes for the top border
	    System.out.println (inputTitle);                                                                                    // Prints out the input received
	    System.out.println ("-----------------------------------");                                                         // Prints out 35 dashes for the bottom border

	    return false;                                                                                                       // Returns a boolean to signify overForty is false
	}                                                                                                                       // *End if()
	
	else 
	{                                                                                                                       // Else statement if title length exceeds 40 characters
	    return true;                                                                                                        // Returns a boolean to signify overForty is true
	}                                                                                                                       // *End else
	
    }                                                                                                                           // *End printReportTitle()
 
}                                                                                                                               // *End DivisibleTenKK class
