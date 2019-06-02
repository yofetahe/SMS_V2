package com.fidel.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fidel.sms.model.TeacherInformation;

@Controller
@RequestMapping(value="communication")
public class CommunicationController {

	@RequestMapping(value="/getEmailCommunicationTemplate", method=RequestMethod.GET)
	public ModelAndView getEmailCommunicationTemplate(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("redirect:emailCommunication");
		
		return modelandview;
	}
	
	@RequestMapping(value="/emailCommunication", method=RequestMethod.GET)
	public ModelAndView emailCommunication(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("Communication/email_communication_template");
		
		return modelandview;
	}
	
	
	
	
	
	@RequestMapping(value="/getSMSCommunicationTemplate", method=RequestMethod.GET)
	public ModelAndView getSMSCommunicationTemplate(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("redirect:smsCommunication");
		
		return modelandview;
	}
	
	@RequestMapping(value="/smsCommunication", method=RequestMethod.GET)
	public ModelAndView smsCommunication(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("Communication/sms_communication_template");
		
		return modelandview;
	}
}
