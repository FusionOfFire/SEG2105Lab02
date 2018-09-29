import java.io.*;
/**
 * This class has been modified for the lab02\assignement 01 of the class SEG2105\
 * Design #02 (Store polar coordinates only)
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @Modifiedby Zhuobin Ma - 7469161
 * @Modifiedby Frederick Gaudet - 8035208
 * @version July 2000
 * @modified September 2018 for SEG 2105lab
 */
public class PointPolar implements Point
{
  //Instance variables ************************************************
  
  /**
   * Contains the RHO
   */
  private double rho;
  
  /**
   * Contains the THETA
   */
  private double theta;
	
  
  //Constructors ******************************************************
  /** 
   * Default constructor
   */
  public PointPolar()
  {
	  
  }
  /**
   * Constructs a coordinate object, with a type identifier.
   * 
   */
  public PointPolar(char type, double rho, double theta)
  {
	  
	  //Make sure good argument as been send to constructor
	  if((	Character.toUpperCase(type) != 'C') &&
			Character.toUpperCase(type) != 'P'  )
		  throw new IllegalArgumentException();//Send an error
	  
	  //If it is cartesian, convert it to polar
	  if(Character.toUpperCase(type) == 'C')
	  {
		  double x = rho;//Save temporary the rho because it will get changed
		  rho = Math.sqrt(Math.pow(rho, 2) + Math.pow(theta, 2));//Compute rho
		  theta = Math.toDegrees(Math.atan2(theta, x));//Compute theta
	  }
	  
	  //Just save it
	  if((rho>360 || rho < 0)&&(theta > 360 || theta < 0))
		  throw new IllegalArgumentException();
	  this.rho = rho;
	  this.theta = theta;

  }
  
  /**
   * Constructor with cartesian as param
   * @param pc
   */
  public PointPolar(PointPolar pp)
  {
	  this.rho = pp.getRho();
	  this.theta = pp.getTheta();
  }
	
  
  //Instance methods **************************************************
 
  //Return the X value computed
  public double getX()
  {
      return (Math.cos(Math.toRadians(theta)) * rho);
  }

  //Return the Y value computed
  public double getY()
  {
      return (Math.sin(Math.toRadians(theta)) * rho);
  }
  

  //Return the RHO value stored
  public double getRho()
  {
    return this.rho;
  }
  
  //Return the THETA value stored
  public double getTheta()
  {
    return this.theta;
  }

  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(int x, int y)
  {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - x;
    double deltaY = getY() - y;
    
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }
  
  public PointPolar convertStorageToPolar()
  {
	  return this;
  }
  
  /**
   * Converts Polar coordinates to Cartesian coordinates.
   */
  public PointCart convertStorageToCartesian()
  {
    PointCart tmp = new PointCart('C', getX(), getY());
    return tmp;
  }
  
  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   *
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointPolar rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointPolar('P',(Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString()
  {
    return "Stored as " +  "Polar [" + getRho() + "," + getTheta() + "]" + "\n";
  }
}