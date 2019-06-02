package com.fidel.sms.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fidel.sms.model.TeacherAssignment;
import com.fidel.sms.model.TeacherCurrentAddress;
import com.fidel.sms.model.TeacherDisciplinaryAction;
import com.fidel.sms.model.TeacherEducationBackground;
import com.fidel.sms.model.TeacherEmergencyContact;
import com.fidel.sms.model.TeacherInformation;
import com.fidel.sms.model.TeacherReward;
import com.fidel.sms.model.TeacherWorkExperience;
import com.fidel.sms.service.TeacherService;

@Controller
@RequestMapping(value="teacher")
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;

	@RequestMapping(value="/getTeacherTemplate", method=RequestMethod.GET)
	public ModelAndView getTeacherTemplate(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("redirect:teachersList");
		
		return modelandview;
	}
	
	@RequestMapping(value="/teachersList", method=RequestMethod.GET)
	public ModelAndView teachersList(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		List<TeacherInformation> active_teacher_list = teacherService.getActiveTeacherList();
		
		ModelAndView modelandview = new ModelAndView("Teacher_Registration/teacher_template");
		
		modelandview.addObject("teacher_list", active_teacher_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getActiveTeacherList", method=RequestMethod.GET)
	public ModelAndView getActiveTeacherList(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		List<TeacherInformation> active_teacher_list = teacherService.getActiveTeacherList();
		
		ModelAndView modelandview = new ModelAndView("Teacher_Registration/teacher_list");
		
		modelandview.addObject("teacher_list", active_teacher_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getInactiveTeacherList", method=RequestMethod.GET)
	public ModelAndView getInactiveTeacherList(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		List<TeacherInformation> inactive_teacher_list = teacherService.getInactiveTeacherList();
		
		ModelAndView modelandview = new ModelAndView("Teacher_Registration/teacher_list_inactive");
		
		modelandview.addObject("teacher_list", inactive_teacher_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getNewTeacherRegistrationForm", method=RequestMethod.GET)
	public ModelAndView getNewTeacherRegistrationForm(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("Teacher_Registration/teacher_profile_registration_form");
		
		return modelandview;
	}
	
	@RequestMapping(value="/getTeacherProfileEditForm", method=RequestMethod.GET)
	public ModelAndView getTeacherProfileEditForm(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		TeacherInformation teacher_info = teacherService.getTeacherInformationByTi_id(teacherInfo.getTi_id());
		
		ModelAndView modelandview = new ModelAndView("Teacher_Registration/teacher_profile_edit_temp");
		
		modelandview.addObject("teacher_info", teacher_info);
		
		return modelandview;
	}
	

	@RequestMapping(value="/getTeacherPhoto", method=RequestMethod.GET)
	public void getTeacherPhoto(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, HttpServletResponse response){
		
		byte[] readImg = teacherService.getTeacherPhotoByTiid(teacherInfo.getTi_id());
		
		if(readImg == null){
			
			File image = new File("C:\\sms_system_file\\everest\\Photos\\stud_photo\\default.jpeg");
			byte[] fileContent;
			try {
				fileContent = Files.readAllBytes(image.toPath());
				readImg = fileContent;
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
		
		if(readImg != null){
						
			try {
				response.reset();
				response.setContentType("image/jpeg");
				response.getOutputStream().write(readImg, 0, readImg.length);
				response.getOutputStream().flush();
				response.getOutputStream().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value="/getEducationBackgroundList", method=RequestMethod.GET)
	public ModelAndView getEducationBackgroundList(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		List<TeacherEducationBackground> edubackground_list = teacherService.getTeacherEducationalBackgroundByTi_id(teacherInfo.getTi_id());
		
		ModelAndView modelandview = new ModelAndView("Teacher_Registration/educational_background/edu_background_list");
		
		modelandview.addObject("edubackground_list", edubackground_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getTeacherWorkExperienceList", method=RequestMethod.GET)
	public ModelAndView getTeacherWorkExperienceList(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		List<TeacherWorkExperience> workexp_list = teacherService.getTeacherWorkExperienceByTi_id(teacherInfo.getTi_id());
		
		ModelAndView modelandview = new ModelAndView("Teacher_Registration/work_experience/work_exp_list");
		
		modelandview.addObject("workexp_list", workexp_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getTeacherCurrentAddress", method=RequestMethod.GET)
	public ModelAndView getTeacherCurrentAddress(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		TeacherCurrentAddress current_address = teacherService.getTeacherCurrentAddressByTi_id(teacherInfo.getTi_id());
		
		ModelAndView modelandview = new ModelAndView("Teacher_Registration/current_address/teacher_curadd_edit_form");
		
		modelandview.addObject("current_address", current_address);
		
		if(current_address.getTca_id() != 0){
			
			modelandview.addObject("formType", "update");
		}
		
		return modelandview;
	}
	
	@RequestMapping(value="/getTeacherEmergencyContactList", method=RequestMethod.GET)
	public ModelAndView getTeacherEmergencyContactList(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		TeacherEmergencyContact emergency_contant = teacherService.getTeacherEmergencyContactByTi_id(teacherInfo.getTi_id());
		
		ModelAndView modelandview = new ModelAndView("Teacher_Registration/emergency_contact/teacher_emergcont_edit_form");
		
		modelandview.addObject("emergency_contant", emergency_contant);
		
		if(emergency_contant.getTec_id() != 0){
			
			modelandview.addObject("formType", "update");
		}
		
		return modelandview;
	}
	
	@RequestMapping(value="/getTeacherRewardList", method=RequestMethod.GET)
	public ModelAndView getTeacherRewardList(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		List<TeacherReward> reward_list = teacherService.getTeacherRewardListByTi_id(teacherInfo.getTi_id());
		
		ModelAndView modelandview = new ModelAndView("Teacher_Registration/reward/teacher_reward_list");
		
		modelandview.addObject("reward_list", reward_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getTeacherDisciplinaryActionList", method=RequestMethod.GET)
	public ModelAndView getTeacherDisciplinaryActionList(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		List<TeacherDisciplinaryAction> disaction_list = teacherService.getTeacherDisciplinaryActionByTi_id(teacherInfo.getTi_id());
		
		ModelAndView modelandview = new ModelAndView("Teacher_Registration/disciplinary_action/teacher_disact_list");
		
		modelandview.addObject("disaction_list", disaction_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getTeacherClassSubjectAssignment", method=RequestMethod.GET)
	public ModelAndView getTeacherClassSubjectAssignment(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		List<TeacherAssignment> assign_list = teacherService.getTeacherClassSubjectAssignmentByTi_id(teacherInfo.getTi_id());
		
		ModelAndView modelandview = new ModelAndView("Teacher_Registration/Assignment/assign_list");
		
		modelandview.addObject("assign_list", assign_list);
		
		return modelandview;
	}
}
