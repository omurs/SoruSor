package com.sorusor.service;

import java.util.List;

import com.sorusor.model.User;
 
public interface UserService {
     
    User findById(int id);
     
    User findByEmail(String email);
     
    void saveUser(User user);
     
    void updateUser(User user);
     
    void deleteUserByEmail(String email);
 
    List<User> findAllUsers(); 
     
    boolean isEmailUnique(Integer id, String email);
 
}