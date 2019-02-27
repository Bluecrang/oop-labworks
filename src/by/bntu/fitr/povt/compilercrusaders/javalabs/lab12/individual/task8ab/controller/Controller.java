package by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.individual.task8ab.controller;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.individual.task8ab.logic.MatrixLogic;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.individual.task8ab.util.KeyboardInput;
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
			double[][] matrix2;
			
			switch(inputChoice) {
			
			case 1: {
				
				rowCount = random.nextInt(MAX_RANDOM_ROW_LENGTH_MINUS_ONE) + 1;
				printer.println("number of rows in matrix is " + rowCount);
				
				columnCount = random.nextInt(MAX_RANDOM_COLLUMN_LENGTH_MINUS_ONE) + 1;
				printer.println("number of columns in matrix is " + columnCount);
				
				matrix = new double[rowCount][columnCount];
				matrix2 = new double[rowCount][columnCount];
				
				for (int i = 0; i < matrix.length; i++) {
					for (int j = 0; j < matrix[i].length; j++) {
						matrix[i][j] = (MAX_RANDOM_NUM - MIN_RANDOM_NUM) * random.nextDouble() + MIN_RANDOM_NUM;
						matrix2[i][j] = (MAX_RANDOM_NUM - MIN_RANDOM_NUM) * random.nextDouble() + MIN_RANDOM_NUM;
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
					
					printer.println("Second matrix: ");
					
					matrix2 = new double[rowCount][columnCount];
					
					for (int i = 0; i < matrix2.length; i++) {
						for (int j = 0; j < matrix2[i].length; j++) {
							printer.println("enter element (row = " + (i + 1) + "; column = " + (j + 1) + "): ");
							matrix2[i][j] = input.nextDouble();
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
			printer.println("Second matrix:");
			for (double[] row : matrix2) {
				printer.println(Arrays.toString(row));
			}
			printer.println("\n");
			double max = logic.findMaxWithDuplicateInMatrix(matrix);
			printer.println("max element in matrix with duplicates: " + max);
			double[][] newMatrix = logic.multiplyMatrix(matrix, matrix2);
			printer.println("New matrix with multiplied elements: ");
			for (double[] row : newMatrix) {
				printer.println(Arrays.toString(row));
			}
		}
		
	}

}
