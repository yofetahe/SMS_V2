package com.fidel.sms.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fidel.sms.model.AnnualTerms;
import com.fidel.sms.model.ClassScheduleSubjectPeriodRelation;
import com.fidel.sms.model.ClassType;
import com.fidel.sms.model.DAAttendanceType;
import com.fidel.sms.model.ExamDefaultComment;
import com.fidel.sms.model.ExamGrade;
import com.fidel.sms.model.ExamSchedule;
import com.fidel.sms.model.Holidays;
import com.fidel.sms.model.PaymentClassRelation;
import com.fidel.sms.model.PaymentType;
import com.fidel.sms.model.SchoolEvent;
import com.fidel.sms.model.SchoolInformation;
import com.fidel.sms.model.SubjectType;
import com.fidel.sms.model.TeacherHomeRoomAssignment;
import com.fidel.sms.model.TeacherInformation;
import com.fidel.sms.service.AnnualTermsService;
import com.fidel.sms.service.AttendanceService;
import com.fidel.sms.service.ClassScheduleService;
import com.fidel.sms.service.ClassTypeService;
import com.fidel.sms.service.ExamDefaultCommentService;
import com.fidel.sms.service.ExamScheduleService;
import com.fidel.sms.service.HolidaysService;
import com.fidel.sms.service.PaymentService;
import com.fidel.sms.service.SchoolEventService;
import com.fidel.sms.service.SchoolInformationService;
import com.fidel.sms.service.SubjectExamTypeService;
import com.fidel.sms.service.TeacherService;
import com.fidel.sms.utils.ReturnCurrentEthiopianYear;

public class AdminTemplateController {
	
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
	

}
