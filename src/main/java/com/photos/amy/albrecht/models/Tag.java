package com.photos.amy.albrecht.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "tag")
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tagId", nullable = false, length = 11)
	int tagId;
	
	@Column(name = "tagName", nullable = false, length = 20)
	String tagName;
	
	//constructors
	
	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}

	//removed tagId from fields constructor because it's auto-generated
	public Tag(String tagName) {
		super();
		this.tagName = tagName;
	}
	
	//getters and setters

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	//hashCode()

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tagId;
		result = prime * result + ((tagName == null) ? 0 : tagName.hashCode());
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
		Tag other = (Tag) obj;
		if (tagId != other.tagId)
			return false;
		if (tagName == null) {
			if (other.tagName != null)
				return false;
		} else if (!tagName.equals(other.tagName))
			return false;
		return true;
	}

	//toString()
	
	@Override
	public String toString() {
		return "tag [tagId=" + tagId + ", tagName=" + tagName + "]";
	}
	
	
	
}

