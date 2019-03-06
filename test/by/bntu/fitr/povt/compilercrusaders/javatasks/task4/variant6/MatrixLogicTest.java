/* Unit tests for MatrixLogic class
 * Control task 4 variant 6
 * Author: Gilevskiy Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 */

package by.bntu.fitr.povt.compilercrusaders.javatasks.task4.variant6;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.bntu.fitr.povt.compilercrusaders.javatasks.task4.variant6.Matrix;
import by.bntu.fitr.povt.compilercrusaders.javatasks.task4.variant6.MatrixLogic;

public class MatrixLogicTest {
	
	private static MatrixLogic logic;
	
	@BeforeClass
	public static void setUp() {
		logic = new MatrixLogic();
	}
	
	@Test 
	public void isSymetric_symetricMatrix_true() {
		
		double[][] arrayOfArrays = {
				{2, 3, 2},
				{3, 1, 1},
				{2, 1, 6},
		};
		
		Matrix matrix = new Matrix(arrayOfArrays);
		
		Boolean condition = logic.isSymetric(matrix);
		
		Assert.assertTrue(condition);
	}
	
	@Test
	public void isSymetric_notSymetricMatrix_false() {
		
		double[][] arrayOfArrays = {
				{2, 3, 2},
				{3, 1, 3},
				{2, 1, 6},
		};
		
		Matrix matrix = new Matrix(arrayOfArrays);
		
		Boolean condition = logic.isSymetric(matrix);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void isSymetric_matrixRowNull_null() {
		
		double[][] arrayOfArrays = {
				{2, 3, 2},
				{3, 1, 3},
				null,
		};
		
		Matrix matrix = new Matrix(arrayOfArrays);
		
		Boolean condition = logic.isSymetric(matrix);
		
		Assert.assertNull(condition);
	}
	
	@Test
	public void isSymetric_matrixLengthZero_null() {
		
		double[][] arrayOfArrays = new double[0][0];
		
		Matrix matrix = new Matrix(arrayOfArrays);
		
		Boolean condition = logic.isSymetric(matrix);
		
		Assert.assertNull(condition);
	}
	
	@Test
	public void isSymetric_MatrixNull_null() {
		
		Matrix matrix = null;
		
		Boolean condition = logic.isSymetric(matrix);
		
		Assert.assertNull(condition);
	}
	
	@Test
	public void isSymetric_differentMatrixRowLengths_false() {
		
		double[][] arrayOfArrays = {
				{2, 3, 2},
				{3, 1},
				{2, 1, 6, 4},
		};
		
		Matrix matrix = new Matrix(arrayOfArrays);
		
		Boolean condition = logic.isSymetric(matrix);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void maxAtDiagonalsIndex_validMatrix_doubleArray() {
		
		double[][] arrayOfArrays = {
				{2, 3, 2},
				{3, 1, 1},
				{12, 1, 6},
		};
		Matrix matrix = new Matrix(arrayOfArrays);
		int[] expected = {2, 2};
		
		int[] actual = logic.maxAtDiagonalsIndex(matrix);
		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void maxAtDiagonalsIndex_matrixNotPrimeLength_null() {
		
		double[][] arrayOfArrays = {
				{2, 3, 2},
				{3, 1, 1},
				{2, 1, 6},
				{2, 1, 6},
		};
		Matrix matrix = new Matrix(arrayOfArrays);
		
		int[] actual = logic.maxAtDiagonalsIndex(matrix);
		
		Assert.assertNull(actual);
	}
	
	@Test
	public void maxAtDiagonalsIndex_matrixRowNull_null() {
		
		double[][] arrayOfArrays = {
				{2, 3, 2},
				null,
				{2, 1, 6},
		};
		Matrix matrix = new Matrix(arrayOfArrays);
		
		int[] actual = logic.maxAtDiagonalsIndex(matrix);
		
		Assert.assertNull(actual);
	}
	
	@Test
	public void maxAtDiagonalsIndex_MatrixNull_null() {
		
		Matrix matrix = null;
		
		int[] condition = logic.maxAtDiagonalsIndex(matrix);
		
		Assert.assertNull(condition);
	}
	
	@Test
	public void maxAtDiagonalsIndex_MatrixLengthZero_null() {
		
		Matrix matrix = new Matrix(new double[][]{});
		
		int[] condition = logic.maxAtDiagonalsIndex(matrix);
		
		Assert.assertNull(condition);
	}
	
	@Test
	public void swapElementWithCentralElement_validArgs_true() {
		
		double[][] arrayOfArrays = {
				{2, 3, 2},
				{3, 1, 1},
				{2, 1, 6},
		};
		Matrix actual = new Matrix(arrayOfArrays);
		int[] indexes = {0, 0};
		
		double[][] arrayOfArrays2 = {
				{1, 3, 2},
				{3, 2, 1},
				{2, 1, 6},
		};
		Matrix expected = new Matrix(arrayOfArrays2);
		
		logic.swapElementWithCentralElement(actual, indexes);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void swapElementWithCentralElement_matrixNull_false() {
		
		Matrix matrix = null;
		int[] indexes = {0, 0};

		
		Boolean condition = logic.swapElementWithCentralElement(matrix, indexes);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void swapElementWithCentralElement_indexesNull_false() {
		
		Matrix matrix = new Matrix(new double[][] {
			{1, 2, 3},
			{2, 3, 4},
			{4, 5, 6}
		});
		int[] indexes = null;

		
		Boolean condition = logic.swapElementWithCentralElement(matrix, indexes);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void swapElementWithCentralElement_matrixLengthNotPrime_false() {

		double[][] arrayOfArrays = {
				{2, 3, 2},
				{3, 1, 1},
				{2, 1, 6},
				{2, 1, 6},
		};
		Matrix matrix = new Matrix(arrayOfArrays);
		int[] indexes = {0, 0};
		
		Boolean condition = logic.swapElementWithCentralElement(matrix, indexes);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void swapElementWithCentralElement_indexesLengthMoreThanTwo_false() {

		double[][] arrayOfArrays = {
				{2, 3, 2},
				{3, 1, 1},
				{2, 1, 6},
		};
		Matrix matrix = new Matrix(arrayOfArrays);
		int[] indexes = {0, 0, 1};
		
		Boolean condition = logic.swapElementWithCentralElement(matrix, indexes);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void swapElementWithCentralElement_indexesLengthLessThanTwo_false() {

		double[][] arrayOfArrays = {
				{2, 3, 2},
				{3, 1, 1},
				{2, 1, 6},
		};
		Matrix matrix = new Matrix(arrayOfArrays);
		int[] indexes = {0};
		
		Boolean condition = logic.swapElementWithCentralElement(matrix, indexes);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void swapElementWithCentralElement_matrixLengthZero_false() {
		
		double[][] arrayOfArrays = new double[0][0];
		int[] indexes = {0, 0};
		
		Matrix matrix = new Matrix(arrayOfArrays);
		
		Boolean condition = logic.swapElementWithCentralElement(matrix, indexes);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void swapElementWithCentralElement_maxMatrixIndexLessThanFirstIndexInIndexesArray_false() {
		
		double[][] arrayOfArrays = new double[][] {
			{1, 2, 3},
			{3, 4, 5},
			{4, 5, 6}
		};
		int[] indexes = {5, 1};
		
		Matrix matrix = new Matrix(arrayOfArrays);
		
		Boolean condition = logic.swapElementWithCentralElement(matrix, indexes);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void swapElementWithCentralElement_maxMatrixIndexLessThanSecondIndexInIndexesArray_false() {
		
		double[][] arrayOfArrays = new double[][] {
			{1, 2, 3},
			{3, 4, 5},
			{4, 5, 6}
		};
		int[] indexes = {1, 5};
		
		Matrix matrix = new Matrix(arrayOfArrays);
		
		Boolean condition = logic.swapElementWithCentralElement(matrix, indexes);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void swapElementWithCentralElement_matrixRowNull_false() {
		
		double[][] arrayOfArrays = new double[][] {
			{1, 2, 3},
			{5, 6, 7},
			null
		};
		int[] indexes = {0, 0};
		
		Matrix matrix = new Matrix(arrayOfArrays);
		
		Boolean condition = logic.swapElementWithCentralElement(matrix, indexes);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void swapElementWithCentralElement_matrixRowsDifferentLengths_false() {
		
		double[][] arrayOfArrays = new double[][] {
			{1, 2, 3},
			{5, 6},
			{3, 5, 6, 7}
		};
		int[] indexes = {0, 0};
		
		Matrix matrix = new Matrix(arrayOfArrays);
		
		Boolean condition = logic.swapElementWithCentralElement(matrix, indexes);
		
		Assert.assertFalse(condition);
	}
}
