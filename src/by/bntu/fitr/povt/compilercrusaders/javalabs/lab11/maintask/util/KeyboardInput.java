/* Keyboard input
 * laboratory work ¹11 - Java One-dimensional Arrays
 * version: 1.1
 * Authors: Gilevskiy Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 20.02.2019
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.maintask.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class KeyboardInput {
	private static final String INT_VALUE_ERROR = "value must be integer";
	private static final String DOUBLE_VALUE_ERROR = "value must be double";
	private static final String CHAR_VALUE_ERROR = "value must be character";
	private static final String POSITIVE_INT_VALUE_ERROR = "value must be positive integer";
	private static final String RANGE_ERROR = "value must be within the range";
	private Scanner scanner = new Scanner(System.in);
	
	public String nextLine() {
		String result = null;
		result = scanner.nextLine();
		while (result.isEmpty()) {
			result = scanner.nextLine();
		}
		return result;
	}
	
	public int nextInt() {
		if (scanner.hasNextInt()) {
			return scanner.nextInt();
		}
		else {
			scanner.next();
			throw new InputMismatchException(INT_VALUE_ERROR);
		}
	}
	public int nextPositiveInt() {
		if (scanner.hasNextInt()) {
			int result = scanner.nextInt();
			if (result > 0) {
				return result;
			}
			else {
				throw new InputMismatchException(POSITIVE_INT_VALUE_ERROR);
			}
		}
		else {
			scanner.next();
			throw new InputMismatchException(POSITIVE_INT_VALUE_ERROR);
		}
	}
	public double nextDouble() {
		if (scanner.hasNextDouble()) {
			return scanner.nextDouble();
		}
		else {
			scanner.next();
			throw new InputMismatchException(DOUBLE_VALUE_ERROR);
		}
	}
	public char nextChar() {
		if (scanner.hasNext()) {
			return scanner.next().charAt(0);
		}
		else {
			scanner.next();
			throw new InputMismatchException(CHAR_VALUE_ERROR);
		}
	}
	
	public int nextIntInRange(int min, int max) {
		if (min > max) {
			throw new IllegalArgumentException(RANGE_ERROR);
		}
		if (scanner.hasNextInt()) {
			int result = scanner.nextInt();
			if (result >= min && result <= max) {
				return result;
			}
			else {
				throw new InputMismatchException(RANGE_ERROR);
			}
		}
		else {
			scanner.next();
			throw new InputMismatchException(INT_VALUE_ERROR);
		}
	}
}
