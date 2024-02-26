/*////////////////////////////////////////////////////////////////////////////////////////////////
// Program Name: BMI_Calculator_Arrays.java                                                     //
// Name: Keigo Katanaga                                                                         //
// Date: 05/01/2020                                                                             //
//                                                                                              //
// Description:                                                                                 //
// Calculates the BMI using inputs from a .txt file.                                            //
// A complete set of inputs is (in the same exact format) as follows:                           //
//                                                                                              //
// Patient's Name                                                                               //   
// Height (in)                                                                                  //
// Weight (lbs)                                                                                 //
//                                                                                              //
// Can currently accept up to 500 sets (people) of input, as long as all inputs are complete.   //
// A complete set of inputs will be referred to as a "batch".                                   //
*/////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;                                                                                                                   // Imports java.io functions

public class BMI_Calculator_Arrays
{

    public static void main (String[] args) throws Exception
    {
	String fileLocation = "h:\\in.txt";                                                                                         // Contains the file location for the inputs
	String input        = null;                                                                                                 // String to hold the inputs
	
	int maxIndex        = 499;                                                                                                  // Variable to contain maximum number of indexes
	
	String name      [] = new String [maxIndex];                                                                                // String array for the patient's name
	int height       [] = new int    [maxIndex];                                                                                // integer array variable to hold the patients' height
	double weight    [] = new double [maxIndex];                                                                                // double array variable to hold the patients' weight
	double bmiResult [] = new double [maxIndex];                                                                                // double array variable to hold the patients' BMI
	String status    [] = new String [maxIndex];                                                                                // String array to hold the patients' BMI status
	
	int peopleCount     = 0;                                                                                                    // Counter that determines what batch is currently being worked with, including how many people.
	
	double undrWeightCount = 0;                                                                                                 // Counts the number of underweight people
	double normWeightCount = 0;                                                                                                 // Counts the number of normal weight people
	double overWeightCount = 0;                                                                                                 // Counts the number of overrweight people
	
	double undrPercent  = 0.0;                                                                                                  // Contains the total percentage of underweight people (in decimals)
	double normPercent  = 0.0;                                                                                                  // Contains the total percentage of normal weight people (in decimals)
	double overPercent  = 0.0;                                                                                                  // Contains the total percentage of overweight people (in decimals)
	
	try
	{
	    BufferedReader inputData = new BufferedReader ( new FileReader ( fileLocation ));                                       // Reads the data within "fileLocation"
	    input = inputData.readLine();                                                                                           // "input" is data read in "fileLocation"
	    
	    while( input != null )
	    {
		name [peopleCount]   = input;                                                                                       // "name [peopleCount]" now contains the first input/data of batch [peopleCount]
		height [peopleCount] = Integer.parseInt ( inputData.readLine() );                                                   // "height [peopleCount]" now contains the input/data after "name [peopleCount]", converted to meters
		weight [peopleCount] = Double.parseDouble ( inputData.readLine() );                                                 // "weight [peopleCount]" now contains the input/data after "height [peopleCount]"
		
		bmiResult [peopleCount] = ( weight [peopleCount] / (height [peopleCount] * height [peopleCount]) * 703 );           // Calculates the BMI; Result is multiplied by 703 for conversion
		
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
		System.out.println (bmiResult [x] + "\t|" + status [x]);                                                            // Prints the bmi and status (command is in two lines for spacing in the code)
		
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
    
}                                                                                                                                   // End class BMI_Calculator_Arrays
