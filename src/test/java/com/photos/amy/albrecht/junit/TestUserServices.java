package com.photos.amy.albrecht.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.photos.amy.albrecht.models.User;
import com.photos.amy.albrecht.repo.UserRepository;
import com.photos.amy.albrecht.services.UserServices;

@SpringBootTest
public class TestUserServices {
	
	@Autowired
	UserServices userServices;
	
	@Autowired
	UserRepository userRepository;



		
		@Test
		@Transactional
		public void testAddUser() {
			User user = new User("email@email.com", "password", "Callie", "Albrecht", false, new ArrayList<>());
			boolean expected = true;
			assertEquals(expected, userServices.addUser(user));
		}
	

//		
//		public List<User> getAllUsers() {
//			return userRepository.findAll();
//		}
		
//		@Test 
//		@Transactional
//		public void testGetAllUsers() {
//			List<User> userList = 
//			
//		}
		

		
		@Test
		@Transactional
		public void testGetUserByEmail() {
			String expected ="admin@admin.com";
			assertEquals(expected, userServices.getUserByEmail(expected).getEmail());
		}
		
//		
//		public User getUserByEmailAndPassword(String email, String password) {
//			if(email == null || password == null) return null;
//			return userRepository.getUserByEmailAndPassword(email, password);
//		}
//		
		//update
		public void saveUser(User user) {
			userRepository.save(user);
		}
		
		@Test
		@Transactional
		public void testSaveUser() {
			
		}
//		
//		
//		//delete
//		public void deleteUserByEmail(String email) {
//			userRepository.deleteByEmail(email);
//		}
//		
//

		
//		@Test
//		@Transactional
//		public void testDeleteUserByEmail() {
//			User user = new User("email@email.com", "password", "Callie", "Albrecht", false, new ArrayList<>());
//			boolean expected = true;
//			assertEquals(expected, userServices.deleteUserByEmail(user.getEmail()));
//		}
//		
//		
//		
//
//	
	}
