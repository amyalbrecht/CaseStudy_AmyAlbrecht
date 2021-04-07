package com.photos.amy.albrecht.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.photos.amy.albrecht.models.Album;
import com.photos.amy.albrecht.models.Comment;
import com.photos.amy.albrecht.models.Likes;
import com.photos.amy.albrecht.models.Photo;
import com.photos.amy.albrecht.models.Tag;
import com.photos.amy.albrecht.models.User;
import com.photos.amy.albrecht.services.AlbumServices;
import com.photos.amy.albrecht.services.PhotoServices;
import com.photos.amy.albrecht.services.TagServices;
import com.photos.amy.albrecht.services.UserServices;

@Controller
public class TestController {
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private PhotoServices photoServices;
	//User(String email, String password, String firstName, String lastName, boolean authLevel,
	//List<Photo> uPhotos, List<Comment> uComment, List<Like> uLike) 
	
	@Autowired
	private AlbumServices albumServices;
	
	@Autowired
	private TagServices tagServices;
	

	//add User
	@RequestMapping("/")
	public String testHandler() {
		User user = new User("email@email.com", "passwerd", "Callie", "Albrecht", false, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		userServices.addUser(user);
		return "index";
	}
	
	
	//linking to the addPhoto.jsp page
	
	//get albumList for dropdown
	@RequestMapping("/addPhoto")
	public ModelAndView addPhotoHandler() {
		ModelAndView mav = new ModelAndView("addPhoto"); 
		List<Album> albumList = albumServices.getAllAlbums();
		List<Tag> tagList = tagServices.getAllTags();
		mav.addObject("albumList", albumList);
		mav.addObject("tagList", tagList);
		mav.addObject("photo", new Photo());
		return mav;
	}
	
	
//	//http://localhost:8080/photos/savePhoto?
//	photoFileName=blippi.PNG&
//	album=new&
//	newAlbum=New+Album&
//	caption=hello&
//	tag=new%2C+red&
//	submit=Submit

	//saving Photo to database
//	@RequestMapping("/savePhoto")
//	public String savePhotoHandler(@ModelAttribute Photo photo) {
//		System.out.println(photo);
//		photoServices.addPhoto(photo);
//		return "album1";
//	}
	
//	@RequestMapping(value="/savePhoto", method = RequestMethod.GET)
//	public ModelAndView savePhotoHandler(@ModelAttribute("photo") @Valid Photo photo,
//			BindingResult errors) {
//		if(errors.hasErrors()) {
//			ModelAndView mav = new ModelAndView("error");
//			return mav;
//		}
//		
//		ModelAndView mav = new ModelAndView("addPhoto");
//		return mav;
//		
//	}
	
	@RequestMapping(value="/savePhoto", method = RequestMethod.POST)
	public ModelAndView savePhotoHandler(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("addPhoto");

		System.out.println(request.getParameter("photoFileName"));
		System.out.println(request.getParameter("caption"));
		System.out.println(request.getParameter("pAlbum"));
		System.out.println(request.getParameter("pTags"));
		
		Photo photokey = new Photo();
		photokey.setPhotoFileName(request.getParameter("photoFileName"));
		photokey.setCaption(request.getParameter("caption"));
		photokey.setpAlbum(albumServices.getAlbumByAlbumId(Integer.parseInt(request.getParameter("pAlbum"))));
		
		String pTagsCombined = request.getParameter("pTags");
		String[] pTagsSeparated = pTagsCombined.split(", ");
		HashMap<String, Tag> pTagsNoDuplications = new HashMap<>();
		for(String s : pTagsSeparated){
			pTagsNoDuplications.put(s, new Tag(s));
		}
		ArrayList<Tag> pTagsUnchecked = new ArrayList<>(pTagsNoDuplications.values());
		ArrayList<Tag> pTagsChecked = new ArrayList<>();
		for(Tag t : pTagsUnchecked){
			Tag test = tagServices.findTagByTagName(t.getTagName());
			if(test == null){
				System.out.println("Tag:" + t.getTagId() + " TagName: " + t.getTagName());
				tagServices.saveTag(t);
				pTagsChecked.add(tagServices.findTagByTagName(t.getTagName()));
			} else {
				System.out.println("Test:" + test.getTagId() + " TestName: " + test.getTagName());
				pTagsChecked.add(test);
			}
			
		}
		
		photokey.setpTags(pTagsChecked);
		
		mav.setViewName("album1");
		photoServices.addPhoto(photokey);
		albumServices.addPhotoToAlbum(Integer.parseInt(request.getParameter("pAlbum")), photokey);
		
		return mav;
		
		
	}
	
	

	
	
}
