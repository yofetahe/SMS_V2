<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>
	
</head>
<body id="sessionExpire" background="<c:url value='/Resources/images/new_bg_2.png'/>" style="margin: 0; background-repeat: repeat;">

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<div id="fullPageContent">
	
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<div class="menu_shadow">
						<jsp:include page="../General/header.jsp"/>
					</div>
				</td>
			</tr>
			<tr>
				<td align="center" style="padding-top: 3px;">
				
					<!-- body part -->
					<div style="width: 98%; min-height: 450px">
								
						<table width="100%" height="450px" cellpadding="0" cellspacing="0" border="0">
							<tr>
<!-- 								<td width="13%" valign="top" style="padding-top: 5px;"> -->
<!-- 									<div> -->
<%-- 										<jsp:include page="../General/menu.jsp"/> --%>
<!-- 									</div> -->
<!-- 								</td> -->
								<td valign="top" style="padding-top: 0px">
								
									<div class="menu_shadow" style="height: 50px; padding: 10px; margin-bottom: 10px;">
										
										<table><tr>
											<td> 
												
												<jsp:include page="../General/header_menu_list.jsp"/>
												 
											</td>
											<td style="padding-left: 10px;"> 
												 
												<select id="studTeacherInfo" class="form-control" onchange="studentTeacherInformtionReports(this.value, '${loader}')">
													<option value="-">-Student-Teacher Info. Reports-</option>
<!-- 													<option value="Attendance">Attendance</option> -->
													<option value="CheckInsertedResult">Check Inserted Result</option>
<!-- 													<option value="DropoutStudent">Drop out Student</option> -->
<!-- 													<option value="ExamProgram">Exam Program</option> -->
<!-- 													<option value="ExamSchedule">Exam Schedule</option> -->
													<option value="QuarterMarkList">Quarter Mark List</option>												
													<option value="StudentsRoster">Students Roster</option>
													<option value="StudentsRosterFullYear">Students Roster (Full Year)</option>
													<option value="StudentsTranscript">Students Transcript</option>
													<option value="TopNRankingStudents">Top N Ranking Students</option>
												</select>
												
											</td>
											<td style="padding-left: 10px;"> 
											 
												<select id="finance" class="form-control">
													<option value="-">-Finance Reports-</option>
													<option value="F">Payment Collections</option>
													<option value="M">Unpaid Student</option>													
												</select>
											</td>
											<td style="padding-left: 10px;"> 
											
												<select id="eduOffice" class="form-control">
													<option value="-">-Education Office Reports-</option>
													<option value="M">S. Mark Plan and Implementation</option>
													<option value="F">Student Mark Per Semester</option>
												</select>
											</td>
											<td style="padding-left: 10px;"> 
												<select id="general" class="form-control">
													<option value="-">-General Reports-</option>
													
												</select>
											</td>
											<td style="padding-left: 10px;"> 
												<select id="format" class="form-control">
													<option value="-">-Formats-</option>
													<option value="M">Attendance Format</option>													
													<option value="M">Student Leave Certificate</option>
													<option value="F">Student Mark List Format</option>
												</select>
											</td>
										</tr></table>
																				
									</div>
									
									<div id="report"> 
										
										
													
									</div>
									
								</td>
							</tr>
							<tr><td colspan="2">&nbsp;</td></tr>
						</table>					
					</div>
					<!-- body part -->
				</td>
			</tr>
			<tr>
				<td>
					<jsp:include page="../General/footer.jsp"/>
				</td>
			</tr>
		</table>
	</div>
	
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
</body>
</html>