package com.sorusor.service;

import java.util.List;

import com.sorusor.model.Question;
import com.sorusor.model.User;
 
public interface QuestionService {
     
    Question findById(int id);
     
    List<Question> findByUser(User user);
    
    List<Question> findAllQuestions(); 
    
    void saveQuestion(Question question);
    
//    void updateQuestion(Question question); //gerek yok
     
    void deleteQuestion(Question question);
    
    void deleteQuestionByUser(User user);
    
    
    
//    boolean isEmailUnique(Integer id, String email);
 
}