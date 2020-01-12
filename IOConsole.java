import java.util.Scanner;

public class IOConsole extends IOManager{
	String inputInstructions = "";

	IOConsole(String instructions) {
		inputInstructions = instructions;
	}

	/**
	 * determine what to do when runDriver() is called, repeated until returns true
	 * @return return false to exit training loop or true to run nextStep() again
	 */
	public boolean nextStep() {
		System.out.print("\nOptions:\n - " + inputInstructions + "\n - Enter num > 0 to train"
				+ "\n - Enter \"%\" and a number from 0 - 100 to train until the given percent accuracy"
				+ "\n - Enter \"0\" to save NeuralNet\n - Enter -1 to end training"
				+ "\nEnter input: ");
		String input = getInput();
		if (input.equals("-1"))
			return false;
		if (input.equals("0")) {
			System.out.println(save() ? "file saved" : "error saving file");
		}
		else if (input.matches("\\d+"))
			trainByRounds(Integer.parseInt(input));
		else if(input.charAt(0) == '%') {
			double parsed = 0;
			try {
				parsed = Double.parseDouble(input.substring(1));
			}
			catch (Exception e) {
				System.out.println("invalid input");
				return true;
			}
			trainByAccuracy(parsed);
		}
		else
			testInput(input);
		return true;
	}

	private String getInput()
	{
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		reader.useDelimiter("\n");
		String input = "";
		try {
			input += reader.next();
		}
		catch (Exception e)	{
			System.out.println(e);
		}
		return input;
	}

	public void invalidInput() {
		System.out.println("Invalid Input");
	}

	//different printing formats, some of these are used, but could be helpful ways to 
	//display information at some point

	public void dispEpochTrainByRound(int trainingRound, double[][] input, double[][] a1, double[][] a2, 
			double[][] expected, double[][] w1, double[][] w2, double[][] b1, double[][] b2) {
		String output = "";
		output+="\n======Epoch " + trainingRound + "========\n";
		System.out.println(output);
	}

	public void dispEpochTrainByAccuracy(int trainingRound, double[][] input, double[][] a1, double[][] a2, 
			double[][] expected, double[][] w1, double[][] w2, double[][] b1, double[][] b2) {
		String output = "";
		output+="\n======Epoch " + trainingRound + "========\n accuracy: %" + getAccuracy() + "\n";
		System.out.println(output);
	}

	public void dispFinal(int trainingRound, double[][] input, double[][] a1, double[][] a2, double[][] expected, double[][] w1, double[][] w2, 
			double[][] b1, double[][] b2)
	{
		double[][] transposeA = MatrixMath.transpose(a2);
		double[][] transposeInput = MatrixMath.transpose(input);

		double accuracy = getAccuracy();
		String output = "";

		output+=("======Final Result Rounded========\n");
		output+=("Predictions: \n");
		for(int j = 0; j < transposeA.length; j++)
		{
			double[] str = new double[transposeInput[0].length];
			output+=("[");
			for(int i1 = 0; i1 < transposeInput[0].length;i1++)
				str[i1] = (int)(transposeInput[j][i1]);
			output+=(unparseData(str) + ", ");
			output = output.substring(0,output.length() - 2);
			output+=("] -> ");
			output+=("[");
			String language = "";
			language = dispOutputResults(transposeA[j]);
			output+=(language + ", ");
			output = output.substring(0,output.length() - 2);
			output+=("]\n");
		} 
		output+=("Accuracy = " + accuracy + "%\n");
		System.out.println(output);
	}

	public void dispResults(String input, double[] odds) {
		if (input.length() > 40)
			input = input.substring(0,40) + "...";

		String toAdd = "";
		for(int i = 0; i < input.toCharArray().length; i++)
			toAdd += "-";

		String output = "\n\n-----------------------------------------------" + toAdd
				+ "\n===================input: " + input +" ===================\n";
		output+="[" + input + "] -> [" + dispOutputResults(odds) + "]"
				+"\n-----------------------------------------------" + toAdd;
		System.out.println(output);
	}

	public boolean shouldLoadData() {
		System.out.print("Load Data (y = yes, n = no): ");
		String input = getInput();
		if (input.equals("y"))
			return true;
		return false;
	}



	private String dispOutputResults(double[] result)
	{
		String[] names = getNames();
		int[] odds = new int[result.length];
		for(int i = 0; i < result.length; i++)
			odds[i] = (int)(result[i]*100);
		String output = "";
		for(int i = 0; i < odds.length; i++)
			output += ", " + names[i] + ": " + odds[i] + "%";
		output = output.substring(2);
		return output;
	}

	public void loadSuccess(boolean success) {
		System.out.println(success ? "load successful" :
				"load unsuccess");		
	}
}
