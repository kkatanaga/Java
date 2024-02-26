/*
<------------------------------------------------------------->
< Program Name: BMI_Calculator
< Name: Keigo Katanaga
< Date: 04/09/2020
< Description: Calculates the Body Mass Index (BMI) from the 
< height (in metres) and weight (in kilograms). Input comes
< from args.
<------------------------------------------------------------->
*/

public class BMI_Calculator {

    public static void main (String[] args) {
    
	double weight = 0;                                                                           // float weight for the patient's weight
	double height = 0;                                                                           // float height for the patient's height
	double result = 0;                                                                           // float result for the resulting BMI
	
	System.out.println ("Please use 'Run with Args' to input weight (kg) & height (m)!");       // Asks to use args in order to input weight and height
	System.out.println ("Your weight: " + args[0] + " kg");                                     // Asks for an input for args[0] (weight)
	System.out.println ("Your height: " + args[1] + " m" );                                     // Asks for an input for args[1] (height)
	
	weight = Double.parseDouble (args[0]);                                                        // Converts the input in args[0] ("Your weight") to float weight
	height = Double.parseDouble (args[1]);                                                        // Converts the input in args[1] ("Your height") to float height
	result = weight / (height * height);                                                        // Calculates the BMI. "result" is the patient's BMI
	
	System.out.print ("Your BMI is " + result + ";");                                           // Prints out the patient's BMI and also their BMI category
	
	if (result > 0 && result < 18.5) {
	    System.out.println (" you are underweight.");                                           // The result is a BMI of less than 18.5
	    
	} else if (result >= 18.5 && result <= 24.9) {
	    System.out.println (" you have normal weight.");                                        // The result is a BMI of 18.5 to 24.9
	    
	} else if (result > 24.9 && result < 30) {
	    System.out.println (" you are overweight.");                                            // The result is a BMI between 24.9 and 30
	    
	} else if (result >= 30) {
	    System.out.println (" you have obesity.");                                              // The result is a BMI of 30 or more
	    
	} else {
	    System.out.println (" therefore, we could not determine your BMI properly.");           // The result is negative; inadmissible
	    
	}                                                                                           // end else statment

    }                                                                                               // end main()
    
}                                                                                                   // end class BMI_Calculator
