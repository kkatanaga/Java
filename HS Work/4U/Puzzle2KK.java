/*////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Program Name: Puzzle2KK.java                                                                                     //
// Name: Keigo Katanaga                                                                                             //
// Date: 05/11/2021                                                                                                 //
//                                                                                                                  //
// Description: A program that counts "blocks" in a line of data. The first line printed will be the title; the     //
// title must be hardcoded in the program.                                                                          //
//                                                                                                                  //
// Definition of a block: a block must start with, end with, and have the length specified within the variables;    //
// the length must be greater than 2, and any characters can be in between the start and the end.                   //
// To make things easier to understand, we must state what makes up a "basis block"; any blocks within a line that  //
// matches the basis block will be counted.                                                                         //
//                                                                                                                  //
// Example basis block: P_X     (the _ can be any character or number)                                              //
// firstChar   = 'P'            (in this example, we're stating the block MUST start with 'P')                      //
// lastChar    = 'X'            (in this example, we're stating the block MUST end with 'X')                        //
// pieceLength = 3              (in this example, we're stating the block MUST be 3 characters long)                //
//                                                                                                                  //
// What counts as a matching block with the example above?                                                          //
// PAX, P9X, PTX, P$X      - matches every variable of the basis block, therefore they are matching blocks          //
// APX, PX, XAP, EEP, PSSX - have one or more variable(s) that don't match the basis block; no matching blocks      //
//                                                                                                                  //
// 05/12/2021: Added comments & cleaned findText()                                                                  //                                               
*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;

public class Puzzle2KK
{
    public static void main (String[] args) throws IOException
    {
	String fileLocation = "C:\\Games\\inputText.txt";                                                                   // Contains the file location to read a file from
	String lineText     = null;                                                                                         // Contains 1 line of text from the file
	
	boolean overForty;                                                                                                  // True if the title is over forty characters, false if the title is less than forty characters long
	
	char firstChar      = 'P';                                                                                          // Contains the first character of the basis block
	char lastChar       = 'X';                                                                                          // Contains the last character of the basis block
	int pieceLength     = 3;                                                                                            // Contains the number of characters of the basis block
	
	try
	{
	    BufferedReader inputData = new BufferedReader (new FileReader ( fileLocation ) );                               // Reads a line from the file
	    
	    if ( (overForty = printReportTitle ("Puzzle 2") ) == true)
	    {                                                                                                               // Prints the title; if it exceeds 40 characters, prints an error message instead
		System.out.println ("Title exceeds 40 characters!");                                                        // Prints out the error message for unsuccessfully bordering the title
		System.out.println ();                                                                                      // Adds spacing between the error message and the next print
	    }                                                                                                               // *End if()
	    
	    while ( (lineText = inputData.readLine()) != null)
	    {                                                                                                               // Keeps looping until the reader runs out of lines to read
		System.out.println ("Input String: "+ lineText);                                                            // Prints out the current line being worked on
		System.out.println ("Blocks Found: " + findText (firstChar, lastChar, pieceLength, lineText));              // Prints out the number of blocks in the line that match the basis block
		System.out.println ();                                                                                      // Adds a space in between each printed inputs & outputs
	    }                                                                                                               // *End while()
		
	    inputData.close();                                                                                              // Closes inputData
	}                                                                                                                   // *End try
	
	catch (IOException e)
	{
	    System.out.println ("Error Found!");                                                                            // Prints out "Error Found!"
	    System.out.println (e);                                                                                         // Prints out the error message
	}                                                                                                                   // *End catch
	
    }                                                                                                                       // *End main()
    
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
 
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    // <!> Method Name: findText()                                                                                  <!>
    // <!> Input: char strtWith (start of the basis block), char endsWith (end of the basis block), int blockLength <!>
    // <!> (length of the basis block), String inLine (the string we're looking for a block in)                     <!>
    // <!> Output: int blockCount (number of blocks that match the basis block)                                     <!>
    // <!>                                                                                                          <!>
    // <!> Description: Receives the inputs as stated above. If a block in inLine starts with strtWith, ends with   <!>
    // <!> endsWith, and is blockLength long, then the counter is added by one. This keeps looping until inLine no  <!>
    // <!> longer contains even one of the inputs.                                                                  <!>
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>

    static int findText (char strtWith, char endsWith, int blockLength, String inLine)
    {
	int strtWhere    = 0;                                                                                               // Contains the index of strtWith
	int blockCount   = 0;                                                                                               // Number of blocks that match the basis block
	String blockHold = null;                                                                                            // Temporarily holds a block that may or may not match the basis block
	
	inLine = inLine.substring (strtWhere);                                                                              // Cuts off anything before the first strtWhere
	
	if (inLine.length() < (blockLength))
	{                                                                                                                   // Activates when the string length is less (a redundant string) than the length of the basis block
	    return blockCount;                                                                                              // Returns the number of blocks found
	}                                                                                                                   // *End if()
	else
	{                                                                                                                   // Activates when the string length is more than the length of the basis block
	    for (int x = 1; x < blockLength; x++)
	    {                                                                                                               // Only occurs once; loops the addition of spacing after the string in order to avoid out of index errors
		inLine = inLine.concat(" ");                                                                                // Adds a spacing 1 amount less than the length of the basis block
	    }                                                                                                               // *End for()
	    
	    while ( ( strtWhere = inLine.indexOf (strtWith) ) != -1 && inLine.indexOf (endsWith) != -1)
	    {                                                                                                               // Activates only when both strtWith & endsWith characters can be found somewhere in the string
		blockHold = inLine.substring (strtWhere, (strtWhere + blockLength));                                        // Cuts out and saves a block that matches everything but the ending character
		
		if ( blockHold.endsWith ( Character.toString (endsWith) ) == true )
		{                                                                                                           // Activates if the ending character of the block matches the specified ending character
		    blockCount++;                                                                                           // Adds 1 to the counter
		}                                                                                                           // *End if()
		
		inLine = inLine.substring (strtWhere + 1);                                                                  // Cuts off the first strtWih hit and anything else before it
	    }                                                                                                               // *End while()
	    
	}                                                                                                                   // *End else
	
	return blockCount;                                                                                                  // Returns the number of blocks found
    }                                                                                                                       // *End findText()
    
}                                                                                                                           // *End Puzzle2KK class
