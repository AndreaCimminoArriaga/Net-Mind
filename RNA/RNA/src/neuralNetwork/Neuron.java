package neuralNetwork;

import java.util.List;


// NEURON: We can say this class is the cell of our project. 
// It's the neuron like appears explain in the paper of the 
// work. Has a number that works like an id, and receives an entry
// that process and save in the variable called state.

public class Neuron {
	// Count the neurons than have been created.
	private static int numberS = -1;
	// Id of the actual neuron.
	private int number;
	// Is the state of the neuron after process the data in the entry.
	private double state;

	//Constructor
	@SuppressWarnings("static-access")
	public Neuron() {
		this.numberS += 1;
		this.number = this.numberS;
		this.state = -1;
	}
	
	public int getNumber() {
		return number;
	}

	public Double getState() {
		return state;
	}

	public void setState(Double state) {
		this.state = state;
	}
	
	public static int numberOfNeuronsCreated() {
		return numberS;

	}

	// This method receives the weights and the outputs of the other neurons and
	// calculates the output of the current neuron.
	public void inputFunction(List<Double> values, List<Double> weights) {
		if (values.size() != weights.size()) {
			throw new IllegalArgumentException("Neuron " + this.number
					+ " : weights size different from values size");
		}
		
		if( number > 0){
		
			Double value = null;
			Double weight = null;
			int i = 0;
			Double output = 0.0;

			while (i < values.size()) {
				value = values.get(i);
				weight = weights.get(i);
				output += (value * weight);
				i++;
			}
			this.state = sigmoid(output);
			
		}else{
			this.state = -1;
		}
	}

	// Activation Function, use before in the previous function.
	private Double sigmoid(Double input) {
		Double result = 1 + Math.exp((-1.0) * input);

		if (result.equals(0.0)) {
			throw new IllegalArgumentException("Neuron " + this.number
					+ " : In sigmoid function has 1 divided by 0");
		}

		return (1 / result);
	}

	//Other Methods.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Neuron other = (Neuron) obj;
		if (number != other.number)
			return false;
		return true;
	}

}
