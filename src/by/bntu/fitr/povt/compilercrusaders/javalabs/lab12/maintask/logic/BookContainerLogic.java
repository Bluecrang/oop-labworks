/* Logic for book container
 * laboratory work ¹12 - Java Multidimensional Arrays
 * version: 1.0
 * Author: Gilevskiy Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 18.02.2019
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.logic;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.container.BookContainer;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.entity.Book;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.exception.DataException;

public class BookContainerLogic {
	
	public Book findById(BookContainer container, long id) throws DataException {
		
		if (container == null) {
			throw new DataException("container cannot be null");
		}
		
		Book result = null;
		for (int i = 0; i < container.size(); i++) {
			Book currentBook = container.get(i);
			if (currentBook.getBookId() == id) {
				result = currentBook;
				break;
			}
		}
		return result;
	}
	
	public BookContainer findAllByAuthor(BookContainer container, String author) throws DataException {
		
		if (container == null) {
			throw new DataException("container cannot be null");
		}
		
		if (author == null) {
			throw new DataException("author cannot be null");
		}
		
		BookContainer result = new BookContainer();
		
		for (int i = 0; i < container.size(); i++) {
			Book currentBook = container.get(i);
			if (currentBook.getAuthor().equals(author)) {
				result.add(currentBook);
			}
		}
		return result;
	}
	
	public BookContainer findBorrowed(BookContainer container) throws DataException {
		
		if (container == null) {
			throw new DataException("container cannot be null");
		}
		
		BookContainer result = new BookContainer();
		
		for (int i = 0; i < container.size(); i++) {
			Book currentBook = container.get(i);
			if (currentBook.isBorrowed()) {
				result.add(currentBook);
			}
		}
		return result;
	}
	
	public int countAuthorBooks(BookContainer container, String author) throws DataException {
		
		if (container == null) {
			throw new DataException("container cannot be null");
		}
		
		if (author == null) {
			throw new DataException("author cannot be null");
		}
		
		int result = 0;
		for (int i = 0; i < container.size(); i++) {
			Book currentBook = container.get(i);
			if (currentBook.getAuthor().equals(author)) {
				result++;
			}
		}	
		return result;
	}
}
