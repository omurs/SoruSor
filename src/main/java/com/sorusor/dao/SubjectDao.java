package com.sorusor.dao;

import java.util.List;

import com.sorusor.model.Subject;
 
public interface SubjectDao {
 
    Subject findById(int id);
     
   
    List<Subject> findAll();
 
}