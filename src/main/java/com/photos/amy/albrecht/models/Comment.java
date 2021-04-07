package com.photos.amy.albrecht.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "commentId", nullable = false, length = 11)
	int commentId;
	
	@Column(name = "commentText", nullable = false, length = 250)
	String commentText;
	
	//constructors
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	//removed commentId from fields constructor because it's auto-generated
	public Comment(String commentText) {
		super();
		this.commentText = commentText;
	}
	
	//getters and setters

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	//hashCode()	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + commentId;
		result = prime * result + ((commentText == null) ? 0 : commentText.hashCode());
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
		Comment other = (Comment) obj;
		if (commentId != other.commentId)
			return false;
		if (commentText == null) {
			if (other.commentText != null)
				return false;
		} else if (!commentText.equals(other.commentText))
			return false;
		return true;
	}
	
	//toString()

	@Override
	public String toString() {
		return "comment [commentId=" + commentId + ", commentText=" + commentText + "]";
	}
	
	
	
}

