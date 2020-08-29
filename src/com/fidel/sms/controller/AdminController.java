package com.fidel.sms.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fidel.sms.model.AnnualTerms;
import com.fidel.sms.model.ClassDetail;
import com.fidel.sms.model.ClassScheduleSubjectPeriodRelation;
import com.fidel.sms.model.ClassType;
import com.fidel.sms.model.ClassTypeClassDetailRelation;
import com.fidel.sms.model.DAAttendance;
import com.fidel.sms.model.DAAttendanceType;
import com.fidel.sms.model.ExamDefaultComment;
import com.fidel.sms.model.ExamGrade;
import com.fidel.sms.model.ExamSchedule;
import com.fidel.sms.model.Holidays;
import com.fidel.sms.model.PaymentClassRelation;
import com.fidel.sms.model.PaymentFine;
import com.fidel.sms.model.PaymentMaterialClassRelation;
import com.fidel.sms.model.PaymentType;
import com.fidel.sms.model.PaymentTypeMaterialList;
import com.fidel.sms.model.SchoolEvent;
import com.fidel.sms.model.SchoolInformation;
import com.fidel.sms.model.StudentInformation;
import com.fidel.sms.model.StudentMaterials;
import com.fidel.sms.model.StudentRegistration;
import com.fidel.sms.model.SubjectType;
import com.fidel.sms.model.SystemURL;
import com.fidel.sms.model.TeacherHomeRoomAssignment;
import com.fidel.sms.model.TeacherInformation;
import com.fidel.sms.utils.CheckCurrentSessionAndAuthentication;
import com.fidel.sms.utils.DeleteSecurityFile;
import com.fidel.sms.utils.ReturnCurrentEthiopianYear;
import com.fidel.sms.utils.SessionManager;
import com.fidel.sms.utils.SystemValidator;
import com.fidel.sms.utils.TodayDate_YYYYMMDD;
import com.fidel.sms.model.Users;
import com.fidel.sms.service.UsersService;
import com.fidel.sms.service.ExamScheduleService;
import com.fidel.sms.service.HolidaysService;
import com.fidel.sms.service.PaymentService;
import com.fidel.sms.service.SchoolEventService;
import com.fidel.sms.service.SchoolInformationService;
import com.fidel.sms.service.StudentMaterialsService;
import com.fidel.sms.service.AnnualTermsService;
import com.fidel.sms.service.AttendanceService;
import com.fidel.sms.service.ClassScheduleService;
import com.fidel.sms.service.ClassTypeService;
import com.fidel.sms.service.ExamDefaultCommentService;
import com.fidel.sms.service.StudentService;
import com.fidel.sms.service.SubjectExamTypeService;
import com.fidel.sms.service.SystemURLService;
import com.fidel.sms.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="admin")
public class AdminController {
	
