<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	
	<c:url value="/Resources/images/loader.gif" var="loader"/>
	<c:url value="/Resources/images/loader_2.gif" var="loader2"/>
	
	<div class="titleBottomBorder" style="background-color: #fff; height: 45px; padding-top: 6px; padding-left: 5px;">
		<table cellpadding="0" cellspacing="0"><tr><td>
					
			<div class="form-group form-inline">
				<form:select id="academic_year" path="examResult.fiscal_year" cssClass="form-control" onchange="refreshStudentMarkList()" style="width: 160px;">
					<form:option value="0">-Academic Year-</form:option>
					<form:options items="${acadmicYearList}"/>
				</form:select>
			</div>
			
		</td>
		<td width="10px">&nbsp;</td>
		<td id="semList">
			
			<div class="form-group form-inline">
				<form:select id="at_id" path="examResult.at_id" cssClass="form-control" onchange="refreshStudentMarkList()" style="width: 160px;">
					<form:option value="0">-Quarter-</form:option>
					<form:options itemLabel="at_name" itemValue="at_id" items="${annualTermList}"/>
				</form:select>
			</div>
			
		</td>
		<td width="10px">&nbsp;</td>		
		<td id="clLIst">
			
			<div class="form-group form-inline">
				<form:select id="cl_id" path="examResult.studentRegistration.clcdRelation.cl_id" cssClass="form-control" onchange="getClassDetailListByClassId(this.value, '${loader2}')" style="width: 160px;">
					<form:option value="0">-Class-</form:option>
					<form:options itemLabel="class_name" itemValue="cl_id" items="${class_list}"/>
				</form:select>
			</div>
			
		</td>
		<td width="10px">&nbsp;</td>		
		<td>
			
			<div id="classDetailListCertificate">
				<div class="form-group form-inline">
					<select id="cd_id" class="form-control" style="width: 160px;">
						<option value="0">-Class Detail-</option>
					</select>
				</div>
			</div>
			
		</td>
		<td width="10px">&nbsp;</td>		
		<td>
			
			<div class="form-group form-inline">
				<button type="submit" class="btn btn-default" onclick="studentExamResultListPerClassDetail('${loader}')"> SEARCH </button>				
			</div>
			
		</td>
		</tr></table>		
	</div>
	
	<div id="student_result_content" style="padding-top: 5px;">
				
	</div>
						

</body>
</html>