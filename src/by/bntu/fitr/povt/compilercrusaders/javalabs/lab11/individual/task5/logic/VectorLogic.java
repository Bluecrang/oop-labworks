/* logic for individual task 5
 * laboratory work ¹11 - Java One-dimensional Arrays
 * version: 1.0
 * Authors: Gilevskiy Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 18.02.2019
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.individual.task5.logic;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.individual.task5.exception.VectorException;

public class VectorLogic {
	

	public double maxAbsBetweenPositiveElements(double[] vector, int number1, int number2) throws VectorException{
		
		if (vector == null || number1 <= 0 || number2 <= 0 || number1 >= number2) {
			throw new IllegalArgumentException();
		}
		
		int firstPositiveIndex = findPositiveIndex(vector, number1);
		
		int secondPositiveIndex = findPositiveIndex(vector, number2);
		
		if (Math.abs(firstPositiveIndex - secondPositiveIndex) == 1) {
			throw new VectorException("There are no elements between positive elements");
		}
		
		double maxAbs = Math.abs(vector[firstPositiveIndex + 1]);
		
		for (int i = firstPositiveIndex + 2; i < secondPositiveIndex; i++) {
			
			double currentAbs = Math.abs(vector[i]);
			
			if (maxAbs < currentAbs) {
				maxAbs = currentAbs;
			}
		}
		
		return maxAbs;
	}
	
	public double sumBetweenPositiveElements(double[] vector, int number1, int number2) throws VectorException{
		
		if (vector == null || number1 <= 0 || number2 <= 0 || number1 >= number2) {
			throw new IllegalArgumentException();
		}
		
		int firstPositiveIndex = findPositiveIndex(vector, number1);
		
		int secondPositiveIndex = findPositiveIndex(vector, number2);
		
		if (Math.abs(firstPositiveIndex - secondPositiveIndex) == 1) {
			throw new VectorException("There are no elements between positive elements");
		}
		
		double sum = 0;
		for (int i = firstPositiveIndex + 1; i < secondPositiveIndex; i++) {
			sum += vector[i];
		}
		
		return sum;
	}
	
	public int findPositiveIndex(double[] vector, int number) throws VectorException {
		
		if (vector == null || number < 0) {
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
