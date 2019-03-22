package by.bntu.fitr.povt.compilercrusaders.javatasks.task4.variant11;

import java.util.Arrays;
import by.bntu.fitr.povt.compilercrusaders.javatasks.task4.variant11.Matrix;


public class Logic {
	public boolean isSymmetric(Matrix matrix) {
		
		if (matrix == null) {
			throw new IllegalArgumentException();
		}
		boolean symmetric = true;
		for(int i = 0; i < matrix.getLength(); i++) {
			for(int j = 0; j <matrix.getRow(i).length; j++) {
				int res = Double.compare(matrix.getElement(i, j), matrix.getElement(j,  i));
				if (res != 0 && i != j) {
					symmetric = false;
				}
			}
			
		}
		return symmetric;
	}
	
	public int[][] findMaxLocals(Matrix matrix){
		if (matrix == null) {
			throw new IllegalArgumentException();
		}
		int[][] maxValue = {{0, 0}};
		int index = 0;
		double []row ;
		for(int i = 1; i < matrix.getLength() -1; i++) {
			for(int j = 1; j < matrix.getRow(i).length - 1; j++) {
				if( matrix.getElement(i,  j) > matrix.getElement(i - 1,  j)  && matrix.getElement(i,  j) > matrix.getElement(i,  j -1) && 
						matrix.getElement(i, j) > matrix.getElement(i, j + 1) && matrix.getElement(i, j) > matrix.getElement(i + 1,  j)) {
					if(index > 0) {
					maxValue = Arrays.copyOf(maxValue, maxValue.length+1);
					}	
					maxValue[index][0] = i;
					maxValue[index][1] = j;
					index ++;
				}
			}
		}
		if(matrix.getElement(matrix.getLength() -1, 0) > matrix.getElement(matrix.getLength() - 2, 0) && 
				matrix.getElement(matrix.getLength() - 1, 0) > matrix.getElement(matrix.getLength() - 1, 1)) {
			if(index > 0) {
				maxValue = Arrays.copyOf(maxValue, maxValue.length + 1);
				}	
			maxValue[index][0] = matrix.getLength() - 1;
			maxValue[index][1] = 0;
			index ++;}
		row = matrix.getRow(0);
		if (matrix.getElement(0, row.length - 1) > matrix.getElement(0, row.length - 2)
				&& matrix.getElement(0, row.length - 1) > matrix.getElement(1, row.length - 1)) {
			if(index > 0) {
				maxValue = Arrays.copyOf(maxValue, maxValue.length + 1);
				}	
			int []a =  {0, row.length - 1};
			maxValue[index] = a;
			index ++;}
		return maxValue;
	}
	
	public void cleanMax(Matrix matrix, int maxValue[][]) {
		if (matrix == null || maxValue == null) {
			throw new IllegalArgumentException();
		}
		for(int i = 0; i < maxValue.length; i++) {
			matrix.setElement(maxValue[i][0], maxValue[i][1], 0);
		}
		}
	
	 public boolean findSolution(Matrix matrix) {
		 if (matrix == null) {
				throw new IllegalArgumentException();
			}
		 int [][] maxValueble = findMaxLocals(matrix);
		 cleanMax(matrix, maxValueble);
		 return isSymmetric(matrix);
	 }
}
