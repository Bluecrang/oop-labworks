/* logic for task 5a and 5b
 * laboratory work ¹12 - Java Multidimensional Arrays
 * version: 1.0
 * Author: Gilevskiy Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 26.12.2018
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.individual.task5ab.logic;

import java.util.ArrayList;
import java.util.List;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.individual.task5ab.exception.IndexException;

public class MatrixLogic {
	
	private double findMinInColumn(double[][] matrix, int columnIndex) {
		
		double min = matrix[0][columnIndex];
		for (double[] row : matrix) {
			double currentMin = row[columnIndex];
			if (currentMin < min) {
				min = currentMin;
			}
		}
		return min;
	}
	
	public void sortColumnsBySmallestElement(double[][] matrix) {
		
		if (matrix == null) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < matrix[0].length; i++) {
			
			for (int j = 1; j < matrix[0].length - i; j++) {
				
				if (findMinInColumn(matrix, j - 1) > findMinInColumn(matrix, j)) {
					
					for (int k = 0; k < matrix.length; k++) {
						 
						double temp = matrix[k][j - 1];
						matrix[k][j - 1] = matrix[k][j];
						matrix[k][j] = temp;
					}
				}
			}
		}
	}
	
	public List<Integer> findOrderedRowsIndexes(double[][] matrix) {
		
		if (matrix == null) {
			throw new IllegalArgumentException();
		}
		
		List<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < matrix.length; i++) {
			double[] row = matrix[i];
			if (checkOrdered(row)) {
				result.add(i);
			}
		}
		
		return result;
	}
	
	public double findMaxInRows(double[][] matrix, List<Integer> rowsIndexes) throws IndexException {
		
		if (matrix == null || matrix.length == 0 ||rowsIndexes == null || rowsIndexes.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		int firstIndex = rowsIndexes.get(0);
		
		try {
			double max = max(matrix[firstIndex]);
			for (int i = 1; i < rowsIndexes.size(); i++) {
				
				int index = rowsIndexes.get(i);
				double currentMax = max(matrix[index]);
				if (currentMax > max) {
					max = currentMax;
				}
			}
			return max;
		} catch (IndexOutOfBoundsException exception) {
			throw new IndexException("Illegal index in rowsIndexes list");
		}
	}
	
	private boolean checkOrdered(double[] vector) {
		
		boolean result = false;
		
		if (vector[0] > vector[1]) {
			
			double previous = vector[0];
			result = true;
			
			for (int i = 1; i < vector.length; i++) {
				
				if (previous > vector[i]) {
					previous = vector[i];
				} else {
					result = false;
					break;
				}
				
			}
		} else if (vector[0] < vector[1]) {
			
			double previous = vector[0];
			result = true;
			
			for (int i = 1; i < vector.length; i++) {
				
				if (previous < vector[i]) {
					previous = vector[i];
				} else {
					result = false;
					break;
				}
				
			}
		}
		return result;
	}
	
	private double max(double[] array) {
		
		double max = array[0];
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		
		return max;
	}
}
