package com.sorusor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sorusor.dao.SubjectDao;
import com.sorusor.model.Subject;
 
 
 
@Service("subjectService")
@Transactional
public class SubjectServiceImpl implements SubjectService{
     
    @Autowired
    SubjectDao dao;
     
    public  Subject findById(int id) {
        return dao.findById(id);
    }
 
  
 
    public List<Subject> findAll() {
        return dao.findAll();
    }




}