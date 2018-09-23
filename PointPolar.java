/**
 * This class has been modified for the lab02\assignement 01 of the class SEG2105\
 * Design #02 (Store polar coordinates only)
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @Modifiedby Frederick Gaudet and Evan
 * @version July 2000
 * @modified September 2018 for SEG 2105lab
 */
public class PointPolar
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
   */
  public PointPolar(double rho, double theta)
  {
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
  public double getDistance(PointPolar pointB)
  {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();
    
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
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
        
    return new PointPolar((Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
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