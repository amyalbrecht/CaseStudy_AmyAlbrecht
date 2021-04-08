package com.photos.amy.albrecht.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.photos.amy.albrecht.models.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
	Tag getTagByTagId(Integer tagId);

	Tag findTagByTagName(String tagName);
	
	List<Tag> findAll();

}
