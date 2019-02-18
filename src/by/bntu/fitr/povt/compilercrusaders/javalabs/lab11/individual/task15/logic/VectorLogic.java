/* logic for individual task 15
 * laboratory work 11 - Java One-dimensional Arrays
 * version: 1.0
 * Authors: Kitaiharodski Pavel Sergeevich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 18.02.2019
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.individual.task15.logic;

public class VectorLogic {
	private int findMinIndex(double array []) {
		int index = 0;
		if (array.length > 0) {
			double minimal = array[0];
			for(int i = 1; i < array.length; i++) {
				if(minimal < array[i]) {
					minimal = array[i];
					index = i;
				}
			}
		}
		return index;
	}
	
	
	public int CountZeroElement(double array[]){
		int number = 0;
		if (array.length > 0) {
			for(int i = 0; i < array.length; i++) {
				if(array[i] == 0.0) {
					number++ ;
				}
			}
		}
		return number;
	}
	
	public double findSumAfterMin(double array[]) {
		double sum = 0.0;
		if (array.length > 0) {
			for(int i = findMinIndex(array); i < array.length; i++) {
				sum += array[i];
			}
		}
		return sum;
	}
	
}
