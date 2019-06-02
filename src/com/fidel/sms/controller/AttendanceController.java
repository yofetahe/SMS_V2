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
import com.fidel.sms.model.DAAttendance;
import com.fidel.sms.model.DAAttendanceType;
import com.fidel.sms.model.StudentInformation;
import com.fidel.sms.model.TeacherInformation;
import com.fidel.sms.service.AttendanceService;
import com.fidel.sms.service.ClassTypeService;
import com.fidel.sms.service.StudentService;
import com.fidel.sms.utils.ReturnCurrentEthiopianYear;

@Controller
@RequestMapping(value="attendance")
public class AttendanceController {
	
	@Autowired
	ClassTypeService classTypeService;
	@Autowired
	StudentService studentService;
	@Autowired
	AttendanceService attendanceService;
	
	@RequestMapping(value="/getAttendanceTemplate", method=RequestMethod.GET)
	public ModelAndView getAttendanceTemplate(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("redirect:attendanceList");
		
		return modelandview;
	}
	
	@RequestMapping(value="/attendanceList", method=RequestMethod.GET)
	public ModelAndView attendanceList(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		List<ClassType> class_type_list = classTypeService.getActiveClassList();
				
		ModelAndView modelandview = new ModelAndView("Attendance/attendance_template");

		modelandview.addObject("class_list", class_type_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getGradeDetailListPerSelectedClassForAttendance", method=RequestMethod.GET)
	public ModelAndView getGradeDetailListPerSelectedClassForAttendance(@ModelAttribute("classType")ClassType classType, BindingResult result, Errors errors){
	
		List<ClassDetail> class_detail = classTypeService.getClassDetailListByCl_id(classType.getCl_id());
				
		ModelAndView modelandview = new ModelAndView("Attendance/class_detail_list");

		modelandview.addObject("class_detail", class_detail);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getStudentListPerClassDetail", method=RequestMethod.GET)
	public ModelAndView getStudentListPerClassDetail(@ModelAttribute("classDetailRel")ClassTypeClassDetailRelation classDetailRel, BindingResult result, Errors errors){
	
		List<StudentInformation> student_list = studentService.getStudentListPerGradeDetail(classDetailRel.getCl_id(), classDetailRel.getCd_id(), Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()));
		
		List<DAAttendanceType> attendance_type_list = attendanceService.getActiveAttendanceTypeList();
		
		List<AnnualTerms> quarter_list = attendanceService.getActiveAnnualQuarters();
		
		Integer classSize = attendanceService.getClassCapacity(classDetailRel.getCl_id(), classDetailRel.getCd_id());
		Double rwDbl = classSize/6.0;
		Integer rwInt = classSize/6;
		int rowNum = 0;
		
		if(rwDbl > rwInt){
			rowNum = rwInt + 1;
		} else {
			rowNum = rwInt;			
		}
		
		ModelAndView modelandview = new ModelAndView("Attendance/student_list_pergrade");

		modelandview.addObject("student_list", student_list);
		
		modelandview.addObject("attendance_type_list", attendance_type_list);
		
		modelandview.addObject("quarter_list", quarter_list);
		
		modelandview.addObject("classSize", 50);
		
		modelandview.addObject("listSize", student_list.size());
		
		modelandview.addObject("rowNum", rowNum);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getAbsentReasonAddForm", method=RequestMethod.GET)
	public ModelAndView getAbsentReasonAddForm(@ModelAttribute("attend")DAAttendance attend, BindingResult result, Errors errors){
	
		List<StudentInformation> absent_studnet_list = attendanceService.getAbsentStudentListByCl_idCD_idDate(attend.getcTypeCDetailRel().getCl_id(), attend.getcTypeCDetailRel().getCd_id(), attend.getAttendance_date());
				
		ModelAndView modelandview = new ModelAndView("Attendance/absent_student_list");

		modelandview.addObject("absent_studnet_list", absent_studnet_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getStudentsAggregateAbsentList", method=RequestMethod.GET)
	public ModelAndView getStudentsAggregateAbsentList(@ModelAttribute("attend")DAAttendance attend, BindingResult result, Errors errors){
	
		List<StudentInformation> aggStudAbsent_list = attendanceService.getAggregateStudentAbsentListByCl_idCD_idAt_id(attend.getcTypeCDetailRel().getCl_id(), attend.getcTypeCDetailRel().getCd_id(), attend.getAt_id());
				
		ModelAndView modelandview = new ModelAndView("Attendance/aggregate_student_absent_list");

		modelandview.addObject("aggStudAbsent_list", aggStudAbsent_list);
		
		return modelandview;
	}
}
