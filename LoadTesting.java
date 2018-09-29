import java.lang.Math; 
import java.io.*;
import java.util.concurrent.TimeUnit;
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
		//Number of try
		int nbTry = 10000000;
		int percentage = 5;//Number of percentage you wanna see
		
		if(percentage>=1)
		{
			
			System.out.println("\n================ DESIGN 2 =========================\n");
			testDesignTwo(nbTry,percentage);//Testing design 2*/

			System.out.println("\n================ DESIGN 3 =========================\n");
			testDesignThree(nbTry,percentage);//*/

			System.out.println("\n================ DESIGN 6-2 =========================\n");
			testDesignSixTwo(nbTry,percentage);//*/

			System.out.println("\n================ DESIGN 6-3 =========================\n");
			testDesignSixThree(nbTry,percentage);//*/
		}

		System.out.println("\n================ TESTING COMPLETED ==================\n");
		
	}
	/**
	 * Test for design 3. On regular array
	 */
	public static void testDesignTwo(int nbTest, int percentage)
	{
		/* Nb of test we want to try
		 * 
		 */
		long startTime = 0;
		long endTime = 0;
		long endTime2 = 0;	
		
		System.out.println("Doing the design 2 (Polar) testing on a regular array.\n");
			
		
		//Generating the polar
		PointPolar[] pp = new PointPolar[nbTest];

		System.out.println("\nGenerating \t: " + nbTest + " polar coordinates...");
		startTime = System.currentTimeMillis();
		
		for(int i=0; i<nbTest;i++)
		{
			//Small module for the user to see how far we are in the percentage
			if( i % (nbTest/percentage) == 0 && i > 1)
				System.out.println("..." + ((i / (nbTest/percentage)) * (100/percentage)) + "% of datas generated.");
			
			
			double x = (Math.random() * 360);
			double y = (Math.random() * 360);
			
			pp[i] = new PointPolar('P',x,y);
			
		}
		System.out.println("...100% of datas generated.\n\nTesting data...");

		endTime = System.currentTimeMillis();
		//Testing the methods
		for(int i=0;i<nbTest;i++)
		{			
			if( i % (nbTest/percentage) == 0 && i > 1)
				System.out.println("..." + ((i / (nbTest/percentage)) * (100/percentage)) + "% of datas tested.");		

			double getX = pp[i].getX();
			double getY = pp[i].getY();
			double getRho = pp[i].getRho();
			double getTheta = pp[i].getTheta();
		}
		System.out.println("...100% of datas tested.");
		endTime2 = System.currentTimeMillis();

		System.out.println("\n================ DESIGN 2 RESULT ==================\n");
		System.out.println("Data has been generated in \t: \t" + ((endTime - startTime)/1000) + "." + ((endTime - startTime)%1000) + " secondes.\n" +
				"Data has been tested in \t: \t" +((endTime2-endTime)/1000) + "." + ((endTime2 - endTime)%1000)  + " secondes.\n" +
				"For a total time of\t\t: \t" + ((endTime2 - startTime)/1000) + "." + ((endTime2 - startTime)%1000)  + " secondes.");
	}
	
	/**
	 * Test for design 3. On regular array
	 */
	public static void testDesignThree(int nbTest, int percentage)
	{

		long startTime = 0;
		long endTime = 0;
		long endTime2 = 0;	
		
		System.out.println("Doing the design 3 (Cartesian) testing on a regular array.");
		//Generating the cartesian
		PointCart[] pc = new PointCart[nbTest];
		
		System.out.println("Generating \t: " + nbTest + " cartesian coordinates...");
		startTime = System.currentTimeMillis();
		
		for(int i=0; i<nbTest;i++)
		{			
			//Small module for the user to see how far we are in the percentage

			if( i % (nbTest/percentage) == 0 && i > 1)
				System.out.println("..." + ((i / (nbTest/percentage)) * (100/percentage)) + "% of datas generated.");
		
			double x = (Math.random() * 1000);
			double y = (Math.random() * 1000);
			
			pc[i] = new PointCart('C',x,y);
		}
		System.out.println("...100% of datas generated.\n\nTesting data...");		
		endTime = System.currentTimeMillis();
		//Testing the methods
		for(int i=0;i<nbTest;i++)
		{			
			if( i % (nbTest/percentage) == 0 && i > 1)
				System.out.println("..." + ((i / (nbTest/percentage)) * (100/percentage)) + "% of datas tested.");	

			double getX = pc[i].getX();
			double getY = pc[i].getY();
			double getRho = pc[i].getRho();
			double getTheta = pc[i].getTheta();
		}
		System.out.println("...100% of datas tested.");
		endTime2 = System.currentTimeMillis();

		System.out.println("\n================ DESIGN 3 RESULT ==================\n");
		System.out.println("Data has been generated in \t: \t" + ((endTime - startTime)/1000) + "." + ((endTime - startTime)%1000) + " secondes.\n" +
				"Data has been tested in \t: \t" +((endTime2-endTime)/1000) + "." + ((endTime2 - endTime)%1000)  + " secondes.\n" +
				"For a total time of\t\t: \t" + ((endTime2 - startTime)/1000) + "." + ((endTime2 - startTime)%1000)  + " secondes.");
		
	}
	
	
	/**
	 * Test for design 6 with design 3, testing with interface cartesian
	 */
	public static void testDesignSixThree(int nbTest, int percentage)
	{

		long startTime = 0;
		long endTime = 0;
		long endTime2 = 0;	
		
		
		//Generating the cartesian
		Point[] pc2 = new Point[nbTest];
		
		System.out.println("Generating \t: " + nbTest + " cartesian coordinates from design 6...");
		startTime = System.currentTimeMillis();
		
		for(int i=0; i<nbTest;i++)
		{
			//Small module for the user to see how far we are in the percentage
			if( i % (nbTest/percentage) == 0 && i > 1)
				System.out.println("..." + ((i / (nbTest/percentage)) * (100/percentage)) + "% of datas generated.");
		
			double x = (Math.random() * 1000);
			double y = (Math.random() * 1000);
			
			pc2[i] = new PointCart('C',x,y);
		}
		System.out.println("...100% of datas generated.\n\nTesting data...");

		endTime = System.currentTimeMillis();

		//Testing the methods
		for(int i=0;i<nbTest;i++)
		{			
			if( i % (nbTest/percentage) == 0 && i > 1)
				System.out.println("..." + ((i / (nbTest/percentage)) * (100/percentage)) + "% of datas tested.");	

			double getX = pc2[i].getX();
			double getY = pc2[i].getY();
			double getRho = pc2[i].getRho();
			double getTheta = pc2[i].getTheta();
		}
		System.out.println("...100% of datas tested.");
		endTime2 = System.currentTimeMillis();

		System.out.println("\n================ DESIGN 6-3 RESULT ==================\n");
		System.out.println("Data has been generated in \t: \t" + ((endTime - startTime)/1000) + "." + ((endTime - startTime)%1000) + " secondes.\n" +
				"Data has been tested in \t: \t" +((endTime2-endTime)/1000) + "." + ((endTime2 - endTime)%1000)  + " secondes.\n" +
				"For a total time of\t\t: \t" + ((endTime2 - startTime)/1000) + "." + ((endTime2 - startTime)%1000)  + " secondes.");
	}
	
	/**
	 * Test for design 6 with design 2, testing with interface polar
	 */
	public static void testDesignSixTwo(int nbTest, int percentage)
	{

		long startTime = 0;
		long endTime = 0;
		long endTime2 = 0;	
		
		//Generating the polar
		Point[] pp2 = new Point[nbTest];

		System.out.println("\nGenerating \t: " + nbTest + " polar coordinates from design 6...");
		startTime = System.currentTimeMillis();
		
		for(int i=0; i<nbTest;i++)
		{	
			//Small module for the user to see how far we are in the percentage			
			if( i % (nbTest/percentage) == 0 && i > 1)
				System.out.println("..." + ((i / (nbTest/percentage)) * (100/percentage)) + "% of datas generated.");
		
		
			double x = (Math.random() * 360);
			double y = (Math.random() * 360);
			
			pp2[i] = new PointPolar('P',x,y);
		}
		System.out.println("...100% of datas generated.\n\nTesting data...");
		endTime = System.currentTimeMillis();
		
		//Testing the methods
		for(int i=0;i<nbTest;i++)
		{			
			if( i % (nbTest/percentage) == 0 && i > 1)
				System.out.println("..." + ((i / (nbTest/percentage)) * (100/percentage)) + "% of datas tested.");	

			double getX = pp2[i].getX();
			double getY = pp2[i].getY();
			double getRho = pp2[i].getRho();
			double getTheta = pp2[i].getTheta();
		}

		System.out.println("...100% of datas tested.");
		endTime2 = System.currentTimeMillis();

		System.out.println("\n================ DESIGN 6-2 RESULT ==================\n");
		System.out.println("Data has been generated in \t: \t" + ((endTime - startTime)/1000) + "." + ((endTime - startTime)%1000) + " secondes.\n" +
							"Data has been tested in \t: \t" +((endTime2-endTime)/1000) + "." + ((endTime2 - endTime)%1000)  + " secondes.\n" +
							"For a total time of\t\t: \t" + ((endTime2 - startTime)/1000) + "." + ((endTime2 - startTime)%1000)  + " secondes.");
		
	}
	
	public void testArray() {
		
	}
}