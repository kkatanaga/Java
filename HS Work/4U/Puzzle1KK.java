/*////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Program Name: Puzzle1KK.java                                                                                     //
// Name: Keigo Katanaga                                                                                             //
// Date: 05/04/2021                                                                                                 //
//                                                                                                                  //
// Description: A very specific calculator that reads data from a file. The first line is the title and the program //
// creates a border design if the title is less than 40 characters long.                                            //
//                                                                                                                  //
// The program then reads the rest of the line in a format: the first character must be "A" or "S" to indicate      //
// whether the remaining values in the line must be solved into an "A"verage or a "S"um. Each input will be printed //
// the line before the solution. In order for the program to work properly, the file must be written as follows:    //
//                                                                                                                  //
// 1st Line: Title Name                 (Can be anything)                                                           //
// 2nd Line: A,22,74,21,1,66,9,53...    (Values can be decimals and/or negative)                                    //
// Nth Line: S,19,58,88,62,48...                                                                                    //
//                                                                                                                  //
// All characters and values must use the specified separator to separate characters and values from each other.    //
// This program will keep running until there is no more data to be read; there is no limit to how many values are  //
// to be calculated with.                                                                                           //
//                                                                                                                  //
// 05/05/2021: Added useFormula() method for a neater calculation                                                   //   
// 05/06/2021: Changed getData() to use the intended method and fixed anything that came with the change            //                                                
*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;

public class Puzzle1KK
{

    public static void main (String[] args) throws IOException
    {
	String fileLocation = "C:\\Games\\math.txt";                                                                        // Specified file location for reading
	String lineText     = null;                                                                                         // Holds a line of text from fileLocation
	char delimitedBy    = ',';                                                                                          // Specifies what pieces are delimited by
	
	boolean underForty;                                                                                                 // Boolean for whether the report title is under 40 characters (true) or not (false)
	
	int pieceCount      = 1;                                                                                            // Contains the number of items in a line. Starts at 1 since the input file must have at least 1 piece
	String formulaType  = null;                                                                                         // Contains either "A" for average and "S" for sum
	
	double result       = 0;                                                                                            // Contains the sum of each newly scanned value and finally the resulting average or sum
	double valCon       = 0;                                                                                            // Value container that always contains the newly scanned value of a line
	
	boolean finishSum   = false;                                                                                        // Boolean for whether textLine is at the last value (true) or not (false)
	
	
	try
	{
	    BufferedReader inputData = new BufferedReader (new FileReader ( fileLocation ));                                // Reads a line from the file
	    
	    if ( (underForty = printReportTitle ( lineText = inputData.readLine() )) == false )
	    {                                                                                                               // Sends the title line for bordering and spacing. Activates when the first line of data exceeds 40 characters;
		System.out.println ("The title exceeds 40 characters!");                                                    // Indicates that the title is too long for the program to continue
		System.out.println ();                                                                                      // Adds a space in between the error message and the rest of the data
	    }                                                                                                               // *End if()
	    
	    while ( (lineText = inputData.readLine()) != null) 
	    {                                                                                                               // Loop to keep reading lines until the input is empty
		finishSum   = false;                                                                                        // Signifies that the program hasn't added anything yet
		pieceCount  = countItems (delimitedBy, lineText);                                                           // Finds how many pieces are in a line
		
		if (pieceCount > 1)
		{                                                                                                           // Activates when there are more than 1 piece in the line
		    for (int currentPos = 1; currentPos <= pieceCount; currentPos++)
		    {                                                                                                       // Keeps looping until the last piece of the line is reached
			if (currentPos == 1)
			{                                                                                                   // Activates at the very first run
			    formulaType = getData (currentPos, lineText);                                                   // Scans the very first piece to determine what formula to use
			}                                                                                                   // *End if()
			else if (currentPos == 2)
			{                                                                                                   // Activates at the second run
			    result = Double.parseDouble (getData (currentPos, lineText));                                   // Scans the second piece to be used as the first value for addition
			}                                                                                                   // *End else if()
			else
			{                                                                                                   // Activates after the first and second runs
			    valCon = Double.parseDouble (getData (currentPos, lineText));                                   // Saves a value other than the values already saved before
			    result = useFormula (formulaType, result, valCon, finishSum);                                   // Sends everything needed for useFormula() to ONLY add values
			}                                                                                                   // *End else
		    
		    }                                                                                                       // *End for()
		    
		    finishSum = true;                                                                                       // Signifies that the program has finished adding every value in the line
		    result    = useFormula (formulaType, result, pieceCount - 1, finishSum);                                // Sends everything needed for useFormula() to ONLY calculate the average. Subtract 1 to exclude "A" or "S"
		}                                                                                                           // *End if()
		else
		{                                                                                                           // Activates when the input values are insufficient
		    result = -1;                                                                                            // Changes the result to -1 (null)
		}                                                                                                           // *End else
		
		System.out.println ("Input   : " + lineText);                                                               // Prints out the line being read
		System.out.println ("Solution: " + result);                                                                 // Prints out the solution after calling getData()
		System.out.println ();                                                                                      // Adds a space in between each Input & Outputs
	    }                                                                                                               // *End while()

	    inputData.close();                                                                                              // Closes the file
	}                                                                                                                   // *End try
	
	
	catch (IOException e) 
	{                                                                                                                   // Catches the error
	    System.out.println ("Error found! Check your input!" + e);                                                      // Prints out an error message + java's error message
	}                                                                                                                   // *End catch
	
    }                                                                                                                       // *End main

    
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    // <!> Method Name: printReportTitle()                                                                          <!>
    // <!> Input: String (the specified report title)                                                               <!>
    // <!> Output: boolean                                                                                          <!>
    // <!>                                                                                                          <!>
    // <!> Description: Receives a report title string and centers it within 40 characters                          <!>
    // <!> before printing. Returns true if the input is less than 40; returns false if the                         <!>
    // <!> input is more than 40.                                                                                   <!>
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>

    static boolean printReportTitle (String inputTitle)
    {
	if (inputTitle.length() <= 40)
	{                                                                                                                   // If statement to limit title length to be less than or equal to 40 characters
	    int padding = (40 - inputTitle.length() ) / 2;                                                                  // Calculates how much padding is required for proper alignment
	    
	    for (int x = 0; x < padding; x++) 
	    {                                                                                                               // Keeps looping until there are enough spaces to center the alignment of the title
		inputTitle = " " + inputTitle;                                                                              // Adds Y amount of spaces before inputTitle, where Y is determined by the previously calculated padding
	    }                                                                                                               // *End for()
	    
	    System.out.println ("----------------------------------------");                                                // Prints out 40 dashes for the top border
	    System.out.println (inputTitle);                                                                                // Prints out the input received
	    System.out.println ("----------------------------------------");                                                // Prints out 40 dashes for the bottom border

	    return true;                                                                                                    // Returns a boolean to signify the process is successful
	}                                                                                                                   // *End if()
	
	else 
	{                                                                                                                   // Else statement if title length exceeds 40 characters
	    return false;                                                                                                   // Returns a boolean to signify the process is unsuccessful
	}                                                                                                                   // *End else
	
    }                                                                                                                       // *End printReportTitle()

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
	String returnData = null;                                                                                           // Contains the data to be returned
	
	textLine = textLine + ",";                                                                                          // Adds a comma at the end of the line to avoid crashes from missing a comma
	
	for (int x = 0; x < posElement; x++) 
	{                                                                                                                   // Loop that works on piece by piece
	    returnData = textLine.substring (0, textLine.indexOf (',') );                                                   // Cuts out the piece at the very beginning from the line by separating it from the next comma
	    textLine = textLine.substring (textLine.indexOf (',') + 1);                                                     // Cuts out the already printed piece from the line
	}                                                                                                                   // *End for()
	
	return returnData;                                                                                                  // Returns the last line of text to the caller
    
    }                                                                                                                       // *End getData()

    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    // <!> Method Name: countItems()                                                                                <!>
    // <!> Input: char (the character separating pieces), String (line scanned by the caller)                       <!>
    // <!> Output: int (the number of items in the line)                                                            <!>
    // <!>                                                                                                          <!>
    // <!> Description: Counts how many pieces of information in a line are found separated by the specified given  <!>
    // <!> character. The method counts any character or value in a line other than the separator.                  <!>                                            
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
       
    static int countItems (char c, String toCount)
    {
	int count = 0;                                                                                                      // Contains the number of items in a line, separated by commas
	
	if (toCount.length() == 0)
	{                                                                                                                   // Activates when the length of the input line is 0
	    count = -1;                                                                                                     // Signifies that the input is null
	}                                                                                                                   // *End if()
	else
	{                                                                                                                   // Activates when there is at least one piece in the line
	    toCount = toCount + c;                                                                                          // Adds the delimiting character at the end to avoid crashing the method due to missing characters
	    
	    while (toCount.indexOf (c) > 0) 
	    {                                                                                                               // Loops when the index stated by indexOf() isn't 0
		toCount = toCount.substring (toCount.indexOf (c) + 1);                                                      // Skips over a separator and saves anything after it; index = 0 (-1 + 1) when there is no longer a separator
		count++;                                                                                                    // Adds 1 when a piece is removed; counts how many characters and values are in a line
	    }                                                                                                               // *End while()
	    
	}                                                                                                                   // *End else
	    
	return count;                                                                                                       // Returns the total number of items (includes "A" or "S" and values)
    }                                                                                                                       // *End countItems()

    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    // <!> Method Name: useFormula()                                                                                <!>
    // <!> Input: String (formula "A" or "S"), double (sum of every scanned value), double (newly scanned value or  <!>
    // <!>        number of values summed), boolean (true if everything is added already)                           <!>
    // <!> Output: double (Average or Sum)                                                                          <!>
    // <!>                                                                                                          <!>
    // <!> Description: Adds any two values it receives unless stated otherwise. If "A" is specified, the method    <!>
    // <!> will calculate the average. if "S" is specified, nothing will happen as the method is already finished   <!>
    // <!> adding everything.                                                                                       <!>
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
       
    static double useFormula (String formula, double valueOne, double valueTwo, boolean stopAdding)
    {
	if (stopAdding == false)
	{                                                                                                                   // Activates when the caller states that not everything has been added yet
	    valueOne = valueOne + valueTwo;                                                                                 // Adds two values; valueOne is added to while valueTwo is always the new value scanned
	}                                                                                                                   // *End if()
	else if (stopAdding == true)
	{                                                                                                                   // Activates when the caller states that everything has been added
	    if (formula.startsWith ("A") == true)
	    {                                                                                                               // Activates when the line asks for the average ("A"); else does nothing as valueOne is already the total sum
		valueOne = valueOne / valueTwo;                                                                             // Calculates the average; valueOne is initially the total sum while valueTwo is the number of values summed
	    }                                                                                                               // *End if()
	
	}                                                                                                                   // *End else if()
	
	return valueOne;                                                                                                    // Returns the total sum or the average
    }                                                                                                                       // *End useFormula()

}                                                                                                                           // *End Puzzle1KK
