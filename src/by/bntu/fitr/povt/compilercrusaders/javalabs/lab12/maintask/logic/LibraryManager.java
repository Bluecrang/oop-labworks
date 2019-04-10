/* Logic class which contains library management methods
 * laboratory work ¹12 - Java Multidimensional Arrays
 * version: 1.2
 * Authors: Gilevskiy Denis Alexandrovich, Kitaiharodski Pavel
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 26.12.2018
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.entity.Book;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.entity.Library;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.entity.LibraryAccount;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.exception.DataException;

public class LibraryManager {
	
	public boolean lendBook(Library library, LibraryAccount account, long bookId, Calendar dueDate) throws DataException {
		
		if (library == null) {
			throw new DataException("library cannot be null");
		}
		if (account == null) {
			throw new DataException("account cannot be null");
		}
		
		if (dueDate == null) {
			throw new DataException("due date cannot be null");
		}
		
		boolean result = false;
		
		if (isRegistered(library, account)) {
			
			List<Book> borrowedBooks = account.getBorrowedBooks();
			List<Book> libraryBooks = library.getBooks();
			Book book = findBookById(libraryBooks, bookId);
			
			if (book != null && !book.isBorrowed()) {
				book.setDueDate(dueDate);
				book.setBorrowed(true);
				borrowedBooks.add(book);
				result = true;
			}
		}
		
		return result;
	}
	
	public Book findBookById(List<Book> bookList, long id) throws DataException {
		
		if (bookList == null) {
			throw new DataException("book list cannot be null");
		}
		
		for (Book book : bookList) {
			if (book.getBookId() == id) {
				return book;
			}
		}
		return null;
	}
	
	public boolean returnBook(Library library, LibraryAccount account, long bookId) throws DataException {
		
		if (library == null) {
			throw new DataException("library cannot be null");
		}
		
		if (account == null) {
			throw new DataException("account cannot be null");
		}
		
		boolean result = false;
		
		if (isRegistered(library, account)) {
			
			List<Book> libraryBooks = library.getBooks();
			Book lendedBook = findBookById(libraryBooks, bookId);
			List<Book> accountBooks = account.getBorrowedBooks();
			Book borrowedBook = findBookById(accountBooks, bookId);
					
			if (borrowedBook != null && lendedBook != null && borrowedBook == lendedBook && borrowedBook.isBorrowed()) {
				
				accountBooks.remove(borrowedBook);
				borrowedBook.setBorrowed(false);
				borrowedBook.setDueDate(null);
				result = true;
			}			
		}
		return result;
	}
	
	public boolean registerAccount(Library library, LibraryAccount account) throws DataException {
		
		if (library == null) {
			throw new DataException("library cannot be null");
		}
		
		if (account == null) {
			throw new DataException("account cannot be null");
		}
		
		boolean result = false;
		if (!isRegistered(library, account)) {
			List<LibraryAccount> accountList = library.getAccounts();
			accountList.add(account);
			result = true;
		}
		
		return result;
	}
	
	public boolean deregisterAccount(Library library, LibraryAccount account) throws DataException {
		
		if (library == null) {
			throw new DataException("library cannot be null");
		}
		
		if (account == null) {
			throw new DataException("account cannot be null");
		}
		
		if (isRegistered(library, account)) {
			List<LibraryAccount> accountList = library.getAccounts();
			accountList.remove(account);
			return true;
		}
		
		return false;
		
	}
	
	public boolean isRegistered(Library library, LibraryAccount account) throws DataException {
		
		if (library == null) {
			throw new DataException("library cannot be null");
		}
		
		if (account == null) {
			throw new DataException("account cannot be null");
		}
		
		List<LibraryAccount> accountList = library.getAccounts();
		
		return accountList.contains(account);
	}
	
	public List<Book> findLendedBooks(Library library) throws DataException {
		
		if (library == null) {
			throw new DataException("library cannot be null");
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
	
	public Library findLibraryById(List<Library> libraries, long id) throws DataException {
		
		if (libraries == null) {
			throw new DataException("libraries cannot be null");
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
	
	public LibraryAccount findAccountById(List<LibraryAccount> accounts, long id) throws DataException {
		
		if (accounts == null) {
			throw new DataException("accounts cannot be null");
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
	
	public long[][] findLibrariesBooksIds(List<Library> libraries) throws DataException {
		
		if (libraries == null) {
			throw new DataException("libraries cannot be null");
		}
		
		long[][] result = new long[libraries.size()][];
		
		for (int i = 0; i < libraries.size(); i++) {
			List<Book> books = libraries.get(i).getBooks();
			long[] booksIds = new long[books.size()];
			for (int j = 0; j < books.size(); j++) {
				booksIds[j] = books.get(j).getBookId();
			}
			result[i] = booksIds;
		}
		return result;
	}
	
}
