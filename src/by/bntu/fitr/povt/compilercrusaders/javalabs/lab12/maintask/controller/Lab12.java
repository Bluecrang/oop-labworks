/* Controller for vector calculator
 * laboratory work ¹12 - Java Multidimensional Arrays
 * version: 1.3
 * Authors: Gilevskiy Denis Alexandrovich, Kitaiharodski Pavel
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 26.02.2019
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Date;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.util.KeyboardInput;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.container.BookContainer;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.entity.Book;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.entity.Library;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.entity.LibraryAccount;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.exception.DataException;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.exception.InputException;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.logic.BookContainerLogic;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.logic.LibraryManager;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.view.Printer;

public class Lab12 {
	
	public static void main(String[] args) {
		
		Printer printer = new Printer();
		KeyboardInput input = new KeyboardInput();
		
		BookContainer bookContainer = new BookContainer();
		BookContainerLogic containerLogic = new BookContainerLogic();
		List<Library> libraries = new ArrayList<>();
		
		List<Book> books1 = new ArrayList<>();
		List<LibraryAccount> accounts1 = new ArrayList<>();
		
		List<Book> books2 = new ArrayList<>();
		List<LibraryAccount> accounts2 = new ArrayList<>();

		LibraryManager manager = new LibraryManager();
		
		LibraryAccount account1 = new LibraryAccount(1, "Vasilii Popov", new ArrayList<Book>(), "445 Mount Eden Road, Mount Eden, Auckland", true);
		LibraryAccount account2 = new LibraryAccount(2, "Ivan Volkov", new ArrayList<Book>(), "220  Bassell Avenue", true);
		LibraryAccount account3 = new LibraryAccount(3, "Ivan Ivanov", new ArrayList<Book>(), "1780  Aviation Way", true);
		LibraryAccount account4 = new LibraryAccount(4, "Oleg Korolev", new ArrayList<Book>(), "41835  Wood Street", true);
		
		accounts1.add(account1);
		accounts1.add(account2);
		accounts2.add(account3);
		accounts2.add(account4);
		
		Book book1 = new Book(1, "Tresure Island",  "Robert Louis Stevenson", false, null);
		Book book2 = new Book(2, "An Inland Voyage",  "Robert Louis Stevenson", false, null);
		Book book3 = new Book(3, "War and Peace",  "Leo Tolstoy", false, null);
		Book book4 = new Book(4, "Crime and Punishment",  "Fedor Dostoevsky", false, null);
		
		bookContainer.add(book1);
		bookContainer.add(book2);
		bookContainer.add(book3);
		bookContainer.add(book4);
		
		books1.add(book1);
		books1.add(book2);
		books2.add(book3);
		books2.add(book4);
		
		libraries.add(new Library(1, "Alexandria Library", books1, accounts1, "44-22-11", "Sesame street"));
		libraries.add(new Library(2, "Calgary Public Library,", books2, accounts2, "13-33-28", "Sesame street"));
		
		boolean active = true;
		while (active) {
			printer.println("MENU");
			printer.println("1 - list libraries");
			printer.println("2 - list libraries accounts");
			printer.println("3 - list libraries books");
			printer.println("4 - list borrowed books");
			printer.println("5 - list all books");
			printer.println("6 - add book to the global container");
			printer.println("7 - add book to the library from the global container");
			printer.println("8 - borrow book");
			printer.println("9 - return book");
			printer.println("10 - count books from the same author");
			printer.println("11 - list books from chosen author");
			printer.println("12 - list books ids from all libraries");
			printer.println("13 - exit");
			
			try {
				int choice = input.nextIntInRange(1, 13);
				choiceStart: switch (choice) {
				case 1: {
					for (Library library : libraries) {
						printer.println(library.toString());
					}
					break;
				}
				case 2: {
					for (Library library : libraries) {
						printer.println("Library: " + library.getName());
						for (LibraryAccount account : library.getAccounts()) {
							printer.println("Account:");
							printer.println(account.toString());
							printer.println("Borrowed books:");
							for (Book book : account.getBorrowedBooks()) {
								printer.println(book.toString());
							}
						}
					}
					break;
				}
				case 3: {
					for (Library library : libraries) {
						printer.println("Library: " + library.getName());
						for (Book book : library.getBooks()) {
							printer.println(book.toString());
						}
					}
					break;
				}
				case 4: {
						BookContainer borrowedBooks = containerLogic.findBorrowed(bookContainer);
						for (int i = 0; i < borrowedBooks.size(); i++) {
							printer.println(borrowedBooks.get(i).toString());
							printer.println("When: ", borrowedBooks.get(i).getDueDate());
						}
						break;
					}
				case 5: {
					for (int i = 0; i < bookContainer.size(); i++) {
						printer.println(bookContainer.get(i).toString());
					}
					break;
				}
				case 6: {
					
					printer.println("Enter book id:");
					long id = input.nextPositiveInt();
					
					for (int i = 0; i < bookContainer.size(); i++) {
						if (bookContainer.get(i).getBookId() == id) {
							printer.println("Book with chosen id already exists");
							break choiceStart;
						}
					}
					
					printer.println("Enter title:");
					String name = input.nextLine();
					
					printer.println("Enter author:");
					String author  = input.nextLine();
					
					bookContainer.add(new Book(id, name, author, false, null));
					printer.println("Book successfully added");
					break;
				}
				case 7: {
					
					printer.println("Enter book id:");
					long bookId = input.nextPositiveInt();
					
					Book chosenBook = containerLogic.findById(bookContainer, bookId);
					
					if (chosenBook == null) { 
						printer.println("Book with chosen id does not exist");
						break;
					}
					
					printer.println("Enter library id:");
					long libraryId = input.nextPositiveInt();

					Library chosenLibrary = manager.findLibraryById(libraries, libraryId);
					
					if (chosenLibrary == null) { 
						printer.println("Library with chosen id does not exist");
						break;
					}
					
					List<Book> libraryBooks = chosenLibrary.getBooks();
					for (Library library : libraries) {
						if (library.getBooks().contains(chosenBook)) {
							printer.println("This book is already in the library");
							break choiceStart;
						}
					}
					libraryBooks.add(chosenBook);
					printer.println("Book successfully added to the library");
					
					break;
				}
				case 8: {
					
					printer.println("Enter library id:");
					long libraryId = input.nextPositiveInt();

					Library chosenLibrary = manager.findLibraryById(libraries, libraryId);
					
					if (chosenLibrary == null) { 
						printer.println("Library with chosen id does not exist");
						break;
					}
					
					printer.println("Enter book id:");
					long bookId = input.nextPositiveInt();
					
					Book chosenBook = manager.findBookById(chosenLibrary.getBooks(), bookId);
					
					if (chosenBook == null) { 
						printer.println("Book with chosen id does not exist");
						break;
					}
					
					if (chosenBook.isBorrowed()) {
						printer.println("Book is already borrowed");
						break;
					}
					
					printer.println("Enter account id:");
					long accountId = input.nextPositiveInt();
					
					LibraryAccount chosenAccount = manager.findAccountById(chosenLibrary.getAccounts(), accountId);

					if (chosenAccount == null ) { 
						printer.println("Account with chosen id does not exist");
						break;
					}
					
					if (!manager.isRegistered(chosenLibrary, chosenAccount)) {
						printer.println("This account is not regestered in this library");
						break;
					}
					
					List<Book> libraryBooks = chosenLibrary.getBooks();
					
					if (libraryBooks.contains(chosenBook)) {
						GregorianCalendar e = new  GregorianCalendar();
						e.setTime(new Date());
						if (manager.lendBook(chosenLibrary, chosenAccount, bookId, e)) {
							printer.println("Book successfully borrowed");
						} else {
							printer.println("Can not borrow book");
						}
					}
					
					break;
				}
				case 9: {
					
					printer.println("Enter library id:");
					long libraryId = input.nextPositiveInt();

					Library chosenLibrary = manager.findLibraryById(libraries, libraryId);
					
					if (chosenLibrary == null) { 
						printer.println("Library with chosen id does not exist");
						break;
					}
					
					printer.println("Enter book id:");
					long bookId = input.nextPositiveInt();
					
					Book chosenBook =  manager.findBookById(chosenLibrary.getBooks(), bookId);
					
					if (chosenBook == null) { 
						printer.println("Book with chosen id does not belong to the library");
						break;
					}
					
					if (!chosenBook.isBorrowed()) {
						printer.println("Book is not borrowed");
						break;
					}
					
					printer.println("Enter account id:");
					long accountId = input.nextPositiveInt();
					
					LibraryAccount chosenAccount = manager.findAccountById(chosenLibrary.getAccounts(), accountId);

					if (chosenAccount == null ) { 
						printer.println("Account with chosen id does not exist");
						break;
					}
					
					if (!manager.isRegistered(chosenLibrary, chosenAccount)) {
						printer.println("This account is not regestered in this library");
						break;
					}
					
					List<Book> libraryBooks = chosenLibrary.getBooks();
					
					if (libraryBooks.contains(chosenBook)) {
						if (manager.returnBook(chosenLibrary, chosenAccount, bookId)) {
							printer.println("Book successfully returned");
						} else {
							printer.println("Can not return book");
						}
					}
					
					break;
				}
				case 10: {
					printer.println("Enter author: ");
					String author = input.nextLine();
					int books = containerLogic.countAuthorBooks(bookContainer, author);
					printer.println("number of books: " + books);
					break;
				}
				case 11: {
					printer.println("Enter author: ");
					String author = input.nextLine();
					BookContainer container = containerLogic.findAllByAuthor(bookContainer, author);
					for (int i = 0; i < container.size(); i++) {
						printer.println(container.get(i).toString());
					}
					break;
				}
				case 12: {
					printer.println("Libraries books ids: ");
					printer.println(Arrays.deepToString(manager.findLibrariesBooksIds(libraries)));
					break;
				}
				case 13: {
					active = false;
					break;
				}
				default: {
					printer.println("Unknown command");
				}
				}
			} catch (InputException e) {
				printer.println(e.getMessage());
			} catch (DataException e) {
				printer.println(e.getMessage());
			}				
		}
	}		
}
