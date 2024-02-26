/*////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Name: Keigo Katanaga                                                                                              //
//Student Number: 25603325                                                                                          //
//Program Name: Special_Square.java                                                                                 //
//Date: 06/13/2020                                                                                                  //
//                                                                                                                  //
//Description:                                                                                                      //
//A calculator for whether a set of given values create a "special square" using 2d arrays and for loops.           //
//A special square is made up of S * S values.                                                                      //
//A special square is determined by comparing the sum of all horizontal, vertical, and diagonal values.             //
//If the given values make up a special square, the calculator shows the equal sum.                                 //
//If not, the calculator shows "-1".                                                                                //
//                                                                                                                  //
//The inputs consist of the first line determining the size of the special square (The S value).                    //
//The number of the remaining data needs to equal to the square of S (i.e when S is 3, 9 values must be present).   //
//The inputs need to be in proper format. Otherwise, the program will not work.                                     //
//                                                                                                                  //
//Example input:                                                                                                    //
//3 <-- Size; the array will be 3x3                                                                                 //
//2 -                                                                                                               //
//5  |                                                                                                              //
//4  |                                                                                                              //
//7  |                                                                                                              //
//5  |- 9 values for the 3x3 array.                                                                                 //
//4  |                                                                                                              //
//6  |                                                                                                              //
//9  |                                                                                                              //
//1 -                                                                                                               //
//                                                                                                                  //
//<!><!>Change the directory (fileLocation) if needed! The file name can also be changed!<!><!>                     //
*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;

public class Special_Square
{
    public static void main (String[] args)
    {
	String fileLocation = "h://in.txt";                                                     // Container for the file location (Can be changed without consequences)
	
	int squareSize      = 0;                                                                // Container for array size; requires input (The S value that is mentioned in the description)
	
	int min             = 0;                                                                // Holds the min value for diagonal locations
	int max             = 0;                                                                // Holds the max value for diagonal locations
	
	int specialValue    = 0;                                                                // Holds the special square number (-1 if square is not special)
	
	try
	{
	    BufferedReader dataIn = new BufferedReader ( new FileReader (fileLocation));        // Creates a BufferedReader
	    squareSize = Integer.parseInt (dataIn.readLine());                                  // Reads the first line. Determines the size of the special square
		
	    int specialSquare [][] = new int [squareSize][squareSize];                          // Creates an int 2d array that follows the given size from the first line
	    
	    int hztal [] =  new int [squareSize];                                               // Creates an int array that holds the sum of each horizontal
	    int vtcal [] =  new int [squareSize];                                               // Creates an int array that holds the sum of each vertical
	    int dgnal [] =  new int [2];                                                        // Creates an int array that holds the sum of each diagonal
		
	    for (int r = 0; r < squareSize; r++)
	    {
		for (int c = 0; c < squareSize; c++)
		{
												// <!>Designates each data read to their respective locations in the specialSquare array<!>
		    specialSquare [r][c] = Integer.parseInt (dataIn.readLine());                // Reads the rest of the data and converts to integer. "r" represents the rows. "c" represents the columns
		}                                                                               //*end c for() loop
	    }                                                                                   //*end r for() loop
	    
	    for (int x = 0; x < squareSize; x++)
	    {
		for (int y = 0; y < squareSize; y++)
		{
												// <!>Finds the sum of horizontals and verticals<!>
		    hztal [x] = hztal [x] + specialSquare [x][y];                               // Keeps adding the horizontal values until it reaches the max sum of the horizontal
		    vtcal [x] = vtcal [x] + specialSquare [y][x];                               // Keeps adding the vertical values until it reaches the max sum of the vertical
		}                                                                               //*end y for() loop
	    }                                                                                   //*end x for() loop
	    
	    max = squareSize - 1;                                                               // max now holds the maximum index to start counting down from
	    while (max != -1)
	    {
												// <!>Finds the sum of diagonal 0 (top left -> bottom right), and diagonal 1 (top right -> bottom left)<!>
		    dgnal [0] = dgnal [0] + specialSquare [min][min];                           // Keeps adding the diagonal 0 values until it reaches the total sum of the diagonal
		    dgnal [1] = dgnal [1] + specialSquare [min][max];                           // Keeps adding the diagonal 1 values until it reaches the total sum of the diagonal
		    min++;                                                                      // Adds 1 per run. Will not go over squareSize because of max
		    max--;                                                                      // Substracts 1 per run. If max reaches -1, min would have reached the maximum size. This will end the loop
	    }                                                                                   //*end while() loop
	    
	    for (int checkCounter = 0; checkCounter < squareSize; checkCounter++)
	    {
												// <!>Checks if the sum of all horizontals, verticals, and diagonals are equal<!>
		if (hztal [0] != hztal [checkCounter])
		{
												// Checks whether the sum of horizontals are equal to other sums of horizontals
		    specialValue = -1;                                                          // The square is not special
		    checkCounter = squareSize;                                                  // Stops the for loop
		}                                                                               //*end if statement
		else if (vtcal [0] != vtcal [checkCounter])
		{
												// Checks whether the sum of verticals are equal to the other sums of verticals
		    specialValue = -1;                                                          // The square is not special
		    checkCounter = squareSize;                                                  // Stops the for loop
		}                                                                               //*end else if statement
		else if (dgnal [0] != dgnal [1] )
		{
												// Checks whether the sums of the two diagonals are equal
		    specialValue = -1;                                                          // The square is not special
		    checkCounter = squareSize;                                                  // Stops the for loop
		}                                                                               //*end else if statement
		else if (hztal [0] != vtcal [checkCounter])
		{
												// Checks whether the sum of horizontals are equal to the sum of verticals
		    specialValue = -1;                                                          // The square is not special
		    checkCounter = squareSize;                                                  // Stops the for loop
		}                                                                               //*end else if statement
		
		else if (dgnal [0]!= hztal [checkCounter])
		{
												// Checks whether the sum of diagonal 0 is equal to the sum of horizontals
		    specialValue = -1;                                                          // The square is not special
		    checkCounter = squareSize;                                                  // Stops the for loop
		}                                                                               //*end else if statement
		else if (dgnal [1] != hztal [checkCounter])
		{
												// Checks whether the sum of diagonal 1 is equal to the sum of horizontals
		    specialValue = -1;                                                          // The square is not special
		    checkCounter = squareSize;                                                  // Stops the for loop
		}                                                                               //*end else if statement
		else if (dgnal [0]!= vtcal [checkCounter])
		{
												// Checks whether the sum of diagonal 0 is equal to the sum of verticals
		    specialValue = -1;                                                          // The square is not special
		    checkCounter = squareSize;                                                  // Stops the for loop
		}                                                                               //*end else if statement
		else if (dgnal [1] != vtcal [checkCounter] )
		{
												// Checks whether the sum of diagonal 1 is equal to the sum of verticals
		    specialValue = -1;                                                          // The square is not special
		    checkCounter = squareSize;                                                  // Stops the for loop
		}                                                                               //*end else if statement
		else
		{
												// Activated when all values are equal
		    specialValue = hztal [0];                                                   // Sets specialValue to hztal [0] since all values are equal
		}                                                                               //*end else
		
	    }                                                                                   //*end checkCounter for() loop
	    
	    System.out.println ("Special Square");                                              // Prints out the title
	    System.out.print   ("--------------");                                              // Prints out underline
	    
	    for (int a = 0; a < squareSize; a++)
	    {
		System.out.println ();                                                          // Prints a new line for every horizontals printed
		
		for (int b = 0; b < squareSize; b++)
		{
		    System.out.print (specialSquare [a][b] + " ");                              // Prints out all the values of the specified horizontal
		}                                                                               //*end b for()
	    }                                                                                   //*end a for()
	    
	    System.out.println ("\n\nSpecial Square = " + specialValue);                        // Prints out the special square total value
	    
	    dataIn.close();                                                                     // Closes the file
	    
	}                                                                                       //*end try
	
	catch (Exception e)
	{
	    System.out.println (e + "\nThere was an error. Check your inputs!");                // Sends out error message
	}                                                                                       //*end catch
	    
    }                                                                                           //*end main
}                                                                                               //*end class
