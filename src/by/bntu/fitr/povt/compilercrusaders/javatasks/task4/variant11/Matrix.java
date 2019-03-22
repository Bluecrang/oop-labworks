/* Matrix class
 * Control task 4 variant 6
 * Author: Gilevskiy Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 */

package by.bntu.fitr.povt.compilercrusaders.javatasks.task4.variant11;

import java.util.Arrays;

public class Matrix {
	
	public static final int DEFAULT_SIZE = 10;
	
	private double[][] matrix;

	public Matrix() {
		this.matrix = new double[DEFAULT_SIZE][DEFAULT_SIZE];
	}
	
	public Matrix(double[][] matrix) {
		
		this.matrix = matrix;
	}
	
	public Matrix(int size) {

		this.matrix = new double[size][size];
	}
	
	public Matrix(int rowCount, int columnCount) {

		this.matrix = new double[rowCount][columnCount];
	}
	
	public Matrix(Matrix matrix) {
		
		this.matrix = Arrays.copyOf(matrix.matrix, matrix.matrix.length);
		for (int i = 0; i < this.matrix.length; i++) {
			this.matrix[i] = Arrays.copyOf(matrix.matrix[i], matrix.matrix[i].length);
		}
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (double[] row : matrix) {
            StringBuilder sbRow = new StringBuilder("{");
            Object[] rowValues = new Object[row.length];
            for (int i = 0; i < row.length; i++) {
                sbRow.append(" %10.3f");
                rowValues[i] = row[i];
            }
            sbRow.append(" }");
            sb.append(String.format(sbRow.toString(), rowValues));
            sb.append('\n');
        }
        return sb.toString();
    }
}
