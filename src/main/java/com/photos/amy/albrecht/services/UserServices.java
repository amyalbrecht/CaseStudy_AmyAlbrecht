package com.photos.amy.albrecht.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.photos.amy.albrecht.models.User;
import com.photos.amy.albrecht.repo.UserRepository;

@Service
public class UserServices {
private UserRepository userRepository;
	
	@Autowired
	public UserServices(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	//create
	public boolean addUser(User user) {
		if(user == null) return false;
		userRepository.save(user);
		return true;
	}
	
	
//	public void addUserByEmailAndPassword(String email, String password) {
//		if (email != null && password != null) {
//			userRepository.saveByEmailAndPassword(email, password);
//		}
//	}
	
	//read
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User getUserByEmail(String email) {
		if(email == null) return null;
		return userRepository.getUserByEmail(email);
	}
	
	public User getUserByEmailAndPassword(String email, String password) {
		if(email == null || password == null) return null;
		return userRepository.getUserByEmailAndPassword(email, password);
	}
	
	//update
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	
	//delete
	public void deleteUserByEmail(String email) {
		userRepository.deleteByEmail(email);
	}
	


	
	
	

	/* 
	 * Pseudo code for showing edit button for admin vs. regular users.
	 * 
	 * if user is admin {
	 * 	if user is regular {
	 *		if user.userId == photo.userId, show edit button
	 *		} else { 
	 *		don't show edit button
	 *		}
	 * show all edit buttons
	 * 	}
	 * 
	*/
	
	
	
	
	
	

	
	
}
