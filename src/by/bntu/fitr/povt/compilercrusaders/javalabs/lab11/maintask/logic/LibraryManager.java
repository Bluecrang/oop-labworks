/* Logic for lab11
 * laboratory work ¹11 - Java One-dimensional Arrays
 * version: 1.1
 * Authors: Gilevskiy Denis Alexandrovich, Kitaiharodski Pavel
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 20.12.2018
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.maintask.logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.maintask.entity.Book;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.maintask.entity.Library;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.maintask.entity.LibraryAccount;

public class LibraryManager {
	
	public boolean lendBook(Library library, LibraryAccount account, long bookId, Calendar dueDate) {
		
		if (library == null || account == null || dueDate == null) {
			throw new IllegalArgumentException();
		}
		
		boolean result = false;
		
		if (isRegistered(library, account)) {
			
			List<Book> borrowedBooks = account.getBorrowedBooks();
			List<Book> libraryBooks = library.getBooks();
			Book book = findBookById(libraryBooks, bookId);
			
			if (book != null) {
				book.setDueDate(dueDate);
				book.setBorrowed(true);
				borrowedBooks.add(book);
				result = true;
			}
		}
		
		return result;
	}
	
	public Book findBookById(List<Book> bookList, long id) {
		
		if (bookList == null) {
			throw new IllegalArgumentException();
		}
		
		for (Book book : bookList) {
			if (book.getBookId() == id) {
				return book;
			}
		}
		return null;
	}
	
	public Book findBookByTitle(List<Book> bookList, String title) {
		
		if (bookList == null || title == null) {
			throw new IllegalArgumentException();
		}
		
		for (Book book : bookList) {
			if (book.getTitle().equals(title)) {
				return book;
			}
		}
		return null;
	}
	
	public boolean returnBook(Library library, LibraryAccount account, long bookId) {
		
		if (library == null || account == null) {
			throw new IllegalArgumentException();
		}
		
		boolean result = false;
		
		if (isRegistered(library, account)) {
			
			List<Book> libraryBooks = library.getBooks();
			Book lendedBook = findBookById(libraryBooks, bookId);
			List<Book> accountBooks = account.getBorrowedBooks();
			Book borrowedBook = findBookById(accountBooks, bookId);
					
			if (borrowedBook != null && borrowedBook == lendedBook && borrowedBook.isBorrowed()) {
				
				accountBooks.remove(borrowedBook);
				borrowedBook.setBorrowed(false);
				borrowedBook.setDueDate(null);
				result = true;
			}			
		}
		return result;
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
	
	public Library findLibraryById(List<Library> libraries, long id) {
		
		if (libraries == null) {
			throw new IllegalArgumentException();
		}
		
		Library chosenLibrary = null;
		for (Library library : libraries) {
			if (library.getLibraryId() == id) {
				chosenLibrary = library;
				break;
			}
		}
		
		return chosenLibrary;
	}
	
	public LibraryAccount findAccountById(List<LibraryAccount> accounts, long id) {
		
		if (accounts == null) {
			throw new IllegalArgumentException();
		}
		
		LibraryAccount chosenAccount = null;
		for (LibraryAccount account : accounts) {
			if (account.getLibraryAccountId() == id) {
				chosenAccount = account;
				break;
			}
		}
		
		return chosenAccount;
	}
	
	
}
