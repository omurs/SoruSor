package com.sorusor.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
public abstract class AbstractDao<PK extends Serializable, T> {
     
    private final Class<T> persistentClass;
     
    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
     
    @PersistenceContext
    EntityManager entityManager;
     
    protected EntityManager getEntityManager(){
        return this.entityManager;
    }
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    protected T getByKey(PK key) {
        return (T) entityManager.find(persistentClass, key);
    }
 
    protected void persist(T entity) {
        entityManager.persist(entity);
    }
     
    protected void update(T entity) {
        entityManager.merge(entity);
    }
 
    protected void delete(T entity) {
        entityManager.remove(entity);
    }
    
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
}