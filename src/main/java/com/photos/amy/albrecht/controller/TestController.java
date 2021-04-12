package com.photos.amy.albrecht.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.photos.amy.albrecht.models.Album;
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

	@Autowired
	private AlbumServices albumServices;

	@Autowired
	private TagServices tagServices;

	// localhost:8080/ takes you to landing page
	@RequestMapping("/")
	public String testHandler() {
		return "landingPage";
	}


	// linking to addPhoto.jsp
	// get albumList for dropdown
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
	
	
	//linking to allAlbums.jsp
	@RequestMapping("/allAlbums")
	public ModelAndView allAlbumsHandler() {
		ModelAndView mav = new ModelAndView("allAlbums");
		List<Album> albumList = albumServices.getAllAlbums();
		mav.addObject("albumList", albumList);
		// mav.addObject("photo", new Photo());
		return mav;
	}

	//linking to about.jsp
	@RequestMapping("/about")
	public ModelAndView aboutHandler() {
		ModelAndView mav = new ModelAndView("about");
		return mav;
	}

	//linking to login.jsp (now landingPage.jsp)
	@RequestMapping("/login")
	public ModelAndView loginHandler() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	//linking to register.jsp
	@RequestMapping("/register")
	public ModelAndView registerHandler() {
		ModelAndView mav = new ModelAndView("register");
		return mav;
	}

	//linking to index.jsp
	@RequestMapping("/index")
	public ModelAndView indexHandler() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	//linking to landingPage.jsp
	@RequestMapping("/landingPage")
	public ModelAndView landingPageHandler() {
		ModelAndView mav = new ModelAndView("landingPage");
		return mav;
	}

	//linking to album page - showing one album at a time, given the albumID you have chosen
	@RequestMapping("/album1/{albumId}")
	public ModelAndView showAllAlbumsHandler(@PathVariable int albumId) {
		ModelAndView mav = new ModelAndView();

		List<Tag> pTagsList = tagServices.getAllTags();

		mav.setViewName("album1");
		List<Photo> photoList = albumServices.getAlbumByAlbumId(albumId).getaPhotos();
		Album album = albumServices.getAlbumByAlbumId(albumId);

		mav.addObject("pTagsList", pTagsList);
		mav.addObject("photoList", photoList);
		mav.addObject("album", album);

		return mav;
	}

	//saving a photo on addPhoto.jsp. See handler comments for more info.
				
	@Transactional
	@RequestMapping(value = "/savePhoto", method = RequestMethod.POST)
	public ModelAndView savePhotoHandler(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		

		Photo photokey = new Photo();
		photokey.setPhotoFileName(request.getParameter("photoFileName"));
		photokey.setCaption(request.getParameter("caption"));
		photokey.setpAlbum(albumServices.getAlbumByAlbumId(Integer.parseInt(request.getParameter("pAlbum"))));

		//saving pTags via split(", ") and sending them to a HashMap and a for loop to prevent duplicates.
		String pTagsCombined = request.getParameter("pTags");
		String[] pTagsSeparated = pTagsCombined.split(", ");
		HashMap<String, Tag> pTagsNoDuplications = new HashMap<>();
		for (String s : pTagsSeparated) {
			pTagsNoDuplications.put(s, new Tag(s));
		}
		
		//checking to see if the tags exist in the HashMap. 
		//If the tag does not exist, save the new tag in the Tag table and add to the photo's tag list (pTags).
		//If the tag does exist, only save the tag to the photo's tag list (pTags).
		ArrayList<Tag> pTagsUnchecked = new ArrayList<>(pTagsNoDuplications.values());
		ArrayList<Tag> pTagsChecked = new ArrayList<>();
		for (Tag t : pTagsUnchecked) {
			Tag test = tagServices.findTagByTagName(t.getTagName());
			if (test == null) {
				//System.out.println("Tag:" + t.getTagId() + " TagName: " + t.getTagName());
				tagServices.saveTag(t);
				pTagsChecked.add(tagServices.findTagByTagName(t.getTagName()));
			} else {
				//System.out.println("Test:" + test.getTagId() + " TestName: " + test.getTagName());
				pTagsChecked.add(test);
			}

		}

		photokey.setpTags(pTagsChecked);

		List<Tag> pTagsList = tagServices.getAllTags();

		mav.setViewName("album1");
		photoServices.addPhoto(photokey);
		albumServices.addPhotoToAlbum(Integer.parseInt(request.getParameter("pAlbum")), photokey);
		List<Photo> photoList = albumServices.getAlbumByAlbumId(Integer.parseInt(request.getParameter("pAlbum"))).getaPhotos();
		Album album = albumServices.getAlbumByAlbumId(Integer.parseInt(request.getParameter("pAlbum")));
		mav.addObject("pTagsList", pTagsList);
		mav.addObject("photoList", photoList);
		mav.addObject("album", album);

		return mav;

	}

	//linking to editPhoto.jsp and pulling all the info for the photo you're editing
	@RequestMapping("/editPhoto/{photoId}")
	public ModelAndView editPhotoHandler(@PathVariable int photoId) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("editPhoto");

		Photo photo = photoServices.getPhotoByPhotoId(photoId);
		List<Album> albumList = albumServices.getAllAlbums();	
		
		mav.addObject("photo", photo);
		mav.addObject("pAlbum", albumList);
		
		return mav;
	}

	//saving the photo on editPhoto.jsp. Uses similar code as savePhotoHandler(). See handler comments for more info. 
	@Transactional
	@RequestMapping(value = "/saveEditedPhoto", method = RequestMethod.POST)
	public ModelAndView saveEditedPhotoHandler(HttpServletRequest request) {
		
		
		ModelAndView mav = new ModelAndView();
		
		Photo photo = photoServices.getPhotoByPhotoId(Integer.parseInt(request.getParameter("photoId")));
		photo.setCaption(request.getParameter("caption"));
		albumServices.removePhotoFromAlbum(photo.getpAlbum(), photo.getPhotoId());
		
		photo.setpAlbum(albumServices.getAlbumByAlbumId(Integer.parseInt(request.getParameter("pAlbum"))));
		
		//saving pTags via split(", ") and sending them to a HashMap and a for loop to prevent duplicates.	
		String pTagsCombined = request.getParameter("pTag");
		String[] pTagsSeparated = pTagsCombined.split(", ");
		HashMap<String, Tag> pTagsNoDuplications = new HashMap<>();
		for (String s : pTagsSeparated) {
			pTagsNoDuplications.put(s, new Tag(s));
		}
		
		//checking to see if the tags exist in the HashMap. 
				//If the tag does not exist, save the new tag in the Tag table and add to the photo's tag list (pTags).
				//If the tag does exist, only save the tag to the photo's tag list (pTags).
		ArrayList<Tag> pTagsUnchecked = new ArrayList<>(pTagsNoDuplications.values());
		ArrayList<Tag> pTagsChecked = new ArrayList<>();
		for (Tag t : pTagsUnchecked) {
			Tag test = tagServices.findTagByTagName(t.getTagName());
			if (test == null) {
				//System.out.println("Tag:" + t.getTagId() + " TagName: " + t.getTagName());
				tagServices.saveTag(t);
				pTagsChecked.add(tagServices.findTagByTagName(t.getTagName()));
			} else {
				//System.out.println("Test:" + test.getTagId() + " TestName: " + test.getTagName());
				pTagsChecked.add(test);
			}

		}

		photo.setpTags(pTagsChecked);
				
		photoServices.savePhoto(photo);
		
		
		Album album = photo.getpAlbum();

		int id = album.getAlbumId();
		
		albumServices.addPhotoToAlbum(id, photo);
		
		mav.setViewName("redirect:about");
		

		return showAllAlbumsHandler(id);

	}
	
	//delete photo on editPhoto.jsp
	@RequestMapping("deletePhoto/{photoId}")
	public ModelAndView deletePhotoHandler(@PathVariable int photoId) {
		
		Photo photo = photoServices.getPhotoByPhotoId(photoId);
		Album album = photo.getpAlbum();
		int id = album.getAlbumId();
	
		albumServices.removePhotoFromAlbum(album, photoId);
		
		photoServices.deletePhotoByPhotoId(photoId);
	
		return showAllAlbumsHandler(id);
		
	}
	

	

}
