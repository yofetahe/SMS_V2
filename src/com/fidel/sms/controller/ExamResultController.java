package com.fidel.sms.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Comparator;
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

import com.fidel.sms.model.AnnualTerms;
import com.fidel.sms.model.BEvaluationStudentResult;
import com.fidel.sms.model.ClassDetail;
import com.fidel.sms.model.ClassType;
import com.fidel.sms.model.DAAttendance;
import com.fidel.sms.model.ExamDefaultComment;
import com.fidel.sms.model.ExamResult;
import com.fidel.sms.model.ExamResultComment;
import com.fidel.sms.model.ExamSchedule;
import com.fidel.sms.model.ExamSubjectClassGradeRelation;
import com.fidel.sms.model.ExamsType;
import com.fidel.sms.model.StudentInformation;
import com.fidel.sms.model.StudentRegistration;
import com.fidel.sms.model.SubjectType;
import com.fidel.sms.model.TeacherInformation;
import com.fidel.sms.service.AnnualTermsService;
import com.fidel.sms.service.BehaviouralEvaluationService;
import com.fidel.sms.service.ClassTypeService;
import com.fidel.sms.service.ExamDefaultCommentService;
import com.fidel.sms.service.ExamResultService;
import com.fidel.sms.service.StudentService;
import com.fidel.sms.service.SubjectExamTypeService;
import com.fidel.sms.utils.ReturnCurrentEthiopianYear;
import com.fidel.sms.utils.SysConstant;

@Controller
@RequestMapping(value="examresult")
public class ExamResultController {
	
	@Autowired
	StudentService studentService;
	@Autowired
	ClassTypeService classTypeService;
	@Autowired
	AnnualTermsService annualTermsService;
	@Autowired
	SubjectExamTypeService subjectExamTypeService;
	@Autowired
	ExamResultService examResultService;
	@Autowired
	BehaviouralEvaluationService bevalService;
	@Autowired
	ExamDefaultCommentService examDefaultCommentService;
	
	@RequestMapping(value="/getExamTemplate", method=RequestMethod.GET)
	public ModelAndView getExamTemplate(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("redirect:examResultList");
		
		return modelandview;
	}
	
	@RequestMapping(value="/examResultList", method=RequestMethod.GET)
	public ModelAndView examResultList(@ModelAttribute("teacherInfo")TeacherInformation teacherInfo, BindingResult result, Errors errors){
	
		ModelAndView modelandview = new ModelAndView("ExamRslt_Registration/exam_result_template");
		
		return modelandview;
	}
	
	@RequestMapping(value="/studentExamResultAddForm", method=RequestMethod.GET)
	public ModelAndView studentExamResultAddForm(@ModelAttribute("examResult")ExamResult examResult, BindingResult result, Errors errors){
			
		//Annual term list
		List<AnnualTerms> annualTermList = annualTermsService.getActiveAnnualTermsList();
		
		///*** getting class list ***///
		//List<ClassType> class_type_list = classTypeService.getActiveClassList();
		
		ModelAndView modelandview = new ModelAndView("ExamRslt_Registration/exam_result_registration/exam_result_registration_template");

		modelandview.addObject("annualTermList", annualTermList);
		
		//modelandview.addObject("class_list", class_type_list);
		
		modelandview.addObject("academic_year", ReturnCurrentEthiopianYear.getCurrentEthiopianYear());
		
		return modelandview;
	}
	
