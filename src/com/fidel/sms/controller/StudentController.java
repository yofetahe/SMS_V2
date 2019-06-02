package com.fidel.sms.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.fidel.sms.model.SpecialNeedCategory;
import com.fidel.sms.model.StudentCurrentAddress;
import com.fidel.sms.model.StudentDisciplinaryAction;
import com.fidel.sms.model.StudentEmergencyContact;
import com.fidel.sms.model.StudentInformation;
import com.fidel.sms.model.StudentRegistration;
import com.fidel.sms.model.StudentReward;
import com.fidel.sms.model.StudentSpecialNeedRequired;
import com.fidel.sms.service.ClassTypeService;
import com.fidel.sms.service.SpecialNeedCategoryService;
import com.fidel.sms.service.StudentService;
import com.fidel.sms.utils.CheckCurrentSessionAndAuthentication;
import com.fidel.sms.utils.ReturnCurrentEthiopianYear;
import com.fidel.sms.utils.TodayDate_YYYYMMDD;

@Controller
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	@Autowired
	ClassTypeService classTypeService;
	@Autowired
	SpecialNeedCategoryService specialNeedCategoryService;

	@RequestMapping(value="/getStudentTemplate", method=RequestMethod.GET)
	public ModelAndView getStudentTemplate(@ModelAttribute("studInfo")StudentInformation studInfo, BindingResult result, Errors errors){
	
		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		ModelAndView modelandview = new ModelAndView("redirect:studentList");
		
		return modelandview;
	}
	
	@RequestMapping(value="/studentList", method=RequestMethod.GET)
	public ModelAndView studentList(@ModelAttribute("studInfo")StudentInformation studInfo, BindingResult result, Errors errors){
	
		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		
		///*** Getting year list ***///
		String acyear = TodayDate_YYYYMMDD.getCurrentEthiopianYear();
		
		int[] acyear_list = new int[] {
				Integer.parseInt(acyear), Integer.parseInt(acyear) - 1,
				Integer.parseInt(acyear) - 2 };
		///*** END - Getting year list ***///
		
		
		///*** getting number of student per each class ***///
		List<StudentInformation> studnum_perclass = studentService.getStudentNumPerClass(Integer.parseInt(acyear));
		
		///*** getting class list ***///
		List<ClassType> class_type_list = classTypeService.getActiveClassList();
		
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/student_template");
		
		modelandview.addObject("acyear_list", acyear_list);
		
		modelandview.addObject("studnum_perclass", studnum_perclass);
		
		modelandview.addObject("class_list", class_type_list);
		
		modelandview.addObject("num_of_class", class_type_list.size());
		
		return modelandview;
	}	
	
	@RequestMapping(value="/getStudentListPerSelectedAcadmicYear", method=RequestMethod.GET)
	public ModelAndView getStudentListPerSelectedAcadmicYear(@ModelAttribute("studReg")StudentRegistration studReg, BindingResult result, Errors errors){
	
		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
				
		
		
		///*** getting number of student per each class ***///
		List<StudentInformation> studnum_perclass = studentService.getStudentNumPerClass(studReg.getAcademic_year());
		
		///*** getting class list ***///
		List<ClassType> class_type_list = classTypeService.getActiveClassList();
		
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/student_male_female_num_per_class");
		
		modelandview.addObject("studnum_perclass", studnum_perclass);
		
		modelandview.addObject("class_list", class_type_list);
		
		modelandview.addObject("num_of_class", class_type_list.size());
		
		return modelandview;
	}
	
	@RequestMapping(value="/getClassDetailForBrotherSisterSearch", method=RequestMethod.GET)
	public ModelAndView getClassDetailForBrotherSisterSearch(@ModelAttribute("studentReg")StudentRegistration studReg, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		
		List<ClassDetail> class_detail_list = classTypeService.getNotFilteredClassDetailPerSelectedClass(studReg.getClcdRelation().getCl_id());
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/grade_detail_list_for_brosis_search");

		modelandview.addObject("class_detail_list", class_detail_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/searchBrotherSisterByName", method=RequestMethod.GET)
	public ModelAndView searchBrotherSisterByName(@ModelAttribute("studentReg")StudentRegistration studReg, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		
		List<StudentInformation> student_search_result = studentService.searchStudentByCl_idCd_idName(studReg.getClcdRelation().getCl_id(), studReg.getClcdRelation().getCd_id(), studReg.getStudentInformation().getFname());
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/student_search_result_for_brosis_search");

		modelandview.addObject("student_search_result", student_search_result);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getNewStudentRegistrationForm", method=RequestMethod.GET)
	public ModelAndView getNewStudentRegistrationForm(){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		
		///*** getting class list ***///
		List<ClassType> class_type_list = classTypeService.getActiveClassList();
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/student_info_registration_form", "studentInformation", new StudentInformation());
		
		modelandview.addObject("class_type_list", class_type_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/saveStudentProfileInformation", method=RequestMethod.POST)
	public ModelAndView saveStudentProfileInformation(@ModelAttribute("studentInformation")StudentInformation studentInformation, BindingResult result){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		
		///--->>> 1 - SAVE Student Info
//		StudentInformation studInfo = new StudentInformation();
//		studInfo.setFname(request.getParameter("fname"));
//		studInfo.setMname(request.getParameter("mname"));
		System.out.println(studentInformation.getFname());
		
		///--->>> 2 - SAVE Emergency Contact info - 1. Share if s/he has a brother/sister OR 2. Save info
		
		
		
		///--->>> 3 - SAVE Student Relation Info
		
		
		
		//boolean rslt = studentService.saveStudentProfileInformation(studReg);
		
		
		///--->>> Information required to display the student_info_template <<<---///
		///*** Getting year list ***///
		String acyear = TodayDate_YYYYMMDD.getCurrentEthiopianYear();
		
		int[] acyear_list = new int[] {
				Integer.parseInt(acyear), Integer.parseInt(acyear) - 1,
				Integer.parseInt(acyear) - 2 };
		///*** END - Getting year list ***///
						
		///*** getting number of student per each class ***///
		List<StudentInformation> studnum_perclass = studentService.getStudentNumPerClass(Integer.parseInt(acyear));
			
		///*** getting class list ***///
		List<ClassType> class_type_list = classTypeService.getActiveClassList();
				
				
		ModelAndView modelandview = new ModelAndView("Student_Registration/student_template");
			
		modelandview.addObject("acyear_list", acyear_list);
				
		modelandview.addObject("studnum_perclass", studnum_perclass);
				
		modelandview.addObject("class_list", class_type_list);
				
		modelandview.addObject("num_of_class", class_type_list.size());
		
		
				
		return modelandview;
	}
	
	
	@RequestMapping(value="/getGradeDetailListPerSelectedClass", method=RequestMethod.GET)
	public ModelAndView getGradeDetailListPerSelectedClass(@ModelAttribute("studReg")StudentRegistration studReg, BindingResult result, Errors errors){
	
		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		
		int next_year = Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear());
		
		
		List<StudentInformation> stud_count = studentService.getStudentCountPerGradeDetail(studReg);
		
		List<ClassDetail> class_detail = classTypeService.getNotFilteredClassDetailPerSelectedClass(studReg.getClcdRelation().getClassType().getCl_id());
				
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/class_detail_list_per_selected_class");
		
		modelandview.addObject("stud_rslt", stud_count);
		
		modelandview.addObject("class_detail", class_detail);
		
		modelandview.addObject("num_of_class_detail", class_detail.size());
				
		if(next_year == studReg.getAcademic_year()){
			
			modelandview.addObject("registrationTime", "ON");
		}
		
		return modelandview;
	}
	
	@RequestMapping(value="/getStudentListPerClassDetail", method=RequestMethod.GET)
	public ModelAndView getStudentListPerClassDetail(@ModelAttribute("studReg")StudentRegistration studReg, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		
		List<StudentInformation> stud_list = studentService.getStudentListPerGradeDetail(studReg.getClcdRelation().getCl_id(), studReg.getClcdRelation().getCd_id(), studReg.getAcademic_year());
		
		List<ClassDetail> class_detail = classTypeService.getNotFilteredClassDetailPerSelectedClass(studReg.getClcdRelation().getCl_id());
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/student_list_per_grade_detail");

		modelandview.addObject("stud_list", stud_list);
		
		modelandview.addObject("class_detail", class_detail);
		
		return modelandview;
	}
		
	@RequestMapping(value="/getStudentDetailInformationForm", method=RequestMethod.GET)
	public ModelAndView getStudentDetailInformationForm(@ModelAttribute("studReg")StudentRegistration studReg, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		///*** Used to if it is needed to change the class of the student ***///
		List<ClassType> class_list = classTypeService.getClassListOtherThanCurrentClass(studReg.getClcdRelation().getCl_id());
		
		///*** Used to if it is needed to change the class detail of the student ***///
		List<ClassDetail> class_detail = classTypeService.getFilteredClassDetailUnderSelectedClass(studReg.getClcdRelation().getCl_id(), studReg.getClcdRelation().getCd_id());
		
		///*** Used to display student profile information for update ***///
		StudentInformation stud_info = studentService.getStudentInformationById(studReg.getSi_id());
		
		studReg.setStudentInformation(stud_info);
		
		///*** Used to assign special payment type for student ***///
		List<SpecialNeedCategory> specialNeedsCategoryList = specialNeedCategoryService.getSpecialNeedsCategoryList();
		
		///*** to get if there is previously registered special payment type ***///
		List<StudentSpecialNeedRequired> studentSpecialNeedStatus = specialNeedCategoryService.checkStudSpecialNeedRequirment(studReg.getSi_id());
		
		
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/student_detail_information_for_update");

		modelandview.addObject("stud_info", stud_info);
		
		modelandview.addObject("class_list", class_list);

		modelandview.addObject("class_detail", class_detail);
		
		modelandview.addObject("specialNeedsCategoryList", specialNeedsCategoryList);
		
		if(studentSpecialNeedStatus.size() > 0){
			
			studReg.setStudentSpecialNeedRequired(studentSpecialNeedStatus.get(0));
			
			modelandview.addObject("stud_special_need_status", "1");
			
			modelandview.addObject("studentSpecialNeedStatus", studentSpecialNeedStatus);
			
		} else {
			
			modelandview.addObject("stud_special_need_status", "2");
		}
		
		///*** Used to control information change on -> Enrollment status, Class Room Change and Special payment ***///
		if(Integer.parseInt(TodayDate_YYYYMMDD.getCurrentEthiopianYear()) > studReg.getAcademic_year()){
			
			modelandview.addObject("ChangeAllowed", "NO");
		}
		
		return modelandview;
	}
	
	@RequestMapping(value="/getStudentPhoto", method=RequestMethod.GET)
	public void getStudentPhoto(@ModelAttribute("studReg")StudentRegistration studReg, HttpServletResponse response){
		
		byte[] readImg = studentService.getStudentPhotoBySiid(studReg.getSi_id());
		
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
	
	@RequestMapping(value="/getStudentContactInformationListPerGrade", method=RequestMethod.GET)
	public ModelAndView getStudentContactInformationListPerGrade(@ModelAttribute("studReg")StudentRegistration studReg, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		
		List<StudentEmergencyContact> contactInfo = studentService.getStudentContactInformationListPerGradeDetail(studReg.getClcdRelation().getCl_id(), studReg.getClcdRelation().getCd_id(), studReg.getAcademic_year());
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/Student_Contact_Information/student_contact_info_pergrade");

		modelandview.addObject("contactInfo", contactInfo);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getClassDetailListByClassId", method=RequestMethod.GET)
	public ModelAndView getClassDetailListByClassId(@ModelAttribute("studReg")StudentRegistration studReg, BindingResult result, Errors errors){
		
		List<ClassDetail> class_detail_list = classTypeService.getClassDetailListByCl_id(studReg.getClcdRelation().getCl_id());
	
		ModelAndView model = new ModelAndView("Student_Registration/Student_Profile/grade_detail_list");
		
		model.addObject("class_detail_list", class_detail_list);		
		
		return model;
	}
	
	@RequestMapping(value="/getStudentProfileEditForm", method=RequestMethod.GET)
	public ModelAndView getStudentProfileEditForm(@ModelAttribute("studReg")StudentRegistration studReg, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		
		///*** Used to if it is needed to change the class detail of the student ***///
		List<ClassDetail> class_detail = classTypeService.getFilteredClassDetailUnderSelectedClass(studReg.getClcdRelation().getCl_id(), studReg.getClcdRelation().getCd_id());
		
		///*** Used to display student profile information for update ***///
		StudentInformation stud_info = studentService.getStudentInformationById(studReg.getSi_id());
		
		studReg.setStudentInformation(stud_info);
		
		///*** Used to assign special payment type for student ***///
		List<SpecialNeedCategory> specialNeedsCategoryList = specialNeedCategoryService.getSpecialNeedsCategoryList();
		
		///*** to get if there is previously registered special payment type ***///
		List<StudentSpecialNeedRequired> studentSpecialNeedStatus = specialNeedCategoryService.checkStudSpecialNeedRequirment(studReg.getSi_id());
		
		
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/Student_Profile/student_profile_template");

		modelandview.addObject("stud_info", stud_info);
		
		modelandview.addObject("class_detail", class_detail);
		
		modelandview.addObject("specialNeedsCategoryList", specialNeedsCategoryList);
		
		if(studentSpecialNeedStatus.size() > 0){
			
			studReg.setStudentSpecialNeedRequired(studentSpecialNeedStatus.get(0));
			
			modelandview.addObject("stud_special_need_status", "1");
			
			modelandview.addObject("studentSpecialNeedStatus", studentSpecialNeedStatus);
			
		} else {
			
			modelandview.addObject("stud_special_need_status", "2");
		}
		
		///*** Used to control information change on -> Enrollment status, Class Room Change and Special payment ***///
		if(Integer.parseInt(TodayDate_YYYYMMDD.getCurrentEthiopianYear()) > studReg.getAcademic_year()){
			
			modelandview.addObject("ChangeAllowed", "NO");
		}
		
		return modelandview;
	}
	
	@RequestMapping(value="/getAllStudentsListPerSelectedYear", method=RequestMethod.GET)
	public ModelAndView getAllStudentsListPerSelectedYear(@ModelAttribute("studReg")StudentRegistration studReg, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		
		List<StudentInformation> allStudentList = studentService.getAllStudentInformationPerSelectedAcademicYear(studReg.getAcademic_year());
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/General_Student_List/general_student_list");

		modelandview.addObject("allStudentList", allStudentList);

		modelandview.addObject("headerTitle", "All Active Students List on " + studReg.getAcademic_year() + " Academic Year");
		
		return modelandview;
	}
	
	@RequestMapping(value="/getAllInactiveStudentsListPerSelectedYear", method=RequestMethod.GET)
	public ModelAndView getAllInactiveStudentsListPerSelectedYear(@ModelAttribute("studReg")StudentRegistration studReg, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		
		List<StudentInformation> allStudentList = studentService.getAllInactiveStudentInformationPerSelectedAcademicYear(studReg.getAcademic_year());
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/General_Student_List/general_student_list");

		modelandview.addObject("allStudentList", allStudentList);

		modelandview.addObject("headerTitle", "All Inactive Students List on " + studReg.getAcademic_year() + " Academic Year");
		
		return modelandview;
	}
	
	@RequestMapping(value="/getAllNewCandidateStudentsList", method=RequestMethod.GET)
	public ModelAndView getAllNewCandidateStudentsList(@ModelAttribute("studReg")StudentRegistration studReg, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		
		List<StudentInformation> allStudentList = studentService.getAllNewCandidateStudentInformation();
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/General_Student_List/new_candidate_student_list");

		modelandview.addObject("allStudentList", allStudentList);
		
		modelandview.addObject("headerTitle", "New Candidate Students List");
		
		return modelandview;
	}
	
	@RequestMapping(value="/getStudentsListPerSelectedGrade", method=RequestMethod.GET)
	public ModelAndView getStudentsListPerSelectedGrade(@ModelAttribute("studReg")StudentRegistration studReg, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		
		List<StudentInformation> allStudentList = studentService.getStudentsListPerGrade(studReg.getClcdRelation().getCl_id(), studReg.getAcademic_year());
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/student_list_per_grade");

		modelandview.addObject("stud_list", allStudentList);
		
		modelandview.addObject("headerTitle", "All Students List of " + studReg.getClcdRelation().getClassType().getClass_name());
		
		return modelandview;
	}
	
	
	
	
	///>>>--- STUDENT REGISTRATION ---<<<///
	
	@RequestMapping(value="/getStudentRegistrationForm", method=RequestMethod.GET)
	public ModelAndView getStudentRegistrationForm(@ModelAttribute("studReg")StudentRegistration studReg, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		
		List<StudentInformation> allStudentList = studentService.getStudentsListForRegistration(studReg.getClcdRelation().getCl_id(), studReg.getAcademic_year());
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/Student_Registration_Forms/student_list_for_registration");
		
		modelandview.addObject("stud_list", allStudentList);
		
		return modelandview;
	}
		
	///>>>--- END - STUDENT REGISTRATION ---<<<///
	
	
	
	
	
	///>>>--- STUDENT CURRENT ADDRESS ---<<<///
	
	@RequestMapping(value="/getStudentCurrentAddress", method=RequestMethod.GET)
	public ModelAndView getStudentCurrentAddress(@ModelAttribute("studReg")StudentRegistration studReg, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		
		List<StudentCurrentAddress> studCurrentAddress = studentService.getStudentCurrentAddressBySiid(studReg.getSi_id());
		
		ModelAndView modelandview = new ModelAndView();
		
		if(studCurrentAddress.size() > 0){
		
			modelandview = new ModelAndView("Student_Registration/Current_Address/student_currentaddress_edit");
	
			modelandview.addObject("studCurrentAddress", studCurrentAddress);
		
		} else {
			
			modelandview = new ModelAndView("Student_Registration/Current_Address/student_currentaddress_create");			
		}
		
		return modelandview;
	}
	
	///>>>--- END - STUDENT CURRENT ADDRESS ---<<<///
	
	
	
	
	
	///>>>--- STUDENT EMERGENCY CONTACT ---<<<///
		
	@RequestMapping(value="/getStudentEmergencyContact", method=RequestMethod.GET)
	public ModelAndView getStudentEmergencyContact(@ModelAttribute("studReg")StudentRegistration studReg, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		
		List<StudentEmergencyContact> studEmergencyContact = studentService.getStudentEmergencyContactBySiid(studReg.getSi_id());
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/Student_Emergency_Contact/student_emergcontact_list");
	
		modelandview.addObject("studEmergencyContact", studEmergencyContact);
		
		return modelandview;
	}
	
	@RequestMapping(value="/addNewStudentEergencyContact", method=RequestMethod.GET)
	public ModelAndView addNewStudentEergencyContact(@ModelAttribute("studReg")StudentRegistration studReg, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/Student_Emergency_Contact/student_emergcontact_create");
	
		return modelandview;
	}
	
	@RequestMapping(value="/getStudentEmergencyContactEditForm", method=RequestMethod.GET)
	public ModelAndView getStudentEmergencyContactEditForm(@ModelAttribute("studEmerg")StudentEmergencyContact studEmerg, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		StudentEmergencyContact emergencyContact = studentService.getStudentEmergencyContactBySecid(studEmerg.getSec_id());
		
		studEmerg.setSec_status(emergencyContact.getSec_status());
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/Student_Emergency_Contact/student_emergcontact_edit");
		
		modelandview.addObject("emergencyContact", emergencyContact);
	
		return modelandview;
	}
	
	///>>>--- END - STUDENT EMERGENCY CONTACT ---<<<///
	
	
	
	
	
	
	
	///>>>--- STUDENT REWARD ---<<<///	
	
	@RequestMapping(value="/getStudentReward", method=RequestMethod.GET)
	public ModelAndView getStudentReward(@ModelAttribute("studReward")StudentReward studReward, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		List<StudentReward> studentReward = studentService.getStudentRewardListBySiid(studReward.getSi_id());
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/Student_Reward/student_reward_list");
		
		modelandview.addObject("studentReward", studentReward);
	
		return modelandview;
	}
	
	@RequestMapping(value="/addNewStudentReward", method=RequestMethod.GET)
	public ModelAndView addNewStudentReward(@ModelAttribute("studReward")StudentReward studReward, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/Student_Reward/student_reward_create");
	
		return modelandview;
	}
	
	@RequestMapping(value="/getStudentRewardUpdateForm", method=RequestMethod.GET)
	public ModelAndView getStudentRewardUpdateForm(@ModelAttribute("studReward")StudentReward studReward, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		StudentReward studentReward = studentService.getStudentRewardBySrid(studReward.getSr_id());
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/Student_Reward/student_reward_edit");
	
		modelandview.addObject("studentReward", studentReward);
		
		return modelandview;
	}
	
	///>>>--- END - STUDENT REWARD ---<<<///
	
	
	
	
	
	
	///>>>--- DISCIPLINARY ACTION ---<<<////
	
	@RequestMapping(value="/getStudentDisciplinaryAction", method=RequestMethod.GET)
	public ModelAndView getStudentDisciplinaryAction(@ModelAttribute("studDisAction")StudentDisciplinaryAction studDisAction, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		List<StudentDisciplinaryAction> studentDisAction = studentService.getStudentDisciplinaryActionListBySiid(studDisAction.getSi_id());
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/Student_Disciplinary_Action/student_disaction_list");
		
		modelandview.addObject("studentDisAction", studentDisAction);
	
		return modelandview;
	}
	
	@RequestMapping(value="/addStudentDisciplinaryAction", method=RequestMethod.GET)
	public ModelAndView addStudentDisciplinaryAction(@ModelAttribute("studDisAction")StudentDisciplinaryAction studDisAction, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/Student_Disciplinary_Action/student_disaction_create");
	
		return modelandview;
	}
	
	@RequestMapping(value="/getStudentDisciplinaryActionUpdateForm", method=RequestMethod.GET)
	public ModelAndView getStudentDisciplinaryActionUpdateForm(@ModelAttribute("studDisAction")StudentDisciplinaryAction studDisAction, BindingResult result, Errors errors){

		///*** Checking whether the current session is expire or not and ***///
		///*** if this method is authorized for the current user or not ***///
		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
		
		if(check.checkCurrentSessionAuthentication() != null){
			
			return check.checkCurrentSessionAuthentication();
		}
		///*** END - Checking ***///
		
		StudentDisciplinaryAction studentDisAction = studentService.getStudentDisciplinaryActionBySdaid(studDisAction.getSda_id());
		
		ModelAndView modelandview = new ModelAndView("Student_Registration/Student_Disciplinary_Action/student_disaction_edit");
	
		modelandview.addObject("studentDisAction", studentDisAction);
		
		return modelandview;
	}
	
	///>>>--- END - DISCIPLINARY ACTION ---<<<////
}
