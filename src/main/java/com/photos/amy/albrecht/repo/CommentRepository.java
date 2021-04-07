package com.photos.amy.albrecht.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.photos.amy.albrecht.models.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	Comment getCommentByCommentId(Integer commentId);

	Comment findCommentByCommentText(String commentText);

	Comment countByCommentId(Integer commentId);
}
