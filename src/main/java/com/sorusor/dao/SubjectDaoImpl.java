package com.sorusor.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import com.sorusor.model.Subject;
 
 
	 
	@Repository("subjectDao")
	public class SubjectDaoImpl extends AbstractDao<Integer, Subject> implements SubjectDao {

// 
//    @SuppressWarnings("unchecked")
//    public List<User> findAllUsers() {
//        List<User> users = getEntityManager()
//                .createQuery("SELECT u FROM User u ORDER BY u.firstName ASC")
//                .getResultList();
//        return users;
//    }
// 
//    public void save(User user) {
//        persist(user);
//    }
// 
//    public void deleteByEmail(String email) {
//        User user = (User) getEntityManager()
//                .createQuery("SELECT u FROM User u WHERE u.email LIKE :email")
//                .setParameter("email", email)
//                .getSingleResult();
//        delete(user);
//    }
//    //An alternative to Hibernate.initialize()
//    protected void initializeCollection(Collection<?> collection) {
//        if(collection == null) {
//            return;
//        }
//        collection.iterator().hasNext();
//    }
//
//	@Override
//	public User findByEmail(String email) {
//
//        System.out.println("Email : "+email);
//        try{
//            User user = (User) getEntityManager()
//                    .createQuery("SELECT u FROM User u WHERE u.email LIKE :email")
//                    .setParameter("email", email)
//                    .getSingleResult();
//             
//            if(user!=null){
//                initializeCollection(user.getUserProfiles());
//            }
//            return user; 
//        }catch(NoResultException ex){
//            return null;
//        }
//    
//	}

	@Override
	public List<Subject> findAll() {
        @SuppressWarnings("unchecked")
		List<Subject> subjects = getEntityManager()
                .createQuery("SELECT s FROM Subject s ORDER BY s.id ASC")
                .getResultList();
        return subjects;
    }

	@Override
	public Subject findById(int id) {
	    Subject subject = getByKey(id);
	    return subject;
	}
}