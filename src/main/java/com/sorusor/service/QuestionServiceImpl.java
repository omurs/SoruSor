package com.sorusor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sorusor.dao.QuestionDao;
import com.sorusor.model.Question;
import com.sorusor.model.User;
 
 
@Service("questionService")
@Transactional
public class QuestionServiceImpl implements QuestionService{
 
	@Autowired
    private QuestionDao dao;
	 
	@Override
	public Question findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Question> findByUser(User user) {
		return dao.findByUser(user.getId());
	}

	@Override
	public List<Question> findAllQuestions() {
		return dao.findAllQuestions();
	}
    
	@Override
	public void saveQuestion(Question question) {
		dao.save(question);
	}

	@Override
	public void deleteQuestion(Question question) {
		dao.delete(question);
	}

	@Override
	public void deleteQuestionByUser(User user) {
		dao.deleteByUser(user);
		
	}

	
	
}