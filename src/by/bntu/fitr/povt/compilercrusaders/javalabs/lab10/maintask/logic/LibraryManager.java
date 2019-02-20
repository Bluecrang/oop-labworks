/* Logic for lab10
 * laboratory work ¹10 - Java One-dimensional Arrays
 * version: 1.0
 * Authors: Gilevskiy Denis Alexandrovich, Kitaiharodski Pavel
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 20.12.2018
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab10.maintask.logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab10.maintask.entity.Book;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab10.maintask.entity.Library;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab10.maintask.entity.LibraryAccount;

public class LibraryManager {
	
	public void lendBook(Library library, LibraryAccount account, String bookTitle, Calendar dueDate) {
		
		if (library == null || account == null || bookTitle == null || dueDate == null) {
			throw new IllegalArgumentException();
		}
		
		if (isRegistered(library, account)) {
			
			List<Book> borrowedBooks = account.getBorrowedBooks();
			List<Book> libraryBooks = library.getBooks();
			Book book = findBookByTitle(libraryBooks, bookTitle);
			
			if (book != null) {
				book.setDueDate(dueDate);
				book.setBorrowed(true);
				borrowedBooks.add(book);
			}
		}
	}
	
	public Book findBookByTitle(List<Book> bookList, String title) {
		
		if (bookList == null || title == null) {
			throw new IllegalArgumentException();
		}
		
		for (Book book : bookList) {
			if (book.getTitle() == title) {
				return book;
			}
		}
		return null;
	}
	
	public void returnBook(Library library, LibraryAccount account, String title) {
		
		if (library == null || account == null || title == null) {
			throw new IllegalArgumentException();
		}
		
		if (isRegistered(library, account)) {
			
			List<Book> libraryBooks = library.getBooks();
			Book lendedBook = findBookByTitle(libraryBooks, title);
			List<Book> accountBooks = account.getBorrowedBooks();
			Book borrowedBook = findBookByTitle(accountBooks, title);
					
			if (borrowedBook != null && borrowedBook == lendedBook && borrowedBook.isBorrowed()) {
				
				accountBooks.remove(borrowedBook);
				borrowedBook.setBorrowed(false);
				borrowedBook.setDueDate(null);
			}			
		}	
	}
	
	public void registerAccount(Library library, LibraryAccount account) {
		
		if (library == null || account == null) {
			throw new IllegalArgumentException();
		}
		
		if (!isRegistered(library, account)) {
			List<LibraryAccount> accountList = library.getAccounts();
			accountList.add(account);
		}
		
	}
	
	public void deregisterAccount(Library library, LibraryAccount account) {
		
		if (library == null || account == null) {
			throw new IllegalArgumentException();
		}
		
		if (isRegistered(library, account)) {
			List<LibraryAccount> accountList = library.getAccounts();
			accountList.remove(account);
		}
		
	}
	
	public boolean isRegistered(Library library, LibraryAccount account) {
		
		if (library == null || account == null) {
			throw new IllegalArgumentException();
		}
		
		List<LibraryAccount> accountList = library.getAccounts();
		
		return accountList.contains(account);
	}
	
	public List<Book> findLendedBooks(Library library) {
		
		if (library == null) {
			throw new IllegalArgumentException();
		}
		
		List<Book> lendedBooks = new ArrayList<>();
		List<Book> books = library.getBooks();
		
		for (Book book : books) {
			if (book.isBorrowed()) {
				lendedBooks.add(book);
			}
		}
		
		return lendedBooks;
	}
	
	
}
