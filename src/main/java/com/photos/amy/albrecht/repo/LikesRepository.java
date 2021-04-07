package com.photos.amy.albrecht.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.photos.amy.albrecht.models.Likes;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Integer> {
	Likes countByLikesId(Integer likesId);

}
