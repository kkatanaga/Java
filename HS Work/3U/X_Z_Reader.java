/*////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Program Name: X_Z_Reader.java                                                                            //
// Name: Keigo Katanaga                                                                                     //
// Date: 05/16/2020                                                                                         //
//                                                                                                          //
// Description:                                                                                             //
// Scans the file/input/line for a substring that contains 3 characters and starts with an "X" and          //
// ends with a "Z". These 3 characters will be mentioned as "X_Z". After scanning, the program              //
// outputs the number of valid "X_Z" substrings.                                                            //
//                                                                                                          //
// This program only detects "X_Z"'s according to these rules:                                              //
//                                                                                                          //
// It must be a substring in "X_Z" format, i.e XYZ.                                                         //
// Non-capitalized "x" and "z"'s will not be recognized, but the one in between can be anything.            //
// If a substring starts with an "X" but does not end with a "Z" i.e ZY, it will not be recognized.         //
// If "X_Z" exists in a string of more than a total of 3 characters but follows the previous rules          //
// i.e XYZXAZ, then it will be recognized; if however, it exists in a total of more than 3                  //
// characers but the "X_Z" itself is more than 3 characters i.e XAAZXYZ, then it will not be recognized.    //
//                                                                                                          //
// Currently only accepts 50 lines of correct inputs.                                                       //
//                                                                                                          //
// 05/21/2020                                                                                               //
// Redo of the methods and fixed a few problems. Finished the remaining comments.                           //
*/////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;                                                                                                       // Imports java.io functions

public class X_Z_Reader
{

    public static void main (String[] args) throws Exception
    {
	String fileLocation = "C:\\Games\\in.txt";                                                                      // Contains the file location for the inputs
	String input        = null;                                                                                     // String to hold an input
	
	int maxIndex        = 49;                                                                                       // Variable to contain maximum number of indexes
	
	String lineData []  = new String [maxIndex];                                                                    // String array to hold data from each line read
	int numberOfXZ  []  = new int    [maxIndex];                                                                    // Integer array to hold the number of X_Z in each line read
	
	int lineNumber      = 0;                                                                                        // Integer variable to contain the line number of data being read starting from 0
	
	try
	{
	    BufferedReader inputData = new BufferedReader ( new FileReader ( fileLocation ));                           // Reads the data within "fileLocation"
	    input = inputData.readLine();                                                                               // "input" now contains the line read in "fileLocation"
	    
	    while( input != null )
	    {
		lineData [lineNumber] = input;                                                                          // Contains the line read before
		numberOfXZ [lineNumber] = hadText(input);                                                               // Calls for the hadText() method and contains its output
		
		lineNumber++;                                                                                           // Indicates that the program is moving to the next line
		input = inputData.readLine();                                                                           // input now contains the next line
		
	    }                                                                                                           // *End while() loop
	    
	    for (int x = 0; x < lineNumber; x++)
	    {
		System.out.println (lineData [x]);                                                                      // Prints out a line from the given file
		System.out.println ("Number of substrings found: " + numberOfXZ [x] + " \n");                           // Prints out the report of the X_Z scan result when the number of substring = 1
		
	    }                                                                                                           // *End for() loop
	    
	    inputData.close();                                                                                          // Closes inputData
	    
	}                                                                                                               // *End try
	
	catch ( Exception e )
	{
	    System.out.println ( e );                                                                                   // Prints out the error
	    System.out.println ("There was an error. Check your file and inputs!");                                     // Prints out an error message
	    
	}                                                                                                               // *End catch
	
    }                                                                                                                   // *End main
    
    // <!>=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\<!>
    // <!> Method Name: hadText ()                                                                  <!>
    // <!> Input: A string/line of text to scan for "X_Z"'s                                         <!>
    // <!> Output: An integer indicating the number of "X_Z"'s in the given input                   <!>
    // <!>                                                                                          <!>
    // <!> Description: A method that counts how many "X_Z" substrings are within the given input.  <!>
    // <!>                                                                                          <!>
    // <!>=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\<!>
    
    public static int hadText (String dataRead) 
    {
	int countOfXZ        = 0;                                                                                       // Contains the number of "X_Z" substrings (output)
	
	int dataLength       = 0;                                                                                       // Contains the number of characters in the whole given input
	
	String subDataRead   = null;                                                                                    // String that temporarily holds a substring that starts with "X" and ends with "Z"
	int subDataLength    = 0;                                                                                       // Integer that temporarily holds the number of characters in the "subString"
	
	boolean hasX_Z       = false;                                                                                   // boolean for whether the "X_Z" fits the criteria
	
	dataLength = dataRead.length();                                                                                 // Measures the length of dataRead
	    
	while (dataLength >= 3)
	{
	    subDataRead = dataRead.substring (0,3);                                                                     // subDataRead (NOT dataRead!) contains the first 3 characters of dataRead
		
	    hasX_Z = checkX_Z (subDataRead);                                                                            // Calls for checkX_Z 
		
	    if (hasX_Z == true)
	    {
		countOfXZ++;                                                                                            // Adds 1 to the number of X_Z
		dataRead = dataRead.substring (1);                                                                      // Removes the first substring from dataRead i.e YTZ -> TZ
		
	    }                                                                                                           // *End if statement
		
	    else
	    {
		dataRead = dataRead.substring (1);                                                                      // Removes the first substring from dataRead i.e YTZ -> TZ
		
	    }                                                                                                           // *End else
		
	    dataLength = dataRead.length();                                                                             // Counts the length of "subString"
		
	}                                                                                                               // *End while() loop
	    
	return countOfXZ;                                                                                               // Returns the number of "X_Z" in dataRead
	    
    }                                                                                                                   // *End hadText()
    
    // <!>=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\<!>
    // <!> Method Name: checkX_Z ()                                                                 <!>
    // <!> Input: A three-character string                                                          <!>
    // <!> Output: Boolean; true or false                                                           <!>
    // <!>                                                                                          <!>
    // <!> Description: A method that outputs true if the input begins with "X" and ends with "Z".  <!>
    // <!> Otherwise, false.                                                                        <!>
    // <!>                                                                                          <!>
    // <!>=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\=\\<!>
    
    public static boolean checkX_Z (String tempDataRead)
    {
	boolean X_Z           = true;                                                                                   // If true, the given string begins with "X" and ends with "Z"
	    
	String checkFirstChar = null;                                                                                   // Contains the first character of a three-character string i.e UZH -> U
	String lastChar       = null;                                                                                   // Contains the string without the first character i.e UZH -> ZH
	String checkLastChar  = null;                                                                                   // Contains the last character of a three-character string i.e UZH -> H
	    
	try
	{
	    checkFirstChar = tempDataRead.substring ( tempDataRead.indexOf ("X"), 1 );                                  // Checks if tempDataRead has an "X" in the beginnning or else it is caught
	    lastChar       = tempDataRead.substring ( tempDataRead.indexOf ("X") + 2 );                                 // Contains the last character of the string
	    checkLastChar  = lastChar.substring ( lastChar.indexOf ("Z") );                                             // Checks if the last character of the string is "Z"
		
	    return X_Z;                                                                                                 // Returns "true"
		
	}                                                                                                               // *End try
	    
	catch (Exception f)
	{
	    return X_Z = false;                                                                                         // Returns "false" when checkFirstChar and/or checkLastChar fail
		
	}                                                                                                               // *End catch
	    
    }                                                                                                                   // *End checkX_Z()
    
}                                                                                                                       // *End class BMI_Calculator_Arrays
