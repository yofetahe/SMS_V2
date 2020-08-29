package com.fidel.sms.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fidel.sms.model.ClassDetail;
import com.fidel.sms.model.ClassType;
import com.fidel.sms.model.ClassTypeClassDetailRelation;
import com.fidel.sms.model.StudentInformation;
import com.fidel.sms.model.TeacherHomeRoomAssignment;
import com.fidel.sms.service.ClassTypeService;
import com.fidel.sms.service.StudentService;
import com.fidel.sms.utils.ReturnCurrentEthiopianYear;

public class SpecialRegistrationController {
	
	@Autowired
	StudentService studentService;
	@Autowired
	ClassTypeService classTypeService;

	@RequestMapping(value="/getSpecialRegistrationTemplate", method=RequestMethod.GET)
	public ModelAndView getSpecialRegistrationTemplate(@ModelAttribute("homeroomAssign")TeacherHomeRoomAssignment homeroomAssign, BindingResult result, Errors errors){
	
		List<ClassType> classTypeList = classTypeService.getActiveClassList();
		
		ModelAndView modelandview = new ModelAndView("Admin/SpecialRegistration/special_registration_template");

		modelandview.addObject("class_list", classTypeList);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getClassDetailByClassIdForSpecialRegistration", method=RequestMethod.GET)
	public ModelAndView getClassDetailByClassIdForSpecialRegistration(@ModelAttribute("classType")ClassType classType, BindingResult result, Errors errors){
	
		List<ClassDetail> class_detail = classTypeService.getClassDetailListByCl_id(classType.getCl_id());
		
		ModelAndView modelandview = new ModelAndView("Admin/SpecialRegistration/class_detail_list");

		modelandview.addObject("class_detail", class_detail);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getStudentListPerClassDetailForSpecialReg", method=RequestMethod.GET)
	public ModelAndView getStudentListPerClassDetailForSpecialReg(@ModelAttribute("classTypeClassDetailRel")ClassTypeClassDetailRelation classTypeClassDetailRel, BindingResult result, Errors errors){
	
		List<StudentInformation> unregistered_student_list = studentService.getUnregistedStudentListPerGradeDetailForSpecialReg(classTypeClassDetailRel.getCl_id(), classTypeClassDetailRel.getCd_id(), Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()));
		
		List<StudentInformation> registered_student_list = studentService.getRegisteredStudentListPerGradeDetailForSpecialReg(classTypeClassDetailRel.getCl_id(), classTypeClassDetailRel.getCd_id(), Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()));
		
		ModelAndView modelandview = new ModelAndView("Admin/SpecialRegistration/special_registration_student_list");

		modelandview.addObject("unregistered_student_list", unregistered_student_list);

		modelandview.addObject("registered_student_list", registered_student_list);
		
		return modelandview;
	}
}
