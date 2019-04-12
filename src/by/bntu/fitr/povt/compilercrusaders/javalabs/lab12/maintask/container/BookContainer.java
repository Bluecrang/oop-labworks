/* Book container
 * laboratory work ¹12 - Java Multidimensional Arrays
 * version: 1.1
 * Author: Gilevskiy Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 20.02.2019
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.container;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.entity.Book;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.exception.DataException;

public class BookContainer {
	
	public static final double SIZE_MULTIPLIER;
	public static final double SIZE_DIVIDER;
	
	private static final Logger logger = LogManager.getLogger();

	private Book[] bookArray;
	private int size;
	
	static {
		SIZE_MULTIPLIER = 1.5;
		SIZE_DIVIDER = 1.5;
	}
	
	{
		bookArray = new Book[10];
	}
	
	public BookContainer() {}
	
	public BookContainer(Book... books) {
		
		if (books != null) {
			for (Book book : books) {
				add(book);
			}
		}
	}
	
	public BookContainer(BookContainer container) {
		
		if (container != null) {
			for (int i = 0; i < container.size(); i++) {
				try {
					add(new Book(container.get(i)));
				} catch (DataException e) {
					logger.error("could  not add book to container at index=" + i);
				}
			}
		}
	}

	public int size() {
		return size;
	}
	
	public void add(Book book) {
		
		if (size >= bookArray.length) {
			bookArray = Arrays.copyOf(bookArray, (int)(bookArray.length * SIZE_MULTIPLIER));
		} 
		
		bookArray[size] = book;
		logger.debug("book=" + book + " added");
		size++;
	}
	
	public Book get(int index) throws DataException {
		
		if (index < 0 || index >= size) {
			throw new DataException("Index should be less than size and more or equal to 0");
		}
		
		return bookArray[index];
	}
	
	public void set(int index, Book book) throws DataException {
		
		if (index < 0 || index >= size) {
			throw new DataException("Index should be less than size and more or equal to 0");
		}
		
		bookArray[index] = book;
		logger.debug("book=" + book + " set to index=" + index);
	}
	
	public void remove(int index) throws DataException {
		
		if (index < 0 || index >= size) {
			throw new DataException("Index should be less than size and more or equal to 0");
		}
		
		System.arraycopy(bookArray, index + 1, bookArray, index, size - (index + 1));
		bookArray[size - 1] = null; //removing reference which was not replaced
		size--;
		
		if (bookArray.length > size * Math.pow(SIZE_MULTIPLIER, 2)) {
			bookArray = Arrays.copyOf(bookArray, (int)(bookArray.length / SIZE_DIVIDER));
			
		}
	}
	
	public boolean contains(Book book) {
		
		for (int i = 0; i < size; i++) {
			if (book == bookArray[i]) {
				return true;
			}
		}
		
		return false;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i = 0; i < size; i++) {
			sb.append(bookArray[i]);
		}
		sb.append(']');
		return sb.toString();
	}
	
}
