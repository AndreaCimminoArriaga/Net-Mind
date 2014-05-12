package proben1;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import main.Main;

// TrainingMetrics: This class contains all the formulas described in the paper PROBEN1

public class TrainingMetrics {
	
	// This attribute will contain the squared error of all the examples of the training set
	// over an epoch. 
	public static List<Double> squaredErrorsForAnEpochOfTrainingSet = new ArrayList<Double>();
	// This attribute will contain the mean squared error of the validation set when the
	// epoch coincides with the STRIP.
	public static List<Double> Evas = new ArrayList<Double>();
	
	// Basic Formula to calculate a squared error
	public static Double squaredError(Collection<Double> outputs, List<Double> target){
		Double sum = 0.0;
		int i= 0;
		for(Double out:outputs){
			Double targetOutput = target.get(i);
			if(!Main.output_initialized && targetOutput > Main.O_MAX){
				Main.O_MAX = targetOutput;
			}
			if(!Main.output_initialized && targetOutput < Main.O_MIN){
				Main.O_MIN = targetOutput;
			}
			sum += Math.pow((out - targetOutput),2);
		}
		return sum;
	}
	
	// Formula only for training set to calculate the mean squared error.
	public static Double meanSquaredErrorForTrainingSet(Integer numberOfOutputsNeuron, Integer numberOfExamples){
		Double sum = 0.0;
		Double factor_one = (Main.O_MAX - Main.O_MIN) / (numberOfOutputsNeuron * numberOfExamples);
		for(Double error: squaredErrorsForAnEpochOfTrainingSet){
			// Calculating statistics.
			sum += error;
		}
		Double result = 100*factor_one*sum;
		if(result < Statistics.minimumMeanSquaredErrorOnTraining)
			Statistics.minimumMeanSquaredErrorOnTraining = result;
		return result;
	}
	
	// Basic Formula to calculate the meanSquaredError.
	public static Double meanSquaredError(List<Double> squaredErrors,Integer numberOfOutputsNeuron, Integer numberOfExamples){
		Double sum = 0.0;
		Double factor_one = (Main.O_MAX - Main.O_MIN) / (numberOfOutputsNeuron * numberOfExamples);
		for(Double error: squaredErrors){
			
			sum += error;
		}
		return 100*factor_one*sum;
	}
	
	// Formula to calculate the parameter Eopt.
	public static Double Eopt(){
		Double Eopt = Evas.get(0);
		for(Double Eva: Evas){
			if(Eva < Eopt){
				Eopt = Eva;
			}
		}
		return Eopt;
		
	}
	
	// Formula to calculate the parameter Gl.
	public static Double Gl(Double Eva, Double Eopt){
		return 100*((Eva/Eopt) -1 );
	}
	
	// Formula to calculate the parameter Pk.
	public static Double Pk(List<Double> Etrs){
		Double etrMin = Etrs.get(0);
		Double sum = 0.0;
		for(Double etr: Etrs){
			if(etr < etrMin){
				etrMin = etr;
			}
			sum += etr;
		}
		return 1000*((sum / (Main.STRIP * etrMin)) -1 );
	}
	
	

	
}