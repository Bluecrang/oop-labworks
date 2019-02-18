package by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.individual.task15.controller;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.individual.task15.view.*;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.individual.task15.logic.*;

public class Controller {

	public static void main(String[] args) {
		VectorLogic logic = new VectorLogic();
		View view = new View();
		double array[] = view.getVector();
		boolean flag = true;
		while(flag) {
			view.menu();
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
