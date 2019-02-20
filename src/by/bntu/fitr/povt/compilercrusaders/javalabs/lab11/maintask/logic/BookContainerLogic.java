/* Logic for book container
 * laboratory work ¹11 - Java One-dimensional Arrays
 * version: 1.0
 * Author: Gilevskiy Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 18.02.2019
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.maintask.logic;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.maintask.container.BookContainer;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.maintask.entity.Book;

public class BookContainerLogic {
	
	public Book findById(BookContainer container, long id) {
		
		if (container == null) {
			throw new IllegalArgumentException();
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
	
	public BookContainer findAllByAuthor(BookContainer container, String author) {
		
		if (container == null || author == null) {
			throw new IllegalArgumentException();
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
	
	public BookContainer findBorrowed(BookContainer container) {
		
		if (container == null) {
			throw new IllegalArgumentException();
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
	
	public int countAuthorBooks(BookContainer container, String author) {
		
		if (container == null || author == null) {
			throw new IllegalArgumentException();
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
