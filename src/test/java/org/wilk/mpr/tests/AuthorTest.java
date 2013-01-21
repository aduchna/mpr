
package org.wilk.mpr.tests;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.wilk.mpr.beans.Author;
import org.wilk.mpr.beans.Book;
import org.wilk.mpr.beans.Bookstore;

public class AuthorTest {
    
    private Author author;
    
    @Before
    public void setUp() {
        author = new Author();
    }
    
    @Test
    public void name() {
        author.setName("test");
        assertEquals("test", author.getName());
    }
    
    @Test
    public void adress() {
        author.setAdress("test");
        assertEquals("test", author.getAdress());
    }
    
    @Test
    public void bookstore() {
        Bookstore bookstore = new Bookstore("test");
        author.setBookstore(new Bookstore("test"));
        assertEquals(bookstore.getName(), author.getBookstore().getName());
    }
    
    @Test
    public void books() {
        List<Book> books = new ArrayList<Book>();
        author.setBooks(books);
        assertSame(books, author.getBooks());
    }
}
