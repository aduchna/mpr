package org.wilk.mpr.core;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.wilk.mpr.beans.Author;
import org.wilk.mpr.beans.Book;
import org.wilk.mpr.beans.Bookstore;


public class Main {
    
    public static void main( String[] args )
    {
        SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
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
        
        SearchBooks searchBooks = new SearchBooks(sessionFactory);
        
        List<Book> result = searchBooks.searchByTitle("Kuchnia polska");
        
        System.out.println("Result search by title:");
        for(Book book : result) {
            System.out.println(book.getTitle());
            System.out.println(book.getIsbn());
            System.out.println(book.getAuthor().getName());
        }
        
        result = searchBooks.searchByIsbn("23123-2302");
        
        System.out.println("Result search by isbn:");
        for(Book book : result) {
            System.out.println(book.getTitle());
            System.out.println(book.getIsbn());
            System.out.println(book.getAuthor().getName());
        }
    }
}
