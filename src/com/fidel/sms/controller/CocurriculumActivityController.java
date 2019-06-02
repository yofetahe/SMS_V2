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
@RequestMapping(value="cocurriculum")
public class CocurriculumActivityController {
	
	@RequestMapping(value="/getCocurriculumActivityTemplate", method=RequestMethod.GET)
	public ModelAndView getCocurriculumActivityTemplate(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("redirect:cocurriculumActivityList");
		
		return modelandview;
	}
	
	@RequestMapping(value="/cocurriculumActivityList", method=RequestMethod.GET)
	public ModelAndView cocurriculumActivityList(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("CoCurriculumActivity/cocurriculum_activity_template");
		
		return modelandview;
	}

}
