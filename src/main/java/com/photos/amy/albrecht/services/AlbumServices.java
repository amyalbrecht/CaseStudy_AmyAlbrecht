package com.photos.amy.albrecht.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.photos.amy.albrecht.models.Album;
import com.photos.amy.albrecht.models.Photo;
import com.photos.amy.albrecht.repo.AlbumRepository;
import com.photos.amy.albrecht.repo.PhotoRepository;

@Service
public class AlbumServices {
	private AlbumRepository albumRepository;

	@Autowired
	private PhotoServices photoServices;

	@Autowired
	public AlbumServices(AlbumRepository albumRepository) {
		this.albumRepository = albumRepository;
	}

	// create
	public boolean addAlbum(Album album) {
		boolean result = true;
		try {
			albumRepository.save(album);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	public void addAlbumByAlbumName(String albumName) {
		// Add code here
		if (albumName != null) {
			albumRepository.save(albumName);
		}
		// add code here
	}

	// read
	public List<Album> getAllAlbums() {
		return albumRepository.findAll();
	}

	public Album getAlbumByAlbumId(int albumId) {
		return albumRepository.getAlbumByAlbumId(albumId);
	}

	public Album getAlbumByAlbumName(String albumName) {
		return albumRepository.getAlbumByAlbumName(albumName);
	}

	// read - look at all photos in an album
		public List<Photo> findByaPhotos(Integer albumId) {
			
			return albumRepository.findByaPhotos(albumId);
		}
	

	// update
	public void saveAlbum(Album album) {
		albumRepository.save(album);
	}

	// delete
	public void deleteAlbumByAlbumName(String albumName) {
		albumRepository.deleteByAlbumName(albumName);
	}

	
	//add Photo to Album
	public boolean addPhotoToAlbum(Integer albumId, Photo photo) {
		Album newAlbum = albumRepository.getAlbumByAlbumId(albumId);

		boolean isAdded = newAlbum.getaPhotos().add(photo);
		albumRepository.save(newAlbum);

		return isAdded;

	}

	
// hello


}
