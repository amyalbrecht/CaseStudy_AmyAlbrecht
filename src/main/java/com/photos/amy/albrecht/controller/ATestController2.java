package com.photos.amy.albrecht.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class ATestController2 {
	
	@Autowired
	private UserServices userServices;

	@Autowired
	private PhotoServices photoServices;

	@Autowired
	private AlbumServices albumServices;

	@Autowired
	private TagServices tagServices;
	
	
	@RequestMapping("/loginAttempt")
	public String loginAttemptHandler(HttpServletRequest request) {
		if (userServices.getUserByEmailAndPassword(request.getParameter("email"),
				request.getParameter("password")) != null) {
			return "index";
		}
		return "redirect:/";
	}

}
