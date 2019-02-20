/* logic for individual task 5
 * laboratory work ¹11 - Java One-dimensional Arrays
 * version: 1.1
 * Authors: Gilevskiy Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 18.02.2019
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.individual.task5.logic;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.individual.task5.exception.VectorException;

public class VectorLogic {
	

	public double maxAbs(double[] vector){
		
		if (vector == null || vector.length < 1) {
			throw new IllegalArgumentException();
		}
		
		double maxAbs = vector[0];
		
		for (int i = 1; i < vector.length; i++) {
			
			if (Math.abs(maxAbs) < Math.abs(vector[i])) {
				maxAbs = vector[i];
			}
		}
		
		return maxAbs;
	}
	
	public double sumBetweenPositiveElements(double[] vector, int number1, int number2) throws VectorException{
		
		if (vector == null || number1 <= 0 || number2 <= 0 || number1 >= number2 || vector.length < 1) {
			throw new IllegalArgumentException();
		}
		
		int firstPositiveIndex = findPositiveIndex(vector, number1);
		
		int secondPositiveIndex = findPositiveIndex(vector, number2);
		
		if (Math.abs(firstPositiveIndex - secondPositiveIndex) == 1) {
			throw new VectorException("There are no elements between chosen positive elements");
		}
		
		double sum = 0;
		for (int i = firstPositiveIndex + 1; i < secondPositiveIndex; i++) {
			sum += vector[i];
		}
		
		return sum;
	}
	
	public int findPositiveIndex(double[] vector, int number) throws VectorException {
		
		if (vector == null || number < 0 || vector.length < 1) {
			throw new IllegalArgumentException();
		}
		
		int count = 1;
		
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] > 0) {
				if (count == number) {
					return i;
				} else {
					count++;
				}
			}
		}
		
		throw new VectorException("Unable to find index of positive element number " + number);
	}
}
