/* Book container
 * laboratory work ¹11 - Java One-dimensional Arrays
 * version: 1.0
 * Author: Gilevskiy Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 18.02.2019
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.maintask.container;

import java.util.Arrays;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.maintask.entity.Book;

public class BookContainer {
	
	private static final double GROW_MULTIPLIER;
	private static final double SHRINK_DIVIDER;

	private Book[] bookArray;
	private int size;
	
	static {
		GROW_MULTIPLIER = 1.5;
		SHRINK_DIVIDER = 1.5;
	}
	
	{
		bookArray = new Book[10];
		size = 0;
	}
	
	public BookContainer() {}
	
	public BookContainer(Book... books) {
		
		if (books == null) {
			throw new IllegalArgumentException();
		}
		
		for (Book book : books) {
			add(book);
		}
	}
	
	public BookContainer(BookContainer container) {
		
		if (container == null) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < container.size(); i++) {
			add(container.get(i));
		}
	}

	public int size() {
		return size;
	}
	
	public void add(Book book) {
		
		if (size >= bookArray.length) {
			bookArray = Arrays.copyOf(bookArray, (int)(bookArray.length * GROW_MULTIPLIER));
		} 
		
		bookArray[size] = book;
		size++;
	}
	
	public Book get(int index) {
		
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException();
		}
		
		return bookArray[index];
	}
	
	public void set(int index, Book book) {
		
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException();
		}
		
		bookArray[index] = book;
	}
	
	public void remove(int index) {
		
		if (index < 0 || index < 0 || index >= size) {
			throw new IllegalArgumentException();
		}
		
		System.arraycopy(bookArray, index + 1, bookArray, index, size - (index + 1));
		bookArray[size - 1] = null; //removing reference which was not replaced
		size--;
		
		if (bookArray.length > size * 2) { // if doubled container size less than array length
			bookArray = Arrays.copyOf(bookArray, (int)(bookArray.length / SHRINK_DIVIDER));
		}
	}
	
	public boolean contains(Book book) {
		
		if (book == null) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < size(); i++) {
			if (book == get(i)) {
				return true;
			}
		}
		
		return false;
	}
	
}
