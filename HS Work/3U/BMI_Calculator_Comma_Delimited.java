/*////////////////////////////////////////////////////////////////////////////////////////////////
// Program Name: BMI_Calculator_Comma_Delimited.java                                            //
// Name: Keigo Katanaga                                                                         //
// Date: 05/12/2020                                                                             //
//                                                                                              //
// Description:                                                                                 //
// Calculates the BMI using inputs from a .txt file.                                            //
// A complete set of inputs is (in the same exact format; no spaces!!) as follows:              //
//                                                                                              //
// Patient's Name,Height (in),Weight (lbs)                                                      //
//                                                                                              //
// Can currently accept up to 500 sets (people) of input, as long as all inputs are complete.   //
// A complete set of inputs will be referred to as a "batch".                                   //
*/////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;                                                                                                                   // Imports java.io functions

public class BMI_Calculator_Comma_Delimited
{

    public static void main (String[] args) throws Exception
    {
	String fileLocation    = "F:\\in.txt";                                                                                      // Contains the file location for the inputs
	String input           = null;                                                                                              // String to hold the inputs
	
	int maxIndex           = 499;                                                                                               // Variable to contain maximum number of indexes
	
	String name      []    = new String [maxIndex];                                                                             // String array for the patient's name
	int height       []    = new int    [maxIndex];                                                                             // integer array variable to hold the patients' height
	double weight    []    = new double [maxIndex];                                                                             // double array variable to hold the patients' weight
	double bmiResult []    = new double [maxIndex];                                                                             // double array variable to hold the patients' BMI
	String status    []    = new String [maxIndex];                                                                             // String array to hold the patients' BMI status
	
	int peopleCount        = 0;                                                                                                 // Counter that determines what batch is currently being worked with, including how many people.
	
	double undrWeightCount = 0;                                                                                                 // Counts the number of underweight people
	double normWeightCount = 0;                                                                                                 // Counts the number of normal weight people
	double overWeightCount = 0;                                                                                                 // Counts the number of overrweight people
	
	double undrPercent     = 0.0;                                                                                               // Contains the total percentage of underweight people (in decimals)
	double normPercent     = 0.0;                                                                                               // Contains the total percentage of normal weight people (in decimals)
	double overPercent     = 0.0;                                                                                               // Contains the total percentage of overweight people (in decimals)
	
	try
	{
	    BufferedReader inputData = new BufferedReader ( new FileReader ( fileLocation ));                                       // Reads the data within "fileLocation"
	    input = inputData.readLine();                                                                                           // "input" is data read in "fileLocation"
	    
	    while( input != null )
	    {
		name [peopleCount]   = readDataBeforeComma (input);                                                                 // Jumps to "readDataBeforeComma" method and its output (name) gets contained in "name [peopleCount]" 
		input                = readDataAfterComma (input);                                                                  // "input" will contain the output from the method "readDataAfterComma"
		
		height [peopleCount] = Integer.parseInt ( readDataBeforeComma (input) );                                            // Jumps to "readDataBeforeComma" method and its output (height) gets contained in "height [peopleCount]"
		input                = readDataAfterComma (input);                                                                  // "input" will contain the output from the method "readDataAfterComma"
		
		weight [peopleCount] = Double.parseDouble (input);                                                                  // "weight [peopleCount]" contains variable "input" after revisions from the methods used before it
		
		bmiResult [peopleCount] = ( weight [peopleCount] / (height [peopleCount] * height [peopleCount]) * 703 );           // Calculates the BMI; result is multiplied by 703 for conversion
		
		if (bmiResult [peopleCount] < 0)
		    {
			bmiResult [peopleCount] = bmiResult [peopleCount] * -1;                                                     // bmiResult multiplied by -1 in case bmiResult is a negative number
		    }
		
		input = inputData.readLine();                                                                                       // Reads the next line
		peopleCount++;                                                                                                      // Adds 1 so that peopleCount = current total number of people in the data
		
	    }                                                                                                                       // End while() loop
	    
	    System.out.println ("------------------------------------------------------------------------------");                  // Top border
	    System.out.println ("Name\t\t|Height\t|Weight\t\t|BMI\t\t\t|Status");                                                   // Prints the label for the table of outputs
	    System.out.println ("------------------------------------------------------------------------------");                  // Bottom border
	    
	    for (int x = 0; x < peopleCount; x++)
	    {
		if (bmiResult [x] > 0 && bmiResult [x] < 18.5)
		{
		    status [x] = "Underweight";                                                                                     // Classifies status [x] of name [x] as Underweight
		    undrWeightCount++;                                                                                              // Adds 1 to the number of underweight people
		    
		}                                                                                                                   // End if statement
		else if (bmiResult [x] >= 18.5 && bmiResult [x] <= 25)
		{
		    status [x] = "Normal Weight";                                                                                   // Classifies status [x] of name [x] as Normal weight
		    normWeightCount++;                                                                                              // Adds 1 to the number of normal weight people
		    
		}                                                                                                                   // End else if statement
		else if (bmiResult [x] > 25)
		{
		    status [x] = "Overweight";                                                                                      // Classifies status [x] of name [x] as Overrweight
		    overWeightCount++;                                                                                              // Adds 1 to the number of overweight people
		    
		}                                                                                                                   // End else if statement
		
		System.out.print   (name [x] + "    \t|" + height [x] + " in\t|" + weight [x] + " lbs\t|");                         // Prints the name, height, and weight
		System.out.println (bmiResult [x] + "   \t|" + status [x]);                                                         // Prints the bmi and status (command is in two lines for spacing in the code)
		
	    }                                                                                                                       // End for() loop
	    
	    undrPercent = (undrWeightCount / peopleCount) * 100;                                                                    // Calculates the rate (%) of underweight people
	    normPercent = (normWeightCount / peopleCount) * 100;                                                                    // Calculates the rate (%) of normal weight people
	    overPercent = (overWeightCount / peopleCount) * 100;                                                                    // Calculates the rate (%) of overweight people

	    System.out.println ("------------------------------------------------------------------------------");                  // Separates the summary from the BMI table
	    System.out.println ("\n*SUMMARY*");                                                                                     // Summary
	    System.out.println ("Underweight:\t" + undrPercent + "%");                                                              // Underweight percentage
	    System.out.println ("Normal Weight:\t" + normPercent + "%");                                                            // Normal weight percentage
	    System.out.println ("Overweight:\t" + overPercent + "%");                                                               // Overweight percentage
	    
	    inputData.close();                                                                                                      // Closes inputData
	    
	}                                                                                                                           // End try
	
	catch ( Exception e )
	{
	    System.out.println ( e );                                                                                               // Prints out the error
	    System.out.println ("There was an error. Check your file and inputs!");                                                 // Prints out an error message
	}                                                                                                                           // End catch
	
    }                                                                                                                               // End main
    
