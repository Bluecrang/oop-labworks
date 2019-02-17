/* This class contains logic for lab10 extra task
 * laboratory work ¹10 - Basics Object-Oriented Programming in Java. Abstraction. Object Initialzation
 * version: 1.0
 * Authors: Kitaiharodski Pavel
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 20.12.2018
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab10.extratask.logic;

import java.util.Random;

public class Model {
	Random random = new Random();
	
	public int guessAnswerBinarySearch(int min, int max) {
		return (min + max) / 2;
	}
	
	public int guessAnswerRandomSearch(int min, int max) {
		return random.nextInt(max + 1 - min) + min;
	}
}