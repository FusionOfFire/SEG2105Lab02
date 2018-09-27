// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;

/**
 * This class has been modified for the lab02\assignement 01 of the class SEG2105\
 * This is the main test modified on purpose to test for the design 2 and 3.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @Modifiedby Frederick Gaudet and Evan
 * @version July 2000
 * @modified September 2018 for SEG 2105lab
 */
public class PointCPTest
{
  //Class methods *****************************************************

  public static void main(String[] args)
  {
	PointCart pointCart = new PointCart();
	PointPolar pointPolar = new PointPolar();
	
	
	char coordType = 'A';
	
    byte[] buffer = new byte[1024];  //Buffer to hold byte input
    String theInput = "";  // Input information
	
    System.out.println("Cartesian-Polar Coordinates Conversion Program");

    //Try to see if the user inserted argument at run
    try
    {
    	coordType = args[0].toUpperCase().charAt(0);
    	if(coordType == 'C')
    		pointCart = new PointCart(	Double.valueOf(args[1]).doubleValue(),
    									Double.valueOf(args[2]).doubleValue());
    	else if(coordType == 'P')
    		pointPolar = new PointPolar(Double.valueOf(args[1]).doubleValue(),
    									Double.valueOf(args[2]).doubleValue());
    }
    catch(Exception e)
    {
      // If we arrive here, it is because either there were no
      // command line arguments, or they were invalid
      if(args.length != 0)
        System.out.println("Invalid arguments on command line");

      try
      {
    	  boolean isOK = false;
    	  while(isOK == false) {
    		  isOK = true;
	    	  System.out.print("Enter the type of Coordinates you "
	    	            + "are inputting ((C)artesian / (P)olar): ");
	          for(int k=0; k<1024; k++)
	          	buffer[k] = '\u0020';        
	               
	          System.in.read(buffer);
	          theInput = new String(buffer).trim();
	          //Read if the user input C or P
	          if (!((theInput.toUpperCase().charAt(0) == 'C') 
                  || (theInput.toUpperCase().charAt(0) == 'P')))
              {
	        	  //Invalid input, reset flag so user is prompted again
	        	  isOK = false;
              }
              else
              {
            	  coordType = theInput.toUpperCase().charAt(0);
              }
    	  }
    	  if(coordType == 'C')
    	  {    
    		  pointCart = getCart(coordType);//Return a cartesian variable
    	  }
    	  else if(coordType == 'P')
    	  {
    		  pointPolar = getPolar(coordType);//Return a polar variable
    	  }
      }
      catch(IOException ex)
      {
        System.out.println("Error getting input. Ending program.");
        return;
      }
    }
    if(coordType == 'C')
    {    
        System.out.println("\nAfter asking to store as Cartesian:\n" + pointCart);
 
    }
    else if(coordType == 'P')
    {
    	System.out.println("\nAfter asking to store as Polar:\n" + pointPolar);
    }
    else 
    	System.out.println("Not working please try again");


    
  }

  /**
   * This method only work for point cart
   */
  private static PointCart getCart(char coordType) throws IOException
  {
    byte[] buffer = new byte[1024];  //Buffer to hold byte input
    boolean isOK = false;  // Flag set if input correct
    String theInput = "";  // Input information
    
    //Information to be passed to the constructor
    double a = 0.0;
    double b = 0.0;

    // Allow the user to enter the three different arguments
    
    while (!(isOK))
    {
    	isOK = true;
    	System.out.println("Enter the cartesian value of...");
    	for(int i=0;i<2;i++)
    	{
    		System.out.print(i == 0 ? "X " : "Y ");
    		System.in.read(buffer);
	        theInput = new String(buffer).trim();
	        try
	        {
	          
	            //Convert the input to double values
	            if (i == 0)
	              a = Double.valueOf(theInput).doubleValue();
	            else
	              b = Double.valueOf(theInput).doubleValue();
	            }
	        catch(Exception e)//If user input something else than a double
	        {
	        	System.out.println("Incorrect input");
	        	i=3;
	        	isOK = false;  //Reset flag as so not to end while loop
	        }
    	}
    	
    }
    //Return a new PointCP object
    return (new PointCart(a, b));
  }
  
  /**
   * This method only work for polar coordinate
   */
  private static PointPolar getPolar(char coordType) throws IOException
  {
    byte[] buffer = new byte[1024];  //Buffer to hold byte input
    boolean isOK = false;  // Flag set if input correct
    String theInput = "";  // Input information
    
    //Information to be passed to the constructor
    double a = 0.0;
    double b = 0.0;

    // Allow the user to enter the three different arguments
    
    while (!(isOK))
    {
    	isOK = true;
    	System.out.println("Enter a polar value between 0 and 360(inclusive) of...");
    	for(int i=0;i<2;i++)
    	{
    		System.out.print(i == 0 ? "Rho " : "Theta ");
    		System.in.read(buffer);
	        theInput = new String(buffer).trim();
	        try
	        {
	        	double v = Double.valueOf(theInput).doubleValue();
	            //Convert the input to double values
	            if (i == 0) {
	            	a = Double.valueOf(theInput).doubleValue();
	            	i = ((v>360 || v<0)? -1:i);//Make sure that the value is between 0 and 360
	            }
	            else
	            {
	            	b = Double.valueOf(theInput).doubleValue();
	            	i = ((v>360 || v<0)? 0:i);//Make sure that the value is between 0 and 360
	            }
	        }
	        catch(Exception e)
	        {
	        	System.out.println("Incorrect input");
	        	i=3;
	        	isOK = false;  //Reset flag as so not to end while loop
	        }
    	}
    	
    }
    //Return a new PointCP object
    return (new PointPolar(a, b));
  }
}