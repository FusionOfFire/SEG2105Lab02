public interface PointCP{


  public double getRho();
  public double getTheta();
  public double getX();
  public double getY();
   	
  public PointCP convertStorageToPolar();
  public PointCP convertStorageToCartesian();

	public double getDistance(PointCP pointB);
	public PointCP rotatePoint(double rotation);

}