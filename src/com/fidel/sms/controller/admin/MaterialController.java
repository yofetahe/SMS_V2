package com.fidel.sms.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fidel.sms.model.ClassType;
import com.fidel.sms.model.PaymentMaterialClassRelation;
import com.fidel.sms.model.PaymentTypeMaterialList;
import com.fidel.sms.service.ClassTypeService;
import com.fidel.sms.service.StudentMaterialsService;

public class MaterialController {
	
	@Autowired
	ClassTypeService classTypeService;
	@Autowired
	StudentMaterialsService studentMaterialsService;
	
	@RequestMapping(value="/getStudentMaterialTemplate", method=RequestMethod.GET)
	public ModelAndView getStudentMaterialTemplate(@ModelAttribute("classType")ClassType classType, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("Admin/StudentMaterial/student_material_template");

		return modelandview;
	}
	
	@RequestMapping(value="/getMaterialList", method=RequestMethod.GET)
	public ModelAndView getMaterialList(@ModelAttribute("classType")ClassType classType, BindingResult result, Errors errors){
		
		List<PaymentTypeMaterialList> materialList = studentMaterialsService.getAllStudentMaterialList();
	
		ModelAndView modelandview = new ModelAndView("Admin/StudentMaterial/student_material_list");

		modelandview.addObject("materialList", materialList);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getMaterialClassRelation", method=RequestMethod.GET)
	public ModelAndView getMaterialClassRelation(@ModelAttribute("materialClassRel")PaymentMaterialClassRelation materialClassRel, BindingResult result, Errors errors){
		
		List<PaymentMaterialClassRelation> materialClassRelList = studentMaterialsService.getAllClassMaterialRelationList();
		
		List<ClassType> classTypeList = classTypeService.getActiveClassList();
		
		List<PaymentTypeMaterialList> materialList = studentMaterialsService.getAllStudentMaterialList();
	
		ModelAndView modelandview = new ModelAndView("Admin/StudentMaterial/class_material_relationship/class_material_rel_list");

		modelandview.addObject("materialClassRelList", materialClassRelList);
		
		modelandview.addObject("classTypeList", classTypeList);

		modelandview.addObject("materialList", materialList);
		
		return modelandview;
	}

}
