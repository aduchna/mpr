
package org.wilk.mpr.core;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.wilk.mpr.beans.Book;


public class SearchBooks {
    
    private SessionFactory sf;
    
    public SearchBooks(SessionFactory sessionFactory) {
        sf = sessionFactory;
    }
    
    public List<Book> searchByTitle(String title) {
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Book.class);
        criteria.add(Restrictions.eq("title", title));
        List<Book> result = criteria.list();
        
        transaction.commit();

        return result;
    }
    
    public List<Book> searchByIsbn(String isbn) {
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Book.class);
        criteria.add(Restrictions.eq("isbn", isbn));
        List<Book> result = criteria.list();
        
        transaction.commit();

        return result;
    }
}
