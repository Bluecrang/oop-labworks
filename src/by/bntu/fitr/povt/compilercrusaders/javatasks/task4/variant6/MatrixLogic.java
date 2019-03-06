/* Matrix logic class
 * Control task 4 variant 6
 * Author: Gilevskiy Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 */

package by.bntu.fitr.povt.compilercrusaders.javatasks.task4.variant6;

public class MatrixLogic {
	
	private static final double EPSILON = 0.0001;
	
	public Boolean isSymetric(Matrix matrix) {
		
		if (matrix == null || matrix.getLength() == 0 || checkNullRows(matrix)) {
			return null;
		}
		
		if (!checkSquareMatrix(matrix)) {
			return false;
		}
		
		for (int i = 0; i < matrix.getLength(); i++) {
			for (int j = 0; j < matrix.getRow(i).length; j++) {
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
		
		if (matrix == null || matrix.getLength() == 0 || checkNullRows(matrix) || !checkSquareMatrix(matrix)) {
			return null;
		}
		
		int maxRowIndex = 0;
		int maxColumnIndex = 0;
		for (int i = 0; i < matrix.getLength(); i++) {
			if (matrix.getElement(maxRowIndex, maxColumnIndex) < matrix.getElement(i, i)) {
				maxRowIndex = i;
				maxColumnIndex = i;
			}
		}
		
		for (int i = 0; i < matrix.getLength(); i++) {
			for (int j = matrix.getRow(i).length - 1; j >= 0; j--) {
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
				matrix.getLength() == 0 ||  matrix.getLength() % 2 == 0 || checkNullRows(matrix) ||
				!checkSquareMatrix(matrix) || (matrix.getLength() - 1) < indexes[0] || (matrix.getRow(0).length - 1) < indexes[1]) {
			return false;
		}
		
		int rowIndex = indexes[0];
		int columnIndex = indexes[1];
		int halfLength = (matrix.getLength() - 1) / 2;
		double temp = matrix.getElement(rowIndex, columnIndex);
		matrix.setElement(rowIndex, columnIndex, matrix.getElement(halfLength, halfLength));
		matrix.setElement(halfLength, halfLength, temp);
		return true;
	}
	
	private boolean checkSquareMatrix(Matrix matrix) {
		
		for (int i = 0; i < matrix.getLength(); i++) {
			if (matrix.getLength() != matrix.getRow(i).length) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkNullRows(Matrix matrix) {
		for (int i = 0; i < matrix.getLength(); i++) {
			if (matrix.getRow(i) == null) {
				return true;
			}
		}
		
		return false;
	}
}
