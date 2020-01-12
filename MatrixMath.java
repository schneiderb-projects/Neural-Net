import java.util.Arrays;
import java.util.Random;

public class MatrixMath {
	//arrays go by row and then columns
	public static double[][] dot(double[][] x, double[][] y)
	{
		int heightX = x.length;
		int widthX = x[0].length;
		int widthY = y[0].length;
		double[][] temp= new double[heightX][widthY];
		for(int i = 0; i < heightX; i++)
			for(int j = 0; j < widthY; j++)
				for(int k = 0; k < widthX; k++)
					temp[i][j] += x[i][k] * y[k][j];
		return temp;
	}
	public static double[][] transpose(double[][] x)
	{
		double[][] temp = new double[x[0].length][x.length];
		for(int i = 0; i < x.length; i++)
			for(int j = 0; j < x[0].length; j++)
				temp[j][i] = x[i][j];
		return temp;
	}

	public static String print(double[][] x)
	{
		String output = "";
		for(double[] row: x)
			output+=(Arrays.toString(row)+"\n");
		return output;
	}

	public static double[][] rowAdd(double[][] matrix, double[][] vector) {
		int m = matrix.length;
		int n = matrix[0].length;
		double[][] c = new double[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				c[i][j] = matrix[i][j] + vector[i][0];
			}
		}
		return c;
	}

	public static double[][] elementWiseMult(double[][] x, double[][] y)
	{
		int width = x[0].length;
		int height = y.length;
		double[][] temp = new double[height][width];
		for(int i = 0; i < height; i++)
			for(int j = 0; j < width; j++)
				temp[i][j] = x[i][j]*y[i][j];
		return temp;		
	}

	public static double[][] scalarMult(double[][] x, double scalar)
	{
		double[][] temp = new double[x.length][x[0].length];
		for(int i = 0; i < temp.length; i++)
			for(int j = 0; j < temp[0].length; j++)
				temp[i][j] = x[i][j]*scalar;
		return temp;
	}

	public static double[][] scalarDivide(double[][] x, double scalar)
	{
		double[][] temp = new double[x.length][x[0].length];
		for(int i = 0; i < temp.length; i++)
			for(int j = 0; j < temp[0].length; j++)
				temp[i][j] = x[i][j]/scalar;
		return temp;
	}

	public static double[][] power(double[][] x, double power)
	{
		double[][] temp = new double[x.length][x[0].length];
		for(int i = 0; i < temp.length; i++)
			for(int j = 0; j < temp[0].length; j++)
				temp[i][j] = Math.pow(x[i][j],power);
		return temp;
	}
	public static String dimensions(double[][] a) {
		int height = a.length;
		int length = a[0].length;
		String Vshape = "(" + height + "," + length + ")";
		return Vshape;
	}
	public static double[][] sigmoid(double[][] a) {
		int height = a.length;
		int length = a[0].length;
		double[][] temp = new double[height][length];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < length; j++) {
				temp[i][j] = (1.0 / (1 + Math.exp(-a[i][j])));
			}
		}
		return temp;
	}
	public static double cross_entropy(int batch_size, double[][] Y, double[][] A) {
		int height = A.length;
		int width = A[0].length;
		double[][] temp = new double[height][width];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				temp[i][j] = (Y[i][j] * Math.log(A[i][j])) + ((1 - Y[i][j]) * Math.log(1 - A[i][j]));
			}
		}

		double sum = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				sum += temp[i][j];
			}
		}
		return -sum / batch_size;
	}
	public static double[][] add(double[][] x, double[][] y)
	{
		int width = x[0].length;
		int height = y.length;
		double[][] temp = new double[height][width];
		for(int i = 0; i < height; i++)
			for(int j = 0; j < width; j++)
				temp[i][j] = x[i][j] + y[i][j];
		return temp;
	}
	public static double[][] vectorAdd(double[][] x, double[][] vector)
	{
		int width = x[0].length;
		int height = x.length;
		double[][] temp = new double[height][width];
		for(int i = 0; i < height; i++)
			for(int j = 0; j < width; j++)
				temp[i][j] = x[i][j] + vector[i][0];
		return temp;
	}
	public static double[][] subtract(double[][] x, double[][] y)
	{
		int height = x.length;
		int width = x[0].length;
		double[][] c = new double[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				c[i][j] = x[i][j] - y[i][j];
			}
		}
		return c;
	}
	public static double[][] scalarSubtract(double[][] x, double scalar)
	{
		double[][] temp = new double[x.length][x[0].length];
		for(int i = 0; i < temp.length; i++)
			for(int j = 0; j < temp[0].length; j++)
				temp[i][j] = scalar - x[i][j];
		return temp;
	}

	public static double[][] roundAll(double[][] toRound) {
		double[][] rounded = new double[toRound.length][toRound[0].length];
		for(int k = 0; k < toRound.length; k++)
			for(int j = 0; j < toRound[0].length; j++)
				rounded[k][j] = Math.round(toRound[k][j]);
		return rounded;
	}

	//---------------------------------------------------------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------------------------------------------------------
	//NOT MINE 
	private static Random random;
	private static long seed;

	static {
		seed = System.currentTimeMillis();
		random = new Random(seed);
	}

	/**
	 * Sets the seed of the pseudo-random number generator. This method enables
	 * you to produce the same sequence of "random" number for each execution of
	 * the program. Ordinarily, you should call this method at most once per
	 * program.
	 *
	 * @param s the seed
	 */
	public static void setSeed(long s) {
		seed = s;
		random = new Random(seed);
	}

	/**
	 * Returns the seed of the pseudo-random number generator.
	 *
	 * @return the seed
	 */
	public static long getSeed() {
		return seed;
	}

	/**
	 * Returns a random real number uniformly in [0, 1).
	 *
	 * @return a random real number uniformly in [0, 1)
	 */
	public static double uniform() {
		return random.nextDouble();
	}

	/**
	 * Returns a random integer uniformly in [0, n).
	 *
	 * @param n number of possible integers
	 * @return a random integer uniformly between 0 (inclusive) and {@code n}
	 * (exclusive)
	 * @throws IllegalArgumentException if {@code n <= 0}
	 */
	public static int uniform(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("argument must be positive: " + n);
		}
		return random.nextInt(n);
	}

	/**
	 * Returns a random long integer uniformly in [0, n).
	 *
	 * @param n number of possible {@code long} integers
	 * @return a random long integer uniformly between 0 (inclusive) and
	 * {@code n} (exclusive)
	 * @throws IllegalArgumentException if {@code n <= 0}
	 */
	public static long uniform(long n) {
		if (n <= 0L) {
			throw new IllegalArgumentException("argument must be positive: " + n);
		}

		long r = random.nextLong();
		long m = n - 1;

		// power of two
		if ((n & m) == 0L) {
			return r & m;
		}

		// reject over-represented candidates
		long u = r >>> 1;
		while (u + m - (r = u % n) < 0L) {
			u = random.nextLong() >>> 1;
		}
		return r;
	}

	/**
	 * Returns a random integer uniformly in [a, b).
	 *
	 * @param a the left endpoint
	 * @param b the right endpoint
	 * @return a random integer uniformly in [a, b)
	 * @throws IllegalArgumentException if {@code b <= a}
	 * @throws IllegalArgumentException if {@code b - a >= Integer.MAX_VALUE}
	 */
	public static int uniform(int a, int b) {
		if ((b <= a) || ((long) b - a >= Integer.MAX_VALUE)) {
			throw new IllegalArgumentException("invalid range: [" + a + ", " + b + ")");
		}
		return a + uniform(b - a);
	}

	/**
	 * Returns a random real number uniformly in [a, b).
	 *
	 * @param a the left endpoint
	 * @param b the right endpoint
	 * @return a random real number uniformly in [a, b)
	 * @throws IllegalArgumentException unless {@code a < b}
	 */
	public static double uniform(double a, double b) {
		if (!(a < b)) {
			throw new IllegalArgumentException("invalid range: [" + a + ", " + b + ")");
		}
		return a + uniform() * (b - a);
	}

	/**
	 * @param m
	 * @param n
	 * @return random m-by-n matrix with values between 0 and 1
	 */
	public static double[][] random(int m, int n) {
		double[][] a = new double[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = uniform(0.0, 1.0);
			}
		}
		return a;
	}

}