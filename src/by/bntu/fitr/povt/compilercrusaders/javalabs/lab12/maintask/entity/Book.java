/* Book entity
 * laboratory work ¹12 - Java Multidimensional Arrays
 * version: 1.0
 * Authors: Gilevskiy Denis Alexandrovich, Kitaiharodski Pavel
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 20.12.2018
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.entity;

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
		this.dueDate = (Calendar) book.dueDate.clone();
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + (int) (bookId ^ (bookId >>> 32));
		result = prime * result + (borrowed ? 1231 : 1237);
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookId != other.bookId)
			return false;
		if (borrowed != other.borrowed)
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("ID: ").append(bookId)
		.append("; TITLE: ").append(title)
		.append("; AUTHOR: ").append(author)
		.append("; BORROWED: ").append(borrowed)
		.append("; DUE DATE: ").append(dueDate);
		return sb.toString();
	}	
}
