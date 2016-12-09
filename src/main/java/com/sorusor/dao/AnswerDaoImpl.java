package com.sorusor.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.sorusor.model.Answer;
import com.sorusor.model.Question;

@Repository("answerDao")
public class AnswerDaoImpl extends AbstractDao<Integer, Answer>  implements AnswerDao {

	@Override
	public Answer findById(int id) {
		Answer answer = getByKey(id);
	        return answer;
	}
	 	
	@Override
	@SuppressWarnings("unchecked")
	public List<Answer> findByQuestion(Question question) {

        System.out.println("Answers : "+question);
        try{
           
		
			ArrayList<Answer> answerList =(ArrayList<Answer> ) getEntityManager()
                    .createQuery("SELECT a FROM Answer a WHERE a.question.id =?")
                    .setParameter(1, question.getId())
                    .getResultList();
             
            if(answerList!=null)
            	
            return answerList; 
            
            return null;
        }catch(NoResultException ex){
            return null;
        }
    
	}
	
	  
	@Override
	@SuppressWarnings("unchecked")
	public  List<Answer> findByUser(Integer userId) {
		System.out.println("User : "+userId);
        try{
			ArrayList<Answer> answerList =(ArrayList<Answer> ) getEntityManager()
					.createQuery("SELECT a FROM Answer a WHERE a.user_id =userId")
                    .setParameter("user_id", userId)
                    .getResultList();
             
            if(answerList!=null)
            	
            return answerList; 
            
            return null;
        }catch(NoResultException ex){
            return null;
        }
	}

	@Override
	public void save(Answer answer) {
		persist(answer);
		
	}

	 public void update(Answer answer){
		 update(answer);
	 }
	public void delete(Answer answer){
	        delete(answer);
	 }
	
	



	//An alternative to Hibernate.initialize()
    protected void initializeCollection(Collection<?> collection) {
        if(collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }


	
}
