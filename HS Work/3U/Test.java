// The "Test" class.

import java.io.*;

public class Test
{
    public static void main (String[] args) throws Exception
    {
	String inputData = null;
	String fileName = "E:\\in.txt";
	
	String dataReadA = null;
	String dataReadB = null;
	String subDataRead = "wat";
	
	try
	{
	    dataReadA = subDataRead.substring (0,1);
	    dataReadB = subDataRead.substring (2,3);
	    
	    System.out.println (dataReadA);
	    System.out.println (dataReadB);
	    
	    if (dataReadA == "w")
	    {
		System.out.println ("success");
	    }
	    else
	    {
		System.out.println ("fail");
	    }
	}
	
	catch ( Exception e )
	{
	    System.out.println ( e );
	    System.out.println ("Check your file!!");
	}
    }
} 
