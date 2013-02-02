
package org.wilk.mpr.core.facade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.wilk.mpr.beans.Book;


public class BookFacade {
     private SessionFactory sf;
    
    public BookFacade(SessionFactory sessionFactory) {
        sf = sessionFactory;
    }
    
    public void add(Book book) {
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        session.flush();
        transaction.commit();
    }
    
    public void remove(Book book) {
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(book);
        transaction.commit();
    }
    
    public Book get(Long id) {
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Book book = (Book)session.get(Book.class, id);
        transaction.commit();
        
        return book;
    }
    
    public void update(Book book) {
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(book);
        transaction.commit();
    }
}
