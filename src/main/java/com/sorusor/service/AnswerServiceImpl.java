package com.sorusor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sorusor.dao.AnswerDao;
import com.sorusor.dao.QuestionDao;
import com.sorusor.model.Answer;
import com.sorusor.model.Question;
import com.sorusor.model.User;
 
 
@Service("answerService")
@Transactional
public class AnswerServiceImpl implements AnswerService{
 
	@Autowired
    private AnswerDao dao;
	 
	@Override
	public Answer findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Answer> findByUser(User user) {
		return dao.findByUser(user.getId());
	}

    
	@Override
	public void saveAnswer(Answer answer) {
		dao.save(answer);
	}

	@Override
	public void deleteAnswer(Answer answer) {
		dao.delete(answer);
	}

	

	@Override
	public List<Answer> findByQuestion(Question question) {
		return dao.findByQuestion(question);
	}

	@Override
	public List<Question> findAllQuestions() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}