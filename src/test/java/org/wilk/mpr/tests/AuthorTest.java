
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
    
    @Before // metoda z tą adnotacją wykonuję się przed testami
    public void setUp() {
        author = new Author();
    }
    
    @Test // metoda z tą adnotacją oznacza test - i wykonywana jest jako test przez JUnit'a
    public void name() {
        author.setName("test");
        assertEquals("test", author.getName()); // pierwszy elemnt to wartość oczekiwana drugi to zwrócona
        // jeśli są te same to assercja zwraca true i test jest zaliczony, w wypadku false test zwraca fail
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
        assertSame(books, author.getBooks()); // assercja sprawdza czy mamy do czynienia z dokładnie z tym samym obiektem na podstawie adresu w pamięci komputera
    }
}
