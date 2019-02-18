package by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.individual.task15.view;

import java.util.Scanner;

public class View {
	private Scanner scan = new Scanner(System.in);
	
	public void menu() {
		System.out.println("Please, input 1 if you want to find number of zero elements.");
		System.out.println("Please, input 2 if you want to find sum of elements after minimal element.");
		System.out.println("Please, input 3 if you want to see the array.");
		System.out.println("Please, input 4 if you want to exit.");
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
	
	public double[] getVector() {
		System.out.println("1 - run using random input");
		System.out.println("2 - run using console input");
		
		int a = getChoice(1, 2);
		double[] array;
		System.out.println("Please input number of elements");
		int number = getInt();
		if(number < 1) {
			number = 1;
		}
		if(a == 2) {
		array = new double[number];
		for(int i = 0; i < number; i++) {
			array[i] = getDouble();
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
	
	 private double getDouble() {
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
	 private int getInt() {
		 System.out.print("Please, input: ");
			while(!scan.hasNextInt()) {
				scan.next();
				System.out.println("It should be integer number");
			}
		
		return scan.nextInt();
}
}
