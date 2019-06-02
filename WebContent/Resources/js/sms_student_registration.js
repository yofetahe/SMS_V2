/**
 * 
 */
/*======================= STUDENT REGISTRATION GENERAL =======================*/

/*----- STUDENT TEMPLATE JSP PAGE -----*/

	function getNewStudentRegistrationForm(src){
		
		document.getElementById("studInformationBtn").className = "btn btn-default";
		document.getElementById("newStudRegFormBtn").className = "btn btn-default active";
		
		$("#student_content").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/getNewStudentRegistrationForm",				
			data : "",
			success : function(response) {
				$('#student_content').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getStudentListPerSelectedAcadmicYear(ac_year, src){
		
		$("#studpergrade").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/getStudentListPerSelectedAcadmicYear",
			data : "academic_year=" + ac_year,
			success : function(response) {
				$('#studpergrade').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- STUDENT MALE FEMALE NUM PER CLASS PAGE -----*/
	
	function getAllStudentsListPerSelectedYear(src){
		
		var ac_year = $("#academicYear").val();
		
		$("#student_list").html("<div width=\"100%\" align=\"center\"> <img align=\"center\" src=\""+ src +"\" width=\"100px\"/> <br/> <c:url var=\"information\" value=\"/Resources/images/msg_information.jpeg\"/> <img src=\"${information}\" width=\"20px;\"/> <span style=\"color: GREEN\"> It is processing huge data, it might take longer time.</span> </div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/getAllStudentsListPerSelectedYear",				
			data : "academic_year=" + ac_year,
			success : function(response) {
				$('#student_list').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}

	function getInactiveStudentsListPerSelectedYear(src){
		
		var ac_year = $("#academicYear").val();
		
		$("#student_list").html("<div width=\"100%\" align=\"center\"> <img align=\"center\" src=\""+ src +"\" width=\"100px\"/> <br/> <c:url var=\"information\" value=\"/Resources/images/msg_information.jpeg\"/> <img src=\"${information}\" width=\"20px;\"/> <span style=\"color: GREEN\"> It is processing huge data, it might take longer time.</span> </div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/getAllInactiveStudentsListPerSelectedYear",				
			data : "academic_year=" + ac_year,
			success : function(response) {
				$('#student_list').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}

	function getNewCandidateStudentsList(src){
		
		$("#student_list").html("<div width=\"100%\" align=\"center\"> <img align=\"center\" src=\""+ src +"\" width=\"100px\"/> <br/> <c:url var=\"information\" value=\"/Resources/images/msg_information.jpeg\"/> <img src=\"${information}\" width=\"20px;\"/> <span style=\"color: GREEN\"> It is processing huge data, it might take longer time.</span> </div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/getAllNewCandidateStudentsList",				
			data : "",
			success : function(response) {
				$('#student_list').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	
	/*----- STUDENT MALE FEMALE NUM PER CLASS DETAIL PAGE -----*/
	
	function getStudentsListPerSelectedGrade(src, cl_id, class_name){
		
		var ac_year = $("#academicYear").val();
		
		$("#student_list_perdetial").html("<div width=\"100%\" align=\"center\"> <img align=\"center\" src=\""+ src +"\" width=\"100px\"/> <br/> <span style=\"color: GREEN\"> It is processing huge data, it might take longer time.</span> </div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/getStudentsListPerSelectedGrade",				
			data : "clcdRelation.cl_id=" + cl_id + "&academic_year=" + ac_year + "&clcdRelation.classType.class_name=" + class_name,
			success : function(response) {
				$('#student_list_perdetial').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- STUDENT LIST PAGE -----*/
	
	var prev_cdid = null;
	
	function getStudentListPerClassDetail(src, cl_id, cd_id, ac_year){
		
		$("#student_list_perdetial").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/getStudentListPerClassDetail",				
			data : "clcdRelation.cl_id=" + cl_id + "&clcdRelation.cd_id=" + cd_id + "&academic_year=" + ac_year,
			success : function(response){
				if(prev_cdid == null){
					document.getElementById(cd_id+"_cd").style.color = "#ffffff";
					document.getElementById(cd_id+"_cd").style.backgroundColor = "#3d6e9f";
				} else {
					document.getElementById(prev_cdid+"_cd").style.backgroundColor = '#e5e5e5';
					document.getElementById(prev_cdid+"_cd").style.color = '#3d6e9f';
					document.getElementById(cd_id+"_cd").style.backgroundColor = '#3d6e9f';
					document.getElementById(cd_id+"_cd").style.color = '#ffffff';
				}
				$('#student_list_perdetial').html(response);
				prev_cdid = cd_id;
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getStudentRegistrationForm(src, cl_id, class_name){
		
		var ac_year = $("#academicYear").val();
		
		$("#student_list").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/getStudentRegistrationForm",				
			data : "clcdRelation.classType.cl_id=" + cl_id + "&clcdRelation.classType.class_name=" + class_name + "&academic_year=" + ac_year,
			success : function(response) {
				$('#student_list').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- STUDENT LIST PER GRADE PAGE -----*/
	
	function getStudentDetailInformationForm(src, si_id, cl_id, cd_id){

		var ac_year = $("#academicYear").val();
		
		$("#student_list_pergrade").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/getStudentDetailInformationForm",				
			data : "si_id=" + si_id + "&clcdRelation.cl_id=" + cl_id + "&clcdRelation.cd_id=" + cd_id + "&academic_year=" + ac_year,
			success : function(response) {
				
				$('#student_list_pergrade').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getStudentContactInformationListPerGrade(src, cl_id, cd_id){
		
		var ac_year = $("#academicYear").val();
		
		$("#student_list_pergrade").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/getStudentContactInformationListPerGrade",				
			data : "clcdRelation.cl_id=" + cl_id + "&clcdRelation.cd_id=" + cd_id + "&academic_year=" + ac_year,
			success : function(response) {
				$('#student_list_pergrade').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function importStudentContactInfoFromExcelForm(cl_id, cd_id){
		
		$("#student_list_pergrade").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_importStudentContactInfoFromExcelForm.action",				
			data : "class_id=" + cl_id + "&cd_id=" + cd_id,
			success : function(response) {
				$('#student_list_pergrade').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- STUDENT LIST ALL PAGE -----*/
	
	var prev_clid = null;
	
	function getGradeDetailListPerSelectedClass(src, cl_id, clname){
		
		var ac_year = $("#academicYear").val();
		
		$("#student_list").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/getGradeDetailListPerSelectedClass",				
			data : "clcdRelation.classType.cl_id=" + cl_id + "&clcdRelation.classType.class_name=" + clname + "&academic_year=" + ac_year,
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
				$('#student_list').html(response);
				prev_clid = cl_id;
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- STUDENT EDIT PAGE -----*/
	
	function upload_photo(si_id, class_id){
		
		$("#student_additionalinfo").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_photoupload.action",				
			data : "si_id=" + si_id + "&class_id=" + class_id,
			success : function(response) {
				$('#student_additionalinfo').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- STUDENT DROPOUT FORM PAGE -----*/
	
	function studentDropOut(siid, fname, mname, gname, dropout_status){
		
		$("#dropout_div").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_dropout.action",				
			data : "si_id=" + siid + "&fname=" + fname + "&mname=" + mname + "&gname=" + gname + "&dropout_status=" + dropout_status,
			success : function(response) {
				$('#dropout_div').html(response);					
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- STUDENT DROPOUT CONFIRMATION PAGE -----*/
	
	function cancleDropOut(siid, fname, mname, gname, dropout_status){
		
		$("#dropout_div").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_cancledropout.action",				
			data : "si_id=" + siid + "&fname=" + fname + "&mname=" + mname + "&gname=" + gname + "&dropout_status=" + dropout_status,
			success : function(response) {
				$('#dropout_div').html(response);					
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function confirmDropOut(siid){
		
		$("#dropout_div").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_confirmdropout.action",				
			data : "si_id=" + siid ,
			success : function(response) {
				$('#dropout_div').html(response);					
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- STUDENT ADDITIONAL INFO SAVE MENU PAGE -----*/
	
	function student_info_save(){
		
		$("#student_additionalinfo_save").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_editform_save.action",				
			data : "",
			success : function(response) {
				document.getElementById("si").style.backgroundColor = '#e5e5e5';
				document.getElementById("ca").style.backgroundColor = '#ffffff';
				document.getElementById("ec").style.backgroundColor = '#ffffff';
				document.getElementById("gh").style.backgroundColor = '#ffffff';
				document.getElementById("r").style.backgroundColor = '#ffffff';
				document.getElementById("da").style.backgroundColor = '#ffffff';
				$('#student_additionalinfo_save').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function current_address_save(){
		$("#student_additionalinfo_save").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_currentaddress_save.action",				
			data : "",
			success : function(response) {
				document.getElementById("si").style.backgroundColor = '#ffffff';
				document.getElementById("ca").style.backgroundColor = '#e5e5e5';
				document.getElementById("ec").style.backgroundColor = '#ffffff';
				document.getElementById("gh").style.backgroundColor = '#ffffff';
				document.getElementById("r").style.backgroundColor = '#ffffff';
				document.getElementById("da").style.backgroundColor = '#ffffff';
				$('#student_additionalinfo_save').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function emergency_contact_save(){
		$("#student_additionalinfo_save").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_emergcontact_create.action",				
			data : "",
			success : function(response) {
				document.getElementById("si").style.backgroundColor = '#ffffff';
				document.getElementById("ca").style.backgroundColor = '#ffffff';
				document.getElementById("ec").style.backgroundColor = '#e5e5e5';
				document.getElementById("gh").style.backgroundColor = '#ffffff';
				document.getElementById("r").style.backgroundColor = '#ffffff';
				document.getElementById("da").style.backgroundColor = '#ffffff';
				$('#student_additionalinfo_save').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});	
	}
	
	function grade_history_save(){
		$("#student_additionalinfo_save").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_grdhistory_save.action",				
			data : "",
			success : function(response) {
				document.getElementById("si").style.backgroundColor = '#ffffff';
				document.getElementById("ca").style.backgroundColor = '#ffffff';
				document.getElementById("ec").style.backgroundColor = '#ffffff';
				document.getElementById("gh").style.backgroundColor = '#e5e5e5';
				document.getElementById("r").style.backgroundColor = '#ffffff';
				document.getElementById("da").style.backgroundColor = '#ffffff';
				$('#student_additionalinfo_save').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});	
	}
	
	function reward_save(){
		$("#student_additionalinfo_save").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_reward.action",				
			data : "",
			success : function(response) {
				document.getElementById("si").style.backgroundColor = '#ffffff';
				document.getElementById("ca").style.backgroundColor = '#ffffff';
				document.getElementById("ec").style.backgroundColor = '#ffffff';
				document.getElementById("gh").style.backgroundColor = '#ffffff';
				document.getElementById("r").style.backgroundColor = '#e5e5e5';
				document.getElementById("da").style.backgroundColor = '#ffffff';
				$('#student_additionalinfo_save').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});	
	}
	
	function disciplinary_action_save(){
		$("#student_additionalinfo_save").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_disaction_create.action",				
			data : "",
			success : function(response) {
				document.getElementById("si").style.backgroundColor = '#ffffff';
				document.getElementById("ca").style.backgroundColor = '#ffffff';
				document.getElementById("ec").style.backgroundColor = '#ffffff';
				document.getElementById("gh").style.backgroundColor = '#ffffff';
				document.getElementById("r").style.backgroundColor = '#ffffff';
				document.getElementById("da").style.backgroundColor = '#e5e5e5';
				$('#student_additionalinfo_save').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- STUDENT ADDITIONAL INFO MENU PAGE -----*/
	
	function get_student_profile_edit_form(src, si_id, cl_id, cd_id){
		
		var ac_year = $("#academicYear").val();
		
		$("#student_additionalinfo").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/getStudentProfileEditForm",
			data : "si_id=" + si_id + "&clcdRelation.cl_id=" + cl_id + "&clcdRelation.cd_id=" + cd_id + "&academic_year=" + ac_year,
			success : function(response) {
				document.getElementById("si").style.backgroundColor = '#e5e5e5';
				document.getElementById("ca").style.backgroundColor = '';
				document.getElementById("ec").style.backgroundColor = '';
				//document.getElementById("gh").style.backgroundColor = '';
				document.getElementById("r").style.backgroundColor = '';
				document.getElementById("da").style.backgroundColor = '';
				$('#student_additionalinfo').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getStudentCurrentAddress(src, si_id){
		
		$("#student_additionalinfo").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/getStudentCurrentAddress",				
			data : "si_id=" + si_id,
			success : function(response) {
				document.getElementById("si").style.backgroundColor = '';
				document.getElementById("ca").style.backgroundColor = '#e5e5e5';
				document.getElementById("ec").style.backgroundColor = '';
				//document.getElementById("gh").style.backgroundColor = '';
				document.getElementById("r").style.backgroundColor = '';
				document.getElementById("da").style.backgroundColor = '';
				$('#student_additionalinfo').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getStudentEmergencyContact(src, si_id){
		
		$("#student_additionalinfo").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/getStudentEmergencyContact",				
			data : "si_id=" + si_id,
			success : function(response) {
				document.getElementById("si").style.backgroundColor = '';
				document.getElementById("ca").style.backgroundColor = '';
				document.getElementById("ec").style.backgroundColor = '#e5e5e5';
				//document.getElementById("gh").style.backgroundColor = '';
				document.getElementById("r").style.backgroundColor = '';
				document.getElementById("da").style.backgroundColor = '';
				$('#student_additionalinfo').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function grade_history(siid){
		$("#student_additionalinfo").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_grdhistory.action",				
			data : "si_id=" + siid,
			success : function(response) {
				document.getElementById("si").style.backgroundColor = '';
				document.getElementById("ca").style.backgroundColor = '';
				document.getElementById("ec").style.backgroundColor = '';
				//document.getElementById("gh").style.backgroundColor = '#e5e5e5';
				document.getElementById("r").style.backgroundColor = '';
				document.getElementById("da").style.backgroundColor = '';
				$('#student_additionalinfo').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getStudentReward(src, si_id){
		
		$("#student_additionalinfo").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/getStudentReward",				
			data : "si_id=" + si_id,
			success : function(response) {
				document.getElementById("si").style.backgroundColor = '';
				document.getElementById("ca").style.backgroundColor = '';
				document.getElementById("ec").style.backgroundColor = '';
				//document.getElementById("gh").style.backgroundColor = '';
				document.getElementById("r").style.backgroundColor = '#e5e5e5';
				document.getElementById("da").style.backgroundColor = '';
				$('#student_additionalinfo').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getStudentDisciplinaryAction(src, si_id){
		
		$("#student_additionalinfo").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/getStudentDisciplinaryAction",				
			data : "si_id=" + si_id,
			success : function(response) {
				document.getElementById("si").style.backgroundColor = '';
				document.getElementById("ca").style.backgroundColor = '';
				document.getElementById("ec").style.backgroundColor = '';
				//document.getElementById("gh").style.backgroundColor = '';
				document.getElementById("r").style.backgroundColor = '';
				document.getElementById("da").style.backgroundColor = '#e5e5e5';
				$('#student_additionalinfo').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- IMPORT STUDENT CONTACT INFO FROM EXCEL PAGE -----*/
	
	function importStudContactInfoFromExcel(cl_id, cd_id){
		
		var file_path = $('#file_path').val();
		var sheetNum = $('#sheetNum').val();
		var columnNum = $('#columnNum').val();
		var rowNum = $('#rowNum').val();
		
		var relationship = $('#relationship').val();
		
		if(file_path == ""){
			
			document.getElementById("errMsg").innerHTML = "File path is required.";
		} else if(sheetNum == ""){
			
			document.getElementById("errMsg").innerHTML = "Sheet Number is required.";
		} else if(rowNum == ""){
			
			document.getElementById("errMsg").innerHTML = "Row Number is required.";
		} else if(columnNum == ""){
			
			document.getElementById("errMsg").innerHTML = "Column Number is required.";			
		} else if(relationship == 0){
			
			document.getElementById("errMsg").innerHTML = "Relationship is required.";
		} else {
			
			$("#student_list_pergrade").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "studentaction_importStudContactInfoFromExcel.action",				
				data : "examResultBean.file_path=" + file_path + "&examResultBean.column_num=" + columnNum + "&examResultBean.row_num=" + rowNum + "&examResultBean.sheet_num=" + sheetNum + "&class_id=" + cl_id + "&cd_id=" + cd_id + "&emergencyContactBean.relationship=" + relationship,
				success : function(response) {
					$('#student_list_pergrade').html(response);				
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});			
		}		
	}

	/*======================= STUDENT CLASS REGISTRATION =======================*/
	
	/*----- STUDENT LIST SELECTED PAGE -----*/
	
	var section = "";
	function removeSelectedStud(inde, stud_id, selclid){
		$("#selStudList").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_removestudentlist.action",				
			data : "inde=" + inde + "&selcl_id=" + selclid,
			success : function(response) {
				document.getElementById(stud_id + "_add").style.display = 'block';
				$('#selStudList').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function sectionSelected(sec){
		section = sec;
		//alert(section);
	}

	function registerStudent(selclid, rawcount){
		var acyear = $('#acYear').val();
		
		if(rawcount == 0){
			document.getElementById("errMsg").innerHTML = "There is no added student in the list";
		} else if(section == ''){
			document.getElementById("errMsg").innerHTML = "Section is mandatory field.";
		} else {
			$("#regSuccuss").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "studentaction_regstudentlist.action",				
				data : "sec_id=" + section + "&selcl_id=" + selclid + "&academic_year=" + acyear,
				success : function(response) {			
					$('#regSuccuss').html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
	}
	
	/*----- STUDENT LIST FOR REGISTRATION PAGE -----*/
	
	var selectedStudentList = new Array();
	
	///*** use to collect selected students for registration
	function selectStudentsForRegistration(stud_id, cl_id, fname, mname, gname){
		
		var counter = selectedStudentList.length;
		
		var checker = 0;
		
		for(var i = 0; i < counter; i++){
			
			if(selectedStudentList[i][0] == stud_id){
				
				selectedStudentList.splice(i, 1);
				checker++;
				break;
			}
		}
		
		if(checker == 0){
		
			selectedStudentList[counter] = new Array(stud_id, cl_id, fname, mname, gname);
		}
	}
	
	function addSelectedStudentsForRegistration(src){
		
		$("#selStudList").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "GET",
			url : "studentaction_selstudentlist.action",				
			data : "si_id=" + stud_id + "&stud_name=" + stud_name + "&selcl_id=" + cl_id,
			success : function(response) {
				document.getElementById(stud_id + "_add").style.display = 'none';
				$('#selStudList').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*======================= STUDENT REWARD =======================*/
	
	/*----- STUDENT REWARD LIST PAGE -----*/

	function getStudentRewardUpdateForm(src, sr_id, si_id){
		
		$("#rewardlist_container").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "POST",
			url : "/SMS/student/getStudentRewardUpdateForm",				
			data : "sr_id=" + sr_id + "&si_id=" + si_id,
			success : function(response) {
				$('#rewardlist_container').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function addNewStudentReward(src, si_id){
		
		$("#rewardlist_container").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/addNewStudentReward",				
			data : "si_id=" + si_id,
			success : function(response) {
				$('#rewardlist_container').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- STUDENT REWARD EDIT PAGE -----*/
	
	function updateReward(siid, srid){
		
		var rw_type = $('#rw_type').val();
		var rw_reason = $('#rw_reason').val();
		var rw_date = $('#rw_date').val();
		var rw_status = $('#rw_status').val();
		
		if(rw_type == ""){
			document.getElementById("errMsg").innerHTML = "Reward type is required.";
		} else if(rw_reason == ""){
			document.getElementById("errMsg").innerHTML = "Reward reason is required.";
		} else if(rw_date == ""){
			document.getElementById("errMsg").innerHTML = "Reward date is required.";
		} else {
		
			$("#reward_updateform").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "studentaction_reward_update.action",				
				data : "sr_type=" + rw_type + "&sr_reason=" + rw_reason + "&sr_date=" + rw_date + "&sr_status=" + rw_status + "&si_id=" + siid + "&sr_id=" + srid,
				success : function(response) {
					$('#reward_updateform').html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		
		}
	}

	/*----- STUDENT REWARD CREATE PAGE -----*/

	function saveReward(siid){
		var rw_type = $('#rw_type').val();
		var rw_reason = $('#rw_reason').val();
		var rw_date = $('#rw_date').val();
		
		if(rw_type == ""){
			document.getElementById("errMsg").innerHTML = "Reward type is required.";
		} else if(rw_reason == ""){
			document.getElementById("errMsg").innerHTML = "Reward reason is required.";
		} else if(rw_date == ""){
			document.getElementById("errMsg").innerHTML = "Reward date is required.";
		} else {
		
			$("#reward_saveform").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "studentaction_reward_save.action",				
				data : "sr_type=" + rw_type + "&sr_reason=" + rw_reason + "&sr_date=" + rw_date + "&si_id=" + siid,
				success : function(response) {
					$('#reward_saveform').html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		
		}
	}
	
	/*======================= STUDENT PERSONAL INFO =======================*/
	
	/*----- STUDENT PERSONAL INFO EDIT PAGE -----*/
	
	function getClassDetailListByClassId(class_id, src){
				
		$("#classDetailListDiv").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/getClassDetailListByClassId",				
			data : "clcdRelation.cl_id=" + class_id,
			success : function(response) {
				$('#classDetailListDiv').html(response);					
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function changeStudentToOtherClass(src, si_id, class_id, cd_id){
		
		var counter = 0;
		
		var new_clid = $('#newClassId').val();
				
		if(cd_id == new_cdid){
			
			document.getElementById("cdErrMsg").innerHTML = "The same class room is selected.";
			counter++;			
		} 
		if(new_clid == "0"){
			
			document.getElementById("newClassId").style.borderColor = "#ff0000";
			counter++;
		}
		if(counter == 0){
		
			$("#class_change").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
			$.ajax({
				type : "POST",
				url : "studentaction_changeclassroom.action",				
				data : "si_id=" + si_id + "&cd_id=" + new_cdid + "&cl_id=" + class_id,
				success : function(response) {
					$('#class_change').html(response);					
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
	}
	
	function changeClassDetail(src, si_id, class_id, cd_id){
		
		var counter = 0;
		
		var new_cdid = $('#newClassDetailId').val();
				
		if(cd_id == new_cdid){
			
			document.getElementById("cdErrMsg").innerHTML = "The same class room detail is selected.";
			counter++;			
		} 
		if(new_cdid == "0"){
			
			document.getElementById("newClassDetailId").style.borderColor = "#ff0000";
			counter++;
		}
		if(counter == 0){
		
			$("#class_detail_change").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
			$.ajax({
				type : "POST",
				url : "studentaction_changeclassroom.action",				
				data : "si_id=" + si_id + "&cd_id=" + new_cdid + "&cl_id=" + class_id,
				success : function(response) {
					$('#class_detail_change').html(response);					
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
	}
	
	var spNeedReq = "";
	
	function specialNeedRequired(value){
		
		spNeedReq = value;
	}
	
	function saveSpecialNeedRequirement(si_id){
		
		var snc_id = $('#snc_id').val();
		
		if(snc_id == ""){
			
			document.getElementById("errMsg").innerHTML = "Special need category is required.";
			
		} else {
			
			$("#specialNeed").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "studentaction_specialneedrequired.action",				
				data : "si_id=" + si_id + "&snc_id=" + snc_id,
				success : function(response) {
					$('#specialNeed').html(response);					
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
	}
	
	function updateSpecialNeedRequirement(si_id, ssnr_id){
		
		var snc_id = $('#snc_id').val();
		if(spNeedReq == ""){
			spNeedReq = 1;
		}
		
		if(spNeedReq == 1 && snc_id == ""){
			document.getElementById("errMsg").innerHTML = "Special need category is required.";
		} else {
			$("#specialNeed").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "studentaction_specialneedrequiredupdate.action",				
				data : "ssnr_id=" + ssnr_id + "&snc_id=" + snc_id + "&stud_special_need_status=" + spNeedReq,
				success : function(response) {
					$('#specialNeed').html(response);					
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
	}
	
	/*----- STUDENT PERSONAL INFO CREATE PAGE -----*/
	
	function getClassDetailForBrotherSisterSearch(cl_id, src){
		
		document.getElementById("searchName").value = "";
				
		$("#class_detail_list").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/getClassDetailForBrotherSisterSearch",				
			data : "clcdRelation.cl_id=" + cl_id,
			success : function(response) {
				$('#class_detail_list').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});		
	}
	
	function searchBrotherSisterByName(src){
	
		var cl_id = $('#cl_id').val();
		var cd_id = $('#cd_id').val();
		var searchName = $('#searchName').val();
		
		var counter = 0;
		
		if(cl_id == 0){
			
			document.getElementById("cl_id").style.borderColor = "#ff0000";
			counter++;
		}
		if(cd_id == 0){
			
			document.getElementById("cd_id").style.borderColor = "#ff0000";
			counter++;
		}
		if(searchName == ""){
			
			document.getElementById("searchName").style.borderColor = "#ff0000";
			counter++;
		}
		if(counter == 0){
			
			$("#searchResult").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
			$.ajax({
				type : "GET",
				url : "/SMS/student/searchBrotherSisterByName",				
				data : "clcdRelation.cl_id=" + cl_id + "&clcdRelation.cd_id=" + cd_id + "&studentInformation.fname=" + searchName,
				success : function(response) {
					
					$('#searchResult').html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});	
		}
	}

	var selectedStudent = new Array();
	
	var selectedStudIdList = "";
	
	function selectStudentAsBrotherSister(src, si_id, stud_name){
		
		var index = selectedStudent.length;
		
		var check = 0;
		
		for(var i = 0; i < selectedStudent.length; i++){
			
			if(selectedStudent[i][0] == si_id){
				
				check++;
			}
		}
		
		if(check == 0){
		
			selectedStudent[index] = new Array(si_id, stud_name);
			
			var selectedStudTblHeader = "<table><thead><tr><th style=\"line-height: 30px\"> Selected Brother/Sister Name </th></tr></thead><tbody>";
			
			var selectedStudTblBody = "";
			
			for(var i = 0; i < selectedStudent.length; i++){
				
				selectedStudTblBody = selectedStudTblBody + "<tr><td style=\"line-height: 30px\">" + selectedStudent[i][1] + " [ <span style=\"color: #3d6e9f; cursor: pointer;\" onclick=\"removeStudentFromBrotherSister('${loader}', '" + selectedStudent[i][0] + "')\"> Remove </span> ]</td></tr>";
				
			}
			
			var selectedStudTblFooter = "</tbody></table>";
			
			$("#selectedStudentList").html(selectedStudTblHeader + selectedStudTblBody + selectedStudTblFooter);
			
			selectedStudIdList = selectedStudIdList + " " + si_id;
			
			document.getElementById("selectedStudIdList").value = selectedStudIdList;
		}
	}
	
	function removeStudentFromBrotherSister(src, si_id){
		
		/// Selected Student ID List ///
		
		var selStudIdList = $('#selectedStudIdList').val();
		
		selectedStudIdList = "";
		
		var selectedStudIdListArray = selStudIdList.split(/(\s+)/);
		
		for(var i = 0; i < selectedStudIdListArray.length; i++){
			
			if(si_id == selectedStudIdListArray[i]){
				
				selectedStudIdListArray.splice(i, 1);
				
			} else {
				
				selectedStudIdList = selectedStudIdList + " " + selectedStudIdListArray[i];
			}
		}
		
		document.getElementById("selectedStudIdList").value = selectedStudIdList;
		
		/// END - Selected Student ID List ///
		
		
		/// Updating the selected student list ///
		
		for(var i = 0; i < selectedStudent.length; i++){
			
			if(si_id == selectedStudent[i][0]){
				
				selectedStudent.splice(i, 1);
				break;
			}
		}
		
		var selectedStudTblHeader = "<table><thead><tr><th style=\"line-height: 30px\"> Selected Brother/Sister Name </th></tr></thead><tbody>";
		
		var selectedStudTblBody = "";
		
		for(var i = 0; i < selectedStudent.length; i++){
			
			selectedStudTblBody = selectedStudTblBody + "<tr><td style=\"line-height: 30px\">" + selectedStudent[i][1] + " [ <span style=\"color: #3d6e9f; cursor: pointer;\" onclick=\"removeStudentFromBrotherSister('${loader}', '" + selectedStudent[i][0] + "')\"> Remove </span> ]</td></tr>"
		}
		
		var selectedStudTblFooter = "</tbody></table>";
		
		$("#selectedStudentList").html(selectedStudTblHeader + selectedStudTblBody + selectedStudTblFooter);
	}
	
	function saveStudentInfo(){
		
		var fname = $('#fname').val();
		var mname = $('#mname').val();
		var gname = $('#gname').val();
		var mother_name = $('#mothername').val();
		var sex = $('#sex').val();
		var dob = $('#dob').val();
		var pob = $('#pob').val();
		var nat = $('#nat').val();
		var idno = $('#idno').val();
		
		var pattern = /^[A-Za-z ]{3,300}$/;
		var fname_pattern = pattern.test(fname);
		var mname_pattern = pattern.test(mname);
		var gname_pattern = pattern.test(gname);
		var mothername_patter = pattern.test(mother_name);	
		
		var valDob = validateDOB(dob);
		
		if(fname == "" || mname == "" || gname == ""){
			document.getElementById("errMsg").innerHTML = "Full Name is required.";
			document.getElementById("fname").style.borderColor = "#ff0000";
		} else if(fname_pattern == false || mname_pattern == false || gname_pattern == false){
			document.getElementById("errMsg").innerHTML = "Name is invalid.";
		} else if(mothername_patter == false){
			document.getElementById("errMsg").innerHTML = "Mother name is invalid.";
		}else if(mother_name == ""){
			document.getElementById("errMsg").innerHTML = "Mother name is required.";
		} else if(sex == "0"){
			document.getElementById("errMsg").innerHTML = "Sex is required.";
		} else if(dob == ""){
			document.getElementById("errMsg").innerHTML = "Date of birth is required.";
		} else if(valDob == "invalideDate"){
			document.getElementById("errMsg").innerHTML = "Invalid Date of Birth";
		} 
		else if(valDob == "ageProblem"){
			document.getElementById("errMsg").innerHTML = "The minimum age is 3 years.";
		} 
		else if(pob == ""){
			document.getElementById("errMsg").innerHTML = "Place of birth is required.";
		} else if(nat == ""){
			document.getElementById("errMsg").innerHTML = "Nationality is required.";
		} else {
			$("#info_saveform").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "studentaction_save.action",				
				data : "fname=" + fname + "&mname=" + mname + "&gname=" + gname + "&mother_name=" + mother_name + "&sex=" + sex + "&dob=" + dob + "&pob=" + pob + "&id_no=" + idno + "&nationality=" + nat,
				success : function(response) {
					$('#studSaveForm').html(response);
					display_active_menu();
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
	}
	
	function validateDOB(dob){
		//dob format validator
		var year = 0;
		var month_dob = "";
		var month = 0;
		var day = 0;
		var j = 0;		
		for(var i = 0; i < 1; i++){
			j = dob.indexOf("-");
			year = dob.substring(0,j);			
			month_dob = dob.substring(j+1, dob.length);
		}
		
		for(var i = 0; i < 1; i++){
			j = month_dob.indexOf("-");
			month = month_dob.substring(0, j);
			day = month_dob.substring(j+1);
		}
		
		// Age validator
		var now = new Date();
		if(month < 5){
			age = now.getFullYear() - 7 - year;
		} else {
			age = now.getFullYear() - 8 - year;
		}
			
		if((year%4 == 0 && month == 13 && day > 6) || (year%4 != 0 && month == 13 && day > 5)){
			return "invalideDate";
		} else if(month > 13 || day > 30){
			return "invalideDate";
		} else if(age < 2) {
			return "ageProblem";
		} 
	}
	
	function display_active_menu(){
		
		$.ajax({
			type : "POST",
			url : "studentaction_activemenu.action",				
			data : "",
			success : function(response) {
				$('#menu_active').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function addStudPersonalInfoFromExcel(){
		
		$("#info_saveform").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_addstudpersonalinfofromexcel.action",				
			data : "",
			success : function(response) {
				$('#info_saveform').html(response);				
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- PERSONAL INFO EDIT FORM -----*/
	
	function updateStudentInfo(siid, stud_edit_status){
		
		var fname = $('#fname').val();
		var mname = $('#mname').val();
		var gname = $('#gname').val();
		var mother_name = $('#mother_name').val();
		var sex = $('#sex').val();
		var dob = $('#dob').val();
		var pob = $('#pob').val();
		var nat = $('#nat').val();
		var status = $('#status').val();
		var idno = $('#idno').val();

		var pattern = /^[A-Za-z/ ]{3,300}$/;
		var fname_pattern = pattern.test(fname);
		var mname_pattern = pattern.test(mname);
		var gname_pattern = pattern.test(gname);
		var mothername_patter = pattern.test(mother_name);
		
		if(fname.trim() == ""){
			document.getElementById("errMsg").innerHTML = "Full Name is required.";
			document.getElementById("fname").style.borderColor = "#ff0000";
		} else if(mname.trim() == ""){
			document.getElementById("errMsg").innerHTML = "Full Name is required.";
			document.getElementById("mname").style.borderColor = "#ff0000";
		} else if(gname.trim() == ""){
			document.getElementById("errMsg").innerHTML = "Full Name is required.";
			document.getElementById("gname").style.borderColor = "#ff0000";
		} else if(fname_pattern == false || mname_pattern == false || gname_pattern == false){
			document.getElementById("errMsg").innerHTML = "Name is invalide.";
		} else if(mothername_patter == false){
			document.getElementById("errMsg").innerHTML = "Mother name is invalide.";
		} else if(mother_name == ""){
			document.getElementById("errMsg").innerHTML = "Mother name is required.";
		} else if(sex == "0"){
			document.getElementById("errMsg").innerHTML = "Sex is required.";
		} else if(dob == ""){
			document.getElementById("errMsg").innerHTML = "Date of birth is required.";
		} else if(validateDOB(dob) == "invalideDate"){
			document.getElementById("errMsg").innerHTML = "Invalide Date of Birth";
		} else if(validateDOB(dob) == "ageProblem"){
			document.getElementById("errMsg").innerHTML = "The age is below the required level(3).";
		} else if(pob == ""){
			document.getElementById("errMsg").innerHTML = "Place of birth is required.";
		} else if(nat == ""){
			document.getElementById("errMsg").innerHTML = "Nationality is required.";
		} else {
			$("#info_updateform").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "studentaction_update.action",				
				data : "si_id=" + siid + "&fname=" + fname + "&mname=" + mname + "&gname=" + gname + "&mother_name=" + mother_name + "&sex=" + sex + "&dob=" + dob + "&pob=" + pob + "&si_status=" + status + "&id_no=" + idno + "&nationality=" + nat + "&stud_edit_status=" + stud_edit_status,
				success : function(response) {
					$('#info_updateform').html(response);					
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
	}
	
	function validateDOB(dob){
		//dob format validator
		var year = 0;
		var month_dob = "";
		var month = 0;
		var day = 0;
		var j = 0;		
		for(var i = 0; i < 1; i++){
			j = dob.indexOf("-");
			year = dob.substring(0,j);			
			month_dob = dob.substring(j+1, dob.length);
		}
		
		for(var i = 0; i < 1; i++){
			j = month_dob.indexOf("-");
			month = month_dob.substring(0, j);
			day = month_dob.substring(j+1);
		}
		
		// Age validator
		var now = new Date();
		if(month < 5){
			age = now.getFullYear() - 7 - year;
		} else {
			age = now.getFullYear() - 8 - year;
		}
		
		if((year%4 == 0 && month == 13 && day > 6) || (year%4 != 0 && month == 13 && day > 5)){
			return "invalideDate";
		} else if(month > 13 || day > 30){
			return "invalideDate";
		} else if(age < 2) {
			return "ageProblem";
		} 
	}
	
	/*----- IMPORT STUDENT PERSONAL INFO FROM EXCEL -----*/
	
	function importStudPersonalInfoFromExcel(){
		
		var file_path = $('#file_path').val();
		var sheetNum = $('#sheetNum').val();
		var columnNum = $('#columnNum').val();
		var rowNum = $('#rowNum').val();
		
		if(file_path == ""){
			
			document.getElementById("errMsg").innerHTML = "File path is required.";
		} else if(sheetNum == ""){
			
			document.getElementById("errMsg").innerHTML = "Sheet Number is required.";
		} else if(rowNum == ""){
			
			document.getElementById("errMsg").innerHTML = "Row Number is required.";
		} else if(columnNum == ""){
			
			document.getElementById("errMsg").innerHTML = "Column Number is required.";			
		} else {
			
			$("#info_saveform").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "studentaction_importStudPersonalInfoFromExcel.action",				
				data : "examResultBean.file_path=" + file_path + "&examResultBean.column_num=" + columnNum + "&examResultBean.row_num=" + rowNum + "&examResultBean.sheet_num=" + sheetNum,
				success : function(response) {
					$('#info_saveform').html(response);				
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});			
		}		
	}
		
	/*======================= INACTIVE STUDENT LIST =======================*/
	
	/*----- STUDENT LIST (INACTIVE) -----*/
	
	function student_edit_inactivestudent(id_no, si_id, fname, mname, gname, sex, dob, pob, nationality, sistatus, mothername, photo_path, photo_name){
		
		$("#can_student_list").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_candidateedit.action",				
			data : "id_no=" + id_no + "&si_id=" + si_id + "&fname=" + fname + "&mname=" + mname + "&gname=" + gname + "&sex=" + sex + "&dob=" + dob + "&pob=" + pob + "&nationality=" + nationality + "&si_status=" + sistatus + "&mother_name=" + mothername + "&photo_path=" + photo_path + "&photo_name=" + photo_name + "&stud_edit_status=candidate",
			success : function(response) {
				$('#can_student_list').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}

	function activateStudentsStatus(si_id){
		
		var ac_year = $('#academicYear').val();
			
		$("#student_list").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_activateStudentsStatus.action",				
			data : "ac_year=" + ac_year + "&si_id=" + si_id,
			success : function(response) {
				$('#student_list').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*======================= STUDENT GRADE HISTORY =======================*/
	
	/*----- STUDENT GRADE HISTORY LIST -----*/
	
	var classid = null;
	function grdAttended(clid, siid){
		$("#subject_list").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_grdhistory_sbjlist.action",				
			data : "clid=" + clid + "&si_id=" + siid,
			success : function(response) {
				if(classid == null){
					document.getElementById(clid).style.backgroundColor = '#3d6e9f';
					document.getElementById(clid).style.color = '#ffffff';
				} else {
					document.getElementById(classid).style.backgroundColor = 'silver';
					document.getElementById(clid).style.backgroundColor = '#3d6e9f';
					document.getElementById(clid).style.color = '#ffffff';
				}
				classid = clid;
				$('#subject_list').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*======================= STUDENT FAMILY INFO =======================*/
	
	
	
	/*======================= STUDENT EMERGENCY CONTACT =======================*/
	
	/*----- STUDENT EMERGENCY CONTACT LIST PAGE -----*/
	
	function getStudentEmergencyContactEditForm(src, si_id, sec_id){
		
		$("#emergcont_list").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/getStudentEmergencyContactEditForm.action",				
			data : "si_id=" + si_id + "&sec_id=" + sec_id,
			success : function(response) {
				$('#emergcont_list').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function addNewStudentEergencyContact(src, si_id){
		
		$("#emergcont_list").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/addNewStudentEergencyContact",				
			data : "si_id=" + si_id,
			success : function(response) {
				$('#emergcont_list').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- STUDENT EMERGENCY CONTACT EDIT -----*/
	
	function updateEmrgContact(secid, si_id){
		
		var contact_name = $('#contact_name').val();
		var relationship = $('#relationship').val();
		var mob_no = $('#mob_no').val();
		var offphone_no = $('#offphone_no').val();
		var homephone_no = $('#homephone_no').val();
		var status = $('#status').val();		

		var pattern = /^[A-Za-z/ ]{3,20}$/;
		var contact_name_pattern = pattern.test(contact_name);
		var pattern_rel = /^[A-Za-z]{3,20}$/;
		var relation_pattern = pattern_rel.test(relationship);
		
		if(contact_name == ""){
			document.getElementById("errMsg").innerHTML = "Contact Name is required.";
		} else if(contact_name_pattern == false){
			document.getElementById("errMsg").innerHTML = "Invalide Contact Name";
		} else if(relationship == ""){
			document.getElementById("errMsg").innerHTML = "Relationship is required.";
		} else if(relation_pattern == false){
			document.getElementById("errMsg").innerHTML = "Invalide relationship content.";
		} else if(mob_no == "" && offphone_no == "" && homephone_no == ""){
			document.getElementById("errMsg").innerHTML = "At leaste one phone number is required.";
		} else {
			
			$("#cadd_updateform").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "studentaction_emergcont_update.action",				
				data : "si_id=" + si_id + "&contact_name=" + contact_name + "&relationship=" + relationship + "&mob_no=" + mob_no + "&office_phone_no=" + offphone_no + "&home_phone_no=" + homephone_no + "&sec_status=" + status + "&sec_id=" + secid,
				success : function(response) {
					$('#cadd_updateform').html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
			
		}
	}

	/*----- STUDENT EMERGENCY CONTACT CREATE -----*/

	function saveEmergContact(siid){
		
		var contact_name = $('#contact_name').val();
		var relationship = $('#relationship').val();
		var mob_no = $('#mob_no').val();
		var offphone_no = $('#offphone_no').val();
		var homephone_no = $('#homephone_no').val();
		
		var pattern = /^[A-Za-z/ ]{3,20}$/;
		var contact_name_pattern = pattern.test(contact_name);
		var pattern_rel = /^[A-Za-z]{3,20}$/;
		var relation_pattern = pattern_rel.test(relationship);
		
		if(contact_name == ""){
			document.getElementById("errMsg").innerHTML = "Contact Name is required.";
		} else if(contact_name_pattern == false){
			document.getElementById("errMsg").innerHTML = "Invalide Contact Name";
		} else if(relationship == ""){
			document.getElementById("errMsg").innerHTML = "Relationship is required.";
		} else if(relation_pattern == false){
			document.getElementById("errMsg").innerHTML = "Invalide relationship content.";
		} else if(mob_no == "" && offphone_no == "" && homephone_no == ""){
			document.getElementById("errMsg").innerHTML = "At leaste one phone number is required.";
		} else {
		
			$("#cadd_saveform").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "studentaction_emergcontact_save.action",				
				data : "contact_name=" + contact_name + "&relationship=" + relationship + "&mob_no=" + mob_no + "&office_phone_no=" + offphone_no + "&home_phone_no=" + homephone_no + "&si_id=" + siid,
				success : function(response) {
					$('#cadd_saveform').html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
			
		}
	}
	
	/*======================= DROPOUT STUDENT LIST =======================*/
	
	/*----- STUDENT LIST (DROPOUT) -----*/
	
	function student_edit_to_dropout(id_no, si_id, fname, mname, gname, sex, dob, pob, nationality, sistatus, mothername, photo_path, photo_name){
		
		$("#can_student_list").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_candidateedit.action",				
			data : "id_no=" + id_no + "&si_id=" + si_id + "&fname=" + fname + "&mname=" + mname + "&gname=" + gname + "&sex=" + sex + "&dob=" + dob + "&pob=" + pob + "&nationality=" + nationality + "&si_status=" + sistatus + "&mother_name=" + mothername + "&photo_path=" + photo_path + "&photo_name=" + photo_name + "&stud_edit_status=candidate",
			success : function(response) {
				$('#can_student_list').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}	
	
	/*======================= STUDENT DISCIPLINARY ACTION =======================*/
	
	/*----- STUDENT DISCIPLINARY ACTION LIST PAGE -----*/
	
	function disaction_edit(sdaid, sdatype, sdareason, sdadate, sdastatus, siid){
		$("#disact_container").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_disaction_edit.action",				
			data : "sda_id=" + sdaid + "&sda_type=" + sdatype + "&sda_reason=" + sdareason + "&sda_date=" + sdadate + "&sda_status=" + sdastatus + "&si_id=" + siid,
			success : function(response) {
				$('#disact_container').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function addNewStudentDisciplinaryAction(src, si_id){
		
		$("#disact_container").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/student/addStudentDisciplinaryAction",				
			data : "si_id=" + si_id,
			success : function(response) {
				$('#disact_container').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	/*----- STUDENT DISCIPLINARY ACTION EDIT -----*/
	
	function updateDisAct(siid, da_id){
		
		var da_type = $('#da_type').val();
		var da_reason = $('#da_reason').val();
		var da_date = $('#da_date').val();
		var da_status = $('#da_status').val();
		
		if(da_type == ""){
			document.getElementById("errMsg").innerHTML = "Disciplinary action type is required.";
		} else if(da_reason == ""){
			document.getElementById("errMsg").innerHTML = "Disciplinary action reason is required.";
		} else if(da_date == ""){
			document.getElementById("errMsg").innerHTML = "Disciplinary action date is required.";
		} else {			
		
			$("#disact_editform").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "studentaction_disact_update.action",				
				data : "sda_id=" + da_id + "&sda_type=" + da_type + "&sda_reason=" + da_reason + "&sda_date=" + da_date + "&sda_status=" + da_status + "&si_id=" + siid,
				success : function(response) {
					$('#disact_editform').html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
			
		}
	}

	/*----- STUDENT DISCIPLINARY ACTION CREATE PAGE -----*/

	function saveDisAct(siid){
		var da_type = $('#da_type').val();
		var da_reason = $('#da_reason').val();
		var da_date = $('#da_date').val();
		
		if(da_type == ""){
			document.getElementById("errMsg").innerHTML = "Disciplinary action type is required.";
		} else if(da_reason == ""){
			document.getElementById("errMsg").innerHTML = "Disciplinary action reason is required.";
		} else if(da_date == ""){
			document.getElementById("errMsg").innerHTML = "Disciplinary action date is required.";
		} else {
		
			$("#disact_saveform").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "studentaction_disact_save.action",				
				data : "sda_type=" + da_type + "&sda_reason=" + da_reason + "&sda_date=" + da_date + "&si_id=" + siid,
				success : function(response) {
					$('#disact_saveform').html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		
		}
	}	
	
	/*======================= STUDENT CURRENT ADDRESS =======================*/
	
	/*----- STUDENT CURRENT ADDRESS EDIT PAGE -----*/

	function updateCurAddress(siid, sca_id){
		
		var sub_city = $('#sub_city').val();
		var kebele = $('#kebele').val();
		var house_no = $('#house_no').val();
		var house_phone = $('#house_phone').val();
		var email = $('#email').val();
		var email_2 = $('#email_2').val();
		
		var emailValidator = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		
		var pattern_phone = /^[0-9 ]{9,10}$/;
		var houseno_pattern = pattern_phone.test(house_phone);
		
		if(sub_city == ""){
			document.getElementById("errMsg").innerHTML = "Sub-city is required.";
		} else if(kebele == ""){
			document.getElementById("errMsg").innerHTML = "Kebele is required.";
		} else if(house_no == ""){
			document.getElementById("errMsg").innerHTML = "House number is required.";
		} else if(house_phone != "" && houseno_pattern == false){
			document.getElementById("errMsg").innerHTML = "Invalide phone number.";
		} else if(!emailValidator.test(email) || !emailValidator.test(email_2)){
			document.getElementById("errMsg").innerHTML = "Please insert a valide email address.";
		} else {
		
			$("#cadd_updateform").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "studentaction_currentaddress_update.action",				
				data : "sub_city=" + sub_city + "&kebele=" + kebele + "&house_no=" + house_no + "&home_phone=" + house_phone + "&si_id=" + siid + "&sca_id=" + sca_id + "&email=" + email + "&email_2=" + email_2,
				success : function(response) {
					$('#cadd_updateform').html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		
		}
	}
	
	/*----- STUDENT CURRENT ADDRESS CREATE PAGE -----*/
	
	function saveCurAddress(siid){
		
		var sub_city = $('#sub_city').val();
		var kebele = $('#kebele').val();
		var house_no = $('#house_no').val();
		var house_phone = $('#house_phone').val();
		var email = $('#email').val();
		var email_2 = $('#email_2').val();
		
		var emailValidator = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		
		var pattern_phone = /^[0-9 ]{9,10}$/;
		var housephno_pattern = pattern_phone.test(house_phone);
		
		if(sub_city == ""){
			document.getElementById("errMsg").innerHTML = "Sub-city is required.";
		} else if(kebele == ""){
			document.getElementById("errMsg").innerHTML = "Kebele is required.";
		} else if(house_no == ""){
			document.getElementById("errMsg").innerHTML = "House number is required.";
		} else if(house_phone != "" && housephno_pattern == false){
			document.getElementById("errMsg").innerHTML = "Invalide phone number.";
		} else if((email != "" && !emailValidator.test(email)) || (email_2 != "" && !emailValidator.test(email_2))){
			document.getElementById("errMsg").innerHTML = "Please insert a valide email address.";
		} else {
		
			$("#cadd_saveform").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
			$.ajax({
				type : "POST",
				url : "studentaction_curaddress_save.action",				
				data : "sub_city=" + sub_city + "&kebele=" + kebele + "&house_no=" + house_no + "&home_phone=" + house_phone + "&si_id=" + siid + "&email=" + email + "&email_2=" + email_2,
				success : function(response) {
					$('#cadd_saveform').html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		
		}
	}
	
	
	/*======================= STUDENT CANDIDATE LIST =======================*/
	
	/*----- STUDENT LIST (CANDIDATE) -----*/
	
	function student_edit_candidate(id_no, si_id, fname, mname, gname, sex, dob, pob, nationality, sistatus, mothername, photo_path, photo_name){
		
		$("#can_student_list").html("<div align=\"center\" width=\"100%\"><img align=\"center\" src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "studentaction_candidateedit.action",				
			data : "id_no=" + id_no + "&si_id=" + si_id + "&fname=" + fname + "&mname=" + mname + "&gname=" + gname + "&sex=" + sex + "&dob=" + dob + "&pob=" + pob + "&nationality=" + nationality + "&si_status=" + sistatus + "&mother_name=" + mothername + "&photo_path=" + photo_path + "&photo_name=" + photo_name + "&stud_edit_status=candidate",
			success : function(response) {
				$('#can_student_list').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	