/* Main class for lab11
 * laboratory work ¹11 - Java One-dimensional Arrays
 * version: 1.0
 * Authors: Gilevskiy Denis Alexandrovich, Kitaiharodski Pavel
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 20.12.2018
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.individual.task5.controller;

import java.util.InputMismatchException;
import java.util.Random;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab10.extratask.util.KeyboardInput;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.individual.task5.exception.VectorException;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.individual.task5.logic.VectorLogic;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.view.Printer;

public class Controller {

	private static final int MAX_RANDOM_NUM = 100;
	private static final int MIN_RANDOM_NUM = -100;
	private static final int MAX_RANDOM_ARRAY_LENGTH_MINUS_ONE = 19;
	
	public static void main(String[] args) {
		
		KeyboardInput input = new KeyboardInput();
		Printer printer = new Printer();
		Random random = new Random();
		VectorLogic logic = new VectorLogic();
		
		boolean active = true;
		
		printer.println("***VECTOR CALCULATOR***");
		
		start: while (active) {
			
			printer.println("Choose command:");
			printer.println("1 - use random input");
			printer.println("2 - use console input");
			printer.println("3 - EXIT");
			int inputChoice;
			try {
				inputChoice = input.nextInt();
			} catch (InputMismatchException e) {
				printer.println(e.getMessage());
				continue;
			}
			
			int vectorLength;
			double[] vector;
			
			switch(inputChoice) {
			
			case 1: {
				
				vectorLength = random.nextInt(MAX_RANDOM_ARRAY_LENGTH_MINUS_ONE) + 1;
				printer.println("vector length is " + vectorLength);
				
				vector = new double[vectorLength];
				for (int i = 0; i < vector.length; i++) {
					vector[i] = (MAX_RANDOM_NUM - MIN_RANDOM_NUM) * random.nextDouble() + MIN_RANDOM_NUM;
				}
				break;
			}
			
			case 2: {
				try {
					printer.println("Input vector length in range(1, 100): ");
					vectorLength = input.nextIntInRange(1, 100);
					printer.println("vector length is " + vectorLength);
					
					vector = new double[vectorLength];
					
					for (int i = 0; i < vector.length; i++) {
						printer.println("enter number " + (i + 1) + ": ");
						vector[i] = input.nextDouble();
					}
				} catch (InputMismatchException e) {
					printer.println(e.getMessage());
					continue;
				}

				break;
			}
			
			case 3: {
				break start;
			}
			
			default: {
				printer.println("Unknown command");
				continue;
			}
			}
			
			printer.println("Resulting vector:");
			for (int i = 0; i < vector.length; i++) {
				printer.println(Double.toString(vector[i]));
			}
			printer.println("\n");
			try {
				double maxAbs = logic.maxAbs(vector);
				printer.println("max absolute element: " + maxAbs);
				double sumBetweenPositive = logic.sumBetweenPositiveElements(vector, 1, 2);
				printer.println("sum of elements between first two positive numbers: " + sumBetweenPositive);
			} catch (VectorException e) {
				printer.println(e.getMessage());
				continue;
			}
		}
		
	}
}
