package com.sorusor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sorusor.dao.UserDao;
import com.sorusor.model.User;
 
 
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
 
    @Autowired
    private UserDao userDao;
 
    public User findById(int id) {
        return userDao.findById(id);
    }
 
    public User findByEmail(String email) {
        User user = userDao.findByEmail(email);
        return user;
    }
 
    public void saveUser(User user) {
    	userDao.save(user);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void updateUser(User user) {
        User entity = userDao.findById(user.getId());
        if(entity!=null){
        	 	entity.setEmail(user.getEmail());
	            entity.setPassword(user.getPassword());
	            entity.setFirstName(user.getFirstName());
	            entity.setLastName(user.getLastName());
	            entity.setUserProfiles(user.getUserProfiles());
        }
    }
 
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }
 

	@Override
	public boolean isEmailUnique(Integer id, String email) {
		User user = findByEmail(email);
        return ( user == null || ((id != null) && (user.getId() == id)));
	}

	@Override
	public void deleteUserByEmail(String email) {
		userDao.deleteByEmail(email);
		
	}
     
}