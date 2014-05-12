package neuralNetwork;

import java.util.ArrayList;
import java.util.List;

// LAYER: A layer is a set of neurons ( really a List in java ). It has also 
// a layer position, that is the position of the current layer in the network.
// For example the input layer has the position 0.

public class Layer {
	
	private List<Neuron> neurons;
	private Integer numberOfNeurons;
	private Integer layerPosition;
	
	// Constructor
	public Layer(Integer numberOfNeurons, Integer layerPosition){
		if(numberOfNeurons <= 0){
			throw new IllegalArgumentException("Layer (Constructor): the number of neurons in a layer can't be less than 1.");
		}
		if(layerPosition < 0 && numberOfNeurons < 0){
			throw new IllegalArgumentException("Layer (Constructor): the layer position cant be less than 0.");
		}
		
		
		if (layerPosition.equals(-1)) {
			
			this.numberOfNeurons = 1;
			this.layerPosition = -1;
			this.neurons = new ArrayList<Neuron>();
			neurons.add(NeuralNetwork.getN0());
			
		} else {
			
			this.numberOfNeurons = numberOfNeurons;
			this.layerPosition = layerPosition;
			this.neurons = new ArrayList<Neuron>();

			// Generating the number of required neurons as indicate by
			// parameter.
			int i = 0;
			while (i < numberOfNeurons) {
				Neuron neuron = new Neuron();
				neurons.add(neuron);
				i++;
			}

		}
		
		
	}

	public List<Neuron> getNeurons() {
		return neurons;
	}

	public Integer getNumberOfNeurons() {
		return numberOfNeurons;
	}

	public Integer getLayerPosition() {
		return layerPosition;
	}
	
	
	
}
