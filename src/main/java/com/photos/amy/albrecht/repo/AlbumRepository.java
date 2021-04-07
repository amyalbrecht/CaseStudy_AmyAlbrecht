package com.photos.amy.albrecht.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.photos.amy.albrecht.models.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
	Album getAlbumByAlbumId(Integer albumId);
	
	Album getAlbumByAlbumName(String albumName);
	
	//void addAlbumByAlbumName(String albumName);

	void deleteByAlbumName(String albumName);

	void save(String albumName);

}
