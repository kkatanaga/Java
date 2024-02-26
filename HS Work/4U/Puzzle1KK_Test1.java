/*////////////////////////////////////////////////////////////////////////////////////////////////
// Program Name: Puzzle1KK.java                                                                 //
// Name: Keigo Katanaga                                                                         //
// Date: 05/04/2021                                                                             //
//                                                                                              //
// Description: A very specific calculator that reads data from a file. The first line is the   //
// title and the program creates a border design if the title is less than 40 characters long.  //
//                                                                                              //
// The program then reads the rest of the line in a format: the first character must be "A" or  //
// "S" to indicate whether the remaining values in the line must be solved into an "A"verage or //
// a "S"um. Each input will be printed the line before the solution. In order for the program   //
// to work properly, the file must be written as follows:                                       //
//                                                                                              //
// 1st Line: Title Name             (Can be anything)                                           //
// 2nd Line: X,I,E,A,A,U,O,I...     (Where X = A or S, and vowels = any number,                 //
// Nth Line: X,E,A,U,E,I,A,E...      including decimals)                                        //
//                                                                                              //
// All characters and values must use commas for separation. This program will keep running     //
// until there is no more data to be read.                                                      //
*/////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;

public class Puzzle1KK
{

    public static void main (String[] args) throws IOException
    {
	String fileLocation = "C:\\Games\\math.txt";                                                        // Specified file location for reading
	String lineText     = null;                                                                         // Holds a line of text from fileLocation
	
	boolean overForty;                                                                                  // Boolean for whether the reportTitle exceeds 40 characters (true) or not (false)
	
	double result       = 0;                                                                            // Contains the resulting average or sum of the input line
	
	try
	{
	    BufferedReader inputData = new BufferedReader (new FileReader ( fileLocation ));                // Reads a line from the file
	    
	    overForty = printReportTitle (lineText = inputData.readLine());                                 // Reads the line (title), puts it into lineText and sends that line to printReportTitle. Variable outcome takes in a boolean.
	    
	    if (overForty == true)
	    {                                                                                               // Activates when the first line of data exceeds 40 characters; else doesn't print any errors
		System.out.println ("The title exceeds 40 characters!");                                    // Signifies that the title is too long for the program to continue
		System.out.println ();                                                                      // Adds a space in between the error message and the rest of the data
	    }                                                                                               // *End if()
	    
	    while ( (lineText = inputData.readLine()) != null) 
	    {                                                                                               // Loop to keep reading lines until the input is empty
		System.out.println ("Input   : " + lineText);                                               // Prints out the line being read
		System.out.println ("Solution: " + ( result = getData (lineText) ));                        // Prints out the solution after calling getData()
		System.out.println ();                                                                      // Adds a space in between each Input & Outputs
	    }                                                                                               // *End while()

	    inputData.close();                                                                              // Closes the file
	}                                                                                                   // *End try
	
	catch (IOException e) 
	{                                                                                                   // Catches the error
	    System.out.println ("Error found! Check your input!" + e);                                      // Prints out an error message + java's error message
	}                                                                                                   // *End catch
	
    }                                                                                                       // *End main


    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    // <!> Method Name: printReportTitle()                                                  <!>
    // <!> Input: String (the specified report title)                                       <!>
    // <!> Output: boolean                                                                  <!>
    // <!>                                                                                  <!>
    // <!> Description: Receives a report title string and centers it within 40 characters  <!>
    // <!> before printing. Returns true if the input is less than 40; returns false if the <!>
    // <!> input is more than 40.                                                           <!>
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>

