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

import com.fidel.sms.model.ClassDetail;
import com.fidel.sms.model.ClassType;
import com.fidel.sms.model.ExamGrade;
import com.fidel.sms.model.ExamsType;
import com.fidel.sms.model.SubjectClassRelation;
import com.fidel.sms.model.SubjectType;
import com.fidel.sms.service.ClassTypeService;

@Controller
@RequestMapping(value="classtype")
public class ClassTypeController {
	
	@Autowired
	ClassTypeService classTypeService;

	@RequestMapping(value="/getClassTypeTemplate", method=RequestMethod.GET)
	public ModelAndView getClassTypeTemplate(@ModelAttribute("classType")ClassType classType, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("redirect:classTypeList");
		
		return modelandview;
	}
	
	@RequestMapping(value="/classTypeList", method=RequestMethod.GET)
	public ModelAndView classTypeList(@ModelAttribute("classType")ClassType classType, BindingResult result, Errors errors){
	
		List<ClassType> class_list = classTypeService.getActiveClassList();
		
		List<ClassDetail> class_detail_list = classTypeService.getAllClassDetail();
		
		ModelAndView modelandview = new ModelAndView("Class_Type_Registration/class_type_registration_template");
		
		modelandview.addObject("class_list", class_list);

		modelandview.addObject("class_detail_list", class_detail_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getClassTypeRegistrationForm", method=RequestMethod.GET)
	public ModelAndView getClassTypeRegistrationForm(@ModelAttribute("classType")ClassType classType, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("Class_Type_Registration/Class_Type/class_type_create");
		
		return modelandview;
	}
	
	@RequestMapping(value="/getRelatedClassDetailByClassId", method=RequestMethod.GET)
	public ModelAndView getRelatedClassDetailByClassId(@ModelAttribute("classType")ClassType classType, BindingResult result, Errors errors){
	
		List<ClassDetail> related_classdetail_list = classTypeService.getRelatedClassDetailByCl_id(classType.getCl_id());
		
		ModelAndView modelandview = new ModelAndView("Class_Type_Registration/Class_ClassDetail_Relation/class_detail_list");

		modelandview.addObject("related_classdetail_list", related_classdetail_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getRelatedSubjectByClassId", method=RequestMethod.GET)
	public ModelAndView getRelatedSubjectByClassId(@ModelAttribute("classType")ClassType classType, BindingResult result, Errors errors){
	
		List<SubjectType> related_subject_list = classTypeService.getRelatedSubjectByCl_id(classType.getCl_id());
		
		ModelAndView modelandview = new ModelAndView("Class_Type_Registration/Class_Subject_Relation/class_subject_rel_list");

		modelandview.addObject("related_subject_list", related_subject_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getRelatedExamTypeList", method=RequestMethod.GET)
	public ModelAndView getRelatedExamTypeList(@ModelAttribute("subClassRel")SubjectClassRelation subClassRel, BindingResult result, Errors errors){
	
		List<ExamsType> related_examtype_list = classTypeService.getRelatedExamTypeBySubCl_id(subClassRel.getSubcl_id());
		
		ModelAndView modelandview = new ModelAndView("Class_Type_Registration/Subject_Examtype/examtype_subject_list");

		modelandview.addObject("related_examtype_list", related_examtype_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getRelatedExamGradingList", method=RequestMethod.GET)
	public ModelAndView getRelatedExamGradingList(@ModelAttribute("subClassRel")SubjectClassRelation subClassRel, BindingResult result, Errors errors){
	
		List<ExamGrade> related_examgrading_list = classTypeService.getRelatedExamGradingBySubCl_id(subClassRel.getSubcl_id());
		
		ModelAndView modelandview = new ModelAndView("Class_Type_Registration/Exam_Grading/exam_grading_list");

		modelandview.addObject("related_examgrading_list", related_examgrading_list);
		
		return modelandview;
	}
}
