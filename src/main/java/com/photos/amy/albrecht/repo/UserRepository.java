package com.photos.amy.albrecht.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.photos.amy.albrecht.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User getUserByUserId(Integer userId);
	
	User getUserByEmail(String email);
	
	User getUserByEmailAndPassword(String email, String password);
	
	boolean existsByEmail(String email);
	
	boolean existsByEmailAndPassword(String email, String password);
	
	void deleteByEmail(String email);
	
	void save(String email);
	
	void saveByEmailAndPassword(String email, String password);

}
