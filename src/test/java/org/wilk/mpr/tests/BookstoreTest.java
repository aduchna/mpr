
package org.wilk.mpr.tests;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.wilk.mpr.beans.Author;
import org.wilk.mpr.beans.Bookstore;

// patrz opis Author Test
public class BookstoreTest {
    
    private Bookstore bookstore;
    
    @Before
    public void setUp() {
        bookstore = new Bookstore();
    }
    
    @Test
    public void name() {
        bookstore.setName("test");
        assertEquals("test", bookstore.getName());
    }
    
    @Test        
    public void adress() {
        bookstore.setAdress("test");
        assertEquals("test", bookstore.getAdress());
    }
    
    @Test
    public void authors() {
        List<Author> authors = new ArrayList<Author>();
        bookstore.setAuthors(authors);
        assertSame(authors, bookstore.getAuthors());
    }
}
