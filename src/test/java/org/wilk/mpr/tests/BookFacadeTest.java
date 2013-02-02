
package org.wilk.mpr.tests;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.wilk.mpr.beans.Book;
import org.wilk.mpr.core.facade.BookFacade;


public class BookFacadeTest {
    
    private BookFacade bookFacade;
    private Book book;
    
    @Before
    public void setUp() {
        SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
        bookFacade = new BookFacade(sessionFactory);
        
        book = new Book();
        book.setTitle("Pan Tadeusz");
        book.setIsbn("1232-898-BSN");
    }
    
    @Test
    public void add() {
        bookFacade.add(book);
        assertNotNull(book.getId());
    }
    
    @Test
    public void remove() {
        add();
        bookFacade.remove(book);
        book = bookFacade.get(book.getId());
        assertNull(book);
    }
    
    @Test
    public void get() {
        add();
        String title = bookFacade.get(book.getId()).getTitle();
        assertEquals("Pan Tadeusz", title);
    }
    
    @Test
    public void update() {
        add();
        book.setTitle("Pan Lodowego Ogrodu");
        bookFacade.update(book);
        String title = bookFacade.get(book.getId()).getTitle();
        assertEquals("Pan Lodowego Ogrodu", title);
    } 
}
