package com.sorusor.dao;

import java.util.List;
import com.sorusor.model.Question;
//import com.sorusor.model.Subject;
import com.sorusor.model.User;

public interface QuestionDao {
	 	
		Question findById(int id);
	     
		List<Question> findBySubject(Integer subjectId);
	    
		List<Question>  findByUser(Integer userId);
	    
	    void save(Question question);
	    
	    void update(Question question);
	    
	    void delete(Question question);
	     
	    void deleteBySubject(Integer subject);
	    
	    void deleteByUser(User user); 
	    
	    List<Question> findAllQuestions();

	 
}
