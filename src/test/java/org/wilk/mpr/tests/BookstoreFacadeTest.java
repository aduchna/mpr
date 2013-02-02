
package org.wilk.mpr.tests;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.wilk.mpr.beans.Bookstore;
import org.wilk.mpr.core.facade.BookstoreFacade;


public class BookstoreFacadeTest {
    
    private BookstoreFacade bookstoreFacade;
    private Bookstore bookstore;
    
    @Before
    public void setUp() {
        SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
        bookstoreFacade = new BookstoreFacade(sessionFactory);
        
        bookstore = new Bookstore();
        bookstore.setName("Matras");
        bookstore.setAdress("Gdańsk, Malownicza 45");
    }
    
    @Test
    public void add() {
        bookstoreFacade.add(bookstore);
        assertNotNull(bookstore.getId());
    }
    
    @Test
    public void remove() {
        add();
        bookstoreFacade.remove(bookstore);
        bookstore = bookstoreFacade.get(bookstore.getId());
        assertNull(bookstore);
    }
    
    @Test
    public void get() {
        add();
        String name = bookstoreFacade.get(bookstore.getId()).getName();
        assertEquals("Matras", name);
    }
    
    @Test
    public void update() {
        add();
        bookstore.setName("Empik");
        bookstoreFacade.update(bookstore);
        String name = bookstoreFacade.get(bookstore.getId()).getName();
        assertEquals("Empik", name);
    } 
}