	@Autowired
	UsersService usersService;
	@Autowired
	SystemURLService systemURLService;
	@Autowired
	StudentService studentService;
	@Autowired
	AnnualTermsService annualTermsService;
	@Autowired
	AttendanceService attendanceService;
	@Autowired
	ExamDefaultCommentService defaultCommentService;
	@Autowired
	ClassTypeService classTypeService;
	@Autowired
	ClassScheduleService classScheduleService;
	@Autowired
	SubjectExamTypeService subjectExamTypeService;
	@Autowired
	ExamScheduleService examScheduleService;
	@Autowired
	HolidaysService holidaysService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	PaymentService paymentService;
	@Autowired
	SchoolEventService schoolEventService;
	@Autowired
	SchoolInformationService schoolInformationService;
	@Autowired
	StudentMaterialsService studentMaterialsService;
		
//	@RequestMapping(value="/validateLoginForm", method=RequestMethod.POST)
//	public ModelAndView validateLoginForm(@ModelAttribute("users")Users users, BindingResult result, Errors errors){
//		
//		///*** check system security ***///
//		if(!isTheSystemSecure()){
//			
//			DeleteSecurityFile.deleteSystemFileForSecurityPurpose();
//			
//			ModelAndView modelandview = new ModelAndView("redirect:access_denied");
//			
//			return modelandview;
//		}
//		
//		///*** check point 1 - user name and password is given or not ***///
//		if(users.getUser_name().equals("")){
//			errors.rejectValue("user_name", "username is required"); 
//		}
//		if(users.getPassword().equals("")){
//			errors.rejectValue("password", "password is required");
//		}
//		
//		///>>>*** check if user_name and password is super-administrator ***<<<///
//		if(!users.getUser_name().isEmpty() && !users.getPassword().isEmpty() && users.getUser_name().equals("smssuperadmin") && users.getPassword().equals("P@55w0rd@sms")){
//			
//			List<SystemURL> urlList = systemURLService.getAllURL();
//			
//			//Notice: user_id set to 1
//			SessionManager.addingUserOnSession(users.getUser_name(), 1, urlList);
//			
//			ModelAndView modelandview = new ModelAndView("redirect:index");
//
//			return modelandview;
//		}
//		System.out.println("After");
//		///*** check point 2 - validate user_name and password ***///
//		boolean validateUsernamePassword = false;
//		
//		if((!users.getUser_name().isEmpty() && !users.getPassword().isEmpty()) && !usersService.validateUser(users.getUser_name(), users.getPassword())){
//			
//			errors.reject("");
//			
//			validateUsernamePassword = true;
//		}
//		
//		///*** validate the previous 2 check points has errors or not ***///
//		if(result.hasErrors()){
//			
//			ModelAndView modelandview = new ModelAndView("General/login");			
//			
//			modelandview.addObject("username_error", (users.getUser_name().isEmpty())?"username is required":"");
//			modelandview.addObject("password_error", (users.getPassword().isEmpty())?"password is required":"");
//			modelandview.addObject("input_error", (validateUsernamePassword)?"Username or Password is incorrect.":"");
//			
//			if(!users.getUser_name().equals("")){
//				
//				users.setUser_name(users.getUser_name());
//			}
//			
//			return modelandview;
//		}
//		
//		///*** check user privilege to work on the system ***///
//		if(usersService.checkUserStatus(users.getUser_name(), users.getPassword())){
//			
//			ModelAndView modelandview = new ModelAndView("redirect:inactiveUser");
//			
//			return modelandview;
//		}
//		
//		///*** getting all the authenticated URL and put on session ***///
//		List<SystemURL> urlList = systemURLService.getAuthenticatedURL(users.getUser_name());
//		
//		SessionManager.addingUserOnSession(users.getUser_name(), usersService.getUserId(users.getUser_name()), urlList);
//		
//		///*** return index page ***///
//		ModelAndView modelandview = new ModelAndView("redirect:index");
//		
//		return modelandview;
//	}
//	
//	///*** check system security ***///
//	public boolean isTheSystemSecure(){
//		
//		return SystemValidator.systemValidation();
//	}
//	
//	@RequestMapping(value="/index", method=RequestMethod.GET)
//	public ModelAndView index(){
//		
//		///*** Checking whether the current session is expire or not and ***///
//		///*** if this method is authorized for the current user or not ***///
//		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
//		
//		if(check.checkCurrentSessionAuthentication() != null){
//			
//			return check.checkCurrentSessionAuthentication();
//		}
//		///*** END - Checking ***///
//		
//		///*** getting student number per sex of current year
//		List<StudentInformation> db_stud_persex = studentService.stud_db_persex();
//		
//		ModelAndView modelandview = new ModelAndView("General/index");
//
//		modelandview.addObject("db_stud_persex", db_stud_persex);
//		
//		modelandview.addObject("academic_year", TodayDate_YYYYMMDD.getCurrentEthiopianYear());
//		
//		return modelandview;
//	}
//	
//	@RequestMapping(value="/login", method=RequestMethod.GET)
//	public ModelAndView loginForm() {
//				
//		ModelAndView modelandview = new ModelAndView("General/login");
//		
//		return modelandview;
//	}
//	
//	@RequestMapping(value="/logout", method=RequestMethod.GET)
//	public String logout(){
//		
//		SessionManager.clearSession();
//		
//		return "redirect:login";
//	}
//
//	@RequestMapping(value="/session_expire", method=RequestMethod.GET)
//	public ModelAndView session_expire(@ModelAttribute("user") Users users, BindingResult result) {
//				
//		ModelAndView modelandview = new ModelAndView("General/session_expire");
//		
//		return modelandview;
//	}
//	
//	@RequestMapping(value="/access_denied", method=RequestMethod.GET)
//	public ModelAndView access_denied(@ModelAttribute("user") Users users, BindingResult result) {
//				
//		ModelAndView modelandview = new ModelAndView("General/access_denied_page");
//		
//		return modelandview;
//	}
//	
//	@RequestMapping(value="/inactiveUser", method=RequestMethod.GET)
//	public ModelAndView inactiveUser(@ModelAttribute("user") Users users, BindingResult result) {
//				
//		ModelAndView modelandview = new ModelAndView("General/login");
//		
//		modelandview.addObject("input_error", "You are not allowed to work on the system. Please talk to your supervisor.");
//		
//		return modelandview;
//	}
	
	
	
	
//	@RequestMapping(value="/changeProfile", method=RequestMethod.GET)
//	public ModelAndView changeProfile(@ModelAttribute("user")Users user, BindingResult result) {
//		
//		ModelAndView modelandview = new ModelAndView("General/change_profile");
//		
//		return modelandview;
//	}
//	
//	@RequestMapping(value="/changeUserProfile", method=RequestMethod.GET)
//	public ModelAndView changeUserProfile(@ModelAttribute("user") Users users, BindingResult result){
//		
//		///*** Checking whether the current session is expire or not and ***///
//		///*** if this method is authorized for the current user or not ***///
//		CheckCurrentSessionAndAuthentication check = new CheckCurrentSessionAndAuthentication();
//				
//		if(check.checkCurrentSessionAuthentication() != null){
//			
//			return check.checkCurrentSessionAuthentication();
//		}
//		///*** END - Checking ***///
//		
//		boolean rslt = usersService.updateUserNamePassword(users);
//		
//		ModelAndView modelandview = new ModelAndView("General/login");
//		
//		if(rslt){
//						
//			modelandview.addObject("successMessage", "Profile successfully changed.");
//		} else {
//			
//			modelandview.addObject("errorMessage", "Profile information is not changed. Please try again.");
//		}
//		
//		return modelandview;
//	}
		
	
	
	
	
	
	
	
	
