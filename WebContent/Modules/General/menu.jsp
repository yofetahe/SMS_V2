<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>

<c:url value="/Resources/js/js_new/jquery-1.6.1.js" var="Jq161"/>
<script type="text/javascript" src="${Jq161}"></script>

<c:url value="/Resources/js/jquery-ui-1.8.18.custom.min.js" var="JqUIJS"/>
<script type="text/javascript" src="${JqUIJS}"></script>

<STYLE type="text/css">
 	#menu_content { 
 		font-family: Calibri, Arial;
 	}
	#accordion {
		list-style: none;
		padding: 0 0 0 0;
		width:auto;	
	}
	#accordion li{
		display: block;
		background-color: #E5E5E5;
 		/* font-weight: bold; */
 		font-style:italic;
 		font-size: 12px;
		margin: 1px;
		cursor: pointer;
		padding: 5 5 5 7px;
		list-style: circle;
		border-top-color: #fff;
		border-bottom-color: #fff;
		border-top-style: solid;
		border-bottom-style: solid;
		border-top-width: thin;
		border-bottom-width: thin;
		height: 60px;
		padding-top: 20px;
		padding-left: 5px;		
		color: #3d6e9f;
	}
	#accordion ul {
		list-style: none;
		padding: 0 0 0 0;
		display: none;
	}
	#accordion ul li{
		font-weight: normal;
		cursor: auto;
		background-color: #fff;
		padding: 0 0 0 7px;
		padding-top: 10px;
		padding-bottom: 5px;
	}
	#accordion a {
		text-decoration: none;
	}
	#accordion a:hover {
		text-decoration: underline;
	}
		
</STYLE>

</head>
<body id="menu_content" style="margin-top: 0px; background-color: #000;" >
	
	<div align="center" class="logo_background">
		<div style=" width: auto; vertical-align: middle; font-size: 12px; font-weight: bold;">
			<c:url value="/Resources/images/fidel_logo.png" var="smsLogo"/>
			<img alt="Logo" src="${smsLogo}" style="width: 46px;"><br/>
			<span style="color:  #3d6e9f; font-size: 24px; font-weight: bold;">FIDEL</span>
			<br/>SCHOOL MANAGEMENT <br/>SYSTEM
		</div>
	</div>
	<div align="center" style="border-top-color: #3d6e9f; border-top-style: solid; border-top-width: thin;">
		<c:url value="/Resources/images/down.png" var="downIcon"/>
		<img alt="" src="${downIcon}" width="40px" height="10px">
	</div>
	
	<c:set var="sysURLInitial" value="/SMS"/>
	
	<div style="margin-top: 0px;">
		<ul id="accordion">
			<li> RECORDS </li>
			<ul>		
				<li>
					<a href="${sysURLInitial}/student/getStudentTemplate" style="text-decoration: none; color: #000000">
						<div style="width: auto; height: auto;" onmouseover="this.style.color = '#8BD948'" onmouseout="this.style.color = '#000000'">
							<table><tr><td> <c:url value="/Resources/images/menu_icon/student.png" var="studentIcon"/> <img alt="" src="${studentIcon}" width="30px"> </td><td> Student </td></tr></table>							
						</div>
					</a>													
				</li>
				<li>			
					<a href="${sysURLInitial}/teacher/getTeacherTemplate" style="text-decoration: none; color: #000000">
						<div style="width: auto; height: auto;" onmouseover="this.style.color = '#8BD948'" onmouseout="this.style.color = '#000000'">								
							<table><tr><td> <c:url value="/Resources/images/menu_icon/teachers.png" var="teacherIcon"/> <img alt="" src="${teacherIcon}" width="30px"> </td><td > Teacher </td></tr></table>
						</div>
					</a>				
				</li>
				<li>			
					<a href="${sysURLInitial}/nonteacher/getNonteacherTemplate" style="text-decoration: none; color: #000000">
						<div style="width: auto; height: auto;" onmouseover="this.style.color = '#8BD948'" onmouseout="this.style.color = '#000000'">								
							<table><tr><td> <c:url value="/Resources/images/menu_icon/teachers.png" var="teacherIcon"/> <img alt="" src="${teacherIcon}" width="30px"> </td><td > Non-Academic </td></tr></table>
						</div>
					</a>				
				</li>				
			</ul>
			<li style="text-align: left;">TEACHERS ACTIVITY</li>
			<ul>
				<li>
					<a href="${sysURLInitial}/attendance/getAttendanceTemplate" style="text-decoration: none; color: #000000">
						<div style="width: auto; height: auto;" onmouseover="this.style.color = '#8BD948'" onmouseout="this.style.color = '#000000'">								 
							<table><tr><td> <c:url value="/Resources/images/menu_icon/daily_activity.png" var="dailyActIcon"/> <img alt="" src="${dailyActIcon}" width="30px"> </td><td> Attendance </td></tr></table>
						</div>
					</a>
				</li>
				<li>
					<a href="${sysURLInitial}/examresult/getExamTemplate" style="text-decoration: none; color: #000000">
						<div style="width: auto; height: auto;" onmouseover="this.style.color = '#8BD948'" onmouseout="this.style.color = '#000000'">								 
							<table><tr><td> <c:url value="/Resources/images/menu_icon/exam.png" var="examIcon"/> <img alt="" src="${examIcon}" width="30px"> </td><td> Exam Result </td></tr></table>
						</div>
					</a>
				</li>
				<li>
					<a href="${sysURLInitial}/behaviouraleval/getBeheviouralEvaluationTemplate" style="text-decoration: none; color: #000000">
						<div style="width: auto; height: auto; text-align: left;" onmouseover="this.style.color = '#8BD948'" onmouseout="this.style.color = '#000000'">								 
							<table><tr><td> <c:url value="/Resources/images/menu_icon/exam.png" var="examIcon"/> <img alt="" src="${examIcon}" width="30px"> </td><td> Behavioural Evaluation </td></tr></table>
						</div>
					</a>
				</li>
