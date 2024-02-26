/*////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Program Name: LuckyMoneyKK.java                                                                                      //
// Name: Keigo Katanaga                                                                                                 //
// Date: 05/26/2021                                                                                                     //
//                                                                                                                      //
// Description: Looks for a specific sequence called a lucky code from an input file. When all specifications are met,  //
// the program will print out "LUCKY", else "NOT LUCKY". The conditions for an input to contain lucky codes are as      //
// follows:                                                                                                             //
//                                                                                                                      //
//      1.) A lucky code must be 3 UNIQUE characters long, so any input less than 3 characters are not lucky; this also //
//          means the first 3 characters will be the reference for a lucky code.                                        //
//      2.) The line can be any of any length- but the lucky code itself could repeat over the sequence; therefore the  //
//          length of the line/sequence must be divisible by 3 to be lucky.                                             //
//      3.) The first input line MUST be an integer; it will specify how many lines the program will search after it.   //
//                                                                                                                      //
// Example Input:                                                                                                       //
// 4                    - Will scan 4 lines after itself                                                                //
// ASDASDASDASD         - Scans 4 instances of "ASD" out of 4 potential codes (12/3); therefore lucky                   //
// FAEFADFAEF           - Reference code doesn't match the rest, and indivisible by 3 (10/3); therefore not lucky       //
// FFAFFAFFAFFAFFA      - Reference code has 2 repeating characters; therefore not lucky                                //
// XAE                  - 3 unique characters; therefore lucky                                                          //
// UDHUDHUDH            - Meets all of the conditions, but sits in the 5th line; therefore not scanned                  //
*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;

public class LuckyMoneyKK
{
    public static void main (String[] args)
    {
	String fileLocIn = "C:\\Games\\yen.txt";                                                                                // fileLocationIn; the file to read from
	
	int loopCount    = 0;                                                                                                   // Contains the number of loops to be done (first integer input from the file)
	int lineNum      = 1;                                                                                                   // Contains what line/sequence is being worked on (excluding the first line)
	String seqLine   = null;                                                                                                // Contains the sequence being worked on
	
	String result    = null;                                                                                                // Contains the resulting luck from the sequence
	
	try
	{
	    BufferedReader inData  = new BufferedReader (new FileReader (fileLocIn) );                                          // Opens the file containing an unsorted set
	    
	    loopCount = Integer.parseInt (inData.readLine());                                                                   // Inputs the first line, the number of loops, into loopCount
	    
	    while ( lineNum <= loopCount && (seqLine = inData.readLine()) != null )
	    {                                                                                                                   // Loops until the number of lines reaches the number of loops or the data is empty
		result  = codeMatch (seqLine);                                                                                  // Sends the sequence and receives the luck state of the sequence
		
		System.out.println (seqLine);                                                                                   // Prints out the sequence analyzed
		System.out.println ("The sequence above is " + result + "!");                                                   // Prints the result of the analysis
		System.out.println ();                                                                                          // Adds a space after the first sequence report
		
		lineNum++;                                                                                                      // Specifies the movement to the next line
	    }                                                                                                                   // *End for()
	    
	    inData.close();                                                                                                     // Closes the input file
	    
	}                                                                                                                       // *End try
	
	catch (IOException e) 
	{                                                                                                                       // Catches the error
	    System.out.println ("Error found! Check your input!" + e);                                                          // Prints out an error message + java's error message
	}                                                                                                                       // *End catch
	 
    }                                                                                                                           // *End main

    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
    // <!> Method Name: codeMatch()                                                                                 <!>
    // <!> Input: String seq (sequence; a line that may or may not contain the unique, repeating code)              <!>
    // <!> Output: String "LUCKY" or "NOT LUCKY"                                                                    <!>
    // <!>                                                                                                          <!>
    // <!> Description: Receives a sequence of codes that must follow a specification (see description at the top). <!>
    // <!> If the specifications are followed, the method returns "LUCKY", else "NOT LUCKY"                         <!>
    // <!>//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//==//<!>
   
    static String codeMatch (String seq)
    {
	String luck        = "NOT LUCKY";                                                                                       // Holds the luck statement
	
	String luckyCode   = null;                                                                                              // Holds the reference 3-character code
	String codeCompare = null;                                                                                              // Holds the code to be compared to the lucky code
	
	int totalCode      = 0;                                                                                                 // Contains the potential number of repeating codes
	int matchCount     = 0;                                                                                                 // Contains the number of matches
	
	if ( (seq.length() % 3) == 0 && seq.length() >= 3)
	{                                                                                                                       // Activates only when the length of the sequence is divisible by 3 and is greater than or equal to 3
	    if ( seq.charAt(0) != seq.charAt(1) && seq.charAt(1) != seq.charAt(2) && seq.charAt(2) != seq.charAt(0) )
	    {                                                                                                                   // Activates when all first three characters of the code are unique
		totalCode = (seq.length() / 3) - 1;                                                                             // Holds the number of potential lucky codes in a sequence; subtract 1 to exclude the reference code
		luckyCode = seq.substring (0, 3);                                                                               // Saves the first 3 unique characters as the reference code
		
		for (int codePosn = 1; codePosn <= totalCode; codePosn++)
		{                                                                                                               // Loops codeCount times (codeCount = 2 when there are 3 potential codes in the sequence)
		    seq = seq.substring (3);                                                                                    // Removes the first 3 characters from the sequence
		    codeCompare = seq.substring (0, 3);                                                                         // Holds the first 3 characters from the newly cut sequence (a different code)
		    
		    if (codeCompare.equals(luckyCode) == true)
		    {                                                                                                           // Activates when the different code matches the lucky code
			matchCount++;                                                                                           // Adds 1 to the number of matches
		    }                                                                                                           // *End if()
		
		}                                                                                                               // *End for()
		
		if (matchCount == totalCode)
		{                                                                                                               // Activates when the number of potential lucky codes equals the number of matches
		    return luck = "LUCKY";                                                                                      // When all specifications are met, luck is set as LUCKY
		}                                                                                                               // *End if()
		
	    }                                                                                                                   // *End if()
	    
	}                                                                                                                       // *End if()
	
	return luck;                                                                                                            // Returns the luck state
    }
}                                                                                                                               // *End LuckyMoneyKK
