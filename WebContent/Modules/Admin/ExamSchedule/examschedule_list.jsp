<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<div class="form-group form-inline titleBottomBorder">
		<button type="submit" class="btn btn-default" onclick="getNewExamScheduleRegistrationForm('${loader}')"> Add New Exam Schedule </button>				
	</div>
				
	<div id="examScheInfo">
			
		<div style="border-bottom-style: solid; border-bottom-width: thin; border-bottom-color: #3d6e9f; padding-left: 5px;">
			
			<table><tr><td>
				
				<div class="form-group form-inline">
					<label for="academic_year"> Academic Year </label>
					<select id="ac_year" class="form-control" style="width: 196px;">
						<c:forEach var="acyear" varStatus="stat" items="${acadmicYearList}">
							<option> <c:out value="${acyear}"/> </option>
						</c:forEach>
					</select>
				</div>
				
			</td><td style="padding-left: 10px;">
				
				<div class="form-group form-inline">
					<label for="academic_year"> Annual Terms </label>
					<select id="at_id" class="form-control" style="width: 196px;">
						<option value="-">-</option>
						<c:forEach var="sem_list" items="${annualTermList}">
							<option value="${sem_list.at_id}">${sem_list.at_name}</option>
						</c:forEach>
					</select>
				</div>
				
			</td></tr></table>
			
			<table cellpadding="0" cellspacing="0">
				<tr>
					<c:forEach var="class_list" varStatus="stat" items="${classTypeList}">
						<td width="50px" height="25px" align="center">
							<c:set var="clid" value="${class_list.cl_id}"/>
							<div class="header_btn_inactive" id="${clid}_cd" onclick="getExamScheduleByClassId('${loader}', '${class_list.cl_id}')">
								<c:out value="${class_list.class_name}"/>
							</div>
						</td>
						<td>&nbsp;</td>
					</c:forEach>
				</tr>
			</table>
		
		</div>
		
		<div id="examsch_filter" class="content_background" style="padding-top: 10px;">
	
		</div>
		
	</div>
	
	<jsp:include page="/Modules/General/footer_resource.jsp"/>

</body>
</html>