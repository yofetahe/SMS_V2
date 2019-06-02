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
import com.fidel.sms.model.ClassDetail;
import com.fidel.sms.model.ClassType;
import com.fidel.sms.model.ClassTypeClassDetailRelation;
import com.fidel.sms.model.ExamResult;
import com.fidel.sms.model.ExamSubjectRelation;
import com.fidel.sms.model.ExamsType;
import com.fidel.sms.model.SubjectType;
import com.fidel.sms.model.TeacherInformation;
import com.fidel.sms.service.AnnualTermsService;
import com.fidel.sms.service.ClassTypeService;
import com.fidel.sms.service.ExamResultService;
import com.fidel.sms.service.SubjectExamTypeService;
import com.fidel.sms.utils.ReturnCurrentEthiopianYear;



@Controller
@RequestMapping(value="report")
public class ReportController {
	
	@Autowired
	ClassTypeService classTypeService;
	@Autowired
	AnnualTermsService annualTermsService;
	@Autowired
	SubjectExamTypeService subjectExamTypeService;
	@Autowired
	ExamResultService examResultService;	

	@RequestMapping(value="/getReportTemplate", method=RequestMethod.GET)
	public ModelAndView getTeacherTemplate(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("redirect:reportsList");
		
		return modelandview;
	}
	
	@RequestMapping(value="/reportsList", method=RequestMethod.GET)
	public ModelAndView teachersList(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("Report/report_template");
		
		return modelandview;
	}
	
	@RequestMapping(value="/report_checkInsertedExamResult", method=RequestMethod.GET)
	public ModelAndView report_checkInsertedExamResult(@ModelAttribute("annualTerms")AnnualTerms annualTerms, BindingResult result, Errors errors){
	
		
		List<AnnualTerms> term_list = annualTermsService.getActiveAnnualTermsList();
		
		ModelAndView modelandview = new ModelAndView("Report/checkInsertedExamResult/check_inserted_exam_result");
		
		modelandview.addObject("academic_year", ReturnCurrentEthiopianYear.getActualCurrentEthiopianYear());
		
		modelandview.addObject("term_list", term_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/report_checkrslt_classlist", method=RequestMethod.GET)
	public ModelAndView report_checkrslt_classlist(@ModelAttribute("classType")ClassType classType, BindingResult result, Errors errors){
	
		
		List<ClassType> class_type_list = classTypeService.getActiveClassList();
		
		ModelAndView modelandview = new ModelAndView("Report/CommonListsForAllReport/class_list");
		
		modelandview.addObject("class_list", class_type_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/report_checkresult_gradelist", method=RequestMethod.GET)
	public ModelAndView report_checkresult_gradelist(@ModelAttribute("classTypeClassDetailRel")ClassTypeClassDetailRelation classTypeClassDetailRel, BindingResult result, Errors errors){
	
		
		List<ClassDetail> class_detail_list = classTypeService.getClassDetailListByCl_id(classTypeClassDetailRel.getCl_id());
		
		ModelAndView modelandview = new ModelAndView("Report/CommonListsForAllReport/grade_detail_list");
		
		modelandview.addObject("class_detail_list", class_detail_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/report_checkresult_classSubjectRelList", method=RequestMethod.GET)
	public ModelAndView report_checkresult_classSubjectRelList(@ModelAttribute("classType")ClassType classType, BindingResult result, Errors errors){
	
		
		List<SubjectType> subject_list = classTypeService.getRelatedSubjectByCl_id(classType.getCl_id());
		
		ModelAndView modelandview = new ModelAndView("Report/CommonListsForAllReport/subject_list");
		
		modelandview.addObject("subject_list", subject_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/report_checkrslt_examtypelist", method=RequestMethod.GET)
	public ModelAndView report_checkrslt_examtypelist(@ModelAttribute("examSubRel")ExamSubjectRelation examSubRel, BindingResult result, Errors errors){
	
		
		List<ExamsType> exam_type_list = subjectExamTypeService.getActiveExamType();
		
		ModelAndView modelandview = new ModelAndView("Report/CommonListsForAllReport/examtype_list");
		
		modelandview.addObject("exam_type_list", exam_type_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/report_getCheckInsertedMarkRsltList", method=RequestMethod.GET)
	public ModelAndView report_getCheckInsertedMarkRsltList(@ModelAttribute("examResult")ExamResult examResult, BindingResult result, Errors errors){
		
		
		List<ExamResult> summerized_studmark_number = examResultService.getSummerizedStudCountPerMarkInserted(examResult.getAt_id(), examResult.getFiscal_year(), examResult.getExamSubjectRel().getEt_id(), examResult.getStudentRegistration().getClcdRelation().getCl_id(), examResult.getStudentRegistration().getClcdRelation().getCd_id());
		
		ModelAndView modelandview = new ModelAndView("Report/checkInsertedExamResult/summeried_student_number");
		
		modelandview.addObject("summerized_studmark_number", summerized_studmark_number);
		
		return modelandview;
	}
	
	@RequestMapping(value="/report_quarterMarkList", method=RequestMethod.GET)
	public ModelAndView report_quarterMarkList(@ModelAttribute("annualTerms")AnnualTerms annualTerms, BindingResult result, Errors errors){
	
		
		List<AnnualTerms> term_list = annualTermsService.getActiveAnnualTermsList();
		
		ModelAndView modelandview = new ModelAndView("Report/Quarter_mark_list/quarter_mark_list_temp");
		
		modelandview.addObject("academic_year", ReturnCurrentEthiopianYear.getActualCurrentEthiopianYear());
		
		modelandview.addObject("term_list", term_list);
		
		return modelandview;
	}
}
