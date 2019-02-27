/* unit tests for BookContainerLogic class
 * laboratory work ¹12 - Java Multidimensional Arrays
 * version: 1.0
 * Author: Gilevskiy Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 26.12.2018
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.logic;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.container.BookContainer;
import by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.entity.Book;

public class BookContainerLogicTest {
	
	private static BookContainerLogic logic;
	
	@BeforeClass
	public static void setUp() {
		logic = new BookContainerLogic();
	}

	@Test(expected = IllegalArgumentException.class)
	public void findById_containerNull_IllegalArgumentException() {
		
		BookContainer container = null;
		
		logic.findById(container, 3);
	}
	
	@Test
	public void findById_noBookWihChosenId_null() {
		
		BookContainer container = new BookContainer();
		Book book = new Book();
		book.setBookId(1);
		container.add(book);
		
		Book expected = null;

		
		Book actual = logic.findById(container, 3);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void findById_noBookWihChosenId_book() {
		
		BookContainer container = new BookContainer();
		Book book = new Book();
		long bookId = 1;
		book.setBookId(bookId);
		container.add(book);
		
		Book expected = new Book();
		expected.setBookId(bookId);
		
		Book actual = logic.findById(container, bookId);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findAllByAuthor_containerNull_IllegalArgumentException() {
		
		BookContainer container = null;
		String author = "Author";
		
		logic.findAllByAuthor(container, author);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findAllByAuthor_authorNull_IllegalArgumentException() {
		
		BookContainer container = new BookContainer();
		String author = null;
		
		logic.findAllByAuthor(container, author);	
	}
	
	@Test
	public void findAllByAuthor_validData_containerWithBooks() {
		
		BookContainer container = new BookContainer();
		
		Book book1 = new Book();
		Book book2 = new Book();
		Book book3 = new Book();
		
		String author = "Alice";
		
		book1.setAuthor(author);
		book2.setAuthor(author);
		book3.setAuthor("Bob");
		
		container.add(book1);
		container.add(book2);
		container.add(book3);
		
		int expected = 2;
		
		int actual = logic.findAllByAuthor(container, author).size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void findAllByAuthor_noBooksWithChosenAuthor_emptyContainer() {
		
		BookContainer container = new BookContainer();
		
		Book book1 = new Book();
		Book book2 = new Book();
		
		String author = "Alice";
		
		book1.setAuthor(author);
		book2.setAuthor(author);
		
		container.add(book1);
		container.add(book2);
		
		int expected = 0;

		
		int actual = logic.findAllByAuthor(container, "Bob").size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findBorrowed_containerNull_IllegalArgumentException() {
		
		BookContainer container = null;
		
		logic.findBorrowed(container);	
	}
	
	@Test
	public void findBorrowed_noBooksBorrowed_emptyContainer() {
		
		BookContainer container = new BookContainer();
		
		Book book1 = new Book();
		Book book2 = new Book();
		
		container.add(book1);
		container.add(book2);
		
		int expected = 0;
		
		int actual = logic.findBorrowed(container).size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void findBorrowed_OneBookBorrowed_containerWithOneBook() {
		
		BookContainer container = new BookContainer();
		
		Book book1 = new Book();
		book1.setBorrowed(true);
		Book book2 = new Book();
		
		container.add(book1);
		container.add(book2);
		
		Book expected = new Book();
		expected.setBorrowed(true);
		
		Book actual = logic.findBorrowed(container).get(0);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void countAuthorBooks_containerNull_IllegalArgumentException() {
		
		BookContainer container = null;
		String author = "Author";
		
		logic.countAuthorBooks(container, author);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void countAuthorBooks_authorNull_IllegalArgumentException() {
		
		BookContainer container = new BookContainer();
		String author = null;
		
		logic.countAuthorBooks(container, author);
	}
	
	@Test
	public void countAuthorBooks_validData_Two() {
		
		BookContainer container = new BookContainer();
		
		Book book1 = new Book();
		Book book2 = new Book();
		Book book3 = new Book();
		
		String author = "Alice";
		
		book1.setAuthor(author);
		book2.setAuthor(author);
		book3.setAuthor("Bob");
		
		container.add(book1);
		container.add(book2);
		container.add(book3);
		
		int expected = 2;
		
		int actual = logic.countAuthorBooks(container, author);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void countAuthorBooks_noBooksWithChosenAuthor_Zero() {
		
		BookContainer container = new BookContainer();
		
		Book book1 = new Book();
		Book book2 = new Book();
		
		String author = "Alice";
		
		book1.setAuthor(author);
		book2.setAuthor(author);
		
		container.add(book1);
		container.add(book2);
		
		int expected = 0;

		
		int actual = logic.countAuthorBooks(container, author);
		
		Assert.assertEquals(expected, actual);
	}
}
