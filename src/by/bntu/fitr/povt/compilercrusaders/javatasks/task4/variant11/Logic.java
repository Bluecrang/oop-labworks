package by.bntu.fitr.povt.compilercrusaders.javatasks.task4.variant11;

import java.util.Arrays;

public class Logic {
	public boolean isSymmetric(double matrix[][]) {
		if (matrix == null) {
			throw new IllegalArgumentException();
		}
		boolean symmetric = true;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j <matrix[0].length; j++) {
				if (matrix[j][i] != matrix[i][j] && i != j) {
					symmetric = false;
				}
			}
			
		}
		return symmetric;
	}
	
	public int[][] findMaxLocals(double matrix[][]){
		if (matrix == null) {
			throw new IllegalArgumentException();
		}
		int[][] maxValue = {{0,0}};
		int index = 0;
		for(int i = 1; i < matrix.length -1; i++) {
			for(int j = 1; j < matrix[0].length - 1; j++) {
				if(matrix[i][j] > matrix[i - 1][j] && matrix[i][j] > matrix[i][j - 1] && 
						matrix[i][j] > matrix[i][j + 1] && matrix[i][j] > matrix[i + 1][j]) {
					if(index > 0) {
					maxValue = Arrays.copyOf(maxValue, maxValue.length+1);
					}	
					maxValue[index][0] = i;
					maxValue[index][1] = j;
					index ++;
				}
			}
		}
		if(matrix[matrix.length - 1][0] > matrix[matrix.length -2][0] && matrix[matrix.length -1][0] > matrix[matrix.length - 1][1]) {
			if(index > 0) {
				maxValue = Arrays.copyOf(maxValue, maxValue.length + 1);
				}	
			maxValue[index][0] = matrix.length - 1;
			maxValue[index][1] = 0;
			index ++;}
		if(matrix[0][matrix[0].length - 1] > matrix[0][matrix[0].length - 2]
				&& matrix[0][matrix[0].length - 1] > matrix[1][matrix[0].length - 1]) {
			if(index > 0) {
				maxValue = Arrays.copyOf(maxValue, maxValue.length + 1);
				}	
			int []a =  {0, matrix[0].length - 1};
			maxValue[index] = a;
			index ++;}
		return maxValue;
	}
	
	public void cleanMax(double matrix[][], int maxValue[][]) {
		if (matrix == null || maxValue == null) {
			throw new IllegalArgumentException();
		}
		for(int i = 0; i < maxValue.length; i++) {
			matrix[maxValue[i][0]][maxValue[i][1]] = 0;
		}
		}
	
	 public boolean findSolution(double matrix[][]) {
		 if (matrix == null) {
				throw new IllegalArgumentException();
			}
		 int [][] maxValueble = findMaxLocals(matrix);
		 cleanMax(matrix, maxValueble);
		/* System.out.print("_____");
	 for(int i = 0; i < matrix.length; i++) {
				for(int j = 0; j <matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
				System.out.print("|");}
			System.out.print("_____");}*/
		 return isSymmetric(matrix);
	 }
}
