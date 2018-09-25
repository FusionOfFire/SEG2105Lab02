public class Test{


	private static final int dataLength = 10000000;

	public static void main(String[] args){

		char typeC = 'C';
		PointCP[] points = new PointCP[dataLength];
		
		double[] x = new double[dataLength];
		double[] y = new double[dataLength];

		for (int i = 0; i< dataLength; i++){
			double dataX = (double)Math.random()*10000;
			double dataY = (double)Math.random()*10000;

			x[i] = dataX;
			y[i] = dataY;

		}


		long startTime = System.currentTimeMillis ();

		for (int j=0; j<dataLength; j++) {
			points[j] = new PointCP (typeC, x[j], y[j]);
		}

		for (int k=0; k<dataLength; k++) {
			points[k].getRho();
			points[k].getTheta();
		}

		for (int l=0; l<(dataLength/2); l++){
			points[l].getDistance(points[dataLength/2+l]);
		}


		for (int m=0; m<dataLength; m++){
			double degree = (double)Math.random()*360.0;

			points[m].rotatePoint(degree);

		}


		long endTime = System.currentTimeMillis ();
		System.out.println ("The Running time is (ms): "+ (endTime-startTime));


	}
}