    // **************************************************************************************
    // Method Name: readDataBeforeComma                                                     *
    // Input: A string with comma delimited text (input) -> (dataRead)                      *
    // Output: A substring of the input, BEFORE the first comma                             *
    //                                                                                      *
    // Description: A method that cuts off and outputs the substring before the first (but  *
    // not including) comma within the input                                                *
    // **************************************************************************************
    
    public static String readDataBeforeComma (String dataRead) 
    {
	return dataRead.substring ( 0, dataRead.indexOf(",") );                                                                     // returns a substring starting from index 0 to before the index of the first comma (,)
	
    }                                                                                                                               // End readDataBeforeComma ()
    
    // **************************************************************************************
    // Method Name: readDataAfterComma                                                      *           
    // Input: A string with comma delimited text (input) -> (dataRead)                      *
    // Output: A substring of the input, AFTER the first comma                              *
    //                                                                                      *
    // Description: A method that cuts off and outputs the substring after the first (but   *
    // not including) comma within the input                                                *
    // **************************************************************************************
    
    public static String readDataAfterComma (String dataRead) 
    {
	return dataRead.substring ( dataRead.indexOf(",") + 1 );                                                                    // returns a substring starting from 1 index after the first comma (,)
	
    }                                                                                                                               // End readDataAfterComma ()
    
}                                                                                                                                   // End class BMI_Calculator_Arrays
