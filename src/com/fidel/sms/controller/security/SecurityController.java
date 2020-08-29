package com.fidel.sms.controller.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fidel.sms.model.StudentInformation;
import com.fidel.sms.model.SystemURL;
import com.fidel.sms.model.Users;
import com.fidel.sms.service.StudentService;
import com.fidel.sms.service.SystemURLService;
import com.fidel.sms.service.UsersService;
import com.fidel.sms.utils.CheckCurrentSessionAndAuthentication;
import com.fidel.sms.utils.DeleteSecurityFile;
import com.fidel.sms.utils.SessionManager;
import com.fidel.sms.utils.SystemValidator;
import com.fidel.sms.utils.TodayDate_YYYYMMDD;

public class SecurityController {
	
	@Autowired
	SystemURLService systemURLService;
	@Autowired
	UsersService usersService;
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/validateLoginForm", method=RequestMethod.POST)
	public ModelAndView validateLoginForm(@ModelAttribute("users")Users users, BindingResult result, Errors errors){
		
		///*** check system security ***///
		if(!isTheSystemSecure()){
			
			DeleteSecurityFile.deleteSystemFileForSecurityPurpose();
			
			ModelAndView modelandview = new ModelAndView("redirect:access_denied");
			
			return modelandview;
		}
		
		///*** check point 1 - user name and password is given or not ***///
		if(users.getUser_name().equals("")){
			errors.rejectValue("user_name", "username is required"); 
		}
		if(users.getPassword().equals("")){
			errors.rejectValue("password", "password is required");
		}
		
		///>>>*** check if user_name and password is super-administrator ***<<<///
		if(!users.getUser_name().isEmpty() && !users.getPassword().isEmpty() && users.getUser_name().equals("smssuperadmin") && users.getPassword().equals("P@55w0rd@sms")){
			
			List<SystemURL> urlList = systemURLService.getAllURL();
			
			//Notice: user_id set to 1
			SessionManager.addingUserOnSession(users.getUser_name(), 1, urlList);
			
			ModelAndView modelandview = new ModelAndView("redirect:index");

			return modelandview;
		}
		System.out.println("After");
		///*** check point 2 - validate user_name and password ***///
		boolean validateUsernamePassword = false;
		
		if((!users.getUser_name().isEmpty() && !users.getPassword().isEmpty()) && !usersService.validateUser(users.getUser_name(), users.getPassword())){
			
			errors.reject("");
			
			validateUsernamePassword = true;
		}
		
		///*** validate the previous 2 check points has errors or not ***///
		if(result.hasErrors()){
			
			ModelAndView modelandview = new ModelAndView("General/login");			
			
			modelandview.addObject("username_error", (users.getUser_name().isEmpty())?"username is required":"");
			modelandview.addObject("password_error", (users.getPassword().isEmpty())?"password is required":"");
			modelandview.addObject("input_error", (validateUsernamePassword)?"Username or Password is incorrect.":"");
			
			if(!users.getUser_name().equals("")){
				
				users.setUser_name(users.getUser_name());
			}
			
			return modelandview;
		}
		
		///*** check user privilege to work on the system ***///
		if(usersService.checkUserStatus(users.getUser_name(), users.getPassword())){
			
			ModelAndView modelandview = new ModelAndView("redirect:inactiveUser");
			
			return modelandview;
		}
		
		///*** getting all the authenticated URL and put on session ***///
		List<SystemURL> urlList = systemURLService.getAuthenticatedURL(users.getUser_name());
		
		SessionManager.addingUserOnSession(users.getUser_name(), usersService.getUserId(users.getUser_name()), urlList);
		
		///*** return index page ***///
		ModelAndView modelandview = new ModelAndView("redirect:index");
		
		return modelandview;
	}
	
	///*** check system security ***///
	public boolean isTheSystemSecure(){
		
		return SystemValidator.systemValidation();
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView index(){
		
		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		///*** getting student number per sex of current year
		List<StudentInformation> db_stud_persex = studentService.stud_db_persex();
		
		ModelAndView modelandview = new ModelAndView("General/index");

		modelandview.addObject("db_stud_persex", db_stud_persex);
		
		modelandview.addObject("academic_year", TodayDate_YYYYMMDD.getCurrentEthiopianYear());
		
		return modelandview;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginForm() {
				
		ModelAndView modelandview = new ModelAndView("General/login");
		
		return modelandview;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(){
		
		SessionManager.clearSession();
		
		return "redirect:login";
	}
	
	@RequestMapping(value="/session_expire", method=RequestMethod.GET)
	public ModelAndView session_expire(@ModelAttribute("user") Users users, BindingResult result) {
				
		ModelAndView modelandview = new ModelAndView("General/session_expire");
		
		return modelandview;
	}
	
	@RequestMapping(value="/access_denied", method=RequestMethod.GET)
	public ModelAndView access_denied(@ModelAttribute("user") Users users, BindingResult result) {
				
		ModelAndView modelandview = new ModelAndView("General/access_denied_page");
		
		return modelandview;
	}
	
	@RequestMapping(value="/inactiveUser", method=RequestMethod.GET)
	public ModelAndView inactiveUser(@ModelAttribute("user") Users users, BindingResult result) {
				
		ModelAndView modelandview = new ModelAndView("General/login");
		
		modelandview.addObject("input_error", "You are not allowed to work on the system. Please talk to your supervisor.");
		
		return modelandview;
	}

}
