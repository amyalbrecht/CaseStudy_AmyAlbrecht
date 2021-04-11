package com.photos.amy.albrecht.models;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "album")
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "albumId", nullable = false, length = 11)
	int albumId;
	
	@Column(name = "albumName", nullable = false, length = 50)
	String albumName;
	
	@OneToMany(targetEntity = Photo.class, fetch = FetchType.EAGER)
	private List<Photo> aPhotos; //all the photos in an album
	
	//constructors
	
	public Album() {
		super();
	}

	//removed albumId from fields constructor because it's auto-generated
	public Album(String albumName) {
		super();
		this.albumName = albumName;
	}
	
	//getters and setters

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public List<Photo> getaPhotos() {
		return aPhotos;
	}

	public void setaPhotos(List<Photo> aPhotos) {
		this.aPhotos = aPhotos;
	}

	//hashCode()
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aPhotos == null) ? 0 : aPhotos.hashCode());
		result = prime * result + albumId;
		result = prime * result + ((albumName == null) ? 0 : albumName.hashCode());
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
		Album other = (Album) obj;
		if (albumId != other.albumId)
			return false;
		if (albumName == null) {
			if (other.albumName != null)
				return false;
		} else if (!albumName.equals(other.albumName))
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return "Album [albumId=" + albumId + ", albumName=" + albumName + ", aPhotos=" + aPhotos + "]";
//	}

	//toString()
	
	
	

	

	
	
	
	
	
	
	
}

