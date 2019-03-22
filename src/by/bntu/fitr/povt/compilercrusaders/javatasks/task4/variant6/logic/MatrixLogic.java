/* Matrix logic class
 * Control task 4 variant 6
 * Author: Gilevskiy Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 */

package by.bntu.fitr.povt.compilercrusaders.javatasks.task4.variant6.logic;

import by.bntu.fitr.povt.compilercrusaders.javatasks.task4.variant6.entity.Matrix;

public class MatrixLogic {
	
	private static final double EPSILON = 0.0001;
	
	public Boolean isSymetric(Matrix matrix) {
		
		if (matrix == null || matrix.getRowCount() == 0) {
			return null;
		}
		
		if (!checkSquareMatrix(matrix)) {
			return false;
		}
		
		for (int i = 0; i < matrix.getRowCount(); i++) {
			for (int j = 0; j < matrix.getRowLength(i); j++) {
				if (!(i == j)) {
					if (!(matrix.getElement(i, j) - matrix.getElement(j, i) < EPSILON)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public int[] maxAtDiagonalsIndex(Matrix matrix) {
		
		if (matrix == null || matrix.getRowCount() == 0 || !checkSquareMatrix(matrix)) {
			return null;
		}
		
		int maxRowIndex = 0;
		int maxColumnIndex = 0;
		for (int i = 0; i < matrix.getRowCount(); i++) {
			if (matrix.getElement(maxRowIndex, maxColumnIndex) < matrix.getElement(i, i)) {
				maxRowIndex = i;
				maxColumnIndex = i;
			}
		}
		
		for (int i = 0; i < matrix.getRowCount(); i++) {
			for (int j = matrix.getRowLength(i) - 1; j >= 0; j--) {
				if (matrix.getElement(maxRowIndex, maxColumnIndex) < matrix.getElement(i, j)) {
					maxRowIndex = i;
					maxColumnIndex = i;
				}
			}
		}
		return new int[] {maxRowIndex, maxColumnIndex};
	}
	
	public boolean swapElementWithCentralElement(Matrix matrix, int[] indexes) {
		
		if (matrix == null || indexes == null || indexes.length != 2 || 
				matrix.getRowCount() == 0 ||  matrix.getRowCount() % 2 == 0 ||
				!checkSquareMatrix(matrix) || (matrix.getRowCount() - 1) < indexes[0] || (matrix.getRowLength(0)- 1) < indexes[1]) {
			return false;
		}
		
		int rowIndex = indexes[0];
		int columnIndex = indexes[1];
		int halfLength = (matrix.getRowCount() - 1) / 2;
		double temp = matrix.getElement(rowIndex, columnIndex);
		matrix.setElement(rowIndex, columnIndex, matrix.getElement(halfLength, halfLength));
		matrix.setElement(halfLength, halfLength, temp);
		return true;
	}
	
	private boolean checkSquareMatrix(Matrix matrix) {
		
		for (int i = 0; i < matrix.getRowCount(); i++) {
			if (matrix.getRowCount() != matrix.getRowLength(i)) {
				return false;
			}
		}
		
		return true;
	}
}
