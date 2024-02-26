/*





*/

import java.io.*;

public class Puzzle1KK_Trash
{

    public static void main (String[] args) throws IOException
    {
	String fileLocation = "C:\\Games\\math.txt";
	String lineText     = null;
	boolean lastText;
	
	boolean outcome;
	int pieceNumber        = 0;
	
	try
	{
	    BufferedReader inputData = new BufferedReader (new FileReader ( fileLocation ));        // Reads a line from the file
	    outcome = printReportTitle (lineText = inputData.readLine());                           // Reads the line (title), puts it into lineText and sends that line to printReportTitle. Variable outcome takes in a boolean.
	    
	    while ( (lineText = inputData.readLine()) != null) {                                    // Keeps reading lines until the line being read is empty
		System.out.println ( lastText = getData (lineText) );                  // Prints the last piece of data in a line after calling getData
	    }                                                                                       // *End while()

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
	if (inputTitle.length() <= 40) {                                                            // If statement to limit title length to be less than or equal to 40 characters
	    int padding = (40 - inputTitle.length() ) / 2;                                          // Calculates how much padding is required for proper alignment
	    
	    for (int x = 0; x < padding; x++) {                                                     // Keeps looping until there are enough spaces to center the alignment of the title
		inputTitle = " " + inputTitle;                                                      // Adds x amount of spaces before inputTitle, where x is determined by the previously calculated padding
	    }                                                                                       // *End for()
	    
	    System.out.println ("----------------------------------------");                        // Prints out 40 dashes for the top border
	    System.out.println (inputTitle);                                                        // Prints out the input received
	    System.out.println ("----------------------------------------");                        // Prints out 40 dashes for the bottom border

	    return true;                                                                            // Returns a boolean "true"
	}                                                                                           // *End if()
	
	else {                                                                                      // Else statement if title length exceeds 40 characters
	    return false;                                                                           // Returns a boolean "false"
	}                                                                                           // *End else
	
    }                                                                                               // *End printReportTitle()

    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    // <!> Method Name: getData()                                                       <!>
    // <!> Input: String (single line of text)                                          <!>
    // <!> Output: String (last data of the input line)                                 <!>
    // <!>                                                                              <!>
    // <!> Description: Delimits the input string (textLine) until the last piece is    <!>
    // <!> reached, which will then be returned.                                        <!>
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    
    static boolean getData (String textLine)
    {
	String formulaType  = null;
	boolean firstScan   = true;
	String pieceData    = null;                                                                    // String to temporarily hold a piece
	int initVal         = 0;
	int nextVal         = 0;
	boolean success     = false;
	int numberCount     = 0;
	
	try
	{
	    while (textLine.indexOf (',') != 0) {                                                   // Loop that works on piece by piece
		pieceData = textLine.substring (0, textLine.indexOf (',') );                        // Cuts out the piece at the very beginning from the line by separating it from the next comma
		
		if (firstScan == true) {
		    formulaType = String.valueOf (pieceData);
		    firstScan = false;
		}
		
		else if (initVal == 0)
		{
		    initVal = Integer.parseInt (pieceData);
		    numberCount = 1;
		}
		
		else
		{
		    nextVal = Integer.parseInt (pieceData);
		    initVal = initVal + nextVal;
		    numberCount++;
		    System.out.println (initVal);
		}
	    
		textLine = textLine.substring (textLine.indexOf (',') + 1);                         // Cuts out the already printed piece from the line
	    }                                                                                       // *End for()
	    
	    return success;                                                                        // Returns the last line of text to the caller
	}

	
	catch (Exception f)
	{
	    nextVal = Integer.parseInt (pieceData);
	    initVal = initVal + nextVal;
	    
	    if (formulaType == "A")
	    {
		
		System.out.println (initVal / numberCount);
	    }
	    else if (formulaType == "S")
	    {
		System.out.println (initVal);
	    }
	    success = true;
	    return success;
	}
	
    }                                                                                               // *End getData()
    
}                                                                                                   // *End Puzzle1KK
