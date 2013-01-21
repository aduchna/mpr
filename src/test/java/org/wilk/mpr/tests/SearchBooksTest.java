
package org.wilk.mpr.tests;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.wilk.mpr.beans.Author;
import org.wilk.mpr.beans.Book;
import org.wilk.mpr.beans.Bookstore;
import org.wilk.mpr.core.SearchBooks;

public class SearchBooksTest {
    
    SearchBooks searchBooks;
    
    @Before
    public void setUp() {
        SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        searchBooks = new SearchBooks(sessionFactory);
        
        Transaction transaction = session.beginTransaction();
        
        Bookstore bookstore = new Bookstore("Matras");
        bookstore.setAdress("Podmiejska 15a");
        
        Author kowalski = new Author();
        Author grebosz  = new Author();
        
        kowalski.setName("Jan Kowalski");
        grebosz.setName("Jerzy Grębosz");
        
        kowalski.setAdress("Warszawa 12-223, Wojska Polskiego 18");
        grebosz.setAdress("Warszawa 12-223, Wojska Polskiego 19");
        
        List<Author> authors = new ArrayList<Author>();
        authors.add(grebosz);
        authors.add(kowalski);
        
        kowalski.setBookstore(bookstore);
        grebosz.setBookstore(bookstore);
        
        bookstore.setAuthors(authors);
        
        Book cpp = new Book();
        Book kuchnia = new Book();
        Book ogrody = new Book();
        
        cpp.setTitle("Symfonia C++");
        cpp.setIsbn("23123-2302");
        
        kuchnia.setTitle("Kuchnia polska");
        kuchnia.setIsbn("2392-09330-39");
        
        ogrody.setTitle("Ogrody polskie");
        ogrody.setIsbn("324324-2323-45");
        
        List<Book> books = new ArrayList<Book>();
        books.add(cpp);
        
        grebosz.setBooks(books);
        cpp.setAuthor(grebosz);
        
        books = new ArrayList<Book>();
        books.add(kuchnia);
        books.add(ogrody);
        
        kowalski.setBooks(books);
        kuchnia.setAuthor(kowalski);
        ogrody.setAuthor(grebosz); 
        
        session.save(bookstore);
        
        transaction.commit();
        session.close();
    }
    
    @Test
    public void searchByTitle() {
        List<Book> result = searchBooks.searchByTitle("Kuchnia polska");
        assertEquals(1, result.size());
        assertEquals("Kuchnia polska", result.get(0).getTitle());
    }
    
    @Test
    public void searchByIsbn() {
        List<Book> result = searchBooks.searchByIsbn("23123-2302");
        assertEquals(1, result.size());
        assertEquals("23123-2302", result.get(0).getIsbn());
    }
}