	@RequestMapping(value="/getAdminTemplate", method=RequestMethod.GET)
	public ModelAndView getAdminTemplate(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("redirect:adminList");
		
		return modelandview;
	}
	
	@RequestMapping(value="/adminList", method=RequestMethod.GET)
	public ModelAndView adminList(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("Admin/admin_template");
		
		return modelandview;
	}
	
	@RequestMapping(value="/getUsersManagementModule", method=RequestMethod.GET)
	public ModelAndView getUsersManagementModule(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("Admin/UsersManagement/usersManagementTemplate");
		
		return modelandview;
	}
	
	
	@RequestMapping(value="/getAnnualTermTemplate", method=RequestMethod.GET)
	public ModelAndView getAnnualTermTemplate(@ModelAttribute("annualTerms")AnnualTerms annualTerms, BindingResult result, Errors errors){
	
		List<AnnualTerms> annualTermList = annualTermsService.getAllAnnualTermsList();
		
		ModelAndView modelandview = new ModelAndView("Admin/AnnualTerm/annual_term_list");
		
		modelandview.addObject("annualTermList", annualTermList);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getAttendanceTypeTemplate", method=RequestMethod.GET)
	public ModelAndView getAttendanceTypeTemplate(@ModelAttribute("attendanceType")DAAttendanceType attendanceType, BindingResult result, Errors errors){
	
		List<DAAttendanceType> attendanceTypeList = attendanceService.getAllAttendanceTypeList();
		
		ModelAndView modelandview = new ModelAndView("Admin/Attendance/attendance_type_template");
		
		modelandview.addObject("attendanceTypeList", attendanceTypeList);
		
		return modelandview;
	}
	
	
	@RequestMapping(value="/getBehaviouralEvaluationTemplate", method=RequestMethod.GET)
	public ModelAndView getBehaviouralEvaluationTemplate(@ModelAttribute("attendanceType")DAAttendanceType attendanceType, BindingResult result, Errors errors){
	
		//List<DAAttendanceType> attendanceTypeList = attendanceService.getAllAttendanceTypeList();
		
		ModelAndView modelandview = new ModelAndView("Admin/BehaviouralEvaluation/behavioural_evaluation_template");
		
		//modelandview.addObject("attendanceTypeList", attendanceTypeList);
		
		return modelandview;
	}
	
	
	@RequestMapping(value="/getCertificateDefaultCommentTemplate", method=RequestMethod.GET)
	public ModelAndView getCertificateDefaultCommentTemplate(@ModelAttribute("defaultComment")ExamDefaultComment defaultComment, BindingResult result, Errors errors){
	
		List<ExamDefaultComment> defaultCommentList = defaultCommentService.getAllDefaultComment();
		
		ModelAndView modelandview = new ModelAndView("Admin/CertificateDefaultComment/cert_default_comment_list");
		
		modelandview.addObject("defaultCommentList", defaultCommentList);
		
		return modelandview;
	}
	
	
	@RequestMapping(value="/getClassAllotmentTemplate", method=RequestMethod.GET)
	public ModelAndView getClassAllotmentTemplate(@ModelAttribute("subjectAllotment")ClassScheduleSubjectPeriodRelation subjectAllotment, BindingResult result, Errors errors){
	
		String[] acadmicYearList = {	
				String.valueOf(Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear())), 
				String.valueOf(Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear())-1)
			};
		
