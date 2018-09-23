/**
 * This class has been modified for the lab02\assignement 01 of the class SEG2105\
 * Design #03 (Store cartesian coordinates only)
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @Modifiedby Frederick Gaudet and Evan
 * @version July 2000
 * @modified September 2018 for SEG 2105lab
 */
public class PointCart
{
  //Instance variables ************************************************

  
  
  /**
   * Contains the current value of X or RHO depending on the type
   * of coordinates.
   */
  private double x;
  
  /**
   * Contains the current value of Y or THETA value depending on the
   * type of coordinates.
   */
  private double y;
	
  
  //Constructors ******************************************************
  /** 
   * Default constructor
   */
  public PointCart()
  {
	  
  }
  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointCart(double x, double y)
  {
    
    this.x = x;
    this.y = y;
    
  }
	
  
  //Instance methods **************************************************
  //Return the X value stored
  public double getX()
  {
      return x;
  }

  //Return the Y value stored
  public double getY()
  {
      return y;
  }

  //Return the RHO value computed
  public double getRho()
  {
      return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
  }

  //Return the THETA value computed
  public double getTheta()
  {
      return Math.toDegrees(Math.atan2(y, x));
  }
  
	
  

  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(PointCart pointB)
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
  public PointCart rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointCart((Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString()
  {
    return "Stored as Cartesian  (" + getX() + "," + getY() + ")";
  }
}