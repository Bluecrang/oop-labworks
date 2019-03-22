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

import by.bntu.fitr.povt.compilercrusaders.javatasks.task4.variant6.entity.impl.ArrayMatrix;
import by.bntu.fitr.povt.compilercrusaders.javatasks.task4.variant6.logic.MatrixLogic;

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
		
		ArrayMatrix matrix = new ArrayMatrix(arrayOfArrays);
		
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
		
		ArrayMatrix matrix = new ArrayMatrix(arrayOfArrays);
		
		Boolean condition = logic.isSymetric(matrix);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void isSymetric_matrixLengthZero_null() {
		
		double[][] arrayOfArrays = new double[0][0];
		
		ArrayMatrix matrix = new ArrayMatrix(arrayOfArrays);
		
		Boolean condition = logic.isSymetric(matrix);
		
		Assert.assertNull(condition);
	}
	
	@Test
	public void isSymetric_MatrixNull_null() {
		
		ArrayMatrix matrix = null;
		
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
		
		ArrayMatrix matrix = new ArrayMatrix(arrayOfArrays);
		
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
		ArrayMatrix matrix = new ArrayMatrix(arrayOfArrays);
		int[] expected = {2, 2};
		
		int[] actual = logic.findIdexesOfMaxAtDiagonals(matrix);
		
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
		ArrayMatrix matrix = new ArrayMatrix(arrayOfArrays);
		
		int[] actual = logic.findIdexesOfMaxAtDiagonals(matrix);
		
		Assert.assertNull(actual);
	}
	
	@Test
	public void maxAtDiagonalsIndex_MatrixNull_null() {
		
		ArrayMatrix matrix = null;
		
		int[] condition = logic.findIdexesOfMaxAtDiagonals(matrix);
		
		Assert.assertNull(condition);
	}
	
	@Test
	public void maxAtDiagonalsIndex_MatrixLengthZero_null() {
		
		ArrayMatrix matrix = new ArrayMatrix(new double[][]{});
		
		int[] condition = logic.findIdexesOfMaxAtDiagonals(matrix);
		
		Assert.assertNull(condition);
	}
	
	@Test
	public void swapElementWithCentralElement_validArgs_true() {
		
		double[][] arrayOfArrays = {
				{2, 3, 2},
				{3, 1, 1},
				{2, 1, 6},
		};
		ArrayMatrix actual = new ArrayMatrix(arrayOfArrays);
		int[] indexes = {0, 0};
		
		double[][] arrayOfArrays2 = {
				{1, 3, 2},
				{3, 2, 1},
				{2, 1, 6},
		};
		ArrayMatrix expected = new ArrayMatrix(arrayOfArrays2);
		
		logic.swapElementWithCentralElement(actual, indexes);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void swapElementWithCentralElement_matrixNull_false() {
		
		ArrayMatrix matrix = null;
		int[] indexes = {0, 0};

		
		Boolean condition = logic.swapElementWithCentralElement(matrix, indexes);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void swapElementWithCentralElement_indexesNull_false() {
		
		ArrayMatrix matrix = new ArrayMatrix(new double[][] {
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
		ArrayMatrix matrix = new ArrayMatrix(arrayOfArrays);
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
		ArrayMatrix matrix = new ArrayMatrix(arrayOfArrays);
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
		ArrayMatrix matrix = new ArrayMatrix(arrayOfArrays);
		int[] indexes = {0};
		
		Boolean condition = logic.swapElementWithCentralElement(matrix, indexes);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void swapElementWithCentralElement_matrixLengthZero_false() {
		
		double[][] arrayOfArrays = new double[0][0];
		int[] indexes = {0, 0};
		
		ArrayMatrix matrix = new ArrayMatrix(arrayOfArrays);
		
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
		
		ArrayMatrix matrix = new ArrayMatrix(arrayOfArrays);
		
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
		
		ArrayMatrix matrix = new ArrayMatrix(arrayOfArrays);
		
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
		
		ArrayMatrix matrix = new ArrayMatrix(arrayOfArrays);
		
		Boolean condition = logic.swapElementWithCentralElement(matrix, indexes);
		
		Assert.assertFalse(condition);
	}
}