<!-- 				<li> -->
<%-- 					<a href="${sysURLInitial}/cocurriculum/getCocurriculumActivityTemplate" style="text-decoration: none; color: #000000"> --%>
<!-- 						<div style="width: auto; height: auto; text-align: left;" onmouseover="this.style.color = '#8BD948'" onmouseout="this.style.color = '#000000'">								  -->
<%-- 							<table><tr><td> <c:url value="/Resources/images/menu_icon/exam_pre.png" var="examPreIcon"/> <img alt="" src="${examPreIcon}" width="30px"> </td><td> Co-curriculum Activity </td></tr></table> --%>
<!-- 						</div> -->
<!-- 					</a> -->
<!-- 				</li> -->
			</ul>
			<li style="text-align: left;">FINANCE</li>
			<ul>
				<li>
					<a href="${sysURLInitial}/payment/getPaymentTemplate" style="text-decoration: none; color: #000000">
						<div style="width: auto; height: auto;" onmouseover="this.style.color = '#8BD948'" onmouseout="this.style.color = '#000000'">								 
							<table><tr><td> <c:url value="/Resources/images/menu_icon/payment.png" var="paymentIcon"/> <img alt="" src="${paymentIcon}" width="30px"> </td><td> Payment </td></tr></table>
						</div>
					</a>
				</li>
			</ul>
			<li style="text-align: left;">COMMUNICATION</li>
			<ul>
				<li>
					<a href="${sysURLInitial}/communication/getEmailCommunicationTemplate" style="text-decoration: none; color: #000000">
						<div style="width: auto; height: auto;" onmouseover="this.style.color = '#8BD948'" onmouseout="this.style.color = '#000000'">								 
							<table><tr><td> <c:url value="/Resources/images/menu_icon/email.png" var="emailIcon"/> <img alt="" src="${emailIcon}" width="30px"> </td><td> E-mail </td></tr></table>
						</div>
					</a>
				</li>
				<li>
					<a href="${sysURLInitial}/communication/getSMSCommunicationTemplate" style="text-decoration: none; color: #000000">
						<div style="width: auto; height: auto;" onmouseover="this.style.color = '#8BD948'" onmouseout="this.style.color = '#000000'">								 
							<table><tr><td> <c:url value="/Resources/images/menu_icon/sms.png" var="smsIcon"/> <img alt="" src="${smsIcon}" width="30px"> </td><td> Short Text Message </td></tr></table>
						</div>
					</a>
				</li>
			</ul>
			<li style="text-align: left;">REPORTS</li>
			<ul>
				<li>
					<a href="${sysURLInitial}/report/getReportTemplate" style="text-decoration: none; color: #000000">
						<div style="width: auto; height: auto;" onmouseover="this.style.color = '#8BD948'" onmouseout="this.style.color = '#000000'">								 
							<table><tr><td> <c:url value="/Resources/images/menu_icon/report.png" var="reportIcon"/> <img alt="" src="${reportIcon}" width="30px"> </td><td> Report </td></tr></table>
						</div>
					</a>
				</li>
			</ul>
			<li style="text-align: left;">BASIC INFORMATION</li>
			<ul>
				<li>
					<a href="${sysURLInitial}/subjectexamtype/getSubjectExamTypeTemplate" style="text-decoration: none; color: #000000">
						<div style="width: auto; height: auto;" onmouseover="this.style.color = '#8BD948'" onmouseout="this.style.color = '#000000'">								 
							<table><tr><td> <c:url value="/Resources/images/menu_icon/subject.png" var="subjectIcon"/> <img alt="" src="${subjectIcon}" width="30px"> </td><td> Subject & Exam </td></tr></table>
						</div>
					</a>
				</li>
				<li>
					<a href="${sysURLInitial}/classtype/getClassTypeTemplate" style="text-decoration: none; color: #000000">
						<div style="width: auto; height: auto;" onmouseover="this.style.color = '#8BD948'" onmouseout="this.style.color = '#000000'">								 
							<table><tr><td>  <c:url value="/Resources/images/menu_icon/classroom.png" var="classroomIcon"/> <img alt="" src="${classroomIcon}" width="30px"> </td><td> Class </td></tr></table>
						</div>
					</a>
				</li>
			</ul>
			<li style="text-align: left;">MANAGE</li>
			<ul>
				<li>
					<a href="${sysURLInitial}/classschedule/getClassScheduleTemplate" style="text-decoration: none; color: #000000">
						<div style="width: auto; height: auto;" onmouseover="this.style.color = '#8BD948'" onmouseout="this.style.color = '#000000'">								 
							<table><tr><td> <c:url value="/Resources/images/menu_icon/daily_activity.png" var="dailyActivityIcon"/> <img alt="" src="${dailyActivityIcon}" width="30px"> </td><td> Class Schedule </td></tr></table>
						</div>
					</a>
				</li>
				<li>
					<a href="${sysURLInitial}/admin/getAdminTemplate" style="text-decoration: none; color: #000000">
						<div style="width: auto; height: auto;" onmouseover="this.style.color = '#8BD948'" onmouseout="this.style.color = '#000000'">								 
							<table><tr><td> <c:url value="/Resources/images/menu_icon/admin.png" var="adminIcon"/> <img alt="" src="${adminIcon}" width="30px"> </td><td> Admin Data </td></tr></table>
						</div>
					</a>
				</li>
			</ul>
		</ul>			
	</div>
	
	<SCRIPT type="text/javascript">
	
	$("#accordion > li").click(function(){
	
		if(false == $(this).next().is(':visible')) {
			$('#accordion > ul').slideUp(300);
		}
		$(this).next().slideToggle(300);
	});
	
	//$('#accordion > ul:eq(0)').show();
	
	</SCRIPT>

</body>
</html>