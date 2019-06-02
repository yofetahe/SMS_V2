/**
 * 
 */

/*===================== EXAM RESULT REGISTRATION =====================*/

	/*----- exam result template -----*/
	
	function studentCertificateView(src){		

		document.getElementById("examResultInformationBtn").className = "btn btn-default";
		document.getElementById("examResultRegBtn").className = "btn btn-default";
		document.getElementById("certificateResultViewBtn").className = "btn btn-default active";
		document.getElementById("importFromExcelBtn").className = "btn btn-default";		
		
		$("#examrslt_content_body").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/examresult/studentCertificateView",		
			data : "",
			success : function(response) {
				$('#examrslt_content_body').html(response);				
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function studentExamResultAddForm(src){
		
		document.getElementById("examResultInformationBtn").className = "btn btn-default";
		document.getElementById("examResultRegBtn").className = "btn btn-default active";
		document.getElementById("certificateResultViewBtn").className = "btn btn-default";
		document.getElementById("importFromExcelBtn").className = "btn btn-default";
		
		$("#examrslt_content_body").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/examresult/studentExamResultAddForm",				
			data : "",
			success : function(response) {
				$('#examrslt_content_body').html(response);				
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function importStudentExamResultFromExcel(){
		
		$("#examrslt_displaytype").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "examrsltaction_importStudrsltfromexcel.action",				
			data : "",
			success : function(response) {				
				document.getElementById('rsltAddFromArraw').style.display = "none";
				document.getElementById('rsltListArraw').style.display = "none";				
				document.getElementById('rsltImportFromArraw').style.display = "block";
				$('#examrslt_displaytype').html(response);				
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}

	/*----- subject list page -----*/
	
	function examTypeListForExamResult(subcl_id, src){
		
		var academic_year = $('#ac_year').val();
		var at_id = $('#at_id').val();
		var cl_id = $('#cl_id').val();
		var cd_id = $('#cd_id').val();
		
		$("#examListContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/examresult/examTypeListForExamResult",				
			data : "es_fiscalyear=" + academic_year + "&at_id=" + at_id + "&cl_id=" + cl_id + "&subjectClassRel.subcl_id=" + subcl_id,
			success : function(response) {
				
				document.getElementById('studentExamRegistrationForm').innerHTML = "";
				
				$('#examListContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}

	function getTermCertificateTemplate(src){
		
		document.getElementById("termCertificate").className = "active";
		document.getElementById("fullYearCertificate").className = "";
		
		$("#certificate_rslt_content").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/examresult/getTermCertificateTemplate",				
			data : "",
			success : function(response) {
				$('#certificate_rslt_content').html(response);		
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- grade detail list page -----*/
	
	function subjectListForExamResult(cd_id, src){
		
		var at_id = $('#at_id').val();
		var cl_id = $('#cl_id').val();
		
		$("#subjectListContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/examresult/subjectListForExamResult",				
			data : "at_id=" + at_id + "&examSubjectRel.subjectClassRel.cl_id=" + cl_id + "&cd_id=" + cd_id,
			success : function(response) {
										
				document.getElementById('examListContent').innerHTML = "<div class=\"form-group form-inline\"><select id=\"et_id\" class=\"form-control\" style=\"width: 160px;\">"+
																"<option>-Exam Type-</option></select></div>";
				document.getElementById('studentExamRegistrationForm').innerHTML = "";	
				
				$('#subjectListContent').html(response);				
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	} 
	
	/*----- examrslt student rslt list page -----*/
	
	function getStudentResultDetail(src, si_id, rank){
		
		var academic_year = $("#academic_year").val();
		var at_id = $("#at_id").val();
		var cl_id = $('#cl_id').val();
		var cd_id = $('#cd_id').val();
		
		$("#studPerGrade").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/examresult/getStudentResultDetail",				
			data : "si_id=" + si_id + "&studentRegistration.clcdRelation.cl_id=" + cl_id + "&studentRegistration.clcdRelation.cd_id=" + cd_id + "&fiscal_year=" + academic_year + "&at_id=" + at_id + "&stud_rank=" + rank,
			success : function(response) {
				$('#studPerGrade').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
		
	}
	
	function getTermReportCardFormat(src, si_id, at_id, cl_id, cd_id, rank, academic_year){
		
		$("#studPerGrade").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/examresult/getTermReportCardFormat",				
			data : "si_id=" + si_id + "&studentRegistration.clcdRelation.cl_id=" + cl_id + "&studentRegistration.clcdRelation.cd_id=" + cd_id + "&fiscal_year=" + academic_year + "&at_id=" + at_id + "&stud_rank=" + rank,
			success : function(response) {
				$('#studPerGrade').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getTeachersCertificateCommentAddForm(src, si_id, at_id, cl_id, cd_id){
		
		var academic_year = $("#academic_year").val();
		
		$("#studentMarkList").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/examresult/getTeachersCertificateCommentAddForm",				
			data : "si_id=" + si_id + "&studentRegistration.clcdRelation.cl_id=" + cl_id + "&studentRegistration.clcdRelation.cd_id=" + cd_id + "&fiscal_year=" + academic_year + "&at_id=" + at_id,
			success : function(response) {
				$('#studentMarkList').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getTeachersCertificateCommentEditForm(src, si_id, at_id, cl_id, cd_id){
		
		var academic_year = $("#academic_year").val();
		
		$("#studentMarkList").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/examresult/getTeachersCertificateCommentEditForm",				
			data : "si_id=" + si_id + "&studentRegistration.clcdRelation.cl_id=" + cl_id + "&studentRegistration.clcdRelation.cd_id=" + cd_id + "&fiscal_year=" + academic_year + "&at_id=" + at_id,
			success : function(response) {
				$('#studentMarkList').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- examrslt student rslt decision page -----*/
	
	function saveStudentFinalResultStatus(cl_id, cd_id, academic_year){
		
		var check = 0;
		
		var ac_year = $("#academicYear").val();
		
		var pass_rank_from = $("#pass_rank_from").val();
		var pass_rank_to = $("#pass_rank_to").val();
		var pass_decision_type = $("#pass_decision_type").val();
		
//		var fail_rank_from = $("#fail_rank_from").val();
//		var fail_rank_to = $("#fail_rank_to").val();
//		var fail_decision_type = $("#fail_decision_type").val();
		
		if(pass_rank_from == ""){
			
			documnet.getElementById("errorMessage").innerHTML = "Pass student average from is required";
			
		} else if(pass_rank_to == ""){
			
			documnet.getElementById("errorMessage").innerHTML = "Pass student average to is required";
			
		} else if(Number(pass_rank_from) == Number(pass_rank_to)){
			
			documnet.getElementById("errorMessage").innerHTML = "Rank from and Rank to can't be equal.";
		}
//		else if(fail_rank_from == ""){
//			
//			documnet.getElementById("errorMessage").innerHTML = "Fail student average from is required";
//			
//		} else if(fail_rank_to == ""){
//			
//			documnet.getElementById("errorMessage").innerHTML = "Fail student average to is required";
//			
//		} else if((Number(pass_rank_from)>= Number(fail_rank_from)) && (Number(pass_rank_to)<= Number(fail_rank_from)) || (Number(pass_rank_from)<= Number(fail_rank_from)) && (Number(pass_rank_to)>= Number(fail_rank_from))){
//			
//			documnet.getElementById("errorMessage").innerHTML = "Pass average gap and fail average from overlap";
//			
//		} else if((Number(pass_rank_from)>= Number(fail_rank_to)) && (Number(pass_rank_to)<= Number(fail_rank_to)) || (Number(pass_rank_from)<= Number(fail_rank_to)) && (Number(pass_rank_to)>= Number(fail_rank_to))){
//			
//			documnet.getElementById("errorMessage").innerHTML = "Pass average gap and fail average to overlap";
//			
//		} 
		else {
			
			$("#exam_studlist").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				async: false,
				url : "examrsltaction_saveStudentFinalResultStatus.action",				
				data : "studRslt_status=Passed&rank_from=" + pass_rank_from + "&rank_to=" + pass_rank_to + "&academic_year=" + ac_year + "&cl_id=" + cl_id + "&cd_id=" + cd_id,
				success : function(response) {
					$('#exam_studlist').html(response);
					//check = 1;
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
		
//		if(check == 1){
//			//alert("studRslt_status=" + fail_decision_type + "&rank_from=" + fail_rank_from + "&rank_to=" + fail_rank_to + "&academic_year=" + ac_year + "&cl_id=" + cl_id + "&cd_id=" + cd_id);
//			$("#exam_studlist").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
//			$.ajax({
//				type : "POST",
//				//async: false,
//				url : "examrsltaction_saveStudentFinalResultStatus.action",				
//				data : "studRslt_status=" + fail_decision_type + "&rank_from=" + fail_rank_from + "&rank_to=" + fail_rank_to + "&academic_year=" + ac_year + "&cl_id=" + cl_id + "&cd_id=" + cd_id,
//				success : function(response) {
//					$('#exam_studlist').html(response);
//				},
//				error : function(e) {
//					alert('Error: ' + e);
//				}
//			});
//		}
		
		
	}
	
	function updateStudentFinalResultStatus(cl_id, cd_id, academic_year){
		
		var check = 0;
		
		var ac_year = $("#academicYear").val();
		
		var pass_rank_from = $("#pass_rank_from").val();
		var pass_rank_to = $("#pass_rank_to").val();
		var pass_decision_type = $("#pass_decision_type").val();
		
		var fail_rank_from = $("#fail_rank_from").val();
		var fail_rank_to = $("#fail_rank_to").val();
		var fail_decision_type = $("#fail_decision_type").val();
		
		if(pass_rank_from == ""){
			
			documnet.getElementById("errorMessage").innerHTML = "Pass student average from is required";
			
		} else if(pass_rank_to == ""){
			
			documnet.getElementById("errorMessage").innerHTML = "Pass student average to is required";
			
		} else if(fail_rank_from == ""){
			
			documnet.getElementById("errorMessage").innerHTML = "Fail student average from is required";
			
		} else if(fail_rank_to == ""){
			
			documnet.getElementById("errorMessage").innerHTML = "Fail student average to is required";
			
		} else if((Number(pass_rank_from)>= Number(fail_rank_from)) && (Number(pass_rank_to)<= Number(fail_rank_from)) || (Number(pass_rank_from)<= Number(fail_rank_from)) && (Number(pass_rank_to)>= Number(fail_rank_from))){
			
			documnet.getElementById("errorMessage").innerHTML = "Pass average gap and fail average from overlap";
			
		} else if((Number(pass_rank_from)>= Number(fail_rank_to)) && (Number(pass_rank_to)<= Number(fail_rank_to)) || (Number(pass_rank_from)<= Number(fail_rank_to)) && (Number(pass_rank_to)>= Number(fail_rank_to))){
			
			documnet.getElementById("errorMessage").innerHTML = "Pass average gap and fail average to overlap";
			
		} else {
			//alert("studRslt_status=" + pass_decision_type + "&rank_from=" + pass_rank_from + "&rank_to=" + pass_rank_to + "&academic_year=" + ac_year + "&cl_id=" + cl_id + "&cd_id=" + cd_id);
			$("#exam_studlist").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				async: false,
				url : "examrsltaction_updateStudentFinalResultStatus.action",				
				data : "studRslt_status=" + pass_decision_type + "&rank_from=" + pass_rank_from + "&rank_to=" + pass_rank_to + "&academic_year=" + ac_year + "&cl_id=" + cl_id + "&cd_id=" + cd_id,
				success : function(response) {
					//$('#exam_studlist').html(response);
					//check = 1;
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
			
			$("#exam_studlist").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				async: false,
				url : "examrsltaction_updateStudentFinalResultStatus.action",				
				data : "studRslt_status=" + fail_decision_type + "&rank_from=" + fail_rank_from + "&rank_to=" + fail_rank_to + "&academic_year=" + ac_year + "&cl_id=" + cl_id + "&cd_id=" + cd_id,
				success : function(response) {
					$('#exam_studlist').html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});			
		}		
	}
	
	/*----- examrslt per subject detail page -----*/
	
	function getSubjectResultPerExamDetail(src, cl_id, si_id, sub_id, exsub_id){
		
		var academic_year = $("#academic_year").val();
		var at_id = $("#at_id").val();
				
		$("#subject_detail").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/examresult/getSubjectResultPerExamDetail",				
			data : "studentRegistration.clcdRelation.cl_id=" + cl_id + "&si_id=" + si_id + "&examSubjectRel.subjectClassRel.sub_id=" + sub_id + "&fiscal_year=" + academic_year + "&at_id=" + at_id + "&examsub_id=" + exsub_id,
			success : function(response) {
				$('#subject_detail').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- examrslt per subject detail detail page -----*/
	
	function editSubRslt(er_id, rslt, maxRslt){
		
		$("#rsltEditForm").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "examrsltaction_editform.action",				
			data : "er_id=" + er_id + "&result=" + rslt + "&total_mark=" + maxRslt + "&pageFlag=2",
			success : function(response) {
				$('#rsltEditForm').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- examrslt list page -----*/
	
	function subStudRsltList(cl_id){
		
		$("#studRsltList").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "examrsltaction_clsublist_srslt.action",				
			data : "cl_id=" + cl_id,
			success : function(response) {
				document.getElementById('studRsltList').innerHTML = "";
				document.getElementById('sList').innerHTML = "";
				$('#studRsltList').html(response);				
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	var prev_clid = null;
	function examrslt_gradeSelected(cl_id, cl_name){
		
		var ac_year = $("#academicYear").val();
		var semisterList = $("#semisterList").val();
		var certOnOff = $("#certOnOff").val();
		
		if(semisterList == 0 && certOnOff == 0){
			document.getElementById("errMsg").innerHTML = "Please select semister or check the certificate.";
		} else if(semisterList != 0 && certOnOff == 1){
			document.getElementById("errMsg").innerHTML = "Please select either semister or certificate.";
		} else {
			document.getElementById("errMsg").innerHTML = "";
			$("#studRsltList").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "examrsltaction_pergradelist.action",				
				data : "cl_id=" + cl_id + "&cl_name=" + cl_name + "&academic_year=" + ac_year + "&at_id=" + semisterList,
				success : function(response) {
					if(prev_clid == null){
						document.getElementById(cl_id).style.backgroundColor = '#e5e5e5';
						document.getElementById(cl_id).style.color = '#3d6e9f';
					} else {
						document.getElementById(prev_clid).style.backgroundColor = '';
						document.getElementById(prev_clid).style.color = '#000000';
						document.getElementById(cl_id).style.backgroundColor = '#e5e5e5';
						document.getElementById(cl_id).style.color = '#3d6e9f';
					}
					$('#studRsltList').html(response);
					prev_clid = cl_id;
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
	}
	
	function filterAnnualTermList(ac_year){
		
		$("#semList").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "examrsltaction_semisterlist.action",				
			data : "academic_year=" + ac_year,
			success : function(response) {
				document.getElementById("semList").innerHTML = response;
				//$('#semisterList').html(response);				
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function refreshStudentMarkList(src){
		
		$("#classListContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/examresult/getClassListForExamResult",				
			data : "",
			success : function(response) {
				document.getElementById("studentExamRegistrationForm").innerHTML = "";
//				document.getElementById("ck_box").innerHTML = "<img alt=\"\" src=\"images/check_box.png\" style=\"width: 20px;\" onclick=\"onCertificateResult()\"> ";
//				document.getElementById("certOnOff").value = "0"				
				$('#classListContent').html(response);				
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function onCertificateResult(){
		
		document.getElementById("ck_box").innerHTML = "<img alt=\"\" src=\"images/checked.png\" style=\"width: 20px;\" onclick=\"offCertificateResult()\"> ";
		document.getElementById("certOnOff").value = "1"
		
		$("#clLIst").html("<img align=\"center\" src=\"images/30.GIF\"/>");
		$.ajax({
			type : "POST",
			url : "examrsltaction_classlist_srslt.action",				
			data : "",
			success : function(response) {
				document.getElementById("studRsltList").innerHTML = "";
				$('#clLIst').html(response);				
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function offCertificateResult(){
		
		document.getElementById("ck_box").innerHTML = "<img alt=\"\" src=\"images/check_box.png\" style=\"width: 20px;\" onclick=\"onCertificateResult()\"> ";
		document.getElementById("certOnOff").value = "0"
		document.getElementById("clLIst").innerHTML = "";
		document.getElementById("studRsltList").innerHTML = "";
	}
	
	/*----- examrslt list per grade -----*/
	
	var prev_cdid = null;
	function studentExamResultListPerClassDetail(src){
		
		document.getElementById("academic_year").style.borderColor = "#e5e5e5";
		document.getElementById("at_id").style.borderColor = "#e5e5e5";
		document.getElementById("cl_id").style.borderColor = "#e5e5e5";
		document.getElementById("cd_id").style.borderColor = "#e5e5e5";
		
		var academic_year = $("#academic_year").val();
		var at_id = $("#at_id").val();
		var cl_id = $("#cl_id").val();
		var cd_id = $("#cd_id").val();
		
		var counter = 0;
		
		if(academic_year == "0"){
			
			document.getElementById("academic_year").style.borderColor = "#ff0000";
			counter++;
		}
		if(at_id == "0"){
			
			document.getElementById("at_id").style.borderColor = "#ff0000";
			counter++;
		}
		if(cl_id == "0"){
			
			document.getElementById("cl_id").style.borderColor = "#ff0000";
			counter++;
		}
		if(cd_id == "0"){
			
			document.getElementById("cd_id").style.borderColor = "#ff0000";
			counter++;
		}		
		
		if(counter == 0){
			
			$("#student_result_content").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
			$.ajax({
				type : "GET",
				url : "/SMS/examresult/studentExamResultListPerClassDetail",				
				data : "studentRegistration.clcdRelation.cl_id=" + cl_id + "&studentRegistration.clcdRelation.cd_id=" + cd_id + "&fiscal_year=" + academic_year + "&at_id=" + at_id,
				success : function(response) {				
					$('#student_result_content').html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
		
		
//			$("#exam_studlist").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
//			$.ajax({
//				type : "POST",
//				url : "examrsltaction_classdetailfullyear.action",				
//				data : "cl_id=" + cl_id + "&cd_id=" + cd_id + "&cl_name=" + cl_name + "&cd_name=" + cd_name + "&academic_year=" + ac_year + "&at_id=" + semisterList,
//				success : function(response) {
//					if(prev_cdid == null){
//						document.getElementById(cd_id+"_cd").style.color = "#ffffff";
//						document.getElementById(cd_id+"_cd").style.backgroundColor = "#3d6e9f";
//					} else {
//						document.getElementById(prev_cdid+"_cd").style.backgroundColor = '#e5e5e5';
//						document.getElementById(prev_cdid+"_cd").style.color = '#3d6e9f';
//						document.getElementById(cd_id+"_cd").style.backgroundColor = '#3d6e9f';
//						document.getElementById(cd_id+"_cd").style.color = '#ffffff';
//					}
//					$('#exam_studlist').html(response);
//					prev_cdid = cd_id;
//				},
//				error : function(e) {
//					alert('Error: ' + e);
//				}
//			});
			
	}
	
	/*----- examrslt full year page -----*/
	
	function SaveFinalStudentAnnualRsltDecision(si_id, rslt_status, cl_id, cl_name, cd_id, cd_name){
		
		if(rslt_status == "---"){
			rslt_status = "Active";
		}
		
		var ac_year = $("#academicYear").val();
		$("#exam_studlist").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "examrsltaction_finalrsltdecision.action",				
			data : "si_id=" + si_id + "&studRslt_status=" + rslt_status + "&cl_id=" + cl_id + "&cd_id=" + cd_id + "&cl_name=" + cl_name + "&cd_name=" + cd_name + "&academic_year=" + ac_year,
			success : function(response) {
				$('#exam_studlist').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function certificateResult(si_id, cl_id, cl_name, cd_id, cd_name, fname, mname, gname, year_avg_rank){
		
		var ac_year = $("#academicYear").val();
		
		$("#certView").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "examrsltaction_certificateview.action",				
			data : "si_id=" + si_id + "&cl_id=" + cl_id + "&cd_id=" + cd_id + "&cl_name=" + cl_name + "&cd_name=" + cd_name + "&academic_year=" + ac_year + "&fname=" + fname + "&mname=" + mname + "&gname=" + gname + "&year_avg_rank=" + year_avg_rank,
			success : function(response) {
				$('#certView').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function certificateResultCoverPage(si_id, cl_id, cl_name, cd_id, cd_name, fname, mname, gname, year_avg_rank){
		
		var ac_year = $("#academicYear").val();
		
		$("#certView").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "examrsltaction_certificateview_coverpage.action",
			data : "si_id=" + si_id + "&cl_id=" + cl_id + "&cd_id=" + cd_id + "&cl_name=" + cl_name + "&cd_name=" + cd_name + "&academic_year=" + ac_year + "&fname=" + fname + "&mname=" + mname + "&gname=" + gname + "&year_avg_rank=" + year_avg_rank,
			success : function(response) {
				$('#certView').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function generalStudentResultDecision(cl_id, cd_id, cl_name, cd_name){
		
		var ac_year = $("#academicYear").val();
		
		$("#certView").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "examrsltaction_generalStudentResultDecision.action",				
			data : "cl_id=" + cl_id + "&cd_id=" + cd_id + "&cl_name=" + cl_name + "&cd_name=" + cd_name + "&academic_year=" + ac_year,
			success : function(response) {
				$('#certView').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function generateAllStudentFullYearCertificate(cl_id, cd_id, cl_name, cd_name){
		
		var ac_year = $("#academicYear").val();
		
		$("#certView").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "examrsltaction_certificateview_forall_PDF.action",				
			data : "cl_id=" + cl_id + "&cd_id=" + cd_id + "&cl_name=" + cl_name + "&cd_name=" + cd_name + "&academic_year=" + ac_year,
			success : function(response) {
				$('#certView').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function generateAllStudentFullYearCertificateCover(cl_id, cd_id, cl_name, cd_name){
		
		var ac_year = $("#academicYear").val();
		
		$("#certView").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "examrsltaction_certificate_cover_forall_PDF.action",				
			data : "cl_id=" + cl_id + "&cd_id=" + cd_id + "&cl_name=" + cl_name + "&cd_name=" + cd_name + "&academic_year=" + ac_year,
			success : function(response) {
				$('#certView').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- examrslt edit page -----*/
	
	function updateResult(er_id, total_mark, cl_id, exsub_id, cd_id, at_id, pageFlag){
		
		var result = $('#rslt').val();
		var ac_year = $("#academicYear").val();
		
		if(result == ""){
			document.getElementById("resultErrorMsg").innerHTML = "Result is blank.";
		} else if(result - total_mark > 0){
			document.getElementById("resultErrorMsg").innerHTML = "The result is beyond the boundery.";
		}else {
		
			$("#rsltEditForm").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "examrsltaction_updateresult.action",				
				data : "er_id=" + er_id + "&result=" + result + "&at_id=" + at_id + "&cl_id=" + cl_id + "&exsub_id=" + exsub_id + "&cd_id=" + cd_id + "&pageFlag=" + pageFlag + "&academic_year=" + ac_year,
				success : function(response) {
					$('#rsltEditForm').html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
			
		}
	}
	
	/*----- examrslt create page -----*/
	
	//rawcount increases every time when the result added. 
	//and then the count will compare with the total raw student list (rwcount)
	//it helps to control whether there is unfilled result or not.
	var rawcount = 0;
	
	function checkStudExamRslt(rslt, si_id, exsub_id, indx, total_mark){
		
		var semister = $('#at_id').val();
		var ac_year = $('#ac_year').val();		
		var r = rslt - total_mark;
		
		if(semister == 0){
			document.getElementById('rsltError').innerHTML = "* Please select which semister result it is.";
			document.getElementById('rslt_' + indx).innerHTML = "";
		} else if(rslt == ""){
			document.getElementById('rsltFrm_' + indx).style.display = "block";
			document.getElementById('rslt_' + indx).style.display = "block";
			document.getElementById('strslt_' + indx).style.display = "none";
		} else if(r > 0){
			document.getElementById('strslt_' + indx).innerHTML = "<div style=\"color:RED\">Invalid result</div>";
			document.getElementById('rslt_' + indx).innerHTML = "";
		} else {
			studExamRslt(rslt, si_id, exsub_id, indx, total_mark, ac_year, semister);
		}
	}
	
 	var studMark = new Array();

	function studExamRslt(exrslt, si_id, exsub_id, indx, total_mark, ac_year, semister){
		
		var size = studMark.length;
		
		studMark[size] = new Array(si_id, exsub_id, exrslt, semister);
		
		document.getElementById('rsltFrm_' + indx).style.display = "none";
		document.getElementById('strslt_'+ indx).style.display = "block";
		$('#strslt_'+ indx).html("<table width=\"100%\"><tr><td width=\"80%\" style=\"padding-left: 60px;\">" + exrslt + " </td><td> <div style=\"color: RED; padding-left: 10px; cursor: pointer;\" onclick=\"removeMark(" + si_id + ", " + exsub_id + ", " + indx + ")\">  X </div> </td></tr></table>");
		
// 		rawcount++;
// 		$.ajax({
// 			type : "POST",
// 			url : "examrsltaction_addstudrslt.action",				
// 			data : "si_id=" + si_id + "&exsub_id=" + exsub_id + "&result=" + exrslt + "&rwindex=" + indx + "&total_mark=" + total_mark + "&academic_year=" + ac_year + "&at_id=" + semister,
// 			success : function(response) {
// 				document.getElementById('rsltFrm_' + indx).style.display = "none";
// 				document.getElementById('strslt_'+ indx).style.display = "block";
// 				$('#strslt_'+ indx).html("<table width=\"100%\"><tr><td width=\"80%\" style=\"padding-left: 60px;\">" + exrslt + " </td><td> <div style=\"color: RED; padding-left: 10px; cursor: pointer;\" onclick=\"removeMark(" + si_id + ", " + exsub_id + ", " + indx + ")\">  X </div> </td></tr></table>");
// 			},
// 			error : function(e) {
// 				alert('Error: ' + e);
// 			}
// 		});
	}
	
	function removeMark(si_id, exsub_id, indx){
		
		var count = 0;
		for(var i = 0; i < studMark.length; i++){
			
			for(var j = 0; j < studMark[i].length; j++){
				
				if(studMark[i][j] == si_id){
					
					count++;
				}
			}
			
			if(count > 0){
				studMark.splice(i, 1);
				document.getElementById('rsltFrm_' + indx).style.display = "block";
 				document.getElementById('strslt_' + indx).style.display = "none";
				count = 0;
			}
		}
		
// 		$.ajax({
// 			type : "POST",
// 			url : "examrsltaction_removeexamrslt.action",				
// 			data : "si_id=" + si_id + "&exsub_id=" + exsub_id,
// 			success : function(response) {
// 				document.getElementById('rsltFrm_' + indx).style.display = "block";
// 				document.getElementById('strslt_' + indx).style.display = "none";
// 				//$('#strslt_'+ indx).html("<table width=\"100%\"><tr><td width=\"80%\" style=\"padding-left: 60px;\">" + exrslt + " </td><td> <div style=\"color: RED; padding-left: 10px; cursor: pointer;\" onclick=\"removeMark(" + si_id + ", " + exsub_id + ")\">  X </div> </td></tr></table>");
// 			},
// 			error : function(e) {
// 				alert('Error: ' + e);
// 			}
// 		});
	}

	function saveExamRslt(cl_id, rwcount, exsub_id){
		
		var at_id = $('#at_id').val();
		
// 		if(rwcount != rawcount){
// 			document.getElementById('rsltError').innerHTML = "* Please check, there is unfilled result.";			
// 		} else {
		
			$("#studrsltFrm").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "examrsltaction_savestudrslt.action",				
				data : "cl_id=" + cl_id + "&exsub_id=" + exsub_id + "&at_id=" + at_id + "&studMarkList=" + studMark,
				success : function(response) {
					studMark = new Array();
					$('#studrsltFrm').html(response);
				},
				error : function(e) {
					alert('Error : ' + e);
				}
			});
//		}
	}
	
	function refreshExamCreateFrm(exsub_id, cl_id, subcl_id){
		
		var ac_year = $('#ac_year').val();
		
		$("#examrsltcreatetable").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "examrsltaction_refreshcreatetable.action",				
			data : "exsub_id=" + exsub_id + "&cl_id=" + cl_id + "&subcl_id=" + subcl_id + "&academic_year=" + ac_year,
			success : function(response) {
				$('#examrsltcreatetable').html(response);
				document.getElementById("rsltError").innerHTML = "";
			},
			error : function(e) {
				alert('Error : ' + e);
			}
		});
	}
	
	function getStudentSubjectMarkEditForm(src, er_id, si_id){
		
		var at_id = $('#at_id').val();
		
		$("#rsltEditForm").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/examresult/getStudentSubjectMarkEditForm",				
			data : "er_id=" + er_id + "&si_id=" + si_id + "&at_id=" + at_id,
			success : function(response) {
				$('#rsltEditForm').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});		
	}
	
	function studListPerGradeDetail(cd_id, cl_id, exsub_id){
		
		$("#studListPerGrDetail").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "examrsltaction_studlistpergradedetail.action",				
			data : "cd_id=" + cd_id + "&cl_id=" + cl_id + "&exsub_id=" + exsub_id,
			success : function(response) {
				$('#studListPerGrDetail').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});	
	}
	
	/*----- examrslt add form page -----*/
	
	function classRoomList(at_id){
		
		$("#classList").html("<img align=\"center\" src=\"images/30.GIF\"/>");
		$.ajax({
			type : "POST",
			url : "examrsltaction_classlist.action",				
			data : "at_id=" + at_id,
			success : function(response) {
				
				document.getElementById('classList').innerHTML = "";
				document.getElementById('grdList').innerHTML = "";
				document.getElementById('subList').innerHTML = "";
				document.getElementById('examList').innerHTML = "";
				document.getElementById('studList').innerHTML = "";
				
				$('#classList').html(response);				
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- examrslt list page -----*/
	
	function getStudentExamResultRegistration(exsub_id, src){
		
		var at_id = $('#at_id').val();
		var cl_id = $('#cl_id').val();
		var cd_id = $('#cd_id').val();
		var subcl_id = $('#subcl_id').val();
		var ac_year = $('#ac_year').val();
		
		$("#studentExamRegistrationForm").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/examresult/getStudentExamResultRegistration",				
			data : "at_id=" + at_id + "&studentRegistration.clcdRelation.cl_id=" + cl_id + "&studentRegistration.clcdRelation.cd_id=" + cd_id + "&examsub_id=" + exsub_id + "&fiscal_year=" + ac_year,
			success : function(response) {
				$('#studentExamRegistrationForm').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- class list page -----*/
	
	function gradeDetailListForExamResult(cl_id, src){
		
		var at_id = $('#at_id').val();
		
		$("#gradeDetailListContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/examresult/gradeDetailListForExamResult",				
			data : "at_id=" + at_id + "&examSubjectRel.subjectClassRel.cl_id=" + cl_id,
			success : function(response) {
				
				document.getElementById('subjectListContent').innerHTML = "<div class=\"form-group form-inline\"><select id=\"sub_id\" class=\"form-control\" style=\"width: 160px;\">"+
								"<option>-Subject-</option></select></div>";
				document.getElementById('examListContent').innerHTML = "<div class=\"form-group form-inline\"><select id=\"et_id\" class=\"form-control\" style=\"width: 160px;\">"+
								"<option>-Exam Type-</option></select></div>";
				document.getElementById('studentExamRegistrationForm').innerHTML = "";
				
				$('#gradeDetailListContent').html(response);				
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- class list 2 page -----*/
	
	function getClassDetailListByClassId(cl_id, src){
		
		$("#classDetailListCertificate").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/examresult/getClassDetailListByClassId",
			data : "studentRegistration.clcdRelation.cl_id=" + cl_id,
			success : function(response) {
				$('#classDetailListCertificate').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});		
	}
	
	/*============= TEACHERS COMMENT =============*/
	
	/*----- teachers comment edit -----*/
	
	function updateTeachersComment(si_id, cl_id, cd_id, at_id, ac_year, erc_id){
		
		var tchrcomm = $('#tchrcomm').val();
		
		if(tchrcomm == ""){
			document.getElementById("comErrMsg").innerHTML = "Comment must be given";
		} else {
		
			$("#studPerGrade").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "examrsltaction_updateteachercomment.action",				
				data : "si_id=" + si_id + "&cl_id=" + cl_id + "&cd_id=" + cd_id + "&academic_year=" + ac_year + "&at_id=" + at_id + "&erc_content=" + tchrcomm + "&erc_id=" + erc_id,
				success : function(response) {
					document.getElementById("errMsg").innerHTML = "";
					$('#studPerGrade').html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
	}
	
	/*----- teachers comment create page -----*/
	
	function saveTeachersComment(si_id, cl_id, cd_id, at_id, ac_year){
		
		var tchrcomm = $('#tchrcomm').val();
		
		if(tchrcomm == ""){
			document.getElementById("comErrMsg").innerHTML = "Comment must be given";
		} else {
		
			$("#studPerGrade").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "examrsltaction_saveteachercomment.action",				
				data : "si_id=" + si_id + "&cl_id=" + cl_id + "&cd_id=" + cd_id + "&academic_year=" + ac_year + "&at_id=" + at_id + "&teacher_comment=" + tchrcomm,
				success : function(response) {
					document.getElementById("errMsg").innerHTML = "";
					$('#studPerGrade').html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
	}
	
	/*==================== IMPORT RESULT FROM EXCEL ==========================*/
	
	/*----- IMPORT FROM EXCEL TEMPLATE -----*/
	
	function classRoomListForImportFromExcel(at_id){
		
		$("#classList").html("<img align=\"center\" src=\"images/30.GIF\"/>");
		$.ajax({
			type : "POST",
			url : "examrsltaction_importclasslist.action",				
			data : "at_id=" + at_id,
			success : function(response) {
				
				document.getElementById('classList').innerHTML = "";
				document.getElementById('grdList').innerHTML = "";
				document.getElementById('subList').innerHTML = "";
				document.getElementById("impType").style.display = "none";
				document.getElementById("colNumTbl").style.display = "none";
				document.getElementById("examList").style.display = "none";
								
				$('#classList').html(response);				
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	var impType = -1;
	var subclid = -1;
	function checkImportType(importType){
		
		impType = importType;
		
		if(impType == 2){			
			document.getElementById("colNumTbl").style.display = "block";
			document.getElementById("examList").style.display = "block";
			getExamList();
		}
		if(impType == 1){
			document.getElementById("colNumTbl").style.display = "none";
			document.getElementById("examList").style.display = "none";
		}
		if(impType == 3){
			document.getElementById("colNumTbl").style.display = "block";
		}
	}
	
	function getExamList(){
		var at_id = $('#at_id').val();
		var cl_id = $('#cl_id').val();
		var cd_id = $('#cd_id').val();
		
		$("#examList").html("<img align=\"center\" src=\"images/30.GIF\"/>");
		$.ajax({
			type : "POST",
			url : "examrsltaction_importclsubexamlist.action",				
			data : "at_id=" + at_id + "&cl_id=" + cl_id + "&cd_id=" + cd_id + "&subcl_id=" + subclid,
			success : function(response) {
								
				$('#examList').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function examListForImportFromExcel(subcl_id){
		
		subclid = subcl_id;
		
		document.getElementById("impType").style.display = "none";
		document.getElementById("colNumTbl").style.display = "none";
		document.getElementById("examList").style.display = "none";
		
		document.getElementById("impType").style.display = "block";
		document.getElementById("importType").checked = false;
	}
	
	function importExamResultFromExcel(){
		
		var file_path = $('#file_path').val();
		var at_id = $('#at_id').val();
		var cl_id = $('#cl_id').val();
		var cd_id = $('#cd_id').val();
		var subcl_id = $('#subcl_id').val();
		var row_num = $('#rowNum').val();
		var sheet_num = $('#sheetNum').val();
		
		if(file_path == ""){
			document.getElementById("errMsg").innerHTML = "File paht is required.";
		} else if(at_id == 0){
			document.getElementById("errMsg").innerHTML = "Quarter is required.";	
		} else if(cl_id == 0){
			document.getElementById("errMsg").innerHTML = "Class is required.";
		} else if(cd_id == 0){
			document.getElementById("errMsg").innerHTML = "Class detail is required.";
		} else if(subcl_id == 0){
			document.getElementById("errMsg").innerHTML = "Subject is required.";
		} else if(impType == -1){			
			document.getElementById("errMsg").innerHTML = "Please select the import type you prefer.";
		} else if(sheet_num == ""){			
			document.getElementById("errMsg").innerHTML = "Sheet number is required";
		} else if(row_num == ""){			
			document.getElementById("errMsg").innerHTML = "Row From - To is required";
		} else if(impType == 1){		
			 
			$("#importAll").html("<div width=\"100%\" align=\"center\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "examrsltaction_importstudmarkfromexcelfile.action",				
				data : "at_id=" + at_id + "&cl_id=" + cl_id + "&cd_id=" + cd_id + "&subcl_id=" + subcl_id + "&file_path=" + file_path + "&row_num=" + row_num + "&sheet_num=" + sheet_num,
				success : function(response) {
					$('#importAll').html(response);				
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});			
		
		} else if(impType == 2){
			var colNum = $('#columnNum').val();
			var exsub_id = $('#exsub_id').val();
			
			if(colNum == ""){
				document.getElementById("errMsg").innerHTML = "Column Number is required.";
			} else if(exsub_id == 0){
				document.getElementById("errMsg").innerHTML = "Exam Type is required.";
			} else {
				
				$("#importAll").html("<div width=\"100%\" align=\"center\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
				$.ajax({
					type : "POST",
					url : "examrsltaction_importSpecificstudmarkfromexcelfile.action",				
					data : "at_id=" + at_id + "&cl_id=" + cl_id + "&cd_id=" + cd_id + "&subcl_id=" + subcl_id + "&file_path=" + file_path + "&column_num=" + colNum + "&exsub_id=" + exsub_id + "&subcl_id=" + subcl_id + "&row_num=" + row_num + "&sheet_num=" + sheet_num,
					success : function(response) {
						$('#importAll').html(response);				
					},
					error : function(e) {
						alert('Error: ' + e);
					}
				});	
				
			}
		} else if(impType == 3){
			var colNum = $('#columnNum').val();
			
			if(colNum == ""){
				document.getElementById("errMsg").innerHTML = "Column Number is required.";
			} else {
				
				$("#importAll").html("<div width=\"100%\" align=\"center\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
				$.ajax({
					type : "POST",
					url : "examrsltaction_importMultipleColStudMarkFromExcelFile.action",				
					data : "at_id=" + at_id + "&cl_id=" + cl_id + "&cd_id=" + cd_id + "&subcl_id=" + subcl_id + "&file_path=" + file_path + "&column_num=" + colNum + "&subcl_id=" + subcl_id + "&row_num=" + row_num + "&sheet_num=" + sheet_num,
					success : function(response) {
						$('#importAll').html(response);				
					},
					error : function(e) {
						alert('Error: ' + e);
					}
				});	
				
			}
		}
	}
	
	function updateExamResultFromExcel(){
		
		var file_path = $('#file_path').val();
		var at_id = $('#at_id').val();
		var cl_id = $('#cl_id').val();
		var cd_id = $('#cd_id').val();
		var subcl_id = $('#subcl_id').val();
		var row_num = $('#rowNum').val();
		var sheet_num = $('#sheetNum').val();
		
		if(file_path == ""){
			document.getElementById("errMsg").innerHTML = "File paht is required.";
		} else if(at_id == 0){
			document.getElementById("errMsg").innerHTML = "Quarter is required.";	
		} else if(cl_id == 0){
			document.getElementById("errMsg").innerHTML = "Class is required.";
		} else if(cd_id == 0){
			document.getElementById("errMsg").innerHTML = "Class detail is required.";
		} else if(subcl_id == 0){
			document.getElementById("errMsg").innerHTML = "Subject is required.";
		} else if(impType == -1){			
			document.getElementById("errMsg").innerHTML = "Please select the import type you prefer.";
		} else if(sheet_num == ""){			
			document.getElementById("errMsg").innerHTML = "Sheet number is required";
		} else if(row_num == ""){			
			document.getElementById("errMsg").innerHTML = "Row From - To is required";
		} else if(impType == 1){		
			 
			$("#importAll").html("<div width=\"100%\" align=\"center\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "examrsltaction_updatestudmarkfromexcelfile.action",				
				data : "at_id=" + at_id + "&cl_id=" + cl_id + "&cd_id=" + cd_id + "&subcl_id=" + subcl_id + "&file_path=" + file_path + "&row_num=" + row_num + "&sheet_num=" + sheet_num,
				success : function(response) {
					$('#importAll').html(response);				
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});			
		
		} else if(impType == 2){
			var colNum = $('#columnNum').val();
			var exsub_id = $('#exsub_id').val();
			
			if(colNum == ""){
				document.getElementById("errMsg").innerHTML = "Column Number is required.";
			} else if(exsub_id == 0){
				document.getElementById("errMsg").innerHTML = "Exam Type is required.";
			} else {
				
				$("#importAll").html("<div width=\"100%\" align=\"center\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
				$.ajax({
					type : "POST",
					url : "examrsltaction_updateSpecificstudmarkfromexcelfile.action",				
					data : "at_id=" + at_id + "&cl_id=" + cl_id + "&cd_id=" + cd_id + "&subcl_id=" + subcl_id + "&file_path=" + file_path + "&column_num=" + colNum + "&exsub_id=" + exsub_id + "&subcl_id=" + subcl_id + "&row_num=" + row_num + "&sheet_num=" + sheet_num,
					success : function(response) {
						$('#importAll').html(response);				
					},
					error : function(e) {
						alert('Error: ' + e);
					}
				});	
				
			}
		} else if(impType == 3){
			var colNum = $('#columnNum').val();
			
			if(colNum == ""){
				document.getElementById("errMsg").innerHTML = "Column Number is required.";
			} else {
				
				$("#importAll").html("<div width=\"100%\" align=\"center\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
				$.ajax({
					type : "POST",
					url : "examrsltaction_updateMultipleColStudMarkFromExcelFile.action",				
					data : "at_id=" + at_id + "&cl_id=" + cl_id + "&cd_id=" + cd_id + "&subcl_id=" + subcl_id + "&file_path=" + file_path + "&column_num=" + colNum + "&subcl_id=" + subcl_id + "&row_num=" + row_num + "&sheet_num=" + sheet_num,
					success : function(response) {
						$('#importAll').html(response);				
					},
					error : function(e) {
						alert('Error: ' + e);
					}
				});	
				
			}
		}
	}
	
	function checkStudentNameMarkListFromExcel(){
		
		var file_path = $('#file_path').val();
		var at_id = $('#at_id').val();
		var cl_id = $('#cl_id').val();
		var cd_id = $('#cd_id').val();
		var subcl_id = $('#subcl_id').val();
		var row_num = $('#rowNum').val();
		var sheet_num = $('#sheetNum').val();
		
		if(file_path == ""){
			document.getElementById("errMsg").innerHTML = "File paht is required.";
		} else if(at_id == 0){
			document.getElementById("errMsg").innerHTML = "Quarter is required.";	
		} else if(cl_id == 0){
			document.getElementById("errMsg").innerHTML = "Class is required.";
		} else if(cd_id == 0){
			document.getElementById("errMsg").innerHTML = "Class detail is required.";
		} else if(subcl_id == 0){
			document.getElementById("errMsg").innerHTML = "Subject is required.";
		} else if(impType == -1){			
			document.getElementById("errMsg").innerHTML = "Please select the import type you prefer.";
		} else if(sheet_num == ""){			
			document.getElementById("errMsg").innerHTML = "Sheet number is required";
		} else if(row_num == ""){			
			document.getElementById("errMsg").innerHTML = "Row From - To is required";
		} else {		
			 
			$("#unmatchStudNameList").html("<div width=\"100%\" align=\"center\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "examrsltaction_checkStudetnNamefromExcelFile.action",				
				data : "at_id=" + at_id + "&cl_id=" + cl_id + "&cd_id=" + cd_id + "&subcl_id=" + subcl_id + "&file_path=" + file_path + "&row_num=" + row_num + "&sheet_num=" + sheet_num,
				success : function(response) {
					$('#unmatchStudNameList').html(response);				
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});			
		
		}
	}
	
	/*----- CLASS LIST PAGE -----*/
	
	function gradeDetailListForImportFromExcel(cl_id){
		
		var at_id = $('#at_id').val();
		
		$("#grdList").html("<img align=\"center\" src=\"images/30.GIF\"/>");
		$.ajax({
			type : "POST",
			url : "examrsltaction_importgrdlist.action",				
			data : "at_id=" + at_id + "&cl_id=" + cl_id,
			success : function(response) {
				
				document.getElementById('grdList').innerHTML = "";
				document.getElementById('subList').innerHTML = "";
				document.getElementById("impType").style.display = "none";
				document.getElementById("colNumTbl").style.display = "none";
				document.getElementById("examList").style.display = "none";
				
				$('#grdList').html(response);				
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- GRADE DETAIL LIST PAGE -----*/
	
	function subjectListForImportFromExcel(cd_id){
		
		var at_id = $('#at_id').val();
		var cl_id = $('#cl_id').val();
		
		$("#subList").html("<img align=\"center\" src=\"images/30.GIF\"/>");
		$.ajax({
			type : "POST",
			url : "examrsltaction_importclsublist.action",				
			data : "at_id=" + at_id + "&cl_id=" + cl_id + "&cd_id=" + cd_id,
			success : function(response) {
						
				document.getElementById('subList').innerHTML = "";
				document.getElementById("impType").style.display = "none"; 			
				document.getElementById("colNumTbl").style.display = "none";
				document.getElementById("examList").style.display = "none";
				
				$('#subList').html(response);				
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	} 
	
	
	
	
	
	function getFullYearCertificateTemplate(src){
		
		document.getElementById("termCertificate").className = "";
		document.getElementById("fullYearCertificate").className = "active";
		
		$("#certificate_rslt_content").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/examresult/getFullYearCertificateTemplate",				
			data : "",
			success : function(response) {
				$('#certificate_rslt_content').html(response);		
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function studentFullYearExamResultListPerClassDetail(src){
		
		document.getElementById("academic_year").style.borderColor = "#e5e5e5";
		document.getElementById("cl_id").style.borderColor = "#e5e5e5";
		document.getElementById("cd_id").style.borderColor = "#e5e5e5";
		
		var academic_year = $("#academic_year").val();
		var cl_id = $("#cl_id").val();
		var cd_id = $("#cd_id").val();
		
		var counter = 0;
		
		if(academic_year == "0"){
			
			document.getElementById("academic_year").style.borderColor = "#ff0000";
			counter++;
		}		
		if(cl_id == "0"){
			
			document.getElementById("cl_id").style.borderColor = "#ff0000";
			counter++;
		}
		if(cd_id == "0"){
			
			document.getElementById("cd_id").style.borderColor = "#ff0000";
			counter++;
		}		
		
		if(counter == 0){
			
			$("#student_result_content").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
			$.ajax({
				type : "GET",
				url : "/SMS/examresult/studentFullYearExamResultListPerClassDetail",				
				data : "studentRegistration.clcdRelation.cl_id=" + cl_id + "&studentRegistration.clcdRelation.cd_id=" + cd_id + "&fiscal_year=" + academic_year,
				success : function(response) {				
					$('#student_result_content').html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
	}
	