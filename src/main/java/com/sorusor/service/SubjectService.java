package com.sorusor.service;

import java.util.List;

import com.sorusor.model.Subject;
 
 
public interface SubjectService {
 
    Subject findById(int id);
 
     
    List<Subject> findAll();
     
}