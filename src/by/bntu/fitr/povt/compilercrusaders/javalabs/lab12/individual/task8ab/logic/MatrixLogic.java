/* logic for task 8a and 8b
 * laboratory work ¹12 - Java Multidimensional Arrays
 * version: 1.0
 * Author: Kitaigarodski Pavel Sergeevich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 27.02.2019
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.individual.task8ab.logic;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.view.Printer;

public class MatrixLogic {
	
	public double findMaxInRow(double[][] matrix, int rowIndex) {
		
		if (matrix == null || rowIndex < 0) {
			throw new IllegalArgumentException();
		}
		
		double max = matrix[rowIndex][0];
		for (int i = 0; i < matrix[0].length ; i++) {
			if (matrix[rowIndex][i] > max) {
				max = matrix[rowIndex][i];
			}
		}
		return max;
	}
	
	public double[][] multiplyMatrix(double[][] matrix1, double[][] matrix2) {
		
		if (matrix1 == null || matrix2 == null) {
			throw new IllegalArgumentException();
		}
		double[][] resMatrix = new double [matrix1.length][matrix1[0].length];
		for (int i = 0; i < matrix1.length; i++) {
			double max = findMaxInRow(matrix2, i);
			for (int j = 0; j < matrix1[0].length; j++) {
				resMatrix[i][j] = matrix1[i][j] * max;
			}
		}
		return resMatrix;
	}
	
	public boolean findDuplicate(double[][] matrix, double number){
		int count = 0;
		boolean result;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (number == matrix[i][j]) {
					count++;
				}
			}
		}
		if (count > 1) {
			result = true;
		}
		else {
			result = false;
		}
		return result;
	}
	
	public double findMaxWithDuplicateInMatrix(double[][] matrix) {
		Printer print = new Printer();
		if (matrix == null) {
			throw new IllegalArgumentException();
		}
		boolean flag = true;
		double max = matrix[0][0];
		for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (max <= matrix[i][j] && findDuplicate(matrix, matrix[i][j])){
						max = matrix[i][j];
						flag = false;
					}
				}
		}
		if (flag) {
			max = 0;
			print.println("there are no duplicates");
		}
		return max;
	}
}