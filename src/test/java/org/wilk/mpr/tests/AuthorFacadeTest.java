
package org.wilk.mpr.tests;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.wilk.mpr.beans.Author;
import org.wilk.mpr.core.facade.AuthorFacade;


public class AuthorFacadeTest {
    
    private AuthorFacade authorFacade;
    private Author author;
    
    @Before
    public void setUp() {
        SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
        authorFacade = new AuthorFacade(sessionFactory);
        
        author = new Author();
        author.setName("Picasso");
        author.setAdress("Gdańsk, Malownicza 123");
    }
    
    @Test
    public void add() {
        authorFacade.add(author);
        assertNotNull(author.getId());
    }
    
    @Test
    public void remove() {
        add();
        authorFacade.remove(author);
        author = authorFacade.get(author.getId());
        assertNull(author);
    }
    
    @Test
    public void get() {
        add();
        String name = authorFacade.get(author.getId()).getName();
        assertEquals("Picasso", name);
    }
    
    @Test
    public void update() {
        add();
        author.setName("Matejko");
        authorFacade.update(author);
        String name = authorFacade.get(author.getId()).getName();
        assertEquals("Matejko", name);
    } 
}
