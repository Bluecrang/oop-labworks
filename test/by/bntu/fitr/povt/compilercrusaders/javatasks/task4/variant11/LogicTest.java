package by.bntu.fitr.povt.compilercrusaders.javatasks.task4.variant11;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		double [][] array = {{1, 2, 3},{2, 1, 3}};
		double [][] expected = {{0.0, 2, 3},{2, 1, 0.0}};
		int[][] clean = {{0, 0},{1, 2}};
		logic.cleanMax(array, clean);
		Assert.assertArrayEquals(expected, array);
	}
	
	@Test
	void symmetricTestNegative() {
		double [][] falseArray = {{1,2,3},{2,1,3},{6,6,6}};
		Assert.assertEquals(false, logic.isSymmetric(falseArray));
	}
	
	@Test
	void symmetricTestPositive() {
		double [][]  trueArray = {{1,2,3},{2,4,7},{3,7,0}};
		Assert.assertEquals(true, logic.isSymmetric(trueArray));
	}
	
	@Test
	void ifMatrixNull() {
		double [][]  Array = null;
		Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
			logic.isSymmetric(Array);
		});	
	}
	
	@Test
	void findMaxTest() {
		double [][] array = {
				{1, 1, 1},
				{1, 2, 1},
				{1, 1, 1}
		};
		
		int [][] maxLocals = {{1,1}};
		maxLocals[0][0] = 1;
		maxLocals[0][1] = 1;
		Assert.assertArrayEquals(maxLocals, logic.findMaxLocals(array));
	}
	
	@Test
	void findSolutionTest() {
		double [][] array = {
				{1, 2, 3},
				{2, 2, 1},
				{4, 1, 11}
		};
		
		Assert.assertEquals(true, logic.findSolution(array));
	}
}
