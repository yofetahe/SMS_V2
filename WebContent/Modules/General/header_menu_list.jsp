<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>
	
</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<select id="sex" class="form-control"
		onchange="systemBasicMenu(this.value, '${loader}')">
		<option value="-">- MENU LIST -</option>
		<option value="Student">Student</option>
		<option value="Teacher">Teacher</option>
		<option value="NonAcademic">Non-Academic</option>
		<option value="Attendance">Attendance</option>
		<option value="ExamResult">Exam Result</option>
		<option value="BehEvaluation">B. Evaluation</option>
		<option value="Payment">Payment</option>
		<option value="SubjectExam">Subject & Exam</option>
		<option value="Class">Class</option>
		<option value="Report">Report</option>
		<option value="ClassSchedule">Class Schedule</option>
	</select>
	
	<jsp:include page="/Modules/General/footer_resource.jsp"/>

</body>
</html>