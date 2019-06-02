package com.fidel.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fidel.sms.model.NonAcadmicEmployeeInformation;
import com.fidel.sms.model.TeacherInformation;
import com.fidel.sms.service.NonAcademicService;

@Controller
@RequestMapping(value="nonteacher")
public class NonAcademicController {
	
	@Autowired
	NonAcademicService nonAcademicService;

	@RequestMapping(value="/getNonteacherTemplate", method=RequestMethod.GET)
	public ModelAndView getNonteacherTemplate(@ModelAttribute("nonteacherInfo")NonAcadmicEmployeeInformation nonteacherInfo, BindingResult result, Errors errors){
		
		ModelAndView modelandview = new ModelAndView("redirect:nonteachersList");
		
		return modelandview;
	}
	
	@RequestMapping(value="/nonteachersList", method=RequestMethod.GET)
	public ModelAndView noneteachersList(@ModelAttribute("nonteacherInfo")NonAcadmicEmployeeInformation nonteacherInfo, BindingResult result, Errors errors){
	
		List<NonAcadmicEmployeeInformation> nontchr_list = nonAcademicService.getNonAcadmicStuffList();
		
		ModelAndView modelandview = new ModelAndView("Non_Teacher_Registration/non_academic_template");
		
		modelandview.addObject("nontchr_list", nontchr_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getNonTeacherInfoUpdateForm", method=RequestMethod.GET)
	public ModelAndView getNonTeacherInfoUpdateForm(@ModelAttribute("nonteacherInfo")NonAcadmicEmployeeInformation nonteacherInfo, BindingResult result, Errors errors){
	
		NonAcadmicEmployeeInformation nonteacher_info = nonAcademicService.getNonAcadmicStuffInfoByNti_id(nonteacherInfo.getNti_id());
		
		ModelAndView modelandview = new ModelAndView("Non_Teacher_Registration/nonteacher_edit");
		
		modelandview.addObject("nonteacher_info", nonteacher_info);
		
		return modelandview;
	}
}
