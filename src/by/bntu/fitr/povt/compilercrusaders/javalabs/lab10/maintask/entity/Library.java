/* Library entity
 * laboratory work ¹10
 * version: 1.0
 * Authors: Gilevskiy Denis Alexandrovich, Kitaiharodski Pavel
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 20.12.2018
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab10.maintask.entity;

import java.util.List;

public class Library {
	
	private long libraryId;
	private String name;
	private List<Book> books;
	private List<LibraryAccount> accounts;
	private String telephoneNumber;
	private String address;
	
	public Library() {}
	
	public Library(long libraryId, String name, List<Book> books, List<LibraryAccount> accounts, String telephoneNumber,
			String address) {
		this.libraryId = libraryId;
		this.name = name;
		this.books = books;
		this.accounts = accounts;
		this.telephoneNumber = telephoneNumber;
		this.address = address;
	}

	public Library(Library library) {
		this.libraryId = library.libraryId;
		this.name = library.name;
		this.books = library.books;
		this.accounts = library.accounts;
		this.telephoneNumber = library.telephoneNumber;
		this.address = library.address;
	}

	public long getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(long libraryId) {
		this.libraryId = libraryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<LibraryAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<LibraryAccount> accounts) {
		this.accounts = accounts;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}	
}
