package com.sorusor.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.sorusor.model.Question;
//import com.sorusor.model.Subject;
import com.sorusor.model.User;

@Repository("questionDao")
public class QuestionDaoImpl extends AbstractDao<Integer, Question>  implements QuestionDao {

	@Override
	public Question findById(int id) {
		 Question question = getByKey(id);
	        return question;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Question> findBySubject(Integer subjectId) {

        System.out.println("Subject : "+subjectId);
        try{
           
		
			ArrayList<Question> questionList =(ArrayList<Question> ) getEntityManager()
                    .createQuery("SELECT q FROM QUESTION q WHERE q.subject_id =subjectId")
                    .setParameter("subject_id", subjectId)
                    .getResultList();
             
            if(questionList!=null)
            	
            return questionList; 
            
            return null;
        }catch(NoResultException ex){
            return null;
        }
    
	}
	
	  
	@Override
	@SuppressWarnings("unchecked")
	public  List<Question> findByUser(Integer userId) {
		System.out.println("User : "+userId);
        try{
			ArrayList<Question> questionList =(ArrayList<Question> ) getEntityManager()
                    .createQuery("SELECT q FROM QUESTION q WHERE q.user_id =userId")
                    .setParameter("user_id", userId)
                    .getResultList();
             
            if(questionList!=null)
            	
            return questionList; 
            
            return null;
        }catch(NoResultException ex){
            return null;
        }
	}

	@Override
	public void save(Question question) {
		persist(question);
		
	}

	 public void update(Question question){
		 update(question);
	 }
	public void delete(Question question){
//		 question = (Question) getEntityManager()
//	                .createQuery("SELECT q FROM Question q WHERE q.id LIKE :id")
//	                .setParameter("id", question.getId())
//	                .getSingleResult();
	        delete(question);
	 }
	
	

	@Override
	public List<Question> findAllQuestions() {
        try{
			@SuppressWarnings("unchecked")
			ArrayList<Question> questionList =(ArrayList<Question> ) getEntityManager()
                    .createQuery("SELECT q FROM Question q").getResultList();
            	return questionList; 
            
        }catch(NoResultException ex){
            return null;
        }
	
	}

	//An alternative to Hibernate.initialize()
    protected void initializeCollection(Collection<?> collection) {
        if(collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }

	@Override
	public void deleteByUser(User user) {
		 Question question = (Question) getEntityManager()
				 .createQuery("SELECT q FROM Question q WHERE q.user_id LIKE :id")
				 .setParameter("id", user.getId())
				 .getSingleResult();
		 		delete(question);
	}
	@Override
	public void deleteBySubject(Integer subject) {
		Question question = (Question) getEntityManager()
				 .createQuery("SELECT q FROM Question q WHERE q.subject_id LIKE :id")
				 .setParameter("id", subject)
				 .getSingleResult();
			delete(question);
		}

	
}
