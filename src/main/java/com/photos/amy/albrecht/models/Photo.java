package com.photos.amy.albrecht.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "photo")
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "photoId", nullable = false, length = 11)
	private int photoId;

	@Column(name = "photoFileName", nullable = false, length = 50)
	private String photoFileName;

	@Column(name = "caption", nullable = true, length = 250)
	private String caption;

	@ManyToMany(targetEntity = Tag.class, fetch = FetchType.EAGER)
	private List<Tag> pTags; //all the tags for a photo
	//private String pTags; //all the tags for a photo
	
	@ManyToOne(targetEntity = Album.class, fetch = FetchType.LAZY)
	private Album pAlbum;

	//constructors
	
	public Photo() {
		super();
	}

	
	//removed photoId from fields constructor because it's auto-generated
	public Photo(String photoFileName, String caption, List<Tag> pTags, Album pAlbum) {
		super();
		this.photoFileName = photoFileName;
		this.caption = caption;
		this.pTags = pTags;
		this.pAlbum = pAlbum;
	}



	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}



	public List<Tag> getpTags() {
		return pTags;
	}

	public void setpTags(List<Tag> pTags) {
		this.pTags = pTags;
	}

	public Album getpAlbum() {
		return pAlbum;
	}

	public void setpAlbum(Album pAlbum) {
		this.pAlbum = pAlbum;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caption == null) ? 0 : caption.hashCode());
		result = prime * result + ((pAlbum == null) ? 0 : pAlbum.hashCode());
		result = prime * result + ((pTags == null) ? 0 : pTags.hashCode());
		result = prime * result + ((photoFileName == null) ? 0 : photoFileName.hashCode());
		result = prime * result + photoId;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Photo other = (Photo) obj;
		if (caption == null) {
			if (other.caption != null)
				return false;
		} else if (!caption.equals(other.caption))
			return false;
		if (pAlbum == null) {
			if (other.pAlbum != null)
				return false;
		} else if (!pAlbum.equals(other.pAlbum))
			return false;
		if (photoFileName == null) {
			if (other.photoFileName != null)
				return false;
		} else if (!photoFileName.equals(other.photoFileName))
			return false;
		if (photoId != other.photoId)
			return false;
		return true;
	}


//	@Override
//	public String toString() {
//		return "Photo [photoId=" + photoId + ", photoFileName=" + photoFileName + ", caption=" + caption + ", pTags="
//				+ pTags + ", pAlbum=" + pAlbum + "]";
//	}







	

}
