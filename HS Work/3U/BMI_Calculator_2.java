/*////////////////////////////////////////////////////////////////////////////////////
// Program Name: BMI_Calculator_2.java                                              //
// Name: Keigo Katanaga                                                             //
// Date: 04/15/2020                                                                 //
//                                                                                  //
// Description:                                                                     //
// Calculates the BMI using inputs from a .txt file.                                //
// Inputs are (in the same format) as follows:                                      //
// Patient's Name                                                                   //   
// Height (inches)                                                                  //
// Weight (lbs)                                                                     //
// Can accept any number of set of inputs, as long as all inputs are complete.      //
*/////////////////////////////////////////////////////////////////////////////////////

import java.io.*;                                                                                                                   // Imports java.io functions

public class BMI_Calculator_2
{

    public static void main (String[] args) throws Exception
    {
	String fileLocation  = "h:\\in.txt";                                                                                        // Contains the file location for the inputs
	String input         = null;                                                                                                // String to hold the inputs
	
	String name          = null;                                                                                                // String for the patient's name
	int height           = 0;                                                                                                   // integer variable for the patient's height
	double weight        = 0.0;                                                                                                 // double variable for the patient's weight
	double bodyMassIndex = 0.0;                                                                                                 // double variable for the patient's BMI
	
	try
	{
	    BufferedReader inputData = new BufferedReader ( new FileReader ( fileLocation ));                                       // Reads the data within "fileLocation"
	    input = inputData.readLine();                                                                                           // "input" is data read in "fileLocation"
	    
	    while( input != null )
	    {
		name   = input;                                                                                                     // "name" now contains the first input
		height = Integer.parseInt ( inputData.readLine() );                                                                 // "height" now contains the next input
		weight = Double.parseDouble ( inputData.readLine() );                                                               // "weight" now contains the next input
		
		bodyMassIndex = (weight / (height * height)) * 703;                                                                 // Calculates the BMI; output of height & weight is multiplied by 703 for conversion
		System.out.println (name + " is " + height + " inches tall and weighs " + weight + " lbs. ");                       // Prints "name" is "height" inches and "weight" pounds
		
		if (bodyMassIndex > 0 && bodyMassIndex < 18.5)
		{
		    System.out.println (name + " is Underweight.");                                                                 // Prints patient is Underweight
		    System.out.println ();                                                                                          // Prints a blank to move to the next line
		}                                                                                                                   // End if statement
		    
		else if (bodyMassIndex >= 18.5 && bodyMassIndex <= 25)
		{
		    System.out.println (name + " has Normal Weight.");                                                              // Prints patient has Normal Weight
		    System.out.println ();                                                                                          // Prints a blank to move to the next line
		}                                                                                                                   // End else if statement
		    
		else if (bodyMassIndex > 25)
		{
		    System.out.println (name + " is Overweight.");                                                                  // Prints patient is Overweight
		    System.out.println ();                                                                                          // Prints a blank to move to the next line
		}                                                                                                                   // End else if statement
		    
		input = inputData.readLine();                                                                                       // Reads the next line
		
	    }                                                                                                                       // End while() loop
		
	    inputData.close();                                                                                                      // Closes inputData
	    
	}                                                                                                                           // End try
	
	catch ( Exception e )
	{
	    System.out.println ( e );                                                                                               // Prints out the error
	    System.out.println ("There was an error. Check your file and inputs!");                                                 // Prints out an error message
	}                                                                                                                           // End catch
	
    }                                                                                                                               // End main
    
}                                                                                                                                   // End class BMI_Calculator_2
