/* LibraryAccount entity
 * laboratory work ¹11 - Java One-dimensional Arrays
 * version: 1.0
 * Authors: Gilevskiy Denis Alexandrovich, Kitaiharodski Pavel
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 20.12.2018
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab10.maintask.entity;

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
		this.borrowedBooks = account.borrowedBooks;
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
}
