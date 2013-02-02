
package org.wilk.mpr.core.facade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.wilk.mpr.beans.Bookstore;


public class BookstoreFacade {
     private SessionFactory sf;
    
    public BookstoreFacade(SessionFactory sessionFactory) {
        sf = sessionFactory;
    }
    
    public void add(Bookstore bookstore) {
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(bookstore);
        session.flush();
        transaction.commit();
    }
    
    public void remove(Bookstore bookstore) {
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(bookstore);
        transaction.commit();
    }
    
    public Bookstore get(Long id) {
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Bookstore bookstore = (Bookstore)session.get(Bookstore.class, id);
        transaction.commit();
        
        return bookstore;
    }
    
    public void update(Bookstore bookstore) {
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(bookstore);
        transaction.commit();
    }
}
