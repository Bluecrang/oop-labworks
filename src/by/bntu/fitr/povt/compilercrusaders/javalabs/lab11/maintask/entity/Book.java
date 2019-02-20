/* Book entity
 * laboratory work ¹11 - Java One-dimensional Arrays
 * version: 1.0
 * Authors: Gilevskiy Denis Alexandrovich, Kitaiharodski Pavel
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 20.12.2018
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.maintask.entity;

import java.util.Calendar;

public class Book {
	
	private long bookId;
	private String title;
	private String author;
	private boolean borrowed;
	private Calendar dueDate;
	
	public Book() {}
	
	public Book(long bookId, String title, String author, boolean borrowed, Calendar dueDate) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.borrowed = borrowed;
		this.dueDate = dueDate;
	}
	
	public Book(Book book) {
		this.bookId = book.bookId;
		this.title = book.title;
		this.author = book.author;
		this.borrowed = book.borrowed;
		this.dueDate = book.dueDate;
	}
	
	public long getBookId() {
		return bookId;
	}
	
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public boolean isBorrowed() {
		return borrowed;
	}
	
	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}
	
	public Calendar getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}
	
	@Override
	public String toString() {
		return "ID: " + bookId + 
		"; TITLE: " + title + 
		"; AUTHOR: " + author +
		"; BORROWED: " + borrowed;
	}	
}
