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

import com.fidel.sms.model.AnnualTerms;
import com.fidel.sms.model.BEvaluationStudentResult;
import com.fidel.sms.model.BEvaluationTraits;
import com.fidel.sms.model.ClassDetail;
import com.fidel.sms.model.ClassType;
import com.fidel.sms.model.ClassTypeClassDetailRelation;
import com.fidel.sms.model.StudentInformation;
import com.fidel.sms.model.TeacherInformation;
import com.fidel.sms.service.AttendanceService;
import com.fidel.sms.service.BehaviouralEvaluationService;
import com.fidel.sms.service.ClassTypeService;
import com.fidel.sms.service.StudentService;
import com.fidel.sms.utils.ReturnCurrentEthiopianYear;

@Controller
@RequestMapping(value="behaviouraleval")
public class BehaviouralEvaluationController {
	
	@Autowired
	ClassTypeService classTypeService;
	@Autowired
	StudentService studentService;
	@Autowired
	AttendanceService attendanceService;
	@Autowired
	BehaviouralEvaluationService behEvalService;
	
	@RequestMapping(value="/getBeheviouralEvaluationTemplate", method=RequestMethod.GET)
	public ModelAndView getBeheviouralEvaluationTemplate(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("redirect:evaluationList");
		
		return modelandview;
	}
	
	@RequestMapping(value="/evaluationList", method=RequestMethod.GET)
	public ModelAndView evaluationList(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		List<ClassType> class_type_list = classTypeService.getActiveClassList();
		
		ModelAndView modelandview = new ModelAndView("Behavioural_evaluation/behavioural_evaluation_template");

		modelandview.addObject("class_list", class_type_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getGradeDetailListPerSelectedClassForBehEvaluation", method=RequestMethod.GET)
	public ModelAndView getGradeDetailListPerSelectedClassForBehEvaluation(@ModelAttribute("classType")ClassType classType, BindingResult result, Errors errors){

		List<ClassDetail> class_detail = classTypeService.getClassDetailListByCl_id(classType.getCl_id());
		
		ModelAndView modelandview = new ModelAndView("Behavioural_evaluation/beval_classdetail_list");

		modelandview.addObject("class_detail", class_detail);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getStudentListPerClassDetailForEvaluation", method=RequestMethod.GET)
	public ModelAndView getStudentListPerClassDetailForEvaluation(@ModelAttribute("classDetailRel")ClassTypeClassDetailRelation classDetailRel, BindingResult result, Errors errors){

		List<StudentInformation> student_list = studentService.getStudentListPerGradeDetail(classDetailRel.getCl_id(), classDetailRel.getCd_id(), Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()));
		
		List<AnnualTerms> quarter_list = attendanceService.getActiveAnnualQuarters();
		
		ModelAndView modelandview = new ModelAndView("Behavioural_evaluation/beval_studentlist_pergrade");

		modelandview.addObject("student_list", student_list);
		
		modelandview.addObject("quarter_list", quarter_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getStudentEvaluationResult", method=RequestMethod.GET)
	public ModelAndView getStudentEvaluationResult(@ModelAttribute("bevalResult")BEvaluationStudentResult bevalResult, BindingResult result, Errors errors){

		StudentInformation student_info = studentService.getStudentInformationById(bevalResult.getSi_id());
				
		List<BEvaluationStudentResult> stud_evaluation_rslt = behEvalService.getStudentEvaluationResultBySi_idCl_id(bevalResult.getSi_id(), bevalResult.getCl_id(), bevalResult.getAt_id(), bevalResult.getAcademic_year());
		
		List<Object> btrait_list = behEvalService.getBehavioralEvalTraints(bevalResult.getSi_id(), bevalResult.getCl_id(), bevalResult.getAt_id());
		
		ModelAndView modelandview = new ModelAndView("Behavioural_evaluation/beval_stud_bevalrslt");

		modelandview.addObject("student_info", student_info);
		
		modelandview.addObject("stud_evaluation_rslt", stud_evaluation_rslt);

		modelandview.addObject("btrait_list", btrait_list);
		
		modelandview.addObject("academic_year", ReturnCurrentEthiopianYear.getCurrentEthiopianYear());
		
		return modelandview;
	}
}
