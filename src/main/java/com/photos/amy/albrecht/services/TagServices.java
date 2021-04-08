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
import com.photos.amy.albrecht.models.Tag;
import com.photos.amy.albrecht.repo.TagRepository;

@Service
public class TagServices {
	private TagRepository tagRepository;
	
	@Autowired
	public TagServices(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
	
	//create
	public boolean addTag(Tag tag) {
		if(tag == null) return false;
		tagRepository.save(tag);
		return true;
	}
	
	//read
	
	public List<Tag> getAllTags() {
		return tagRepository.findAll();
	}
	
	public Tag getTagByTagId(Integer tagId) {
		return tagRepository.getTagByTagId(tagId);
	}
	
		
	public Tag findTagByTagName(String tagName) {
			return tagRepository.findTagByTagName(tagName);
		}
	

	
	//update
	public void saveTag(Tag tag) {
		tagRepository.save(tag);
	}
	
	//delete
	
	public void deleteTagByTagId(Integer tagId) {
		tagRepository.deleteById(tagId);
	}
	
		


}
