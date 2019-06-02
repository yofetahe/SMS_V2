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
@RequestMapping(value="classschedule")
public class ClassScheduleController {

	@RequestMapping(value="/getClassScheduleTemplate", method=RequestMethod.GET)
	public ModelAndView getClassScheduleTemplate(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("redirect:classScheduleList");
		
		return modelandview;
	}
	
	@RequestMapping(value="/classScheduleList", method=RequestMethod.GET)
	public ModelAndView classScheduleList(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("Class_Schedule/class_schedule_template");
		
		return modelandview;
	}
}
