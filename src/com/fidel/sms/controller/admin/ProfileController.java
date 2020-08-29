package com.fidel.sms.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fidel.sms.model.Users;
import com.fidel.sms.service.UsersService;
import com.fidel.sms.utils.CheckCurrentSessionAndAuthentication;

public class ProfileController {
	
	@Autowired
	UsersService usersService;
	
	@RequestMapping(value="/changeProfile", method=RequestMethod.GET)
	public ModelAndView changeProfile(@ModelAttribute("user")Users user, BindingResult result) {
		
		ModelAndView modelandview = new ModelAndView("General/change_profile");
		
		return modelandview;
	}
	
	@RequestMapping(value="/changeUserProfile", method=RequestMethod.GET)
	public ModelAndView changeUserProfile(@ModelAttribute("user") Users users, BindingResult result){
		
		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
				
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		boolean rslt = usersService.updateUserNamePassword(users);
		
		ModelAndView modelandview = new ModelAndView("General/login");
		
		if(rslt){
						
			modelandview.addObject("successMessage", "Profile successfully changed.");
		} else {
			
			modelandview.addObject("errorMessage", "Profile information is not changed. Please try again.");
		}
		
		return modelandview;
	}

}
