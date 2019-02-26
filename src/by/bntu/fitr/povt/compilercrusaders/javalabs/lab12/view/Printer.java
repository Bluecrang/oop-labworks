/* This class contains methods for console output
 * laboratory work ¹12 - Java Multidimensional Arrays
 * version: 1.0
 * Full name: Gilevskiy Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 20.12.2018
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.view;

import java.util.Calendar;

public class Printer {
	public void println(String message) {
		System.out.println(message);
	}

	public void println(String message,Calendar dueDate) {
		System.out.println(message + dueDate.getTime());
		
	}
}