    static boolean printReportTitle (String inputTitle)
    {
	int padding = 0;                                                                                    // Contains how much the title needs to be spaced
													    // Tries in case the input title has problems
	if (inputTitle.length() <= 40)
	{                                                                                                   // If statement to limit title length to be less than or equal to 40 characters
	    padding = (40 - inputTitle.length() ) / 2;                                                      // Calculates how much padding is required for proper alignment
	    
	    for (int x = 0; x < padding; x++) 
	    {                                                                                               // Keeps looping until there are enough spaces to center the alignment of the title
		inputTitle = " " + inputTitle;                                                              // Adds x amount of spaces before inputTitle, where x is determined by the previously calculated padding
	    }                                                                                               // *End for()
	    
	    System.out.println ("----------------------------------------");                                // Prints out 40 dashes for the top border
	    System.out.println (inputTitle);                                                                // Prints out the input received
	    System.out.println ("----------------------------------------");                                // Prints out 40 dashes for the bottom border

	    return false;                                                                                   // Returns a boolean to signify overForty is false
	}                                                                                                   // *End if()
	
	else 
	{                                                                                                   // Else statement if title length exceeds 40 characters
	    return true;                                                                                    // Returns a boolean to signify overForty is true
	}                                                                                                   // *End else
	
    }                                                                                                       // *End printReportTitle()

    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    // <!> Method Name: getData()                                                           <!>
    // <!> Input: String (single line of text)                                              <!>
    // <!> Output: double (total sum or average)                                            <!>
    // <!>                                                                                  <!>
    // <!> Description: Delimits the input string (textLine) until the last piece is reached<!>
    // <!> which will then be returned.                                                     <!>
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    
    static double getData (String textLine)
    {
	String formulaType = null;                                                                          // Contains either "A" for average and "S" for sum
	
	double valOne      = 0;                                                                             // Contains one value to be added with valTwo (always contains the sum before each loop)
	double valTwo      = 0;                                                                             // Contains another value to be added with valOne (always contains a new value per loop)
	
	double result      = 0;                                                                             // Contains the average or the sum
	
	int dataCount      = 0;                                                                             // Contains the number of data found in a line
	
	try
	{                                                                                                   // Tries the program in case of a wrong input
	    formulaType = textLine.substring (0, textLine.indexOf (',') );                                  // Scans the very first character (either "A" or "S")
	    textLine    = textLine.substring (textLine.indexOf (',') + 1);                                  // Removes "A" or "S" and saves the line after the comma
	    dataCount   = getDataCount (textLine);                                                          // Counts how many values are in a line.
	    
	    for (int currentPos = 1; currentPos < dataCount; currentPos++)
	    {                                                                                               // Keeps adding valOne & valTwo before reaching the very last piece
		valTwo   = Double.parseDouble (textLine.substring (0, textLine.indexOf (',') ) );           // Converts a scanned value into a double
		textLine = textLine.substring (textLine.indexOf (',') + 1);                                 // Cuts out the already printed piece from the line
		valOne   = valOne + valTwo;                                                                 // Keeps adding valOne (initially 0) to valTwo before the program reaches the last value of the line
	    }                                                                                               // *End for()
	
	    valTwo = Double.parseDouble(textLine);                                                          // Converts the last scanned value of the line into a double
	    result = valOne + valTwo;                                                                       // Adds the last value of the line to complete the sum; this is the total sum in a line
	
	    if (formulaType.startsWith ("A") == true)
	    {                                                                                               // Activates when the line starts with "A"; else do nothing to result
		result = result / dataCount;                                                                // Divides the total sum of the line by the number of values (formula for average)
	    }                                                                                               // *End if()
	
	    return result;                                                                                  // Returns the last line of text to the caller
	}                                                                                                   // *End try
	
	catch (Exception g)
	{                                                                                                   // Catches the error
	   System.out.println ("Error found! Check your input!");                                           // Prints out an error message
	   System.out.println (g);                                                                          // Prints out java's error message
	   return (result = -1);                                                                            // Returns the result as "-1" to signify an error
	}                                                                                                   // *End catch

    }                                                                                                       // *End getData()

    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    // <!> Method Name: getDataCount()                                                      <!>
    // <!> Input: String (numbers separated by commas)                                      <!>
    // <!> Output: int (the number count of numbers found in the input)                     <!>
    // <!>                                                                                  <!>
    // <!> Description: Counts how many pieces of information in a line are found separated <!>
    // <!> by commas (excluding "A" or "S").                                                <!>
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
       
    static int getDataCount (String toCount)
    {
	int total = 0;                                                                                      // Contains the number of items in a line, separated by commas
	
	try
	{                                                                                                   // Tries the program until a comma isn't found
	    while (toCount.indexOf (',') != 0) 
	    {                                                                                               // Loops when the line doesn't start with a comma
		total++;                                                                                    // Adds 1 before a value is removed; counts how many characters and values are in a line
		toCount = toCount.substring (toCount.indexOf (','));                                        // Deletes the data before the comma; purposefully fails when a comma can't be found
		toCount = toCount.substring (toCount.indexOf (',') + 1);                                    // Deletes the comma and saves any information after it
	    }                                                                                               // *End while()
	    
	    return total;                                                                                   // Returns the total number of items (includes "A" or "S" and values)
	}                                                                                                   // *End try
	
	catch (Exception h)
	{                                                                                                   // Catches the puposefully failed read
	    return total;                                                                                   // Returns the total number of items (includes "A" or "S" and values)
	}                                                                                                   // *End catch
    
    }                                                                                                       // *End getDataCount()
    
}                                                                                                           // *End Puzzle1KK
