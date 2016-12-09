package com.sorusor.service;

import java.util.List;

import com.sorusor.model.Answer;
import com.sorusor.model.Question;
import com.sorusor.model.User;
 
public interface AnswerService {
     
    Answer findById(int id);
     
    List<Answer> findByUser(User user);
    
    List<Answer> findByQuestion(Question question);
    
    List<Question> findAllQuestions(); 
    
    void saveAnswer(Answer answer);
    
//    void updateQuestion(Question question); //gerek yok
     
    void deleteAnswer(Answer answer);
    
//    void deleteQuestionByUser(User user);
    
    
    
//    boolean isEmailUnique(Integer id, String email);
 
}