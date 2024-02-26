/*////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Program Name: AnimalCombinations.java                                                                                    //
// Name: Keigo Katanaga                                                                                                     //
// Date: 05/20/2021                                                                                                         //
//                                                                                                                          //
// Description: Calculates the number of possible unique combinations in catching 3 animals, under a limit. Each animal has //
// an assigned point- a bear could be worth 3 points and the program will see how many bears can be hunted until the        //
// resulting points are less than or equal to the limit. Do this with moose and wolves: individually and combined.          //
//                                                                                                                          //
// 4 lines of integers are required for the input:                                                                          //
//      1st Line: # of points assigned to bears                                                                             //
//      2nd Line: # of points assigned to moose                                                                             //
//      3rd Line: # of points assigned to wolves                                                                            //
//      4th Line: total # of points (limit)                                                                                 //
*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;

public class AnimalCombinations
{
    public static void main (String[] args) throws IOException
    {
	String fileLocation = "C:\\Games\\points.txt";                                                                      // Contains the file location to read a file from
	String lineText     = null;                                                                                         // Contains 1 line of text from the file
	
	boolean overForty;                                                                                                  // True if the title is over forty characters, false if the title is less than forty characters long
	
	int bearsPoints = 0;                                                                                                // Contains the number of points assigned to one Brown Bear
	int moosePoints = 0;                                                                                                // Contains the number of points assigned to one Northern Moose
	int wolfsPoints = 0;                                                                                                // Contains the number of points assigned to one Gray Wolf 
	int totalPoints = 0;                                                                                                // Contains the total number of points to be the upper limit
	
	int resultPoint = 0;                                                                                                // Contains the result of calculations less than or equal to the totalPoints
	
	int combCount = 0;                                                                                                  // Contains the total number of possible unique combinations of the three animals
	
	try
	{
	    BufferedReader inputData = new BufferedReader (new FileReader ( fileLocation ) );                               // Reads a line from the file
	    
	    overForty = printReportTitle ("Lab Test Solution");                                                             // Prints out the title "Lab Test Solution" with borders
	    
	    bearsPoints = Integer.parseInt (inputData.readLine());                                                          // Inputs the first line as an integer to assign the point worth of bears
	    moosePoints = Integer.parseInt (inputData.readLine());                                                          // Inputs the second line as an integer to assign the point worth of moose
	    wolfsPoints = Integer.parseInt (inputData.readLine());                                                          // Inputs the third line as an integer to assign the point worth of wolves
	    totalPoints = Integer.parseInt (inputData.readLine());                                                          // Inputs the last line as an integer
	    
	    for (int w = 0; w <= (totalPoints / wolfsPoints); w++)
	    {                                                                                                               // for loop until (the number of w) * wolfsPoints is less than or equal to totalPoints
		for (int m = 0; m <= (totalPoints / moosePoints); m++)
		{                                                                                                           // for loop until (the number of m) * moosePoints is less than or equal to totalPoints
		    for (int b = 0; b <= (totalPoints / bearsPoints); b++)
		    {                                                                                                       // for loop until (the number of b) * bearsPoints is less than or equal to totalPoints
			resultPoint = (b * bearsPoints) + (m * moosePoints) + (w * wolfsPoints);                            // Calculates the sum of (bear points) + (moose points) + (wolves points)
			
			if (resultPoint <= totalPoints && resultPoint != 0)
			{                                                                                                   // Activates when the calculation results less than or equal to the limit && when it doesn't equal 0
			    System.out.print   (b + " Brown Bear, ");                                                       // Prints out how many bears are possible in the combination
			    System.out.print   (m + " Northern Moose, ");                                                   // Prints out how many moose are possible in the combination
			    System.out.println (w + " Gray Wolf");                                                          // Prints out how many wolves are possible in the combination
			    combCount++;                                                                                    // Add 1 to the number of combinations possible
			}                                                                                                   // *End if()
			
		    }                                                                                                       // *End for() of bears
		    
		}                                                                                                           // *End for() of moose
		
	    }                                                                                                               // *End for() of wolves
	    
	    System.out.println ();                                                                                          // Adds a line space to separate the combinations and the number report
	    System.out.println ("Number of ways to catch animals: " + combCount);                                           // Prints out the number of unique combinations possible within the totalPoints
	    
	    inputData.close();                                                                                              // Closes inputData
	    
	}                                                                                                                   // *End try
	
	catch (IOException e)
	{                                                                                                                   // Catches the error to avoid ugly messages
	    System.out.println ("Error Found!");                                                                            // Prints out "Error Found!"
	    System.out.println (e);                                                                                         // Prints out the error message
	}                                                                                                                   // *End catch
	
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
 
}                                                                                                                           // *End AnimalCombinations class
