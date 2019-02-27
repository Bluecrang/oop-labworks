/* unit tests for MatrixLogic class
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

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.individual.task5ab.exception.IndexException;

public class MatrixLogicTest {

	private static MatrixLogic logic;
	
	@BeforeClass
	public static void setUp() {
		logic = new MatrixLogic();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void sortColumnsBySmallestElement_matrixNull_IllegalArgumentException() {
		
		double[][] matrix = null;
		
		logic.sortColumnsBySmallestElement(matrix);
	}
	
	@Test
	public void sortColumnsBySmallestElement_validMatrix_void() {
		
		double[][] matrix = {
				{1,   5,  2},
				{3,  -4, -13},
				{-10, 3,  8}};
		double[][] expecteds = {
				{2,   1,   5},
				{-13, 3,  -4},
				{8,  -10,  3}}; 
		
		logic.sortColumnsBySmallestElement(matrix);
		
		Assert.assertArrayEquals(expecteds, matrix);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findOrderedRowsIndexes_matrixNull_IllegalArgumentException() {
		
		double[][] matrix = null;
		
		logic.findOrderedRowsIndexes(matrix);
	}
	
	@Test
	public void findOrderedRowsIndexes_severalOrderedRows_listInteger() {
		
		double[][] matrix = {
				{1,   5,  2},
				{5,   5,  5},
				{3,  -4, -13},
				{-10, 3,  8}};
		List<Integer> expected = new ArrayList<>();
		expected.add(2);
		expected.add(3);
		
		List<Integer> actual = logic.findOrderedRowsIndexes(matrix);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void findOrderedRowsIndexes_noOrderedRows_emptyList() {
		
		double[][] matrix = {
				{1,   5,  2},
				{3,  -4,  13},
				{-10, 3,  -3}};
		List<Integer> expected = new ArrayList<>();
		
		List<Integer> actual = logic.findOrderedRowsIndexes(matrix);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findMaxInRows_matrixNull_IllegalArgumentException() {
		
		double[][] matrix = null;
		List<Integer> rowIndexes = new ArrayList<>();
		
		logic.findMaxInRows(matrix, rowIndexes);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findMaxInRows_rowIndexesNull_IllegalArgumentException() {
		
		double[][] matrix = {
				{1,   5,  2},
				{3,  -4,  13},
				{-10, 3,  -3}};
		List<Integer> rowIndexes = null;
		
		logic.findMaxInRows(matrix, rowIndexes);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findMaxInRows_rowIndexesEmpty_IllegalArgumentException() {
		
		double[][] matrix = {
				{1,   5,  2},
				{3,  -4,  13},
				{-10, 3,  -3}};
		List<Integer> rowIndexes = new ArrayList<>();
		
		logic.findMaxInRows(matrix, rowIndexes);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findMaxInRows_arrayLengthZero_IllegalArgumentException() {
		
		double[][] matrix = {};
		List<Integer> rowIndexes = new ArrayList<>();
		rowIndexes.add(1);
		
		logic.findMaxInRows(matrix, rowIndexes);
	}
	
	@Test(expected = IndexException.class)
	public void findMaxInRows_indexTooBig_IndexException() {
		
		double[][] matrix = {
				{1,   5,  2},
				{3,  -4,  13},
				{-10, 3,  -3}};
		List<Integer> rowIndexes = new ArrayList<>();
		rowIndexes.add(5);
		
		logic.findMaxInRows(matrix, rowIndexes);
	}
	
	@Test(expected = IndexException.class)
	public void findMaxInRows_negativeIndex_IndexException() {
		
		double[][] matrix = {
				{1,   5,  2},
				{3,  -4,  13},
				{-10, 3,  -3}};
		List<Integer> rowIndexes = new ArrayList<>();
		rowIndexes.add(-5);
		
		logic.findMaxInRows(matrix, rowIndexes);
	}
	
	@Test
	public void findMaxInRows_legalInput_double() {
		
		double[][] matrix = {
				{1,   5,  2},
				{3,  -4,  13},
				{-10, 3,  15},
				{-5,  6,  3}};
		List<Integer> rowIndexes = new ArrayList<>();
		rowIndexes.add(1);
		rowIndexes.add(2);
		rowIndexes.add(3);
		double expected = -1;
		
		double actual = logic.findMaxInRows(matrix, rowIndexes);
		
		Assert.assertEquals(expected, actual, 0.0001);
	}
}
