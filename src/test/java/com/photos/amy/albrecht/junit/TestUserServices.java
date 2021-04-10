package com.photos.amy.albrecht.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;



import com.photos.amy.albrecht.config.DataConfig;
import com.photos.amy.albrecht.models.User;
import com.photos.amy.albrecht.repo.UserRepository;
import com.photos.amy.albrecht.services.UserServices;

public class TestUserServices {
	
	private static UserServices userServices;
	private static UserRepository userRepository;
	private static Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private User actual = null;
	
	@BeforeAll
	public static void setUp() throws SQLException {
		System.out.println("Before All Method");
		DataConfig dc = new DataConfig();
		
		userServices = new UserServices(userRepository);
		conn = (Connection) dc.getEntityManagerFactoryBean();
		
	}
	
	@BeforeEach
	public void beforeEach() throws SQLException{
		System.out.println("Before Each");
	
		stmt = conn.prepareStatement("SELECT * FROM user WHERE id = ?");
		stmt.setInt(1, 1);
		rs = stmt.executeQuery();
		if(rs.next()) {
			actual = new User();
			actual.setUserId(rs.getInt(1));
			actual.setAuthLevel(rs.getBoolean(2));
			actual.setEmail(rs.getString(3));
			actual.setFirstName(rs.getString(4));
			actual.setLastName(rs.getString(5));
			actual.setPassword(rs.getString(6));
			
		}
		
	}

//	//create
//		public boolean addUser(User user) {
//			if(user == null) return false;
//			userRepository.save(user);
//			return true;
//		}
		
//		@Test
//		public void testAddUser() {
//			
//		}
	

//		
//		public List<User> getAllUsers() {
//			return userRepository.findAll();
//		}
		
//		@Test 
//		public void testGetAllUsers() {
//			
//		}
		
//		
//		public User getUserByEmail(String email) {
//			if(email == null) return null;
//			return userRepository.getUserByEmail(email);
//		}
		
		@Test
		public void testGetUserByEmail() {
			String expected ="admin@admin.com";
		
			assertEquals(expected, actual.getEmail());
		}
		
//		
//		public User getUserByEmailAndPassword(String email, String password) {
//			if(email == null || password == null) return null;
//			return userRepository.getUserByEmailAndPassword(email, password);
//		}
//		
//		//update
//		public void saveUser(User user) {
//			userRepository.save(user);
//		}
//		
//		
//		//delete
//		public void deleteUserByEmail(String email) {
//			userRepository.deleteByEmail(email);
//		}
//		
//
//		public boolean deleteUser(String email) {
//			if(email == null) return false;
//			User user = userRepository.getUserByEmail(email);
//			if (user != null) {
//				userRepository.delete(user);
//				return true;
//			}
//			return false;
//		}
//		
//		
//		
//
//	
	}
