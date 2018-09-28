import java.lang.Math; 
import java.io.*;
/**
 * This class has been modified for the lab02\assignement 01 of the class SEG2105\
 * This is the main test modified on purpose to test the charge put on the computer
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @Modifiedby Zhuobin Ma - 7469161
 * @Modifiedby Frederick Gaudet - 8035208
 * @version July 2000
 * @modified September 2018 for SEG 2105lab
 */
public class LoadTesting
{
	//Class methods *****************************************************
	
	public static void main(String[] args)
	{
		testDesignThreeAndTwo();
		//testDesignSix();
		
	}
	
	/**
	 * Test for design 2, 3. On regular array
	 */
	public static void testDesignThreeAndTwo()
	{
		/* Nb of test we want to try
		 * 
		 */
		//int nbTest = 30000000;//Best test simulation to get around 9 secondes
		int nbTest = 1000;
		long startTime = 0;
		long endTime = 0;
		float result = 0;
		
		System.out.println("Doing the design 2 & 3 testing on a regular array.");
		//Generating the cartesian
		PointCart[] pc = new PointCart[nbTest];
		
		System.out.println("Generating \t: " + nbTest + " cartesian coordinates...");
		startTime = System.currentTimeMillis();
		
		for(int i=0; i<nbTest;i++)
		{
			double x = (Math.random() * 1000);
			double y = (Math.random() * 1000);
			
			pc[i] = new PointCart('C',x,y);
		}

		endTime = System.currentTimeMillis();
		result = (endTime - startTime)/1000;
		System.out.println("Time \t\t: " + result + " secondes for the cartesian coordinate.");
		
		
		//Generating the polar
		PointPolar[] pp = new PointPolar[nbTest];

		System.out.println("\nGenerating \t: " + nbTest + " polar coordinates...");
		startTime = System.currentTimeMillis();
		
		for(int i=0; i<nbTest;i++)
		{
			double x = (Math.random() * 360);
			double y = (Math.random() * 360);
			
			pp[i] = new PointPolar('P',x,y);
		}

		endTime = System.currentTimeMillis();
		result = (endTime - startTime)/1000;
		System.out.println("Time \t\t: " + result + " secondes for the polar coordinate.");
		
	}
	
	/**
	 * Test for design 6, testing with interface
	 */
	public static void testDesignSix()
	{
		/* Nb of test we want to try
		 * 
		 */
		//int nbTest = 30000000;//Best test simulation to get around 9 secondes
		int nbTest = 1000;
		long startTime = 0;
		long endTime = 0;
		float result = 0;
		
		
		//Generating the cartesian
		Point[] pc = new Point[nbTest];
		
		System.out.println("Generating \t: " + nbTest + " cartesian coordinates...");
		startTime = System.currentTimeMillis();
		
		for(int i=0; i<nbTest;i++)
		{
			double x = (Math.random() * 1000);
			double y = (Math.random() * 1000);
			
			pc[i] = new PointCart('C',x,y);
		}

		endTime = System.currentTimeMillis();
		result = (endTime - startTime)/1000;
		System.out.println("Time \t\t: " + result + " secondes for the cartesian coordinate.");
		
		
		//Generating the polar
		Point[] pp = new Point[nbTest];

		System.out.println("\nGenerating \t: " + nbTest + " polar coordinates...");
		startTime = System.currentTimeMillis();
		
		for(int i=0; i<nbTest;i++)
		{
			double x = (Math.random() * 360);
			double y = (Math.random() * 360);
			
			pp[i] = new PointPolar('P',x,y);
		}

		endTime = System.currentTimeMillis();
		result = (endTime - startTime)/1000;
		
		System.out.println("Time \t\t: " + result + " secondes for the polar coordinate.");
		
	}
	
	public void testArray() {
		
	}
}