/* controller for individual task 15
 * laboratory work 11 - Java One-dimensional Arrays
 * version: 1.0
 * Authors: Kitaiharodski Pavel Sergeevich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 19.02.2019
 */
package by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.individual.task15.controller;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.individual.task15.view.*;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.individual.task15.logic.*;

public class Controller {
	
	public static double[] getVector() {
		View view = new View();
		view.showInfo("1 - run using random input");
		view.showInfo("2 - run using console input");
		
		int a = view.getChoice(1, 2);
		double[] array;
		view.showInfo("Please input number of elements");
		int number = view.getInt();
		if(number < 1) {
			number = 1;
		}
		if(a == 2) {
		array = new double[number];
		for(int i = 0; i < number; i++) {
			array[i] = view.getDouble();
			}
		}
		else {
			array = new double[number];
			for(int i = 0; i < number; i++) {
				array[i] = Math.random()*200 - 100;
			}
		}
		return array;
	}
	
	public static void menu() {
		View view = new View();
		view.showInfo("Please, input 1 if you want to find number of zero elements.");
		view.showInfo("Please, input 2 if you want to find sum of elements after minimal element.");
		view.showInfo("Please, input 3 if you want to see the array.");
		view.showInfo("Please, input 4 if you want to exit.");
	}
	
	public static void main(String[] args) {
		VectorLogic logic = new VectorLogic();
		View view = new View();
		double array[] = getVector();
		boolean flag = true;
		while(flag) {
			menu();
			int choice = view.getChoice(1,4);
			switch(choice) {
			
			case 1:{
				view.showResult("Number of zero elements: ", logic.CountZeroElement(array) );
				break;
			}
			case 2:{
				view.showResult("Sum of elements after minimal element: ", logic.findSumAfterMin(array) );
				break;
			}
			case 3:{
				view.showArray(array);
				break;
			}
			case 4:{
				flag = false;
				break;
			}
			}
		}

	}

}