		List<ClassScheduleSubjectPeriodRelation> assignPeriodList = classScheduleService.getGeneralPeriodAssignmentByAcademicYear(Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()));
		
		List<ClassType> classTypeList = classTypeService.getAllClassList();
		
		ModelAndView modelandview = new ModelAndView("Admin/ClassAllotment/class_allotment_template");

		modelandview.addObject("assignPeriodList", assignPeriodList);
		
		modelandview.addObject("classTypeList", classTypeList);
		
		modelandview.addObject("academic_year", ReturnCurrentEthiopianYear.getCurrentEthiopianYear());
		
		modelandview.addObject("acadmicYearList", acadmicYearList);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getSubjectListPerClassForClassAllotment", method=RequestMethod.GET)
	public ModelAndView getSubjectListPerClassForClassAllotment(@ModelAttribute("subjectAllotment")ClassScheduleSubjectPeriodRelation subjectAllotment, BindingResult result, Errors errors){
	
		List<SubjectType> subjectList = subjectExamTypeService.getSubjectListWithPeriodAllotmentByCl_id(subjectAllotment.getCl_id());
		
		ModelAndView modelandview = new ModelAndView("Admin/ClassAllotment/subject_period_allotment_form");
		
		modelandview.addObject("subjectList", subjectList);
		
		return modelandview;
	}
	
	
	@RequestMapping(value="/getExamGradingTemplate", method=RequestMethod.GET)
	public ModelAndView getExamGradingTemplate(@ModelAttribute("examGrading")ExamGrade examGrading, BindingResult result, Errors errors){
	
		List<ExamGrade> gradingList = subjectExamTypeService.getExamGradingList();
		
		ModelAndView modelandview = new ModelAndView("Admin/ExamGrading/exam_grading_list");
		
		modelandview.addObject("gradingList", gradingList);
		
		return modelandview;
	}
	
	
	
	
	@RequestMapping(value="/getExamScheduleTemplate", method=RequestMethod.GET)
	public ModelAndView getExamScheduleTemplate(@ModelAttribute("examSchedule")ExamSchedule examSchedule, BindingResult result, Errors errors){

		String[] acadmicYearList = {	
				String.valueOf(Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear())), 
				String.valueOf(Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear())-1)
			};
		
		List<AnnualTerms> annualTermList = annualTermsService.getActiveAnnualTermsList();
		
		List<ExamGrade> gradingList = subjectExamTypeService.getExamGradingList();
		
		List<ClassType> classTypeList = classTypeService.getActiveClassList();
		
		ModelAndView modelandview = new ModelAndView("Admin/ExamSchedule/examschedule_list");
		
		modelandview.addObject("gradingList", gradingList);
		
		modelandview.addObject("acadmicYearList", acadmicYearList);
		
		modelandview.addObject("annualTermList", annualTermList);
		
		modelandview.addObject("classTypeList", classTypeList);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getNewExamScheduleRegistrationForm", method=RequestMethod.GET)
	public ModelAndView getNewExamScheduleRegistrationForm(@ModelAttribute("examSchedule")ExamSchedule examSchedule, BindingResult result, Errors errors){
	
		List<AnnualTerms> annualTermList = annualTermsService.getActiveAnnualTermsList();
		
		List<ClassType> classTypeList = classTypeService.getActiveClassList();
		
		ModelAndView modelandview = new ModelAndView("Admin/ExamSchedule/examschedule_create");
		
		modelandview.addObject("annualTermList", annualTermList);
		
		modelandview.addObject("classTypeList", classTypeList);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getExamScheduleByClassId", method=RequestMethod.GET)
	public ModelAndView getExamScheduleByClassId(@ModelAttribute("examSchedule")ExamSchedule examSchedule, BindingResult result, Errors errors){
	
		List<ExamSchedule> examScheduleList = examScheduleService.getExamScheduleByCl_idAt_idAcademic_year(examSchedule.getCl_id(), examSchedule.getAt_id(), examSchedule.getEs_fiscalyear());
		
		ModelAndView modelandview = new ModelAndView("Admin/ExamSchedule/examschedule_filtered_list");
		
		modelandview.addObject("examScheduleList", examScheduleList);
		
		return modelandview;
	}
	
	
	
	
	@RequestMapping(value="/getHolidayListTemplate", method=RequestMethod.GET)
	public ModelAndView getHolidayListTemplate(@ModelAttribute("holidays")Holidays holidays, BindingResult result, Errors errors){
	
		List<Holidays> holidaysList = holidaysService.getAllHolidays();
		
		ModelAndView modelandview = new ModelAndView("Admin/Holiday/holiday_list");
		
		modelandview.addObject("holidaysList", holidaysList);
		
		return modelandview;
	}
	
	
	
	
	
	
	@RequestMapping(value="/getHomeRoomTeachersTemplate", method=RequestMethod.GET)
	public ModelAndView getHomeRoomTeachersTemplate(@ModelAttribute("homeroomAssign")TeacherHomeRoomAssignment homeroomAssign, BindingResult result, Errors errors){
	
		List<TeacherHomeRoomAssignment> teachersAssignment = teacherService.getAssignedHomeRoomTeacherListByAcademic_year(Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()));
				
		List<TeacherInformation> teachersList = teacherService.getActiveTeacherList();
		
		List<ClassType> classTypeList = classTypeService.getActiveClassList();
		
		ModelAndView modelandview = new ModelAndView("Admin/HomeRoomTeacherAssignment/homeroomteacherassign_template");

		modelandview.addObject("teachersAssignment", teachersAssignment);

		modelandview.addObject("teachersList", teachersList);

		modelandview.addObject("classTypeList", classTypeList);
		
		modelandview.addObject("academic_year", ReturnCurrentEthiopianYear.getCurrentEthiopianYear());
		
		return modelandview;
	}
	
	
	
	
	
	
