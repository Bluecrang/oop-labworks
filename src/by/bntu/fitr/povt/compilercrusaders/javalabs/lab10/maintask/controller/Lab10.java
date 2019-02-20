/* Controller for vector calculator
 * laboratory work ¹11 - Java One-dimensional Arrays
 * version: 1.0
 * Authors: Gilevskiy Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 18.02.2019
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab10.maintask.controller;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.maintask.entity.Book;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.maintask.entity.Library;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.maintask.entity.LibraryAccount;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.maintask.logic.LibraryManager;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.view.Printer;

public class Lab10 {
	
	public static void main(String[] args) {
		
		List<Book> libraryBooks = new ArrayList<Book>();
		libraryBooks.add(new Book(1, "Treasure Island", "Robert Louis Stevenson", false, null));
		libraryBooks.add(new Book(2, "Crime and Punishment", "Fyodor Dostoevsky", false, null));
		libraryBooks.add(new Book(3, "War and Peace", "Leo Tolstoy", false, null));
		
		List<LibraryAccount> libraryAccounts = new ArrayList<LibraryAccount>();
		
		Library library = new Library(
				1, 
				"Bibliotheca Alexandrina", 
				libraryBooks, 
				libraryAccounts, 
				"21-24-54", 
				"7361 Evergreen Road Howard Beach, NY 11414");
		
		LibraryAccount account1 = new LibraryAccount(1, "Vasilii Popov", new ArrayList<Book>(), "445 Mount Eden Road, Mount Eden, Auckland", true);
		LibraryAccount account2 = new LibraryAccount(2, "Ivan Ivanovich", new ArrayList<Book>(), "21 Greens Road RD 2 Ruawai 0592", true);
		
		LibraryManager manager = new LibraryManager();
		
		Printer printer = new Printer();
		
		printer.println("Initial registered account owners:");
		for (LibraryAccount account : libraryAccounts) {
			printer.println(account.getFullName());
		}
		printer.println("\n");
		
		manager.registerAccount(library, account1);
		manager.registerAccount(library, account2);
		
		printer.println("Initial books in library:");
		for (Book book : libraryBooks) {
			printer.println(book.getTitle());
			printer.println("Is It Borrowed? - " + book.isBorrowed());
		}
		printer.println("\n");
		
		printer.println("Library account owners after two registrations:");
		for (LibraryAccount account : libraryAccounts) {
			printer.println(account.getFullName());
		}
		printer.println("\n");
		
		manager.lendBook(library, account1, "Treasure Island", new GregorianCalendar(2018, 10, 21));
		manager.lendBook(library, account2, "Crime and Punishment", new GregorianCalendar(2018, 11, 15));
		
		printer.println("Books in library after two was borrowed:");
		for (Book book : libraryBooks) {
			printer.println(book.getTitle());
			printer.println("Is It Borrowed? - " + book.isBorrowed());
		}
		printer.println("\n");
		
		printer.println("All lended books:");
		for (Book book : manager.findLendedBooks(library)) {
			printer.println(book.getTitle());
			printer.println("Is It Borrowed? - " + book.isBorrowed());
		}
		printer.println("\n");
		
		manager.returnBook(library, account1, "Treasure Island");
		manager.returnBook(library, account2, "Crime and Punishment");
		
		printer.println("Books in library after two returns:");
		for (Book book : libraryBooks) {
			printer.println(book.getTitle());
			printer.println("Is It Borrowed? - " + book.isBorrowed());
		}
		printer.println("\n");
		
		manager.deregisterAccount(library, account1);
		manager.deregisterAccount(library, account2);
		
		printer.println("Library account owners after two deregistrations:");
		for (LibraryAccount account : libraryAccounts) {
			printer.println(account.getFullName());
		}
		printer.println("\nEND");
		
	}
}
