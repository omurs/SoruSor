package com.sorusor.dao;

import java.util.List;

import com.sorusor.model.Answer;
import com.sorusor.model.Question;
//import com.sorusor.model.Subject;
import com.sorusor.model.User;

public interface AnswerDao {
	 	
		Answer findById(int id);
	     
		List<Answer> findByQuestion(Question subjectId);
	    
		List<Answer>  findByUser(Integer userId);
	    
	    void save(Answer answer);
	    
	    void update(Answer answer);
	    
	    void delete(Answer answer);
	     
//	    void deleteBySubject(Integer subject);
	    
//	    void deleteByUser(User user); 
	    
//	    List<Question> findAllQuestions();

	 
}
