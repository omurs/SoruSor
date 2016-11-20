package com.sorusor.dao;

import java.util.List;
import com.sorusor.model.UserProfile;
 
 
 
public interface UserProfileDao {
 
    List<UserProfile> findAll();
     
    UserProfile findByType(String type);
     
    UserProfile findById(int id);
}