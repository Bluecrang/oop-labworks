/* unit tests for LibraryManager class
 * laboratory work ¹12 - Java Multidimensional Arrays
 * version: 1.0
 * Author: Gilevskiy Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 26.12.2018
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.entity.Book;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.entity.Library;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.entity.LibraryAccount;
import org.junit.Assert;

public class LibraryManagerTest {
	
	private static LibraryManager manager;
	
	@BeforeClass
	public static void setUp() {
		manager = new LibraryManager();
	}

	@Test(expected = IllegalArgumentException.class)
	public void lendBook_libraryNull_IllegalArgumentException() {
		
		Library library = null;
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		long bookId = 5;
		Calendar dueDate = new GregorianCalendar();
		
		manager.lendBook(library, account, bookId, dueDate);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void lendBook_libraryAccountNull_IllegalArgumentException() {
		
		Library library = new Library();
		LibraryAccount account = null;
		long bookId = 5;
		Calendar dueDate = new GregorianCalendar();
		
		manager.lendBook(library, account, bookId, dueDate);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void lendBook_dueDateNull_IllegalArgumentException() {
		
		Library library = new Library();
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		long bookId = 5;
		Calendar dueDate = null;
		
		manager.lendBook(library, account, bookId, dueDate);
	}
	
	@Test
	public void lendBook_legalInput_true() {
		
		Library library = new Library();
		List<LibraryAccount> accounts = new ArrayList<>();
		List<Book> books = new ArrayList<>();
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		long bookId = 5;
		Book book = new Book(bookId, "Title", "Author", false, null);
		books.add(book);
		accounts.add(account);
		library.setAccounts(accounts);
		library.setBooks(books);
		Calendar dueDate = new GregorianCalendar();
		
		boolean condition = manager.lendBook(library, account, bookId, dueDate);
		
		Assert.assertTrue(condition);
	}
	
	@Test
	public void lendBook_accountNotRegistered_false() {
		
		Library library = new Library();
		List<LibraryAccount> accounts = new ArrayList<>();
		List<Book> books = new ArrayList<>();
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		long bookId = 5;
		Book book = new Book(bookId, "Title", "Author", false, null);
		library.setAccounts(accounts);
		books.add(book);
		library.setBooks(books);
		Calendar dueDate = new GregorianCalendar();
		
		boolean condition = manager.lendBook(library, account, bookId, dueDate);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void lendBook_BookAlreadyBorrowed_false() {
		
		Library library = new Library();
		List<LibraryAccount> accounts = new ArrayList<>();
		List<Book> books = new ArrayList<>();
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		long bookId = 5;
		Book book = new Book(bookId, "Title", "Author", true, null);
		books.add(book);
		library.setBooks(books);
		accounts.add(account);
		library.setAccounts(accounts);
		Calendar dueDate = new GregorianCalendar();
		
		boolean condition = manager.lendBook(library, account, bookId, dueDate);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void lendBook_noBookInLibrary_false() {
		
		Library library = new Library();
		List<LibraryAccount> accounts = new ArrayList<>();
		List<Book> books = new ArrayList<>();
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		long bookId = 222;
		accounts.add(account);
		library.setBooks(books);
		library.setAccounts(accounts);
		Calendar dueDate = new GregorianCalendar();
		
		boolean condition = manager.lendBook(library, account, bookId, dueDate);
		
		Assert.assertFalse(condition);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findBookById_bookListNull_IllegalArgumentException() {
		
		List<Book> bookList = null;
		
		manager.findBookById(bookList, 1);
		
	}
	
	@Test
	public void findBookById_legalInput_bookFound() {
		
		List<Book> bookList = new ArrayList<>();
		Book expected = new Book(1, "title", "author", false, null);
		bookList.add(expected);
		
		Book actual = manager.findBookById(bookList, 1);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void findBookById_noBookInList_null() {
		
		List<Book> bookList = new ArrayList<>();
		bookList.add(new Book(1, "title1", "author1", false, null));
		bookList.add(new Book(2, "title2", "author2", false, null));
		Book expected = null;
		
		Book actual = manager.findBookById(bookList, 15);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void returnBook_libraryNull_IllegalArgumentException() {
		
		Library library = null;
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		long bookId = 5;
		
		manager.returnBook(library, account, bookId);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void returnBook_libraryAccountNull_IllegalArgumentException() {
		
		Library library = new Library();
		LibraryAccount account = null;
		long bookId = 5;
		
		manager.returnBook(library, account, bookId);
	}
	
	@Test
	public void returnBook_legalInput_true() {
		
		Library library = new Library();
		List<LibraryAccount> accounts = new ArrayList<>();
		List<Book> books = new ArrayList<>();
		
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		long bookId = 5;
		Book book = new Book(bookId, "Title", "Author", true, null);
		account.getBorrowedBooks().add(book);
		
		books.add(book);
		accounts.add(account);
		
		library.setAccounts(accounts);
		library.setBooks(books);
		
		boolean condition = manager.returnBook(library, account, bookId);
		
		Assert.assertTrue(condition);
	}
	
	@Test
	public void returnBook_accountNotRegistered_false() {
		
		Library library = new Library();
		List<LibraryAccount> accounts = new ArrayList<>();
		List<Book> books = new ArrayList<>();
		
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		long bookId = 5;
		Book book = new Book(bookId, "Title", "Author", true, null);
		account.getBorrowedBooks().add(book);
		
		books.add(book);
		
		library.setAccounts(accounts);
		library.setBooks(books);
		
		boolean condition = manager.returnBook(library, account, bookId);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void returnBook_noLendedBook_false() {
		
		Library library = new Library();
		List<LibraryAccount> accounts = new ArrayList<>();
		List<Book> books = new ArrayList<>();
		
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		long bookId = 5;
		Book book = new Book(bookId, "Title", "Author", true, null);
		
		account.getBorrowedBooks().add(book);
		accounts.add(account);
		
		library.setAccounts(accounts);
		library.setBooks(books);
		
		boolean condition = manager.returnBook(library, account, bookId);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void returnBook_noBorrowedBook_false() {
		
		Library library = new Library();
		List<LibraryAccount> accounts = new ArrayList<>();
		List<Book> books = new ArrayList<>();
		
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		long bookId = 5;
		Book book = new Book(bookId, "Title", "Author", true, null);
		
		books.add(book);
		accounts.add(account);
		
		library.setAccounts(accounts);
		library.setBooks(books);
		
		boolean condition = manager.returnBook(library, account, bookId);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void returnBook_sameIdDifferentBooks_false() {
		
		Library library = new Library();
		List<LibraryAccount> accounts = new ArrayList<>();
		List<Book> books = new ArrayList<>();
		
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		long bookId = 5;
		Book book1 = new Book(bookId, "Title1", "Author1", true, null);
		Book book2 = new Book(bookId, "Title2", "Author2", true, null);
		
		account.getBorrowedBooks().add(book1);
		books.add(book2);
		accounts.add(account);
		
		library.setAccounts(accounts);
		library.setBooks(books);
		
		boolean condition = manager.returnBook(library, account, bookId);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void returnBook_bookIsNotBorrowed_false() {
		
		Library library = new Library();
		List<LibraryAccount> accounts = new ArrayList<>();
		List<Book> books = new ArrayList<>();
		
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		long bookId = 5;
		Book book = new Book(bookId, "Title", "Author", false, null);
		account.getBorrowedBooks().add(book);
		
		books.add(book);
		accounts.add(account);
		
		library.setAccounts(accounts);
		library.setBooks(books);
		
		boolean condition = manager.returnBook(library, account, bookId);
		
		Assert.assertFalse(condition);
	}
	
	@Test
	public void registerAccount_legalInput_true() {
		
		Library library = new Library();
		List<LibraryAccount> accounts = new ArrayList<>();
		
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		
		library.setAccounts(accounts);
		
		boolean condition = manager.registerAccount(library, account);
		
		Assert.assertTrue(condition);
	}
	
	@Test
	public void registerAccount_accountAlreadyRegistered_false() {
		
		Library library = new Library();
		List<LibraryAccount> accounts = new ArrayList<>();
		
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		accounts.add(account);
		
		library.setAccounts(accounts);
		
		boolean condition = manager.registerAccount(library, account);
		
		Assert.assertFalse(condition);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void registerAccount_libraryNull_IllegalArgumentException() {
		
		Library library = null;
		
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		
		manager.registerAccount(library, account);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void registerAccount_accountNull_IllegalArgumentException() {
		
		Library library = new Library();
		List<LibraryAccount> accounts = new ArrayList<>();
		library.setAccounts(accounts);
		
		LibraryAccount account = null;
		
		manager.registerAccount(library, account);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deregisterAccount_libraryNull_IllegalArgumentException() {
		
		Library library = null;
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		
		manager.deregisterAccount(library, account);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deregisterAccount_accountNull_IllegalArgumentException() {
		
		Library library = new Library();
		LibraryAccount account = null;
		
		manager.deregisterAccount(library, account);
	}
	
	@Test
	public void deregisterAccount_legalInput_true() {
		
		Library library = new Library();
		List<LibraryAccount> accounts = new ArrayList<>();
		
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		accounts.add(account);
		
		library.setAccounts(accounts);
		
		boolean condition = manager.deregisterAccount(library, account);
		
		Assert.assertTrue(condition);
	}
	
	@Test
	public void deregisterAccount_unregisteredAccount_false() {
		
		Library library = new Library();
		List<LibraryAccount> accounts = new ArrayList<>();
		
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		
		library.setAccounts(accounts);
		
		boolean condition = manager.deregisterAccount(library, account);
		
		Assert.assertFalse(condition);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void isRegistered_libraryNull_IllegalArgumentException() {
		
		Library library = null;
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		
		manager.isRegistered(library, account);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void isRegistered_accountNull_IllegalArgumentException() {
		
		Library library = new Library();
		LibraryAccount account = null;
		
		manager.isRegistered(library, account);
	}
	
	@Test
	public void isRegistered_validData_true() {
		
		Library library = new Library();
		List<LibraryAccount> accounts = new ArrayList<>();
		
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);
		accounts.add(account);
		library.setAccounts(accounts);
		
		boolean condition = manager.isRegistered(library, account);
		
		Assert.assertTrue(condition);
	}
	
	@Test
	public void isRegistered_noAccountInLibrary_false() {
		
		Library library = new Library();
		List<LibraryAccount> accounts = new ArrayList<>();
		
		LibraryAccount account = new LibraryAccount(1, "name", new ArrayList<Book>(), "address", true);

		library.setAccounts(accounts);
		
		boolean condition = manager.isRegistered(library, account);
		
		Assert.assertFalse(condition);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findLendedBooks_libraryNull_IllegalArgumentException() {
		
		Library library = null;
		
		manager.findLendedBooks(library);
	}
	
	@Test
	public void findLendedBooks_validData_listWithOneBook() {
		
		Library library = new Library();
		List<Book> books = new ArrayList<>();
		Book book = new Book(1, "title", "author", true, new GregorianCalendar());
		books.add(book);
		library.setBooks(books);
		List<Book> expected = new ArrayList<>();
		expected.add(book);
		
		List<Book> actual = manager.findLendedBooks(library);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void findLendedBooks_noLendedBooks_emptyList() {
		
		Library library = new Library();
		List<Book> books = new ArrayList<>();
		books.add(new Book(1, "title", "author", false, new GregorianCalendar()));
		library.setBooks(books);
		List<Book> expected = new ArrayList<>();
		
		List<Book> actual = manager.findLendedBooks(library);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void findLibraryById_legalInput_libraryFound() {
		
		List<Library> libraries = new ArrayList<>();
		Library library = new Library();
		long libraryId = 1;
		library.setLibraryId(libraryId);
		libraries.add(library);
		
		Library expected = new Library();
		expected.setLibraryId(libraryId);
		
		Library actual = manager.findLibraryById(libraries, libraryId);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void findLibraryById_noLibrary_null() {
		
		List<Library> libraries = new ArrayList<>();
		Library library = new Library();
		library.setLibraryId(1);
		libraries.add(library);
		
		Library expected = null;
		
		Library actual = manager.findLibraryById(libraries, 33);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findLibraryById_librariesNull_IllegalArgumentException() {
		
		List<Library> libraries = null;
		long libraryId = 1;
		
		manager.findLibraryById(libraries, libraryId);
	}
	
	@Test
	public void findAccountById_validData_accountFound() {
		
		List<LibraryAccount> accounts = new ArrayList<>();
		LibraryAccount account = new LibraryAccount();
		long accountId = 1;
		account.setLibraryAccountId(accountId);
		accounts.add(account);
		
		LibraryAccount expected = new LibraryAccount();
		expected.setLibraryAccountId(accountId);
		
		LibraryAccount actual = manager.findAccountById(accounts, accountId);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void findAccountById_validData_null() {
		
		List<LibraryAccount> accounts = new ArrayList<>();
		LibraryAccount account = new LibraryAccount();
		long accountId = 1;
		account.setLibraryAccountId(accountId);
		accounts.add(account);
		
		LibraryAccount expected = null;
		
		LibraryAccount actual = manager.findAccountById(accounts, 4);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findAccountById_accountsNull_IllegalArgumentException() {
		
		List<LibraryAccount> accounts = null;
		long accountId = 1;
		
		manager.findAccountById(accounts, accountId);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findLibrariesBooksIds_librariesNull_IllegalArgumentException() {
		
		List<Library> libraries = null;
		
		manager.findLibrariesBooksIds(libraries);
	}
	
	@Test
	public void findLibrariesBooksIds_listHasLibrariesWithBooks_matrix() {
		
		List<Library> libraries = new ArrayList<>();
		
		Library library1 = new Library();
		List<Book> books1 = new ArrayList<>();
		library1.setBooks(books1);
		Book book1 = new Book(1, "title1", "author1", false, null);
		Book book2 = new Book(2, "title2", "author2", false, null);
		books1.add(book1);
		books1.add(book2);
		
		Library library2 = new Library();
		List<Book> books2 = new ArrayList<>();
		library2.setBooks(books2);
		Book book3 = new Book(3, "title3", "author3", false, null);
		Book book4 = new Book(4, "title4", "author4", false, null);
		books2.add(book3);
		books2.add(book4);
		
		libraries.add(library1);
		libraries.add(library2);
		
		long[][] expecteds = {{1, 2}, {3, 4}};
		
		long[][] actuals = manager.findLibrariesBooksIds(libraries);
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
}
