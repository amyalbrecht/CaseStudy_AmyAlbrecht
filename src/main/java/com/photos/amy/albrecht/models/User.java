package com.photos.amy.albrecht.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", nullable = false, length = 11)
	int userId;
	
	@Column(name = "email", nullable = false, length = 50)
	String email;
	
	@Column(name = "password", nullable = false, length = 20)
	String password;
	
	@Column(name = "firstName", nullable = false, length = 50)
	String firstName;
	
	@Column(name = "lastName", nullable = false, length = 50)
	String lastName;
	
	@Column(name = "authLevel", nullable = false)
	boolean authLevel; //true = admin, false = regular user
	
	@OneToMany(targetEntity = Photo.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Photo> uPhotos; //all the photos uploaded by a user
	
		
	//constructors
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	//removed userId from fields constructor because it's auto-generated
	public User(String email, String password, String firstName, String lastName, boolean authLevel,
			List<Photo> uPhotos) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.authLevel = authLevel;
		this.uPhotos = uPhotos;
		
	}

	//getters and setters

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public boolean isAuthLevel() {
		return authLevel;
	}


	public void setAuthLevel(boolean authLevel) {
		this.authLevel = authLevel;
	}


	public List<Photo> getuPhotos() {
		return uPhotos;
	}


	public void setuPhotos(List<Photo> uPhotos) {
		this.uPhotos = uPhotos;
	}


	

	//hashCode()

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (authLevel ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((uPhotos == null) ? 0 : uPhotos.hashCode());
		result = prime * result + userId;
		return result;
	}

	//equals()

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (authLevel != other.authLevel)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (uPhotos == null) {
			if (other.uPhotos != null)
				return false;
		} else if (!uPhotos.equals(other.uPhotos))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}


	//toString()
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", authLevel=" + authLevel + ", uPhotos=" + uPhotos  + "]";
	}

	
	
	
	
}



