/*////////////////////////////////////////////////////////////////////////////////////////
// Program Name: ProgramTwoKK.java                                                      //
// Name: Keigo Katanaga                                                                 //
// Date: 04/27/2021                                                                     //
//                                                                                      //
// Description: Reads the first line to create a bordered & centered title (within 40   //
// characters); if it exceeds 40, the program prints an error message and stops.        //
// The program will keep printing the remaining data (any number of characters) without //
// borders & centering until there are no more lines of readable data.                  //
*/////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;

public class ProgramTwoKK
{

    public static void main (String[] args) throws IOException
    {
	String fileLocation = "C:\\Games\\textdata.txt";                                            // Specified file location for reading
	String lineText     = null;                                                                 // Holds a line of text from fileLocation
	boolean outcome;                                                                            // Boolean for whether the reportTitle exceeds 40 characters (false) or not (true)
	
	try 
	{                                                                                           // Try in order to avoid crashing
	    BufferedReader inputData = new BufferedReader (new FileReader ( fileLocation ));        // Reads a line from the file
	    outcome = printReportTitle (lineText = inputData.readLine());                           // Reads the line (title), puts it into lineText and sends that line to printReportTitle. Variable outcome takes in a boolean.
	    
	    while ( (lineText = inputData.readLine()) != null) {                                    // Keeps reading lines until the line being read is empty
		System.out.println (lineText);                                                      // Prints out the line read after the first line (title)
	    }                                                                                       // *End while()

	    System.out.println ();
	    System.out.println ("All text successfully printed: " + outcome);                       // States whether the program was able to print everything in the file
	    inputData.close();                                                                      // Closes the file
	}                                                                                           // *End try
	
	catch (IOException e) 
	{                                                                                           // Catches the error
	    System.out.println ("Error Found!");                                                    // Prints out "Error Found!"
	    System.out.println (e);                                                                 // Prints out the error message
	}                                                                                           // *End catch
	
    }                                                                                               // *End main

    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    // <!> Method Name: printReportTitle()                                      <!>
    // <!> Input: String (the specified report title)                           <!>
    // <!> Output: void                                                         <!>
    // <!>                                                                      <!>
    // <!> Description: Receives a report title string and centers it within    <!>
    // <!> 40 characters before printing. Returns true if the input is less     <!>
    // <!> than 40; returns false if the input is more than 40.                 <!>
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>

    static boolean printReportTitle (String inputTitle)
    {
	if (inputTitle.length() <= 40) 
	{                                                                                           // If statement to limit title length to be less than or equal to 40 characters
	    int padding = (40 - inputTitle.length() ) / 2;                                          // Calculates how much padding is required for proper alignment
	    
	    for (int x = 0; x < padding; x++) 
	    {                                                                                       // Keeps looping until there are enough spaces to center the alignment of the title
		inputTitle = " " + inputTitle;                                                      // Adds x amount of spaces before inputTitle, where x is determined by the previously calculated padding
	    }                                                                                       // *End for()
	    
	    System.out.println ("----------------------------------------");                        // Prints out 40 dashes for the top border
	    System.out.println (inputTitle);                                                        // Prints out the input received
	    System.out.println ("----------------------------------------");                        // Prints out 40 dashes for the bottom border

	    return true;                                                                            // Returns a boolean "true"
	}                                                                                           // *End if()
	
	else 
	{                                                                                           // Else statement if title length exceeds 40 characters
	    return false;                                                                           // Returns a boolean "false"
	}                                                                                           // *End else
	
    }                                                                                               // *End printReportTitle()
    
}                                                                                                   // *End ProgramTwoKK
