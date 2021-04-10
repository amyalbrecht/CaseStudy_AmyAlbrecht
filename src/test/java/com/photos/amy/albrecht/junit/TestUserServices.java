package com.photos.amy.albrecht.junit;

import java.util.List;

import com.photos.amy.albrecht.models.User;

public class TestUserServices {

	//create
		public boolean addUser(User user) {
			if(user == null) return false;
			userRepository.save(user);
			return true;
		}
		
		
//		public void addUserByEmailAndPassword(String email, String password) {
//			if (email != null && password != null) {
//				userRepository.saveByEmailAndPassword(email, password);
//			}
//		}
		
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
		

		public boolean deleteUser(String email) {
			if(email == null) return false;
			User user = userRepository.getUserByEmail(email);
			if (user != null) {
				userRepository.delete(user);
				return true;
			}
			return false;
		}
		
		
		

	
}
