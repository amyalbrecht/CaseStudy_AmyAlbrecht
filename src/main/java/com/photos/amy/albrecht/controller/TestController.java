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

	// add User
	@RequestMapping("/")
	public String testHandler() {
//		User user = new User("email@email.com", "passwerd", "Callie", "Albrecht", false, new ArrayList<>());
//		userServices.addUser(user);
		return "landingPage";
	}

//	@RequestMapping("/loginAttempt")
//	public String loginAttemptHandler(HttpServletRequest request) {
//		if (userServices.getUserByEmailAndPassword(request.getParameter("email"),
//				request.getParameter("password")) != null) {
//			return "index";
//		}
//		return "redirect:/";
//	}

	// linking to the addPhoto.jsp page

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
	
	

	@RequestMapping("/allAlbums")
	public ModelAndView allAlbumsHandler() {
		ModelAndView mav = new ModelAndView("allAlbums");
		List<Album> albumList = albumServices.getAllAlbums();
		mav.addObject("albumList", albumList);
		// mav.addObject("photo", new Photo());
		return mav;
	}

	@RequestMapping("/about")
	public ModelAndView aboutHandler() {
		ModelAndView mav = new ModelAndView("about");
		return mav;
	}

	@RequestMapping("/login")
	public ModelAndView loginHandler() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping("/register")
	public ModelAndView registerHandler() {
		ModelAndView mav = new ModelAndView("register");
		return mav;
	}

	@RequestMapping("/index")
	public ModelAndView indexHandler() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	@RequestMapping("/landingPage")
	public ModelAndView landingPageHandler() {
		ModelAndView mav = new ModelAndView("landingPage");
		return mav;
	}

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


	@Transactional
	@RequestMapping(value = "/savePhoto", method = RequestMethod.POST)
	public ModelAndView savePhotoHandler(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		

		Photo photokey = new Photo();
		photokey.setPhotoFileName(request.getParameter("photoFileName"));
		photokey.setCaption(request.getParameter("caption"));
		photokey.setpAlbum(albumServices.getAlbumByAlbumId(Integer.parseInt(request.getParameter("pAlbum"))));

		String pTagsCombined = request.getParameter("pTags");
		String[] pTagsSeparated = pTagsCombined.split(", ");
		HashMap<String, Tag> pTagsNoDuplications = new HashMap<>();
		for (String s : pTagsSeparated) {
			pTagsNoDuplications.put(s, new Tag(s));
		}
		ArrayList<Tag> pTagsUnchecked = new ArrayList<>(pTagsNoDuplications.values());
		ArrayList<Tag> pTagsChecked = new ArrayList<>();
		for (Tag t : pTagsUnchecked) {
			Tag test = tagServices.findTagByTagName(t.getTagName());
			if (test == null) {
				System.out.println("Tag:" + t.getTagId() + " TagName: " + t.getTagName());
				tagServices.saveTag(t);
				pTagsChecked.add(tagServices.findTagByTagName(t.getTagName()));
			} else {
				System.out.println("Test:" + test.getTagId() + " TestName: " + test.getTagName());
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

		System.out.println("=========================");
		System.out.println(photoList);
		System.out.println("=========================");

		return mav;

	}

	@RequestMapping("/editPhoto/{photoId}")
	public ModelAndView editPhotoHandler(@PathVariable int photoId) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("editPhoto");
		
		//Photo photokey = new Photo();
		//photokey.setpAlbum(albumServices.getAlbumByAlbumId(Integer.parseInt(request.getParameter("pAlbum"))));

		Photo photo = photoServices.getPhotoByPhotoId(photoId);
		List<Album> albumList = albumServices.getAllAlbums();
		
		
		mav.addObject("photo", photo);
		mav.addObject("pAlbum", albumList);
		System.out.println("=========================");
		System.out.println(albumList);
		System.out.println("=========================");
		return mav;
	}

	@Transactional
	@RequestMapping(value = "/saveEditedPhoto", method = RequestMethod.POST)
	public ModelAndView saveEditedPhotoHandler(HttpServletRequest request) {
		System.out.println("=========================");
		System.out.println(request.getParameter("caption"));
		System.out.println(request.getParameter("photoId"));
		System.out.println(request.getParameter("pAlbum"));
		System.out.println(request.getParameter("pTag"));
	
		System.out.println("=========================");
		
		ModelAndView mav = new ModelAndView();
		
		Photo photo = photoServices.getPhotoByPhotoId(Integer.parseInt(request.getParameter("photoId")));
		photo.setCaption(request.getParameter("caption"));
		albumServices.removePhotoFromAlbum(photo.getpAlbum(), photo.getPhotoId());
		
		photo.setpAlbum(albumServices.getAlbumByAlbumId(Integer.parseInt(request.getParameter("pAlbum"))));
		
		String pTagsCombined = request.getParameter("pTag");
		String[] pTagsSeparated = pTagsCombined.split(", ");
		HashMap<String, Tag> pTagsNoDuplications = new HashMap<>();
		for (String s : pTagsSeparated) {
			pTagsNoDuplications.put(s, new Tag(s));
		}
		ArrayList<Tag> pTagsUnchecked = new ArrayList<>(pTagsNoDuplications.values());
		ArrayList<Tag> pTagsChecked = new ArrayList<>();
		for (Tag t : pTagsUnchecked) {
			Tag test = tagServices.findTagByTagName(t.getTagName());
			if (test == null) {
				System.out.println("Tag:" + t.getTagId() + " TagName: " + t.getTagName());
				tagServices.saveTag(t);
				pTagsChecked.add(tagServices.findTagByTagName(t.getTagName()));
			} else {
				System.out.println("Test:" + test.getTagId() + " TestName: " + test.getTagName());
				pTagsChecked.add(test);
			}

		}

		photo.setpTags(pTagsChecked);
				
		photoServices.savePhoto(photo);
		
		
		Album album = photo.getpAlbum();

		int id = album.getAlbumId();
		
		albumServices.addPhotoToAlbum(id, photo);
		
		mav.setViewName("redirect:about");
		
//		System.out.println("=========================");
//		System.out.println(request.getParameter("caption"));
//		System.out.println(request.getParameter("photoId"));
//		System.out.println(request.getParameter("pAlbum"));
//		System.out.println(request.getParameter("pTags"));
//		System.out.println(photo);
//		System.out.println(album);
//		System.out.println(id);
//		System.out.println("=========================");

		return showAllAlbumsHandler(id);

	}
	
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
