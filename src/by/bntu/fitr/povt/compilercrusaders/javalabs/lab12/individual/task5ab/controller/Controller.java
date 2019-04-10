/* controller for individual tasks 5a and 5b class for lab12
 * laboratory work ¹12 - Java Multidimensional Arrays
 * version: 1.0
 * Author: Gilevskiy Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 26.12.2018
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.individual.task5ab.controller;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.individual.task5ab.exception.IndexException;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.individual.task5ab.logic.MatrixLogic;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.individual.task5ab.util.KeyboardInput;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.view.Printer;

public class Controller {

	private static final int MAX_RANDOM_NUM = 100;
	private static final int MIN_RANDOM_NUM = -100;
	private static final int MAX_RANDOM_ROW_LENGTH_MINUS_ONE = 19;
	private static final int MAX_RANDOM_COLLUMN_LENGTH_MINUS_ONE = 19;
	
	public static void main(String[] args) {
		
		KeyboardInput input = new KeyboardInput();
		Printer printer = new Printer();
		Random random = new Random();
		MatrixLogic logic = new MatrixLogic();
		
		boolean active = true;
		
		start: while (active) {
			
			printer.println("Choose command:");
			printer.println("1 - use random input");
			printer.println("2 - use console input");
			printer.println("3 - EXIT");
			int inputChoice;
			try {
				inputChoice = input.nextInt();
			} catch (InputMismatchException e) {
				printer.println(e.getMessage());
				continue;
			}
			
			int rowCount;
			int columnCount;
			double[][] matrix;
			
			switch(inputChoice) {
			
			case 1: {
				
				rowCount = random.nextInt(MAX_RANDOM_ROW_LENGTH_MINUS_ONE) + 1;
				printer.println("number of rows in matrix is " + rowCount);
				
				columnCount = random.nextInt(MAX_RANDOM_COLLUMN_LENGTH_MINUS_ONE) + 1;
				printer.println("number of columns in matrix is " + columnCount);
				
				matrix = new double[rowCount][columnCount];
				
				for (int i = 0; i < matrix.length; i++) {
					for (int j = 0; j < matrix[i].length; j++) {
						matrix[i][j] = (MAX_RANDOM_NUM - MIN_RANDOM_NUM) * random.nextDouble() + MIN_RANDOM_NUM;
					}
				}
				break;
			}
			
			case 2: {
				try {
					printer.println("Input matrix row length in range(1, 100): ");
					rowCount = input.nextIntInRange(1, 100);
					printer.println("Input matrix column length in range(1, 100): ");
					columnCount = input.nextIntInRange(1, 100);
					printer.println("matrix is " + rowCount + "x" + columnCount);
					
					matrix = new double[rowCount][columnCount];
					
					for (int i = 0; i < matrix.length; i++) {
						for (int j = 0; j < matrix[i].length; j++) {
							printer.println("enter element (row = " + (i + 1) + "; column = " + (j + 1) + "): ");
							matrix[i][j] = input.nextDouble();
						}
					}
				} catch (InputMismatchException e) {
					printer.println(e.getMessage());
					continue;
				}

				break;
			}
			
			case 3: {
				break start;
			}
			
			default: {
				printer.println("Unknown command");
				continue;
			}
			}
			
			printer.println("Resulting matrix:");
			for (double[] row : matrix) {
				printer.println(Arrays.toString(row));
			}
			printer.println("\n");
			List<Integer> orderedRowsIndexes = logic.findOrderedRowsIndexes(matrix);
			if (!orderedRowsIndexes.isEmpty()) {
				double max;
				try {
					max = logic.findMaxInRows(matrix, orderedRowsIndexes);
					printer.println("max element in ordered rows: " + max);
				} catch (IndexException e) {
					printer.println("wrong index");
				}

			} else {
				printer.println("There are no ordered rows");
			}

			logic.sortColumnsBySmallestElement(matrix);
			printer.println("Matrix with columns sorted by smallest element: ");
			for (double[] row : matrix) {
				printer.println(Arrays.toString(row));
			}
		}
		
	}
}
