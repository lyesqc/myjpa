package com.myjpa.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
public abstract class AbstractDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession() {
    	System.out.println("My SessionFactory " +sessionFactory.isClosed());
        return sessionFactory.getCurrentSession();
    }
    
    public void persist(Object entity) {
        getSession().save(entity);
    }
 
    public void delete(Object entity) {
        getSession().delete(entity);
    }
    public SessionFactory getMySessionFactory() {
		// TODO Auto-generated method stub
		return sessionFactory;
	}
    
}