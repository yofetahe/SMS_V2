/**
 * 
 */
/*===================== ADMIN MENU =====================*/

	/*----- admin template -----*/
	
	function getSelectedAdminModuleTemplate(value, src){
		
		if(value == "AnnualTerm"){ getAnnualTermTemplate(src); }
		else if(value == "Attendance"){ getAttendanceTypeTemplate(src) }
		else if(value == "BehavioralEvaluation"){ getBehaviouralEvaluationTemplate(src) }
		else if(value == "CertificateDefaultComment"){ getCertificateDefaultCommentTemplate(src) }
		else if(value == "ClassAllotment"){ getClassAllotmentTemplate(src) }
		else if(value == "CoCurriculum"){ getCocurriculumActivity(src) }
		else if(value == "ExamGrading"){ getExamGradingTemplate(src) }
		else if(value == "ExamSchedule"){ getExamScheduleTemplate(src) }
		else if(value == "Holidays"){ getHolidayListTemplate(src) }
		else if(value == "HomeRoomTeacher"){ getHomeRoomTeachersTemplate(src) }
		else if(value == "GenerateIDCard"){ getIDCardGeneratorTemplate(src) }		
		else if(value == "Payment"){ getPaymentAmountTemplate(src) }
		else if(value == "SchoolEvents"){ getSchoolEventTemplate(src) }
		else if(value == "SchoolInformation"){ getSchoolInformationTemplate(src) }
		else if(value == "SpecialRegistration"){ getSpecialRegistrationTemplate(src) }
		else if(value == "StudentMaterial"){ getStudentMaterialTemplate(src) }
		else if(value == "SystemUsers"){ getUsersManagementTemplate(src) }
	}
	
	function getUsersManagementTemplate(src){
		
		$("#adminModuleContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/admin/getUsersManagementModule",				
			data : "",
			success : function(response) { 				
				$('#adminModuleContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function addUserRole(src){
		
		$("#adminModuleContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "useraction_rolelist.action",				
			data : "",
			success : function(response) { 
				$('#adminModuleContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getHomeRoomTeachersTemplate(src){
		
		$("#adminModuleContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/admin/getHomeRoomTeachersTemplate",				
			data : "",
			success : function(response) { 
				$('#adminModuleContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getAnnualTermTemplate(src){
		
		$("#adminModuleContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/admin/getAnnualTermTemplate",				
			data : "",
			success : function(response) { 
				$('#adminModuleContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getSchoolEventTemplate(src){
		
		$("#adminModuleContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/admin/getSchoolEventTemplate",				
			data : "",
			success : function(response) { 
				$('#adminModuleContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getHolidayListTemplate(src){
		
		$("#adminModuleContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/admin/getHolidayListTemplate",				
			data : "",
			success : function(response) { 
				$('#adminModuleContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getExamScheduleTemplate(src){
		
		$("#adminModuleContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/admin/getExamScheduleTemplate",				
			data : "",
			success : function(response) { 
				$('#adminModuleContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getCocurriculumActivity(src){
		
		$("#adminModuleContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/admin/getCocurriculumActivity",				
			data : "",
			success : function(response) { 
				$('#adminModuleContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getBehaviouralEvaluationTemplate(src){
		
		$("#adminModuleContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/admin/getBehaviouralEvaluationTemplate",				
			data : "",
			success : function(response) { 
				$('#adminModuleContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getStudentMaterialTemplate(src){
		
		$("#adminModuleContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/admin/getStudentMaterialTemplate",				
			data : "",
			success : function(response) { 
				$('#adminModuleContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	} 
	
	function getAttendanceTypeTemplate(src){
		
		$("#adminModuleContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/admin/getAttendanceTypeTemplate",				
			data : "",
			success : function(response) { 
				$('#adminModuleContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getPaymentAmountTemplate(src){
		
		$("#adminModuleContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/admin/getPaymentAmountTemplate",				
			data : "",
			success : function(response) { 
				$('#adminModuleContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getSchoolInformationTemplate(src){
		
		$("#adminModuleContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/admin/getSchoolInformationTemplate",				
			data : "",
			success : function(response) { 
				$('#adminModuleContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getCertificateDefaultCommentTemplate(src){
		
		$("#adminModuleContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/admin/getCertificateDefaultCommentTemplate",				
			data : "",
			success : function(response) { 
				$('#adminModuleContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getExamGradingTemplate(src){
		
		$("#adminModuleContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/admin/getExamGradingTemplate",				
			data : "",
			success : function(response) { 
				$('#adminModuleContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getSpecialRegistrationTemplate(src){
		
		$("#adminModuleContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/admin/getSpecialRegistrationTemplate",				
			data : "",
			success : function(response) { 
				$('#adminModuleContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getIDCardGeneratorTemplate(src){
		
		$("#adminModuleContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/admin/getIDCardGeneratorTemplate",				
			data : "",
			success : function(response) { 
				$('#adminModuleContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function getClassAllotmentTemplate(src){
		
		$("#adminModuleContent").html("<div style=\"width: 100%\" align=\"center\"><img align=\"center\" src=\""+ src +"\" width=\"100px\"/></div>");
		$.ajax({
			type : "GET",
			url : "/SMS/admin/getClassAllotmentTemplate",				
			data : "",
			success : function(response) { 
				$('#adminModuleContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}