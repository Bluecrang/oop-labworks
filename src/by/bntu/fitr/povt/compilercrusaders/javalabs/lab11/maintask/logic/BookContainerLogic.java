package by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.maintask.logic;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.maintask.container.BookContainer;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.maintask.entity.Book;

public class BookContainerLogic {
	
	public BookContainer findByAuthor(BookContainer container, String author) {
		
		if (container == null || author == null) {
			throw new IllegalArgumentException();
		}
		
		BookContainer result = new BookContainer();
		
		for (int i = 0; i < container.size(); i++) {
			Book currentBook = container.get(i);
			if (currentBook.getAuthor() == author) {
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
			if (currentBook.getAuthor() == author) {
				result++;
			}
		}
		
		return result;
	}
	
	
}
