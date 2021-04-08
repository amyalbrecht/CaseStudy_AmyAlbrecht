package com.photos.amy.albrecht.repo;


import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.photos.amy.albrecht.models.Photo;
import com.photos.amy.albrecht.models.Tag;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {
	Photo getPhotoByPhotoId(Integer photoId);
	
	Photo getPhotoByPhotoFileName(String photoFileName);
	
	void deleteByPhotoFileName(String photoFileName);
	
	void save(String photoFileName);
	
	List<Photo> findAll();
	
	List<Photo> findBypAlbum(int albumId);
	
	Optional<Photo> getByPhotoId(Integer photoId);
	
	//List<Photo> getByPhotoFileNameAndCaption(String photoFileName, String caption);
	
	//List<Photo> getAllByPComments(List<Comment> pComments);
	
	//List<Photo> getAllByPLikes(List<Likes> pLikes);
	
	//List<Photo> getAllByPTags(List<Tag> pTags);
	
}
