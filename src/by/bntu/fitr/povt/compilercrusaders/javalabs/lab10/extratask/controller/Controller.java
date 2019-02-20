/* This program is "Guess the number" game
 * laboratory work ¹10 - Basics Object-Oriented Programming in Java. Abstraction. Object Initialzation
 * version: 1.0
 * Full name: Gilevsky Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 20.12.2018
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab10.extratask.controller;

import java.util.InputMismatchException;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab10.extratask.logic.Model;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab10.extratask.util.KeyboardInput;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab10.extratask.view.Printer;

public class Controller {
	public static void main(String[] args) {
		KeyboardInput input = new KeyboardInput();
		Printer printer = new Printer();
		Model model = new Model();
		boolean active = true;
		printer.println("*** GUESS THE NUMBER ***");
		while (active) {
			try {
				int searchType = 0;
				while (searchType != 1 && searchType != 2) {
					printer.println("Choose the type of the guessing: \n"
							+ "1 - binary search\n"
							+ "2 - random search");
					searchType = input.nextInt();
				}
				printer.println("Enter the minimum of the range: ");
				int min = input.nextInt();
				printer.println("Enter the maximum of the range: ");
				int max = input.nextInt();
				printer.println("Enter the secret number: ");
				int secretNumber = input.nextIntInRange(min, max);
				printer.println("Enter attempts limit: ");
				int limit = input.nextPositiveInt();
				int answersCount = 0;
				while (answersCount < limit) {
					printer.println("*** GAME STARTS ***");
					try {
						int answer;
						if (searchType == 1) {
							answer = model.guessAnswerBinarySearch(min, max);
						} else {
							answer = model.guessAnswerRandomSearch(min, max);
						}
						printer.println("Computer tries number " + answer);
						if (answer == secretNumber) {
							answersCount++;
							printer.println("Computer win!");
							printer.println(String.format("attempts: %d/%d", answersCount, limit));
							break;
						} else if (limit - answersCount == 1) {
							printer.println("GAME OVER");
							break;
						} else if (answer < secretNumber) {
							min = answer + 1;
							answersCount++;
							printer.println("The secret number is higher");
						} else if (answer > secretNumber) {
							max = answer - 1;
							answersCount++;
							printer.println("The secret number is lower");
						}
					} catch (InputMismatchException exc) {
						printer.println(exc.getMessage());
					}
				}
				printer.println("Run again?(Y/N)");
				try {
					int choice = input.nextChar();
					switch (choice) {
					case 'Y': {
						break;
					}
					case 'N': {
						active = false;
						break;
					}
					default: {
						throw new InputMismatchException();
					}
					}
				} catch (InputMismatchException exc){
					printer.println("Wrong value, program shut down");
					active = false;
				}
			} catch (InputMismatchException|IllegalArgumentException exc) {
				printer.println(exc.getMessage());
			}
		}
	}
}
