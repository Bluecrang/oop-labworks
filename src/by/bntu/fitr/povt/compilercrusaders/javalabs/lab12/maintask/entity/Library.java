/* Library entity
 * laboratory work ¹12 - Java Multidimensional Arrays
 * version: 1.0
 * Authors: Gilevskiy Denis Alexandrovich, Kitaiharodski Pavel
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 20.12.2018
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.entity;

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

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + (int) (libraryId ^ (libraryId >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((telephoneNumber == null) ? 0 : telephoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Library other = (Library) obj;
		if (accounts == null) {
			if (other.accounts != null)
				return false;
		} else if (!accounts.equals(other.accounts))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (libraryId != other.libraryId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (telephoneNumber == null) {
			if (other.telephoneNumber != null)
				return false;
		} else if (!telephoneNumber.equals(other.telephoneNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ID: " + libraryId + 
		"; NAME: " + name +
		"; PHONE NUMBER:" + telephoneNumber +
		"; ADDRESS: " + address;
	}	
}