	@RequestMapping(value="/getClassListForExamResult", method=RequestMethod.GET)
	public ModelAndView getClassListForExamResult(@ModelAttribute("examResult")ExamResult examResult, BindingResult result, Errors errors){
			
		
		///*** getting class list ***///
		List<ClassType> class_type_list = classTypeService.getActiveClassList();
		
		ModelAndView modelandview = new ModelAndView("ExamRslt_Registration/exam_result_registration/er_class_list");

		modelandview.addObject("class_list", class_type_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/gradeDetailListForExamResult", method=RequestMethod.GET)
	public ModelAndView gradeDetailListForExamResult(@ModelAttribute("examResult")ExamResult examResult, BindingResult result, Errors errors){
			
		
		///*** getting class list ***///
		List<ClassDetail> class_detail = classTypeService.getClassDetailListByCl_id(examResult.getExamSubjectRel().getSubjectClassRel().getCl_id());
		
		ModelAndView modelandview = new ModelAndView("ExamRslt_Registration/exam_result_registration/er_grade_detail_list");

		modelandview.addObject("class_detail", class_detail);
		
		return modelandview;
	}
	
	@RequestMapping(value="/subjectListForExamResult", method=RequestMethod.GET)
	public ModelAndView subjectListForExamResult(@ModelAttribute("examResult")ExamResult examResult, BindingResult result, Errors errors){
			
		
		///*** getting class list ***///
		List<SubjectType> subject_list = subjectExamTypeService.getSubjectTypeListByCl_id(examResult.getExamSubjectRel().getSubjectClassRel().getCl_id());
		
		ModelAndView modelandview = new ModelAndView("ExamRslt_Registration/exam_result_registration/er_subject_list");

		modelandview.addObject("subject_list", subject_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/examTypeListForExamResult", method=RequestMethod.GET)
	public ModelAndView examTypeListForExamResult(@ModelAttribute("examSchedule")ExamSchedule examSchedule, BindingResult result, Errors errors){
			
		
		///*** getting class list ***///
		List<ExamsType> exam_type_list = subjectExamTypeService.getScheduledExamTypesBySubCl_idAcademic_yearAt_idCl_id(examSchedule.getEs_fiscalyear(), examSchedule.getAt_id(), examSchedule.getCl_id(), examSchedule.getSubjectClassRel().getSubcl_id());
		
		ModelAndView modelandview = new ModelAndView("ExamRslt_Registration/exam_result_registration/er_exam_list");

		modelandview.addObject("exam_type_list", exam_type_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getStudentExamResultRegistration", method=RequestMethod.GET)
	public ModelAndView getStudentExamResultRegistration(@ModelAttribute("examResult")ExamResult examResult, BindingResult result, Errors errors){
		
		
		
		
		List<ExamResult> unfilledStudentResultList = examResultService.getUnfilledStudentMarkListByCl_idCd_idExsub_idAt_idAcademic_year(examResult.getStudentRegistration().getClcdRelation().getCl_id(), examResult.getStudentRegistration().getClcdRelation().getCd_id(), examResult.getExamsub_id(), examResult.getAt_id(), examResult.getFiscal_year());
		
		List<ExamResult> filledStudentResultList = examResultService.getFilledStudentMarkListByCl_idCd_idExsub_idAt_idAcademic_year(examResult.getStudentRegistration().getClcdRelation().getCl_id(), examResult.getStudentRegistration().getClcdRelation().getCd_id(), examResult.getExamsub_id(), examResult.getAt_id(), examResult.getFiscal_year());
		
		ModelAndView modelandview = new ModelAndView("ExamRslt_Registration/exam_result_registration/exam_result_registration");

		modelandview.addObject("unfilledStudentResultList", unfilledStudentResultList);

		modelandview.addObject("filledStudentResultList", filledStudentResultList);
		
		modelandview.addObject("examDateStatus", examResultService.getExaminationDateValidation(examResult.getExamsub_id(), examResult.getFiscal_year()));
		
		return modelandview;
	}
	
	@RequestMapping(value="/getStudentSubjectMarkEditForm", method=RequestMethod.GET)
	public ModelAndView getStudentSubjectMarkEditForm(@ModelAttribute("examResult")ExamResult examResult, BindingResult result, Errors errors){
			
		
		
		List<ExamResult> exam_result = examResultService.getStudentExamResultWithStudInfoByEr_id(examResult.getEr_id());
		
		ModelAndView modelandview = new ModelAndView("ExamRslt_Registration/exam_result_registration/exam_result_edit_form");

		modelandview.addObject("exam_result", exam_result);
		
		return modelandview;
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/studentCertificateView", method=RequestMethod.GET)
	public ModelAndView studentCertificateView(@ModelAttribute("examResult")ExamResult examResult, BindingResult result, Errors errors){
		
		
				
		ModelAndView modelandview = new ModelAndView("ExamRslt_Registration/certificate_view/certificate_view_template");

		return modelandview;
	}
	
	
	@RequestMapping(value="/getTermCertificateTemplate", method=RequestMethod.GET)
	public ModelAndView getTermCertificateTemplate(@ModelAttribute("examResult")ExamResult examResult, BindingResult result, Errors errors){
		
		
		int[] acadmicYearList = new int[(Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()) - 2007) + 1];
		
		for(int i = Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()), j = 0; i >= 2007; i--, j++){
			
			acadmicYearList[j] = i;
		}
		
		List<AnnualTerms> annualTermList = annualTermsService.getActiveAnnualTermsList();
		
		List<ClassType> class_type_list = classTypeService.getActiveClassList();
		
		ModelAndView modelandview = new ModelAndView("ExamRslt_Registration/certificate_view/term_certificate/term_certifiate_template");

		modelandview.addObject("acadmicYearList", acadmicYearList);

		modelandview.addObject("annualTermList", annualTermList);

		modelandview.addObject("class_list", class_type_list);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getClassDetailListByClassId", method=RequestMethod.GET)
	public ModelAndView getClassDetailListByClassId(@ModelAttribute("examResult")ExamResult examResult, BindingResult result, Errors errors){
			
		
		
		List<ClassDetail> class_detail = classTypeService.getClassDetailListByCl_id(examResult.getStudentRegistration().getClcdRelation().getCl_id());
		
		ModelAndView modelandview = new ModelAndView("ExamRslt_Registration/certificate_view/term_certificate/er_grade_detail_list");

		modelandview.addObject("class_detail", class_detail);
		
		return modelandview;
	}
	
	@RequestMapping(value="/studentExamResultListPerClassDetail", method=RequestMethod.GET)
	public ModelAndView studentExamResultListPerClassDetail(@ModelAttribute("examResult")ExamResult examResult, BindingResult result, Errors errors){
		
		
		
		List<ExamResult> studTotalMark = examResultService.getStudentsQuarterTotalResultByAcademic_yearAt_idCl_idCd_id(examResult.getFiscal_year(), examResult.getAt_id(), examResult.getStudentRegistration().getClcdRelation().getCl_id(), examResult.getStudentRegistration().getClcdRelation().getCd_id());
		
		ClassType class_type = classTypeService.getClassTypeByCl_id(examResult.getStudentRegistration().getClcdRelation().getCl_id());
		
		ClassDetail class_detail = classTypeService.getClassDetailByCd_id(examResult.getStudentRegistration().getClcdRelation().getCd_id());
		
		ModelAndView modelandview = new ModelAndView("ExamRslt_Registration/certificate_view/term_certificate/quarter_exam_result_list");

		modelandview.addObject("studTotalMark", studTotalMark);
		
		modelandview.addObject("class_name", class_type.getClass_name());
		
		modelandview.addObject("class_detail_name", class_detail.getCd_name());
		
		return modelandview;
	}
	
	@RequestMapping(value="/getStudentResultDetail", method=RequestMethod.GET)
	public ModelAndView getStudentResultDetail(@ModelAttribute("examResult")ExamResult examResult, BindingResult result, Errors errors){
			
		
		
		List<ExamResult> studentMarkList = examResultService.getEachSubjectTotalMarkListBySi_idCl_idAt_idAcademic_year(examResult.getSi_id(), examResult.getStudentRegistration().getClcdRelation().getCl_id(), examResult.getAt_id(), examResult.getFiscal_year());

		StudentInformation student_info = studentService.getStudentInformationById(examResult.getSi_id());
		
		ClassType class_type = classTypeService.getClassTypeByCl_id(examResult.getStudentRegistration().getClcdRelation().getCl_id());
		
		ClassDetail class_detail = classTypeService.getClassDetailByCd_id(examResult.getStudentRegistration().getClcdRelation().getCd_id());
		
		ModelAndView modelandview = new ModelAndView("ExamRslt_Registration/certificate_view/term_certificate/total_exam_result_per_subject");

		modelandview.addObject("studentMarkList", studentMarkList);
		
		modelandview.addObject("full_name", student_info.getFname() + " " + student_info.getMname() + " " + student_info.getGname());

		modelandview.addObject("class_name", class_type.getClass_name());
		
		modelandview.addObject("class_detail_name", class_detail.getCd_name());
		
		return modelandview;
	}
	
	@RequestMapping(value="/getSubjectResultPerExamDetail", method=RequestMethod.GET)
	public ModelAndView getSubjectResultPerExamDetail(@ModelAttribute("examResult")ExamResult examResult, BindingResult result, Errors errors){
			
		
		
		List<ExamResult> markPerExamType = examResultService.getSubjectResultPerExamDetailBySi_idAt_idAcademic_year(examResult.getSi_id(), examResult.getAt_id(), examResult.getFiscal_year(), examResult.getExamSubjectRel().getSubjectClassRel().getSub_id());
		
		ModelAndView modelandview = new ModelAndView("ExamRslt_Registration/certificate_view/term_certificate/subject_exam_result_per_exam_type");

		modelandview.addObject("markPerExamType", markPerExamType);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getTeachersCertificateCommentAddForm", method=RequestMethod.GET)
	public ModelAndView getTeachersCertificateCommentAddForm(@ModelAttribute("examResult")ExamResult examResult, BindingResult result, Errors errors){
			
		

		StudentInformation student_info = studentService.getStudentInformationById(examResult.getSi_id());
		
		ClassType class_type = classTypeService.getClassTypeByCl_id(examResult.getStudentRegistration().getClcdRelation().getCl_id());
		
		ClassDetail class_detail = classTypeService.getClassDetailByCd_id(examResult.getStudentRegistration().getClcdRelation().getCd_id());
		
		ModelAndView modelandview = new ModelAndView("ExamRslt_Registration/certificate_view/term_certificate/teachers_comment_per_student/teachers_comment_create");
		
		modelandview.addObject("full_name", student_info.getFname() + " " + student_info.getMname() + " " + student_info.getGname());

		modelandview.addObject("class_name", class_type.getClass_name());
		
		modelandview.addObject("class_detail_name", class_detail.getCd_name());
		
		return modelandview;
	}
	
	@RequestMapping(value="/getTeachersCertificateCommentEditForm", method=RequestMethod.GET)
	public ModelAndView getTeachersCertificateCommentEditForm(@ModelAttribute("examResult")ExamResult examResult, BindingResult result, Errors errors){
			
		
		
		ExamResultComment teacherComment = examResultService.getTeacherCommentBySi_idCl_idAt_idAcademic_year(examResult.getSi_id(), examResult.getStudentRegistration().getClcdRelation().getCl_id(), examResult.getAt_id(), examResult.getFiscal_year());

		StudentInformation student_info = studentService.getStudentInformationById(examResult.getSi_id());
		
		ClassType class_type = classTypeService.getClassTypeByCl_id(examResult.getStudentRegistration().getClcdRelation().getCl_id());
		
		ClassDetail class_detail = classTypeService.getClassDetailByCd_id(examResult.getStudentRegistration().getClcdRelation().getCd_id());
		
		ModelAndView modelandview = new ModelAndView("ExamRslt_Registration/certificate_view/term_certificate/teachers_comment_per_student/teachers_comment_edit");
		
		modelandview.addObject("full_name", student_info.getFname() + " " + student_info.getMname() + " " + student_info.getGname());

		modelandview.addObject("class_name", class_type.getClass_name());
		
		modelandview.addObject("class_detail_name", class_detail.getCd_name());

		modelandview.addObject("teacherComment", teacherComment);
		
		return modelandview;
	}
	
	@RequestMapping(value="/getTermReportCardFormat", method=RequestMethod.GET)
	public ModelAndView getTermReportCardFormat(@ModelAttribute("examResult")ExamResult examResult, BindingResult result, Errors errors){
			
		
		
		
		List<ExamResult> quarterRsltView = examResultService.getStudentQuarterResultViewBySi_idCl_idAt_idAcademic_year(examResult.getSi_id(), examResult.getStudentRegistration().getClcdRelation().getCl_id(), examResult.getAt_id(), examResult.getFiscal_year());
		
		int total_student_number = studentService.getStudentNumberPerClassDetail(examResult.getStudentRegistration().getClcdRelation().getCl_id(), examResult.getStudentRegistration().getClcdRelation().getCd_id(), examResult.getFiscal_year());
		
		List<BEvaluationStudentResult> quarterEvaluation = bevalService.getStudentEvaluationResultBySi_idCl_id(examResult.getSi_id(), examResult.getStudentRegistration().getClcdRelation().getCl_id(), examResult.getAt_id(), examResult.getFiscal_year());
		
		ExamResultComment quarterTeacherComment = examResultService.getTeacherCommentBySi_idCl_idAt_idAcademic_year(examResult.getSi_id(), examResult.getStudentRegistration().getClcdRelation().getCl_id(), examResult.getAt_id(), examResult.getFiscal_year());
		
		
		Double grandTotal = 0.0, averageMark = 0.0;
		
		int subjectNum = 0;
		
		for(Object obj: quarterRsltView){
			
			Object[] feilds = (Object[])obj;
			
			//fields[9] - include in the total mark, fields[10] - convert to grade
			if(feilds[9].toString().equals("Yes") && feilds[10].toString().equals("NO")){
				
				subjectNum++;
				
				grandTotal += Double.parseDouble(feilds[11].toString()) + Double.parseDouble(feilds[15].toString());
			}
		}

		averageMark = grandTotal/subjectNum;

		
		ExamDefaultComment getDefaultComment = examDefaultCommentService.getDefaultCommentPerRank(averageMark);
		
		DAAttendance getAbsentDayList = examResultService.getStudentAbsentDayList(examResult.getSi_id(), examResult.getAt_id(), examResult.getFiscal_year());
		
		String home_room_teacher_name = examResultService.getHomeroomTeacherName(examResult.getStudentRegistration().getClcdRelation().getCl_id(), examResult.getStudentRegistration().getClcdRelation().getCd_id(), examResult.getFiscal_year());
		
		
		

		ModelAndView modelandview = new ModelAndView("ExamRslt_Registration/certificate_view/term_certificate/quarter_certificate_result_view");
		
		modelandview.addObject("quarterRsltView", quarterRsltView);

		modelandview.addObject("quarterEvaluation", quarterEvaluation);
		
		modelandview.addObject("quarterTeacherComment", quarterTeacherComment);

		modelandview.addObject("getDefaultComment", getDefaultComment);

		modelandview.addObject("getAbsentDayList", getAbsentDayList);
		
		modelandview.addObject("homeRoomTeacherName", home_room_teacher_name);
		
		modelandview.addObject("totalStudentNumber", total_student_number);
		
		modelandview.addObject("grandTotal", grandTotal);
		
		modelandview.addObject("averageMark", averageMark);
		
		modelandview.addObject("school_name", SysConstant.ORGANIZATION_FULL_NAME);

		modelandview.addObject("school_address", SysConstant.ORGANIZATION_ADDRESS);

		modelandview.addObject("school_location", SysConstant.ORGANIZATION_LOCATION);
		
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
	
	
	
	@RequestMapping(value="/getFullYearCertificateTemplate", method=RequestMethod.GET)
	public ModelAndView getFullYearCertificateTemplate(@ModelAttribute("examResult")ExamResult examResult, BindingResult result, Errors errors){
		
		
		int[] acadmicYearList = new int[(Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()) - 2007) + 1];
		
		for(int i = Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear()), j = 0; i >= 2007; i--, j++){
			
			acadmicYearList[j] = i;
		}
		
		List<AnnualTerms> annualTermList = annualTermsService.getActiveAnnualTermsList();
		
		List<ClassType> class_type_list = classTypeService.getActiveClassList();
		
		ModelAndView modelandview = new ModelAndView("ExamRslt_Registration/certificate_view/full_year_certificate/full_year_certificate_template");

		modelandview.addObject("acadmicYearList", acadmicYearList);

		modelandview.addObject("annualTermList", annualTermList);

		modelandview.addObject("class_list", class_type_list);
		
		return modelandview;
	}
		
	@RequestMapping(value="/studentFullYearExamResultListPerClassDetail", method=RequestMethod.GET)
	public ModelAndView studentFullYearExamResultListPerClassDetail(@ModelAttribute("examResult")ExamResult examResult, BindingResult result, Errors errors){
		
		
		List<ExamResult> studFullYearMark = examResultService.getStudentTotalResultPerEachQuarter(examResult.getStudentRegistration().getClcdRelation().getCl_id(), examResult.getStudentRegistration().getClcdRelation().getCd_id(), examResult.getFiscal_year());

		if(studFullYearMark.size() > 0){
			
			///// sorting student based on annual year average
			Collections.sort(studFullYearMark, new Comparator<ExamResult>() {
				
				public int compare(ExamResult a, ExamResult b){
					
					int rslt = 0;
					
					if(b.getAverage_quarter_mark() > a.getAverage_quarter_mark()){
						rslt = 1;
					}
					if(b.getAverage_quarter_mark() < a.getAverage_quarter_mark()){
						rslt = -1;
					}
					if(b.getAverage_quarter_mark() == a.getAverage_quarter_mark()){
						rslt = 0;
					}
					
					return rslt;
				}
			});
		}
		
		
		///>>> *** adding student rank based on the total mark *** <<<///
		
		double pervious_total = 0.0;
		
		int pervious_rank = 0, same_rank_counter = 0;
		
		for(int i = 0; i < studFullYearMark.size(); i++){
			
			if(pervious_total == 0.0){
				
				pervious_total = studFullYearMark.get(i).getTotal_mark();
				
				pervious_rank = 1;
				
				studFullYearMark.get(i).setStudent_rank(pervious_rank);
				
			} else if(pervious_total != 0.0 && studFullYearMark.get(i).getTotal_mark() == pervious_total){
				
				pervious_total = studFullYearMark.get(i).getTotal_mark();
				
				studFullYearMark.get(i).setStudent_rank(pervious_rank);
				
				same_rank_counter++;
				
			} else {
				
				pervious_total = studFullYearMark.get(i).getTotal_mark();
				
				pervious_rank = pervious_rank + same_rank_counter + 1;
				
				studFullYearMark.get(i).setStudent_rank(pervious_rank);
				
				same_rank_counter = 0;
			}
		}
		
		ModelAndView modelandview = new ModelAndView("ExamRslt_Registration/certificate_view/full_year_certificate/full_year_exam_result_list");

		modelandview.addObject("studFullYearMark", studFullYearMark);
		
		return modelandview;
	}
}
