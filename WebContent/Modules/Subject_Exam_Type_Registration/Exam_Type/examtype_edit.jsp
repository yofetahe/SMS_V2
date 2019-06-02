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
	
	<div class="panel panel-default" style="width: 60%">
		<div class="panel-heading">
			<h4 class="panel-title" style="color: #1c75bc;">
				Exam Type Registration Form
			</h4>
		</div>
		<div class="panel-body" align="right" style="padding-right: 50px;">
					
			<div class="form-group form-inline">
				<label for="et_name"> Exam Type Title </label>					
				<input id="et_name" type="text" value="" class="form-control">
			</div>
			
			<div class="form-group form-inline">
				<label for="et_status"> Exam Type Status </label>					
				<form:select id="et_status" path="examType.et_status" class="form-control">
					<form:option value="A">Active</form:option>
					<form:option value="I">Inactive</form:option>
				</form:select>
			</div>
			
			<button type="submit" class="btn btn-default" onclick="updateExamType('${loader}', '${et_id}')"> UPDATE </button>
					
		</div>
	</div>
	
	
</body>
</html>