//	@RequestMapping(value="/getIDCardGeneratorTemplate", method=RequestMethod.GET)
//	public ModelAndView getIDCardGeneratorTemplate(@ModelAttribute("homeroomAssign")TeacherHomeRoomAssignment homeroomAssign, BindingResult result, Errors errors){
//	
//		List<ClassType> classTypeList = classTypeService.getActiveClassList();
//		
//		ModelAndView modelandview = new ModelAndView("Admin/IDCardGeneration/id_card_generation_template");
//
//		modelandview.addObject("class_list", classTypeList);
//		
//		return modelandview;
//	}
//	
//	@RequestMapping(value="/getClassDetailListForIDCardByClassId", method=RequestMethod.GET)
//	public ModelAndView getClassDetailListForIDCardByClassId(@ModelAttribute("classType")ClassType classType, BindingResult result, Errors errors){
//	
//		List<ClassDetail> class_detail = classTypeService.getClassDetailListByCl_id(classType.getCl_id());
//		
//		ModelAndView modelandview = new ModelAndView("Admin/IDCardGeneration/class_detail_list");
//
//		modelandview.addObject("class_detail", class_detail);
//		
//		return modelandview;
//	}
//	
//	@RequestMapping(value="/getStudentListPerClassDetailForIDCard", method=RequestMethod.GET)
//	public ModelAndView getStudentListPerClassDetailForIDCard(@ModelAttribute("classTypeClassDetailRel")ClassTypeClassDetailRelation classTypeClassDetailRel, BindingResult result, Errors errors){
//	
//		List<StudentInformation> stud_with_id_rslt = studentService.getStudListWithIDPerGradeDetail(classTypeClassDetailRel.getCl_id(), classTypeClassDetailRel.getCd_id(), Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()));
//		
//		List<StudentInformation> stud_with_out_id_rslt = studentService.getStudListWithoutIDPerGradeDetail(classTypeClassDetailRel.getCl_id(), classTypeClassDetailRel.getCd_id(), Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()));
//		
//		ModelAndView modelandview = new ModelAndView("Admin/IDCardGeneration/student_list");
//
//		modelandview.addObject("stud_with_id_rslt", stud_with_id_rslt);
//		
//		modelandview.addObject("stud_with_out_id_rslt", stud_with_out_id_rslt);
//		
//		return modelandview;
//	}
//	
//	@RequestMapping(value="/getStudentListDontHavePhoto", method=RequestMethod.GET)
//	public ModelAndView getStudentListDontHavePhoto(@ModelAttribute("classTypeClassDetailRel")ClassTypeClassDetailRelation classTypeClassDetailRel, BindingResult result, Errors errors){
//	
//		List<StudentInformation> stud_without_photo_contact_rslt = studentService.getStudentListWithoutPhotoByCl_idCd_idAcadmic_year(classTypeClassDetailRel.getCl_id(), classTypeClassDetailRel.getCd_id(), Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()));
//		
//		ModelAndView modelandview = new ModelAndView("Admin/IDCardGeneration/stud_without_photo_contact_info");
//
//		modelandview.addObject("stud_without_photo_contact_rslt", stud_without_photo_contact_rslt);
//		
//		modelandview.addObject("pageTitle", "Student List Who Don't Have Photo");
//		
//		return modelandview;
//	}
//	
//	@RequestMapping(value="/getStudentListDontHaveContactInfo", method=RequestMethod.GET)
//	public ModelAndView getStudentListDontHaveContactInfo(@ModelAttribute("classTypeClassDetailRel")ClassTypeClassDetailRelation classTypeClassDetailRel, BindingResult result, Errors errors){
//	
//		List<StudentInformation> stud_without_photo_contact_rslt = studentService.getStudentWithoutContactInfoByCl_idCd_idAcadmic_year(classTypeClassDetailRel.getCl_id(), classTypeClassDetailRel.getCd_id(), Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()));
//		
//		ModelAndView modelandview = new ModelAndView("Admin/IDCardGeneration/stud_without_photo_contact_info");
//
//		modelandview.addObject("stud_without_photo_contact_rslt", stud_without_photo_contact_rslt);
//
//		modelandview.addObject("pageTitle", "Student List Who Don't Have Emergency Contact Information");
//		
//		return modelandview;
//	}
	
	
	
	
	@RequestMapping(value="/getPaymentAmountTemplate", method=RequestMethod.GET)
	public ModelAndView getPaymentAmountTemplate(@ModelAttribute("homeroomAssign")TeacherHomeRoomAssignment homeroomAssign, BindingResult result, Errors errors){
	
		List<PaymentClassRelation> paymentAmountList = paymentService.getPaymentAmountList();
		
		List<ClassType> classTypeList = classTypeService.getActiveClassList();
		
		List<PaymentType> paymentTypeList = paymentService.getActivePaymentTypeList();
		
		ModelAndView modelandview = new ModelAndView("Admin/PaymentAdmin/payment_admin_template");

		modelandview.addObject("paymentAmountList", paymentAmountList);

		modelandview.addObject("classTypeList", classTypeList);

		modelandview.addObject("paymentTypeList", paymentTypeList);
		
		return modelandview;
	}
	
	
	
	
	
	@RequestMapping(value="/getSchoolEventTemplate", method=RequestMethod.GET)
	public ModelAndView getSchoolEventTemplate(@ModelAttribute("schoolEvent")SchoolEvent schoolEvent, BindingResult result, Errors errors){
	
		List<SchoolEvent> schoolEventList = schoolEventService.getAllSchoolEvent();
		
		ModelAndView modelandview = new ModelAndView("Admin/SchoolEvent/schoolevent_list");

		modelandview.addObject("schoolEventList", schoolEventList);

		return modelandview;
	}
	
	
	
	
	@RequestMapping(value="/getSchoolInformationTemplate", method=RequestMethod.GET)
	public ModelAndView getSchoolInformationTemplate(@ModelAttribute("schoolInfo")SchoolInformation schoolInfo, BindingResult result, Errors errors){
	
		SchoolInformation schoolInformation = schoolInformationService.getSchoolInformation();
		
		ModelAndView modelandview = new ModelAndView("Admin/SchoolInformation/school_information");

		modelandview.addObject("schoolInformation", schoolInformation);
		
		if(schoolInformation.getSchool_name().length() != 0){
			
			modelandview.addObject("formType", "update");
		}

		return modelandview;
	}
	
	@RequestMapping(value="/getOrganizationLogo", method=RequestMethod.GET)
	public void getOrganizationLogo(@ModelAttribute("schoolInfo")SchoolInformation schoolInfo, HttpServletResponse response){
		
		byte[] schoolLogo = schoolInformationService.getOrganizationLogoById(schoolInfo.getSch_inf_id());
		
		if(schoolLogo == null){
			
			File image = new File("C:\\sms_system_file\\everest\\Photos\\stud_photo\\default.jpeg");
			byte[] fileContent;
			try {
				fileContent = Files.readAllBytes(image.toPath());
				schoolLogo = fileContent;
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
		
		if(schoolLogo != null){
						
			try {
//				response.reset();
				response.setContentType("image/jpeg");
				response.getOutputStream().write(schoolLogo, 0, schoolLogo.length);
				response.getOutputStream().flush();
				response.getOutputStream().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
//	@RequestMapping(value="/getSpecialRegistrationTemplate", method=RequestMethod.GET)
//	public ModelAndView getSpecialRegistrationTemplate(@ModelAttribute("homeroomAssign")TeacherHomeRoomAssignment homeroomAssign, BindingResult result, Errors errors){
//	
//		List<ClassType> classTypeList = classTypeService.getActiveClassList();
//		
//		ModelAndView modelandview = new ModelAndView("Admin/SpecialRegistration/special_registration_template");
//
//		modelandview.addObject("class_list", classTypeList);
//		
//		return modelandview;
//	}
//	
//	@RequestMapping(value="/getClassDetailByClassIdForSpecialRegistration", method=RequestMethod.GET)
//	public ModelAndView getClassDetailByClassIdForSpecialRegistration(@ModelAttribute("classType")ClassType classType, BindingResult result, Errors errors){
//	
//		List<ClassDetail> class_detail = classTypeService.getClassDetailListByCl_id(classType.getCl_id());
//		
//		ModelAndView modelandview = new ModelAndView("Admin/SpecialRegistration/class_detail_list");
//
//		modelandview.addObject("class_detail", class_detail);
//		
//		return modelandview;
//	}
//	
//	@RequestMapping(value="/getStudentListPerClassDetailForSpecialReg", method=RequestMethod.GET)
//	public ModelAndView getStudentListPerClassDetailForSpecialReg(@ModelAttribute("classTypeClassDetailRel")ClassTypeClassDetailRelation classTypeClassDetailRel, BindingResult result, Errors errors){
//	
//		List<StudentInformation> unregistered_student_list = studentService.getUnregistedStudentListPerGradeDetailForSpecialReg(classTypeClassDetailRel.getCl_id(), classTypeClassDetailRel.getCd_id(), Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()));
//		
//		List<StudentInformation> registered_student_list = studentService.getRegisteredStudentListPerGradeDetailForSpecialReg(classTypeClassDetailRel.getCl_id(), classTypeClassDetailRel.getCd_id(), Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()));
//		
//		ModelAndView modelandview = new ModelAndView("Admin/SpecialRegistration/special_registration_student_list");
//
//		modelandview.addObject("unregistered_student_list", unregistered_student_list);
//
//		modelandview.addObject("registered_student_list", registered_student_list);
//		
//		return modelandview;
//	}
	
	
	
	
	
	
//	@RequestMapping(value="/getStudentMaterialTemplate", method=RequestMethod.GET)
//	public ModelAndView getStudentMaterialTemplate(@ModelAttribute("classType")ClassType classType, BindingResult result, Errors errors){
//	
//		ModelAndView modelandview = new ModelAndView("Admin/StudentMaterial/student_material_template");
//
//		return modelandview;
//	}
//	
//	@RequestMapping(value="/getMaterialList", method=RequestMethod.GET)
//	public ModelAndView getMaterialList(@ModelAttribute("classType")ClassType classType, BindingResult result, Errors errors){
//		
//		List<PaymentTypeMaterialList> materialList = studentMaterialsService.getAllStudentMaterialList();
//	
//		ModelAndView modelandview = new ModelAndView("Admin/StudentMaterial/student_material_list");
//
//		modelandview.addObject("materialList", materialList);
//		
//		return modelandview;
//	}
//	
//	@RequestMapping(value="/getMaterialClassRelation", method=RequestMethod.GET)
//	public ModelAndView getMaterialClassRelation(@ModelAttribute("materialClassRel")PaymentMaterialClassRelation materialClassRel, BindingResult result, Errors errors){
//		
//		List<PaymentMaterialClassRelation> materialClassRelList = studentMaterialsService.getAllClassMaterialRelationList();
//		
//		List<ClassType> classTypeList = classTypeService.getActiveClassList();
//		
//		List<PaymentTypeMaterialList> materialList = studentMaterialsService.getAllStudentMaterialList();
//	
//		ModelAndView modelandview = new ModelAndView("Admin/StudentMaterial/class_material_relationship/class_material_rel_list");
//
//		modelandview.addObject("materialClassRelList", materialClassRelList);
//		
//		modelandview.addObject("classTypeList", classTypeList);
//
//		modelandview.addObject("materialList", materialList);
//		
//		return modelandview;
//	}
}
