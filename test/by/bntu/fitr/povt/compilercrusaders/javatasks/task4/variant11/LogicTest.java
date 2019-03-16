package by.bntu.fitr.povt.compilercrusaders.javatasks.task4.variant11;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import by.bntu.fitr.povt.compilercrusaders.javatasks.task4.variant6.Matrix;

class LogicTest {
	private Logic logic = new Logic();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCleanMax() {
		double [][] array = {
				{1, 2, 3},
				{2, 1, 3}};
		double [][] expected = {
				{0.0, 2, 3},
				{2, 1, 0.0}};
		int[][] clean = {
				{0, 0},
				{1, 2}
				};
		Matrix matrix = new Matrix(array);
		Matrix matrix2 = new Matrix(expected);
		logic.cleanMax(matrix, clean);
		Assert.assertEquals(matrix, matrix2);
	}
	
	@Test
	void symmetricTestNegative() {
		double [][] falseArray = {
						{1, 2, 3},
						{2, 1, 3},
						{6, 6, 6}};
		Matrix matrix = new Matrix(falseArray);
		Assert.assertEquals(false, logic.isSymmetric(matrix));
	}
	
	@Test
	void symmetricTestPositive() {
		double [][]  trueArray = {
								  {1, 2, 3},
								  {2, 4, 7},
								  {3, 7, 0}
								  		};
		Matrix matrix = new Matrix(trueArray);
		Assert.assertEquals(true, logic.isSymmetric(matrix));
	}
	
	@Test
	void ifMatrixNull() {
		Matrix matrix = null;
		Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
			logic.isSymmetric(matrix);
		});	
	}
	
	@Test
	void findMaxTest() {
		double [][] array = {
				{1, 1, 1},
				{1, 2, 1},
				{1, 1, 1}
		};
		Matrix matrix = new Matrix(array);
		int [][] maxLocals = {{1, 1}};
		int [][] test = logic.findMaxLocals(matrix);
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i][0]);
			System.out.println(test[i][1]);
		}
		Assert.assertArrayEquals(maxLocals, logic.findMaxLocals(matrix));
	}
	
	@Test
	void findSolutionTest() {
		double [][] array = {
				{1, 2, 3},
				{2, 2, 1},
				{4, 1, 11}
		};
		Matrix matrix = new Matrix(array);
		Assert.assertEquals(true, logic.findSolution(matrix));
	}
}
