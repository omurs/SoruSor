package com.sorusor.dao;


import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.sorusor.model.User;
 
 
	 
	@Repository("userDao")
	public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
	 
	public User findById(int id) {
	    User user = getByKey(id);
	    if(user!=null){
	        initializeCollection(user.getUserProfiles());
	    }
	    return user;
	}
 
    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        List<User> users = getEntityManager()
                .createQuery("SELECT u FROM User u ORDER BY u.firstName ASC")
                .getResultList();
        return users;
    }
 
    public void save(User user) {
        persist(user);
    }
 
    public void deleteByEmail(String email) {
        User user = (User) getEntityManager()
                .createQuery("SELECT u FROM User u WHERE u.email LIKE :email")
                .setParameter("email", email)
                .getSingleResult();
        delete(user);
    }
    //An alternative to Hibernate.initialize()
    protected void initializeCollection(Collection<?> collection) {
        if(collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }

	@Override
	public User findByEmail(String email) {

        System.out.println("Email : "+email);
        try{
            User user = (User) getEntityManager()
                    .createQuery("SELECT u FROM User u WHERE u.email LIKE :email")
                    .setParameter("email", email)
                    .getSingleResult();
             
            if(user!=null){
                initializeCollection(user.getUserProfiles());
            }
            return user; 
        }catch(NoResultException ex){
            return null;
        }
    
	}
 
}