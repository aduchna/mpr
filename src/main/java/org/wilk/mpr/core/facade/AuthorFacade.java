
package org.wilk.mpr.core.facade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.wilk.mpr.beans.Author;


public class AuthorFacade {
    
    private SessionFactory sf;
    
    public AuthorFacade(SessionFactory sessionFactory) {
        sf = sessionFactory;
    }
    
    public void add(Author author) {
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(author);
        session.flush();
        transaction.commit();
    }
    
    public void remove(Author author) {
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(author);
        transaction.commit();
    }
    
    public Author get(Long id) {
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Author author = (Author)session.get(Author.class, id);
        transaction.commit();
        
        return author;
    }
    
    public void update(Author author) {
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(author);
        transaction.commit();
    }
}
