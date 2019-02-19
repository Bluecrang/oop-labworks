/* view for individual task 15
 * laboratory work 11 - Java One-dimensional Arrays
 * version: 1.0
 * Authors: Kitaiharodski Pavel Sergeevich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 19.02.2019
 */
package by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.individual.task15.view;

import java.util.Scanner;

public class View {
	private Scanner scan = new Scanner(System.in);
	
	
	public void showInfo(String a) {
		System.out.println(a);
	}
	
	public void showResult(String a, double b) {
		System.out.println(a + b);
	}
	public void showResult(String a, int b) {
		System.out.println(a + b);
	}
	
	public int getChoice(int a, int b) {
		int res = a - 1;
		do {
			System.out.println("It should be number from " + a + " to " + b);
			while(!scan.hasNextInt()) {
				scan.next();
				System.out.println("It should be integer number");
			}
			res = scan.nextInt();
		}while(a > res && res > b);
		return res;
	}
	
	
	
	public double getDouble() {
		 System.out.print("Please, input: ");
				while(!scan.hasNextDouble()) {
					scan.next();
					System.out.println("It should be number");
				}
			
			return scan.nextDouble();
	 }
	 
	 public void showArray(double array[]) {
		 for(int i = 0;i < array.length;i++) {
			 System.out.println(" " + array[i]);
		 }
	 }
	 public int getInt() {
		 System.out.print("Please, input: ");
			while(!scan.hasNextInt()) {
				scan.next();
				System.out.println("It should be integer number");
			}
		
		return scan.nextInt();
}
}
