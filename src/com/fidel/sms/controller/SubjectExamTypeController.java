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

import com.fidel.sms.model.ExamsType;
import com.fidel.sms.model.SubjectType;
import com.fidel.sms.model.TeacherInformation;
import com.fidel.sms.service.SubjectExamTypeService;

@Controller
@RequestMapping(value="subjectexamtype")
public class SubjectExamTypeController {
	
	@Autowired
	SubjectExamTypeService subjectExamTypeService;

	@RequestMapping(value="/getSubjectExamTypeTemplate", method=RequestMethod.GET)
	public ModelAndView getSubjectExamTypeTemplate(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("redirect:subjectExamTypeList");
		
		return modelandview;
	}
	
	@RequestMapping(value="/subjectExamTypeList", method=RequestMethod.GET)
	public ModelAndView subjectExamTypeList(@ModelAttribute("subjectType")SubjectType subjectType, BindingResult result, Errors errors){
	
		List<SubjectType> subject_list = subjectExamTypeService.getAllSubjectType();
		
		ModelAndView modelandview = new ModelAndView("Subject_Exam_Type_Registration/subject_exam_type_template");
		
		modelandview.addObject("subject_list", subject_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getSubjectTypeList", method=RequestMethod.GET)
	public ModelAndView getSubjectTypeList(@ModelAttribute("subjectType")SubjectType subjectType, BindingResult result, Errors errors){
	
		List<SubjectType> subject_list = subjectExamTypeService.getAllSubjectType();
		
		ModelAndView modelandview = new ModelAndView("Subject_Exam_Type_Registration/Subject_Type/subject_list");
		
		modelandview.addObject("subject_list", subject_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getExamTypeList", method=RequestMethod.GET)
	public ModelAndView getExamTypeList(@ModelAttribute("examType")ExamsType examType, BindingResult result, Errors errors){
	
		List<ExamsType> examtype_list = subjectExamTypeService.getAllExamType();
		
		ModelAndView modelandview = new ModelAndView("Subject_Exam_Type_Registration/Exam_Type/examtype_list");
		
		modelandview.addObject("examtype_list", examtype_list);
		
		return modelandview;
	}
}
