package com.photos.amy.albrecht.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.photos.amy.albrecht.models.Photo;
import com.photos.amy.albrecht.models.User;
import com.photos.amy.albrecht.repo.PhotoRepository;

@Service
public class PhotoServices {
private PhotoRepository photoRepository;
	
	@Autowired
	public PhotoServices(PhotoRepository photoRepository) {
		this.photoRepository = photoRepository;
	}
	
	//create
	
	public boolean addPhoto(Photo photo) {
		if(photo == null) return false;
		photoRepository.save(photo);
		return true;
	}
	
	public void addPhotoByPhotoFileName(String photoFileName) {
		if (photoFileName != null) {
			photoRepository.save(photoFileName);
		}
	}
	
	
	//read
	public List<Photo> getAllPhotos() {
		return photoRepository.findAll();
	}
	
	public Photo getPhotoByPhotoId(Integer photoId) {
		return photoRepository.getPhotoByPhotoId(photoId);
	}
	
	public Photo getPhotoByPhotoFileName(String photoFileName) {
		return photoRepository.getPhotoByPhotoFileName(photoFileName);
	}
	
	
	
	//update
	public void savePhoto(Photo photo) {
		photoRepository.save(photo);
	}
	
	
	//delete
	public void deletePhotoByPhotoId(Integer photoId) {
		photoRepository.deleteById(photoId);
	}



	
	
}
	