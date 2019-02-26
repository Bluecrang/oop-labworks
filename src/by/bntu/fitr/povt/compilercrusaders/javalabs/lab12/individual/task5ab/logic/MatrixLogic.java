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

public class MatrixLogic {
	
	public double findMinInColumn(double[][] matrix, int columnIndex) {
		
		if (matrix == null || columnIndex < 0) {
			throw new IllegalArgumentException();
		}
		
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
	
	public List<Integer> findOrderedRows(double[][] matrix) {
		
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
	
	public double findMaxInOrderedRows(double[][] matrix, List<Integer> rowsIndexes) {
		
		if (matrix == null || rowsIndexes == null || rowsIndexes.isEmpty()) {
			throw new IllegalArgumentException();
		}
		int firstIndex = rowsIndexes.get(0);
		
		double max = Math.max(matrix[firstIndex][0], matrix[firstIndex][matrix[firstIndex].length - 1]);
		
		if (rowsIndexes.size() == 1) {
			return max;
		}
		
		for (int i = 1; i < rowsIndexes.size(); i++) {
			
			int index = rowsIndexes.get(i);
			double currentMax = Math.max(matrix[index][0], matrix[index][matrix[index].length - 1]);
			
			if (currentMax > max) {
				max = currentMax;
			}
		}
		
		return max;
	}
	
	public boolean checkOrdered(double[] vector) {
		
		if (vector == null || vector.length < 1) {
			throw new IllegalArgumentException();
			
		} else if (vector.length == 1) {
			return true;
			
		}
		
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
}
