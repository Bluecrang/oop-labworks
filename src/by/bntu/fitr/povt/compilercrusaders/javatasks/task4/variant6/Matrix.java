/* Matrix class
 * Control task 4 variant 6
 * Author: Gilevskiy Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 */

package by.bntu.fitr.povt.compilercrusaders.javatasks.task4.variant6;

import java.util.Arrays;

public class Matrix {
	
	private double[][] matrix;

	public Matrix(double[][] matrix) {
		
		if (matrix == null) {
			matrix = new double[][]{};
		}
		
		this.matrix = matrix;
	}
	
	public double[] getRow(int index) {
		
		if (matrix.length - 1 < index) {
			return null;
		}
		
		return matrix[index];
	}
	
	public Double getElement(int row, int column) {

		if (matrix.length == 0 || matrix.length - 1 < row || matrix[row] == null || matrix[row].length - 1 < column) {
			return null;
		}
		
		return matrix[row][column];
	}
	
	public boolean setElement(int row, int column, double element) {
		
		if (matrix.length == 0 || matrix.length - 1 < row || matrix[row] == null || matrix[row].length - 1 < column) {
			return false;
		}
		
		matrix[row][column] = element;
		return true;
	}
	
	public int getLength() {
		return matrix.length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(matrix);
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
		Matrix other = (Matrix) obj;
		if (!Arrays.deepEquals(matrix, other.matrix))
			return false;
		return true;
	}
	
}
