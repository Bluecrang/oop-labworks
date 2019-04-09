/* LibraryAccount entity
 * laboratory work ¹12 - Java Multidimensional Arrays
 * version: 1.0
 * Authors: Gilevskiy Denis Alexandrovich, Kitaiharodski Pavel
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 20.12.2018
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.entity;

import java.util.ArrayList;
import java.util.List;

public class LibraryAccount {
	
	private long libraryAccountId;
	private String fullName;
	private List<Book> borrowedBooks;
	private String address;
	private boolean active;
	
	public LibraryAccount() {}
	
	public LibraryAccount(long libraryAccountId, String fullName, List<Book> borrowedBooks, String address,
			boolean active) {
		this.libraryAccountId = libraryAccountId;
		this.fullName = fullName;
		this.borrowedBooks = borrowedBooks;
		this.address = address;
		this.active = active;
	}
	
	public LibraryAccount(LibraryAccount account) {
		this.libraryAccountId = account.libraryAccountId;
		this.fullName = account.fullName;
		this.borrowedBooks = new ArrayList<>();
		for (Book book : borrowedBooks) {
			this.borrowedBooks.add(new Book(book));
		}
		this.address = account.address;
		this.active = account.active;
	}

	public long getLibraryAccountId() {
		return libraryAccountId;
	}

	public void setLibraryAccountId(long libraryCardId) {
		this.libraryAccountId = libraryCardId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((borrowedBooks == null) ? 0 : borrowedBooks.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + (int) (libraryAccountId ^ (libraryAccountId >>> 32));
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
		LibraryAccount other = (LibraryAccount) obj;
		if (active != other.active)
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (borrowedBooks == null) {
			if (other.borrowedBooks != null)
				return false;
		} else if (!borrowedBooks.equals(other.borrowedBooks))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (libraryAccountId != other.libraryAccountId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ID: ");
		sb.append(libraryAccountId)
		.append("; NAME: ").append(fullName)
		.append("; ADDRESS: ").append(address);
		return sb.toString();
	}	
}
