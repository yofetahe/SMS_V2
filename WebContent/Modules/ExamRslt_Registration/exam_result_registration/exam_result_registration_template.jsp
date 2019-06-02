<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	<c:url value="/Resources/images/loader_2.gif" var="loader2"/>

	<div class="titleBottomBorder" style="padding-bottom: 2px;">
			
		<!-- filter form -->
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td>
				
					<div class="form-group form-inline">
						<label for="ac_year"> Academic Year </label>
						<input id="ac_year" type="text" readonly="readonly" value="${academic_year}" class="form-control" style="width: 160px;">
					</div>
					
				</td>
				<td style="padding-left: 15px;">
				
					<div class="form-group form-inline">						
						<form:select id="at_id" path="examResult.at_id" cssClass="form-control" onchange="refreshStudentMarkList('${loader2}')" style="width: 160px;">
							<form:option value="0">-Quarter-</form:option>
							<form:options itemLabel="at_name" itemValue="at_id" items="${annualTermList}"/>
						</form:select>
					</div>
					
				</td>
				<td style="padding-left: 10px;">
					
					<div id="classListContent">
					
						<div class="form-group form-inline">							
							<select id="cl_id" class="form-control" style="width: 160px;">
								<option>-Class-</option>
							</select>
						</div>
					
					</div>
					
				</td>
				<td style="padding-left: 10px;">
					
					<div id="gradeDetailListContent">
						
						<div class="form-group form-inline">							
							<select id="cd_id" class="form-control" style="width: 160px;">
								<option>-Class Detail-</option>
							</select>
						</div>
						
					</div>
					
				</td>
				<td style="padding-left: 10px;">
					
					<div id="subjectListContent">
						
						<div class="form-group form-inline">							
							<select id="sub_id" class="form-control" style="width: 160px;">
								<option>-Subject-</option>
							</select>
						</div>
						
					</div>
					
				</td>
				<td style="padding-left: 10px;">
					
					<div id="examListContent">
						
						<div class="form-group form-inline">							
							<select id="et_id" class="form-control" style="width: 160px;">
								<option>-Exam Type-</option>
							</select>
						</div>
						
					</div>
					
				</td>
			</tr>
		</table>
		<!-- filter form -->				
	</div>
				
	<div id="studentExamRegistrationForm">
	
	</div>
			
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
</body>
</html>