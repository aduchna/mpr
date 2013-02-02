
package org.wilk.mpr.tests;

import org.junit.Before;
import org.junit.Test;
import org.wilk.mpr.beans.Book;
import static org.junit.Assert.*;
import org.wilk.mpr.beans.Author;

// patrz opis Author Test
public class BookTest {
    
    private Book book;
    
    @Before
    public void setUp() {
        book = new Book();
    }
    
    @Test
    public void title() {
        book.setTitle("test");
        assertEquals("test", book.getTitle());
    }
    
    @Test
    public void isbn() {
        book.setIsbn("test");
        assertEquals("test", book.getIsbn());
    }
    
    @Test
    public void author() {
        Author author = new Author();
        book.setAuthor(author);
        assertSame(author, book.getAuthor());
    }
}
