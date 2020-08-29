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

public class IDCardController {
	
	@Autowired
	StudentService studentService;
	@Autowired
	ClassTypeService classTypeService;
	
	@RequestMapping(value="/getIDCardGeneratorTemplate", method=RequestMethod.GET)
	public ModelAndView getIDCardGeneratorTemplate(@ModelAttribute("homeroomAssign")TeacherHomeRoomAssignment homeroomAssign, BindingResult result, Errors errors){
	
		List<ClassType> classTypeList = classTypeService.getActiveClassList();
		
		ModelAndView modelandview = new ModelAndView("Admin/IDCardGeneration/id_card_generation_template");

		modelandview.addObject("class_list", classTypeList);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getClassDetailListForIDCardByClassId", method=RequestMethod.GET)
	public ModelAndView getClassDetailListForIDCardByClassId(@ModelAttribute("classType")ClassType classType, BindingResult result, Errors errors){
	
		List<ClassDetail> class_detail = classTypeService.getClassDetailListByCl_id(classType.getCl_id());
		
		ModelAndView modelandview = new ModelAndView("Admin/IDCardGeneration/class_detail_list");

		modelandview.addObject("class_detail", class_detail);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getStudentListPerClassDetailForIDCard", method=RequestMethod.GET)
	public ModelAndView getStudentListPerClassDetailForIDCard(@ModelAttribute("classTypeClassDetailRel")ClassTypeClassDetailRelation classTypeClassDetailRel, BindingResult result, Errors errors){
	
		List<StudentInformation> stud_with_id_rslt = studentService.getStudListWithIDPerGradeDetail(classTypeClassDetailRel.getCl_id(), classTypeClassDetailRel.getCd_id(), Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()));
		
		List<StudentInformation> stud_with_out_id_rslt = studentService.getStudListWithoutIDPerGradeDetail(classTypeClassDetailRel.getCl_id(), classTypeClassDetailRel.getCd_id(), Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()));
		
		ModelAndView modelandview = new ModelAndView("Admin/IDCardGeneration/student_list");

		modelandview.addObject("stud_with_id_rslt", stud_with_id_rslt);
		
		modelandview.addObject("stud_with_out_id_rslt", stud_with_out_id_rslt);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getStudentListDontHavePhoto", method=RequestMethod.GET)
	public ModelAndView getStudentListDontHavePhoto(@ModelAttribute("classTypeClassDetailRel")ClassTypeClassDetailRelation classTypeClassDetailRel, BindingResult result, Errors errors){
	
		List<StudentInformation> stud_without_photo_contact_rslt = studentService.getStudentListWithoutPhotoByCl_idCd_idAcadmic_year(classTypeClassDetailRel.getCl_id(), classTypeClassDetailRel.getCd_id(), Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()));
		
		ModelAndView modelandview = new ModelAndView("Admin/IDCardGeneration/stud_without_photo_contact_info");

		modelandview.addObject("stud_without_photo_contact_rslt", stud_without_photo_contact_rslt);
		
		modelandview.addObject("pageTitle", "Student List Who Don't Have Photo");
		
		return modelandview;
	}
	
	@RequestMapping(value="/getStudentListDontHaveContactInfo", method=RequestMethod.GET)
	public ModelAndView getStudentListDontHaveContactInfo(@ModelAttribute("classTypeClassDetailRel")ClassTypeClassDetailRelation classTypeClassDetailRel, BindingResult result, Errors errors){
	
		List<StudentInformation> stud_without_photo_contact_rslt = studentService.getStudentWithoutContactInfoByCl_idCd_idAcadmic_year(classTypeClassDetailRel.getCl_id(), classTypeClassDetailRel.getCd_id(), Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()));
		
		ModelAndView modelandview = new ModelAndView("Admin/IDCardGeneration/stud_without_photo_contact_info");

		modelandview.addObject("stud_without_photo_contact_rslt", stud_without_photo_contact_rslt);

		modelandview.addObject("pageTitle", "Student List Who Don't Have Emergency Contact Information");
		
		return modelandview;
	}

}
