package by.bntu.fitr.povt.compilercrusaders.javatasks.task4.variant6.entity;

public interface Matrix {
	int getRowCount();
	Integer getRowLength(int index);
	Double getElement(int row, int column);
	boolean setElement(int index, int column, double value);
	
}
