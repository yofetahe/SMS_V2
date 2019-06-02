<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>

	<div style="color: GREEN; padding: 5px; text-align: center; width: 40%;">
		<c:url var="info_image" value="/Resources/images/msg_information.jpeg"></c:url>
		<img alt="information" src="${info_image}" width="20px;">
		If the new record has similar EXAM TYPE, ACADEMIC YEAR, QUARTER, CLASS, and SUBJECT with the existing data,
		then the system will consider it as a duplicated record. 
		Therefore, other than inserting a new record, it is better to update the existing one.
	</div>
	
	<div class="panel panel-default" style="width: 40%">
		<div class="panel-heading">
			<h4 class="panel-title" style="color: #1c75bc;">
				Exam Schedule Registration Form
			</h4>
		</div>
		<div class="panel-body" align="right" style="padding-right: 60px;">
					
			<div class="form-group form-inline">
				<label for="academic_year"> Annual Terms </label>
				<select id="at_id" class="form-control" style="width: 196px;">
					<option value="-">-</option>
					<c:forEach var="sem_list" items="${annualTermList}">
						<option value="${sem_list.at_id}">${sem_list.at_name}</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="form-group form-inline">
				<label for="cl_id"> Class Type </label>
				<select id="cl_id" class="form-control" style="width: 196px;">
					<option value="0">-</option>
					<c:forEach var="class_list" items="${classTypeList}">
						<option value="${class_list.cl_id}">${class_list.class_name}</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="form-group form-inline" id="subList">
				<label for="sub_id"> Subject Type </label>					
				<select id="sub_id" class="form-control" style="width: 196px;">
					<option value="0">-</option>
				</select>
			</div>
			
			<div class="form-group form-inline" id="exTypeList">
				<label for="et_id"> Exam Type </label>					
				<select id="et_id" class="form-control" style="width: 196px;">
					<option value="0">-</option>
				</select>
			</div>
						
			<button type="submit" class="btn btn-default" onclick="saveExamSchedule('${loader}')"> SAVE </button>
					
		</div>
	</div>
	
	

</body>
</html>