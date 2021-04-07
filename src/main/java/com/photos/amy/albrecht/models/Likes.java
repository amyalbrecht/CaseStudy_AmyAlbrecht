package com.photos.amy.albrecht.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "likes")
public class Likes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "likesId", nullable = false, length = 11)
	int likesId;
	
	@Column(name = "likesName", nullable = true, length = 10)
	String likesName;
	
	//constructors

	public Likes() {
		super();
		// TODO Auto-generated constructor stub
	}

	//did not include likeName in fields constructor
	public Likes(int likesId) {
		super();
		this.likesId = likesId;
	}

	//getters and setters
	
	public int getLikesId() {
		return likesId;
	}

	public void setLikesId(int likesId) {
		this.likesId = likesId;
	}

	public String getLikesName() {
		return likesName;
	}

	public void setLikesName(String likesName) {
		this.likesName = likesName;
	}

	//hashCode()
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + likesId;
		result = prime * result + ((likesName == null) ? 0 : likesName.hashCode());
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
		Likes other = (Likes) obj;
		if (likesId != other.likesId)
			return false;
		if (likesName == null) {
			if (other.likesName != null)
				return false;
		} else if (!likesName.equals(other.likesName))
			return false;
		return true;
	}
	
	//toString()

	@Override
	public String toString() {
		return "Likes [likesId=" + likesId + ", likesName=" + likesName + "]";
	}

	
	
	
	
	
}