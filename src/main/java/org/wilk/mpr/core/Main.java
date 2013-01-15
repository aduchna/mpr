package org.wilk.mpr.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.wilk.mpr.beans.Bookstore;
import org.wilk.mpr.hibernate.HibernateUtil;


public class Main {
    
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
            
        Transaction transaction = session.beginTransaction();
        
        Bookstore bookstore = new Bookstore("Matras");
        bookstore.setAdress("Podmiejska 15a");
        
        
        session.save(bookstore);
        
        transaction.commit();
        session.close();
    }
}
