/*////////////////////////////////////////////////////////////////////////////////
// Program Name: ProgramOneKK.java                                              //
// Name: Keigo Katanaga                                                         //
// Date: 04/21/2021                                                             //
//                                                                              //
// Description: Prints a bordered report title with proper alignment (centered) //
*/////////////////////////////////////////////////////////////////////////////////

public class ProgramOneKK
{

    public static void main (String[] args)
    {
	String reportTitle = "Math Exam";                                                                                   // String variable to cntain the report title
	boolean overForty;                                                                                                  // Boolean for whether the reportTitle exceeds 40 characters (true) or not (false)
	
	overForty = printReportTitle (reportTitle);                                                                         // Sends reportTitle to the printReportTitle method
	System.out.println (overForty);                                                                                     // Check if the program works or not
	
    }                                                                                                                       // *End main

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
	int padding = 0;                                                                                                    // Contains how much the title needs to be spaced
															    // Tries in case the input title has problems
	if (inputTitle.length() <= 40)
	{                                                                                                                   // If statement to limit title length to be less than or equal to 40 characters
	    padding = (40 - inputTitle.length() ) / 2;                                                                      // Calculates how much padding is required for proper alignment
	    
	    for (int x = 0; x < padding; x++) 
	    {                                                                                                               // Keeps looping until there are enough spaces to center the alignment of the title
		inputTitle = " " + inputTitle;                                                                              // Adds Y amount of spaces before inputTitle, where Y is determined by the previously calculated padding
	    }                                                                                                               // *End for()
	    
	    System.out.println ("----------------------------------------");                                                // Prints out 40 dashes for the top border
	    System.out.println (inputTitle);                                                                                // Prints out the input received
	    System.out.println ("----------------------------------------");                                                // Prints out 40 dashes for the bottom border

	    return false;                                                                                                   // Returns a boolean to signify overForty is false
	}                                                                                                                   // *End if()
	
	else 
	{                                                                                                                   // Else statement if title length exceeds 40 characters
	    return true;                                                                                                    // Returns a boolean to signify overForty is true
	}                                                                                                                   // *End else
	
    }                                                                                                                       // *End printReportTitle()
 
}                                                                                                                           // *End ProgramOneKK
