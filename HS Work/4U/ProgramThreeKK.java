/*////////////////////////////////////////////////////////////////////////////////////////////////////
// Program Name: ProgramThreeKK.java                                                                //
// Name: Keigo Katanaga                                                                             //
// Date: 04/29/2021                                                                                 //
//                                                                                                  //
// Description: Reads the first line to create a bordered & centered title (within 40 characters);  //
// if it exceeds 40, the program prints an error message and stops.                                 //
//                                                                                                  //
// This program will keep reading and take in complete lines of text with "pieces" separated by     //
// commas. These pieces will be printed with spaces inbetween and separated per line. Currently,    //
// each line can only have 5 pieces for the porgram to work properly.                               //
//                                                                                                  //
//      Example line 1: John,Flintstone,19,159,49   -> 5 pieces separated by commas                 //
//      Example line 2: Mark,Conception,23,180,55                                                   //
//                                                                                                  //
//      Result:         John Flintstone 19 159 49   -> same as line 1 except with spaces            //
//                      Mark Conception 23 180 55                                                   //
*/////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;

public class ProgramThreeKK
{

    public static void main (String[] args) throws IOException
    {
	String fileLocation = "C:\\Games\\textdata.txt";                                            // Specified file location for reading
	String lineText     = null;                                                                 // Holds a line of text from fileLocation
	boolean outcome;                                                                            // Boolean for whether the reportTitle exceeds 40 characters (false) or not (true)
	
	String receivedData = null;                                                                 // Holds the last piece of data in a line after a series of reading and delimiting
	
	try 
	{                                                                                           // Try in order to avoid crashing
	    BufferedReader inputData = new BufferedReader (new FileReader ( fileLocation ));        // Reads a line from the file
	    outcome = printReportTitle (lineText = inputData.readLine());                           // Reads the line (title), puts it into lineText and sends that line to printReportTitle. Variable outcome takes in a boolean.
	    
	    while ( (lineText = inputData.readLine()) != null) 
	    {                                                                                       // Keeps reading lines until the line being read is empty
		for (int position = 1; position <= 5; position++)
		{
		    System.out.print ( receivedData = getData (position, lineText) + " ");                 // Prints the last piece of data in a line after calling getData
		}
		System.out.println ();
	    }                                                                                       // *End while()

	    System.out.println ();                                                                  // Adds spacing
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
    // <!> Output: boolean                                                      <!>
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
	    
	    for (int x = 0; x < padding; x++) {                                                     // Keeps looping until there are enough spaces to center the alignment of the title
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

    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    // <!> Method Name: getData()                                                       <!>
    // <!> Input: int (maximum index of data per line), String (single line of text)    <!>
    // <!> Output: String (last data of the input line)                                 <!>
    // <!>                                                                              <!>
    // <!> Description: Saves a piece and returns it. If the piece to be saved is in    <!>
    // <!> between other pieces, the method will cut off any pieces before the target   <!>
    // <!> piece until the target is reached.                                           <!>
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    
    static String getData (int posElement, String textLine)
    {
	String returnData = null;                                                                   // Contains the data to be returned
	
	textLine = textLine + ",";                                                                  // Adds a comma at the end of the line to avoid crashes from missing a comma
	
	for (int x = 0; x < posElement; x++) 
	{                                                                                           // Loop that works on piece by piece
	    returnData = textLine.substring (0, textLine.indexOf (',') );                           // Cuts out the piece at the very beginning from the line by separating it from the next comma
	    textLine = textLine.substring (textLine.indexOf (',') + 1);                             // Cuts out the already printed piece from the line
	}                                                                                           // *End for()
	
	return returnData;                                                                          // Returns the last line of text to the caller
    
    }                                                                                               // *End getData()
    
}                                                                                                   // *End ProgramThreeKK
